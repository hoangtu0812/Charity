<%--
  Created by IntelliJ IDEA.
  User: hoang
  Date: 2/27/2022
  Time: 10:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="header.jsp">
    <c:param name="title" value="Charity | Trang chủ"/>
</c:import>
<div class="index">
    <div class="banner">
        <img style="width: 100%;" src="${pageContext.request.contextPath}/image/Charity-Banner.png"/>
    </div>
    <div class="program-list row ml-auto mr-auto">
        <c:forEach var="program" items="${programList}">
            <%--            <c:if test="${program.status == 1}">--%>
            <div class="col-12 col-lg-4 program-container">
                <div class="program">
                    <img style="width: 100%;" src="${pageContext.request.contextPath}/upload/${program.src}"/>
                    <h4>${program.name}</h4>
                    <h5>${program.foundation}</h5>
                    <p>${program.des}</p>
                    <div class="donation-container">
                        <div>${program.moneyStringCurrent}/${program.moneyString}</div>
                        <div>Còn lại ${program.left} ngày</div>
                            <%--                    <span>${program.target}</span>--%>
                        <a class="btn btn-primary" href="${pageContext.request.contextPath}/detail?id=${program.id}">Quyên
                            góp</a>
                    </div>
                </div>
            </div>
            <%--            </c:if>--%>
        </c:forEach>
    </div>
</div>

<c:import url="footer.jsp"/>





