<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>Book Library</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.5/css/bootstrap.min.css"
	integrity="sha384-AysaV+vQoT3kOAXZkl02PThvDr8HYKPZhNT5h/CXfBThSRXQ6jW5DO2ekP5ViFdi"
	crossorigin="anonymous">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"
	integrity="sha384-3ceskX3iaEnIogmQchP8opvBy3Mi7Ce34nWjpBIwVTHfGYWQS9jwHDVRnpKKHJg7"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.3.7/js/tether.min.js"
	integrity="sha384-XTs3FgkjiBgo8qjEjBk0tGmf3wPrWtA6coPfQDfFEY8AnYJwjalXCiosYRBIBZX8"
	crossorigin="anonymous"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.5/js/bootstrap.min.js"
	integrity="sha384-BLiI7JTZm+JWlgKa0M0kGRpJbF2J8q+qreVrKBC47e3K6BW78kGLrCkeRX6I9RoK"
	crossorigin="anonymous"></script>



<div class="wrapper container-fluid" style="margin-top: 5px">
	<div class="row" align="center" style="margin-bottom: 20px;">



		<nav class="navbar navbar-expand-lg navbar-light bg-light">
			<a href="/index"><button type="submit"
					class="btn  btn-info btn-lg" value="">
					<span class="glyphicon glyphicon glyphicon-home" aria-hidden="true"></span>
					Book library
				</button></a> <a href="/searchBooksView"><button type="submit"
					class="btn btn-outline-info  btn-lg" value="Search book">
					<span class="glyphicon glyphicon-search" aria-hidden="true"></span>
					Search book
				</button></a> <a href="/categoriesView"><button type="submit"
					class="btn btn-outline-info  btn-lg" value="Browse">
					<span class="glyphicon glyphicon-book" aria-hidden="true"></span>
					Browse
				</button></a>
			<c:if test="${user.login == null}">
				<a href="/signIn"><input type="submit"
					class="btn btn-outline-info  btn-lg" value="Sign in"></a>
				<a href="/signUp"><input type="submit"
					class="btn btn-outline-info  btn-lg" value="Sign up"></a>
			</c:if>
			<c:if test="${user.login != null}">
				<div class="btn-group">
					<button type="button"
						class="btn btn-outline-info dropdown-toggle  btn-lg "
						data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"
						value="Logged as:
							${user.login}"
						style="max-width: 200px; overflow: hidden; text-overflow: ellipsis;">
						<span class="glyphicon glyphicon glyphicon-user"
							aria-hidden="true"> ${user.login} </span>
					</button>
					<div class="dropdown-menu">
						<c:if test="${user.login != null }">
							<a class="dropdown-item" href="/userInfoView">user info</a>
							<div class="dropdown-divider"></div>
							<a class="dropdown-item" href="/ownOrdersView">your history</a>
						</c:if>
						<c:if test="${user.userType.userType=='admin'}">

							<div class="dropdown-divider"></div>
							<a class="dropdown-item" href="/addBookView">add book</a>
						</c:if>
						<div class="dropdown-divider"></div>
						<a class="dropdown-item" href="/signOut/">log out</a>
					</div>
				</div>
				<c:if test="${user.login != null}">
					<a href="/cartView"><button type="submit"
							class="btn btn-outline-info  btn-lg " value="Cart">
							<span class="glyphicon glyphicon glyphicon-shopping-cart"
								aria-hidden="true"></span> Cart
						</button></a>
				</c:if>
			</c:if>
			<a href="#"><button type="submit"
					class="btn btn-outline-info  btn-lg" value="Contact">
					<span class="glyphicon glyphicon glyphicon-envelope"
						aria-hidden="true"></span> Contact
				</button></a>

		</nav>

	</div>

</div>

</head>