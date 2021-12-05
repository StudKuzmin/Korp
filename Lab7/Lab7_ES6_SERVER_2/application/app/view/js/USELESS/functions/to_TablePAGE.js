var cells = [];
var cell_index = 0;

function to_TablePAGE()
{
	let std1 = {
		log: document.getElementById('log').value,
		pas: document.getElementById('pas').value
	};
  
	let userData = [std1];
	
	Promise.all([
	fetch('/app/api/userData', {method: 'POST', headers: {'Content-Type': 'application/json;charset=utf-8'},body: JSON.stringify(userData)}).then(response => response.text()),
	fetch('/app/api/showArray', {method: 'POST'}).then(response => response.json())
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
			document.body.innerHTML = table_PAGE;
			createTable(students);
		}
		else
		{
			alert("Invalid data, try again!");
			document.body.innerHTML = userData_PAGE;
		}
	});
	
	
	function createTable(students)
	{
		var table = document.getElementById('myTable');
		// document.body.innerHTML = students[0].id;
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
	
};
