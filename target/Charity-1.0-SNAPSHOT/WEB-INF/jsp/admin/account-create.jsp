<%--
  Created by IntelliJ IDEA.
  User: hoangtu
  Date: 02/02/2022
  Time: 08:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="header.jsp">
    <c:param name="title" value="Charity||Account Create"/>
</c:import>
<div class="account-create row">
    <form action="${pageContext.request.contextPath}/dashboard/account-create" METHOD="post" class="ml-auto mr-auto">
        <div class="col-md-12">
            <label for="email">E-mail</label>
            <input class="form-control" type="email" name="email" id="email" value="${resEmail}"/>
            <span style="color: red;" id="email-mess"></span>
        </div>
        <div class="col-md-12">
            <label for="password">Password</label>
            <input class="form-control" type="password" name="password" id="password" value="${password}"/>
            <span style="color: red;" id="password-mess"></span>
        </div>
        <div class="col-md-12">
            <label for="confirmPassword">Confirm Password</label>
            <input class="form-control" type="password" name="confirmPassword" id="confirmPassword" value="${confirmPassword}"/>
            <span style="color: red;" id="confirmPassword-mess"></span>
        </div>
        <div class="col-md-12">
            <label for="name">Full name</label>
            <input class="form-control" type="text" name="name" id="name" value="${name}"/>
            <span style="color: red;" id="name-mess"></span>
        </div>
        <div class="col-md-12">
            <label for="role">Role</label>
            <select class="form-control" name="role" id="role">
                <option value="1">Admin</option>
                <option selected="selected" value="0">User</option>
            </select>
        </div>
        <div class="col-md-12">
            <label for="address">Address</label>
            <input class="form-control" type="text" name="address" id="address" value="${address}"/>
            <span style="color: red;" id="address-mess"></span>
        </div>
        <div class="col-md-12">
            <label for="phone">Phone number</label>
            <input class="form-control" type="text" name="phone" id="phone" value="${phone}"/>
            <span style="color: red;" id="phone-mess"></span>
        </div>
        <input class="submit-btn btn btn-primary" type="submit" value="Submit" onclick="return submitValidate()"/>
        <input type="reset"  value="Reset" class="submit-btn btn btn-primary"/>
        <a href="${pageContext.request.contextPath}/dashboard/account-list" class="submit-btn btn btn-primary">Cancel</a>
        <p style="color: red; margin-left: 10px;">${error}</p>
    </form>
</div>
<script src="${pageContext.request.contextPath}/asset/create-account-admin.js"></script>
<c:import url="footer.jsp"/>

