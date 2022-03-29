<%--
  Created by IntelliJ IDEA.
  User: hoang
  Date: 3/9/2022
  Time: 9:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="header.jsp">
    <c:param name="title" value="Charity | Hoạt động"/>
</c:import>
<div class="index">

    <div class="program-list row ml-auto mr-auto">
        <c:forEach var="program" items="${programList}">
            <div class="col-lg-4 program-container">
                <div class="card-deck program">
                    <div class="card">
                        <div class="card-body">
                            <img style="width: 100%;" src="${pageContext.request.contextPath}/upload/${program.src}"/>
                            <h4 class="card-title">${program.name}</h4>
                            <p class="card-text">${program.des}</p>
                        </div>
                        <div class="card-footer text-muted ">
                            <p>${program.moneyStringCurrent}/${program.moneyString}</p>
                            <div class="progress">
                                <div class="progress-bar progress-bar-striped progress-bar-animated" role="progressbar" aria-valuenow="${program.progress}" aria-valuemin="0" aria-valuemax="100" style="width: ${program.progress}%"></div>
                            </div>
                            <p>Còn lại ${program.left} ngày</p>
                            <a class="btn btn-primary" href="<c:url value="/detail?id=${program.id}"/> ">Quyên góp</a>
                        </div>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
    <div class="row page">
        <div class="ml-auto mr-auto">
            <c:set var="page" value="${1}"/>
            <ul class="pagination page-list">
                <li class="page-item"><a class="page-link"
                                         href="${pageContext.request.contextPath}/list?page=${param.page - 1}">&laquo;</a>
                </li>
                <c:forEach begin="${1}" end="${pageModel}">
                    <li class="page-item"><a class="page-link"
                                             href="${pageContext.request.contextPath}/list?page=${page}">${page}</a>
                    </li>
                    <c:set var="page" value="${page + 1}"/>
                </c:forEach>
                <li class="page-item"><a class="page-link"
                                         href="${pageContext.request.contextPath}/list?page=${param.page + 1}">&raquo;</a>
                </li>
            </ul>
        </div>
    </div>

</div>
<c:import url="footer.jsp"/>