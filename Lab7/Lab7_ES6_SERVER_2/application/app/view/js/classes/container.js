var container = (function()
{
	var cells = [];
	var cell_index = 0;

	pages = {
		table_PAGE: 
				"<link rel='stylesheet' href='./view/css/classes.css' type='text/css'/>"+
			
				"<html>"+
					"<div class='centerNames'>"+
						"<p><input type='text' value='name1' id='name1'></p>"+
						"<p><input type='text' value='name2' id='name2'></p>"+
						"<p><input type='text' value='name3' id='name3'></p>"+
			
						"<input type='button' value='ADD' onclick='service.table.addStr()'>"+
						"<input type='button' value='DELETE' onclick='service.table.deleteStr()'>"+
						"<p><input type='button' value='save' onclick='service.table.save()' style='height:30px; width:100px'><p>"+
					"</div>"+
			
					"<div class='center'>"+
						"<table id = 'myTable' border='1' width='600'>"+
						"</table"+
					"</div>"+
				"</html>",
				
		userData_PAGE:
					"<link rel='stylesheet' href='./view/css/classes.css' type='text/css'/>"+

					"<html>"+
						"<div class='center'>"+
							"LOGIN <p><input type='text' name='log' id='log' ></p>"+
							"PASSWORD <p><input type='text' name='pas' id='pas' ></p>"+
							"<p><input type='button' value='next' onclick='service.table.to_TablePAGE()' style='height:30px; width:50px' /></p>"+
						"</div>"+
					"</html>"
	};
	
	functions = {
		addStr:
				function addStr()
				{
					var table = document.getElementById('myTable');
					var addTr = document.createElement("tr");

					var n1 = document.getElementById("name1").value;
					var n2 = document.getElementById("name2").value;
					var n3 = document.getElementById("name3").value;
	
					var names = [n1, n2, n3];
					for (var i = 0; i < 3; i++) 
					{
						var addTd = document.createElement("td");
		
						cells[cell_index++] = names[i];
		
						addTd.innerHTML = names[i];
						addTr.appendChild(addTd);
						table.appendChild(addTr);
					}
				},
				
		deleteStr:
				function deleteStr()
				{
					var table = document.getElementById('myTable');
					table.deleteRow(-1);
	
					if (cell_index > 0 ) 
					{ 
						cell_index = cell_index - 3;
						for (var i = 0; i < 3; i++) { cells.pop(); }
					}
				},

		save:
				function save()
				{
					var cellsJSON = [];
					for (var i = 0; i < cells.length - 2; i+=3)
					{
						cellsJSON.push(
							{
								id: cells[i],
								first_Name: cells[i+1],
								last_Name: cells[i+2]
							}
						);
					}
	

					fetch('/ap/api/changeArray', {method: 'POST', headers: {'Content-Type': 'application/json;charset=utf-8'},body: JSON.stringify(cellsJSON)})
					.then(function(response) 
					{
						return response.text();
					})
					.then(function(data) 
					{
						if (data == "true")
							alert("the data is saved!");
						else
							alert("ERROR " + data);
					});
				},

		to_TablePAGE:
				function to_TablePAGE()
				{
					let std1 = {
						log: document.getElementById('log').value,
						pas: document.getElementById('pas').value
					};
  
					let userData = [std1];
	
					Promise.all([
						fetch('/ap/api/userData', {method: 'POST', headers: {'Content-Type': 'application/json;charset=utf-8'},body: JSON.stringify(userData)}).then(response => response.text()),
						fetch('/ap/api/showArray', {method: 'POST'}).then(response => response.json())
					])
					// .then(function(allResponses) 
					// {
					// return allResponses[0].text();
					// return allResponses[1].json();
					// })
					.then(function(data) 
					{
						key = data[0];
						students = data[1]
						if (key == "true")
						{
							document.body.innerHTML = pages.table_PAGE;
							createTable(students);
						}
						else
						{
							alert("Invalid data, try again!");
							document.body.innerHTML = pages.userData_PAGE;
						}
					});
	
	
					function createTable(students)
					{
						var table = document.getElementById('myTable');
						var studentsSize = students.length;
	
						for (var i = 0; i < studentsSize; i++) 
						{
							var addTr = document.createElement("tr");
							cells.push(students[i].id, students[i].first_Name, students[i].last_Name);
							for (var j = 0; j < 3; j++)
							{
								var addTd = document.createElement("td");
		
								addTd.innerHTML = cells[cell_index++];
								addTr.appendChild(addTd);
								table.appendChild(addTr);
							}
		
						}
					}
				},
				
		to_UserDataPAGE:
				function to_UserDataPAGE()
				{
					document.body.innerHTML = pages.userData_PAGE;
				}
	};
	
	return {
		table: {
			to_TablePAGE: function() { functions.to_TablePAGE(); },
			addStr: function() { functions.addStr(); },
			deleteStr: function() { functions.deleteStr(); },
			save: function() { functions.save(); }
		},
		user: {
			to_UserDataPAGE: function() { functions.to_UserDataPAGE(); }
		}
	}
})();





					




