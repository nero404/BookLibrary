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
			<div class="col-xs-3"></div>
			<div class="col-xs-6">
				<h3>Informations about user:</h3>
				<br />
				<table class="table table-hover">
					<tr>
						<th>name</th>
						<th>surename</th>
						<th>telephone</th>
					</tr>
					<tr>
						<td><c:out value="${user.name}" /></td>
						<td><c:out value="${user.sureName}" /></td>
						<td><c:out value="${user.telephone}" /></td>
					</tr>
				</table>
			</div>
			<div class="col-xs-3"></div>
		</div>
	</div>
</body>
</html>