/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Car;
import model.CarDB;

/**
 *
 * @author Tomas
 */
@WebServlet(name = "WishlistRemove", urlPatterns = {"/WishlistRemove"})
public class WishlistRemove extends HttpServlet {

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
        
        String nextPage;
        CarDB repo = new CarDB();
        String[] favoriteCars = new String[0];
        List<Car> list = new ArrayList<>();

        ////////////////////////////////////////////////////////////////////////
        Cookie[] cookies = request.getCookies();         
            
            for(Cookie cookie : cookies){
                if("wishlist".equals(cookie.getName())){                    
                    if (request.getParameter("listingNumber") != null)
                    {
                        int listingNumber = Integer.parseInt(request.getParameter("listingNumber"));
                        cookie.setValue(cookie.getValue().replace("/"+listingNumber, ""));
                        cookie.setPath("/");
                        response.addCookie(cookie);
                    }
                    
                    favoriteCars = cookie.getValue().split("/"); 
                    
                }         
            }     

            for(String s: favoriteCars){
                try{
                    int lNumber = Integer.parseInt(s);               
                    Optional<Car> opt = repo.getByID(lNumber);
                    Car myCar = opt.orElse(new Car());
                    list.add(myCar);
                    
                }
                catch(Exception ex){
                    request.setAttribute("Message", ex);
                    nextPage = "error.jsp";
                }
            
            }

        
            nextPage = "Wishlist.jsp";             
            request.setAttribute("list", list); 

            RequestDispatcher dispatcher = request.getRequestDispatcher(nextPage);
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
