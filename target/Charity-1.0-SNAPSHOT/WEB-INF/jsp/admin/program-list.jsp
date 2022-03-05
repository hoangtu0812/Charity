<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="header.jsp">
    <c:param name="title" value="Charity||Program List"/>
</c:import>
<div class="program-list">
    <c:if test="${programList.size() == 0}">
        <h2>${searchMessage}</h2>
    </c:if>
    <table>
        <tr>
            <th>ID</th>
            <th class="col-md-4">Program Name</th>
            <th class="col-md-2">Foundation</th>
            <th class="col-md-1">Image source</th>
            <th class="col-md-2">Target</th>
            <th>End date</th>
            <th>Remaining</th>
            <th></th>
        </tr>
        <c:forEach var="program" items="${programList}">
            <tr>
                <td>${program.id}</td>
                <td class="col-md-4"><a
                        href="${pageContext.request.contextPath}/dashboard/program-detail?id=${program.id}">${program.name}</a>
                </td>
                <td class="col-md-2">${program.foundation}</td>
                <td class="col-md-1"><a href="${program.src}">Link</a></td>
                <td class="col-md-2">${program.target}</td>
                <td>${program.end}</td>
                <td>${program.left}</td>
                <td>
                    <a onclick="return confirm('Are you sure you want to delete this item?');"
                       href="${pageContext.request.contextPath}/dashboard/delete-program?id=${program.id}">Delete</a>/
                    <a href="${pageContext.request.contextPath}/dashboard/update-program-form?id=${program.id}">Edit</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <div class="row page">
        <div class="mr-auto">
            <a class="btn btn-primary create-btn"
               href="${pageContext.request.contextPath}/dashboard/create-program-form">Create</a>
            <button class="btn btn-primary create-btn" id="reload-btn">Reload</button>
        </div>
        <div class="ml-auto">
            <c:set var="page" value="${1}"/>
            <ul class="pagination page-list">
                <li class="page-item"><a class="page-link"
                                         href="${pageContext.request.contextPath}/dashboard/program-list?page=${param.page - 1}">&laquo;</a>
                </li>
                <c:forEach begin="${1}" end="${pageModel}">
                    <li class="page-item"><a class="page-link"
                                             href="${pageContext.request.contextPath}/dashboard/program-list?page=${page}">${page}</a>
                    </li>
                    <c:set var="page" value="${page + 1}"/>
                </c:forEach>
                <li class="page-item"><a class="page-link"
                                         href="${pageContext.request.contextPath}/dashboard/program-list?page=${param.page + 1}">&raquo;</a>
                </li>
            </ul>
        </div>
    </div>

</div>
<c:import url="footer.jsp"/>