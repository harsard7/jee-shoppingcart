<%-- 
    Document   : TestJsp
    Created on : Jun 22, 2018, 10:12:55 AM
    Author     : Hafees
--%>

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
        <title>Pagination</title>
    </head>
    <body>
        <h1>Hello World!</h1>
       
        <%  
          
String spageid=request.getParameter("page"); 
  if(spageid==null){
  spageid="1";
  }
int pageid=Integer.parseInt(spageid);  
int pageid1=Integer.parseInt(spageid);  
int total=5;  
if(pageid==1){}  
else{  
    pageid=pageid-1;  
    pageid=pageid*total+1;  
}  
ItemRepository itemrepo=(ItemRepository)RepositoryFactory.getInstance().getRepository(CONSTANTSTYPE.ITEM);
int itemCount=itemrepo.getAllItemwcount();
List<Item> list=itemrepo.getAllItemwithlimit(pageid,total);  
  
out.print("<h1>Page No: "+spageid+"</h1>");  
out.print("<table border='1' cellpadding='4' width='60%'>");  
out.print("<tr><th>Id</th><th>Name</th><th>Salary</th>");  
for(Item e:list){  
  %>
  <tr>
      <td><%=e.getId()%></td>
      <td><%=e.getCatid()%></td>
      <td><%=e.getDescription()%></td>
      <td><%=e.getId()%></td>
  </tr>
<%  
} 
%>
        </table>
<a href="view.jsp?page=1">1</a>  
<a href="view.jsp?page=2">2</a>  
<a href="view.jsp?page=3">3</a><br>
<%
    int pagecoount=itemCount/5;
    int pagecoounts=itemCount%5;
    if(pagecoounts>0){
    pagecoount+=1;
    }else{
    
    }
    for (int i = 1; i < pagecoount+1; i++) {
        
        if(pageid1==i){
            
        %>
        <a style="color: red" href="view.jsp?page=<%=i%>"><%=(i)%></a> &nbsp; 
        <%
        }else{
       
        %>
        <a href="view.jsp?page=<%=i%>"><%=(i)%></a> &nbsp; 
        <%
         }
       %>
      
       
    <%
    }
%>    
    
    
    </body>
</html>
