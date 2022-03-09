<%--
  Created by IntelliJ IDEA.
  User: hoang
  Date: 3/8/2022
  Time: 12:36 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="header.jsp">
    <c:param name="title" value="Charity | Reset password"/>
</c:import>
<div class="reset-password">
    <h2>Reset Your Password</h2>
    <p>
        Please enter your login email, we'll send a new random password to your inbox:
    </p>

    <form id="resetForm" action="${pageContext.request.contextPath}/reset" method="post">

        <div class="form-group row">
            <label class="col-12 col-sm-12 col-lg-2">Email:</label>
            <div class="col-12 col-sm-12 col-lg-10">
                <input class="form-control" type="text" name="email" id="email" size="20"/>
            </div>
        </div>
        <button type="submit" class="btn btn-primary">Send me new password</button>
    </form>
    <span>${message}</span>
</div>

<c:import url="footer.jsp"/>
