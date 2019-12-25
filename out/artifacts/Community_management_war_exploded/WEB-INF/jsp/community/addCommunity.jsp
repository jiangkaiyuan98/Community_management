<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>

<%
    String path = request.getContextPath();  //得到上下文路径 myweb
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

    //相当于   basePath= http://localhost :8080/myweb/
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <script type="text/javascript">
        function judge(){
            var user = document.getElementById("name").value;
            var pwd= document.getElementById("presidentid").value;
            if(user.trim() == "" || pwd.trim() == ""){
                alert("社团名和社长ID不能为空");
                return false;
            }
            return true;
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
<form id="StudentForm" action="${pageContext.request.contextPath }/communities/addCommunitySubmit.action" method="post">
    <table class="table">
        <tr>
            <td>
                社团名：
            </td>
            <td>
                <input name="name" id="name" value="${communityCustom.name}">
            </td>
        </tr>
        <tr>
            <td> 社长id</td>
            <td> 
            <input name="presidentid" id="presidentid" value="${communityCustom.presidentid}">
            </td>
        </tr>
        <tr>
            <td colspan="2" align="center"><input type="submit" value="提交"  onclick="return judge()"></td>
        </tr>
        <c:if test="${message!=null}">
            <tr>
                <td colspan="2" align="center"><label>${message}</label></td>
            </tr>
        </c:if>
    </table>
</form>
</body>
</html>
