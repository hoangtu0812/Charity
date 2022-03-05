<%--
  Created by IntelliJ IDEA.
  User: hoang
  Date: 3/5/2022
  Time: 3:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="header.jsp">
    <c:param name="title" value="Charity | History"/>
</c:import>
<div class="history">
    <div>
        <table>
            <tr>
                <th>Tên chương trình quyên góp</th>
                <th>Thời gian giao dịch</th>
                <th>Số tiền</th>
            </tr>
        <c:forEach var="donationCOM" items="${donationCOMS}" >
            <tr>
                <td>${donationCOM.programName}</td>
                <td>${donationCOM.date}</td>
                <td>${donationCOM.amount}</td>
            </tr>
        </c:forEach>
        </table>
    </div>

</div>

<c:import url="footer.jsp"/>
