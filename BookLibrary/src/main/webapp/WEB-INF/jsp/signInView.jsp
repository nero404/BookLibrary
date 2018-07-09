<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="header.jsp"%>
</head>
<body>
	<div class="wrapper container-fluid">
		<div class="row">
			<div class="col-xs-4"></div>
			<div class="col-xs-4">
				<h1 align="center">Sign in:</h1>
				<form method="post" action="/signIn/validate" name="registration">
					<div class="form-group">
						<label><b>login </b></label> <input type="text"
							placeholder="login" name="login" required class="form-control">
					</div>
					<div class="form-group">
						<label><b>passowrd </b></label> <input type="password"
							placeholder="password" name="password" required
							class="form-control">
					</div>
					<button type="submit"
						class="btn btn-outline-primary btn-lg btn-block">Sign in</button>
				</form>
			</div>
		</div>
		<div class="col-xs-4"></div>
	</div>
</body>
</html>