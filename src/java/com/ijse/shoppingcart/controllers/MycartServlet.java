/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.shoppingcart.controllers;

import com.ijse.shoppingcart.CONSTANTS.CONSTANTSTYPE;
import com.ijse.shoppingcart.DTO.ItemDTO;
import com.ijse.shoppingcart.DTO.ShoppingCart;
import com.ijse.shoppingcart.service.ServiceFactory;
import com.ijse.shoppingcart.service.SuperService;
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

/**
 *
 * @author Hafees
 */
@WebServlet(name = "MycartServlet", urlPatterns = {"/MycartServlet"})
public class MycartServlet extends HttpServlet {
         ItemService itemService;
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
            /* TODO output your page here. You may use following sample code. */
            String action = request.getParameter("action");
            String qty = request.getParameter("qty");
            
           
            
            if(action.equals("add")){
               
            if(addTocart(request, response)){
               
             ShoppingCart s  = (ShoppingCart)request.getSession().getAttribute("mycart");
               
                response.sendRedirect("index.jsp");
            }else{
            response.sendRedirect("error.jsp");
            }
          }
           if(action.equals("delete")){
              if(removefromcart(request, response)){
                  response.sendRedirect("Mycart.jsp");
              }else{
              response.sendRedirect("Mycart.jsp");
              }
                
           
           } 
            
        }
    }
    
    public boolean addTocart(HttpServletRequest request,HttpServletResponse response) throws Exception{
        String id =request.getParameter("id");
        ItemService itemservice = (ItemService) ServiceFactory.getInstance().getService(CONSTANTSTYPE.ITEM);
        ItemDTO item = itemservice.findOne(id);
        
        if(request.getSession().getAttribute("mycart")==null){
            ShoppingCart cart=new ShoppingCart();
            request.getSession().setAttribute("mycart", cart);
           
        }
        ShoppingCart shoppingcart = (ShoppingCart) request.getSession().getAttribute("mycart");
        if(shoppingcart.updateqtycart(item, Integer.parseInt(request.getParameter("qty")))){
            return true;
        
        }else{
        return false;
        }
//        if(shoppingcart.addtocart(item)){
//          
//            return true;
//            }else{
//             return false;
//            }
         
        
    
    }
    public boolean removefromcart(HttpServletRequest request,HttpServletResponse response) throws Exception{
          String id = request.getParameter("id");
         ItemService itemService=(ItemService) ServiceFactory.getInstance().getService(CONSTANTSTYPE.ITEM);
        ItemDTO item = itemService.findOne(id);
     
        ShoppingCart cart = (ShoppingCart) request.getSession().getAttribute("mycart");
       
            if(cart.deleteFromCart(item)){
            return true;
             }else{
            return false;
            }
    }
    private boolean updateItemqtyforAddtocart(HttpServletRequest request,ItemDTO itemDTO) throws Exception{
        itemService=(ItemService) ServiceFactory.getInstance().getService(CONSTANTSTYPE.ITEM);
        ShoppingCart cart=(ShoppingCart) request.getSession().getAttribute("mycart");
             Integer cartqty = cart.getItemcart().get(itemDTO);
             int qty = itemDTO.getQty()-cartqty;
             itemDTO.setQty(qty);
              System.out.println("updateItemqtyforAddtocart qty  "+qty);
             return itemService.update(itemDTO);
    
    }
     private boolean updateItemqtyfordeletecart(HttpServletRequest request,ItemDTO itemDTO) throws Exception{
        itemService=(ItemService) ServiceFactory.getInstance().getService(CONSTANTSTYPE.ITEM);
        ShoppingCart cart=(ShoppingCart) request.getSession().getAttribute("mycart");
             Integer cartqty = cart.getItemcart().get(itemDTO);
             int qty = itemDTO.getQty()+cartqty;
             System.out.println("updateItemqtyfordeletecart qty  "+qty);
             itemDTO.setQty(qty);
             
             return itemService.update(itemDTO);
    
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
            Logger.getLogger(MycartServlet.class.getName()).log(Level.SEVERE, null, ex);
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
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(MycartServlet.class.getName()).log(Level.SEVERE, null, ex);
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
