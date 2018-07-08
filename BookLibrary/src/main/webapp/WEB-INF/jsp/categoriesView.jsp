
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
	<div class="row">
		<div class="col-md-4"></div>
		<div class="col-md-4">
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
		<div class="col-md-4"></div>
	</div>
</body>
</html>