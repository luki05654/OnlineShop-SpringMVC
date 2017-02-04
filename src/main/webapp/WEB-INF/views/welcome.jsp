<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
	<head>
		<title>Home</title>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	</head>

	<body>
		<section>
			<div class="jumbotron">
				<div class="container">
					<h1>${greeting}</h1>
					<p>${tagline}</p>
				</div>
			</div>
		</section>
	</body>
</html>
