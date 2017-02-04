<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

		<script src="<c:url value="/resources/js/jquery-3.1.1.js" />"></script>
    	<script src="<c:url value="/resources/js/test.js" />"></script>

		<title>Produkty</title>
	</head>

	<body>
		<section>
			<div class="jumbotron">
				<div class="container">
					<h1>Produkty</h1>
					<p>Wszystkie produkty dostępne w naszym sklepie</p>
				</div>
			</div>
		</section>

		<section class="container">
			<div class="row" col-sm-6 col-md-3" style="padding-bottom: 15px">
				<div class="thumbnail">
					<div class="caption">
						<h3>${product.name}</h3>
						<p>${product.description}</p>
						<p>${product.unitPrice}PLN</p>
						<p>Liczba sztuk w magazynie: ${product.unitsInStock}</p>
					</div>
				</div>
			</div>
		</section>
	</body>
</html>