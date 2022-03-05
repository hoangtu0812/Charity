<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="header.jsp">
    <c:param name="title" value="Charity||Program List"/>
</c:import>

<div class="program-detail">
    <table>
        <tr>
            <th class="col-md-1">ID</th>
            <td>${program.id}</td>
        </tr>
        <tr>
            <th class="col-md-1">Program name</th>
            <td>${program.name}</td>
        </tr>
        <tr>
            <th class="col-md-1">Description</th>
            <td>${program.des}</td>
        </tr>
        <tr>
            <th class="col-md-1">Detail</th>
            <td>${program.detail}</td>
        </tr>
        <tr>
            <th class="col-md-1">Foundation</th>
            <td>${program.foundation}</td>
        </tr>
        <tr>
            <th class="col-md-1">Image</th>
            <td><img style="width:100%;" src="${program.src}"/></td>
        </tr>
        <tr>
            <th class="col-md-1">Image source</th>
            <td><a href="${program.src}">${program.src}</a></td>
        </tr>
        <tr>
            <th class="col-md-1">Target</th>
            <td>${program.target}</td>
        </tr>
        <tr>
            <th class="col-md-1">End date</th>
            <td>${program.end}</td>
        </tr>
        <tr>
            <th class="col-md-1">Remaining</th>
            <td>${program.left} days</td>
        </tr>
    </table>
    <a style="margin-top: 10px;" class="btn btn-primary create-btn" onclick="return confirm('Are you sure you want to delete this item?');" href="${pageContext.request.contextPath}/dashboard/delete-program?id=${program.id}">Delete</a>

    <a style="margin-top: 10px;" class="btn btn-primary create-btn" href="${pageContext.request.contextPath}/dashboard/update-program-form?id=${program.id}">Edit</a>
    <a style="margin-top: 10px;" class="create-btn btn btn-primary" href="${pageContext.request.contextPath}/dashboard/program-list">Back</a>
</div>
<c:import url="footer.jsp"/>