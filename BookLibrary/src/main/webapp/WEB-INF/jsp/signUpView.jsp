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
			<div class="col-md-4"></div>
			<div class="col-md-4">
				<h1 align="center">Registration:</h1>

				<form method="post" name="registration" action="/signUp/validate">
					<div class="form-group">
						<label><b>login </b></label> <input class="form-control"
							type="text" name="login" placeholder="login" required>
					</div>
					<div class="form-group">
						<label><b>password </b></label> <input class="form-control"
							type="password" name="password" placeholder="password" required>
					</div>
					<div class="form-group">
						<label><b>surename</b></label> <input class="form-control"
							type="text" name="sure_name" placeholder="suerename" required>
					</div>
					<div class="form-group">
						<label><b>name</b></label> <input class="form-control"
							type="text" name="name" placeholder="name" required>
					</div>
					<div class="form-group">
						<label><b>phone </b></label> <input class="form-control"
							type="text" name="phone" placeholder="phone" required>

					</div>
					<div class="form-group">
						<button type="submit"
							class="btn btn-outline-primary btn-lg btn-block">Sign up</button>
					</div>
					
					<div class="form-group">
						<a href="/index"><button type="submit"
							class="btn btn-outline-primary btn-lg btn-block" >back</button></a>
					</div>
				
					
				</form>
				

			</div>
			<div class="col-md-4"></div>
		</div>
	</div>

</body>
</html>