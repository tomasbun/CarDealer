/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Car;
import model.CarDB;

/**
 *
 * @author Tomas
 */
@WebServlet(name = "CarDetails", urlPatterns = {"/CarDetails"})
public class CarDetails extends HttpServlet {

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
        //======================================================================
        
            String next_page;    
            CarDB repo = new CarDB();
            try
            {
                int listingNumber = Integer.parseInt(request.getParameter("listingNumber"));               
                Optional<Car> opt = repo.getByID(listingNumber);
                Car myCar = opt.orElse(new Car());
                myCar.setDescription(myCar.getDescription().trim());
                myCar.setNote(myCar.getNote().trim());
                request.setAttribute("myCar", myCar);
                
                Cookie[] cookies = request.getCookies();         
            

                for(Cookie cookie : cookies){
                    if("wishlist".equals(cookie.getName())){                    
                        String myCookie = cookie.getValue();
                        if(myCookie.contains(Integer.toString(listingNumber)))
                            request.setAttribute("favorite", true);
                        else
                            request.setAttribute("favorite", false);
                        
                    }
                }         
                     
                
                
                
                next_page = "/CarDetails.jsp";

                           
            } 
            catch(Exception ex)
            {
                 request.setAttribute("Message", ex);
                 next_page = "error.jsp";
            }
            
            RequestDispatcher dispatcher = request.getRequestDispatcher(next_page);
            dispatcher.forward(request, response);
        
        //======================================================================
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
