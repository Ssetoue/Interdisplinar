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
    <link rel="icon"  type="image/x-icon" href="imagens/recanto_do_parque_logo.png">
    <link rel="stylesheet" href="./Style/Cad-fornecedor.css">
    <title>Cadastrar Fornecedor</title>
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
                <form name="novoFornecedor" action="novoFornecedor">

                    <div class="divCadastro">
                        <div id="cadastroUsuario">
                            <p id="cadastro_placeholder_user">Cadastrar Fornecedor</p>
                            <p id="cadastro_placeholder_dataCreation">Data de Cadastro:</p>
                            <p id="cadastro_placeholder_data"><%=dtf.format(now) %></p>
                        </div>
                    </div>
    
                    <div class="msg"></div>
                    <div class="code_produto">
                        <label id="code_produto_text"></label>
                        <p id="code_produto_title">Código do Fornecedor</p>
                    </div>
                    <div class="nome_produto">
                        <input id="nome_produto_text" name="Nome" type="text">
                        <p id="nome_produto_title">Nome de Fornecedor</p>
                    </div>
    
                    <div class="valor_produto">
                        <input id="valor_produto_text" name="Contato" type="number">
                        <p id="valor_produto_title">Contato</p>
                    </div>
                    
                    <div class="Produto">
                        <input id="n-prod" name="Produto-nome" type="text">
                        <p id="title-produto">Nome do Produto</p>
                    </div>
                    <p id="title-c-produto">Código do Produto</p>
                    <div class="cod_produto">
                     <input type="submit" name="adicionar" value="Adicionar" id="add-btn">
                 </div>
       
                       <div class="informaçoes_produto">
                           <p id="informaçoes_produto1_text"></p>
                           <p id="informaçoes_produto2_text"></p>
                           <p id="informaçoes_produto3_text"></p>
                           <p id="informaçoes_produto4_text"></p>
                           <p id="informaçoes_produto_title">Produtos do Fornecedor</p>
                       </div>
       

                    <div class="cancelar_cadastro">
                        <a href="home">
                        	<input id="cancelar_cadastro_button" type="button" name="cancelar_cadastro" value="Cancelar">
                        </a>
                    </div>
    
                    <div class="confirmar_cadastro">
                        <input id="confirmar_cadastro_button" type="button" name="confirmar_cadastrar" onclick="validar()" value="Cadastrar">
                     </div>

                </form>
            </div>
        </div>
    </div>

<script>
function validar() {
	let nome = novoFornecedor.Nome.value;
	let contato = novoFornecedor.Contato.value;
	if (nome === "") {
		alert("Preencha o campo nome");
		novoFornecedor.Nome.focus();
		return false
	} else if (contato === "") {
		alert("Preencha o campo contato");
		novoFornecedor.Contato.focus();
		return false
	} else {
		novoFornecedor.submit();
	}
}
</script>
</body>
</html>