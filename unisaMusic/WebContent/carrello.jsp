<%@page import="java.util.ArrayList"%>
<%@page import="modelbean.UserBean"%>
<%@page import="modelbean.BranoBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
	UserBean user = (UserBean) session.getAttribute("user"); 
    ArrayList<BranoBean> carrello = (ArrayList<BranoBean>) session.getAttribute("carrello");
    %>
    
	
<jsp:include page="/header.jsp" >
<jsp:param value="Carrello" name="title"/>
	</jsp:include>
<!-- Page Preloder -->
	<div id="preloder">
		<div class="loader"></div>
	</div>
	
	<div class="center">
	<h1>Carrello</h1>
	<ul>
	<%if(carrello.size()>0){ %>
 		<%for(BranoBean b: carrello) {%>
 		<li> Titolo: <%=b.getTitle() %></li>
 		<li> Time: <%=b.getTime() %></li>
 		<li>Nome dell'Artista: <%=b.getNomeArtista() %></li>
 		<a href="EliminaCarrello?id=<%=b.getID()%>">delete</a>
 		<hr>
 		</li>
 		<%} %>
 		<a href="AcquistaCarrello">acquista</a>
 		<%	
	}
 		else{%>
 		<p>Non ci sono brani nel carrello
 		</p>
 		<%} %>
 		
	</ul>
	
	</div>
	<jsp:include page="/footer.jsp" />
</body>
</html>