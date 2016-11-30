
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Premise List</title>
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
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
							<b>PREMISES LIST</b>
						</h3>
					</div>
					<div align="right">
						<a href="createPremise"><span class="glyphicon glyphicon-plus"></span><b>
								ADD NEW</b></a>
					</div>
				</h3>
			</div>
			<div class="panel-body">
				<c:if test="${empty premiseList}">
                There are no Premises
            </c:if>
				<c:if test="${not empty premiseList}">

					<form action="searchPremise">
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
								<th>ADDRESS</th>
								<th>POST CODE</th>
								<th>PHONE</th>
								<th>EMAIL</th>
								<th>EDIT</th>
								<th>DELETE</th>
							</tr>
						</thead>
						<tbody style="background-color: #F0F8FF;">
							<c:forEach items="${premiseList}" var="pre">
								<tr>
									<th><c:out value="${pre.id}" /></th>
									<th><c:out value="${pre.preName}" /></th>
									<th><c:out value="${pre.address}" /></th>
									<th><c:out value="${pre.postCode}" /></th>
									<th><c:out value="${pre.phone}" /></th>
									<th><c:out value="${pre.email}" /></th>
									<th><a
										href="editPremise?id=<c:out value='${pre.id}'/>"><span
											class="glyphicon glyphicon-edit"></span></a></th>
									<th><a
										href="deletePremise?id=<c:out value='${pre.id}'/>"><span
											class="glyphicon glyphicon-trash"></span></a></th>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</c:if>
			</div>
		</div>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>