<%@page import="modelbean.UserBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="controlservlet.*"%>
    
    <%UserBean user = (UserBean) session.getAttribute("user"); %>

<jsp:include page="/header.jsp" >
<jsp:param value="User" name="title"/>
</jsp:include>
<!-- Page Preloder -->
	<div id="preloder">
		<div class="loader"></div>
	</div>
	<div class="center">
	<h1 id="">Modifica Profilo</h1>
	<hr>
	<form action="modifica-profilo" method="post" id="registrazione">
		<label id="">Username*<br></label>
			<div id="">
				<input type="text" name="username" id="username" placeholder="UnisaMusic" oninput="validaUsername()">
			</div>
			
		<label id="">E-Mail*<br></label>
			<div id="">
				<input type="text" name="email" id="email" placeholder="l.cirillo33@studenti.unisa.it" oninput="validaEmail()">
			</div>
			
		<label id="">Nome*<br></label>
			<div id="">
				<input type="text" name="nome"id="nome" placeholder="Luigi" oninput="validaNome()">
			</div>
			
		<label id="">Cognome*<br></label>
			<div id="">
				<input type="text" name="cognome" id="cognome" placeholder="Cirillo" oninput="validaCognome()">
			</div>
			
		<label id="">Codice Fiscale*<br></label>
			<div id="">
				<input type="text" name="codicefiscale" id="codicefiscale" placeholder="CRLLGU99H23G813F" oninput="validaCF()">
			</div>
			
		<label id="">Password*<br></label>
			<div id="">
				<input type="password" name="password" id="password" placeholder="********" oninput="validaPassword()">
			</div>
			
		<label id="">Ripeti Password*<br></label>
			<div id="">
				<input type="password" name="passwordConferma" id="passwordconferma" placeholder="********" oninput="validaPassword()">
			</div>
			
		<input value="Aggiorna" type="submit" class="site-btn" id="registrami" disabled>
	</form>
	<hr>
	</div>
	
	<script>
    var borderOk = '2px solid green';
    var borderNo = '2px solid red';
    var usernameOk = false;
    var passwordOk = false;
    var emailOk = false;

    function validaUsername() {
        var input = document.forms['registrazione']['username'];
        if (input.value.length >= 6 && input.value.match(/^[0-9a-zA-Z]+$/)) {
            // verifica se esiste un utente con lo stesso username
            var xmlHttpReq = new XMLHttpRequest();
            xmlHttpReq.onreadystatechange = function() {
                if (this.readyState == 4 && this.status == 200
                    && this.responseText == '<ok/>') {
                    usernameOk = true;
                    input.style.border = borderOk;
                } else {
                    input.style.border = borderNo;
                    usernameOk = false;
                }
                cambiaStatoRegistrami();
            }
            xmlHttpReq.open("GET", "VerificaUsername?username="
                + encodeURIComponent(input.value), true);
            xmlHttpReq.send();
        } else {
            input.style.border = borderNo;
            usernameOk = false;
            cambiaStatoRegistrami();
        }
    }

    function validaPassword() {
        var inputpw = document.forms['registrazione']['password'];
        var inputpwconf = document.forms['registrazione']['passwordConferma'];
        var password = inputpw.value;
        if (password.length >= 8 && password.toUpperCase() != password
            && password.toLowerCase() != password && /[0-9]/.test(password)) {
            inputpw.style.border = borderOk;

            if (password == inputpwconf.value) {
                inputpwconf.style.border = borderOk;
                passwordOk = true;
            } else {
                inputpwconf.style.border = borderNo;
                passwordOk = false;
            }
        } else {
            inputpw.style.border = borderNo;
            inputpwconf.style.border = borderNo;
            passwordOk = false;
        }
        cambiaStatoRegistrami();
    }

    function validaNome() {
        var input = document.forms['registrazione']['nome'];
        if (input.value.trim().length > 0
            && input.value.match(/^[ a-zA-Z\u00C0-\u00ff]+$/)) {
            input.style.border = borderOk;
            nomeOk = true;
        } else {
            input.style.border = borderNo;
            nomeOk = false;
        }
        cambiaStatoRegistrami();
    }
    
    function validaCognome() {
        var input = document.forms['registrazione']['cognome'];
        if (input.value.trim().length > 0
            && input.value.match(/^[ a-zA-Z\u00C0-\u00ff]+$/)) {
            input.style.border = borderOk;
            nomeOk = true;
        } else {
            input.style.border = borderNo;
            nomeOk = false;
        }
        cambiaStatoRegistrami();
    }

    function validaCF(inputtxt) {
    	 var input = document.forms['registrazione']['codicefiscale'];
         if (input.value.trim().length > 0
             && input.value.match(/^[a-zA-Z]{6}[0-9]{2}[a-zA-Z][0-9]{2}[a-zA-Z][0-9]{3}[a-zA-Z]$/)) {
             input.style.border = borderOk;
             nomeOk = true;
         } else {
             input.style.border = borderNo;
             nomeOk = false;
         }
         cambiaStatoRegistrami();	
    }
    
    function validaEmail() {
        var input = document.forms['registrazione']['email'];
        if (input.value.match(/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w+)+$/)) {
            // verifica se esiste un utente con la stessa email
            var xmlHttpReq = new XMLHttpRequest();
            xmlHttpReq.onreadystatechange = function() {
                if (this.readyState == 4 && this.status == 200
                    && this.responseText == '<ok/>') {
                    input.style.border = borderOk;
                    emailOk = true;
                } else {
                    input.style.border = borderNo;
                    emailOk = false;
                }
                cambiaStatoRegistrami();
            }
            xmlHttpReq.open("GET", "VerificaEmail?email="
                + encodeURIComponent(input.value), true);
            xmlHttpReq.send();
        } else {
            input.style.border = borderNo;
            emailOk = false;
            cambiaStatoRegistrami();
        }

    }

    function cambiaStatoRegistrami() {
        if (usernameOk && passwordOk && emailOk) {
            document.getElementById('registrami').disabled = false;
            document.getElementById('registramimessaggio').innerHTML = '';
        } else {
            document.getElementById('registrami').disabled = true;
            document.getElementById('registramimessaggio').innerHTML = 'Verifica che tutti i campi siano in verde.';
        }
    }
</script>
			<jsp:include page="/footer.jsp" />
	
</body>
</html>