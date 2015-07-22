<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style>
html {
background: url(Photos/background.jpg) no-repeat center center fixed;
-webkit-background-size: cover;
-moz-background-size: cover;
-o-background-size: cover;
background-size: cover;
}
</style>

<title>Living healthy for life</title>
</head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1251">
<br></br>
<body>
<%@ include file="Header.jsp" %>
<%@ include file="Menu.jsp" %>
<%@ include file="FirstPane.jsp" %>

<center><h1><font color = "white">It's the start that stops most people.Let's start with us.</font></h1></center>
<br></br>
<center><h2><font color = "white">Login to Web App</font></h2><center>

<form action= "Login" method="post">
<p><input type="text" name="username" value="" placeholder="Username"></p>
<p><input type="password" name="password" value="" placeholder="Password"></p>
<input type = "submit" name= "Log In" VALUE="Log In"><br>
<input type = "submit" name= "Register" VALUE="Register"><br>
<center><h3><font color = "white">About us</font></h3><center>
<center><p><font color = "white">Some large text here !</font></p></center>
<a href="http://www.w3schools.com/html/" target="_blank">Presentation of the app!</a>
<center><p><font color = "white">You can also help us by filling in our investigation in the link below.</font></p></center>
<a href="https://www.surveymonkey.com/r/K3M2MQ5" target="_blank" >CLICK HERE!</a>


</form>
<%@ include file="Footer.jsp" %>
</body>
</html> 