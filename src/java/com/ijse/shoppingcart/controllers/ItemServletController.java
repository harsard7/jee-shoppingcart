/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.shoppingcart.controllers;

import com.ijse.shoppingcart.CONSTANTS.CONSTANTSTYPE;
import com.ijse.shoppingcart.DTO.CategoryDTO;
import com.ijse.shoppingcart.DTO.ItemDTO;
import com.ijse.shoppingcart.service.ServiceFactory;
import com.ijse.shoppingcart.service.custom.ItemService;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.ijse.shoppingcart.util.IdGenerater;

/**
 *
 * @author Hafees
 */
@WebServlet(name = "ItemServletController", urlPatterns = {"/ItemServletController"})
public class ItemServletController extends HttpServlet {

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
//        if(String("true")!="true"){} else {
//        }
        
        
        String image = request.getParameter("image");
        String category = request.getParameter("category");
       
        String description = request.getParameter("description");
        double Price = Double.parseDouble(request.getParameter("Price"));
        int Qty =Integer.parseInt( request.getParameter("Qty"));
        
        String itemid = IdGenerater.generateUUID(CONSTANTSTYPE.ITEM);
        
        try {
            ItemService itemService  =(ItemService) ServiceFactory.getInstance().getService(CONSTANTSTYPE.ITEM);
            ItemDTO itemDTO=new ItemDTO(itemid, category, description,Price, Qty,image);
            if(itemService.insert(itemDTO)){
                response.sendRedirect(request.getContextPath()+"/ManageItem.jsp?status=1");
                request.getSession().setAttribute("latestUrl", request.getRequestURI());//ShoppingCart/ItemServletController
               
            }else{
                response.sendRedirect(request.getContextPath()+"/ManageItem.jsp?status=2");
        
           }
            
            
        } catch (Exception ex) {
            Logger.getLogger(ItemServletController.class.getName()).log(Level.SEVERE, null, ex);
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
