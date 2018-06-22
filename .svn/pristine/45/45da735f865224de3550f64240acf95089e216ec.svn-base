<%@ page import="com.graction.lumi.util.format.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false" contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="java.util.stream.Stream"%>
<%@ page import="com.graction.lumi.data.*"%>
<%@ page import="com.graction.lumi.model.response.*"%>
<%@ page import="com.graction.lumi.model.vo.WeatherVO"%>
<%@ page import="com.graction.lumi.model.xml.weather.*"%>
<%
	Map<String, Object> map = (Map<String, Object>) request.getAttribute(DataStorage.Attribute.ATTR_MAP);
%>
<div class="card-header">
	<i class="fa fa-table"></i> Weather Information
</div>
<div class="card-body">
	<div class="table-responsive">
		<table class="table table-bordered dataTable "
			width="100%" cellspacing="0" role="grid"
			aria-describedby="dataTable_info" style="width: 100%;">
			<%
				Stream<String> stream = map.keySet().stream().sorted();
				for (Iterator<String> it = stream.iterator(); it.hasNext();) {
					String key = it.next().toString();
			%>
			<tr>
				<td><%=key%></td>
				<td><%=map.get(key)%></td>
			</tr>
			<%
				if(key.contains(DataStorage.Type.TYPE_STRING_WEATHER_IS_FILE)){
			%>
			<tr>
				<td><%=key%></td>
				<td>
					<input type="file" class="btn btn-default" onclick="javascript:window.history.back();" value="upload"/>		
				</td>
			</tr>
			<%
					}
				}
			%>
		</table>
		<button type="button" class="btn btn-default" onclick="javascript:window.history.back();">Back</button>
	</div>
</div>
