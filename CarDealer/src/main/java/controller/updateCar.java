/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.helpers.CarValidationRules;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Car;
import model.CarDB;

/**
 *
 * @author Tomas
 */
@WebServlet(name = "updateCar", urlPatterns = {"/updateCar"})
public class updateCar extends HttpServlet {

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
        String message = "";
        String next_page = "";    
        CarDB repo = new CarDB();
        CarValidationRules cv = new CarValidationRules();
                
        int listingNumber = Integer.parseInt(request.getParameter("listingNumber"));
        String listPrice = request.getParameter("listPrice");
        String year = request.getParameter("year");
        String make = request.getParameter("make");
        String model = request.getParameter("model");
        String body = request.getParameter("body");
        String color = request.getParameter("colour");
        String odometer = request.getParameter("odometer");
        String fuel = request.getParameter("fuel");
        String tax = request.getParameter("tax");
        String description = request.getParameter("description");
        String note = request.getParameter("note");
        Boolean sold = Boolean.parseBoolean(request.getParameter("sold"));
        
        if(!cv.valid_price(listPrice)){
            message = "Only number in Price";
            next_page = "CarDetails.jsp";        
        }
        else if(!cv.valid_color(color)){
            message = "Color must be letter only.";
            next_page = "CarDetails.jsp";  
        }
        else if(!cv.valid_odometer(odometer)){
            message = "Odometer must be numbers only.";
            next_page = "CarDetails.jsp";  
        }
        else if (!cv.valid_tax(tax)){
            message = "Invalid tax!";
            next_page = "CarDetails.jsp";  
        }
        else if (!cv.valid_description(description)){
            message = "Description contains invalid characters!";
            next_page = "CarDetails.jsp";     
        }
        else if (!cv.valid_note(note)){
            message = "Note contains invalid characters!";
            next_page = "CarDetails.jsp";  
        }
        else
        {
            try
                {                 
                    Optional<Car> opt = repo.getByID(listingNumber);
                    Car c = opt.orElse(new Car());
                    c.setListPrice(Integer.parseInt(listPrice));
                    c.setYear(year);
                    c.setMake(make);
                    c.setModel(model);
                    c.setBody(body);
                    c.setColour(color);
                    c.setOdometer(Integer.parseInt(odometer));
                    c.setFuel(fuel);
                    c.setTax(Integer.parseInt(tax));
                    c.setDescription(description);
                    c.setNote(note);
                    c.setSold((short)(sold?1:0));

                    repo.update(c);
                    request.setAttribute("c", c); 
                    next_page = "DisplayAllCars";                
                } 
                catch(Exception ex)
                {
                     request.setAttribute("message", ex.getMessage());
                     next_page = "error.jsp";
                }              
        }
        if("CarDetails.jsp".equals(next_page))
            {
                try{
                    Optional<Car> opt = repo.getByID(listingNumber);
                    Car c = opt.orElse(new Car());
                    
                    c.setDescription(c.getDescription().trim().replace(",", "\n"));
                    c.setNote(c.getNote().trim().replace(",", "\n"));
                    
                    request.setAttribute("myCar", c);
                    next_page = "CarDetails.jsp";
                
                }catch(Exception ex)
                {
                    message = ex.getMessage();
                    next_page = "error.jsp";
                }     
                
            
            
            }
        
        
        
            request.setAttribute("message",message);
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
