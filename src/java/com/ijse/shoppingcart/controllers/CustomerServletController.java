/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.shoppingcart.controllers;

import com.ijse.shoppingcart.CONSTANTS.CONSTANTSTYPE;
import com.ijse.shoppingcart.DTO.CustomerDTO;
import com.ijse.shoppingcart.modal.Customer;
import com.ijse.shoppingcart.repostory.custom.AdminRepository;
import com.ijse.shoppingcart.repostory.custom.CustomerRepository;
import com.ijse.shoppingcart.service.ServiceFactory;
import com.ijse.shoppingcart.service.SuperService;
import com.ijse.shoppingcart.service.custom.CustomerService;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.ijse.shoppingcart.util.IdGenerater;
import com.ijse.shoppingcart.util.Jbcrypt;

/**
 *
 * @author Hafees
 */
@WebServlet(name = "CustomerServletController", urlPatterns = {"/CustomerServletController"})
public class CustomerServletController extends HttpServlet {

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
                
        
             String name = request.getParameter("name");
             String password = request.getParameter("password");
             String conpassword = request.getParameter("confirmpassword");
             String gender = request.getParameter("gender");
             String dob= request.getParameter("dob");
        int contact = Integer.parseInt(request.getParameter("contact"));
       
        try {
            if(CustomerRepository.getCustomerbyname(name)==null){
                if(password.equals(conpassword)){
                 CustomerService customerService = (CustomerService) ServiceFactory.getInstance().getService(CONSTANTSTYPE.CUSTOMER);
                String id = IdGenerater.generateUUID(CONSTANTSTYPE.CUSTOMER);
                Jbcrypt jbc=new Jbcrypt();
                String hashPassword = jbc.hashPassword(password);
                CustomerDTO customerDTO=new CustomerDTO(id, name,hashPassword,gender,dob,contact);
                customerService.insert(customerDTO);
                    HttpSession session = request.getSession();
                session.setMaxInactiveInterval(20);
                session.setAttribute("user ", customerDTO);
                session.setAttribute("loginstatus","1");
                   if(request.getParameter("hidden").equals("customer")){
                     
                    response.sendRedirect(request.getContextPath()+"/index.jsp?");
                      
                   }else{
                       System.out.println(" customer control hiden"+request.getParameter("hidden"));
                    response.sendRedirect(request.getContextPath()+"/AdminDashBoard.jsp?");
                   }
               
                   
                }else{
                     response.sendRedirect(request.getContextPath()+"/signin.jsp?error=1");//password mismatch
             }
            }else{
            response.sendRedirect(request.getContextPath()+"/signin.jsp?error=2");//already username exists
            }
            
           // processRequest(request, response);
        } catch (Exception ex) {
            ex.printStackTrace();
            Logger.getLogger(CustomerServletController.class.getName()).log(Level.SEVERE, null, ex);
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
