/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.google.common.hash.Hashing;
import controller.helpers.StaffValidationRules;
//import controller.helperClasses.StaffValidationRules;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Optional;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Staff;
import model.StaffDB;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.imgscalr.Scalr;
import org.imgscalr.Scalr.Method;

/**
 *
 * @author Tomas
 */
@WebServlet(name = "CreateStaff", urlPatterns = {"/CreateStaff"})
public class CreateStaff extends HttpServlet {
    
    
    
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
               
        StaffValidationRules vs = new StaffValidationRules();
        String next_page = "";
        String message = "";
        StaffDB repo = new StaffDB();
        String newPasword = "password";
             
        String fullName = request.getParameter("fullName").trim();
        String email = request.getParameter("email").trim();
        String phone = request.getParameter("phone").trim();
        String fax = request.getParameter("fax").trim();
        Boolean admin = Boolean.parseBoolean(request.getParameter("admin"));

        if(!vs.valid_fullname(fullName)){
            message = "Fullname and lastname has to be only letters and separated.";
            next_page = "CreateStaff.jsp";        
        }
        else if(!vs.valid_email(email)){
            message = "Invalid email address";
            next_page = "CreateStaff.jsp";  
        }
        else if (!vs.valid_phoneFax(phone)){
            message = "Invalid phone number";
            next_page = "CreateStaff.jsp";  
        
        }
        else if (!vs.valid_phoneFax(fax)){
            message = "Invalid fax number";
            next_page = "CreateStaff.jsp";  
            
        }
        else{
            try{                 
                
                List<Staff> list = repo.getall();                
                Staff s = new Staff();
                s.setStaffID(list.size()+1);
                s.setFullName(fullName);
                s.setEmail(email);
                s.setPhone(phone);
                s.setFax(fax);
                s.setPassword(Hashing.sha256().hashString(newPasword, StandardCharsets.UTF_8).toString());
                s.setAdmin((short)(admin?1:0));
                repo.add(s);
                next_page = "DisplayAllStaff";              
            } 
            catch(Exception ex)
            {
                message = ex.getMessage();
                next_page = "error.jsp";
            }              
           }
        
        if("CreateStaff.jsp".equals(next_page))
        {
            request.setAttribute("fullName", fullName);
            request.setAttribute("email", email);
            request.setAttribute("phone", phone);
            request.setAttribute("fax", fax);
            request.setAttribute("admin", admin);
        }
        
        
        request.setAttribute("message",message);
        RequestDispatcher dispatcher = request.getRequestDispatcher(next_page);
        dispatcher.forward(request, response);            
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
