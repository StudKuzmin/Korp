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

<%
	ArrayList<ArrayList<String>> arr = (ArrayList<ArrayList<String>>)(request.getAttribute("arr")); 
%>
 

<form method="post" action="add">
	col1<input type='text' name='col1'>
	col2<input type='text' name='col2'>
	<div class="centerNames">
		<p><input type="submit" value="add"></p>
</form>
<form method="post" action="del">
		<input type="submit" value="del">
		<input type='text' name='idDel'>
		<%
			if (request.getAttribute("id") != null) 
			{
				int idDel = (int)(request.getAttribute("id"));
				arr.remove(idDel - 1);
			}
		%>
	</div>
</form>

<div class="center">
<%
	for (int i = 0; i < arr.size(); i++) 
	{
		for (int j = 0; j < arr.get(i).size(); j++)
		{
%>
			<%= arr.get(i).get(j)%>
<%
		}
%>
	<p></p>
<%
	}
%>
</div>


</html> 