<%-- 
    Document   : NewCustomer
    Created on : Jun 17, 2018, 9:45:31 PM
    Author     : Hafees
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Customer Registration</title>
        <script type="text/javascript" src="js/Calendar3.js"></script>
       
    </head>
    <body>
    <center>
        <h3> Register Now</h3>
         <br>
         <lagend>
             <%if(request.getParameter("error")!=null){
                if(request.getParameter("error").equals("1")){
                %>
                <h2 style="color: orange">password Does not match</h2>
               
                <%
                }else if(request.getParameter("error").equals("2")){
                %>
                 <h2 style="color: red"> Please  try Another Username </h2>
                <%
                }
                }
                %>
         </lagend>
         <form action="http://localhost:11839/ShoppingCart/CustomerServletController" method="post">
            <table>
                <tr>
                    <td>
                        User Name:
                    </td>
                    <td>
                        <input type="text" name="name">
                    </td>
                </tr>
                <tr>
                    <td>
                        PassWord:
                    </td>
                    <td>
                        <input type="password" name="password">
                    </td>
                </tr><tr>
                    <td>
                        Confirm Password:
                    </td>
                    <td>
                        <input type="password" name="confirmpassword">
                    </td>
                </tr><tr>
                    <td>
                        Gender:
                    </td>
                    <td>
                        Male:<input type="radio" name="gender" value="male">
                        FeMale:<input type="radio" name="gender" value="female">
                    </td>
                </tr><tr>
                    <td>
                        Birth Day:
                    </td>
                    <td>
                        <input type="text" name="dob" onclick="new Calendar().show(this);">
                    </td>
                </tr>
                <tr>
                    <td>
                        Contact:
                    </td>
                    <td>
                        <input type="text" name="contact"">
                    </td>
                </tr>
                <tr>
                    <td>
                        <input type="submit" value="Register">
                    </td>
                </tr>
            </table>
        </form>
    </center>
       
    </body>
</html>
