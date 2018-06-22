/*!
 * Start Bootstrap - SB Admin v4.0.0-beta (https://startbootstrap.com/template-overviews/sb-admin)
 * Copyright 2013-2017 Start Bootstrap
 * Licensed under MIT (https://github.com/BlackrockDigital/startbootstrap-sb-admin/blob/master/LICENSE)
 */
$(document).ready(function(){$("#dataTable").DataTable();});
function tableOrder(idx, ord){
	var order = ord == 0 ? 'asc' : 'desc';
	$("#dataTable").DataTable().order([idx, order]).draw();
}