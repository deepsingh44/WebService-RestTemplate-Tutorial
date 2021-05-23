<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@include file="head.jsp"%>
<head>
<script type="text/javascript" src="js/app.js"></script>
</head>

<div class="container">

	<br>
	<div class="card" style="padding: 10px;background-image: url('<spring:url value="/images/background.png"/>');">
		<div class="row" style="height: 600px;">
			<div class="col-sm-5">
				<div>
					<img src="<spring:url value="/images/addbook.jpg"/>" width="100%"
						height="100%" style="border-radius: 10px;">
				</div>
			</div>

			<div class="col-sm-1"></div>

			<div class="col-sm-6">
				<br>
				<h2 align="center" style="color: white;">Add Book</h2>
				<hr>

				<div class="form-group">
					<label for="name" style="color: white;">Book Name:</label> <input type="text"
						class="form-control" placeholder="Enter Book Name" id="name">
				</div>
				<div class="form-group">
					<label for="price" style="color: white;">Book Price:</label> <input type="number"
						class="form-control" placeholder="Enter Book Price" id="price">
				</div>
				<div class="form-group">
					<label for="author" style="color: white;">Book Author:</label> <input type="text"
						class="form-control" placeholder="Enter Book Author" id="author">
				</div>
				<div class="form-group">
					<label for="date" style="color: white;">Book Date:</label> <input type="date"
						class="form-control" placeholder="Select Book Date" id="date">
				</div>

				<div class="form-group">
					<label for="category" style="color: white;">Select Category:</label> <select
						class="form-control" id="category">
						<option>Select Category</option>
						<option>Education</option>
						<option>Science</option>
						<option>Others</option>
					</select>
				</div>

				<div align="center"><button type="submit" style="width: 50%;" class="btn btn-primary" id="btn">Add
					Book</button></div>

			</div>
		</div>
	</div>

</div>