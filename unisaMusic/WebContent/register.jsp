 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>
    
    <% 
		String email = (String) request.getAttribute("email");
		String username = (String) request.getAttribute("username");
		String codiceFiscale = (String) request.getAttribute("codiceFiscale");
		String error = (String) request.getAttribute("errorMessage");
		
		if(email == null)
			email = "";
		if(username == null)
			username = "";
		if(codiceFiscale == null)
			codiceFiscale = "";
	%>

<jsp:include page="/header1.jsp" >
<jsp:param value="Register" name="title"/>
</jsp:include>
	
<section class="blog-section spad">
<div class="container">
	<div class="center">
	<h1 id="">Registrati</h1>
	<form action="register" method="post" class="formRegister"  name="registrazione" id="registrazione">
		<input type="hidden" name="action" value="register">
		
		<label id="">Username*<br></label>
			<div id="">
				<input type="text" name="username" id="username" value="<%=username %>" placeholder="UnisaMusic" oninput="validaUsername()">
			</div>
			
		<label id="">E-Mail*<br></label>
			<div id="">
				<input type="text" name="email" id="email" value="<%=email %>" placeholder="l.cirillo33@studenti.unisa.it" oninput="validaEmail()">
			</div>
			
		<label id="">Password*<br></label>
			<div id="">
				<input type="password" name="password" id="password" placeholder="********" oninput="validaPassword()">
			</div>
			
		<label id="">Ripeti Password*<br></label>
			<div id="">
				<input type="password" name="passwordConferma" id="passwordconferma" placeholder="********" oninput="validaPassword()">
			</div>
			
		<span class="">
		<% if(error != null){%>
		<%=error %>
		<%} %>
		</span><br>
			
		<input value="Registra" type="submit" class="site-btn" id="registrami" disabled>
		<div id="registramimessaggio" name="registramimessaggio"></div>
	</form>


		<div class="user-pannel">
		Sei già registrato? <a href="<%=response.encodeURL("InitServlet?action=InitServlet") %>">Accedi qui</a>
		</div>
		<pre>
		username deve essere di almeno 6 caratteri;
		email non deve essere già utilizzata;
		password almeno 8 carratteri di cui una maiuscola è una minuscola 
		e un numero;	
		</pre>
	</div>
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
/*
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
*/
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

</section>
	<jsp:include page="/footer.jsp" />
</body>
</html>