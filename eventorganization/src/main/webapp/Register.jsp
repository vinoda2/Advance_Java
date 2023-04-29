<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>X-workz</title>
<%@include file="all_css.jsp"%>
</head>
<body>
	<%@include file="Navbar.jsp"%>
	<div align="center">
		<form action="register" method="Post">
			<div
				class="col-sm-3 mt-4 p-5 jumbotron bg-success text-white rounded">
				<div>
					<h5>
						<c:forEach items="${errors}" var="e">
							<span style="color: red;">${e.message }</span>
							<br>
						</c:forEach>
					</h5>
					<div class="row mb-3">
						<h4>Register here!!</h4>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="inputEmail3"
								name="eventName" placeholder="Event Name">
						</div>
					</div>
					<div class="row mb-3">

						<div class="col-sm-10">
							<input type="text" class="form-control" id="inputEmail3"
								name="eventType" placeholder="Event Type">
						</div>
					</div>

					<div class="row mb-3">

						<div class="col-sm-10">
							<input type="number" class="form-control" id="inputEmail3"
								name="budget" placeholder="Budget">
						</div>
					</div>
					<div class="row mb-3">

						<div class="col-sm-10">
							<input type="text" class="form-control" id="inputPassword3"
								name="day" placeholder="Day">
						</div>
					</div>
					<div align="center">
						<input type="submit" class="btn btn-secondary" value="submit">
					</div>
				</div>
			</div>
		</form>
	</div>
</body>
</html>