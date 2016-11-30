<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Home</title>
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap-theme.min.css">
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<style type="text/css">
.example {
	margin: 20px;
}
</style>
</head>
<body style="background-color: #E5ECF4;">
	<div class="example">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<ul>
						<a href="${pageContext.request.contextPath}"> <img
							src="https://citusload.fpt-software.com/images/FPT%20logo.png"
							alt="fpt" height="70" width="250"></a>
					</ul>

					<ul class="nav nav-tabs" style="background-color: #262626;">
						<li><a href="${pageContext.request.contextPath}"
							style="color: white;"><span class="glyphicon glyphicon-home"></span>
								<b>HOME</b></a></li>
						<li><a href="getAllOrganisations" style="color: white;"><span
								class="glyphicon glyphicon-lock"></span> <b>ORGANISATION</b></a></li>
						<li><a href="getAllContacts" style="color: white;"><span
								class="glyphicon glyphicon-envelope"></span> <b>CONTACT</b></a></li>
						<li><a href="getAllPremises" style="color: white;"><span
								class="glyphicon glyphicon-user"></span> <b>PREMISE</b></a></li>
						<li><a href="getAllGeographys" style="color: white;"><span
								class="glyphicon glyphicon-globe"></span> <b>GEOGRAPHY</b></a></li>

					</ul>
				</div>
			</div>

			<div class="col-md-12" style="background-color: white;">
				<div>
					<h2 class="text-center">Team member</h2>
				</div>

				<span class="glyphicon glyphicon-user"></span> <b> Nguyen Xuan
					Toan</b> - Team Leader
				<hr />
				<span class="glyphicon glyphicon-user"></span> <b> Ha Van Dung</b> -
				Member
				<hr />
				<span class="glyphicon glyphicon-user"></span> <b> Dang Thanh
					Duy</b> - Member
				<hr />
				<span class="glyphicon glyphicon-user"></span> <b> Dao Khanh Duy</b>
				- Member
				<hr />
			</div>
		</div>

		<jsp:include page="footer.jsp"></jsp:include>
	</div>
</body>
</html>