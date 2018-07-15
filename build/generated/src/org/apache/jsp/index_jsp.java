package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.ijse.shoppingcart.listeners.UserSessionListner;
import com.ijse.shoppingcart.DTO.CustomerDTO;
import com.ijse.shoppingcart.modal.Customer;
import com.ijse.shoppingcart.DTO.ItemDTO;
import com.ijse.shoppingcart.service.custom.ItemService;
import com.ijse.shoppingcart.service.ServiceFactory;
import com.ijse.shoppingcart.CONSTANTS.CONSTANTSTYPE;
import com.ijse.shoppingcart.repostory.RepositoryFactory;
import com.ijse.shoppingcart.modal.Item;
import java.util.List;
import com.ijse.shoppingcart.repostory.custom.ItemRepository;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Plaza Virtual Shopping</title>\n");
      out.write("          <link href=\"css/bootstrap.min.css\" rel=\"stylesheet\" />\n");
      out.write("        <style>\n");
      out.write("            div{\n");
      out.write("                float: left;\n");
      out.write("                margin-left: 20px;\n");
      out.write("                margin-right:  20px;\n");
      out.write("                overflow: auto;\n");
      out.write("            }\n");
      out.write("            body, html {\n");
      out.write("                background-color: crimson;\n");
      out.write("                   color: #FFFFFF;\n");
      out.write("    height: 100%;\n");
      out.write("    margin: 0;\n");
      out.write("}\n");
      out.write("\n");
      out.write(".bg {\n");
      out.write("    /* The image used */\n");
      out.write("/*    background-image: url(\"img/imagesg.jpg\");*/\n");
      out.write("\n");
      out.write("    /* Full height */\n");
      out.write("    height: 100%; \n");
      out.write("\n");
      out.write("    /* Center and scale the image nicely */\n");
      out.write("    background-position: center;\n");
      out.write("    background-repeat: no-repeat;\n");
      out.write("    background-size: cover;\n");
      out.write("}\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <body class=\"bg\">\n");
      out.write("      \n");
      out.write("        ");

          // request.getSession().setAttribute("latestURL",request.getRequestURI());
        
      out.write("\n");
      out.write("    <center>\n");
      out.write("         ");

            ItemService itemservice=(ItemService)ServiceFactory.getInstance().getService(CONSTANTSTYPE.ITEM);
                List<ItemDTO>itemlist=itemservice.showAll();
                
                if(itemlist!=null){
                    System.out.println("   index jsp 1");
                   
                    if(request.getSession(false).getAttribute("user")!=null){
                        System.out.println("   index jsp 2");
                        CustomerDTO customer=(CustomerDTO)request.getSession(false).getAttribute("user");
        
      out.write("\n");
      out.write("        \n");
      out.write("        <table>\n");
      out.write("            <tr>\n");
      out.write("       \n");
      out.write("       \n");
      out.write("        <td><input type=\"button\" value=\"View Customer Information\"   class=\"btn btn-primary\" onclick=\"location.href='customerinfo.jsp'\"></td>\n");
      out.write("        <td><input type=\"button\" value=\"View Customer Cart\"   class=\"btn btn-info\"   onclick=\"location.href='Mycart.jsp'\"></td>\n");
      out.write("        <td><input type=\"button\" value=\"Logout\"  class=\"btn btn-info\" onclick=\"location.href='LogoutServlet'\"></td>\n");
      out.write("        <td style=\"color: black;font-size: 20px\">");
      out.print(UserSessionListner.getActiveUserCount());
      out.write(" peoples are viewing this web site</td> \n");
      out.write("        <h1>Welcome ");
      out.print(customer.getName());
      out.write("</h1>\n");
      out.write("        ");

                }else{
        
      out.write("\n");
      out.write("        <td><input type=\"button\" value=\"LogIn\"  class=\"btn btn-info\" onclick=\"location.href='signin.jsp'\"</td>\n");
      out.write("        <td style=\"color: black;font-size: 20px\">");
      out.print(UserSessionListner.getActiveUserCount());
      out.write(" peoples are viewing this web site</td>\n");
      out.write("        <td></td>\n");
      out.write("        <td></td>\n");
      out.write("        <td></td>\n");
      out.write("          <h1>Welcome</h1>\n");
      out.write("        ");

            }
//UserSessionListner.getActiveUserCount()
            if(UserSessionListner.getActiveUserCount()>0){
             
      out.write("\n");
      out.write("             <td style=\"color: black;font-size: 20px\">");
      out.print(UserSessionListner.getActiveUserCount());
      out.write(" peoples are viewing this web site</td>    \n");
      out.write("        ");

           }else{}
        
      out.write("    \n");
      out.write("       \n");
      out.write("      </tr>           \n");
      out.write("    </table>\n");
      out.write("    \n");
      out.write("      \n");
      out.write("      ");
  
          
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
           
      out.write("   \n");
      out.write("<!--      Item list-->\n");
      out.write("<table width=\"1000\" height=\"60\">\n");
      out.write("\n");
      out.write("    <tr>\n");
      out.write("        <td>\n");
      out.write("            ");

                System.out.println("getMaxInactiveInterval()  == "+request.getSession(false).getMaxInactiveInterval());
                for (Item item : list) {
             
      out.write("  \n");
      out.write("             <div>\n");
      out.write("<!--                 discription list-->\n");
      out.write("                 <dl>\n");
      out.write("                     <dt>\n");
      out.write("                         <a\n");
      out.write("                             href=\"ItemDetails.jsp?id=");
      out.print(item.getId());
      out.write("\">\n");
      out.write("                             <img src=\"img/");
      out.print(item.getImage());
      out.write(".jpg\" width=\"400\" height=\"350\" border=\"3\" alt=\"");
      out.print(item.getDescription());
      out.write("\"/>\n");
      out.write("                     </a>\n");
      out.write("                     </dt>\n");
      out.write("                     <dd><B>");
      out.print(item.getDescription());
      out.write("</B></dd>\n");
      out.write("                     <dd><B>Price:Rs ");
      out.print(item.getPrice());
      out.write("0</B></dd>\n");
      out.write("                     <dd><B>Stock:");
      out.print(item.getQty());
      out.write("&nbsp;available</B></dd>\n");
      out.write("                 </dl>\n");
      out.write("             </div>\n");
      out.write("                 \n");
      out.write("           ");

               }
            }
          
      out.write("\n");
      out.write("        </td>\n");
      out.write("    </tr>\n");
      out.write("    \n");
      out.write("</table>\n");
      out.write("        ");

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
            
        
      out.write("\n");
      out.write("        <a style=\"color:white;font-size: 40px\" href=\"index.jsp?page=");
      out.print(i);
      out.write("\"><B>");
      out.print((i));
      out.write("</B></a> &nbsp; \n");
      out.write("        ");

        }else{
       
        
      out.write("\n");
      out.write("        <a style=\"font-size: 40px\" href=\"index.jsp?page=");
      out.print(i);
      out.write("\"><B>");
      out.print((i));
      out.write("</B></a> &nbsp; \n");
      out.write("        ");

         }
       
      out.write("\n");
      out.write("      \n");
      out.write("       \n");
      out.write("    ");

    }

      out.write("    \n");
      out.write("      </center>\n");
      out.write("      \n");
      out.write("    <div style=\"position: fixed\">\n");
      out.write("          <p class=\"copyright\">&copy; 2018  All Rights Reserved | Design by <a href=\"https://w3layouts.com/\" target=\"_blank\">Plaza</a></p>\n");
      out.write("      </div>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
