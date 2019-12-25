<%--
  Created by IntelliJ IDEA.
  User: jiangkaiyuan
  Date: 2019-06-18
  Time: 12:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<html>
<head>
    <title>审核活动报名人员</title>
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
    <script type="text/javascript">

    </script>
</head>
<body>
<table width ="100%" border=1 class="table">
    <tr>
        <td>申请人姓名</td>
        <td>申请人描述</td>
        <td>操作</td>
    </tr>
    <c:forEach items="${joinCommunityCustomList }" var="joinCommunityCustom">
        <c:if test="${joinCommunityCustom.state==0}">
            <tr>
                <td>${joinCommunityCustom.name} </td>
                <td>${joinCommunityCustom.description}</td>
                <td><button onclick="javascript:window.location.href='${pageContext.request.contextPath }/communities/choose_communityMembers.action?flag=1&&comid=${joinCommunityCustom.comid}&&stuid=${joinCommunityCustom.stuid}'">接受</button> OR <button onclick="javascript:window.location.href='${pageContext.request.contextPath }/communities/choose_communityMembers.action?flag=2&&comid=${joinCommunityCustom.comid}&&stuid=${joinCommunityCustom.stuid}'">拒绝</button> </td>
            </tr>
        </c:if>
    </c:forEach>
</table>
</body>
</html>
