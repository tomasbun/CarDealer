/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
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
@WebServlet(name = "RefineSearch", urlPatterns = {"/RefineSearch"})
public class RefineSearch extends HttpServlet {

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
        String nextPage;
        CarDB repo = new CarDB();
        Boolean showAll = false;
        List<Car> templist = new ArrayList<>();
        List<Car> finallist  = new ArrayList<>();
        //======================================================================
       try {
            
            String make = request.getParameter("make");
            String body = request.getParameter("body");
            String year = request.getParameter("year");
            String range = request.getParameter("priceRange");        
            
            if(!make.contains("Any")){
                templist = repo.getCarsByMake(make);
                finallist = findUnion(finallist, templist);
            }
               
            if(!body.contains("Any")){
                templist = repo.getCarsByBody(body);
                  finallist = findUnion(finallist, templist);
            }
                
            
            if(!year.contains("Any")){
                templist = repo.getCarsByYear(year);
                finallist = findUnion(finallist,templist);
            }
                          
            if(!range.contains("Any")){
                if(range.contains("Over 40000"))
                    templist = repo.getCarsByPriceRange(40000, 10000000);
                else{
                    String[] prange = range.split(" - ");
                    int min = Integer.parseInt(prange[0]);
                    int max = Integer.parseInt(prange[1]);
                    templist = repo.getCarsByPriceRange(min, max);
                    
                }
                finallist = findUnion(finallist,templist);
            }

            if(make.contains("Any") && body.contains("Any") && year.contains("Any") && range.contains("Any") ){
                finallist = repo.getall();
            }
                       
            nextPage = "/ShowAllCars.jsp";
            request.setAttribute("list", finallist);
            
        }
        catch(NumberFormatException ex){
            
            log("Exeption: " + ex);
            request.setAttribute("message", ex);
            nextPage = "error.jsp";
        }
         
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
    
    public List<Car> findUnion( List<Car> mylist1, List<Car> mylist2){
        if(mylist1.isEmpty())
            mylist1 = mylist2;   
        else{
            Set<Car> myset = Stream.concat(mylist1.stream(), mylist2.stream())
            .filter(mylist1::contains)
            .filter(mylist2::contains)
            .collect(Collectors.toSet());
            mylist1 = new ArrayList<>();
            mylist1.addAll(myset);
        }                
    return mylist1;
    }
}
