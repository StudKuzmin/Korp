import * as manager from "../manager.js";

export let container = (function()
{
	class Service 
	{
		// pages
		#table_PAGE = manager.table_PAGE;
		#userData_PAGE = manager.userData_PAGE;		
		
		// functions
		#to_UserDataPAGE = manager.to_UserDataPAGE;
		#to_TablePAGE = manager.to_TablePAGE;
		#addStr = manager.addStr;
		#deleteStr = manager.deleteStr;
		#save = manager.save;
		
		#func_to_UserDataPAGE() 
		{ 
			this.#to_UserDataPAGE();
			document.getElementById("to_TablePAGE").onclick = () => { this.#func_to_TablePAGE(); };
		}
		#func_to_TablePAGE()
		{
			this.#to_TablePAGE().then(
				result => 
				{
					if (result == true)
					{
						document.getElementById("save").onclick = () => {  this.#func_save();  };
						document.getElementById("addStr").onclick = () => {  this.#func_addStr();  };
						document.getElementById("deleteStr").onclick = () => {  this.#func_deleteStr();  };
					}
				}
			);
		}
		#func_save()
		{
			this.#save();
		}
		#func_addStr()
		{
			this.#addStr();
		}
		#func_deleteStr()
		{
			this.#deleteStr();
		}
		
		run()
		{
			document.getElementById("to_UserDataPAGE").onclick = () => { this.#func_to_UserDataPAGE(); };
			// this.#to_UserDataPAGE();
		}
	}
	
	return {
		start: function () { new Service().run(); }	
	}
})();

					




