<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- base标签的href属性会作为当前页面中所有相对路径的前缀 -->
<base href="http://<%=request.getServerName() %>:<%=request.getServerPort() %><%=request.getContextPath() %>/">
<link type="text/css" rel="stylesheet" href="static/css/style.css" >
<!-- 引入jQuery库 -->
<script type="text/javascript" src="static/script/jquery-1.7.2.js"></script>