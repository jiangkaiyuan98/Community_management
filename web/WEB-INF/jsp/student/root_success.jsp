<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<html>
<head>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>在此处插入标题</title>
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
</head>
<body>
<a href="${pageContext.request.contextPath }/communities/addCommunity.action">添加社团</a>
<%--<input  name="id" value="${studentCustom.id}">--%>
<%--<input  name="username" value="${studentCustom.username}">--%>
<%--<input  name="identity" value="${studentCustom.identity}">--%>
<%--<input  name="name" value="${studentCustom.name}">--%>
<%--<a href="${pageContext.request.contextPath }/students/edit_student.action?id=${studentCustom.id}">修改</a>--%>



<table width ="100%" border=1 class="table">
    <tr>
        <td>社团编号</td>
        <td>社团名称</td>
        <td>社长id</td>
        <td>查看社团活动</td>
        <td>更换社长</td>
    </tr>
    <c:forEach items="${communityCustomList }" var="communityCustom">
        <tr>
            <td>${communityCustom.id} </td>
            <td>${communityCustom.name}</td>
            <td>${communityCustom.presidentid}</td>
            <td><a href="${pageContext.request.contextPath }/activates/findActivateList.action?id=${communityCustom.id }&&identity=0">查看活动</a></td>
            <td><a href="${pageContext.request.contextPath }/communities/jump_changeProprieter.action?comid=${communityCustom.id}">更换社长</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>