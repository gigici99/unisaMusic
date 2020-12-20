<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>

    
	
<jsp:include page="/header.jsp" >
<jsp:param value="esito registrazione" name="title"/>
	</jsp:include>

<!-- Page Preloder -->
	<div id="preloder">
		<div class="loader"></div>
	</div>
	<section class="category-section spad">
		<div class="container-fluid">
			${message}
		</div>
	</section>
	
		<%
			if(exception != null){
				out.flush();
				exception.printStackTrace(response.getWriter());
			}
		%>
		<jsp:include page="/footer.jsp" />
</body>
</html>