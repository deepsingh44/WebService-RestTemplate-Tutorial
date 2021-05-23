<%@taglib prefix="p" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@include file="head.jsp"%>
<head>
<script type="text/javascript" src="js/booklist.js"></script>
<style type="text/css">
.box:hover {
	box-shadow: 0 2px 4px 0 rgba(0, 0, 0, 0.2);
	transition: 0.2s;
	background: purple;
	color: white;
}
</style>
</head>
<div class="container">
	<br>
	<div class="card"
		style="padding: 10px;background-image: url('<spring:url value="/images/background.png"/>');">
		<div class="row" style="height: 80vh;">

			<div class="col-sm-12">
				<p:choose>
					<p:when test="${books==null || books.size()==0}">

						<div align="center">
							<img src="<spring:url value="/images/no_books.jpg"/>" width="300"
								height="300px" style="border-radius: 10px;">
						</div>
						<div align="center">
							<br>
							<h1 style="color: white; font-family: serif;">NO BOOKS
								AVAILABLE</h1>
						</div>
					</p:when>

					<p:otherwise>

						<div class="row">

							<p:forEach items="${books}" var="book">

								<div class="col-sm-4">
									
									<div class="card box">
										<img src="<spring:url value="/images/book_item.png"/>"
											width="100%" height="150" style="border-radius: 5px;">
											<input type="hidden" id="bid" value="${book.id}">
										<p style="padding: 0; margin: 0;">
											<b
												style="padding-left: 5px; font-family: serif; letter-spacing: 2px;">${book.name}</b>
										</p>
										<p style="padding: 0; margin: 0;">
											<b
												style="padding-left: 5px; color: gray; font-family: serif;">$
												${book.price}</b>
										</p>
										<p style="padding: 0; margin: 0;">
											<b
												style="padding-left: 5px; color: gray; font-family: serif;">${book.author}</b>
										</p>
									</div>
									<br>
								</div>

							</p:forEach>

						</div>

					</p:otherwise>
				</p:choose>

			</div>

		</div>
	</div>

	<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<div style="width: 100%;" align="center">
						<h4 style="background: red;" class="modal-title">Book Detail</h4>
					</div>
				</div>
				<div class="modal-body">
				
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				</div>
			</div>
		</div>
	</div>

</div>