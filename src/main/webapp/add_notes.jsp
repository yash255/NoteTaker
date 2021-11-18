<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Notes</title>
<%@include file="all_include.jsp" %>
</head>
<body>

<div class="container">
<%@include file="navbar.jsp" %>
<br>
<h1>Add Notes</h1>
<br>
<!-- add form -->

<form action="SaveNote" method="post">
  <div class="mb-3">
    <label class="form-label">Note Title</label>
    <input required type="text" name="title" class="form-control" id="title" placeholder="Enter Title">
    
  </div>
  <div class="mb-3">
    <label  class="form-label">Note Content</label>
    <textarea required type="text" name="content" class="form-control" rows="7" id="content" placeholder="Enter Content"></textarea>
  </div>
  
  <div class="container" text-center>
  <button type="submit" class="btn purple text-white">Submit</button>
  </div>
</form>

</div>

</body>
</html>