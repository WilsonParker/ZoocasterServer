<%@ page import="com.graction.lumi.util.format.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false" contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="com.graction.lumi.data.DataStorage.*"%>
<%@ page import="com.graction.lumi.data.*"%>
<%@ page import="com.graction.lumi.model.response.*"%>
<%@ page import="com.graction.lumi.model.db.*"%>

<%
	Map<String, Map<String, ArrayList<RegionTable>>> map = DataTableManager.getInstance()
			.getDBWeatherRegionTable();
%>
<link rel="stylesheet" href="<%=DataStorage.Path.PATH_DIR_CSS%>tree.css" />

<!-- <ol class="breadcrumb">
	<li class="breadcrumb-item"><a href="#">Region Reservation Manage</a></li>
	<li class="breadcrumb-item active">Add reservation by region</li>
</ol> -->

<h1>Add Region Reservation</h1>
<hr>

<div class="row">
	<div class="col-lg-4">
		<div class="card mb-3">
			<div class="card-header">
				<i class="fa fa-map-marker"></i> Select Region
			</div>
			<div class="card-body">
				<div class="row">
					<ul id="tree2">
						<%
							String common_li1 = "<li class=\"clickable\" region=\"",
									common_li2 = "\"><span class=\"sp-checkable fa fa-fw fa-square-o\">&nbsp;</span>";
							Map<String, Map<String, ArrayList<RegionTable>>> rootTable = DataTableManager.getInstance()
									.getDBWeatherRegionTable();
							for (String regionRoot : rootTable.keySet()) {
						%>
						<%=common_li1 + regionRoot + common_li2 + regionRoot%>
						<ul>
							<%
								Map<String, ArrayList<RegionTable>> siTable = rootTable.get(regionRoot);
									for (String si : siTable.keySet()) {
							%>
							<%=common_li1 + regionRoot + " " + si + common_li2 + si%>
							<%
								if (siTable.get(si).size() > 0) {
							%>
							<ul>
								<%
									for (RegionTable gugun : siTable.get(si)) {
								%>
								<%=common_li1 + gugun + common_li2 + gugun.getRegion_GUGUN() + "</li>"%>
								<%
									}
								%>
							</ul>
							<%
								}
							%>
							</li>
							<%
								}
							%>
						</ul>
						</li>
						<%
							}
						%>
					</ul>
				</div>
			</div>
			<div class="card-footer small text-muted">Updated 2017-11-20 at 14:46 PM</div>
		</div>

		<div class="card mb-3">
			<div class="card-header">
				<i class="fa fa-hand-o-up"></i> Prioritization
			</div>
			<div class="card-body">
				<div id="btnGroup-Pri" class="btn-group" role="group" aria-label="Basic example">
					<button type="button" class="btn btn-outline btn-info" prioritization="<%=DataStorage.Key.KEY_RESERVATION %>">Reservation</button>
					<button type="button" class="btn btn-outline btn-warning" prioritization="<%=DataStorage.Key.KEY_FINE_DUST%>">Fine dust</button>
				</div>
			</div>
		</div>
		
		<div class="card mb-3">
			<div class="card-body">
				<button type="button" class="btn btn-info btn-circle btn-lg"><i class="fa fa-check" id="btn-add"></i> </button>
				<button type="button" class="btn btn-warning btn-circle btn-lg"><i class="fa fa-times" id="btn-cancel"></i> </button>
			</div>
		</div>
	</div>
	
	<div class="col-lg-6">
		<div class="card mb-3">
			<div class="card-header">
				<i class="glyphicon glyphicon-calendar fa fa-calendar"></i> Select Date
			</div>
			<div class="card-body">
				<!-- Calendar -->
				<div class="input-group">
					<input type="text" class="form-control" name="daterange" readonly>
				</div>
			</div>
			<div class="card-footer small text-muted">Updated 2017-11-20 at 14:46 PM</div>
		</div>
		
		<div class="card mb-3">
			<div class="card-header">
				<i class="fa fa-photo"></i> Select Image
			</div>
			<div class="card-body">
				<div class="table-responsive">
					<form id="frm" method="post" enctype="multipart/form-data"> 
						<table class="table table-bordered dataTable " width="100%" cellspacing="0" role="grid" accept-charset="utf-8" aria-describedby="dataTable_info" style="width: 100%;">
								<tr>
									<td>
										<p class="card-text small"><%=DataStorage.Param.PARAM_BACKGROUND%></p>
										<input type="file" class="btn btn-default" name="<%=DataStorage.Param.PARAM_BACKGROUND%>" />
									</td>
								<tr/>
								<tr>
									<td>
										<img class="img-thumbnail" src="" name="<%=DataStorage.Param.PARAM_BACKGROUND%>" />
									</td>
								</tr>
								<tr>
									<td>
										<p class="card-text small"><%=DataStorage.Param.PARAM_CHARACTER%></p>
										<input type="file" class="btn btn-default" name="<%=DataStorage.Param.PARAM_CHARACTER%>" />
									</td>
								<tr/>
								<tr>
									<td>
										<img class="img-thumbnail" src="" name="<%=DataStorage.Param.PARAM_CHARACTER%>" />
									</td>
								</tr>
								<tr>
									<td>
										<p class="card-text small"><%=DataStorage.Param.PARAM_EFFECT%></p>
										<input type="file" class="btn btn-default" name="<%=DataStorage.Param.PARAM_EFFECT%>" />
									</td>
								<tr/>
								<tr>
									<td>
										<img class="img-thumbnail" src="" name="<%=DataStorage.Param.PARAM_EFFECT%>" />
									</td>
								</tr>
						</table>
					</form>
				</div>
			</div>
			<div class="card-footer small text-muted">Updated 2017-11-20 at 14:46 PM</div>
		</div>
	</div>
