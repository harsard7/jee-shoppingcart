<%-- 
    Document   : error
    Created on : Jun 21, 2018, 11:26:39 PM
    Author     : Hafees
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" isErrorPage="true"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error page</title>
        
        <style>
        body, html {
                background-color: #1769ff;
                   color: #FFFFFF;
                   font-family: sans-serif;
                   font-style: italic;
             }
       </style>
    </head>
    <body>
    <center>
        <%
            if((response.getStatus()==500)||(response.getStatus()==404)){
             %>
             <h1 style="color: red">Ooooops!!! </h1>
            <h2 style="color: crimson">Error Page</h2>
            <h3 style="color: red">Error <%=exception.getMessage()%> code:<%=response.getStatus()%></h3>
            
            <%--include login page
            <%@include file="index.jsp"%>
            --%>
             <h4>Please go to <a href="index.jsp">Home Page</a></h4>
            <%
            }else{ 
            %>
             <h1 style="color: red">Ooooops!!! </h1>
            <h2 style="color: red">Error Page</h2>
            <h3 style="color: crimson">Error code is <%=response.getStatus()%> Message: <%=exception.getMessage()%></h3>
            <h4>Please go to <a href="index.jsp">Home Page</a></h4>
       <%}%>
       </center>
    </body>
</html>
