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
	ArrayList<ArrayList<String>> arr = (ArrayList<ArrayList<String>>)(session.getAttribute("arr"));

	arr.clear();
	arr = (ArrayList<ArrayList<String>>)(session.getAttribute("arr2"));
	
%>




<div class="centerNames">
	<p><input type='text' value='name1' id='name1'></p>
	<p><input type='text' value='name2' id='name2'></p>
	<p><input type='text' value='name3' id='name3'></p>

	<input type='button' value='ADD' onclick="addStr()">
	<input type='button' value='DELETE' onclick="deleteStr()">
	
</div>

<form method="post" id= 'save' action="save">				
		<div class="center">
			<table id = 'myTable' border="1" width="600">
					<!--<tr>
						<th>idStudents</th>
						<th>First_Name</th>
						<th>Last_Name</th>
					</tr> -->
					<%
						String inp = "";
						for(int i = 0; i < arr.size(); i++)
						{
					%>
							<tr>
							<%
							for(int j = 0, c = 1; j < arr.get(i).size(); j++, c++)
							{
								if ( c % 3 == 0 ) { inp = inp + arr.get(i).get(j) + ";"; }
								else if (i == arr.size() - 1 && j == arr.get(arr.size() - 1).size() - 1) { inp = inp + arr.get(i).get(j); }
								else { inp = inp + arr.get(i).get(j) + ","; }
							%>
							<td><%= arr.get(i).get(j)%></td>
							<%
							}
							%>
							</tr>
					<%
						}
					%>
			</table>
		</div>
	<input type='text' value='<%=inp%>' name='myArr' id='myArr'>
	<input type='button' value='save' onclick='save()'>
</form>




<script>
let cells = [];
var cell_index = 0;
var vs =  document.getElementById('myArr').value.replace(/;/g, ',').split(',');

for (var i = 0; i < vs.length - 1; i++)
{
	cells[cell_index++] = vs[i];
}

function addStr() {
	
    var table = document.getElementById('myTable');
    var addTr = document.createElement("tr");
	divCont = document.getElementById('container');

	var n1 = document.getElementById("name1").value;
	var n2 = document.getElementById("name2").value;
	var n3= document.getElementById("name3").value;
	
	let names = [n1, n2, n3];
	for (var i = 0; i < 3; i++) 
	{
		var addTd = document.createElement("td");
		
		cells[cell_index] = names[i];
		if (i == 2) { document.getElementById("myArr").value = document.getElementById("myArr").value + cells[cell_index++]; }
		else { document.getElementById("myArr").value = document.getElementById("myArr").value + cells[cell_index++] + ','; }
		
		addTd.innerHTML = names[i];
		addTr.appendChild(addTd);
		table.appendChild(addTr);
	}
	document.getElementById("myArr").value = document.getElementById("myArr").value + ';';
}

function deleteStr() {
	document.getElementById("myArr").value = "";
	for (var i = 0, c = 1; i < cells.length - 3; i++, c++)
	{
		if (c % 3 == 0) { document.getElementById("myArr").value = document.getElementById("myArr").value + cells[i] + ';'; }
		else if (i == cells.length - 4) { document.getElementById("myArr").value = document.getElementById("myArr").value + cells[i]; }
		else { document.getElementById("myArr").value = document.getElementById("myArr").value + cells[i] + ','; }
	}
    var table = document.getElementById('myTable');
    table.deleteRow(-1);
	
	if (cell_index > 0 ) 
	{ 
		cell_index = cell_index - 3;
		for (var i = 0; i < 3; i++) { cells.pop(); }
	}
	
}

function save() {
	document.getElementById("save").submit();
}
</script>







</html> 