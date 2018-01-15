<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>书城首页</title>
<%@ include file="/WEB-INF/include/base.jsp"%>
<script type="text/javascript">
	$(function(){
		//获取按钮绑定点击事件
		$(".addBook2cart").click(function(){
			var id = this.id;
			//向服务器发送请求
			$.getJSON("client/CartServlet?method=addBook2Cart&bookId="+id,function(data){
				//每次先清空标签，再添加子标签
				$("#info").empty().append("<span>您的购物车中有"+data.totalCount+"件商品</span><div>您刚刚将<span style=\"color: red\">"+data.title+"</span>加入到了购物车中</div>");
				
			})
		})
	})
</script>
</head>
<body>

	<div id="header">
		<img class="logo_img" alt="" src="static/img/logo.gif"> <span
			class="wel_word">网上书城</span>
		<%@ include file="/WEB-INF/include/user.jsp"%>
	</div>

	<div id="main">
		<div id="book">
			<div class="book_cond">
				<form action="client/BookClientServlet" method="get">
					<input type="hidden" name="method" value="findBookByPrice">
					价格：<input type="text" name="min" value="${param.min }"> 元 -
					<input type="text" name="max" value="${param.max }"> <input
						type="submit" value="查询">
				</form>
			</div>
			<div style="text-align: center" id="info">
				<br> <span>您还没有购物，赶快购物吧...</span>
			</div>
			<%-- <c:choose>
				<c:when test="${!empty cart.list }">
					
					<div style="text-align: center">
						<span>您的购物车中有${cart.totalCount }件商品</span>
						<c:if test="${!empty title }">
						<div>
							您刚刚将<span style="color: red">${title }</span>加入到了购物车中
							<c:remove var="title"/>
						</div>
						</c:if>
					</div>
				</c:when>
				<c:otherwise>
					<div style="text-align: center">
						<br>
						<span>您还没有购物，赶快购物吧...</span>
					</div>
				</c:otherwise>
			</c:choose> --%>
			<c:forEach items="${page.list }" var="book">
				<div class="b_list">
					<div class="img_div">
						<img class="book_img" alt="" src="${book.imgPath }" />
					</div>
					<div class="book_info">
						<div class="book_name">
							<span class="sp1">书名:</span> <span class="sp2">${book.title }</span>
						</div>
						<div class="book_author">
							<span class="sp1">作者:</span> <span class="sp2">${book.author }</span>
						</div>
						<div class="book_price">
							<span class="sp1">价格:</span> <span class="sp2">${book.price }</span>
						</div>
						<div class="book_sales">
							<span class="sp1">销量:</span> <span class="sp2">${book.sale }</span>
						</div>
						<div class="book_amount">
							<span class="sp1">库存:</span> <span class="sp2">${book.stock }</span>
						</div>
						<div class="book_add">
							<button class="addBook2cart" id="${book.id }">加入购物车</button>
							<%-- <a href="client/CartServlet?method=addBook2Cart&bookId=${book.id }">加入购物车</a> --%>
						</div>
					</div>
				</div>

			</c:forEach>

		</div>

		<%@ include file="/WEB-INF/include/page.jsp"%>

	</div>

	<div id="bottom">
		<span> 尚硅谷书城.Copyright &copy;2015 </span>
	</div>
</body>
</html>