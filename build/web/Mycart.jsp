<%-- 
    Document   : Mycart
    Created on : Jun 19, 2018, 1:45:54 PM
    Author     : Hafees
--%>

<%@page import="java.util.Iterator"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.HashMap"%>
<%@page import="com.ijse.shoppingcart.DTO.ItemDTO"%>
<%@page import="com.ijse.shoppingcart.DTO.ShoppingCart"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>My cart</title>
       
         <link href="css/bootstrap.min.css" rel="stylesheet" />
          <script src="js/jquery-3.2.1.min.js"></script>  
        <style>
            table td{
                width: 100px;
                text-align: center;
            }
            table th{
                font-size: 20px;                
            }
            table,td,th{
                border: 2px solid blue;
            }
             body, html {
                background-color: crimson;
                   color: #FFFFFF;
             }
        </style>
    </head>
    <body>
    <center>
        <%
            request.getSession().setAttribute("latesturl",request.getRequestURI());
        %>    
        
       
        <%
            if(request.getSession().getAttribute("user")==null){
                request.getSession().removeAttribute("mycart");
            %>
               <h2>Please <a href="signin.jsp"><B>Login</B></a> for Add item to Cart</h2>
            <%
               }else{
           ShoppingCart cart=(ShoppingCart)request.getSession().getAttribute("mycart");
           if(cart==null){
           %>
               <h3>Cart Is Empty</h3>
               
               <br>
               <hr>
           <input type="button" class="btn btn-info"  value="Back to main Page" onclick="location.href='index.jsp'">
           <%
           }else{
                HashMap<ItemDTO,Integer>itemlist=cart.getItemcart();
                                Set<ItemDTO>item=itemlist.keySet();
                                   Iterator<ItemDTO> items= item.iterator();
                                    if(items.hasNext()==false){
                                       %>
                                       <h1>Cart Is Empty</h1>
                                        <input type="button" value="Back to main Page"  class="btn btn-info" onclick="location.href='index.jsp'">
                                       <%
                                       }else{
                                        %>
                          <input type="button" value="My Information" class="btn btn-info" onclick="location.href='customerinfo.jsp'">
<!--        <input type="button" value="Shopping History" onclick="location.href='MyShoppingHistory.jsp'">-->
        <input type="button" value="Back to main Page"  class="btn btn-info" onclick="location.href='index.jsp'">
        <input type="button" value="Log Out"  class="btn btn-info" onclick="location.href='LogoutServlet'">
        <h1>My Cart</h1>               
                                        
        <div class="container">                    
                                        
<!--                                        Show Items-->
                         <table class="table table-striped" id="itemtable">
                            <tr>
                                <th>No</th>
                                <th>Image</th>
                                <th>Description</th>
                                <th>Qty</th>
                                <th>Each Price</th>
                                <th>Total Amount</th>
                                <th>Stock On Hand</th>
                                <th>Operation</th>                 
                            </tr>
                             <%
                                 int rowcount=0;
                                while(items.hasNext()){
                                    ItemDTO itmdto=items.next();
                                    
                             %>
                             <tr>
                                 <td class="rows" id="rowcount<%=rowcount%>"><%=++rowcount%></td>  
                               <td id="id"><a href="ItemDetails.jsp?id=<%=itmdto.getId()%>">
                                         <img src="img/<%=itmdto.getImage()%>.jpg" width="200" height="150"/></a></td>
                                         <td><%=itmdto.getDescription()%></td>        
                                         <td id="qty"><%=itemlist.get(itmdto)%></td>        
                                         <td id="price"><%=itmdto.getPrice()%>0</td>        
                                         <td><%=itemlist.get(itmdto)*itmdto.getPrice()%>0</td>        
                                         <td><%=itmdto.getQty()%></td>        
                                         <td><input type="button" value="Delete" class="btn btn-info" onclick="location.href='MycartServlet?action=delete&id=<%=itmdto.getId()%>'"></td> 
                              </tr>
                              <%
                                }
                               %>     
                        </table>
                               <h3>Total Price is :<%=cart.getTotalprice()%>0</h3>
                               <h3>Total Qty is :<%=cart.getTotalQty()%></h3>
                               <input type="button" value="Buy Now" class="btn btn-info"  onclick="location.href='OrderController'">
<!--                               <input type="button" value="Buy Now" class="btn btn-info"  onclick="getTableData()">-->
                               <%  
                                    }    
                                        
                               }
                            }   
                               %> 
          </div>  
          <script>
            function getTableData(){
               // alert("  getTableData called");
                //var arrdata=[];
                var row=$("#itemtable tr").each(function(){
                    var currentRow=$(this);
                    
                     var col_1=currentRow.find(" td:eq(0)").text();
                     var col_2=currentRow.find(" td:eq(1)").text();
                     var col_3=currentRow.find(" td:eq(2)").text();
                     var col_4=currentRow.find(" td:eq(3)").text();
                     var col_5=currentRow.find(" td:eq(4)").text();
                     var col_6=currentRow.find(" td:eq(5)").text();
                     var col_7=currentRow.find(" td:eq(6)").text();
                     
                   var  arrdata=new array["1":col_1,"2":col_2,"3":col_3,"4":col_4,"5":col_5,"6":col_6];

            )};  
        }
          </script>
        </center>
    </body>
</html>
