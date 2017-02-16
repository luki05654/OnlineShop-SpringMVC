<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

		<script src="<c:url value="/resources/js/jquery-3.1.1.js" />"></script>
    	<script src="<c:url value="/resources/js/test.js" />"></script>

		<title>Dodaj produkt</title>
	</head>

	<body>
		<section>
			<div class="jumbotron">
				<div class="container">
					<h1>Produkty</h1>
					<p>Dodaj produkty</p>
				</div>
				<a href='<c:url value="/j_spring_security_logout" />' class="btn btn-danger btn-mini pull-right">
					Wyloguj się
				</a>
			</div>
		</section>

		<section class="container">
			<form:form modelAttribute="newProduct" class="form-horizontal" enctype="multipart/form-data">
				<fieldset>
					<legend>Dodaj nowy produkt</legend>
					<div class="form-group">
						<label class="control-label col-lg-2 col-lg-2" for="productId">
							<spring:message code="addProduct.form.productId.label"/>
						</label>
						<div class="col-lg-10">
							<form:input id="productId" path="productId" type="text"	class="form:input-large"/>
						</div>
					</div>

					<div class="form-group">
						<label class="control-label col-lg-2" for="name">Nazwa</label>
						<div class="col-lg-10">
							<form:input id="name" path="name"/>
						</div>
					</div>
					
					<div class="form-group">
					<label class="control-label col-lg-2" for="description">Opis</label>
						<div class="col-lg-10">
							<form:textarea id="description" path="description" rows="2"/>
						</div>
					</div>					

					<div class="form-group">
						<label class="control-label col-lg-2" for="unitPrice">Cena</label>
						<div class="col-lg-10">
							<form:input id="unitPrice" path="unitPrice"/>
						</div>
					</div>

					<div class="form-group">
						<label class="control-label col-lg-2" for="manufacturer">Producent</label>
						<div class="col-lg-10">
							<form:input id="manufacturer" path="manufacturer"/>
						</div>
					</div>

					<div class="form-group">
						<label class="control-label col-lg-2" for="category">Kategoria</label>
						<div class="col-lg-10">
							<form:input id="category" path="category"/>
						</div>
					</div>

					<div class="form-group">
						<label class="control-label col-lg-2" for="unitsInStock">Liczba dostępnych sztuk</label>
						<div class="col-lg-10">
							<form:input id="unitsInStock" path="unitsInStock"/>
						</div>
					</div>

					<div class="form-group">
						<label class="control-label col-lg-2" for="condition">Stan</label>
						<div class="col-lg-10">
							<form:radiobutton path="condition" value="New" />Nowy
							<form:radiobutton path="condition" value="Old" />Używany
							<form:radiobutton path="condition" value="Refurbished"/>Odnowiony
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-lg-2" for="productImage">
							<spring:message code="addProdcut.form.productImage.label"/>
						</label>
						<div class="col-lg-10">
							<form:input id="productImage" path="productImage" type="file" class="form:input-large" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-lg-2" for="productManual">
							<spring:message code="addProdcut.form.productManual.label"/>
						</label>
						<div class="col-lg-10">
							<form:input id="productManual" path="productManual" type="file" class="form:input-large" />
						</div>
					</div>
					<div class="form-group">
						<div class="col-lg-offset-2 col-lg-10">
							<input type="submit" id="btnAdd" class="btn btn-primary" value ="Dodaj"/>
						</div>
					</div>
				</fieldset>
			</form:form>
		</section>
	</body>
</html>