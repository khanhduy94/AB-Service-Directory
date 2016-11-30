
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
<title>Add Contact</title>
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
<body class=".container-fluid" onload="focusToEndContactName();">

	<jsp:include page="header.jsp"></jsp:include>

	<div class="container myrow-container">
		<div class="panel panel-success">
			<div class="panel-heading">
				<h3 class="text-center" style="color: black;">
					<b>CONTACT DETAILS</b>
				</h3>
			</div>
			<div class="panel-body">
				<form:form id="contactRegisterForm" cssClass="form-horizontal"
					modelAttribute="contact" method="post" action="saveContact">

					<!-- Name: -->
					<div class="form-group">
						<div class="control-label col-xs-3">
							<form:label path="conName">Contact Name:</form:label>
						</div>
						<div class="col-xs-6">
							<form:hidden path="id" value="${contactObject.id}" />
							<form:input name="idName" cssClass="form-control" path="conName"
								placeholder="Enter Contact Name"
								value="${contactObject.conName}" />
						</div>
						<div class="col-xs-6" id="errorFieldName"
							style="margin-left: 300px; color: red"></div>
					</div>

					<!-- Address: -->
					<div class="form-group">
						<form:label path="conType" cssClass="control-label col-xs-3">Contact Type:</form:label>
						<div class="col-xs-6">
							<form:input name="idType" cssClass="form-control" path="conType"
								placeholder="Enter Contact Type"
								value="${contactObject.conType}" />
						</div>
						<div class="col-xs-6" id="errorFieldType"
							style="margin-left: 300px; color: red"></div>
					</div>

					<!-- Phone: -->
					<div class="form-group">
						<div class="control-label col-xs-3">
							<form:label path="phone">Phone:</form:label>
						</div>
						<div class="col-xs-6">
							<form:input name="idPhone" cssClass="form-control" path="phone"
								placeholder="Enter Phone" value="${contactObject.phone}" />
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
								placeholder="Enter Email" value="${contactObject.email}" />
						</div>
						<div class="col-xs-6" id="errorFieldEmail"
							style="margin-left: 300px; color: red"></div>
					</div>

					<!-- Manager Name: -->
					<div class="form-group">
						<div class="control-label col-xs-3">
							<form:label path="managerName">Manager Name:</form:label>
						</div>
						<div class="col-xs-6">
							<form:input name="idManagerName" cssClass="form-control"
								path="managerName" placeholder="Enter Manager Name"
								value="${contactObject.managerName}" />
						</div>
						<div class="col-xs-6" id="errorFieldManagerName"
							style="margin-left: 300px; color: red"></div>
					</div>

					<div class="form-group" id="errors"></div>

					<div class="form-group">
						<div class="row">
							<div class="col-xs-5"></div>
							<div class="col-xs-5">
								<input type="submit" id="saveContact" class="btn btn-primary"
									value="Save" onclick="return submitContactForm();" />
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
			document.getElementById("conName").value = "";
			document.getElementById("conType").value = "";
			document.getElementById("phone").value = "";
			document.getElementById("email").value = "";
			document.getElementById("managerName").value = "";

			$('#conName').focus();
		};

		cancel.onclick = function() {
			window.location.href = "getAllContacts";
		};

		function focusToEndContactName() {
			$("#conName").focus();
			var text = $("#conName").val();
			document.getElementById("conName").setSelectionRange(text.length,
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

		function submitContactForm() {

			// getting the contact form values
			var name = $('#conName').val().trim();
			var conType = $('#conType').val().trim();
			var phone = $('#phone').val().trim();
			var email = $('#email').val().trim();
			var managerName = $('#managerName').val().trim();

			$("#errorFieldName").empty();
			document.getElementById("errorFieldName").style.visibility = "hidden";
			$("#errorFieldType").empty();
			document.getElementById("errorFieldType").style.visibility = "hidden";
			$("#errorFieldPhone").empty();
			document.getElementById("errorFieldPhone").style.visibility = "hidden";
			$("#errorFieldEmail").empty();
			document.getElementById("errorFieldEmail").style.visibility = "hidden";
			$("#errorFieldManagerName").empty();
			document.getElementById("errorFieldManagerName").style.visibility = "hidden";

			// Validate field name:
			if ((name.length < 3) || (name.length > 30)) {
				document.getElementById("errorFieldName").innerHTML = "Please enter Contact Name! (3 -> 30 characters)";
				document.getElementById("errorFieldName").style.visibility = "visible";
				$('#conName').focus();
				return false;
			} else if (isValidName(name) == false) {
				document.getElementById("errorFieldName").innerHTML = "Contact Name has special characters!";
				document.getElementById("errorFieldName").style.visibility = "visible";
				$('#conName').focus();
				return false;
			}

			// Validate field contact type:
			if ((conType.length < 3) || (conType.length > 30)) {
				document.getElementById("errorFieldType").innerHTML = "Please enter Contact Type! (3 -> 30 characters)";
				document.getElementById("errorFieldType").style.visibility = "visible";
				$('#conType').focus();
				return false;
			} else if (isValidName(conType) == false) {
				document.getElementById("errorFieldType").innerHTML = "Contact Type has special characters!";
				document.getElementById("errorFieldType").style.visibility = "visible";
				$('#conType').focus();
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

			// Validate field email:
			if ((!email.match(/\S+@\S+\.\S+/)) || (email.indexOf(' ') != -1)
					|| (email.indexOf('..') != -1)) {
				document.getElementById("errorFieldEmail").innerHTML = "Please enter valid email! (EX: fpt@gmail.com)";
				document.getElementById("errorFieldEmail").style.visibility = "visible";
				$('#email').focus();
				return false;
			}

			// Validate field manager name:
			if ((managerName.length < 3) || (managerName.length > 30)) {
				document.getElementById("errorFieldManagerName").innerHTML = "Please enter Manager Name! (3 -> 30 characters)";
				document.getElementById("errorFieldManagerName").style.visibility = "visible";
				$('#managerName').focus();
				return false;
			} else if (isValidName(managerName) == false) {
				document.getElementById("errorFieldManagerName").innerHTML = "Manager Name has special characters!";
				document.getElementById("errorFieldManagerName").style.visibility = "visible";
				$('#managerName').focus();
				return false;
			}
			return true;
		};
	</script>
</body>
</html>