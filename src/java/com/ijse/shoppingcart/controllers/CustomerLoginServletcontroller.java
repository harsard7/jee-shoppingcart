/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.shoppingcart.controllers;

import com.ijse.shoppingcart.DTO.CustomerDTO;
import com.ijse.shoppingcart.modal.Customer;
import com.ijse.shoppingcart.repostory.custom.CustomerRepository;
import com.ijse.shoppingcart.util.Jbcrypt;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Hafees
 */
@WebServlet(name = "CustomerLoginServletcontroller", urlPatterns = {"/CustomerLoginServletcontroller"})
public class CustomerLoginServletcontroller extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
          
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
            String name = request.getParameter("username");
            String password = request.getParameter("password");
            Jbcrypt jbc=new Jbcrypt();
            
           
            
            if(name == null || "".equals(name) || password == null || "".equals(password)){
               
		throw new ServletException("User Name Or Password missing!!");
	}
     if(name.equals("admin")){
                RequestDispatcher rdp = request.getRequestDispatcher("AdminServletController");
                rdp.forward(request, response);            
            }else{       
            
        try {
            Customer customer = CustomerRepository.getCustomerbyname(name);
          CustomerDTO customerdto=new CustomerDTO(customer.getId(), customer.getName(), customer.getPassword(), customer.getGender(), customer.getDob(),customer.getContact());
            if(customer!=null){
                 System.out.println("Customer servlet");
                if(customer.getName().equals(name)){
                    boolean veryfypassword = jbc.checkPass(password, customer.getPassword());
                     if(veryfypassword){
                        HttpSession session = request.getSession();
                    session.setMaxInactiveInterval(20);
                    
                    session.setAttribute("user", customerdto);
                    session.setAttribute("loginstatus", "1");
                    response.sendRedirect(request.getContextPath()+"/index.jsp");
                        }else{
                            System.out.println("Customer servlet wrong password");
                           response.sendRedirect(request.getContextPath()+"/signin.jsp?error=1");
                        }
                }else{
                response.sendRedirect(request.getContextPath()+"/signin.jsp?error=2");
                }
            
            }else{
            response.sendRedirect(request.getContextPath()+"/signin.jsp?error=2");
            
            }
            
        } catch (Exception ex) {
            Logger.getLogger(CustomerLoginServletcontroller.class.getName()).log(Level.SEVERE, null, ex);
        }
        
            }
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
