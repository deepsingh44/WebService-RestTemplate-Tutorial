<%@taglib prefix="p" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@include file="head.jsp"%>

<div class="container">
	<br>
	<div class="card"
		style="padding: 10px;background-image: url('<spring:url value="/images/background.png"/>');">
		<div class="row" style="height: 500px;">

			<div class="col-sm-1"></div>

			<div class="col-sm-5">
				<div class="card">
					<div>
						<img src="<spring:url value="/images/book_item.png"/>"
							width="100%" height="400">
					</div>
					<div style="width: 98%;margin-top: 5px;margin-bottom: 5px;margin-left: 3px;">
						<div style="width: 49%;float: left;">
							<button class="btn btn-primary" style="width: 100%;">ADD
								TO CART</button>
						</div>

						<div style="width: 49%;float: right;">
							<button class="btn btn-warning"
								style="width: 100%; color: white;">BUY NOW</button>
						</div>
					</div>
				</div>
			</div>

			<div class="col-sm-5" style="color: white;">
			<p>${book.name}</p>
			<p>${book.price}</p>
			<p>${book.author}</p>
			<p>${book.category}</p>
			</div>
			<div class="col-sm-1"></div>
		</div>
	</div>
</div>