<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@include file="head.jsp"%>
<head>
<script type="text/javascript" src="js/register.js"></script>
</head>
<div class="container">

	<br>
	<div class="card" style="padding: 10px;background-image: url('<spring:url value="/images/background.png"/>');">
		<div class="row" style="height: 500px;">
			<div class="col-sm-5">
				<div>
					<img src="<spring:url value="/images/regist.jpg"/>" width="100%"
						height="100%" style="border-radius: 10px;">
				</div>
			</div>

			<div class="col-sm-1"></div>
			<div class="col-sm-6">
				<br>
				<h2 align="center" style="color: white;">Register Details</h2>
				<hr>
				<div class="form-group">
					<label for="name" style="color: white;">Full Name:</label> <input type="text"
						class="form-control" placeholder="Enter Name" id="name">
				</div>
				<div class="form-group">
					<label for="email" style="color: white;">Email address:</label> <input type="email"
						class="form-control" placeholder="Enter email" id="email">
				</div>
				<div class="form-group">
					<label for="pwd" style="color: white;">Password:</label> <input type="password"
						class="form-control" placeholder="Enter password" id="pwd">
				</div>
				<br>
				<div align="center">
					<button type="submit" class="btn btn-primary" style="width: 50%;"
						id="register">Submit</button>
				</div>
			</div>
		</div>
	</div>
</div>









