<%@page import="modelbean.ArtistaBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="modelbean.UserBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
	UserBean user = (UserBean) session.getAttribute("user"); 
    ArrayList<ArtistaBean> artisti = (ArrayList<ArtistaBean>) request.getAttribute("artisti");
    %>
    
	
<jsp:include page="/header.jsp" >
<jsp:param value="Artisti" name="title"/>
	</jsp:include>
	<!-- Page Preloder -->
	<div id="preloder">
		<div class="loader"></div>
	</div>
		<div class="center">
		<ul>
 		<%for(ArtistaBean a: artisti) {%>
 		<li><%=a.getNomeArte() %> </li>
 		<%} %>
		</ul>
		</div>

		<jsp:include page="/footer.jsp" />
</body>
</html>