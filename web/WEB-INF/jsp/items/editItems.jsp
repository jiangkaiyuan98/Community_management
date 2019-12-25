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
<form id="itemForm" action="${pageContext.request.contextPath }/items/editItemsSubmit.action" method="post">
    <input type="hidden" name="id" value="${itemsCustom.id}">
    修改商品信息:
    <table>
        <tr>
            <td>
               	 商品名称：
            </td>
            <td>
                <input name="name" value="${itemsCustom.name}">
            </td>
        </tr>
        <tr>
            <td>
               	 商品价格：
            </td>
            <td>
                <input name="price" value="${itemsCustom.price}">
            </td>
        </tr>
        <tr>
            <td>
               	上次修改时间：
            </td>
            <td>
                <input name="createtime" value="${itemsCustom.createtime}">
            </td>
        </tr>
        <tr>
            <td> 备注</td>
            <td> 
            <textarea name="detail" >${itemsCustom.detail }</textarea>  </td>
        </tr>
        <tr>
            <td colspan="2" align="center"><input type="submit" value="提交"  ></td>
        </tr>
    </table>
</form>
</body>
</html>
