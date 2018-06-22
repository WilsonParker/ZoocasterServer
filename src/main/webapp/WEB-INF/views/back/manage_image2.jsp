<%@ page import="com.graction.lumi.util.format.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false" contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="com.graction.lumi.data.*"%>
<%@ page import="com.graction.lumi.model.response.*"%>
<%@ page import="com.graction.lumi.model.vo.WeatherVO"%>
<%@ page import="com.graction.lumi.model.xml.weather.*"%>
<%
	ArrayList<WeatherVO> list = (ArrayList<WeatherVO>) request.getAttribute(DataStorage.Attribute.ATTR_WEATHER_TABLES);
%>
<style>
	table {
		width : 100%;
		overflow-x : scroll;
	}
</style>
<table class="table table-hover">
	<thead>
		<tr>
			<th>weather_code</th>
			<th>weather_name</th>
			<th>background_root</th>
			<th>background_img_path</th>
			<th>upload</th>
			<th>character_root</th>
			<th>character_img_path</th>
			<th>upload</th>
			<th>effect_root</th>
			<th>effect_img_path</th>
			<th>upload</th>
		</tr>
	</thead>
	<tbody>
	
	
	<%
		for(WeatherVO table : list) {
	%>
		<tr>
			<td><%=table.getWeather_code()%></td>
			<td><%=table.getWeather_name()%></td>
			<td><%=table.getBackground_root()%></td>
			<td><%=table.getBackground_img_path()%></td>
			<td>
				<button>upload</button>
			</td>
			<td><%=table.getCharacter_root()%></td>
			<td><%=table.getCharacter_img_path()%></td>
			<td>
				<button>upload</button>
			</td>
			<td><%=table.getEffect_root()%></td>
			<td><%=table.getEffect_img_path()%></td>
			<td>
				<button>upload</button>
			</td>
		</tr>
	<% 
		}
	%>
	</tbody>
</table>