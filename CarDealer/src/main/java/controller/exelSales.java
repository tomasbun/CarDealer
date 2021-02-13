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
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Sales;
import model.SalesDB;

/**
 *
 * @author Tomas
 */
@WebServlet(name = "exelSales", urlPatterns = {"/exelSales"})
public class exelSales extends HttpServlet {

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
    ////////////////////////////////////////////////////////////////////////////
    
    
    SalesDB repo = new SalesDB();   
    
    List<Sales> list = repo.getall();
    String report = "The Sales table\n\n" +
            "Sales ID\t" +
            "Listing number\t" +
            "Customer\t" +
            "Sales agent\t" +
            "Trade in\t" +
            "Tradein value\t" +
            "Amount Paid\n";
            
    
    for(Sales s:list){
        report += s.getSalesID()+ "\t"+
                s.getListingNumber().getListingNumber() +"\t"+
                s.getCustomerID().getFullname()+ "\t" +
                s.getStaffID().getFullName() + "\t" +
                s.getTradein() + "\t" +
                s.getTradeinValue() + "\t" +
                s.getAmountPaid() + "\n";            
    }
    
    response.setContentType("application/vnd.ms-excel");
    response.setHeader("cache-control", "no-cache");
    out.println(report);
    
    
    ////////////////////////////////////////////////////////////////////////////
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
