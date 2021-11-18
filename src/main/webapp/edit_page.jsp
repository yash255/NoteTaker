<%@page import="com.entities.NoteTaker"%>
<%@page import="com.helper.factoryProvider"%>
<%@page import="org.hibernate.Session"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit</title>
<%@include file="all_include.jsp" %>
</head>
<body>



<%
int note_id = Integer.parseInt(request.getParameter("note_id").trim());

Session s = factoryProvider.getFactory().openSession();

NoteTaker note=s.get(NoteTaker.class, note_id);
%>

<div class="container">
<%@include file="navbar.jsp" %>
<br>
<h1>Edit Note</h1>
<br>
<!-- add form -->

<form action="UpdateNote" method="post">

<input value="<%=note.getId()%>" name="note_id" type="hidden"/>
  <div class="mb-3">
    <label class="form-label">Note Title</label>
    <input required type="text" name="title" class="form-control" id="title" placeholder="Enter Title" value="<%= note.getTitle() %>">
    
  </div>
  <div class="mb-3">
    <label  class="form-label">Note Content</label>
    <textarea required type="text" name="content" class="form-control" rows="7" id="content" placeholder="Enter Content" ><%= note.getContent() %></textarea>
  </div>
  
  <div class="container" text-center>
  <button type="submit" class="btn btn-success text-white">Save changes</button>
  </div>
</form>

</div>


</body>
</html>