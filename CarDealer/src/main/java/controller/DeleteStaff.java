/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.google.common.hash.Hashing;
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
@WebServlet(name = "DeleteStaff", urlPatterns = {"/DeleteStaff"})
public class DeleteStaff extends HttpServlet {

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
        
        System.out.println("im in");
        
        String next_page;    
        StaffDB repo = new StaffDB();
                
        int staffID = Integer.parseInt(request.getParameter("staffID"));
        System.out.println("this is the id of staff " + staffID);
        
        try
            {   
                System.out.println("im in try");
                
                Optional<Staff> opt = repo.getByID(staffID);
                Staff s = opt.orElse(new Staff());
                System.out.println("////////////////////// try delete");
                repo.delete(s);
                request.setAttribute("s", s); 
                next_page = "DisplayAllStaff";        
                System.out.println("deleted ////////////////////////////////////");                    
            } 
            catch(Exception ex)
            {
                 request.setAttribute("message", ex);
                 next_page = "error.jsp";
            }     
            System.out.println("this is the end");
        
            RequestDispatcher dispatcher = request.getRequestDispatcher(next_page);
            dispatcher.forward(request, response);
        
        
        
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
