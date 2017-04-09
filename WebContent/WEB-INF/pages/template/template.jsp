<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>

<link href="${pageContext.request.contextPath}/static/css/main.css"
	rel="stylesheet" type="text/css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/static/bootstrap/3.3.7-1/css/bootstrap.min.css" />

<script
	src="${pageContext.request.contextPath}/static/bootstrap/3.3.7-1/css/bootstrap.min.css"></script>
<script
	src="${pageContext.request.contextPath}/static/bootstrap/3.3.7-1/js/bootstrap.min.js"></script>
<script
	src="${pageContext.request.contextPath}/static/jquery/3.1.1-1/jquery.min.js"></script>	
<script
	src="${pageContext.request.contextPath}/static/script/scripts.js"></script>		

<div class="content">

	<div class="row">
		<div class="col-xs-12">
			<div class="navbar-top header">
				<tiles:insertAttribute name="header" />
			</div>

		</div>	
	</div>

	<div class="row-height">
		<div class="col-xs-12">
			<div class="nav nav-tabs">
				<tiles:insertAttribute name="menu" />
			</div>
		</div>
	</div>
		
	<div class="row-height">
		<div class="col-xs-12">
			<div class="message">
				<tiles:insertAttribute name="message" />
			</div>
		</div>
	</div>

	<div class="row-height">
		<div class="col-xs-12">
			<div class="body">
				<tiles:insertAttribute name="body" />
			</div>
		</div>
	</div>

	<div class="row">
		<div class="col-xs-12">
			<div class="panel-footer footer">
				<tiles:insertAttribute name="footer" />
			</div>
		</div>
	</div>

</div>


</html>
