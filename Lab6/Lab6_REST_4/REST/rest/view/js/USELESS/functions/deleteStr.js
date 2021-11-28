function deleteStr()
{
	var table = document.getElementById('myTable');
    table.deleteRow(-1);
	
	if (cell_index > 0 ) 
	{ 
		cell_index = cell_index - 3;
		for (var i = 0; i < 3; i++) { cells.pop(); }
	}
}