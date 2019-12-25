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
</head>
<body>
${error}
<form id="Student_Login" action="${pageContext.request.contextPath }/students/student_login.action" method="post">
    登陆
    <table>
        <tr>
            <td>
               	 用户名：
            </td>
            <td>
                <input name="username" value="${StudentCustom.username}">
            </td>
        </tr>
        <tr>
            <td>
               	 密码：
            </td>
            <td>
                <input name="password" value="${StudentCustom.password}">
            </td>
        </tr>
    </table>
</form>
</body>
</html>