</div>

<script src="<%=DataStorage.Path.PATH_DIR_JS%>jquery-3.2.1.min.js"></script>
<script type="text/javascript">
$(function() {
	var prioritization = "reservation";
	
    $("input[type='file']").on('change', function(){
        readURL(this);
    });
    
    $("#btn-add").on("click",function(){
    	loadingActivation();
    	selectedRegions.distinct();
    	var frmData = new FormData(document.getElementById("frm"));
    	frmData.set("<%=Param.PARAM_PRIORITIZATION%>",prioritization);
    	frmData.set("<%=Param.PARAM_background_img_path%>", "<%=Path.PATH_DIR_IMAGES_BACKGROUND%>");
    	frmData.set("<%=Param.PARAM_CHARACTER_PATH%>", "<%=Path.PATH_DIR_IMAGES_CHARACTER%>");
    	frmData.set("<%=Param.PARAM_EFFECT_PATH%>", "<%=Path.PATH_DIR_IMAGES_EFFECT%>");
        frmData.set("<%=Param.PARAM_REGION%>",selectedRegions.distinctList.toString());
        frmData.set("<%=Param.PARAM_TIME%>",$("input[name='daterange']").val());

        /* 
        log(selectedRegions.regionList);
        log(selectedRegions.distinctList.toString());
        log(selectedRegions.regionList);  // Region List
        log(selectedRegions.distinctList);  // distinct List
        log($("input[name='daterange']").val());    // Time
         */
        $.ajax({
           	url : "<%=request.getContextPath()+Mapping.MAPPING_REGION_RESERVATION_ADD%>",
           	type : "POST",
           	processData: false,
            contentType: false,
           	data : frmData,
           	success : function(result){
				showAlert(result);    			
           	},
           	error : function(error){
           		showAlert("<%=Code.CODE_FAIL%>");
           	}
        });
    });
    $("#btnGroup-Pri button").on("click",function(){
    	prioritization = this.getAttribute("prioritization");
        // frmData.set("<%=Param.PARAM_PRIORITIZATION%>",this.getAttribute("prioritization"));
    });
    
    function showAlert(result){
    	loadingTermination();
    	log(result);
    	switch(result){
		case "<%=Code.CODE_SUCCESS%>" :
			alert("<%=Message.REGION_RESERVATION_ADD_SUCCESS_MESSAGE%>");
			location.href="<%=request.getContextPath()+Mapping.MAPPING_MANAGE_REGION_RESERVATION%>";
			break;
		case "<%=Code.CODE_FAIL%>" :
			alert("<%=Message.REGION_RESERVATION_ADD_FAIL_MESSAGE%>");
			break;
		}
    }
    
});
 </script>

<script src="<%=DataStorage.Path.PATH_DIR_JS%>jquery-3.2.1.min.js"></script>
<script src="<%=DataStorage.Path.PATH_DIR_JS%>commonScript.js"></script>
<script src="<%=DataStorage.Path.PATH_DIR_JS%>tree.js"></script>
<script src="<%=DataStorage.Path.PATH_DIR_JS%>DateScript.js"></script>
