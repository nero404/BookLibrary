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
		<c:when test="${user==null && user.userType.userType=='admin'}">
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
					<div class="col-xs-4"></div>
					<div class="col-xs-4">
						<h3 align="center">Update book:</h3>
						<form method="get" action="/updateBook">
							<div class="form-group row">
								<label for="title-input" class="col-xs-2 col-form-label">title</label>
								<div class="col-xs-10">
									<input required="required" class="form-control" type="text"
										placeholder="title" id="title-input" name="title"
										value="${book.title}">
								</div>
							</div>
							<div class="form-group row">
								<label for="author-input" class="col-xs-2 col-form-label">author</label>
								<div class="col-xs-10">
									<input required="required" class="form-control" type="text"
										placeholder="author" id="title-input" name="author"
										value="${book.author}">
								</div>
							</div>
							<div class="form-group row">
								<label for="amoun-input" class="col-xs-2 col-form-label">amount</label>
								<div class="col-xs-10">
									<input required="required" class="form-control" type="number"
										placeholder="amount" id="amoun-input" name="amount"
										value="${book.amount}">
								</div>
							</div>
							<div class="form-group row">
								<label for="isbn-input" class="col-xs-2 col-form-label">isbn</label>
								<div class="col-xs-10">
									<input required="required" class="form-control" type="text"
										placeholder="isbn" id="isbn-input" name="isbn"
										value="${book.isbn}">
								</div>
							</div>
							<div class="form-group row">
								<label for="description-input" class="col-xs-2 col-form-label">description</label>
								<div class="col-xs-10">
									<input required="required" class="form-control" type="text"
										placeholder="description" id="description-input"
										name="description" value="${book.description}">
								</div>
							</div>
							<div class="form-group">
								<label for="sel1">book category:</label> <select
									class="form-control" id="sel1" name="categoryId">
									<option value="1">Science Fiction</option>
									<option value="2">Fantasy</option>
									<option value="3">Paranormal</option>
									<option value="5">New Adult</option>
									<option value="6">Mainstream Novels</option>
									<option value="7">Romantic Fiction</option>
									<option value="8">Narrative Nonfiction</option>
								</select>
							</div>
							<input type="hidden" name="bookId" value="${book.id}">
							<button type="submit"
								class="btn btn-outline-primary btn-lg btn-block">update</button>
						</form>
					</div>
					<div class="col-xs-4"></div>
				</div>
			</div>
		</c:otherwise>
	</c:choose>
</body>
</html>