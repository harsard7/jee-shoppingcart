/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.shoppingcart.controllers;

import com.ijse.shoppingcart.CONSTANTS.CONSTANTSTYPE;
import com.ijse.shoppingcart.connection.ConnectionFactory;
import com.ijse.shoppingcart.modal.Admin;
import com.ijse.shoppingcart.repostory.custom.AdminRepository;
import com.ijse.shoppingcart.util.Jbcrypt;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author Hafees
 */
@WebServlet(name = "AdminServletController", urlPatterns = {"/AdminServletController"})
public class AdminServletController extends HttpServlet {

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
            throws ServletException, IOException, Exception {
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
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(AdminServletController.class.getName()).log(Level.SEVERE, null, ex);
        }
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
          String uname=request.getParameter("username");
            String password=request.getParameter("password");
         Jbcrypt jbc=new Jbcrypt();
        String hashPassword = jbc.hashPassword(password);
        
        try {
            System.out.println(" admin servlet");
              // Admin admin = AdminRepository.verifyAdmin(uname, hashPassword);
               Admin admin = AdminRepository.searchAdmin(uname);
               if(admin!=null){
                    if(uname.equals(admin.getUsername())){
                         boolean checkPass = jbc.checkPass(password, admin.getPassword());
                        if(checkPass){
                         response.sendRedirect(request.getContextPath()+"/AdminDashBoard.jsp");
                        }else{
                         response.sendRedirect(request.getContextPath()+"/signin.jsp?error=1");
                        }
                         
                         //if(password.equals(admin.getPassword())){
                }else{
                 response.sendRedirect(request.getContextPath()+"/signin.jsp?error=1");
                }
            }else{
             response.sendRedirect(request.getContextPath()+"/signin.jsp?error=2");
            }
         
        } catch (Exception ex) {
            Logger.getLogger(AdminServletController.class.getName()).log(Level.SEVERE, null, ex);
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
