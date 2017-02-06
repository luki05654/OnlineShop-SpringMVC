<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

		<script src="<c:url value="/resources/js/jquery-3.1.1.js" />"></script>
    	<script src="<c:url value="/resources/js/test.js" />"></script>

		<title>Produkt</title>
	</head>

	<body>
		<section>
			<div class="jumbotron">
				<div class="container">
					<h1>Produkt</h1>
				</div>
			</div>
		</section>

		<section class="container">
			<div class="row">
				<div class="col-md-5">
					<h3>${product.name}</h3>
					<p>${product.description}</p>
					<p>
						<strong>Kod produktu: </strong><span class="label label-warning">${product.productId}</span>
					</p>
					<p>
						<strong>Producent</strong>: ${product.manufacturer}
					</p>
					<p>
						<strong>Kategoria</strong>: ${product.category}
					</p>
					<p>
						<strong>Dostępna liczba sztuk
						</strong>:${product.unitsInStock}
					</p>
					<h4>${product.unitPrice}PLN</h4>
					<p>
						<a href='<spring:url value="/products" />' class="btn btndefault">
							<span class="glyphicon-hand-left glyphicon"></span> Wstecz
						</a>

						<a href="#" class="btn btn-warning btn-large">
							<span class="glyphicon-shopping-cart glyphicon"></span>
							Zamów teraz
						</a>
					</p>
				</div>
			</div>
		</section>
	</body>
</html>