<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false" contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="com.graction.lumi.data.*"%>
<%@ page import="com.graction.lumi.model.response.*"%>
<%@ page import="com.graction.lumi.model.xml.*"%>
<%
	String content = request.getAttribute(DataStorage.Attribute.ATTR_CONTENT) != null ? ".."+request.getAttribute(DataStorage.Attribute.ATTR_CONTENT)+".jsp" : "home.jsp";
%>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<title><%=DataStorage.Server.PACKAGE_NAME_ONLY %></title>
<%-- <jsp:include page="<%=DataStorage.Mapping.MAPPING_STYLE%>" /> --%>
<%@ include file="style.jsp" %>
</head>
<body class="fixed-nav sticky-footer bg-dark" id="page-top">

	<!-- Navigation-->
	<%@ include file="navigation.jsp" %>	

	<!-- content-wrapper - Start-->
	<div class="content-wrapper">
		<!-- container-fluid - Start-->
		<div class="container-fluid" id="content">
			<!-- Content - Start -->
			<jsp:include page="<%=content%>"/>
			<!-- Content - End -->
		</div>
		<!-- container-fluid - End-->
		
		<!-- Loading -->
	<input type="checkbox" id="loading-css-input">
	<div id="loading-target" class="loading"></div>
	</div>
	<!-- content-wrapper - End-->

	<!-- Footer -->
	<footer class="sticky-footer">
		<div class="container">
			<div class="text-center">
				<small>Copyright © Lumi made by TH 2017</small>
			</div>
		</div>
	</footer>

	<!-- Scroll to Top Button-->
	<a class="scroll-to-top rounded" href="#page-top"> <i
		class="fa fa-angle-up"></i>
	</a>
	
	<%-- <jsp:include page="<%=DataStorage.Mapping.MAPPING_SCRIPT%>" /> --%>
	<%@ include file="script.jsp" %>
	<script>

	$('#toggleNavPosition').click(function() {
	  $('body').toggleClass('fixed-nav');
	  $('nav').toggleClass('fixed-top static-top');
	});
	
</script>
</body>
</html>