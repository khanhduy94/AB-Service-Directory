
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
<title>Add Organisation</title>
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
<body class=".container-fluid" onload="focusToEndOrganisationName();">

	<jsp:include page="header.jsp"></jsp:include>

	<div class="container myrow-container">
		<div class="panel panel-success">
			<div class="panel-heading">
				<h3 class="text-center" style="color: black;">
					<b>ORGANISATION DETAILS</b>
				</h3>
			</div>
			<div class="panel-body">
				<form:form id="organisationRegisterForm" cssClass="form-horizontal"
					modelAttribute="organisation" method="post"
					action="saveOrganisation">

					<!-- Name: -->
					<div class="form-group">
						<div class="control-label col-xs-3">
							<form:label path="orgName">Name:</form:label>
						</div>
						<div class="col-xs-6">
							<form:hidden path="id" value="${organisationObject.id}" />
							<form:input name="idName" cssClass="form-control" path="orgName"
								placeholder="Enter Name" value="${organisationObject.orgName}" />
						</div>
						<div class="col-xs-6" id="errorFieldName"
							style="margin-left: 300px; color: red"></div>
					</div>

					<!-- Address: -->
					<div class="form-group">
						<form:label path="address" cssClass="control-label col-xs-3">Address:</form:label>
						<div class="col-xs-6">
							<form:input name="idAddress" cssClass="form-control"
								path="address" placeholder="Enter Address"
								value="${organisationObject.address}" />
						</div>
						<div class="col-xs-6" id="errorFieldAddress"
							style="margin-left: 300px; color: red"></div>
					</div>

					<!-- Post code: -->
					<div class="form-group">
						<div class="control-label col-xs-3">
							<form:label path="postCode">Post Code:</form:label>
						</div>
						<div class="col-xs-6">
							<form:input name="idPostCode" cssClass="form-control"
								path="postCode" placeholder="Enter Post Code"
								value="${organisationObject.postCode}" />
						</div>
						<div class="col-xs-6" id="errorFieldPostCode"
							style="margin-left: 300px; color: red"></div>
					</div>

					<!-- Phone: -->
					<div class="form-group">
						<div class="control-label col-xs-3">
							<form:label path="phone">Phone:</form:label>
						</div>
						<div class="col-xs-6">
							<form:input name="idPhone" cssClass="form-control" path="phone"
								placeholder="Enter Phone" value="${organisationObject.phone}" />
						</div>
						<div class="col-xs-6" id="errorFieldPhone"
							style="margin-left: 300px; color: red"></div>
					</div>

					<!-- Email: -->
					<div class="form-group">
						<div class="control-label col-xs-3">
							<form:label path="email">Email:</form:label>
						</div>
						<div class="col-xs-6">
							<form:input name="idEmail" cssClass="form-control" path="email"
								placeholder="Enter Email" value="${organisationObject.email}" />
						</div>
						<div class="col-xs-6" id="errorFieldEmail"
							style="margin-left: 300px; color: red"></div>
					</div>

					<div class="form-group" id="errors"></div>

					<div class="form-group">
						<div class="row">
							<div class="col-xs-5"></div>
							<div class="col-xs-5">
								<input type="submit" id="saveOrganisation" class="btn btn-primary"
									value="Save" onclick="return submitOrganisationForm();" />
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
			document.getElementById("orgName").value = "";
			document.getElementById("address").value = "";
			document.getElementById("postCode").value = "";
			document.getElementById("phone").value = "";
			document.getElementById("email").value = "";

			$('#orgName').focus();
		};

		cancel.onclick = function() {
			window.location.href = "getAllOrganisations";
		};

		function focusToEndOrganisationName() {
			$("#orgName").focus();
			var text = $("#orgName").val();
			document.getElementById("orgName").setSelectionRange(text.length,
					text.length);
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

		function isValidAddress(str) {
			var iChars = "<>@!#$%^&*_+[]{}?:|'\"\\~`=";
			for (var i = 0; i < str.length; i++) {
				if (iChars.indexOf(str.charAt(i)) != -1)
					return false;
			}
			return true;
		}

		function submitOrganisationForm() {

			// getting the Organisation form values
			var name = $('#orgName').val().trim();
			var address = $('#address').val().trim();
			var postCode = $('#postCode').val().trim();
			var phone = $('#phone').val().trim();
			var email = $('#email').val().trim();

			$("#errorFieldName").empty();
			document.getElementById("errorFieldName").style.visibility = "hidden";
			$("#errorFieldAddress").empty();
			document.getElementById("errorFieldAddress").style.visibility = "hidden";
			$("#errorFieldPostCode").empty();
			document.getElementById("errorFieldPostCode").style.visibility = "hidden";
			$("#errorFieldPhone").empty();
			document.getElementById("errorFieldPhone").style.visibility = "hidden";
			$("#errorFieldEmail").empty();
			document.getElementById("errorFieldEmail").style.visibility = "hidden";

			// Validate field name:
			if ((name.length < 3) || (name.length > 30)) {
				document.getElementById("errorFieldName").innerHTML = "Please enter Name! (3 -> 30 characters)";
				document.getElementById("errorFieldName").style.visibility = "visible";
				$('#orgName').focus();
				return false;
			} else if (isValidName(name) == false) {
				document.getElementById("errorFieldName").innerHTML = "Name has special characters!";
				document.getElementById("errorFieldName").style.visibility = "visible";
				$('#orgName').focus();
				return false;
			}

			// Validate field address:
			if ((address.length < 3) || (address.length > 30)) {
				document.getElementById("errorFieldAddress").innerHTML = "Please enter Address! (3 -> 30 characters)";
				document.getElementById("errorFieldAddress").style.visibility = "visible";
				$('#address').focus();
				return false;
			} else if (isValidAddress(address) == false) {
				document.getElementById("errorFieldAddress").innerHTML = "Address has special characters!";
				document.getElementById("errorFieldAddress").style.visibility = "visible";
				$('#address').focus();
				return false;
			}

			// Validate field post code:
			if ((postCode.length < 3) || (postCode.length > 15)) {
				document.getElementById("errorFieldPostCode").innerHTML = "Please enter Post Code! (3 -> 15 characters)";
				document.getElementById("errorFieldPostCode").style.visibility = "visible";
				$('#postCode').focus();
				return false;
			} else if (isValidName(postCode) == false) {
				document.getElementById("errorFieldPostCode").innerHTML = "Post Code has special characters!";
				document.getElementById("errorFieldPostCode").style.visibility = "visible";
				$('#postCode').focus();
				return false;
			}

			// Validate field phone:

			if ((phone.length < 6) || (phone > 2147483647)
					|| ((phone % 1) != 0)) {
				document.getElementById("errorFieldPhone").innerHTML = "Please enter valid phone! (6 -> 10 digits)";
				document.getElementById("errorFieldPhone").style.visibility = "visible";
				$('#phone').focus();
				var text = $("#phone").val();
				document.getElementById("phone").setSelectionRange(text.length,
						text.length);
				return false;
			}

			// Validate field phone:
			if ((!email.match(/\S+@\S+\.\S+/)) || (email.indexOf(' ') != -1)
					|| (email.indexOf('..') != -1)) {
				document.getElementById("errorFieldEmail").innerHTML = "Please enter valid email! (EX: fpt@gmail.com)";
				document.getElementById("errorFieldEmail").style.visibility = "visible";
				$('#email').focus();
				return false;
			}
			return true;
		};
	</script>
</body>
</html>