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
<link rel="stylesheet" href="<%=DataStorage.Path.PATH_DIR_CSS%>tree.css" />
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

<!-- <div class="row">
	<div class="col-md-4">
		<ul id="tree1">
			<li><a href="#">TECH</a>
				<ul>
					<li class="clickable"><span
						class="sp-checkable fa fa-fw fa-check-square-o">&nbsp;</span>Company
						Maintenance</li>
					<li>Employees
						<ul>
							<li><span class="fa fa-fw fa-square-o">&nbsp;</span>Reports
								<ul>
									<li>Report1</li>
									<li>Report2</li>
									<li>Report3</li>
								</ul></li>
							<li>Employee Maint.</li>
						</ul>
					</li>
					<li>Human Resources</li>
				</ul></li>
			<li>XRP
				<ul>
					<li>Company Maintenance</li>
					<li>Employees
						<ul>
							<li>Reports
								<ul>
									<li>Report1</li>
									<li>Report2</li>
									<li>Report3</li>
								</ul>
							</li>
							<li>Employee Maint.</li>
						</ul>
					</li>
					<li>Human Resources</li>
				</ul>
			</li>
		</ul>
	</div>
</div> -->

<div class="row">
	<div class="col-md-4">
		<ul id="tree2">
			<%
				String common_li = "<li class=\"clickable\"><span class=\"sp-checkable fa fa-fw fa-square-o\">&nbsp;</span>";
				Map<String, Map<String, ArrayList<RegionTable>>> rootTable = DataTableManager.getInstance().getDBWeatherRegionTable();
				for (String regionRoot : rootTable.keySet()) {
			%>
			<%=common_li+regionRoot %> 
				<ul>
					<%
						Map<String, ArrayList<RegionTable>> siTable = rootTable.get(regionRoot);
						for (String si : siTable.keySet()) {
					%>
					<%=common_li+si %>
						<ul>
						<%
							for (RegionTable gugun : siTable.get(si)) {
						%>
							<%=common_li+gugun.getRegion_GUGUN() %></li>
						<%} %>
						</ul>
					</li>
					<% } %>
				</ul>
			</li>
			<% } %>
		</ul>
	</div>
</div>

<script src="<%=DataStorage.Path.PATH_DIR_JS%>jquery-3.2.1.min.js"></script>
<script src="<%=DataStorage.Path.PATH_DIR_JS%>commonScript.js"></script>
<script src="<%=DataStorage.Path.PATH_DIR_JS%>tree.js"></script>
<script>
	// fa fa-fw fa-square-o
	// fa fa-fw fa-check-square-o  
	var icon_checked = "fa-check-square-o";
	var icon_unchecked = "fa-square-o";
	$(".sp-checkable").on("click", function() {
		console.log("click");
		console.log(this);
		if (this.classList.contains(icon_checked)) {
			this.classList.remove(icon_checked);
			this.classList.add(icon_unchecked);
		} else {
			this.classList.remove(icon_unchecked);
			this.classList.add(icon_checked);
		}
	});
</script>