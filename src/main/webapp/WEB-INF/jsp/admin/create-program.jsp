<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="header.jsp">
    <c:param name="title" value="Charity||Create program"/>
</c:import>
<div class="create-program">
    <form action="${pageContext.request.contextPath}/dashboard/create-program" method="post" class="row"
          id="create-account-form" enctype="multipart/form-data">
        <div class="col-md-12">
            <label for="name">Program Name</label>
            <input class="form-control" type="text" name="name" id="name"/>
            <span style="color: red;" id="name-mess"></span>
        </div>
        <div class="col-md-12 des">
            <label for="des">Describe</label>
            <textarea type="text" name="des" id="des" class="col-md-12 form-control"></textarea>
            <span style="color: red;" id="des-mess"></span>
        </div>
        <div class="col-md-12 detail">
            <label for="detail">Detail</label>
            <textarea type="text" name="detail" id="detail" class="col-md-12 form-control"></textarea>
            <span style="color: red;" id="detail-mess"></span>
        </div>
        <div class="col-md-6">
            <label for="foundation">Foundation</label>
<%--            <input class="form-control" type="text" name="foundation" id="foundation"/>--%>
            <select class="form-control" name="foundation" id="foundation">
                <option value="RAIN COFFEE">RAIN COFFEE</option>
                <option value="SUGAR Vietnam">SUGAR Vietnam</option>
                <option value="Thien Nhan & Friend">Thien Nhan & Friend</option>
                <option value="Sức mạnh 2000">Sức mạnh 2000</option>
                <option value="Think Playgrounds">Think Playgrounds</option>
            </select>
            <span style="color: red;" id="foundation-mess"></span>
        </div>
        <div class="col-md-6">
            <label for="src">Image source</label>
            <input class="form-control" type="file" name="file" id="src"/>
            <span style="color: red;" id="src-mess"></span>
        </div>
        <div class="col-md-6">
            <label for="target">Target</label>
            <input class="form-control" type="text" name="target" id="target"/>
            <span style="color: red;" id="target-mess"></span>
        </div>
        <div class="col-md-6">
            <label for="endtime">End time</label>
            <input class="form-control" type="date" name="endtime" id="endtime"/>
            <span style="color: red;" id="endtime-mess"></span>
        </div>

        <div class="submit-btn" onclick="return confirmUpdateClick()"><input class="btn btn-primary" type="submit"
                                                                             value="Submit"/></div>
        <div class="submit-btn"><input type="reset" value="Reset" class="btn btn-primary"/></div>
        <a class="submit-btn btn btn-primary"
           href="${pageContext.request.contextPath}/dashboard/program-list">Cancel</a>
        <span style="color: red;">${error}</span>
    </form>
</div>
<script src="${pageContext.request.contextPath}/asset/update-program.js"></script>
<script src="${pageContext.request.contextPath}/asset/create-program.js"></script>
<c:import url="footer.jsp"/>

