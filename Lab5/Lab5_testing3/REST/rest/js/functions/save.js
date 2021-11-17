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
	
	// Очищаем массив ячеек
	// cells.length = 0;
	// Очищаем html-таблицу
	// var table = document.getElementById('myTable');
	// while(table.rows.length > 0) 
	// {
		// table.deleteRow(0);
	// }
	
	fetch('/app/api/changeArray', {method: 'POST', headers: {'Content-Type': 'application/json;charset=utf-8'},body: JSON.stringify(cellsJSON)})
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