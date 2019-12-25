<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<html>
<head>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查询商品列表</title>
<script type="text/javascript">
function editItemsAllSubmit(){
	//提交form
	document.itemsForm.action="${pageContext.request.contextPath}/items/editItemsAllSubmit.action";
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
<form name="itemsForm" action="${pageContext.request.contextPath}/items/queryItems.action" method="post">
查询条件
<table width ="100%" border=1>
<tr>
<td>商品名称:<input name="itemsCustom.name" /></td>
<td><input type="button" value="查询" onclick="queryItems()"/>
<input type="button" value="批量修改提交" onclick="editItemsAllSubmit()"/></td>
</table>
<table width ="100%" border=1>
<tr>
<td>商品号</td>
<td>商品名称</td>
<td>价格</td>
<td>商品描述</td>
</tr>
<c:forEach items="${itemsList }" var="item" varStatus="status">
	<tr>
			<td><input name="itemsList[${status.index}].id" value="${item.id}"/></td>
			<td><input name="itemsList[${status.index}].name" value="${item.name}"/></td>
			<td><input name="itemsList[${status.index}].price" value="${item.price}"/></td>
			<td><input name="itemsList[${status.index}].detail" value="${item.detail}"/></td>
	</tr>
</c:forEach>
</table>
</form>
</body>
</html>