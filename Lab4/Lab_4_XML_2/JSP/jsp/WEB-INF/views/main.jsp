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


<div class="centerNames">
	<p><input type='text' value='name1' id='name1'></p>
	<p><input type='text' value='name2' id='name2'></p>
	<p><input type='text' value='name3' id='name3'></p>

	<input type='button' value='ADD' onclick="addStr()">
	<input type='button' value='DELETE' onclick="deleteStr()">
</div>

			
<div class="center">
	<table id = 'myTable' border="1" width="600">
	</table>
</div>
<input type='button' value='save' onclick='save()'>





<script>
// ВЫВОД МАССИВА ИЗ БД
// {
let cells = [];
var cell_index = 0;

var xhr = new XMLHttpRequest();
xhr.open("POST", "http://localhost:8080/app/Enter", true);
xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	
xhr.onreadystatechange = function () 
{
     if (xhr.readyState == 4 && xhr.status == 200)
	{
		// Получаем массив из БД
		cellsString = xhr.getResponseHeader("cellsString").replace(/;/g, ',').split(',');
			
		// Считаем кол-во строк
		var size = 0;
		var size = xhr.getResponseHeader("cellsString").split(';').length - 1;
			
		var table = document.getElementById('myTable');
		var ind = 0;
			
		for (var i = 0; i < size; i++) 
		{
			var addTr = document.createElement("tr");
			for (var j = 0; j < 3; j++)
			{
				cells[cell_index] = cellsString[ind++];
		
				var addTd = document.createElement("td");
		
				addTd.innerHTML = cells[cell_index++];
				addTr.appendChild(addTd);
				table.appendChild(addTr);
			}
		}
	}
	else
	{
		document.getElementById("output").innerHTML= "NOT OK: " + xhr.readyState + " " + xhr.status;
	}
}

xhr.send("name=name1&sername=sername1");
// }

function addStr() {
	
    var table = document.getElementById('myTable');
    var addTr = document.createElement("tr");

	var n1 = document.getElementById("name1").value;
	var n2 = document.getElementById("name2").value;
	var n3 = document.getElementById("name3").value;
	
	let names = [n1, n2, n3];
	for (var i = 0; i < 3; i++) 
	{
		var addTd = document.createElement("td");
		
		cells[cell_index++] = names[i];
		
		addTd.innerHTML = names[i];
		addTr.appendChild(addTd);
		table.appendChild(addTr);
	}
}

function deleteStr() {
    var table = document.getElementById('myTable');
    table.deleteRow(-1);
	
	if (cell_index > 0 ) 
	{ 
		cell_index = cell_index - 3;
		for (var i = 0; i < 3; i++) { cells.pop(); }
	}
	
}

function save() {
	var cellsString = "";
	for (var i = 0; i < cells.length; i++)
	{
		if ((i+1) % 3 == 0) cellsString = cellsString + cells[i] + ';';
		else cellsString = cellsString + cells[i] + ",";
	}
	
	// Очищаем массив ячеек
	cells.length = 0;
	// Очищаем html-таблицу
	var table = document.getElementById('myTable');
	while(table.rows.length > 0) 
	{
		table.deleteRow(0);
	}

	var xhrreq = new XMLHttpRequest();
	xhrreq.open("POST", "http://localhost:8080/app/Enter", true);
	xhrreq.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");

	// Отправляем массив ячеек в виде строки
	xhrreq.setRequestHeader("cellsString", cellsString);
	// Говорим сервлету, что мы находимся в функции save
	xhrreq.setRequestHeader("key", "true");

	xhrreq.onreadystatechange = function () 
	{
		if (xhrreq.readyState == 4 && xhrreq.status == 200)
		{
			result = xhrreq.getResponseHeader("cellsString").replace(/;/g, ',').split(',');
			

			var size = 0;
			var size = xhrreq.getResponseHeader("cellsString").split(';').length - 1;
		
			var ind = 0;
			cell_index = 0;
			
			for (var i = 0; i < size; i++) 
			{
				var addTr = document.createElement("tr");
				for (var j = 0; j < 3; j++)
				{
					cells[cell_index] = result[ind++];
		
					var addTd = document.createElement("td");
		
					addTd.innerHTML = cells[cell_index++];
					addTr.appendChild(addTd);
					table.appendChild(addTr);
				}
			}
		
		
		}
		else
		{
			// alert("NOT OK: " + xhrreq.readyState + " " + xhrreq.status);
		}
	}

	xhrreq.send("name=name1&sername=sername1");
}
</script>







</html> 