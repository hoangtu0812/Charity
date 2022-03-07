<%--
  Created by IntelliJ IDEA.
  User: hoang
  Date: 3/5/2022
  Time: 1:04 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="header.jsp">
    <c:param name="title" value="Charity | Detail"/>
</c:import>

<div class="detail">
    <script src="https://www.paypal.com/sdk/js?client-id=Ae1O4w3_sfrGorAl6rv-PBsxANFyTIhWBdWuAJkukFrGHM7TMH_N809iZFm1hKazT7s6YJZUoNfzzk2-&currency=USD"></script>
    <div class="detail-container">
        <h2>${program.name}</h2>
        <p>${program.des}</p>
        <img src="${pageContext.request.contextPath}/upload/${program.src}"/>
        <div>
            <p>${program.detail}</p>
        </div>
    </div>
    <!-- Set up a container element for the button -->
    <div class="donation-container">
        <div>
            <c:forEach var="donationCOM" items="${donationCOMS}">
                <div>${donationCOM.userName}</div>
                <div>${donationCOM.amount}</div>
            </c:forEach>
        </div>
        <!-- PayPal Logo -->
        <table border='0' cellpadding='10' cellspacing='0' align='center'>
            <tr>
                <td align='center'></td>
            </tr>
            <tr>
                <td align='center'><a href='${pageContext.request.contextPath}/checkout?id=${program.id}'
                                      title='How PayPal Works'><img
                        src='https://www.paypalobjects.com/webstatic/en_AU/i/buttons/btn_paywith_primary_l.png'
                        alt='Thanh toán bằng PayPal | Lớn'/></a></td>
            </tr>
        </table><!-- PayPal Logo -->

        <script src="${pageContext.request.contextPath}/asset/paypal.js"></script>

    </div>
<c:import url="footer.jsp"/>