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
	//ArrayList<String> arrValueInp = new ArrayList<String>();
	
	//int curInpId = (int)(request.getAttribute("curInpId"));
	
	// ArrayList<Integer> arrInpID = new ArrayList<Integer>();
	// for (int i = 0; i < 3; i++)
	// {
		// arrInpID.add(curInpId++);
	// }
%>

<script>
var countName = 0;
var divCont = document.getElementById('container');
function addStr() {
    var table = document.getElementById('myTable');
    var addTr = document.createElement("tr");
	divCont = document.getElementById('container');
    //var addTd = document.createElement("td");

	var n1 = document.getElementById("name1").value;
	var n2 = document.getElementById("name2").value;
	var n3= document.getElementById("name3").value;
	
	let names = [n1, n2, n3];
	//for (var c = 0; c < 3; c++) {
	<% for (int i = 0; i < 3; i++ )
	{
	%>
		var addTd = document.createElement("td");
		
		var input = document.createElement("input");
		input.setAttribute("type", "hidden");
		input.setAttribute("name", countName);
		input.setAttribute("value", names[<%=i%>]);
		document.getElementById("counterInpID").value = countName++;
		divCont.appendChild(input);

		addTd.innerHTML = names[<%=i%>];
		addTr.appendChild(addTd);
		table.appendChild(addTr);
	<%
	}
	%>
	//}
}

</script>
<script>
function deleteStr() {
	for(var i = 1; i <= 3; i++)
	{
		var b = document.getElementsByName(countName-i);
		divCont.parentNode.removeChild(b);
	}
    var table = document.getElementById('myTable');
    table.deleteRow(-1);
	countName = countName - 2;
}
</script>


<div class="centerNames">
	<p><input type='text' value='name1' id='name1'></p>
	<p><input type='text' value='name2' id='name2'></p>
	<p><input type='text' value='name3' id='name3'></p>

	<input type='button' value='ADD' onclick="addStr()">
	<input type='button' value='DELETE' onclick="deleteStr()">
	
</div>

<form method="post" action="save">
	<div id="container">
	 
	</div>
		<input type='hidden' id='counterInpID' name='counterInpID'>
			<div class="center">
				<table id = 'myTable' border="1" width="600">
					<tr>
						<th>idStudents</th>
						<th>First_Name</th>
						<th>Last_Name</th>
					</tr>
					<%
						for(int i = 0; i < arr.size(); i++)
						{
					%>
							<tr>
							<%
							for(int j = 0; j < arr.get(i).size(); j++)
							{
							%>
								<td><%= arr.get(i).get(j)%></td>
							<%		
							}		
							%>
							<tr>
					<%
						}
					%>
			
			
				</table>
			</div>
		<input type='submit' value='save'>
</form>


</html> 