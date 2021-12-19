import * as manager from "../../Controller/manager.js";

function addStr()
{
		let table = document.getElementById('myTable');
		let addTr = document.createElement("tr");

		let n1 = document.getElementById("name1").value;
		let n2 = document.getElementById("name2").value;
		let n3 = document.getElementById("name3").value;
	
		let names = [n1, n2, n3];
		for (var i = 0; i < 3; i++) 
		{
			var addTd = document.createElement("td");
		
			manager.cellsJSON.cells[manager.cellsJSON.cell_index++] = names[i];
		
			addTd.innerHTML = names[i];
			addTr.appendChild(addTd);
			table.appendChild(addTr);
		}
	
}

export {addStr}