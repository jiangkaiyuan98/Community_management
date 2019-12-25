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
<c:if test="${allErrors!=null}">
	<c:forEach items="${allErrors}" var="error">
	${ error.defaultMessage}
</c:forEach>
</c:if>
<form id="StudentForm" action="${pageContext.request.contextPath }/students/editStudentSubmit.action" method="post">
    <input type="hidden" name="id" value="${studentCustom.id}">
    <input type="hidden" name="username" value="${studentCustom.username}">
    <input type="hidden" name="identity" value="${studentCustom.identity}">
    <input type="hidden" name="name" value="${studentCustom.name}">
    修改${studentCustom.name}的个人信息:
    <table>
        <tr>
            <td>
                密码：
            </td>
            <td>
                <input name="password" value="${studentCustom.password}">
            </td>
        </tr>
        <tr>
            <td> 自我介绍</td>
            <td> 
            <textarea name="description" >${studentCustom.description }</textarea>  </td>
        </tr>
        <tr>
            <td colspan="2" align="center"><input type="submit" value="提交"  ></td>
        </tr>
    </table>
</form>
</body>
</html>
