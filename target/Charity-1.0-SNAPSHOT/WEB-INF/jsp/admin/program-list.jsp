<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="header.jsp">
    <c:param name="title" value="Charity||Program List"/>
</c:import>
<div class="program-list">
<%--    <div class="program-list-functional">--%>
<%--        <form action="${pageContext.request.contextPath}/dashboard/search-program" class="form-inline">--%>
<%--            <input type="text" name="search" class="form-control mr-sm-2" placeholder="Search" value="${key}"/>--%>
<%--            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>--%>
<%--        </form>--%>
<%--    </div>--%>
    <c:if test="${programList.size() == 0}">
        <h2>${searchMessage}</h2>
    </c:if>
    <table>
        <tr>
            <th>ID</th>
            <th class="col-md-4">Program Name</th>
            <th class="col-md-2">Foundation</th>
<%--            <th class="col-md-1">Image source</th>--%>
            <th class="col-md-2">Current/Target</th>
            <th><i class="fas fa-calendar-alt"></i> End date</th>
            <th>Remaining</th>
            <th>Status</th>
            <th></th>
        </tr>
        <c:forEach var="program" items="${programList}">
            <tr>
                <td>${program.id}</td>
                <td class="col-md-4"><a
                        href="${pageContext.request.contextPath}/dashboard/program-detail?id=${program.id}">${program.name}</a>
                </td>
                <td class="col-md-2">${program.foundation}</td>
<%--                <td class="col-md-1"><a href="${program.src}">Link</a></td>--%>
                <td class="col-md-2">${program.moneyStringCurrent}/${program.moneyString}</td>
                <td>${program.end}</td>
                <td>${program.left}</td>
                <td>
                    <c:if test="${program.status == 1}">
                        <p style="color: chartreuse;">Active</p>
                    </c:if>
                    <c:if test="${program.status != 1}"><p style="color: red;">Inactive</p></c:if>
                </td>
                <td>
                    <a onclick="return confirm('Are you sure you want to delete this item?');"
                       href="${pageContext.request.contextPath}/dashboard/delete-program?id=${program.id}">Delete</a>/
                    <a href="${pageContext.request.contextPath}/dashboard/update-program-form?id=${program.id}">Edit</a>/
                    <c:if test="${program.status == 1}"><a href="${pageContext.request.contextPath}/dashboard/disable?id=${program.id}" >Inactive</a></c:if>
                    <c:if test="${program.status != 1}"><a href="${pageContext.request.contextPath}/dashboard/enable?id=${program.id}" >Active</a></c:if>

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