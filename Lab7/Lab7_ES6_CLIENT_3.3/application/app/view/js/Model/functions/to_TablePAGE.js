import * as manager from "../../Controller/manager.js";

let cellsJSON = {
	cells: [],
	cell_index: 0
}

function to_TablePAGE()
{
		let std1 = {
			log: document.getElementById('log').value,
			pas: document.getElementById('pas').value
		};
  
		let userData = [std1];
	
	
		Promise.all([
		fetch('/appl/api/userData', {method: 'POST', headers: {'Content-Type': 'application/json;charset=utf-8'},body: JSON.stringify(userData)}).then(response => response.text()),
		fetch('/appl/api/showArray', {method: 'POST'}).then(response => response.json())
		])
		// .then(function(allResponses) 
		// {
			// return allResponses[0].text();
			// return allResponses[1].json();
		
		// })
		.then(function(data) 
		{
			let key = data[0];
			let students = data[1]
			if (key == "true")
			{
				document.body.innerHTML = manager.table_PAGE;
				document.getElementById("save").onclick = () => {  manager.save();  };
				document.getElementById("addStr").onclick = () => {  manager.addStr();  };
				document.getElementById("deleteStr").onclick = () => {  manager.deleteStr();  };
				createTable(students);
				
				function createTable(students)
				{
					var table = document.getElementById('myTable');
					var studentsSize = students.length;
		
	
					for (var i = 0; i < studentsSize; i++) 
					{
						var addTr = document.createElement("tr");
						cellsJSON.cells.push(students[i].id, students[i].first_Name, students[i].last_Name);
						for (var j = 0; j < 3; j++)
						{
							var addTd = document.createElement("td");
			
							addTd.innerHTML = cellsJSON.cells[cellsJSON.cell_index++];
							addTr.appendChild(addTd);
							table.appendChild(addTr);
						}
			
					}
				}
			}
			else
			{
				alert("Invalid data, try again!");
				// document.body.innerHTML = manager.userData_PAGE; 
			}
		});
}
export {cellsJSON, to_TablePAGE}