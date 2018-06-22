<%@ page import="com.graction.lumi.util.format.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false" contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="com.graction.lumi.data.DataStorage.*"%>
<%@ page import="com.graction.lumi.data.*"%>
<%@ page import="com.graction.lumi.util.StringUtil"%>
<%@ page import="com.graction.lumi.model.response.*"%>
<%@ page import="com.graction.lumi.model.db.RegionTable"%>
<%@ page import="com.graction.lumi.model.vo.RegionReservationVO"%>

<%
	Map<String, Map<String, ArrayList<RegionTable>>> map = DataTableManager.getInstance().getDBWeatherRegionTable();
	RegionReservationVO vo = (RegionReservationVO) request.getAttribute(Attribute.ATTR_REGION_RESERVATION_DATA_VO);
	String iTag = "<i class=\"fa fa-fw fa-times img-delete\" style=\"float:right\" onclick=\"deleteOnITag(this)\"></i>";
%>
<link rel="stylesheet" href="<%=DataStorage.Path.PATH_DIR_CSS%>tree.css" />

<h1>Manage Region Reservation</h1>
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
							int span_i = 0;
							String common_li1 = "<li class=\"clickable\" region=\""
									, common_li2 = "\"><span class=\"sp-checkable fa fa-fw fa-square-o\""
									, common_li3 = ">&nbsp;</span>"
									;
							Map<String, Map<String, ArrayList<RegionTable>>> rootTable = DataTableManager.getInstance().getDBWeatherRegionTable();
							for (String regionRoot : rootTable.keySet()) {
						%>
						<%=common_li1 + regionRoot + common_li2 + " id='spanId_"+span_i+++"'" + common_li3 + regionRoot%>
						<ul>
							<%
								Map<String, ArrayList<RegionTable>> siTable = rootTable.get(regionRoot);
									for (String si : siTable.keySet()) {
							%>
							<%=common_li1 + regionRoot + " " + si + common_li2 + " id='spanId_"+span_i+++"'" + common_li3 + si%>
							<%
								if (siTable.get(si).size() > 0) {
							%>
							<ul>
								<%
									for (RegionTable gugun : siTable.get(si)) {
								%>
								<%=common_li1 + gugun + common_li2 + " id='spanId_"+span_i+++"'" + common_li3 + gugun.getRegion_GUGUN() + "</li>"%>
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
			<div class="card-footer small text-muted">Updated 2017-11-29 at 15:09 PM</div>
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
				<button type="button" class="btn btn-success btn-circle btn-md" id="btn-modify"><i class="fa fa-check"></i>수정</button>
				<button type="button" class="btn btn-warning btn-circle btn-md" id="btn-cancel"><i class="fa fa-times"></i>뒤로</button>
				<button type="button" class="btn btn-danger btn-circle btn-md" id="btn-delete"><i class="fa fa-times"></i>삭제</button>
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
			<div class="card-footer small text-muted">Updated 2017-11-29 at 15:09 PM</div>
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
										<%
											if(!StringUtil.nullCheck(vo.getBackground_img_url())){
												out.print(iTag);
											}
										%>
										<img class="img-thumbnail" src="<%=Server.PATH_UPLOAD_DIR+vo.getBackground_img_url()%>" name="<%=DataStorage.Param.PARAM_BACKGROUND%>" />
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
										<%
											if(!StringUtil.nullCheck(vo.getCharacter_img_url())){
												out.print(iTag);
											}
										%>
										<img class="img-thumbnail" src="<%=Server.PATH_UPLOAD_DIR+vo.getCharacter_img_url()%>" name="<%=DataStorage.Param.PARAM_CHARACTER%>" />
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
										<%
											if(!StringUtil.nullCheck(vo.getEffect_img_url())){
												out.print(iTag);
											}
										%>
										<img class="img-thumbnail" src="<%=Server.PATH_UPLOAD_DIR+vo.getEffect_img_url()%>" name="<%=DataStorage.Param.PARAM_EFFECT%>" />
									</td>
								</tr>
						</table>
					</form>
				</div>
			</div>
			<div class="card-footer small text-muted">Updated 2017-11-29 at 15:09 PM</div>
		</div>
	</div>
</div>

<script src="<%=DataStorage.Path.PATH_DIR_JS%>jquery-3.2.1.min.js"></script>
<script src="<%=DataStorage.Path.PATH_DIR_JS%>commonScript.js"></script>
<script src="<%=DataStorage.Path.PATH_DIR_JS%>tree.js"></script>
<script src="<%=DataStorage.Path.PATH_DIR_JS%>DateScript.js"></script>
<script type="text/javascript">

var prioritization = "<%=vo.getRegionReservation_prioritization()%>";

function showModifyAlert(result){
	loadingTermination();
	switch(result){
	case "<%=Code.CODE_SUCCESS%>" :
		log("success");
		alert("<%=Message.REGION_RESERVATION_MODIFY_SUCCESS_MESSAGE%>");
		location.href="<%=request.getContextPath()+Mapping.MAPPING_MANAGE_REGION_RESERVATION%>";
		break;
	case "<%=Code.CODE_FAIL%>" :
		log("fail");
		alert("<%=Message.REGION_RESERVATION_MODIFY_FAIL_MESSAGE%>");
		break;
	}
}

function showDeleteAlert(result){
	loadingTermination();
	switch(result){
	case "<%=Code.CODE_SUCCESS%>" :
		log("success");
		alert("<%=Message.REGION_RESERVATION_DELETE_SUCCESS_MESSAGE%>");
		location.href="<%=request.getContextPath()+Mapping.MAPPING_MANAGE_REGION_RESERVATION%>";
		break;
	case "<%=Code.CODE_FAIL%>" :
		log("fail");
		alert("<%=Message.REGION_RESERVATION_DELETE_FAIL_MESSAGE%>");
		break;
	}
}

function initRegionList(){
	var regionList = $("#tree2 li");
	var selectedList = "<%=vo.getRegionReservation_region()%>".split(",");
	for(var i=0; i<regionList.length; i++){
		for(var j=0; j<selectedList.length; j++){
			if(regionList[i].getAttribute("region") == (selectedList[j])){
                $("#"+regionList[i].childNodes[selectedRegions.findTagIndex(regionList[i], "SPAN")].id).trigger("click");
			}
		}
	}
}

$(function() {
	imgMap.set("<%=Database.Column.COLUMN_BACKGROUND_INDEX%>",  <%=vo.getRegionReservation_background_ref_file_index()%>);
	imgMap.set("<%=Database.Column.COLUMN_CHARACTER_INDEX%>", <%=vo.getRegionReservation_character_ref_file_index()%>);
	imgMap.set("<%=Database.Column.COLUMN_EFFECT_INDEX%>", <%=vo.getRegionReservation_effect_ref_file_index()%>);
	setDaterangeTime("<%=vo.getRegionReservation_active_time().toString().replaceAll("-",".")%>","<%=vo.getRegionReservation_end_time().toString().replaceAll("-",".")%>");
	initRegionList();
	
	// var i = '<i class="fa fa-fw fa-times img-delete" style="float:right"></i>';
	/* $("input[type='file']").on('change', function(){
		var imgDeleteIcon = document.createElement( "i" );
	    imgDeleteIcon.className = "fa fa-fw fa-times img-delete";
	    imgDeleteIcon.style = "float:right";
	    imgDeleteIcon.onclick = deleteAll;
	    // log($("img[name='"+this.name+"']").parentNode);
		$("img[name='"+this.name+"']").parents()[0].prepend(imgDeleteIcon);
	    readURL(this);
	}); */
	
	$("input[type='file']").on('change', function(){
		var obj = this;
		addXButton(this, function(){
			deleteAll(obj);
		});
	});
    
    $("#btn-modify").on("click",function(){
    	loadingActivation();
    	log("moidfy click");
    	<%-- log("<%=Database.Column.COLUMN_BACKGROUND_INDEX%> : "+imgMap.get("<%=Database.Column.COLUMN_BACKGROUND_INDEX%>"));
    	log("<%=Database.Column.COLUMN_CHARACTER_INDEX%> : "+imgMap.get("<%=Database.Column.COLUMN_CHARACTER_INDEX%>"));
    	log("<%=Database.Column.COLUMN_EFFECT_INDEX%> : "+imgMap.get("<%=Database.Column.COLUMN_EFFECT_INDEX%>")); --%>
    	selectedRegions.distinct();
    	log(imgMap);
    	log("background index : "+imgMap.get("<%=Database.Column.COLUMN_BACKGROUND_INDEX%>"))
    	var frmData = new FormData(document.getElementById("frm"));
    	frmData.set("<%=Param.PARAM_INDEX%>",<%=vo.getRegionReservation_index()%>);
    	frmData.set("<%=Param.PARAM_PRIORITIZATION%>",prioritization);
    	frmData.set("<%=Param.PARAM_background_img_path%>", "<%=Path.PATH_DIR_IMAGES_BACKGROUND%>");
    	frmData.set("<%=Param.PARAM_BACKGROUND_INDEX%>", imgMap.get("<%=Database.Column.COLUMN_BACKGROUND_INDEX%>"));
    	frmData.set("<%=Param.PARAM_CHARACTER_PATH%>", "<%=Path.PATH_DIR_IMAGES_CHARACTER%>");
    	frmData.set("<%=Param.PARAM_CHARACTER_INDEX%>", imgMap.get("<%=Database.Column.COLUMN_CHARACTER_INDEX%>"));
    	frmData.set("<%=Param.PARAM_EFFECT_PATH%>", "<%=Path.PATH_DIR_IMAGES_EFFECT%>");
    	frmData.set("<%=Param.PARAM_EFFECT_INDEX%>", imgMap.get("<%=Database.Column.COLUMN_EFFECT_INDEX%>"));
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
           	url : "<%=request.getContextPath()+Mapping.MAPPING_REGION_RESERVATION_MODIFY%>",
           	type : "POST",
           	processData: false,
            contentType: false,
           	data : frmData,
           	success : function(result){
           		showModifyAlert(result);    			
           	},
           	error : function(error){
           		showModifyAlert("<%=Code.CODE_FAIL%>");
           	}
        });
    });
    
    $("#btn-cancel").on("click",function(){
    	window.history.back();
    });
    
    $("#btn-delete").on("click",function(){
    	loadingActivation();
    	$.ajax({
           	url : "<%=request.getContextPath()+Mapping.MAPPING_REGION_RESERVATION_DELETE%>",
           	type : "POST",
           	data : {"<%=Param.PARAM_INDEX%>":"<%=vo.getRegionReservation_index()%>"},
           	success : function(result){
           		showDeleteAlert(result);    			
           	},
           	error : function(error){
           		log(error);
           		showDeleteAlert("<%=Code.CODE_FAIL%>");
           	}
        });
    });
    
    $("#btnGroup-Pri button").on("click",function(){
    	prioritization = this.getAttribute("prioritization");
    });
   
});
 </script>