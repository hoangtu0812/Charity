<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: hoang
  Date: 2/27/2022
  Time: 1:12 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>${param.title}</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/register.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/header.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/index.css">
    <link rel="shortcut icon" type="image/x-icon" href="${pageContext.request.contextPath}/image/logo.png"/>
    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script
            src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script
            src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script
            src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <script src="https://kit.fontawesome.com/293dbbaba2.js"
            crossorigin="anonymous"></script>

</head>
<body>
<div class="header">
    <nav class="navbar navbar-expand-md  ml-auto mr-auto navbar-dark">
        <a class="navbar-brand nav-link" href="${pageContext.request.contextPath}" title="Charity Logo"><img
                style="height: 50px;" src="${pageContext.request.contextPath}/image/logo.png"></a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
<%--            <span class="navbar-toggler-icon" ></span>--%>
            <span class="navbar-toggler-icon navbar-dark" ></span>
        </button>
        <div class="collapse navbar-collapse" id="collapsibleNavbar" >
            <ul class="navbar-nav">
                <li class="nav-item p-sm-2 pl-lg-4 pr-lg-4">
                    <a class="nav-link" href="${pageContext.request.contextPath}">Trang chủ</a>
                </li>
                <li class="nav-item p-sm-2 pl-lg-4 pr-lg-4">
                    <a class="nav-link" href="">Menu1</a>
                </li>
                <li class="nav-item p-sm-2 pl-lg-4 pr-lg-4">
                    <a class="nav-link" href="#">Menu2</a>
                </li>
                <li class="nav-item p-sm-2 pl-lg-4 pr-lg-4">
                    <a class="nav-link" href="#">Menu3</a>
                </li>
                <li class="nav-item p-sm-2 pl-lg-4 pr-lg-4">
                    <a class="nav-link" href="#">Menu4</a>
                </li>
                <li class="nav-item p-sm-2 pl-lg-4 pr-lg-4">

<%--                    <c:if test="${email != null}">--%>
<%--                        <div class="row">--%>
<%--                            <a class="nav-link" href="#">${email}</a>--%>
<%--                            <a class="nav-link" href="<c:url value="/logout"/> ">Đăng xuất</a>--%>
<%--                        </div>--%>
<%--                    </c:if>--%>
                    <c:if test="${email != null}">
                        <div class="dropdown show">
                            <a class="btn btn-secondary dropdown-toggle" href="#" role="button" id="dropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                ${email}
                            </a>

                            <div class="dropdown-menu" aria-labelledby="dropdownMenuLink">
                                <a class="dropdown-item" href="#">Profile</a>
                                <a class="dropdown-item" href="<c:url value="/history"/> ">History</a>
                                <a class="dropdown-item" href="<c:url value="/logout"/> ">Logout</a>
                            </div>
                        </div>
                    </c:if>
                    <c:if test="${email == null}">
                        <a class="nav-link" href="<c:url value="/login"/> ">Đăng nhập</a>
                    </c:if>
                </li>
            </ul>
        </div>
    </nav>
</div>


