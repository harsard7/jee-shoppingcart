<%-- 
    Document   : BuyIng
    Created on : Jun 20, 2018, 9:11:39 AM
    Author     : Hafees
--%>

<%@page import="java.util.Iterator"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.HashMap"%>
<%@page import="com.ijse.shoppingcart.DTO.ItemDTO"%>
<%@page import="com.ijse.shoppingcart.service.custom.ItemService"%>
<%@page import="com.ijse.shoppingcart.CONSTANTS.CONSTANTSTYPE"%>
<%@page import="com.ijse.shoppingcart.service.ServiceFactory"%>
<%@page import="com.ijse.shoppingcart.DTO.ShoppingCart"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Payment page</title>
         <link href="css/bootstrap.min.css" rel="stylesheet" />
        <style>
        body, html {
                background-color: #00bbff;
                   color: #FFFFFF;
                   font-family: sans-serif;
                   font-style: italic;
             }
        </style>
    </head>
    <body>
    <center>
        <%
            ItemService itemservice=(ItemService)ServiceFactory.getInstance().getService(CONSTANTSTYPE.ITEM);
            ShoppingCart cart=(ShoppingCart)request.getSession().getAttribute("mycart");
                    HashMap<ItemDTO,Integer>itemcart=cart.getItemcart();
                    Set<ItemDTO>itemkeyset=itemcart.keySet();
                    Iterator<ItemDTO> it=itemkeyset.iterator();
                    boolean result=false;
                    while(it.hasNext()){
                            ItemDTO itemdtocart=it.next();
                            ItemDTO itemdb=itemservice.findOne(itemdtocart.getId());
                            int qty=itemdb.getQty()-itemcart.get(itemdtocart);
                            ItemDTO itemupdated=new ItemDTO(itemdtocart.getId(), itemdtocart.getCatid(), itemdtocart.getDescription(), itemdtocart.getPrice(), qty, itemdtocart.getImage());
                           
                           result=itemservice.update(itemupdated);
                    }
            
        %>  
        <%
            
            if(result){
                request.getSession().removeAttribute("mycart");
            
         %>   
            
        <h1 style="color: green">Your Payment Successfully Completed</h1>
        <h2 style="color: green">Thank You .Waiting For Next Visit</h2>
        <div></div>
        <br>
        <hr>
        <%
        }else{
        %>
         <h1 style="color: red">Your Payment Not Completed <h1>
        <h2 style="color: green">Sorry  !!! Try Again</h2>
        <%
            }
        %>    
        <h2><input type="button" value="Home"  class="btn btn-info" onclick="location.href='index.jsp'"></h2>
   </center>
    </body>
</html>
