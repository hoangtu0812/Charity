<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="header.jsp">
    <c:param name="title" value="Charity||Account"/>
</c:import>
<div class="account-list">
    <form action="${pageContext.request.contextPath}/dashboard/delete-multiple-account">
    <table>
        <tr>
            <th></th>
            <th>Email</th>
            <th>Full name</th>
            <th>Role</th>
            <th>Address</th>
            <th>Phone number</th>
            <th>Status</th>
            <th></th>
        </tr>
        <c:forEach var="account" items="${accountList}">
            <tr>
                <td><input type="checkbox" name="chk" value="${account.userMail}"/></td>
                <td>${account.userMail}</td>
                <td>${account.userName}</td>
                <td><c:if test="${account.role == 1}">admin</c:if><c:if test="${account.role == 0}">user</c:if></td>
                <td>${account.address}</td>
                <td>${account.phoneNumber}</td>
                <td>
                    <c:if test="${account.status == 1}"><p style="color: green;">Active</p></c:if>
                    <c:if test="${account.status != 1}"><p style="color: red;">Banned</p></c:if>
                </td>
                <td>
                    <a onclick="return confirm('Are you sure you want to delete this item?')" href="${pageContext.request.contextPath}/dashboard/account-delete?email=${account.userMail}">Delete</a>/
                    <a href="${pageContext.request.contextPath}/dashboard/account-update?email=${account.userMail}">Edit</a>/
                    <c:if test="${account.status == 1}"><a href="${pageContext.request.contextPath}/dashboard/ban?email=${account.userMail}">Ban</a></c:if>
                    <c:if test="${account.status != 1}"><a href="${pageContext.request.contextPath}/dashboard/unban?email=${account.userMail}">Unban</a></c:if>
                </td>
            </tr>
        </c:forEach>
    </table>
    <div style="margin-top: 10px; margin-left: 10px; margin-right: 10px;" class="row">
        <div class="mr-auto">
            <a class="btn btn-primary" href="${pageContext.request.contextPath}/dashboard/account-create">Add User</a>
            <button class="btn btn-primary" id="reload-btn">Reload</button>
            <input type="submit" value="Delete Multiple" class="btn btn-primary create-btn" onclick="return confirm('Are you sure you want to delete these items?')">
        </div>
        <div class="ml-auto">
            <c:set var="page" value="${1}"/>
            <ul class="pagination">
                <li class="page-item"><a class="page-link"
                                         href="${pageContext.request.contextPath}/dashboard/account-list?page=${param.page - 1}">&laquo;</a>
                </li>
                <c:forEach begin="${1}" end="${pageModel}">
                    <li class="page-item"><a class="page-link"
                                             href="${pageContext.request.contextPath}/dashboard/account-list?page=${page}">${page}</a>
                    </li>
                    <c:set var="page" value="${page + 1}"/>
                </c:forEach>
                <li class="page-item"><a class="page-link"
                                         href="${pageContext.request.contextPath}/dashboard/account-list?page=${param.page + 1}">&raquo;</a>
                </li>
            </ul>
        </div>
    </div>
    </form>
    <p style="color: red;">${error}</p>
    <p style="color: green;">${message}</p>
</div>
<c:import url="footer.jsp"/>
