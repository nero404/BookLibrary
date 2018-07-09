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
				<h2>Cart:</h2>
				<c:choose>
					<c:when test="${cart != null && cart.numberOfBooks > 0}">
        			books in cart:
					<table class="table table-hover">
							<tr>
								<th>id</th>
								<th>title</th>
								<th>author</th>
								<th>isbn</th>
								<th>delete</th>
							</tr>
							<c:forEach items="${cart.books}" var="book">
								<tr>
									<td><c:out value="${book.id}" /></td>
									<td><c:out value="${book.title}" /></td>
									<td><c:out value="${book.author}" /></td>
									<td><c:out value="${book.isbn}" /></td>
									<td><form method="get" action="/removeBookFromCart"
											name="removeBookFromCart">
											<input type="hidden" name="bookId" value="${book.id}">
											<input type="submit" value="delete">
										</form></td>
								</tr>
							</c:forEach>
						</table>
						<form action="/borrowBooks" method="get">
							<button type="submit" class="btn btn-m btn-danger">
								borrow</button>
						</form>
					</c:when>
					<c:otherwise>
        			Cart is empty!
   			 	</c:otherwise>
				</c:choose>
			</div>
			<div class="col-xs-4"></div>
		</div>
	</div>
</body>
</html>