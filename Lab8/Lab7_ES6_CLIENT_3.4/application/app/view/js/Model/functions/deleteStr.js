import * as manager from "../../Controller/manager.js";

function deleteStr()
{
		let table = document.getElementById('myTable');
		table.deleteRow(-1);
	
		if (manager.cellsJSON.cell_index > 0 ) 
		{ 
			manager.cellsJSON.cell_index = manager.cellsJSON.cell_index - 3;
			for (var i = 0; i < 3; i++) { manager.cellsJSON.cells.pop(); }
		}
}

export {deleteStr}