import * as manager from "../Controller/manager.js";

export const view = (function()
{
	return {
		display: function() { manager.container.start(); }
	}
})();