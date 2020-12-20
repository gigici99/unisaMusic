<%@page import="java.util.ArrayList"%>
<%@page import="modelbean.UserBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
	UserBean user = (UserBean) session.getAttribute("user"); 
   	ArrayList<UserBean> utenti = (ArrayList<UserBean>) request.getAttribute("utenti");
    %>
    
	
<jsp:include page="/header.jsp" >
<jsp:param value="Utenti" name="title"/>
	</jsp:include>
<!-- Page Preloder -->
	<div id="preloder">
		<div class="loader"></div>
	</div>
	
	<div class="center">
	<h1>Lista Utenti</h1>
	<ul>
	<%if(utenti.size()>0){ %>
 		<%for(UserBean u: utenti) {%>
 		<li> Email: <%=u.getEmail() %></li>
 		<a href="EliminaAccount?id=<%=u.getId() %>">delete</a>
 		<hr>
 		</li>
 		<%} %>
 		<%}
 		else{%>
 		<p>
 		Non ci sono utenti presenti nel database.
 		</p>
 		<%} %>
 		
	</ul>
	
	</div>
	<jsp:include page="/footer.jsp" />
</body>
</html>