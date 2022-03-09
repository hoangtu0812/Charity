<%--
  Created by IntelliJ IDEA.
  User: hoang
  Date: 3/8/2022
  Time: 1:51 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="header.jsp">
  <c:param name="title" value="Charity | Trang chủ"/>
</c:import>
<div class="register">
  <div class="register-form">
    <form action="<c:url value="/change-password"/> " method="post">
      <div class="form-group row">
<%--        <label for="email" class="col-12 col-sm-12 col-lg-2">Email</label>--%>
        <div class="col-12 col-sm-12 col-lg-10">
          <input type="hidden" name="email" id="email" placeholder="Nhập email của bạn..."
                 class="form-control" value="${email}"/>
          <span style="color: red;" id="email-mess"></span>
        </div>
      </div>

      <div class="form-group row">
        <label for="password" class="col-12 col-sm-12 col-lg-2">Mật khẩu hiện tại</label>
        <div class="col-12 col-sm-12 col-lg-10">
          <input type="password" name="password" id="password"
                 class="form-control"/>
          <span style="color: red;" id="password-mess"></span>
        </div>
      </div>
      <div class="form-group row">
        <label for="newPassword" class="col-12 col-sm-12 col-lg-2">Mật khẩu mới</label>
        <div class="col-12 col-sm-12 col-lg-10">
          <input type="password" name="newPassword" id="newPassword" placeholder="Ít nhất 8 ký tự"
                 class="form-control"/>
          <span style="color: red;" id="newPassword-mess"></span>
        </div>
      </div>
      <div class="form-group row">
        <label for="confirmPassword" class="col-12 col-sm-12 col-lg-2">Xác nhận mật khẩu</label>
        <div class="col-12 col-sm-12 col-lg-10">
          <input type="password" name="confirmPassword" id="confirmPassword" placeholder="Nhập lại mật khẩu"
                 class="form-control"/>
          <span style="color: red;" id="confirmPassword-mess"></span>
        </div>
      </div>



      <div>
        <input type="submit" value="Xác nhận" class="btn btn-primary" onclick="return submitValidate()">
      </div>
      <span style="color: red;">${message}</span>
    </form>
  </div>
</div>

<c:import url="footer.jsp"/>