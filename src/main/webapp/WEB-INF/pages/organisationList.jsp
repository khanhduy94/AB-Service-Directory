<%--
  User: Ranga Reddy
  Date: 1/27/2015
  Time: 9:48 PM
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="author" content="Ranga Reddy">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Organisation List</title>
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
							<b>ORGANISATIONS LIST</b>
						</h3>
					</div>
					<div align="right">
						<a href="createOrganisation"><span
							class="glyphicon glyphicon-plus"></span><b> ADD</b> </a>
					</div>
				</h3>
			</div>
			<div class="panel-body">
				<c:if test="${empty organisationList}">
                There are no Organisations
            </c:if>
				<c:if test="${not empty organisationList}">

					<form action="searchOrganisation">
						<div class="row">
							<div class="col-md-8">
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
								<th>ADDRESS</th>
								<th>POST CODE</th>
								<th>PHONE</th>
								<th>EMAIL</th>
								<th>EDIT</th>
								<th>DELETE</th>
							</tr>
						</thead>
						<tbody style="background-color: #F0F8FF;">
							<c:forEach items="${organisationList}" var="org">
								<tr>
									<th><c:out value="${org.id}" /></th>
									<th><c:out value="${org.orgName}" /></th>
									<th><c:out value="${org.address}" /></th>
									<th><c:out value="${org.postCode}" /></th>
									<th><c:out value="${org.phone}" /></th>
									<th><c:out value="${org.email}" /></th>
									<th><a
										href="editOrganisation?id=<c:out value='${org.id}'/>"><span
											class="glyphicon glyphicon-edit"></span></a></th>
									<th><a
										href="deleteOrganisation?id=<c:out value='${org.id}'/>"><span
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
</body>
</html>