import {page1} from "./page1.js";
import {top2} from "./topage2.js";

function top1()
{
	alert(a);
	document.getElementById("to_UserDataPAGE").onclick = () => { 
		document.body.innerHTML = page1; 
		top2();
	}
}
top1();