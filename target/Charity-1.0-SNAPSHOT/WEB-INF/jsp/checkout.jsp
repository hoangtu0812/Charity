<%--
  Created by IntelliJ IDEA.
  User: hoang
  Date: 3/5/2022
  Time: 12:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="header.jsp">
    <c:param name="title" value="Charity | Checkout"/>
</c:import>

<div class="checkout">
    <script src="https://www.paypal.com/sdk/js?client-id=Ae1O4w3_sfrGorAl6rv-PBsxANFyTIhWBdWuAJkukFrGHM7TMH_N809iZFm1hKazT7s6YJZUoNfzzk2-&currency=USD"></script>
    <!-- Set up a container element for the button -->
    <div>
        <table>
            <tr>
                <td>Email:</td>
                <td>${account.userMail}</td>
            </tr>
            <tr>
                <td>Full Name:</td>
                <td>${account.userName}</td>
            </tr>
            <tr>
                <td>Phone number:</td>
                <td>${account.phoneNumber}</td>
            </tr>
            <tr>
                <td>Program:</td>
                <td>${program.name}</td>
            </tr>
        </table>
    </div>
    <div>
        <form action="${pageContext.request.contextPath}/donation" method="post" id="donation-form">
            <input type="hidden" name="userMail" value="${account.userMail}"/>
            <input type="hidden" name="userName" value="${account.userName}"/>
            <input type="hidden" name="userPhone" value="${account.phoneNumber}"/>
            <input type="hidden" name="programID" value="${program.id}">
            <input type="hidden" id="contextPath" value="${pageContext.request.contextPath}"/>
            <input type="text" name="amount" id="amount">
        </form>

        <div id="paypal-button-container"></div>
    </div>

    <script src="${pageContext.request.contextPath}/asset/paypal.js"></script>

</div>
<c:import url="footer.jsp"/>