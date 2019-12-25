<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<html>
<head>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>申请加入社团</title>
	<style type="text/css">

		table

		{

			border-collapse: collapse;

			margin: 0 auto;

			text-align: center;

		}

		table td, table th

		{

			border: 1px solid #cad9ea;

			color: #666;

			height: 30px;

		}

		table thead th

		{

			background-color: #CCE8EB;

			width: 100px;

		}

		table tr:nth-child(odd)

		{

			background: #fff;

		}

		table tr:nth-child(even)

		{

			background: #F5FAFA;

		}

	</style>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.4.1.min.js"></script>
	<script type="text/javascript">
		function join_them(comid,stuid) {
			//var ja='{\"comid\":'+comid+',\"stuid\":'+ stuid+'}'
			//alert('{"comid":'+comid+',"stuid":'+stuid+'}')
			$.ajax({
				type:'post',
				url:'${pageContext.request.contextPath}/communities/join_community.action',
				contentType:'application/json;charset=UTF-8',
				data:'{"comid":'+comid+',"stuid":'+stuid+'}',
				dataType:"text",
				success:function(data) {
					alert(data);
				}
			})
		}
	</script>
</head>
<body>
	<table width ="90%" border=1 class="table">
		<tr>
			<td>社团编号</td>
			<td>社团名称</td>
			<td>社长id</td>
			<td>查看社团活动</td>
			<td>报名</td>
		</tr>
		<c:forEach items="${communityCustomList }" var="communityCustom">
			<tr>
				<td>${communityCustom.id} </td>
				<td>${communityCustom.name}</td>
				<td>${communityCustom.presidentid}</td>
				<td><a href="${pageContext.request.contextPath }/activates/findActivateList.action?id=${communityCustom.id }">查看活动</a></td>
				<td><button onclick="join_them(${communityCustom.id},${studentCustom.id})" >加入我们</button></td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="5">没有更多社团了</td>
		</tr>
	</table>
</body>
</html>