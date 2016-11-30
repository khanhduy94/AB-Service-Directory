
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
<title>Add Geography</title>
<!-- Bootstrap CSS -->

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">

<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<style type="text/css">
.example {
	margin: 20px;
}
</style>
</head>
<body class=".container-fluid" onload="focusToEndGeographyName();">

	<jsp:include page="header.jsp"></jsp:include>

	<div class="container myrow-container">
		<div class="panel panel-success">
			<div class="panel-heading">
				<h3 class="text-center" style="color: black;">
					<b>GEOGRAPHY DETAILS</b>
				</h3>
			</div>
			<div class="panel-body">
				<form:form id="geographyRegisterForm" cssClass="form-horizontal"
					modelAttribute="geography" method="post" action="saveGeography">

					<!-- Name: -->
					<div class="form-group">
						<div class="control-label col-xs-3">
							<form:label path="countryName">Country Name:</form:label>
						</div>
						<div class="col-xs-6">
							<form:hidden path="id" value="${geographyObject.id}" />
							<form:input name="idName" cssClass="form-control"
								path="countryName" placeholder="Enter Country Name"
								value="${geographyObject.countryName}" />
						</div>
						<div class="col-xs-6" id="errorFieldName"
							style="margin-left: 300px; color: red"></div>
					</div>

					<!-- Region: -->
					<div class="form-group">
						<form:label path="region" cssClass="control-label col-xs-3">Region:</form:label>
						<div class="col-xs-6">
							<form:input name="idRegion" cssClass="form-control" path="region"
								placeholder="Enter Region" value="${geographyObject.region}" />
						</div>
						<div class="col-xs-6" id="errorFieldRegion"
							style="margin-left: 300px; color: red"></div>
					</div>

					<!-- District: -->
					<div class="form-group">
						<div class="control-label col-xs-3">
							<form:label path="district">District:</form:label>
						</div>
						<div class="col-xs-6">
							<form:input name="idDistrict" cssClass="form-control"
								path="district" placeholder="Enter District"
								value="${geographyObject.district}" />
						</div>
						<div class="col-xs-6" id="errorFieldDistrict"
							style="margin-left: 300px; color: red"></div>
					</div>

					<!-- Email: -->
					<div class="form-group">
						<div class="control-label col-xs-3">
							<form:label path="description">Description:</form:label>
						</div>
						<div class="col-xs-6">
							<form:input name="idDescription" cssClass="form-control"
								path="description" placeholder="Enter Description"
								value="${geographyObject.description}" />
						</div>
						<div class="col-xs-6" id="errorFieldDescription"
							style="margin-left: 300px; color: red"></div>
					</div>

					<div class="form-group" id="errors"></div>

					<div class="form-group">
						<div class="row">
							<div class="col-xs-5"></div>
							<div class="col-xs-5">
								<input type="submit" id="saveGeography" class="btn btn-primary"
									value="Save" onclick="return submitGeographyForm();" />
								<button type="button" id="clearAll" class="btn btn-warning">Clear</button>
								<button type="button" id="cancel" class="btn btn-danger">Cancel</button>
							</div>
							<!--    -->
							<div class="col-xs-5"></div>
						</div>
					</div>

				</form:form>
			</div>
		</div>
	</div>

	<jsp:include page="footer.jsp"></jsp:include>

	<script type="text/javascript">
		clearAll.onclick = function() {
			document.getElementById("countryName").value = "";
			document.getElementById("region").value = "";
			document.getElementById("district").value = "";
			document.getElementById("description").value = "";

			$('#countryName').focus();
		};

		cancel.onclick = function() {
			window.location.href = "getAllGeographys";
		};

		function focusToEndGeographyName() {
			$("#countryName").focus();
			var text = $("#countryName").val();
			document.getElementById("countryName").setSelectionRange(
					text.length, text.length);
		};
	</script>

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/jquery.validation/1.15.0/jquery.validate.min.js"></script>

	<script type="text/javascript">
		function isValidName(str) {
			var iChars = "<>@!#$%^&*()_+[]{}?:;|'\"\\,./~`-=";
			for (var i = 0; i < str.length; i++) {
				if (iChars.indexOf(str.charAt(i)) != -1)
					return false;
			}
			return true;
		}

		function isValidRegion(str) {
			var iChars = "<>@!#$%^&*_+[]{}?:|'\"\\~`=";
			for (var i = 0; i < str.length; i++) {
				if (iChars.indexOf(str.charAt(i)) != -1)
					return false;
			}
			return true;
		}

		function submitGeographyForm() {

			// getting the geography form values
			var name = $('#countryName').val().trim();
			var region = $('#region').val().trim();
			var district = $('#district').val().trim();
			var description = $('#description').val().trim();

			$("#errorFieldName").empty();
			document.getElementById("errorFieldName").style.visibility = "hidden";
			$("#errorFieldRegion").empty();
			document.getElementById("errorFieldRegion").style.visibility = "hidden";
			$("#errorFieldDistrict").empty();
			document.getElementById("errorFieldDistrict").style.visibility = "hidden";
			$("#errorFieldDescription").empty();
			document.getElementById("errorFieldDescription").style.visibility = "hidden";

			// Validate field name:
			if ((name.length < 3) || (name.length > 30)) {
				document.getElementById("errorFieldName").innerHTML = "Please enter Country Name! (3 -> 30 characters)";
				document.getElementById("errorFieldName").style.visibility = "visible";
				$('#countryName').focus();
				return false;
			} else if (isValidName(name) == false) {
				document.getElementById("errorFieldName").innerHTML = "Country Name has special characters!";
				document.getElementById("errorFieldName").style.visibility = "visible";
				$('#countryName').focus();
				return false;
			}

			// Validate field region:
			if ((region.length < 3) || (region.length > 30)) {
				document.getElementById("errorFieldRegion").innerHTML = "Please enter Region! (3 -> 30 characters)";
				document.getElementById("errorFieldRegion").style.visibility = "visible";
				$('#region').focus();
				return false;
			} else if (isValidRegion(region) == false) {
				document.getElementById("errorFieldRegion").innerHTML = "Region has special characters!";
				document.getElementById("errorFieldRegion").style.visibility = "visible";
				$('#region').focus();
				return false;
			}

			// Validate field district:
			if ((district.length > 15)) {
				document.getElementById("errorFieldDistrict").innerHTML = "Please enter District! (< 15 characters)";
				document.getElementById("errorFieldDistrict").style.visibility = "visible";
				$('#district').focus();
				return false;
			} else if (isValidRegion(district) == false) {
				document.getElementById("errorFieldDistrict").innerHTML = "District has special characters!";
				document.getElementById("errorFieldDistrict").style.visibility = "visible";
				$('#district').focus();
				return false;
			}

			// Validate field district:
			if ((description.length < 3)) {
				document.getElementById("errorFieldDescription").innerHTML = "Please enter Description! (> 3 characters)";
				document.getElementById("errorFieldDescription").style.visibility = "visible";
				$('#description').focus();
				return false;
			} else if (isValidRegion(description) == false) {
				document.getElementById("errorFieldDescription").innerHTML = "Description has special characters!";
				document.getElementById("errorFieldDescription").style.visibility = "visible";
				$('#description').focus();
				return false;
			}
			return true;
		};
	</script>
</body>
</html>