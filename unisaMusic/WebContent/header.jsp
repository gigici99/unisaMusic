<%@page import="modelbean.UserBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%UserBean user = (UserBean) session.getAttribute("user"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="description" content="UnisaMusic HTML Template">
<meta name="keywords" content="music, html">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<link href="img/um.png" rel="shortcut icon"/>

<!-- google font -->
<link href="https://fonts.googleapis.com/css?family=Montserrat:300,300i,400,400i,500,500i,600,600i,700,700i&display=swap" rel="stylesheet">

<!-- stylesheet -->
<link rel="stylesheet" href="css1/bootstrap.min.css"/>
<link rel="stylesheet" href="css1/font-awesome.min.css"/>
<link rel="stylesheet" href="css1/owl.carousel.min.css"/>
<link rel="stylesheet" href="css1/slicknav.min.css"/>

<!-- Main Stylesheets -->
<link rel="stylesheet" href="css1/style.css"/>

<!-- 
<link rel="stylesheet" type="text/css" href="css/style.css">
<link rel="stylesheet" type="text/css" href="css/responsive.css">
 -->
<title>${title}</title>
</head>
<body>

<!-- Header section -->
	<header class="header-section clearfix">
		<div class="site-logo">
			<img src="img/logo.png" alt="UnisaMusic">
		</div>
		
		
		
		
		<ul class="main-menu">
			<%if(user.getTipo() == false) {%>
			<li><a href="#">Pages</a>
			<ul class="sub-menu">
			<li><a id="" href="<%=response.encodeURL("InitServletUserMod?action=InitServletUserMod")%>">Area Utente</a></li>		
			<li><a id="" href="InitServletArtisti">Artisti</a></li>
			<li><a id="" href="InitServletBrano">Brani</a></li>
			<li><a id="" href="MostraCarrello">Carrello</a></li>
			<li><a id="" href="CanzoniAcquistate">I MIEI ACQUISTI</a></li>
			
			</ul>
					<%} else { %>
			<li><a href="#">Pages</a>
				<ul class="sub-menu">
			<li><a id="" href="<%=response.encodeURL("InitServletUserMod?action=InitServletUserMod")%>">Area Utente</a></li>		
			<li><a id="" href="InitServletInsertA">Inserisci Artisti</a></li>
			<li><a id="" href="InitServletInsertB">Inserisci Brani</a></li>
			<li><a href="MostraUtenti">Utenti</a></li>
			</ul>
					<%} %>
			<li><a href="InitServletHome">Home</a></li>
			<li><a href="<%=response.encodeURL("./logout")%>">Logout</a></li>
			</ul>
			<form action="RicercaServlet" method="get">
						<input type="text" name="q" list="ricerca-datalist" placeholder="Ricerca" onkeyup="ricerca(this.value)" >
						<datalist id="ricerca-datalist"></datalist>
					</form>
	</header>
	<!-- Header section end -->



		<!-- 
<header>
	<div class="">
			<input type="text" name="q" placeholder="Cerca">
			<input type="submit" value="cerca">
		</div>

		
		<nav>
			<div>
				<%if(user.getTipo() == false) {%>
					<a id="" href="<%=response.encodeURL("InitServletUserMod?action=InitServletUserMod")%>">Area Utente</a>			
					<a id="" href="InitServletArtisti">Artisti</a>
					<a id="" href="InitServletBrano">Brani</a>
					<%} else { %>
					<a id="" href="<%=response.encodeURL("InitServletUserMod?action=InitServletUserMod")%>">Area Utente</a>			
					<a id="" href="InitServletInsertA">Inserisci Artisti</a>
					<a id="" href="InitServletInsertB">Inserisci Brani</a>
					<%} %>
					<a href="InitServletHome">Home</a>
					<a href="<%=response.encodeURL("./logout")%>">Logout</a>	
			
    		</div>
    	</nav>
    	</header>
		 -->