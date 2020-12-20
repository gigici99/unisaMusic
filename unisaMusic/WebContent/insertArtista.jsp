<%@page import="java.util.ArrayList"%>
<%@page import="modelbean.BranoBean"%>
<%@page import="modelbean.UserBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="controlservlet.*"%>

<jsp:include page="/header.jsp" >
<jsp:param value="inserisciArtista" name="title"/>
</jsp:include>
<!-- Page Preloder -->
	<div id="preloder">
		<div class="loader"></div>
	</div>
	<div class="center">
	<h1 id="">Inserisci Artista</h1>
	<hr>
	<form action="InsertArtista" method="post">
		<label id="">Nome dell'Artista: <br></label>
			<div id="">
				<input type="text" name="nome" placeholder="Irama">
			</div>
			
			<button type="submit" class="site-btn">Inserisci</button>
	</div>
	</form>
	<jsp:include page="/footer.jsp" />
</body>
</html>