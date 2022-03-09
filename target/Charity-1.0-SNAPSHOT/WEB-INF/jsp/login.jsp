<%--
  Created by IntelliJ IDEA.
  User: hoang
  Date: 3/1/2022
  Time: 1:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="header.jsp">
    <c:param name="title" value="Charity | Login"/>
</c:import>
<div class="login">
    <div class="login-form">
        <form action="${pageContext.request.contextPath}/login" method="post">
            <div class="form-group row">
                <label for="email" class="col-12">Email</label>
                <div class="col-12">
                    <input type="text" name="email" id="email" class="form-control" value="${cookieEmail}"/>
                    <span style="color: red;" id="email-mess"></span>
                </div>
            </div>
            <div class="form-group row">
                <label for="password" class="col-12">Password</label>
                <div class="col-12">
                    <input type="password" name="password" id="password" class="form-control" value="${cookiePassword}"/>
                    <span style="color: red;" id="password-mess"></span>
                </div>
            </div>
            <div>
                <input type="checkbox" name="checkRemember" value="ON"/>
                <label>Ghi nhớ đăng nhập</label>
            </div>
            <input type="submit" onclick="return submitValidate()" value="Đăng nhập" class="btn btn-primary"/>

            <a href="${pageContext.request.contextPath}/register">Đăng ký tài khoản mới</a> hoặc
            <a href="${pageContext.request.contextPath}/reset">Quên mật khẩu</a>
            <div><span style="color: red;">${error}</span></div>
        </form>
    </div>
    <script src="${pageContext.request.contextPath}/asset/login.js"></script>
</div>
