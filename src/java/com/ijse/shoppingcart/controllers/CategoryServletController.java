/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.shoppingcart.controllers;

import com.ijse.shoppingcart.CONSTANTS.CONSTANTSTYPE;
import com.ijse.shoppingcart.DTO.CategoryDTO;
import com.ijse.shoppingcart.service.ServiceFactory;
import com.ijse.shoppingcart.service.SuperService;
import com.ijse.shoppingcart.service.custom.CategoryService;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
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
@WebServlet(name = "CategoryServletController", urlPatterns = {"/CategoryServletController"})
public class CategoryServletController extends HttpServlet {

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
        //PrintWriter out=response.getWriter();
        //String list = request.getParameter("list");
      //  out.print("11111");
        try {
            CategoryService service = (CategoryService) ServiceFactory.getInstance().getService(CONSTANTSTYPE.CATEGORY);
           
            List<CategoryDTO> catlist = service.showAll();
            
            request.getSession().setAttribute("listcategory", catlist);
              
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("AddItem.jsp");
             
           requestDispatcher.forward(request, response);
         
            
        } catch (Exception ex) {
            ex.printStackTrace();
            Logger.getLogger(CategoryServletController.class.getName()).log(Level.SEVERE, null, ex);
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
        String catname = request.getParameter("catname");
        String generateUUID = IdGenerater.generateUUID(CONSTANTSTYPE.CATEGORY);
        try {
            CategoryService service = (CategoryService) ServiceFactory.getInstance().getService(CONSTANTSTYPE.CATEGORY);
            CategoryDTO categoryDTO=new CategoryDTO(generateUUID, catname);
            if(service.insert(categoryDTO)){
                response.sendRedirect(request.getContextPath()+"/ManageCategory.jsp?status=1");
            
            }else{
                response.sendRedirect(request.getContextPath()+"/ManageCategory.jsp?status=2");
            }
        } catch (Exception ex) {
            Logger.getLogger(CategoryServletController.class.getName()).log(Level.SEVERE, null, ex);
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
