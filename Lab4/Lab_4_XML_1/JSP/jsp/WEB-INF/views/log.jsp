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

<div class="center">
	<form method="post" action="Enter">
		LOGIN <p><input type='text' name='log' id='log' ></p>
		PASSWORD <p><input type='text' name='pas' id='pas' ></p>
		<p><input type='submit' value='next' <!--onclick="next()" --> style="height:30px; width:50px"/></p>
	</form>
</div>

<script>
// объект для отправки
// function next() 
// {
	// var login = document.getElementById("log").value;
	// var password = document.getElementById("pas").value;
	
	// var request = new XMLHttpRequest();
	// request.open("POST", "http://localhost:8080/app/login", true);
	// request.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	
	// request.onreadystatechange = function () 
	// {
        // if (request.readyState == 4 && request.status == 200)
		// {

		// }
		// else
		// {
			
		// }
	// }

	// request.send("login=" + login + "&password=" + password);
}
</script>

</html> 