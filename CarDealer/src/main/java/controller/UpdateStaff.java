/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.google.common.hash.Hashing;
import controller.helpers.StaffValidationRules;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.Optional;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Staff;
import model.StaffDB;

/**
 *
 * @author Tomas
 */
@WebServlet(name = "UpdateStaff", urlPatterns = {"/UpdateStaff"})
public class UpdateStaff extends HttpServlet {

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
        ////////////////////////////////////////////////////////////////////////
        String next_page = "";
        String message = "";
        StaffDB repo = new StaffDB();
        StaffValidationRules vs = new StaffValidationRules();
        
        int staffID = Integer.parseInt(request.getParameter("staffID").trim());
        String fullName = request.getParameter("fullName").trim();
        String email = request.getParameter("email").trim();
        String phone = request.getParameter("phone").trim();
        String fax = request.getParameter("fax").trim();
        Boolean admin = Boolean.parseBoolean(request.getParameter("admin"));
        String checkbox = request.getParameter("resetPassword");
        if(!vs.valid_fullname(fullName)){
            message = "Fullname and lastname has to be only letters and separated.";
            next_page = "StaffDetails.jsp";        
        }
//        else if(vs.valid_email(email)){
//            message = "Invalid email address";
//            next_page = "StaffDetails.jsp";  
//        
//        }
        else if (!vs.valid_phoneFax(phone)){
            message = "Invalid phone number.";
            next_page = "StaffDetails.jsp";  
        
        }
        else if (!vs.valid_phoneFax(fax)){
            message = "Invalid fax number";
            next_page = "StaffDetails.jsp";  
            
        }
        else{
            
            try
                {                 
                    Optional<Staff> opt = repo.getByID(staffID);
                    Staff s = opt.orElse(new Staff());
                    s.setFullName(fullName);
                    s.setEmail(email);
                    s.setPhone(phone);
                    s.setFax(fax);
                    s.setAdmin((short)(admin?1:0)); 

                    if("on".equals(checkbox)){

                        String newPass = "password";
                        String sha256hex = Hashing.sha256()
                            .hashString(newPass, StandardCharsets.UTF_8)
                            .toString();       

                    s.setPassword(sha256hex);
                    }              

                    repo.update(s);
                    request.setAttribute("s", s); 
                    next_page = "DisplayAllStaff";        


                } 
                catch(Exception ex)
                {
                    message = ex.getMessage();
                    next_page = "error.jsp";
                }              
            }
            
            if("StaffDetails.jsp".equals(next_page))
            {
                try{
                    Optional<Staff> opt = repo.getByID(staffID);
                    Staff s = opt.orElse(new Staff());
                
                    request.setAttribute("s", s); 
                    next_page = "StaffDetails.jsp";
                
                }catch(Exception ex)
                {
                    message = ex.getMessage();
                    next_page = "error.jsp";
                }     
                
            
            
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
