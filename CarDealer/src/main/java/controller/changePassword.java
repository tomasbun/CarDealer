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
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Staff;
import model.StaffDB;
import org.apache.shiro.SecurityUtils;

/**
 *
 * @author Tomas
 */
@WebServlet(name = "changePassword", urlPatterns = {"/changePassword"})
public class changePassword extends HttpServlet {

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
        String message ="";
        StaffDB repo = new StaffDB();
        StaffValidationRules vs = new StaffValidationRules();
            
        String oldPassword = request.getParameter("oldPassword");
        String newPassword = request.getParameter("newPassword");
        String newPassword2 = request.getParameter("newPassword2");
        String email = request.getParameter("email");
        String hashedPass = Hashing.sha256().hashString(oldPassword, StandardCharsets.UTF_8).toString();
        
            System.out.println(oldPassword);
            System.out.println(newPassword);
            System.out.println(newPassword2);
            System.out.println(email);
        
        if(!newPassword2.equals(newPassword))    
        {
            System.out.println("///////////// new pass does not macth ///////////");
            message = "Same new password must be entered twice!";
            next_page = "changePassword.jsp";
        }
        else if(!vs.valid_password(newPassword)){
            message = "New password is not valid. Must be only leters and numbers at least 5 long";
            next_page = "changePassword.jsp";
        }       
        else
        {
            try{
                Staff s = StaffDB.getStaffByEmail(email);
                if(s != null && (s.getPassword() == null ? hashedPass == null : s.getPassword().equals(hashedPass)) ){
                
                    s.setPassword(Hashing.sha256().hashString(newPassword, StandardCharsets.UTF_8).toString());
                    repo.update(s);
                    org.apache.shiro.subject.Subject currentUser = SecurityUtils.getSubject();
                    currentUser.logout();
                    System.out.println("///////// pass updated //////////");
                    message = "Password updated please log in";
                    next_page = "login.jsp";
                }
                else{
                    System.out.println("///////// old pass incorect //////////");
                    message = "Old password is incorect!";
                    next_page = "changePassword.jsp";
                }
                    
            }
            catch(Exception ex)
            {
                 request.setAttribute("message", ex);
                 next_page = "error.jsp";
            }
                    
            
        
        
        }
        request.setAttribute("message", message);
        RequestDispatcher rd = request.getRequestDispatcher(next_page);
        rd.forward(request, response);    
       
            
        ////////////////////////////////////////////////////////////////////////
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
