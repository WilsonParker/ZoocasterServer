<%@ page import="com.graction.lumi.util.format.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false" contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="com.graction.lumi.data.*"%>
<%@ page import="com.graction.lumi.model.response.*"%>
<%@ page import="com.graction.lumi.model.xml.weather.*"%>
<%@ page import="com.graction.lumi.model.openWeather.WeatherModel"%>

<%
	Map<String, WeatherModel> map = DataTableManager.getInstance().getWeatherModelTable();
%>

<h1>Weather Cache List</h1>
<hr>

<div class="card mb-3">
	<div class="card-header">
		<i class="fa fa-table"></i> Weather Cache List
	</div>
	<div class="card-body">
		<div class="table-responsive">
			<table class="table table-bordered dataTable table-hover" id="dataTable" width="100%" cellspacing="0" role="grid" aria-describedby="dataTable_info" style="width: 100%;">
				<thead>
					<tr role="row">
 						<th class="sorting_desc" tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1" aria-sort="descending">Index</th>
 						<th class="sorting" tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1" >Latitude</th>
                        <th class="sorting" tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1" >Longitude</th>
                        <th class="sorting" tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1" >Date</th>
                        <th class="sorting" tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1" >Address</th>
                        <th class="sorting" tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1" >Weather</th>
                        <th class="sorting" tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1" >Description</th>
                        <th class="sorting" tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1" >Temperature</th>
					</tr>
				</thead>
				<tfoot>
					<tr>
						<th rowspan="1" colspan="1">Index</th>
						<th rowspan="1" colspan="1">Latitude</th>
						<th rowspan="1" colspan="1">Longitude</th>
						<th rowspan="1" colspan="1">Date</th>
						<th rowspan="1" colspan="1">Address</th>
						<th rowspan="1" colspan="1">Weather</th>
						<th rowspan="1" colspan="1">Description</th>
						<th rowspan="1" colspan="1">Temperature</th>
					</tr>
				</tfoot>
				<tbody>
				
				<%
					int i=1;
					for(String key : map.keySet()) {
						String[] latlng = key.split(DataStorage.Server.KEY_LATLNG_SPLIT);
						WeatherModel model = map.get(key);
				%>
					<tr>
						<td class="sorting_1"><%=i%></td>
						<td><%=NumberFormatManager.getInstatnce().round(latlng[0],5)%></td>
						<td><%=NumberFormatManager.getInstatnce().round(latlng[1],5)%></td>
						<td><%=DateManager.getInstance().longToDate(model.getDt())%></td>
						<td><%=model.getAddressModel().getAddress()%></td>
						<td>
							<select name="" onchange="weatherIdChange('<%=key %>',this)">
								<%
									for(Weather weather : DataStorage.weatherData.getWeathers().getWeather()){
								%>
								<option 
									<%
										if(model.getFirstWeather().getId() == weather.getId()){
									%>
								selected
									<% } %>
								value="<%=weather.getId()%>"><%=weather.getMessage()%></option>
								<% } %>
							</select>
						</td>
						<td><%=model.getFirstWeather().getDescription()%></td>
						<td><%=TemperatureManager.getInstance().kelvinToCelsius(model.getMain().getTemp())%></td>
					</tr>
				<% i++;
					} %>
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
	function weatherIdChange(key, select){
		console.log(select.value);
		$.ajax({
			url :"<%=DataStorage.Server.PACKAGE_NAME+DataStorage.Mapping.MAPPING_WEATHER_ID_CHANGE%>",
			data : {
				"<%=DataStorage.Key.KEY_WEATHER_ID%>":select.value,
				"<%=DataStorage.Key.KEY_WEATHER_KEY%>":key
					},
			complete : function(result){
				location.reload();
			}
		});
	}
</script>

<%-- <table class="table table-hover">
	<thead>
		<tr>
			<th>Latitude</th>
			<th>Longitude</th>
			<th>Date</th>
			<th>Address</th>
			<th>Weather</th>
			<th>Description</th>
			<th>Temperature</th>
		</tr>
	</thead>
	<tbody>
	<%
		for(String key : map.keySet()) {
			String[] latlng = key.split(DataStorage.Server.KEY_LATLNG_SPLIT);
			WeatherModel model = map.get(key);
	%>
		<tr>
			<td><%=NumberFormatManager.getInstatnce().round(latlng[0],5)%></td>
			<td><%=NumberFormatManager.getInstatnce().round(latlng[1],5)%></td>
			<td><%=DateManager.getInstance().longToDate(model.getDt())%></td>
			<td><%=model.getAddress()%></td>
			<td>
				<select name="" onchange="weatherIdChange('<%=key %>',this)">
					<%
						for(Weather weather : DataStorage.weatherData.getWeathers().getWeather()){
					%>
					<option 
						<%
							if(model.getFirstWeather().getId() == weather.getId()){
						%>
					selected
						<% } %>
					value="<%=weather.getId()%>"><%=weather.getMessage()%></option>
					<% } %>
				</select>
			</td>
			<td><%=model.getFirstWeather().getDescription()%></td>
			<td><%=TemperatureManager.getInstance().kelvinToCelsius(model.getMain().getTemp())%></td>
		</tr>
	<% } %>
		
	</tbody>
</table> --%>