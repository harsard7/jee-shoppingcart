<%-- 
    Document   : ItemDetails
    Created on : Jun 19, 2018, 1:12:06 PM
    Author     : Hafees
--%>



<%@page import="com.ijse.shoppingcart.DTO.CustomerDTO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page import="com.ijse.shoppingcart.modal.Customer"%>
<%@page import="com.ijse.shoppingcart.DTO.ItemDTO"%>
<%@page import="com.ijse.shoppingcart.service.custom.ItemService"%>
<%@page import="com.ijse.shoppingcart.CONSTANTS.CONSTANTSTYPE"%>
<%@page import="com.ijse.shoppingcart.service.ServiceFactory"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Item Details</title>
         <link href="css/bootstrap.min.css" rel="stylesheet" />
        <script src="js/jquery-3.2.1.min.js"></script>  
        <style>
            div{
                float: left;
                margin: 10px;
                color: darkblue
            }
            div dd{
                margin: 0px;
                font-size: 10px;
                
            }
            body, html {
                background-color: #FFA534;
                   color: #FFFFFF;
            }
        </style>
        <%
           String path= request.getContextPath();
           String basepath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
           System.out.print("basepath  "+basepath);
            
            CustomerDTO customer=(CustomerDTO)request.getSession().getAttribute("user");            
            String iflogin;
            if(customer!=null){
            iflogin="true";
            }else{
            iflogin="false";
            }
            
        %>
       <script type="text/javascript">
             var id="";
            function addtocarts(id){
//                    var mypath=String("<%=basepath%>")+"/com.ijse.shoppingcart.controllers/MycartServlet?id="+id+"action=add";
//                    window.open(mypath,"_blank","width=300,height=200,top=400,left=50%");
                }else{
                    alert("please Log in");
                }
            }
            function viewcart(){
            if(String(<%=iflogin%>)=="true"){
                var mypath=String("<%=basepath%>")+"Mycart.jsp";
                window.open(mypath,"_self");
            }else{
                alert("Please log in");
            }
            
            }
//            $(document).ready(function(){
//    $("input").keydown(function(){
//        $("input").css("background-color", "yellow");
//    });
//    $("input").keyup(function(){
//        $("input").css("background-color", "pink");
//    });
//});

       
    
            
        </script>
    </head>
   
    <body>
    <center>
        <h1>Item Detail</h1>
         <%
                    if(customer!=null){
                      
              %>
              <h1>Welcome <%=customer.getName()%></h1>
        <table>
            <tr>
             
                
                 <td></td>
                 <td><input type="button" value="my information"  class="btn btn-primary" onclick="location.href='customerinfo.jsp'"></td>
                 <td><input type="button" value="Back to main page"  class="btn btn-primary"  onclick="location.href='index.jsp'"></td>
                 <td><input type="button" value="View cart"  class="btn btn-primary" onclick="location.href='Mycart.jsp'"></td>
                
                 <td><input type="button" value="Logout"  class="btn btn-info" onclick="location.href='LogoutServlet'"></td>
              <% 
                 }else{
              %>  
                 <td><input type="button" value="Log in"   class="btn btn-primary" onclick="location.href='signin.jsp'"></td>
                  <td><input type="button" value="Back to main page"  class="btn btn-info" onclick="location.href='index.jsp'"></td>
                 <td></td>
                 <td></td>
                 <td></td>
               <%  
                 }
               %>
               <td style="color: blue;font-size: 20px"> People Are Live</td>
            </tr>
        </table>
<!--            item detail-->
        <% 
            String id=request.getParameter("id");
            ItemService itemservice=(ItemService)ServiceFactory.getInstance().getService(CONSTANTSTYPE.ITEM);
            ItemDTO itemdto=itemservice.findOne(id);
            String latesturl=request.getRequestURI()+"?id="+id;
            request.getSession().setAttribute("latesturl", latesturl);
        %>
        <script type="text/javascript">
        
        function setparameter(){
            
            var qty=document.getElementById("qty").value;
            var qt=parseInt(qty);
             var numbers = /^[0-9]+$/;
          if(qty!=""){
               if(qty.match(numbers)){
                   if(qt>0){
                    var id="<%=itemdto.getId()%>";
                   
                    window.location.href="MycartServlet?action=add&id="+id+"&qty="+qty;
                   }else{
                       alert("Please enter the number more than Zero"); 
                   }
                }else{
                     alert("Please enter only Number");
                }
          }else{
          alert("Please enter the Qty");
          }
        }
        
         $(document).ready(function(){
            $("#qty").keyup(function(){
                var qty=$("#qty").val();
               
                   var qty1=parseInt(qty);
                if(qty1<1){
                    alert("Qty should be more than Zero");
              $("#qtytext").css("color","red");      
                }else{
                $("#qtytext").css("color","darkblue");    
//                $("#qtytext").html();    
                }
            });
        });
        </script>
    
        <br>
        <table>
            <tr>
                <td rowspan="5"><img src="img/<%=itemdto.getImage()%>.jpg" width="400" height="330"/></td>
            </tr>
            <tr>
                <td><B><%=itemdto.getDescription()%></B></td>
            </tr> 
            <tr>
                <td>Price Rs :<%=itemdto.getPrice()%></td>
            </tr>
            <tr>
                <td>Stock :<%=itemdto.getQty()%>&nbsp;available</td>
            </tr>
            <tr>
                <td>Qty <input type="text" name="qty" id="qty">
            <dt id="qtytext">Enter one or more qty</dt>
                </td>
            </tr>
            <tr>
                
                        <%
                            if(request.getSession().getAttribute("user")!=null){
                            %>
                            <td><div>
                            <input type="button" class="btn btn-primary" onclick="location.href='ViewCartServlet'" value="View Cart">
                            </td>
                            
                           
                            <td>
<!--                            <input type="button" onclick="location.href='MycartServlet?action=add&id=<%=itemdto.getId()%>'" value="Add To cart">-->
                            <input type="button" class="btn btn-primary" onclick="setparameter()" value="Add To cart">
                             
                              </div>
                        </td> 
            </tr>
        </table>
                    <br>
                     <%
                            }else{
                         %>       
                           <h2>Please <a href="signin.jsp"><B>Login</B></a> to Add item to cart</h2>
                           <%
                                }
                           %>
                    <hr>
                    <h1>Product Details</h1>
                    <table>
                        <tr>
                            <td>Item name:</td>
                            <td><%=itemdto.getDescription()%></td>
                        </tr>
                         <tr>
                            <td>Item Price:</td>
                            <td>Rs <%=itemdto.getPrice()%></td>
                        </tr>
                         <tr>
                            <td>Stock On Hand:</td>
                            <td><%=itemdto.getQty()%></td>
                        </tr>
                    </table>
    </center> 
    </body>
</html>
