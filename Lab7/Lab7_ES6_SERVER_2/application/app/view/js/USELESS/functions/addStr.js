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
}