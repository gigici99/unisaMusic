<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
      <%
	String error = (String) request.getAttribute("errorMessage");
	String email = (String) request.getAttribute("email");
	if(email == null)
		email="";
		%>

 <jsp:include page="/header1.jsp" >
<jsp:param value="Login" name="title"/>
</jsp:include>
	
	<section class="blog-section spad">
	<div class="container">
	<div class="center">
	<h1 id="h1">Login</h1>
	<hr>
	<form action="login" method="post" class="formLogin" >
		<label id="email">E-Mail<br></label>
		<div class="">
			<span class="span"><i class="i"></i></span>
			<input type="text" name="email" value="<%=email %>" placeholder="l.cirillo33@studenti.unisa.it">
		</div>

		<label id="password">Password<br></label>
		<div class="">
			<span class="span"><i class="i"></i></span>
			<input type="password" name="password" placeholder="********">
		</div>		
		
		<span class="">
		<%if(error != null){ %>
		<%=error %>
		<%} %>
		</span><br>

		
		<button type="submit" class="site-btn">login</button><hr>
	</form>
	
	
	<pre class="paragrafo">
	sei un nuovo utente?
	<a href="<%=response.encodeURL("InitServletRegister?action=InitServletRegister") %>">REGISTRATI</a>
	</pre>
		</div>
	</div>
	</section>
		<jsp:include page="/footer.jsp" />
</body>
</html>