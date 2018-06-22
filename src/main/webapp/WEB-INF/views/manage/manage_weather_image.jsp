<%@ page import="com.graction.lumi.util.format.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false" contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="com.graction.lumi.data.*"%>
<%@ page import="com.graction.lumi.model.response.*"%>
<%@ page import="com.graction.lumi.model.vo.WeatherVO"%>
<%@ page import="com.graction.lumi.model.xml.weather.*"%>

<h1>Weather List</h1>
<hr>

<div class="card mb-3">
	<div class="card-header">
		<i class="fa fa-table"></i> Weather List
	</div>
	<div class="card-body">
		<div class="table-responsive">
			<table class="table table-bordered dataTable table-hover"
				id="dataTable" width="100%" cellspacing="0" role="grid"
				aria-describedby="dataTable_info" style="width: 100%;">
				<thead>
					<tr role="row">
 						<th class="sorting_desc" tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1" aria-label="Name: activate to sort column ascending" aria-sort="descending"><%=DataStorage.Database.Column.COLUMN_WEATHER_CODE%></th>
                        <th class="sorting" tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1" aria-label="Position: activate to sort column ascending"><%=DataStorage.Database.Column.COLUMN_WEATHER_NAME%></th>
                        <th class="sorting" tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1" aria-label="Office: activate to sort column ascending"><%=DataStorage.Database.Column.COLUMN_BACKGROUND_NAME%></th>
                        <th class="sorting" tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1" aria-label="Age: activate to sort column ascending"><%=DataStorage.Database.Column.COLUMN_CHARACTER_NAME%></th>
                        <th class="sorting" tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1" aria-label="Start date: activate to sort column ascending"><%=DataStorage.Database.Column.COLUMN_EFFECT_NAME%></th>
					</tr>
				</thead>
				<tfoot>
					<tr>
						<th rowspan="1" colspan="1"><%=DataStorage.Database.Column.COLUMN_WEATHER_CODE%></th>
						<th rowspan="1" colspan="1"><%=DataStorage.Database.Column.COLUMN_WEATHER_NAME%></th>
						<th rowspan="1" colspan="1"><%=DataStorage.Database.Column.COLUMN_BACKGROUND_NAME%></th>
						<th rowspan="1" colspan="1"><%=DataStorage.Database.Column.COLUMN_CHARACTER_NAME%></th>
						<th rowspan="1" colspan="1"><%=DataStorage.Database.Column.COLUMN_EFFECT_NAME%></th>
					</tr>
				</tfoot>
				<tbody>
					<%
						for (WeatherVO table : DataTableManager.getInstance().getDBWeatherVOList()) {
					%>
					<tr role="row"
						onclick="javascript: location.href='<%=request.getContextPath() + DataStorage.Mapping.MAPPING_MANAGE_WEATHER_IMAGE_DETAIL+"?"+DataStorage.Param.PARAM_CODE+"="+table.getWeather_code()%>';">
						<td class="sorting_1"><%=table.getWeather_code()%></td>
						<td><%=table.getWeather_name()%></td>
						<td><%=table.getBackground_img_name()%></td>
						<td><%=table.getCharacter_img_name()%></td>
						<td><%=table.getEffect_img_name()%></td>
					</tr>
					<%
						}
					%>
				</tbody>
			</table>
		</div>
	</div>
	<div class="card-footer small text-muted">Updated 2017-10-17 at 14:46 PM</div>
</div>
<script src="<%=DataStorage.Path.PATH_DIR_JS%>jquery-3.2.1.min.js"></script>
<script>
	$(function() {
		$("tbody:odd").addClass("odd");
		$("tbody:even").addClass("even");
	})
</script>