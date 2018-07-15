<%-- 
    Document   : index
    Created on : Jun 18, 2018, 10:57:50 AM
    Author     : Hafees
--%>


<%@page import="com.ijse.shoppingcart.listeners.UserSessionListner"%>
<%@page import="com.ijse.shoppingcart.DTO.CustomerDTO"%>

<%@page import="com.ijse.shoppingcart.modal.Customer"%>
<%@page import="com.ijse.shoppingcart.DTO.ItemDTO"%>
<%@page import="com.ijse.shoppingcart.service.custom.ItemService"%>
<%@page import="com.ijse.shoppingcart.service.ServiceFactory"%>
<%@page import="com.ijse.shoppingcart.CONSTANTS.CONSTANTSTYPE"%>
<%@page import="com.ijse.shoppingcart.repostory.RepositoryFactory"%>
<%@page import="com.ijse.shoppingcart.modal.Item"%>
<%@page import="java.util.List"%>
<%@page import="com.ijse.shoppingcart.repostory.custom.ItemRepository"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Plaza Virtual Shopping</title>
          <link href="css/bootstrap.min.css" rel="stylesheet" />
        <style>
            div{
                float: left;
                margin-left: 20px;
                margin-right:  20px;
                overflow: auto;
            }
            body, html {
                background-color: crimson;
                   color: #FFFFFF;
    height: 100%;
    margin: 0;
}

.bg {
    /* The image used */
/*    background-image: url("img/imagesg.jpg");*/

    /* Full height */
    height: 100%; 

    /* Center and scale the image nicely */
    background-position: center;
    background-repeat: no-repeat;
    background-size: cover;
}
        </style>
    </head>
    <body class="bg">
      
        <%
          // request.getSession().setAttribute("latestURL",request.getRequestURI());
        %>
    <center>
         <%
            ItemService itemservice=(ItemService)ServiceFactory.getInstance().getService(CONSTANTSTYPE.ITEM);
                List<ItemDTO>itemlist=itemservice.showAll();
                
                if(itemlist!=null){
                   
                   
                    if(request.getSession(false).getAttribute("user")!=null){
                       
                        CustomerDTO customer=(CustomerDTO)request.getSession(false).getAttribute("user");
        %>
        
        <table>
            <tr>
       
       
        <td><input type="button" value="View Customer Information"   class="btn btn-primary" onclick="location.href='customerinfo.jsp'"></td>
        <td><input type="button" value="View Customer Cart"   class="btn btn-info"   onclick="location.href='Mycart.jsp'"></td>
        <td><input type="button" value="Logout"  class="btn btn-info" onclick="location.href='LogoutServlet'"></td>
        <td style="color: black;font-size: 20px"><%=UserSessionListner.getActiveUserCount()%> peoples are viewing this web site</td> 
        <h1>Welcome <%=customer.getName()%></h1>
        <%
                }else{
        %>
        <td><input type="button" value="LogIn"  class="btn btn-info" onclick="location.href='signin.jsp'"</td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
          <h1>Welcome</h1>
        <%
            }
//UserSessionListner.getActiveUserCount()
           
             %>
            
        <%
           
        %>    
       
      </tr>           
    </table>
    
      
      <%  
          
        String spageid=request.getParameter("page"); 
          if(spageid==null){
          spageid="1";
          }
        int pageid=Integer.parseInt(spageid);  
         
        int total=4;  
        if(pageid==1){}  
        else{  
            pageid=pageid-1;  
            pageid=pageid*total+1;  
        }  
        ItemRepository itemrepo=(ItemRepository)RepositoryFactory.getInstance().getRepository(CONSTANTSTYPE.ITEM);

        List<Item> list=itemrepo.getAllItemwithlimit(pageid,total);  

        out.print("<h1>Page No: "+spageid+"</h1>");  
           %>   
<!--      Item list-->
<table width="1000" height="60">

    <tr>
        <td>
            <%
                System.out.println("getMaxInactiveInterval()  == "+request.getSession(false).getMaxInactiveInterval());
                for (Item item : list) {
             %>  
             <div>
<!--                 discription list-->
                 <dl>
                     <dt>
                         <a
                             href="ItemDetails.jsp?id=<%=item.getId()%>">
                             <img src="img/<%=item.getImage()%>.jpg" width="400" height="350" border="3" alt="<%=item.getDescription()%>"/>
                     </a>
                     </dt>
                     <dd><B><%=item.getDescription()%></B></dd>
                     <dd><B>Price:Rs <%=item.getPrice()%>0</B></dd>
                     <dd><B>Stock:<%=item.getQty()%>&nbsp;available</B></dd>
                 </dl>
             </div>
                 
           <%
               }
            }
          %>
        </td>
    </tr>
    
</table>
        <%
            String spageid=request.getParameter("page"); 
          if(spageid==null){
          spageid="1";
          }
            int pageid1=Integer.parseInt(spageid); 
            ItemRepository itemrepo=(ItemRepository)RepositoryFactory.getInstance().getRepository(CONSTANTSTYPE.ITEM);
            int itemCount=itemrepo.getAllItemwcount();
    int pagecoount=itemCount/4;
    int pagecoounts=itemCount%4;
    if(pagecoounts>0){
    pagecoount+=1;
    }else{
    
    }
    for (int i = 1; i < pagecoount+1; i++) {
        
        if(pageid1==i){
            
        %>
        <a style="color:white;font-size: 40px" href="index.jsp?page=<%=i%>"><B><%=(i)%></B></a> &nbsp; 
        <%
        }else{
       
        %>
        <a style="font-size: 40px" href="index.jsp?page=<%=i%>"><B><%=(i)%></B></a> &nbsp; 
        <%
         }
       %>
      
       
    <%
    }
%>    
      </center>
      
    <div style="position: fixed">
          <p class="copyright">&copy; 2018  All Rights Reserved | Design by <a href="https://w3layouts.com/" target="_blank">Plaza</a></p>
      </div>
    </body>
</html>
