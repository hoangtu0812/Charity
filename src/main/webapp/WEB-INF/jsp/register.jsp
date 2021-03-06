<%--
  Created by IntelliJ IDEA.
  User: hoang
  Date: 2/27/2022
  Time: 11:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="header.jsp">
    <c:param name="title" value="Charity | Đăng ký"/>
</c:import>
<div class="register">
    <div class="register-form">
        <form action="<c:url value="/register"/> " method="post">
            <div class="form-group row">
                <label for="email" class="col-12 col-sm-12 col-lg-2">Email</label>
                <div class="col-12 col-sm-12 col-lg-10">
                    <input type="text" name="email" id="email" placeholder="Nhập email của bạn..."
                           class="form-control" value="${resEmail}"/>
                    <span style="color: red;" id="email-mess"></span>
                </div>
            </div>
            <div class="form-group row">
                <label for="password" class="col-12 col-sm-12 col-lg-2">Mật khẩu</label>
                <div class="col-12 col-sm-12 col-lg-10">
                    <input type="password" name="password" id="password" placeholder="Ít nhất 8 ký tự"
                           class="form-control" value="${password}"/>
                    <span style="color: red;" id="password-mess"></span>
                </div>
            </div>
            <div class="form-group row">
                <label for="confirmPassword" class="col-12 col-sm-12 col-lg-2">Xác nhận mật khẩu</label>
                <div class="col-12 col-sm-12 col-lg-10">
                    <input type="password" name="confirmPassword" id="confirmPassword" placeholder="Nhập lại mật khẩu"
                           class="form-control" value="${confirmPassword}"/>
                    <span style="color: red;" id="confirmPassword-mess"></span>
                </div>
            </div>
            <div class="form-group row">
                <label for="name" class="col-12 col-sm-12 col-lg-2">Họ và tên</label>
                <div class="col-12 col-sm-12 col-lg-10">
                    <input type="text" name="name" id="name" placeholder="Nguyễn Văn A" class="form-control"
                           value="${name}"/>
                    <span style="color: red;" id="name-mess"></span>
                </div>
            </div>
            <div class="form-group row">
                <label for="address" class="col-12 col-sm-12 col-lg-2">Địa chỉ</label>
                <div class="col-12 col-sm-12 col-lg-10">
                    <input type="text" name="address" id="address" placeholder="Địa chỉ của bạn" class="form-control"
                           value="${address}"/>
                    <span style="color: red;" id="address-mess"></span>
                </div>
            </div>
            <div class="form-group row">
                <label for="phone" class="col-12 col-sm-12 col-lg-2">Số điện thoại</label>
                <div class="col-12 col-sm-12 col-lg-10">
                    <input type="text" name="phone" id="phone" placeholder="0123456789" class="form-control"
                           value="${phone}"/>
                    <span style="color: red;" id="phone-mess"></span>
                </div>
            </div>
            <div>
                <input type="submit" value="Đăng ký" class="btn btn-primary" onclick="return submitValidate()">
                <a href="${pageContext.request.contextPath}/login">Đăng nhập</a>
            </div>
            <span style="color: red;">${error}</span>
        </form>
    </div>
</div>
<script src="${pageContext.request.contextPath}/asset/register.js"></script>
<c:import url="footer.jsp"/>