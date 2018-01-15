<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div id="page_nav">
	<c:choose>
		<c:when test="${page.totalPage<=5 }">
			<c:set value="1" var="begin"></c:set>
			<c:set value="${page.totalPage }" var="end"></c:set>
		</c:when>
		<c:when test="${page.pageNo<3 }">
			<c:set value="1" var="begin"></c:set>
			<c:set value="5" var="end"></c:set>
		</c:when>
		<c:otherwise>
			<c:set value="${page.pageNo-2 }" var="begin"></c:set>
			<c:set value="${page.pageNo+2 }" var="end"></c:set>
			<c:if test="${end>page.totalPage }">
				<c:set value="${page.totalPage-4}" var="begin"></c:set>
				<c:set value="${page.totalPage }" var="end"></c:set>
			</c:if>
		</c:otherwise>
	</c:choose>
	<a href="${page.path }&pageNo=1">首页</a> <a
		href="${page.path }&pageNo=${page.pageNo-1 }">上一页</a>
	<c:forEach begin="${begin }" end="${end}" var="index">
		<c:choose>
			<c:when test="${index==page.pageNo }">
				【${index }】
				</c:when>
			<c:otherwise>
				<a href="${page.path }&pageNo=${index }">${index }</a>
			</c:otherwise>
		</c:choose>
	</c:forEach>
	<a href="${page.path }&pageNo=${page.pageNo+1 }">下一页</a> <a
		href="${page.path }&pageNo=${page.totalPage}">末页</a> 共${page.totalPage }页，${page.totalCount }条记录
	到第<input value="${page.pageNo }" name="pn" id="pn_input" />页 <input
		type="button" value="确定">
	<script type="text/javascript">
				//给文本框提供一个文本改变事件
				$("#pn_input").change(function(){
					var number = $(this).val();
					//跳转页面实际就是改变浏览器的url地址
					window.location.href = "${page.path }&pageNo="+number;
				})
			
			</script>
</div>