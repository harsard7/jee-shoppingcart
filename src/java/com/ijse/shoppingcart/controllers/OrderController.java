/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.shoppingcart.controllers;

import com.ijse.shoppingcart.CONSTANTS.CONSTANTSTYPE;
import com.ijse.shoppingcart.DTO.CustomerDTO;
import com.ijse.shoppingcart.DTO.ItemDTO;
import com.ijse.shoppingcart.DTO.OrderDTO;
import com.ijse.shoppingcart.DTO.OrderDetailDTO;
import com.ijse.shoppingcart.DTO.ShoppingCart;
import com.ijse.shoppingcart.service.ServiceFactory;
import com.ijse.shoppingcart.service.SuperService;
import com.ijse.shoppingcart.service.custom.OrderDetailService;
import com.ijse.shoppingcart.service.custom.OrderService;
import com.ijse.shoppingcart.util.IdGenerater;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Hafees
 */
@WebServlet(name = "OrderController", urlPatterns = {"/OrderController"})
public class OrderController extends HttpServlet {

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
        OrderService orderservice=null;
        OrderDetailService orderdetailservice=null;
        
        
        try {
             orderservice = (OrderService) ServiceFactory.getInstance().getService(CONSTANTSTYPE.ORDERS);
             orderdetailservice = (OrderDetailService)ServiceFactory.getInstance().getService(CONSTANTSTYPE.ORDERDETAIL);
        } catch (Exception ex) {
            Logger.getLogger(OrderController.class.getName()).log(Level.SEVERE, null, ex);
        }
         
        
        CustomerDTO customer = (CustomerDTO) request.getSession().getAttribute("user");
        
         Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String formatdate = dateFormat.format(date);
        
        DateFormat dateFormat1 = new SimpleDateFormat("HH:mm");
        String formattime = dateFormat1.format(date);
        ShoppingCart cart = (ShoppingCart) request.getSession().getAttribute("mycart");
        HashMap<ItemDTO, Integer> itemcart = cart.getItemcart();
        Set<ItemDTO> itemkeySet = itemcart.keySet();
        Iterator<ItemDTO> items = itemkeySet.iterator();
        boolean ordersavestatus=false;
        String orderid = IdGenerater.generateUUID(CONSTANTSTYPE.ORDERS);
        try {
             ordersavestatus = orderservice.insert(new OrderDTO(orderid, formatdate,formattime, customer.getId(),cart.getTotalQty(),cart.getTotalprice()));
                    
        } catch (Exception ex) {
            Logger.getLogger(OrderController.class.getName()).log(Level.SEVERE, null, ex);
        }
        while(items.hasNext()){
            if(ordersavestatus){
             ItemDTO item = items.next();
                try {
                    orderdetailservice.insert(new OrderDetailDTO(orderid, item.getId(),formatdate,itemcart.get(item),item.getPrice()));
                } catch (Exception ex) {
                    Logger.getLogger(OrderController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
           response.sendRedirect("Buying.jsp");
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
       
        Date date = new Date();
        System.out.println("date "+date);
        try {
            // orderservice = (OrderService) ServiceFactory.getInstance().getService(CONSTANTSTYPE.ORDERS);
            // orderdetailservice = (OrderDetailService)ServiceFactory.getInstance().getService(CONSTANTSTYPE.ORDERDETAIL);
        } catch (Exception ex) {
            Logger.getLogger(OrderController.class.getName()).log(Level.SEVERE, null, ex);
        }
        ShoppingCart cart = (ShoppingCart) request.getSession().getAttribute("mycart");
        HashMap<ItemDTO, Integer> itemcart = cart.getItemcart();
        Set<ItemDTO> keySet = itemcart.keySet();
        Iterator<ItemDTO> items = keySet.iterator();
        while(items.hasNext()){
            ItemDTO item = items.next();
            
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
