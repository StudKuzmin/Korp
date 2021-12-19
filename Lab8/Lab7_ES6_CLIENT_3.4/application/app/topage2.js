import {page2} from "./page2.js";

export function top2()
{
	document.getElementById("top2").onclick = () => { document.body.innerHTML = page2; }
}
//top2();