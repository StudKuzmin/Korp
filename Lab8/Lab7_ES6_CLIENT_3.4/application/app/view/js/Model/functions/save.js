import * as manager from "../../Controller/manager.js";

export function save()
{
	console.log(manager.cellsJSON.cells);
		let cellsDataJSON = [];
		for (var i = 0; i < manager.cellsJSON.cells.length - 2; i+=3)
		{
			cellsDataJSON.push(
				{
					id: manager.cellsJSON.cells[i],
					first_Name: manager.cellsJSON.cells[i+1],
					last_Name: manager.cellsJSON.cells[i+2]
				}
			);
		}
	
		fetch('/appl/api/changeArray', {method: 'POST', headers: {'Content-Type': 'application/json;charset=utf-8'},body: JSON.stringify(cellsDataJSON)})
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
	
}