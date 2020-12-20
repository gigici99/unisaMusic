<%@page import="modelbean.ArtistaBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="modelbean.BranoBean"%>
<%@page import="modelbean.UserBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="controlservlet.*"%>
    
<%	UserBean user = (UserBean) session.getAttribute("user");
	ArrayList<ArtistaBean> listaArtisti = (ArrayList<ArtistaBean>) request.getAttribute("listaArtisti"); %>

<jsp:include page="/header.jsp" >
<jsp:param value="inserisciBrano" name="title"/>
</jsp:include>
	<!-- Page Preloder -->
	<div id="preloder">
		<div class="loader"></div>
	</div>
	<div class="center">
	<h1 id="">Inserisci Brani</h1>
	<hr>
	<form action="InsertBrano" method="post">
		<label id="">Titolo: <br></label>
			<div id="">
				<input type="text" name="titolo" placeholder="Mediterranea">
			</div>
			
		<label id="">Durata: <br></label>
			<div id="">
				<input type="text" name="durata" placeholder="00:03:43">
			</div>
			
		<label id="">Nome dell'Artista: <br></label>
			<div id="">
				<select name="nome_arte" id="">
				<%for(ArtistaBean a: listaArtisti){ %>
    				<option value="<%=a.getNomeArte()%>"><%=a.getNomeArte()%></option>
    				<%} %>
    			</select>
			</div>
			
			
		<button type="submit" class="site-btn">Inserisci</button>
	</form>
	<hr>
	</div>
			<jsp:include page="/footer.jsp" />
	
</body>
</html>