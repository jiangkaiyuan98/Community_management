<%--
  Created by IntelliJ IDEA.
  User: jiangkaiyuan
  Date: 2019-06-18
  Time: 20:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<html>
<head>
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
    <title>Title</title>
</head>
<body>
<table width ="100%" border=1 class="table">
    <tr>
        <td>成员姓名</td>
        <td>成员描述</td>
        <td>操作</td>
    </tr>
    <c:forEach items="${activityMembersCustomList }" var="activityMembersCustom" varStatus="status">
            <tr>
                <td>${activityMembersCustom.name} </td>
                <td>${activityMembersCustom.description}</td>
                <td><a href="${pageContext.request.contextPath }/activates/deleteActivityMembers.action?id=${activityMembersCustom.id}&&activateid=${activityMembersCustom.activateid}">删除成员</a> </td>
            </tr>
    </c:forEach>
</table>

</body>
</html>
