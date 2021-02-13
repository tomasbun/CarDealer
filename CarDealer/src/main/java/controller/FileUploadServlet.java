/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.imageio.ImageIO;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author Tomas
 */
@WebServlet(name = "FileUploadServlet", urlPatterns = {"/FileUploadServlet"})
public class FileUploadServlet extends HttpServlet {

    private String message = "";
    private String next_page = "";
    private static final long serialVersionUID = 1L;
 
    // upload settings
    private static final int MEMORY_THRESHOLD   = 1024 * 1024 * 3;  // 3MB
//    private static final int MAX_FILE_SIZE      = 1024 * 1024 * 40; // 40MB
//    private static final int MAX_REQUEST_SIZE   = 1024 * 1024 * 50; // 50MB
// 
    /**
     * Upon receiving file upload submission, parses the request to read
     * upload data and saves the file on disk.
     */
    
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
      //////////////////////////////////////////////////////////////////////////

        // configures upload settings
        DiskFileItemFactory factory = new DiskFileItemFactory();
        // sets memory threshold - beyond which files are stored in disk
        factory.setSizeThreshold(MEMORY_THRESHOLD);
        
        // sets temporary location to store files
        factory.setRepository(new File(System.getProperty("java.io.tmpdir")));
        ServletFileUpload upload = new ServletFileUpload(factory);
         
//        // sets maximum size of upload file
//        upload.setFileSizeMax(MAX_FILE_SIZE);
//         
//        // sets maximum size of request (include file + form data)
//        upload.setSizeMax(MAX_REQUEST_SIZE);
// 
        // construct directory path to store upload file                
        String uploadPath = "src\\main\\webapp\\images\\Sales People\\";
        uploadPath = getServletContext().getRealPath(File.pathSeparator)
               .split("target")[0].concat(uploadPath);
        
        // create dir if it does not exist
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists())
            uploadDir.mkdir();
        
        try {
            // parse request
            @SuppressWarnings("unchecked")
            List<FileItem> formItems = upload.parseRequest(request);
 
            if (formItems != null && formItems.size() > 0) {
                // iterate over form's fields
                for (FileItem item : formItems) {
                    // process only fields that are not form fields
                    if (!item.isFormField()) {
                        if(!item.getName().contains("jpg")&& !item.getName().contains("png") ){
                            message = "Only jpg or png files are allowed!";
                            next_page = "upload.jsp";
                        }
                        else{
                            String currentUser = "";
                            Cookie[] cookies = request.getCookies();
                            for(Cookie c: cookies){
                                if("currentStaff".equals(c.getName())){ 
                                    currentUser = c.getValue().replace("-", " ");
                                }     
                            } 
                       
                            String fileName = currentUser + ".jpg";
                            String filePath = uploadPath + File.separator + fileName;

                            File storeFile = new File(filePath);                       
                            
                                BufferedImage bi = ImageIO.read(item.getInputStream()); 
                                Image img = bi.getScaledInstance(60,60,Image.SCALE_SMOOTH);
                                BufferedImage scaled = new BufferedImage(60,60,BufferedImage.TYPE_INT_RGB);       
                                Graphics2D g = scaled.createGraphics();
                                g.drawImage(img,0,0,null); 
                                if(g != null) g.dispose();
                                ImageIO.write(scaled,"jpg", storeFile);

                            message = "Image uploaded";
                            next_page = "upload.jsp";
                        
                        }
                    }
                }
            }
        } catch (Exception ex) {
            message = ex.getMessage();
            next_page = "error.jsp";
        }
        
        response.setHeader("Cache-Control","no-cache"); //Forces caches to obtain a new copy of the page from the origin server
        response.setHeader("Cache-Control","no-store"); //Directs caches not to store the page under any circumstance
        response.setDateHeader("Expires", 0); //Causes the proxy cache to see the page as "stale"
        response.setHeader("Pragma","no-cache"); //HTTP 1.0 backward compatibility
        
        request.setAttribute("message", message);
        RequestDispatcher dispatcher = request.getRequestDispatcher(next_page);
        dispatcher.forward(request, response);
      
      //////////////////////////////////////////////////////////////////////////
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
