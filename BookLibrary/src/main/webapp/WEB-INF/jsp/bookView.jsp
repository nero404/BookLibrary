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

			<div class="row">
				<div class="panel panel-default">
					<div class="panel-body">
						<p>title: ${book.title}</p>
						<p>author: ${book.author}</p>
						<p>category: ${book.category.name}</p>
						<p>isbn: ${book.isbn}</p>
						<p>users rate: ${book.rate}</p>
						<c:if test="${userRate == false}">
							<form method="get" action="/rateBook">
								<select class="form-control" id="sel1" name="rate">
									<option value="1">1</option>
									<option value="2">2</option>
									<option value="3">3</option>
									<option value="4">4</option>
									<option value="5">5</option>
									<option value="6">6</option>
									<option value="7">7</option>
									<option value="8">8</option>
									<option value="9">9</option>
									<option value="10">10</option>

								</select> <input type="hidden" id="bookId" name="bookId"
									value="${book.id}"> <input type="submit" value="rate">
							</form>
						</c:if>

						<p>available: ${book.amount}</p>

						<p>description: ${book.description}</p>
					</div>
				</div>
				<div class="panel panel-default">
					<div class="panel-body">
						<div class="btn-toolbar" role="toolbar"
							aria-label="Toolbar with button groups" >
							<c:if test="${user.userType.userType=='admin'}">

								<form method="post" action="/deleteBook" name="deleteBook">
									<input type="hidden" name="bookId" value="${book.id}">
									<input type="submit" class="btn btn-m btn-warning"
										value="delete" style="margin-right: 10px">
								</form>
								<form method="post" action="/updateBookView/${bookId}"
									name="updateBookView">

									<input type="submit" class="btn btn-m btn-warning"
										value="update" style="margin-right: 10px">
								</form>
							</c:if>
							<form method="get" action="/addBookToCart" name="addBookToCart">
								<input type="hidden" name="bookId" value="${book.id}"> <input
									type="submit" class="btn btn-m btn-primary" value="order" style="margin-right: 10px">
							</form>
						</div>
					</div>
				</div>

			</div>
		</div>
	</div>
</div>