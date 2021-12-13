import * as manager from "../../Controller/manager.js";

function to_UserDataPAGE()
{	
		document.getElementById("to_UserDataPAGE").onclick = () => { 
			document.body.innerHTML = manager.userData_PAGE; 
			document.getElementById("to_TablePAGE").onclick = () => {
				manager.to_TablePAGE();
			}
		}
		
		
};

export {to_UserDataPAGE}