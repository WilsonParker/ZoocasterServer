<%@ page import="com.graction.lumi.util.format.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false" contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="com.graction.lumi.data.*"%>
<%@ page import="com.graction.lumi.data.DataStorage.*"%>
<%@ page import="com.graction.lumi.model.response.*"%>
<%@ page import="com.graction.lumi.model.db.*"%>

<%
	ArrayList<RegionReservationTable> list = (ArrayList<RegionReservationTable>) request.getAttribute(Attribute.ATTR_WEATHER_REGION_RESERVATION_TABLE);
%>
<h1>Region Reservation List</h1>
<hr>

<div class="card mb-3">
	<div class="card-header">
		<i class="fa fa-table"></i> Region Reservation List
	</div>
	<div class="card-body">
		<div class="table-responsive">
			<table class="table table-bordered dataTable table-hover" id="dataTable" width="100%" cellspacing="0" role="grid" aria-describedby="dataTable_info" style="width: 100%;">
				<thead>
					<tr role="row">
                        <th class="sorting" tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1" >Region</th>
                        <th class="sorting" tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1" >State</th>
                        <th class="sorting" tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1" >Prioritization</th>
                        <th class="sorting" tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1" >Set Time</th>
                        <th class="sorting" tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1" >Active Time</th>
                        <th class="sorting" tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1" >End Time</th>
 						<!-- <th class="sorting_desc" tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1" aria-label="Name: activate to sort column ascending" aria-sort="descending">Index</th> -->
                        <!-- <th class="sorting" tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1" >background_img_name</th>
                        <th class="sorting" tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1" >character_img_name</th>
                        <th class="sorting" tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1" >effect_img_name</th> -->
					</tr>
				</thead>
				<tfoot>
					<tr>
						<th rowspan="1" colspan="1">Region</th>
						<th rowspan="1" colspan="1">State</th>
						<th rowspan="1" colspan="1">Prioritization</th>
						<th rowspan="1" colspan="1">Set Time</th>
						<th rowspan="1" colspan="1">Active Time</th>
						<th rowspan="1" colspan="1">End Time</th>
						<!-- <th rowspan="1" colspan="1">Index</th> -->
						<!-- <th rowspan="1" colspan="1">background_img_name</th>
						<th rowspan="1" colspan="1">character_img_name</th>
						<th rowspan="1" colspan="1">effect_img_name</th> -->
					</tr>
				</tfoot>
				<tbody>
					<%	if(list != null)
						for (RegionReservationTable table : list) {
					%>
					<tr role="row" onclick="javascript: location.href='<%=request.getContextPath() + DataStorage.Mapping.MAPPING_MANAGE_REGION_RESERVATION_DETAIL+"?"+DataStorage.Param.PARAM_INDEX+"="+table.getRegionReservation_index()%>';">
						<td><%=table.getRegionReservation_region()%></td>
						<td><%=table.getRegionReservation_state()%></td>
						<td><%=table.getRegionReservation_prioritization()%></td>
						<td><%=table.getRegionReservation_set_time()%></td>
						<td><%=table.getRegionReservation_active_time()%></td>
						<td><%=table.getRegionReservation_end_time()%></td>
						<%-- <td class="sorting_1"><%=table.getRegionReservation_index()%></td> --%>
						<%-- <td><%=table.getRegionReservation_background_ref_file_index()%></td>
						<td><%=table.getRegionReservation_character_ref_file_index()%></td>
						<td><%=table.getRegionReservation_effect_ref_file_index()%></td> --%>
					</tr>
					<%
						}
					%>
				</tbody>
			</table>
		</div>
	</div>
	<div class="card-footer small text-muted">Updated 2017-11-16 at 16:27 PM</div>
</div>
<script src="<%=DataStorage.Path.PATH_DIR_JS%>jquery-3.2.1.min.js"></script>
<script>
	$(function() {
		// Table Sort ( column index, asc, desc);
		tableOrder(3, 1);
		$("tbody:odd").addClass("odd");
		$("tbody:even").addClass("even");
	})
</script>