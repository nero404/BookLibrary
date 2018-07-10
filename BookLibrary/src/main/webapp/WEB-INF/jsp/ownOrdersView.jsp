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
						<h3>Your history order:</h3>
						<br />
						<table class="table table-hover">
							<tr>
								<th><b>date</b></th>
								<th>title</th>
								<th>author</th>
							</tr>
							<c:forEach items="${user.userBorrows}" var="userOrder">
								<tr>
									<td><c:out value="${userOrder.date}" /></td>
								</tr>
								<c:forEach var="book" items="${userOrder.books}">
									<tr>
										<td></td>
										<td><c:out value="${book.author}" /></td>
										<td><c:out value="${book.title}" /></td>
									</tr>
								</c:forEach>
							</c:forEach>
						</table>
					</div>
					<div class="col-xs-3"></div>
				</div>
			</div>
		</c:otherwise>
	</c:choose>
</body>
</html>