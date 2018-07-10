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
	<c:choose>
		<c:when test="${user==null}">
			<div class="row">
				<div class="col-xs-3"></div>
				<div class="col-xs-6">
					<div class="jumbotron"
						style="padding-left: 30px; padding-right: 30px">
						<h1 class="lead">Welcome!</h1>
						<p class="tagline">We invite you to take advantage of our
							library.</p>
						<p style="text-align: center">
							<a class="btn btn-lg btn-success" href="/signIn" role="button"
								style="text-align: center">Sign in</a>
						</p>
					</div>
				</div>
				<div class="col-xs-3"></div>
			</div>
		</c:when>
		<c:otherwise>
			<div class="wrapper container-fluid">
				<div class="row">
					<div class="col-xs-3"></div>
					<div class="col-xs-6">
						<div class="page-header">
							<h1>
								Thank you <small> for use of our services. See you next
									time.</small>
							</h1>
							<p style="text-align: center">
								<a class="btn btn-lg btn-success" href="/" role="button"
									style="text-align: center">Back to home page</a>
							</p>
						</div>
						<div class="col-xs-3"></div>
					</div>
				</div>
			</div>
		</c:otherwise>
	</c:choose>
</body>
</html>
