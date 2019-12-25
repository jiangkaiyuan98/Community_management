<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<html>
<head>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查询商品列表</title>
<script type="text/javascript">
function deleteItems(){
	//提交form
	document.itemsForm.action="${pageContext.request.contextPath}/items/deleteItems.action";
	document.itemsForm.submit();
}
function queryItems(){
	//提交form
	document.itemsForm.action="${pageContext.request.contextPath}/items/queryItems.action";
	document.itemsForm.submit();
}
</script>
</head>
<body>
<form action="${pageContext.request.contextPath}/items/queryItems.action" method="post">
查询条件
<table width ="100%" border=1>
<tr>
<td>商品名称:<input name="itemsCustom.name" /></td>
<td><input type="button" value="查询" onclick="queryItems"/>
<input type="button" value="批量删除" onclick="deleteItems"/></td>
</table>
<table width ="100%" border=1>
<tr>
<td>选择</td>
<td>商品号</td>
<td>商品名称</td>
<td>价格</td>
<td>商品描述</td>
<td>操作</td>
</tr>
<c:forEach items="${itemsList }" var="item">
	<tr>
			<td><input type="checkbox" name="items_id" value="${item.id}"></td>
			<td>${item.id} </td>
			<td>${item.name}</td>
			<td>${item.price}</td>
			<td>${item.detail}</td>
			<td><a href="${pageContext.request.contextPath }/items/editItems.action?id=${item.id }">修改</a></td>
	</tr>
</c:forEach>
</table>
</form>
</body>
</html>