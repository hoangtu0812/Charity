<%--
  Created by IntelliJ IDEA.
  User: hoang
  Date: 3/12/2022
  Time: 12:30 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="header.jsp">
    <c:param name="title" value="Charity||Program List"/>
</c:import>
<div class="program-list">
    <c:if test="${donationCOMS.size() == 0}">
        <h2>${searchMessage}</h2>
    </c:if>
    <table>
        <tr>
            <th>Email</th>
            <th class="col-md-4">Program Name</th>
            <th class="col-md-2">Amount</th>
            <%--            <th class="col-md-1">Image source</th>--%>
            <th><i class="fas fa-calendar-alt"></i> Date</th>
            <th>Transaction code</th>
        </tr>
        <c:forEach var="donation" items="${donationCOMS}">
            <tr>
                <td>${donation.userMail}</td>
                <td class="col-md-4">${donation.programName}
                </td>
                <td class="col-md-2">${donation.amountVND}</td>
                <td class="col-md-2">${donation.date}</td>
                <td>${donation.tcode}</td>
                <td>${program.left}</td>

            </tr>
        </c:forEach>
    </table>
    <div class="row page">
        <div class="ml-auto">
            <c:set var="page" value="${1}"/>
            <ul class="pagination page-list">
                <li class="page-item"><a class="page-link"
                                         href="${pageContext.request.contextPath}/dashboard/donation-list?page=${param.page - 1}">&laquo;</a>
                </li>
                <c:forEach begin="${1}" end="${pageModel}">
                    <li class="page-item"><a class="page-link"
                                             href="${pageContext.request.contextPath}/dashboard/donation-list?page=${page}">${page}</a>
                    </li>
                    <c:set var="page" value="${page + 1}"/>
                </c:forEach>
                <li class="page-item"><a class="page-link"
                                         href="${pageContext.request.contextPath}/dashboard/donation-list?page=${param.page + 1}">&raquo;</a>
                </li>
            </ul>
        </div>
    </div>

</div>
<c:import url="footer.jsp"/>
