<%@page import="com.entities.NoteTaker"%>

<%@page import="java.util.List"%>
<%@page import="org.hibernate.Query"%>
<%@page import="com.helper.factoryProvider"%>
<%@page import="org.hibernate.Session"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Notes</title>
<%@include file="all_include.jsp" %>

</head>
<body>
<div class="container">
<%@include file="navbar.jsp" %>

<div class="row">
<div class="col-12">

<%
Session session2 = factoryProvider.getFactory().openSession();

Query q = session2.createQuery("from NoteTaker ");
List<NoteTaker> list = q.list();

for(NoteTaker note:list){
	%>
	
	<div class="card mt-3" >
  <img src="img/essay.png" class="card-img-top p-4 mx-auto" alt="..." style="max-width:100px">
  <div class="card-body px-5">
    <h5 class="card-title"><%=note.getTitle() %></h5>
    <p class="card-text"><%=note.getContent() %></p>
    <p class="text-primary"><b>Last Updated on : <%=note.getAddedDate() %></b></p>
   
 <div class="container text-center mt-2">
 
    <a href="edit_page.jsp?note_id=<%=note.getId() %>" class="btn purple text-white">Edit</a>
    <a href="Delete?note_id=<%=note.getId() %>" class="btn btn-danger">Delete</a>
 </div>

   
  </div>
</div>
	
	
<% 	
}


session2.close();
%>


</div>

</div>



</div>

</body>
</html>