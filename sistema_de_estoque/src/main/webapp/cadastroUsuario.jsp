<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.time.format.DateTimeFormatter" %>
<%@ page import="java.time.LocalDateTime" %>
<%   DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");  
	 LocalDateTime now = LocalDateTime.now();  %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" type="image/x-icon" href="./imagens/recanto_do_parque_logo.png">
    <link rel="stylesheet" href="./Style/cadastroUsuario.css">
    <title>Cadastro Usuário</title>
</head>
<body>
    <div class="principal"> <!--Corpo principal-->
        <div class="lateralBar"> <!-- Barra lateral esquerda-->
            <img id="logo" src="imagens/recanto_do_parque_logo.png">
            <div id="linha_vertical"></div> <!--Linha verde-->

            <a href="home">
                <button id="home" type="submit">
                
                    <p id="homeButton">Home</p>
                
                    <img id="homeImg" src="imagens/home.png">
            
                </button>
            </a>

            <a href="cadastro.html">
                <button id="cadastrar" type="submit">
                    <p id="cadastrarButton">Cadastrar</p>
                    <img id="cadastrarImg" src="imagens/cadastro.png">
                </button>
            </a>

            <a href="estoque.jsp">
                <button id="estoque" type="submit">
                    <p id="estoqueButton">Estoque</p>
                    <img id="estoqueImg" src="imagens/in-stock.png">
                </button>   
            </a>

            <a href="usuario">
                <button id="informacao" type="submit">
                    <p id="informacaoButton">Usuário</p>
                    <img id="informacaoImg" src="imagens/boxes.png">
                </button>
            </a>

        </div> <!--Termino da barra lateral esquerda-->

        <div class="body"> <!-- toda parte direita-->
            <div class="navbar"> <!-- a barra de navegação-->
                <input id="engrenagem" src="imagens/settings.png" type="image">
                <input id="perfil" src="imagens/user_icon.png" type="image">
                
                <div class="searchBar">
                    <input id="search" name="search" placeholder="Pesquisar" type="text">
                    <img id="searchIcon" src="imagens/search (1).png">
                </div>
            </div>

            <div class="bodyDiv">
                <div class="divCadastro">
                    <div id="cadastroUsuario" name="cadastrar" type="text">
                        <p id="cadastro_placeholder_user">Cadastrar Usuário</p>
                        <p id="cadastro_placeholder_dataCreation">Data de Cadastro:</p>
                        <p id="cadastro_placeholder_data"><%=dtf.format(now) %></p>
                    </div>
                </div>

            <form id="document" action="novoUsuario" name="document">
                 <div class="msg"></div>
                <div class="nomeCompleto">
                    <input id="nome_completo_text" name="nomeCompleto" type="text">
                    <p id="nome_completo_title">Nome Completo</p>
                   
                    
                </div>
                  
                <div class="msg"></div>
                <div class="CPF">
                    <input id="CPF_text" name="CPF" type="text">
                    <p id="CPF_title">CPF</p>
                    
                </div>

                <div class="senha">
                    <input id="senha_text" name="senha_text" type="password">
                    <p id="senha_title">Senha</p>
                    
                </div>

                <div class="funButton">
                    <label><input id="funcionario" type="radio" name="usuario" value="funcionario" checked>Funcionário></label>
                </div>

                <div class="admButton">
                    <label><input id="administrador" type="radio" name="usuario" value="administrador">Administrador</label>
                </div>

                <div class="cancelar_cadastro">
                    <a href="usuario"><input id="cancelar_cadastro_button" type="button" value="Cancelar" name="cancelar_cadastro"></a>
                </div>

                <div class="confirmar_cadastro">
                    <input id="confirmar_cadastro_button" name="confirmar_cadastrar" value="Cadastrar" type="submit" onclick="validar()">
                </div>
			</form>
            </div>
        </div>
    </div>

<script> //Aqui começa a parte da validação dos campos da tela de cadastro de usuário//
    
function validar() {
	let nome = document.nomeCompleto.value;
	let cpf = document.CPF.value;
	let senha = document.senha_text.value;
	if (nome === "") {
		alert("Preencha o campo nome");
		document.nomeCompleto.focus();
		return false;
	} else if (cpf === "") {
		alert("Preencha o campo cpf");
		document.CPF.focus();
		return false;
	} else if (senha === ""){
		alert("Preencha o campo senha");
		document.senha_text.focus();
		return false;
	} else {
		document.submit();
	}
}
</script>

</body>
</html>