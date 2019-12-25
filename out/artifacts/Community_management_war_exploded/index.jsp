<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%
  String path = request.getContextPath();  //得到上下文路径 myweb
  String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

  //相当于   basePath= http://localhost :8080/myweb/
%>
<%--<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">--%>
<html>
<head>
  <script type="text/javascript">
    function judge(){
      var user = document.getElementById("username").value;
      var pwd= document.getElementById("password").value;
      var patrn=/^[0-9]{1,20}$/;
      if(user.trim() == "" || pwd.trim() == ""){
        alert("用户和密码不能为空");
        return false;
      }
      else if(!patrn.exec(user)||!patrn.exec(pwd)){
        alert("用户名和密码应为数字")
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
  <%--  <style>--%>
  <%--    .firstclass{--%>
  <%--      position:relative;--%>
  <%--      margin-left:200px;--%>
  <%--      margin-top:120px;--%>
  <%--      background-color:#ff0036;--%>
  <%--      width:200px;--%>
  <%--      height:200px;--%>
  <%--    }--%>
  <%--  </style>--%>
</head>
<body>
${error}
<form id="Student_Login" action="${pageContext.request.contextPath }/students/student_login.action" method="post">
  <table>
    <tr>
      <td>
        用户名：
      </td>
      <td>
        <input name="username" id="username" value="${StudentCustom.username}" >
      </td>
    </tr>
    <tr>
      <td>
        密码：
      </td>
      <td>
        <input name="password" type="password" id="password" value="${StudentCustom.password}">
      </td>
    </tr>
    <tr><td colspan="2"><input type="submit" value="登陆" onclick="return judge()"></td></tr>
  </table>
</form>
<%--<form action="${pageContext.request.contextPath }/students/student_login.action">--%>
<%--  <div class="firstclass">--%>
<%--    <span> 用户：</span><input type="text" value="${StudentCustom.username}"><br>--%>
<%--    <span> 密码：</span><input type="password" value="${StudentCustom.password}">--%>
<%--  </div>--%>
<%--</form>--%>
</body>
</html>
