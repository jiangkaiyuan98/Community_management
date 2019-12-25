<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<html>
<head>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>加入的社团</title>
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
欢迎：${studentCustom.name}
<a href="${pageContext.request.contextPath }/students/edit_student.action?id=${studentCustom.id}">修改我的个人信息</a>
<form action="${pageContext.request.contextPath }/communities/findCanJoinCommunityList.action">
    <input  type="hidden" name="id" value="${studentCustom.id}">
    <input  type="hidden" name="username" value="${studentCustom.username}">
    <input  type="hidden" name="identity" value="${studentCustom.identity}">
    <input  type="hidden" name="name" value="${studentCustom.name}">
    <input type="submit" value="查看更多社团">
</form>
-------------------------------------
<table width ="100%" border=1 class="table">
    <tr>
        <td>社团编号</td>
        <td>社团名称</td>
        <td>社长id</td>
        <td>查看社团活动</td>
        <td>社长选项</td>
    </tr>
    <c:forEach items="${communityCustomList }" var="communityCustom">
        <tr>
            <td>${communityCustom.id} </td>
            <td>${communityCustom.name}</td>
            <td>${communityCustom.presidentid}</td>
            <c:if test="${communityCustom.presidentid==studentCustom.id}"><!--判断是否为该社社长,如果是正常-->
            <td><a href="${pageContext.request.contextPath }/activates/findActivateList.action?id=${communityCustom.id }&&identity=${studentCustom.identity }&&stuid=${studentCustom.id}">查看活动</a></td>
            </c:if>
            <c:if test="${communityCustom.presidentid!=studentCustom.id}"><!--判断是否为该社社长，如果不是identity为2-->
            <td><a href="${pageContext.request.contextPath }/activates/findActivateList.action?id=${communityCustom.id }&&identity=2&&stuid=${studentCustom.id}">查看活动</a></td>
            </c:if>
            <c:if test="${communityCustom.presidentid==studentCustom.id}"><!--判断是否为该社社长-->
            <td><a href="${pageContext.request.contextPath }/communities/findCommunityMembersList.action?id=${communityCustom.id }&&identity=1">查看社团成员</a> </td>
            </c:if>
        </tr>
    </c:forEach>
</table>
</body>
</html>