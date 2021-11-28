
var service = (function()
{

	return {
		table: 
		{
			// to_TablePAGE: function() { to_TablePAGE(); },
			// addStr: function() { addStr(); },
			// deleteStr: function() { deleteStr(); },
			// save: function() { save(); }
			
			to_TablePAGE: function() { container.table.to_TablePAGE(); },
			addStr: function() { container.table.addStr(); },
			deleteStr: function() { container.table.deleteStr(); },
			save: function() { container.table.save(); }
			
		},
		
		user:
		{
			// to_UserDataPAGE: function() { to_UserDataPAGE(); }
			to_UserDataPAGE: function() { container.user.to_UserDataPAGE(); }
		}
	
	}
	
	
	
})(); 
