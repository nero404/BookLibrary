
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
			<div class="row">
				<div class="col-xs-4"></div>
				<div class="col-xs-4">
					<div class="card-columns">
						<c:forEach var="category" items="${categories}">
							<div class="card">
								<div class="card-body">
									<h5 class="card-title">${category.name}</h5>
									<p class="card-text">${category.description}</p>
									<a href="categoryView/${category.id}" class="btn btn-primary">Go
										to category</a>
								</div>
							</div>
						</c:forEach>
					</div>
				</div>
				<div class="col-xs-4"></div>
			</div>
		</c:otherwise>
	</c:choose>
</body>
</html>