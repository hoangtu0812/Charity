<%--
  Created by IntelliJ IDEA.
  User: hoang
  Date: 2/28/2022
  Time: 11:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="header.jsp">
    <c:param name="title" value="Charity | Đăng ký tài khoản thành công"/>
</c:import>

<div class="register-success col-6 mr-auto ml-auto" style="text-align: center; margin-top: 100px">
    <h3>Đăng ký tài khoản thành công !</h3>
    <p>${resEmail}</p>
    <a class="btn btn-primary" href="<c:url value="/login"/> ">Đăng nhập</a>
</div>

<c:import url="footer.jsp"/>
