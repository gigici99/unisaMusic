<%@page import="modelbean.ArtistaBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="modelbean.UserBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>

    
	
<jsp:include page="/header.jsp" >
<jsp:param value="exception" name="title"/>
	</jsp:include>
		<section>
        	<h1><%= exception.getMessage() %></h1>
        </section>
        	<jsp:include page="/footer.jsp" />
</body>
</html>