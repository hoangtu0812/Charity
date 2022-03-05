<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="header.jsp">
    <c:param name="title" value="Charity||Success"/>
</c:import>
<div class="success">
    <div class="noti col-md-6 ml-auto mr-auto">
        <h3>${message}</h3>
        <a class="btn btn-primary" href="${pageContext.request.contextPath}/dashboard/program-list">Go to Charity list</a>
    </div>
</div>
<c:import url="footer.jsp"/>