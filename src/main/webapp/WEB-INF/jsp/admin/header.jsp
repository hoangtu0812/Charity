<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <meta charset="UTF-8">
    <title>${param.title}</title>
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/css/dashboard.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/program-list.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/update-program.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/create-program.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/success.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/account-create.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/delete-fail.css">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script src="${pageContext.request.contextPath}/asset/jQuery.js"></script>
    <script src="${pageContext.request.contextPath}/asset/dashboard.js"></script>
    <script src="${pageContext.request.contextPath}/asset/programlist.js"></script>

    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script
            src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script
            src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script
            src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <script src="https://kit.fontawesome.com/293dbbaba2.js" crossorigin="anonymous"></script>

</head>
<body>
<div class="viewport">
    <div class="sidebar">
        <header>
            <a href="${pageContext.request.contextPath}">Dashboard</a>
        </header>
        <ul class="sidenav">
            <li><a
                    href="#">Home Page</a></li>
            <li id="charity-program"><a href="${pageContext.request.contextPath}/dashboard/program-list">Charity
                Programs</a></li>
            <li id="account-manager"><a href="${pageContext.request.contextPath}/dashboard/account-list">Account
                Manager</a></li>
        </ul>
    </div>
    <div class="content">
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <c:if test="${programList != null}">
                <form action="${pageContext.request.contextPath}/dashboard/search-program" class="form-inline">
                    <input type="text" name="search" class="form-control mr-sm-2" placeholder="Search" value="${key}"/>
                    <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
                </form>
            </c:if>
            <ul class="navbar-nav ml-auto">
                <li class="nav-item">(${email})</li>
                <li class="nav-item"><a
                        href="${pageContext.request.contextPath}/logout">Logout</a></li>
            </ul>
        </nav>
        <div class="container-fluid right-side">

