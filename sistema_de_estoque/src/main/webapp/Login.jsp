<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Usuario" %>
<!DOCTYPE html>
<html lang="pt-bt">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="Style/LoginImagem.css">
    <link rel="icon" type="image/x-icon" href="imagens/recanto_do_parque_logo.png">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.2.0/css/all.css%27%3E">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.2.0/css/fontawesome.css%27%3E">
    <!-- <script src="https://kit.fontawesome.com/ca14b9e588.js" crossorigin="anonymous"></script> -->
    <title>Login</title>
</head>
<body <%if (Usuario.getAcesso().equals("negado")){ %> onload="negado()" <%} %>>
    <div class="navbar">
        <input id="engrenagem" src="imagens/settings.png" type="image">
        <input id="perfil" src="imagens/user_icon.png" type="image">
    </div>

    <div class="form">
        <form action="login" name="formLogin">
            <div class="CPFInput">
                <img id="userIcon" src="imagens/user_icon.png">
                <input id="CPF" name="CPF" placeholder="CPF" type="text" pattern="\d{3}\.?\d{3}\.?\d{3}-?\d{2}" title="Digite um CPF no formato: xxx.xxx.xxx-xx">
            </div>
            <div class="passwordInput">
                <img id="keyIcon" src="imagens/hidden.png">
                <input id="allSeeingEye" onclick="eyeHide()" src="imagens/hidden.png" type="image" form="fakeForm">
                <input id="Senha" name="Senha" placeholder="Senha" type="password">
            </div>
            
            <div class="CheckBox">
                <input id="rememberMe" type="checkbox" name="rememberMe" value="rememberMe">
                <label id="rememberMeText" for="rememberMe">Lembrar na próxima vez</label>
            </div>

            <div id="btn">
                
                <input id="button" type="button" value="Login" onclick="validar()">
               
            </div>
            <a id="forgotPass" href="recuperarSenha.html">Esqueceu sua senha?</a>
        </form>
    </div>

    <script>
        var atual = "hidden"
    
        function eyeHide() {
            if(atual === "hidden"){
                var senha = document.getElementById("Senha")
                document.getElementById("allSeeingEye").src = "imagens/notHidden.png"
        
                senha.type = "text"
    
                atual = "notHidden"
            }else{
                var senha = document.getElementById("Senha")
                document.getElementById("allSeeingEye").src = "imagens/hidden.png"
        
                senha.type = "password"
    
                atual = "hidden"
            }
            
         
        }
        
        function validar() {
        	let cpf = formLogin.CPF.value;
        	let senha = formLogin.Senha.value;
        	if (cpf === "") {
        		alert("Preencha o campo cpf");
        		formLogin.CPF.focus();
        		return false
        	} else if (senha === "") {
        		alert("Preencha o campo senha");
        		formLogin.Senha.focus();
        		return false
        	} else {
        		formLogin.submit();
        	}
        }
        
        function negado(){
        	alert("Por favor, insira um CPF e senha válidos");
        	window.location.replace("Login.html");
        }
    </script>
</body>
</html>