<%@page import="modelbean.UserBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="controlservlet.*"%>
    
    <%UserBean user = (UserBean) session.getAttribute("user"); %>

<jsp:include page="/header.jsp" >
<jsp:param value="HomePage" name="title"/>
</jsp:include>
	<%
    String email = (String) user.getEmail();
    %>	
    <!-- Page Preloder -->
	<div id="preloder">
		<div class="loader"></div>
	</div>
		<div class="center">
		    <div class="section-title">
			<h1>HOME</h1>
			<%if(email != null) {%>
			<%=email %>
			<%} %>
		    </div>
			
		<section class="category-section spad">
		<div class="container-fluid">
			<div class="section-title">
			<h3><a href="<%=response.encodeURL("BraniAscoltati")%>">Brani più ascoltati</a></h3>
			<h3><a href="<%=response.encodeURL("ArtistiAscoltati")%>">Artisti più ascoltati</a></h3>
			</div>
		</div>
		</div>
		</section>

		<jsp:include page="/footer.jsp" />	
</body>
</html>