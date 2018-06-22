<%@ page import="com.graction.lumi.util.format.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false" contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="com.graction.lumi.data.*"%>
<%@ page import="com.graction.lumi.model.response.*"%>
<%@ page import="com.graction.lumi.model.db.*"%>

<%
	Map<String, Map<String, ArrayList<RegionTable>>> map = DataTableManager.getInstance()
			.getDBWeatherRegionTable();
%>
<table class="table table-hover">
	<thead>
		<tr>
			<th>시/도</th>
			<th>시</th>
			<th>구/군</th>
		</tr>
	</thead>
	<tbody>
		<%-- <%
		for(String key : map.keySet()) {
			Map<String, ArrayList<RegionTable>> regionMap = map.get(key);
	%> --%>
		<tr>
			<td></td>
		</tr>

	</tbody>
</table>

<div class="col-sm-4">
	<h2>Tree</h2>
	<div id="treeview-checkable" class="treeview">
		<ul class="list-group">
			<li class="list-group-item node-treeview-checkable search-result"
				data-nodeid="0" style="color: #D9534F; background-color: undefined;"><span
				class="icon expand-icon glyphicon glyphicon-minus"></span><span
				class="icon check-icon glyphicon glyphicon-unchecked"></span>Parent
				1</li>
			<li class="list-group-item node-treeview-checkable" data-nodeid="1"
				style="color: undefined; background-color: undefined;"><span
				class="indent"></span><span
				class="icon expand-icon glyphicon glyphicon-minus"></span><span
				class="icon check-icon glyphicon glyphicon-unchecked"></span>Child 1</li>
			<li class="list-group-item node-treeview-checkable node-checked"
				data-nodeid="2"
				style="color: undefined; background-color: undefined;"><span
				class="indent"></span><span class="indent"></span><span
				class="icon glyphicon"></span><span
				class="icon check-icon glyphicon glyphicon-check"></span>Grandchild
				1</li>
			<li class="list-group-item node-treeview-checkable node-checked"
				data-nodeid="3"
				style="color: undefined; background-color: undefined;"><span
				class="indent"></span><span class="indent"></span><span
				class="icon glyphicon"></span><span
				class="icon check-icon glyphicon glyphicon-check"></span>Grandchild
				2</li>
			<li class="list-group-item node-treeview-checkable" data-nodeid="4"
				style="color: undefined; background-color: undefined;"><span
				class="indent"></span><span class="icon glyphicon"></span><span
				class="icon check-icon glyphicon glyphicon-unchecked"></span>Child 2</li>
			<li class="list-group-item node-treeview-checkable node-selected"
				data-nodeid="5" style="color: #FFFFFF; background-color: #428bca;"><span
				class="icon glyphicon"></span><span
				class="icon check-icon glyphicon glyphicon-unchecked"></span>Parent
				2</li>
			<li class="list-group-item node-treeview-checkable" data-nodeid="6"
				style="color: undefined; background-color: undefined;"><span
				class="icon glyphicon"></span><span
				class="icon check-icon glyphicon glyphicon-unchecked"></span>Parent
				3</li>
			<li class="list-group-item node-treeview-checkable" data-nodeid="7"
				style="color: undefined; background-color: undefined;"><span
				class="icon glyphicon"></span><span
				class="icon check-icon glyphicon glyphicon-unchecked"></span>Parent
				4</li>
			<li class="list-group-item node-treeview-checkable" data-nodeid="8"
				style="color: undefined; background-color: undefined;"><span
				class="icon glyphicon"></span><span
				class="icon check-icon glyphicon glyphicon-unchecked"></span>Parent
				5</li>
		</ul>
	</div>
</div>



<script src="<%=DataStorage.Path.PATH_DIR_JS%>commonScript.js"></script>
<script>
	function weatherIdChange(key, select){
		console.log(select.value);
		$.ajax({
			url :"<%=DataStorage.Server.PACKAGE_NAME + DataStorage.Mapping.MAPPING_WEATHER_ID_CHANGE%>",
			data : {
				"<%=DataStorage.Key.KEY_WEATHER_ID%>":select.value,
				"<%=DataStorage.Key.KEY_WEATHER_KEY%>
	" : key
					},
					complete : function(result) {
						location.reload();
					}
				});
	}

	var regionList = [];
	function setRegion(id) {
		regionList.add(id);
		console.log(regionList);
	}
</script>