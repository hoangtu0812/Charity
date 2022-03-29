<%--
  Created by IntelliJ IDEA.
  User: hoang
  Date: 2/27/2022
  Time: 10:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
                            <p>Còn lại <b>${program.left}</b> ngày</p>
                            <a class="btn btn-primary" href="<c:url value="/detail?id=${program.id}"/> ">Quyên góp</a>
                        </div>
                    </div>
                </div>
            </div>
        </c:forEach>
        <div class="donation-list" style="width: 100%;padding-left: 15px; padding-right: 15px; margin-top: 50px;" >
            <table class="table" style="width: 100%">
                <thead class="thead-light">
                <tr>
                    <th scope="col">Nhà hảo tâm</th>
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
    </div>
</div>
<div class="container" style="width: 50%; text-align: center;">
    <div class="accordion" id="accordionExample">
        <div class="steps">
            <progress id="progress" value=0 max=100 ></progress>
            <div class="step-item">
                <button class="step-button text-center" type="button" data-bs-toggle="collapse"
                        data-bs-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
                    1
                </button>
                <div class="step-title">
                    Bước 1
                </div>
            </div>
            <div class="step-item">
                <button class="step-button text-center collapsed" type="button" data-bs-toggle="collapse"
                        data-bs-target="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
                    2
                </button>
                <div class="step-title">
                    Bước 2
                </div>
            </div>
            <div class="step-item">
                <button class="step-button text-center collapsed" type="button" data-bs-toggle="collapse"
                        data-bs-target="#collapseThree" aria-expanded="false" aria-controls="collapseThree">
                    3
                </button>
                <div class="step-title">
                    Bước 3
                </div>
            </div>
        </div>

        <div class="card">
            <div  id="headingOne">
            </div>

            <div id="collapseOne" class="collapse show" aria-labelledby="headingOne"
                 data-bs-parent="#accordionExample">
                <div class="card-body">
                    <h4>Chọn chương trình muốn quyên góp</h4>
                    <img style="width: 50%;" src="${pageContext.request.contextPath}/image/step1.png"/>
                </div>
            </div>
        </div>
        <div class="card">
            <div  id="headingTwo">

            </div>
            <div id="collapseTwo" class="collapse" aria-labelledby="headingTwo" data-bs-parent="#accordionExample">
                <div class="card-body">
                    <h4>Đăng nhập</h4>
                    <img style="width: 50%;" src="${pageContext.request.contextPath}/image/step2.png"/>
                </div>
            </div>
        </div>
        <div class="card">
            <div  id="headingThree">

            </div>
            <div id="collapseThree" class="collapse" aria-labelledby="headingThree"
                 data-bs-parent="#accordionExample">
                <div class="card-body">
                    <h4>Nhập số tiền muốn quyên góp</h4>
                    <img style="width: 50%;" src="${pageContext.request.contextPath}/image/step3.png"/>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj" crossorigin="anonymous"></script>
<script>
    const stepButtons = document.querySelectorAll('.step-button');
    const progress = document.querySelector('#progress');

    Array.from(stepButtons).forEach((button,index) => {
        button.addEventListener('click', () => {
            progress.setAttribute('value', index * 100 /(stepButtons.length - 1) );//there are 3 buttons. 2 spaces.

            stepButtons.forEach((item, secindex)=>{
                if(index > secindex){
                    item.classList.add('done');
                }
                if(index < secindex){
                    item.classList.remove('done');
                }
            })
        })
    })
</script>
<c:import url="footer.jsp"/>





