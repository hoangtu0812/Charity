<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="header.jsp">
    <c:param name="title" value="Charity||Account Create"/>
</c:import>
<div class="account-create row">
    <form action="${pageContext.request.contextPath}/dashboard/account-update" METHOD="post" class="ml-auto mr-auto">
        <div class="col-md-12">
            <label for="email">E-mail</label>
            <input class="form-control" type="email" name="email" id="email" value="${account.userMail}" readonly/>
            <span style="color: red;" id="email-mess"></span>
        </div>
        <div class="col-md-12">
            <label for="password">Password</label>
            <input class="form-control" type="password" name="password" id="password" value="${account.password}"
                   readonly/>
            <span style="color: red;" id="password-mess"></span>
        </div>
        <div class="col-md-12">
            <label for="name">Full name</label>
            <input class="form-control" type="text" name="name" id="name" value="${account.userName}"/>
            <span id="name-mess" style="color: red;"></span>
        </div>
        <c:if test="${account.role == 1}">
            <div class="col-md-12">
                <label for="role">Role</label>
                <select class="form-control" name="role" id="role">
                    <option value="1">Admin</option>
                    <option value="0">User</option>
                </select>
            </div>
        </c:if>
        <c:if test="${account.role == 0}">
            <div class="col-md-12">
                <label for="role">Role</label>
                <select class="form-control" name="role" id="role">
                    <option value="0">User</option>
                    <option value="1">Admin</option>
                </select>
            </div>
        </c:if>
        <div class="col-md-12">
            <label for="address">Address</label>
            <input class="form-control" type="text" name="address" id="address" value="${account.address}"/>
            <span style="color: red;" id="address-mess"></span>
        </div>
        <div class="col-md-12">
            <label for="phone">Phone number</label>
            <input class="form-control" type="text" name="phone" id="phone" value="${account.phoneNumber}"/>
            <span style="color: red;" id="phone-mess"></span>
        </div>
        <div>
            <span style="color: red;">${message}</span>
        </div>
        <input class="submit-btn btn btn-primary" type="submit" value="Submit" onclick="return submitValidate()"/>
        <a class="submit-btn btn btn-primary"
           href="${pageContext.request.contextPath}/dashboard/account-list">Cancel</a>
    </form>
</div>
<script src="${pageContext.request.contextPath}/asset/create-account-admin.js"></script>
<c:import url="footer.jsp"/>