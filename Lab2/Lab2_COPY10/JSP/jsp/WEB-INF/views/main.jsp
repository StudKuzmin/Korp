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
	  Boolean key1 = false;
	  if (request.getAttribute("key1") != null) { key1 = (Boolean)(request.getAttribute("key1")); }
     %>   
	<% 
	if (key1 == true) { for (int i = 0; i < arr.size(); i++)
		{
	%>
     <%= arr.get(i)%>
	 <p></P>
	 <% 
		}
	}
	%>
</div>

col 1
<input type='text' name='text1'>
col 2
<input type='text' name='text2'>

<div class="centerNames"> 
     <input type="submit" value="add"></td>
</div>
  </form>
  <%=str%>

  <form method="post" action="del">
	<input type='number' name='numDel' min='1'>
	<div class="center">
	<%
	Boolean key2 = false;
	if (request.getAttribute("key2") != null) { key2 = (Boolean)(request.getAttribute("key2")); }
	if (key2 == true) {
		for (int i = 0; i < arr.size() - 1; i++)
		{
			
	%>

			<%= arr.get(i)%>
			<p></P>
	<% 
		}
		arr.remove(arr.size() - 1);
	}
	%>
	</div>
	
     <input type="submit" value="del"></td>
	
  </form>
 </body>

</html>