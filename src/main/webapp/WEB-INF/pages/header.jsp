<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
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
		</div>
	</div>
</body>
</html>