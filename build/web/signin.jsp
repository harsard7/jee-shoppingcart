<%-- 
    Document   : signin
    Created on : Jun 22, 2018, 4:52:35 PM
    Author     : Hafees
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Plaza Virtulal Shopping</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="stylish Sign in and Sign up Form A Flat Responsive widget, Login form web template,Flat Pricing tables,Flat Drop downs  Sign up Web Templates, Flat Web Templates, Login signup Responsive web template, Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!--online_fonts-->
	<link href="//fonts.googleapis.com/css?family=Sansita:400,400i,700,700i,800,800i,900,900i&amp;subset=latin-ext" rel="stylesheet">
	<link href="//fonts.googleapis.com/css?family=Poiret+One" rel="stylesheet">
<!--//online_fonts-->
	<link href="w3login/css/style.css" rel='stylesheet' type='text/css' media="all" /><!--stylesheet-->
        <script type="text/javascript" src="js/Calendar3.js"></script>
</head>
<body>
<h1>Welcome </h1>
<div class="form-w3ls">
     <%if(request.getParameter("error")!=null){
                      if(request.getParameter("error").equals("1")){
                %>
                       <h2 style="color: red">Incorrect Password</h2>
                <%
                      }else if(request.getParameter("error").equals("2")){
                %>
                      <h2 style="color: orange">Incorrect Username or Password</h2>
                <%
                     }
                }
                %>
	<div class="form-head-w3l">
		<h2>s</h2>
	</div>
    <ul class="tab-group cl-effect-4">
        <li class="tab active"><a href="#signin-agile">Sign In</a></li>
		<li class="tab"><a href="#signup-agile">Sign Up</a></li>        
    </ul>
    <div class="tab-content">
        <div id="signin-agile">   
			<form action="CustomerLoginServletcontroller" method="post">
                            
				
				<p class="header">User Name</p>
				<input type="text" name="username" placeholder="User Name" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'User Name';}" required="required">
				
				<p class="header">Password</p>
				<input type="password" name="password" placeholder="Password" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Password';}" required="required">
				
				<input type="checkbox" id="brand" value="">
				<label for="brand"><span></span> Remember me?</label>
				
				<input type="submit" class="sign-in" value="Sign In">
			</form>
		</div>
		<div id="signup-agile">   
                     <%if(request.getParameter("error")!=null){
                if(request.getParameter("error").equals("1")){
                %>
                <h2 style="color: orange">password Does not match</h2>
               
                <%
                }else if(request.getParameter("error").equals("2")){
                %>
                 <h2 style="color: red">  User name already Existed</h2>
                <%
                }
                }
                %>
                
			<form action="CustomerServletController" method="post">
				
				<p class="header">User Name</p>
				<input type="text" name="name" placeholder="Your Full Name" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Your Full Name';}" required="required">
				
				<p class="header">Password</p>
				<input type="password" name="password" placeholder="Password" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Password';}" required="required">
				
				<p class="header">Confirm Password</p>
				<input type="password" name="confirmpassword" placeholder="Confirm Password" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Confirm Password';}" required="required">
                                
                                <p class="header">Contact No</p>
				<input type="text" name="contact" placeholder="Your Contact No" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Your Full Name';}">
                                
                                <p class="header">Gender</p>
                                <div class="radio">
                                    <label><input type="radio" name="gender">Male</label>
                                 </div>
                                 <div class="radio">
                                    <label><input type="radio" name="gender">Female</label>
                                 </div><br>
                                <div>
                                <p class="header">Date Of Birth</p>
                                 <input type="text" name="dob" onclick="new Calendar().show(this);">
                                </div><br>
                                <input style="display: none" type="text" name="hidden" value="customer">
				<input type="submit" class="register" value="Sign up">
			</form>
		</div> 
    </div><!-- tab-content -->
</div> <!-- /form -->	  
<p class="copyright">&copy; 2018  All Rights Reserved | Design by <a href="https://w3layouts.com/" target="_blank">Plaza</a></p>
<!-- js files -->
<script src="w3login/js/jquery.min.js"></script>
<script src="w3login/js/signin.js"></script>
<!-- /js files -->
</body>
</html>

