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

<div class="detail mr-auto ml-auto row">
    <script src="https://www.paypal.com/sdk/js?client-id=Ae1O4w3_sfrGorAl6rv-PBsxANFyTIhWBdWuAJkukFrGHM7TMH_N809iZFm1hKazT7s6YJZUoNfzzk2-&currency=USD"></script>
    <div class="detail-container col-12 col-sm-12 col-lg-8 card">
        <h2>${program.name}</h2>
        <p>${program.des}</p>
        <img src="${pageContext.request.contextPath}/upload/${program.src}" style="width: 100%"/>
        <div>
            <p>${program.detail}</p>
        </div>
    </div>
    <!-- Set up a container element for the button -->
    <div class="donation-container col-12 col-sm-12 col-lg-4">
<%--        <div>--%>
<%--            <c:forEach var="donationCOM" items="${donationCOMS}">--%>
<%--                <div>${donationCOM.userName}</div>--%>
<%--                <div>${donationCOM.amount}</div>--%>
<%--            </c:forEach>--%>
<%--        </div>--%>
        <div class=" program">
            <div class="card">
                <div class="card-body">
                    <table class="table" style="width: 100%">
                        <thead class="thead-light">
                        <tr>
                            <th scope="col">Người quyên góp</th>
                            <th scope="col">Số tiền</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="donationCOM" items="${donationCOMS}">
                            <tr>
                                <td>${donationCOM.userName}</td>
                                <td>${donationCOM.amountVND}</td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
                <div class="card-footer text-muted ">
                    <p>${program.moneyStringCurrent}/${program.moneyString}</p>
                    <div class="progress">
                        <div class="progress-bar progress-bar-striped progress-bar-animated" role="progressbar" aria-valuenow="${program.progress}" aria-valuemin="0" aria-valuemax="100" style="width: ${program.progress}%"></div>
                    </div>
                    <p>Còn lại ${program.left} ngày</p>
<%--                    <a class="btn btn-primary" href="<c:url value="/detail?id=${program.id}"/> ">Quyên góp</a>--%>
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
                </div>
            </div>
        </div>


        <script src="${pageContext.request.contextPath}/asset/paypal.js"></script>

    </div>
</div>
<c:import url="footer.jsp"/>