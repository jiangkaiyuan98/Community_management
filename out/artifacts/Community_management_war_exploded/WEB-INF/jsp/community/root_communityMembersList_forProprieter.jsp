<%--
  Created by IntelliJ IDEA.
  User: jiangkaiyuan
  Date: 2019-05-16
  Time: 22:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<html>
<head>
    <title>${communityCustom.name}成员列表</title>
    <script type="text/javascript">
        window.onload = function(){
            var a="${error}"
            if(a!=""){
                alert(a);
            }
        }
    </script>
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
<table width ="100%" border=1 class="table">
    <input type="hidden" value="${comid}">
    <tr>
        <td>成员账号</td>
        <td>社团名称</td>
        <td>成员描述</td>
        <td>参加活动数</td>
        <td>操作</td>
    </tr>
    <c:forEach items="${studentCustomList }" var="studentCustom" varStatus="status">
        <tr>
            <td>${studentCustom.username} </td>
            <td>${studentCustom.name}</td>
            <td>${studentCustom.description}</td>
            <td>${join_act_num[status.index]}</td>
            <td><a href="${pageContext.request.contextPath }/communities/changeProprieter.action?stuid=${studentCustom.id}&&comid=${comid}">将该成员设置为社长</a> </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
