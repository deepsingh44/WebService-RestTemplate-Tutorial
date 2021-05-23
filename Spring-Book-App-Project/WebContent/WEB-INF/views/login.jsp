<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@include file="head.jsp"%>
<head>
<script type="text/javascript" src="js/login.js"></script>
</head>
<div class="container">
	<br>
	<div class="card" style="padding: 10px;background-image: url('<spring:url value="/images/background.png"/>');">
		<div class="row" style="height: 500px;">
			<div class="col-sm-5">
				<div>
					<img src="<spring:url value="/images/login.png"/>" width="100%"
						height="100%"  style="border-radius: 10px;">
				</div>
			</div>

			<div class="col-sm-1"></div>

			<div class="col-sm-6">
				<br>
				<h2 align="center" style="color: white;">Login Details</h2>
				<hr>
				<div class="form-group">
					<label for="email" style="color: white;">Email address:</label> <input type="email"
						class="form-control" placeholder="Enter email" id="email">
				</div>
				<div class="form-group">
					<label for="pwd" style="color: white;">Password:</label> <input type="password"
						class="form-control" placeholder="Enter password" id="pwd">
				</div>
				<div class="form-group form-check">
					<label class="form-check-label" style="color: white;"> <input
						class="form-check-input" type="checkbox"> Remember me
					</label>
				</div>
				<br>
				<div align="center">
					<button type="submit" class="btn btn-primary" style="width: 50%;"
						id="login">Login</button>
				</div>
			</div>
		</div>
	</div>

</div>