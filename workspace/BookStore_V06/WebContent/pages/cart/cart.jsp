<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>购物车</title>
<%@ include file="/WEB-INF/include/base.jsp" %>
<script type="text/javascript">
	$(function(){
		//给删除绑定点击事件
		$(".delA").click(function(){
			var title = $(this).parents("tr").find("td:eq(0)").html();
			if(!confirm("确认要删除 <"+title+"> 图书吗？")){
				return false;
			}
		})
		
		//获取数量文本框，并绑定change事件
		$(".count").change(function(){
			//获取更改后的值 
			var count = $(this).val();
			var bookId = this.name;
			//对文本值进行验证
			var reg = /[0-9]/;
			if(!reg.test(count)){
				alert("请输入正确的数字！");
				$(this).val(this.defaultValue);
				return false;
			}
			
			//发送请求
			window.location.href = "client/CartServlet?method=changeCount&count="+count+"&bookId="+bookId;
		})
	})
</script>
</head>
<body>
	
	<div id="header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
			<span class="wel_word">购物车</span>
			<%@include file="/WEB-INF/include/user.jsp" %>
	</div>
	
	<div id="main">
	
		<table>
			<tr>
				<td>商品名称</td>
				<td>数量</td>
				<td>单价</td>
				<td>金额</td>
				<td>操作</td>
			</tr>
			<c:forEach items="${cart.list }" var="item">
				<tr>
					<td>${item.book.title }</td>
					<td><input type="text" name="${item.book.id }" class="count" style="width:30px;text-align:center" value="${item.count }"></td>
					<td>${item.book.price }</td>
					<td>${item.amount }</td>
					<td><a class="delA" href="client/CartServlet?method=deleteCartItem&bookId=${item.book.id }">删除</a></td>
				</tr>	
			</c:forEach>		
		</table>
		
		<div class="cart_info">
			<span class="cart_span">购物车中共有<span class="b_count">${cart.totalCount }</span>件商品</span>
			<span class="cart_span">总金额<span class="b_price">${cart.totalAmount }</span>元</span>
			<span class="cart_span"><a href="client/CartServlet?method=clear">清空购物车</a></span>
			<span class="cart_span"><a href="pages/cart/checkout.jsp">去结账</a></span>
		</div>
	
	</div>
	
	<div id="bottom">
		<span>
			尚硅谷书城.Copyright &copy;2015
		</span>
	</div>
</body>
</html>