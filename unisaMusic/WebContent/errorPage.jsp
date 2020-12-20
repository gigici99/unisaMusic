<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>
    
<%
	int status = response.getStatus();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><%=status == 404 ? "Errore 404" : status == 500 ? "Errore 500" : "ERRORE!"%></title>
</head>
<!-- Page Preloder -->
	<div id="preloder">
		<div class="loader"></div>
	</div>
	<div class="">
		<img src="/provatsw/img/ <%=status%>.png">
		<h2>
		<%if(status == 404) {%>
			La pagina che cerchi non esiste. Ti consigliamo di tornare dietro con la navigazione
		<%} else if(status == 500){ %>
			Si è verificato un errore durante l'elaborazione della richiesta, riprova più tardi. 
		<%} else { %>
			Qualcosa è andato storto. :-)
		<%} %>
		</h2>
		
		<%
			if(exception != null){
				out.flush();
				exception.printStackTrace(response.getWriter());
			}
		%>
	</div>
	
</body>
</html>