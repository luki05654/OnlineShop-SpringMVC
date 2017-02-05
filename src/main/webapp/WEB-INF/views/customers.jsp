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

		<title>Klienci</title>
	</head>
	<body>
		<section>
			<div class="jumbotron">
				<div class="container">
					<h1>Klienci</h1>
					<p>Wszyscy klienci sklepu</p>
				</div>
			</div>
		</section>

		<section class="container">
			<div class="row">
				<c:forEach items="${customers}" var="customer">
					<div class="col-sm-6 col-md-3" style="padding-bottom: 15px">
						<div class="thumbnail">
							<div class="caption">
								<h3>${customer.name}</h3>
								<p>${customer.address}</p>
								<p>Liczba zakupionych produktów: ${customer.noOfOrdersMade}</p>
							</div>
						</div>
					</div>
				</c:forEach>				
			</div>
		</section>
	</body>
</html>