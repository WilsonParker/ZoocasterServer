/*$(document).ready(function() {
	var customLoaders = (function() {

		// Custom Loading modal
		$('#custom-loading').on('click', function(e) {

			// Prevent Default action
			e.preventDefault();

			// Change the default text of the loading modal
			$.modalLoader({
				displayText : "Custom Loading"
			});

			// Wait 5 seconds and then remove the loading modal
			setInterval(function() {
				$.modalLoader('close');
			}, 2000);

		});

	});

	// Lazy Load the loading modal plugin
	ux.load("modalLoader", customLoaders);

});*/

var loading_target = $('#loading-target');
var loading_input = document.getElementById("loading-css-input");

function loadingActivation(){
	loading_input.checked = true;
	loading_target.loadingOverlay();
	$("#content").css("pointer-events", "none");
}

function loadingTermination(){
	loading_input.checked = false;
	loading_target.loadingOverlay('remove');
	$("#content").css("pointer-events", "auto");
}