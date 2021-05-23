<%@taglib prefix="p" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<div class="container">
<table class="table table-hover">
    <thead>
      <tr>
        <th>ID</th>
        <th>NAME</th>
        <th>AUTHOR</th>
      </tr>
    </thead>
<p:forEach items="${books}" var="book">

    <tbody>
      <tr>
        <td>${book.id}</td>
        <td>${book.name}</td>
        <td>${book.author}</td>
      </tr>
     
    </tbody>
  
</p:forEach>
</table>
<ul class="pagination">
  <li><a href="page?pagenum=1">1</a></li>
  <li><a href="page?pagenum=2">2</a></li>
  <li><a href="page?pagenum=3">3</a></li>
  <li><a href="page?pagenum=4">4</a></li>
  <li><a href="page?pagenum=5">5</a></li>
</ul>
</div>