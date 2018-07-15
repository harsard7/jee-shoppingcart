<%-- 
    Document   : customerinfo
    Created on : Jun 19, 2018, 12:01:06 AM
    Author     : Hafees
--%>

<%@page import="com.ijse.shoppingcart.modal.Customer"%>
<%@page import="com.ijse.shoppingcart.DTO.CustomerDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>My Information</title>
         <link href="css/bootstrap.min.css" rel="stylesheet" />
        <style>
            body, html {
                background-color: crimson;
                   color: #FFFFFF;
                   font-family: serif;
                   font-size: 30px;
            }
        </style>
    </head>
    <body>
        <center>
        <h1>My Information</h1>
            
        <%
            CustomerDTO customer=(CustomerDTO)request.getSession(false).getAttribute("user");
            if(customer!=null){
        %>
        <table>
            <tr>
                <td><h3>User Name :</h3></td>
                <td><%=customer.getName()%></td>
            </tr>
             <tr>
                <td><h3>Gender :</h3></td>
                <td><%=customer.getGender()%></td>
            </tr>
             <tr>
                <td><h3>DOB :</h3></td>
                <td><%=customer.getDob()%></td>
            </tr>
            <tr>
                <td><h3>Contact No :</h3></td>
                <td><%=customer.getContact()%></td>
            </tr>
        </table>
            <h2> back to<a href="index.jsp"><B>Home</B></a> </h2>
          <%  
            }else{
          %>
          <h2>Please <a href="signin.jsp"><B>Login</B></a> to see Profile Information</h2>
          <%
          }
          %>
            </center>
    </body>
</html>
