/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;
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
import model.CarDealerRepository;

/**
 *
 * @author Tomas
 */
@WebServlet(name = "DisplayAllCars", urlPatterns = {"/DisplayAllCars"})
public class DisplayAllCars extends HttpServlet {

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
        
//        CarDB repo = new CarDB();
//        
//        Optional<Car> opt = repo.getByID(4294194);
//        Car a = opt.orElse(new Car());
//        out.println(a.getBody()+" "+ a.getColour()+" ");
//        
//        List<Car> rides = repo.getall();
//        out.println(rides.size()+" ");
//        
//        a.setColour("olive");
//        repo.update(a);
//        
//        List<Car> ides = repo.getCarsByBody("SUV");
//        out.println(ides.size()+" "+ides.get(3).getCarReg());

        
        String nextPage;
        Boolean found =false;
        CarDB repo = new CarDB();
        TreeSet<String> make = new TreeSet<>();
        TreeSet<String> body = new TreeSet<>();
        TreeSet<String> year = new TreeSet<>(); 
        //======================================================================
       try {
           
           ///////////////////////////////////////////////////
           Cookie[] cookies = request.getCookies();
           for(Cookie cookie : cookies){
                if("wishlist".equals(cookie.getName())){
                System.out.println("//////////////Added to response/////////////");
                    System.out.println(cookies.length+" "+cookie.getName()+" "+cookie.getValue());
                     found = true;
                }
                   
           }    
           
           if(!found){
               Cookie cookie = new Cookie("wishlist", "");
               cookie.setMaxAge(60*60*24*365*2);
               cookie.setPath("/");
               response.addCookie(cookie);
               System.out.println("/////////////Cookie created///////////////");
           }
           else
               System.out.println("///////////////Old Cookie was found/////////");
           
           ///////////////////////////////////////////////////
           
           
           List<Car> list = repo.getall(); 
                
            if(list == null || list.isEmpty()){
                nextPage = "error.jsp";
                request.setAttribute("message", "No records could be found");
            }
            else{
                nextPage = "/ShowAllCars.jsp";
                list.stream().map(c -> {make.add(c.getMake());return c;})
                        .map(c -> {body.add(c.getBody());return c;})
                        .forEachOrdered(c -> {year.add(c.getYear());});
                
                HttpSession session = request.getSession();
                session.setAttribute("make", make);
                session.setAttribute("body", body);
                session.setAttribute("year", year);
                request.setAttribute("list", list);
            }      
        }
        catch(Exception ex){
            log("Exeption: " + ex);
            request.setAttribute("message", ex);
            nextPage = "error.jsp";
        }
         
        RequestDispatcher dispatcher = request.getRequestDispatcher(nextPage);
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
