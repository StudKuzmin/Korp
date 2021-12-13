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

		// do_to_UserDataPAGE()
		// {
			// this.#to_UserDataPAGE();
		// }
		run()
		{
			// document.getElementById("to_UserDataPAGE").onclick = function() 
			// { 
				// console.log(this);
				// document.getElementById("to_TablePAGE").onclick = () => { console.log(this.#to_TablePAGE()); };
			// }
			this.#to_UserDataPAGE();
		}
	}
	
	return {
		start: function () { new Service().run(); }	
	}
})();

					




