<%@page import="com.graction.lumi.data.DataStorage"%>
<%@ page session="false" contentType="text/html; charset=UTF-8"%>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top" id="mainNav">
	<a class="navbar-brand" href="<%=request.getContextPath()%>"><%=DataStorage.Server.PACKAGE_NAME_ONLY %></a>
	<button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>

	<div class="collapse navbar-collapse" id="navbarResponsive">
		<ul class="navbar-nav navbar-sidenav" id="exampleAccordion">

			<!-- Image Category-->
			<li class="nav-item" data-toggle="tooltip" data-placement="right" title="Image">
				<a class="nav-link nav-link-collapse collapsed" data-toggle="collapse" href="#collapseImage" data-parent="#exampleAccordion"> 
					<i class="fa fa-fw fa-photo"></i>
					<span class="nav-link-text">Image</span>
				</a>
				<ul class="sidenav-second-level collapse" id="collapseImage">
					<%-- <li><a href="#" onclick="movePage('<%=request.getContextPath()+DataStorage.Mapping.MAPPING_MANAGE_WEATHER_IMAGE%>')">날씨 관리</a></li> --%>
					<li><a href="<%=request.getContextPath()+DataStorage.Mapping.MAPPING_MANAGE_WEATHER_IMAGE%>">날씨 관리</a></li>
					<li><a href="<%=request.getContextPath()+DataStorage.Mapping.MAPPING_MANAGE_FINE_DUST%>">미세먼지 관리</a></li>
					<li><a href="<%=request.getContextPath()+DataStorage.Mapping.MAPPING_MANAGE_REGION_RESERVATION%>">지역별 예약 관리</a></li>
					<li><a href="<%=request.getContextPath()+DataStorage.Mapping.MAPPING_MANAGE_REGION_RESERVATION_ADD%>">예약 추가</a></li>
					<li><a href="<%=request.getContextPath()+DataStorage.Mapping.MAPPING_MANAGE_WEATHER_CACHE%>">캐시 관리</a></li>
				</ul>
			</li>

			<!-- Message Category-->
			<li class="nav-item" data-toggle="tooltip" data-placement="right" title="Message"> 
				<a class="nav-link nav-link-collapse collapsed" data-toggle="collapse" href="#collapseMessage" data-parent="#exampleAccordion"> 
					<i class="fa fa-fw fa-envelope"></i> 
					<span class="nav-link-text">Message</span>
				</a>
				<ul class="sidenav-second-level collapse" id="collapseMessage">
					<li><a href="#">예약 관리</a></li>
					<li><a href="#">예약 추가</a></li>
				</ul>
			</li>

			<!-- Push Category-->
			<li class="nav-item" data-toggle="tooltip" data-placement="right"
				title="Push"><a class="nav-link nav-link-collapse collapsed"
				data-toggle="collapse" href="#collapsePush"
				data-parent="#exampleAccordion"> <i class="fa fa-fw fa-bell"></i>
					<span class="nav-link-text">Push</span>
			</a>
				<ul class="sidenav-second-level collapse" id="collapsePush">
					<li><a href="#">예약 관리</a></li>
					<li><a href="#">예약 추가</a></li>
				</ul>
			</li>
		</ul>

		<ul class="navbar-nav sidenav-toggler">
			<li class="nav-item">
				<a class="nav-link text-center" id="sidenavToggler"> 
					<i class="fa fa-fw fa-angle-left"></i> 
				</a>
			</li>
		</ul>

		<ul class="navbar-nav ml-auto">
	        <li class="nav-item dropdown">
	        	<a class="btn btn-primary" href="#" id="toggleNavPosition">Toggle Fixed/Static Navbar</a>
	        </li>
		</ul>
	</div>
</nav>