<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="header.jsp"%>
</head>
<div class="wrapper container-fluid">
	<div class="row">
		<div class="col-xs-3"></div>
		<div class="col-xs-6">
			<h3>Search book:</h3>
			<div class="row">
				<div class="col-md-12">
					<form method="get" action="/findBook" class="form-inline">
						<select class="selectpicker" name="parametr">
							<option>title</option>
							<option>author</option>
							<option>isbn</option>
						</select> <input type="text" maxlength="20" size="15" value="" name="title"
							style="margin: 5px"> <input type="submit" value="search">
					</form>
					<table class="table table-hover">
						<tr>
							<th></th>
							<th>title</th>
							<th>author</th>
							<th>category</th>
							<th>rate</th>
							<th>available</th>
						</tr>
						<c:forEach items="${selectedBook}" var="book">
							<tr>
								<td><div class="row">
										<img alt="" style="width: 90px; height: 90px;"
											src="https://a.optnmnstr.com/users/3cbeee57fc1c/images/30f9b75891501472785456-Book-Transparent-Background.png">
									</div></td>
								<td><a href="/bookView/${book.id}"><c:out
											value="${book.title}" /> </a></td>
								<td><c:out value="${book.author}" /></td>
								<td><c:out value="${book.category.name}" /></td>
								<td><c:out value="${book.rate}" /></td>
								<td><c:out value="${book.amount} " /></td>
								<td><a href="bookView/${book.id}"><input type="submit"
										class="btn btn-m btn-primary" value="more"> </a></td>
						</c:forEach>
					</table>
				</div>
			</div>
		</div>
		<div class="col-md-3"></div>
	</div>
</div>