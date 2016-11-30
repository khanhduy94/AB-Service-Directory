<%--
  User: Ranga Reddy
  Date: 1/27/2015
  Time: 9:52 PM
  --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Geographys List</title>
<!-- Bootstrap CSS -->
<%-- <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet"> --%>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<style type="text/css">
.example {
	margin: 20px;
}
</style>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>

	<div class="container myrow-container">
		<div class="panel panel-success">
			<div class="panel-heading">
				<h3 class="panel-title">
					<div align="center">
						<h3 style="color: black;">
							<b>GEOGRAPHYS LIST</b>
						</h3>
					</div>
					<div align="right">
						<a href="createGeography"><span
							class="glyphicon glyphicon-plus"></span><b> ADD</b></a>
					</div>
				</h3>
			</div>
			<div class="panel-body">
				<c:if test="${empty geographyList}">
                There are no Geographys
            </c:if>
				<c:if test="${not empty geographyList}">

					<form action="searchGeography">
						<div class="row">
							<div class="col-md-5">
								<span class="glyphicon glyphicon-search"></span> <input
									type='text' name='searchName' id='searchName'
									placeholder="Enter Name" /> <input class="btn btn-info"
									type='submit' value='Search' />
							</div>

						</div>
					</form>

					<hr />

					<table class="table table-hover table-bordered">
						<thead style="background-color: #708090;">
							<tr style="color: white;">
								<th>ID</th>
								<th>NAME</th>
								<th>REGION</th>
								<th>DISTRICT</th>
								<th>DESCRIPTION</th>
								<th>EDIT</th>
								<th>DELETE</th>
							</tr>
						</thead>
						<tbody style="background-color: #F0F8FF;">
							<c:forEach items="${geographyList}" var="org">
								<tr>
									<th><c:out value="${org.id}" /></th>
									<th><c:out value="${org.countryName}" /></th>
									<th><c:out value="${org.region}" /></th>
									<th><c:out value="${org.district}" /></th>
									<th><c:out value="${org.description}" /></th>
									<th><a href="editGeography?id=<c:out value='${org.id}'/>"><span
											class="glyphicon glyphicon-edit"></span></a></th>
									<th><a
										href="deleteGeography?id=<c:out value='${org.id}'/>"><span
											class="glyphicon glyphicon-trash"></span></a></th>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</c:if>
			</div>
		</div>

		<jsp:include page="footer.jsp"></jsp:include>

		<script
			src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
		<script
			src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

		<%-- <script src="<c:url value="/resources/js/jquery-2.1.3.js"/>"></script>
    <script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
     --%>
</body>
</html>