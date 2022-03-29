<%--
  Created by IntelliJ IDEA.
  User: hoang
  Date: 3/12/2022
  Time: 1:11 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="header.jsp">
    <c:param name="title" value="Charity | Đổi thông tin"/>
</c:import>
<div class="register">
    <div class="register-form">
        <form action="<c:url value="/account/change-info"/> " method="post">
            <div class="form-group row">
                <div class="col-12 col-sm-12 col-lg-10">
                    <input type="hidden" name="email" id="email" placeholder="Nhập email của bạn..."
                           class="form-control" value="${email}"/>
                </div>
            </div>

            <div class="form-group row">
                <label for="name" class="col-12 col-sm-12 col-lg-2">Tên của bạn</label>
                <div class="col-12 col-sm-12 col-lg-10">
                    <input type="text" name="name" id="name"
                           class="form-control" value="${account.userName}"/>
                    <span style="color: red;" id="name-mess"></span>
                </div>
            </div>
            <div class="form-group row">
                <label for="phone" class="col-12 col-sm-12 col-lg-2">Số điện thoại</label>
                <div class="col-12 col-sm-12 col-lg-10">
                    <input type="text" name="phone" id="phone"
                           class="form-control" value="${account.phoneNumber}"/>
                    <span style="color: red;" id="phone-mess"></span>
                </div>
            </div>
            <div class="form-group row">
                <label for="address" class="col-12 col-sm-12 col-lg-2">Địa chỉ</label>
                <div class="col-12 col-sm-12 col-lg-10">
                    <input type="text" name="address" id="address"
                           class="form-control" value="${account.address}"/>
                    <span style="color: red;" id="address-mess"></span>
                </div>
            </div>
            <div>
                <input type="submit" value="Thay đổi" class="btn btn-primary" onclick="return submitValidate()">
            </div>
            <span style="color: red;">${message}</span>
            <span style="color: limegreen;">${ok}</span>
        </form>
    </div>
</div>
<c:import url="footer.jsp"/>