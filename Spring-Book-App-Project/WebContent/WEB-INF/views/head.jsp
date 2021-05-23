<%@taglib prefix="p" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
<title>Book Shop App</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<nav class="navbar navbar-expand-md bg-dark navbar-dark">
	<!-- Brand -->
	<a class="navbar-brand" href="#">BookShop</a>

	<!-- Toggler/collapsibe Button -->
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#collapsibleNavbar">
		<span class="navbar-toggler-icon"></span>
	</button>

	<!-- Navbar links -->
	<div class="collapse navbar-collapse" id="collapsibleNavbar">
		<ul class="navbar-nav">
			<p:choose>
				<p:when test="${sessionScope.user==null}">
					<li class="nav-item"><a class="nav-link" href="#">Home</a></li>
					<li class="nav-item"><a class="nav-link" href="login">Login</a></li>
					<li class="nav-item"><a class="nav-link" href="register">Register</a></li>
				</p:when>
				<p:otherwise>
					<li class="nav-item"><a class="nav-link" href="addbook">Add
							Book</a></li>
					<li class="nav-item"><a class="nav-link" href="books">Book
							List</a></li>
					<li class="nav-item"><a class="nav-link" href="logout">Logout</a></li>
				</p:otherwise>
			</p:choose>
		</ul>
	</div>
</nav>