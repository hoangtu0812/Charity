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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/registersuccess.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/resetpassword.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/detail.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/checkout.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/history.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/footer.css">
    <link rel="shortcut icon" type="image/x-icon" href="${pageContext.request.contextPath}/image/logo.png"/>
<%--    <script>--%>
<%--        function SubForm (){--%>
<%--            $.ajax({--%>
<%--                url:"https://api.apispreadsheets.com/data/e1hBb7KWSr1yNkWG/",--%>
<%--                type:"post",--%>
<%--                data:$("#myForm").serializeArray(),--%>
<%--                success: function(){--%>
<%--                    alert("Form Data Submitted :)")--%>
<%--                },--%>
<%--                error: function(){--%>
<%--                    alert("There was an error :(")--%>
<%--                }--%>
<%--            });--%>
<%--        }--%>
<%--    </script>--%>
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
<%--    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet"--%>
<%--          integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">--%>

</head>
<body>
<div class="header">
    <nav class="navbar navbar-expand-md  ml-auto mr-auto navbar-dark">
        <a class="navbar-brand nav-link" href="${pageContext.request.contextPath}" title="Charity Logo"><img
                style="height: 50px;" src="${pageContext.request.contextPath}/image/logo.png"></a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
            <%--            <span class="navbar-toggler-icon" ></span>--%>
            <span class="navbar-toggler-icon navbar-dark"></span>
        </button>
        <div class="collapse navbar-collapse" id="collapsibleNavbar">
            <ul class="navbar-nav">
                <li class="nav-item p-sm-2 pl-lg-2 pr-lg-2">
                    <a class="nav-link" href="${pageContext.request.contextPath}">Trang chủ</a>
                </li>
                <li class="nav-item p-sm-2 pl-lg-2 pr-lg-2">
                    <a class="nav-link" href="${pageContext.request.contextPath}/list">Hoạt động</a>
                </li>
                <li class="nav-item p-sm-2 pl-lg-2 pr-lg-2">
                    <a class="nav-link" href="${pageContext.request.contextPath}/feedback">Góp ý</a>
                </li>
<%--                <li class="nav-item p-sm-2 pl-lg-4 pr-lg-4">--%>
<%--                    <a class="nav-link" href="#">Menu3</a>--%>
<%--                </li>--%>
<%--                <li class="nav-item p-sm-2 pl-lg-4 pr-lg-4">--%>
<%--                    <a class="nav-link" href="#">Menu4</a>--%>
<%--                </li>--%>
                <li class="nav-item p-sm-2 pl-lg-2 pr-lg-2">

                    <%--                    <c:if test="${email != null}">--%>
                    <%--                        <div class="row">--%>
                    <%--                            <a class="nav-link" href="#">${email}</a>--%>
                    <%--                            <a class="nav-link" href="<c:url value="/logout"/> ">Đăng xuất</a>--%>
                    <%--                        </div>--%>
                    <%--                    </c:if>--%>
                    <c:if test="${email != null}">
                        <div class="dropdown show">
                            <a class="btn btn-secondary dropdown-toggle" href="#" role="button" id="dropdownMenuLink"
                               data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    ${sessionAccount.userName}
                            </a>

                            <div class="dropdown-menu" aria-labelledby="dropdownMenuLink">
                                <c:if test="${sessionAccount.role == 1}"><a class="dropdown-item" href="${pageContext.request.contextPath}/dashboard">Quản trị</a></c:if>
                                <a class="dropdown-item" href="<c:url value="/account/change-info"/> ">Đổi thông tin</a>
                                <a class="dropdown-item" href="<c:url value="/change-password"/> ">Đổi mật khẩu</a>
                                <a class="dropdown-item" href="<c:url value="/history"/> ">Lịch sử quyên góp</a>
                                <a class="dropdown-item" href="<c:url value="/logout"/> ">Đăng xuất</a>
                            </div>
                        </div>
                    </c:if>
                    <c:if test="${email == null}">
                        <a class="nav-link" href="<c:url value="/login"/> ">Đăng nhập</a>
                    </c:if>
                </li>
            </ul>
            <form action="${pageContext.request.contextPath}/search" class="form-inline my-2 my-lg-0">
                <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search" name="search">
                <button class="btn btn-primary my-2 my-sm-0" type="submit">Search</button>
            </form>
        </div>
    </nav>
</div>


