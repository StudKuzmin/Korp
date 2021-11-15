function to_TablePAGE()
{
	let std1 = {
		log: document.getElementById('log').value,
		pas: document.getElementById('pas').value
	};
	// std1.log = document.getElementById('log').value;
	// std1.pas = document.getElementById('pas').value;
  
	let userData = [std1];
	
	
	fetch('/app1/api/userData', {method: 'POST', headers: {'Content-Type': 'application/json;charset=utf-8'},body: JSON.stringify(userData)})
	.then(function(response) 
	{
		//alert(JSON.stringify(userData));
		return response.text();
		
	})
    .then(function(data) 
	{
		//alert(data);
		if (data == "true")
			document.body.innerHTML = table_PAGE;
		else
		{
			alert("Invalid data, try again!");
			document.body.innerHTML = userData_PAGE;
		}
	});
};