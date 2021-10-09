<%@ page language="java" contentType="text/html; charset=Windows-1251" pageEncoding="Windows-1251" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 <head>
  <meta http-equiv="Content-Type" content="text/html; charset=Windows-1251">
  <title>Main page</title>
 </head>
 
 
 
 
<style>
.center {
  margin: 0;
  position: absolute;
  top: 50%;
  left: 50%;
  -ms-transform: translate(-50%, -50%);
  transform: translate(-50%, -50%);
} 
</style>
<style>
.centerNames {
  margin: 0;
  position: absolute;
  top: 50%;
  left: 24%;
  -ms-transform: translate(-50%, -50%);
  transform: translate(-50%, -50%);
} 
</style>





 <body>

<div class="center">
  <form method="post" action="add">   
     <% 
      ArrayList<String> arr = (ArrayList<String>)(request.getAttribute("arr"));  
	  String str = (String)(request.getAttribute("ur"));
     %>   
	<% 
	for (int i = 0; i < arr.size(); i++)
		{
	%>
     <%= arr.get(i)%>
	 <p></P>
	 <% 
		}
	%>
</div>

<input type='text' name='text1'>
<input type='text' name='text2'>

<div class="centerNames"> 
     <input type="submit" value="add"></td>
  </form>
  <%=str%>

  <form method="post" action="del">       
     <input type="submit" value="del"></td>
  </form>
 </body>
 </div>

</html>