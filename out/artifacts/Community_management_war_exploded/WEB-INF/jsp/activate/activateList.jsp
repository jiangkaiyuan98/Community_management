<%--
  Created by IntelliJ IDEA.
  User: jiangkaiyuan
  Date: 2019-05-16
  Time: 23:15
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
    <script type="text/javascript">
        function the_submit() {
            document.activeListForm.action("${pageContext.request.contextPath }/activates/the_submitActivateList.action?comid=${comid }");
            document.activeListForm.submit();
        }
    </script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.4.1.min.js"></script>
    <script type="text/javascript">
        function join_activate(activateid,stuid) {
            alert('{"activateid":'+activateid+',"stuid":'+stuid+'}')
            $.ajax({
                type:'post',
                url:'${pageContext.request.contextPath}/activates/join_activate_cache.action',
                contentType:'application/json;charset=UTF-8',
                data:'{"activateid":'+activateid+',"stuid":'+stuid+'}',
                dataType:"text",
                success:function(data) {
                    alert(data);
                }
            })
        }
            function judge(){
                var user = document.getElementById("name").value;
                var pwd= document.getElementById("description").value;
                var patrn=/^[0-9]{1,20}$/;
                if(user.trim() == "" || pwd.trim() == ""){
                    alert("活动名称和描述不能为空");
                    return false;
                }
                return true;
            }
    </script>
</head>
<body>
<c:if test="${flag==1}">
    <form name="activeForm" action="${pageContext.request.contextPath }/activates/sentActivateList.action?comid=${comid }" method="post">
        <table width ="100%" border=1 class="table">
            <input type="hidden" value="activateCustom.id">
            <tr>
                <td>发布新的活动:</td>
                <td><input name="name" id="name" value="${activate.name}"></td>
                <td><input name="description" id="description" value="${activate.description}"></td>
                <td><input type="submit" value="提交" onclick="return judge()"></td>
            </tr>
        </table>
        <input type="hidden" name="flag" value="${flag}">
    </form>
</c:if>

<form name="activeListForm" action="${pageContext.request.contextPath }/activates/the_submitActivateList.action?comid=${comid }" method="post">
        该社团的活动如下：
    <br/>
    <table width ="100%" border=1 class="table">
    <tr>
        <td>id</td>
        <td>活动名称</td>
        <td>活动描述</td>
        <td>状态</td>
    </tr>

    <c:forEach items="${activateCustomList }" var="activateCustom" varStatus="status">
        <c:if test="${activateCustom.state!=0||identity==0||identity==1}"><!--普通学生无法看到未审核的活动 -->
        <tr>
            <td>${activateCustom.id}</td>
            <input type="hidden" name="activateCustomList[${status.index}].id" value="${activateCustom.id}">
            <input type="hidden" name="activateCustomList[${status.index}].name" value="${activateCustom.name}">
            <input type="hidden" name="activateCustomList[${status.index}].description" value="${activateCustom.description}">
            <input type="hidden" name="activateCustomList[${status.index}].comid" value="${comid}">
            <td>${activateCustom.name}</td>
            <td>${activateCustom.description}</td>
            <c:if test="${identity==2||identity==1}">
                <c:if test="${activateCustom.state==0}">
                    <td>状态为${activateCustom.state}:尚未审核</td>
                </c:if>
                <c:if test="${activateCustom.state==1&&identity==2}">
                    <td><button type="button" onclick="join_activate(${activateCustom.id},${stuid })">报名</button></td>
                </c:if>
                <c:if test="${activateCustom.state==1&&identity==1}">
                    <td><a href="${pageContext.request.contextPath }/activates/check_join_activityMembers.action?act_id=${activateCustom.id}&&act=${activateCustom.name}">查看报名表</a>OR<a href="${pageContext.request.contextPath }/activates/findActivityMembers.action?activateid=${activateCustom.id}">查看活动成员</a></td>
                </c:if>
            </c:if>
            <c:if test="${identity==0}">
                <td>
                    <select name="activateCustomList[${status.index}].state">
                        <option value="${activateCustom.state}" selected><c:if test="${activateCustom.state==0}">暂不通过</c:if><c:if test="${activateCustom.state==1}">已通过</c:if></option>
                        <option value="${activateCustom.state=0}" >暂不通过</option>
                        <option value="${activateCustom.state=1}" >可以发布该活动</option>
                    </select>
                    <a href="${pageContext.request.contextPath }/activates/deleteActivate.action?id=${activateCustom.id}&&comid=${activateCustom.comid}">删除该活动</a>
                </td>
            </c:if>
        </tr>
        </c:if>
    </c:forEach>
</table>
    <c:if test="${identity==0}">
        <input type="submit" value="提交" >
    </c:if>
</form>
</body>
</html>
