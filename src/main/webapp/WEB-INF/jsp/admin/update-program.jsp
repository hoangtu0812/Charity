<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="header.jsp">
    <c:param name="title" value="Charity|| Program Update"/>
</c:import>
<div class="update-program">
    <form action="${pageContext.request.contextPath}/dashboard/update-program" method="post" class="row">
        <div>
            <input class="form-control" type="hidden" name="id" id="id" value="${program.id}" readonly>
        </div>
        <div class="col-md-12">
            <label for="name">Program Name</label>
            <input class="form-control" type="text" name="name" id="name" value="${program.name}"/>
            <span style="color: red;" id="name-mess"></span>
        </div>
        <div class="col-md-12 des">
            <label for="des">Describe</label>
            <textarea name="des" id="des" class="col-md-12 form-control">${program.des}</textarea>
            <span style="color: red;" id="des-mess"></span>
        </div>
        <div class="col-md-12 detail">
            <label for="detail">Detail</label>
            <textarea type="text" name="detail" id="detail" class="col-md-12 form-control">${program.detail}</textarea>
            <span style="color: red;" id="detail-mess"></span>
        </div>
        <div class="col-md-6">
            <label for="foundation">Foundation</label>
            <input class="form-control" type="text" name="foundation" id="foundation" value="${program.foundation}"/>
            <span style="color: red;" id="foundation-mess"></span>
        </div>
        <div class="col-md-6">
            <label for="src">Image source</label>
            <input class="form-control" type="text" name="src" id="src" value="${program.src}"/>
            <span style="color: red" id="src-mess"></span>
        </div>
        <div class="col-md-6">
            <label for="target">Target</label>
            <input class="form-control" type="text" name="target" id="target" value="${program.target}"/>
            <span style="color:red;" id="target-mess"></span>
        </div>
        <div class="col-md-6">
            <label for="endtime">End time</label>
            <input class="form-control" type="date" name="endtime" id="endtime" value="${program.end}"/>
            <span style="color: red;" id="endtime-mess"></span>
        </div>
        <div class="submit-btn"><input class="btn btn-primary" onclick="return confirmUpdateClick()" type="submit" value="Submit"/></div>
        <a class="submit-btn btn btn-primary" href="${pageContext.request.contextPath}/dashboard/program-list">Cancel</a>
        <span style="color: red;">${error}</span>
    </form>
</div>
<script src="${pageContext.request.contextPath}/asset/update-program.js"></script>
<c:import url="footer.jsp"/>

