<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Fitness</title>


</head>
<body>
 <%@ include file="Header.jsp" %>
 <%@ include file="Menu.jsp" %>
 <%@ include file="FirstPane.jsp" %>

<br></br> 
<br></br>
<br></br>
<br></br>
<br></br>
<center><h1><b>User Info</b></h1></center>

<br></br>
<form action = "UserInfo" method = "post" >

<center><table>
<tr>
<td><b>Gender:</b></td>
<td><select name="Gender">
<option>Male</option>
<option>Female</option>
</select></td>
</tr>


<tr><td><b>Weight(in kilograms):</b></td><td><input type="number" name="weight"/></td></tr>
<tr><td><b>Height (in santimeters):</b></td><td><input type="number" name="height"/> </td></tr>
<tr><td><b>Age:</b></td><td><input type="number" name="age"/> </td></tr>

</table>
<br></br>
<b>Input activity level</b>

<select name="ActivityLevel">
<option>Rarely exercise</option>
<option>Light exercise (1-3 hours)</option>
<option>Moderate exercise (3-5 hours)</option>
<option>Strenuous esercise  (5-6 hours)</option>
<option>Strenuous esercise  (7-21 hours)</option>
</select>
<br></br>

<b>What is your aim? </b>
<select name="Goal">
<option>Clean bulk</option>
<option>Gain muscle, lose fat</option>
<option>Lose fat - 5%</option>
<option>Lose fat - 10%</option>
<option>Lose fat - 15%</option>
<option>Lose fat - 20%</option>
<option>Lose fat - 25%</option>
</select>
<br>
</table>
</center>
<br>
<center><input type="submit" value="Submit" onclick="location.href='yourpage.html'" /></center><br>
<center><input type="button" value="Discard changes" onclick="location.href='yourpage.html'" /></center>
</form>
<%@ include file="Footer.jsp" %>
   
</body>
</html> 