<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Produto" %>
<%@ page import="model.Usuario" %>
<%@ page import="java.util.ArrayList" %>
<%--
  @ SuppressWarnings ("unchecked")
  ArrayList<Produto> lista = (ArrayList<Produto>) request.getAttribute("produtosVencendo");
--%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" type="image/x-icon" href="./imagens/recanto_do_parque_logo.png">
    <link rel="stylesheet" href="./Style/Home.css">
    <title>Home</title>
</head>
<body>
    <div class="principal"> <!--Corpo principal-->
        <div class="lateralBar"> <!-- Barra lateral esquerda-->
            <img id="logo" src="imagens/recanto_do_parque_logo.png">
            <div id="linha_vertical"></div> <!--Linha verde-->

            <a href="Home.jsp">
                <button id="home" type="submit">
                    <p id="homeButton">Home</p>
                    <img id="homeImg" src="imagens/home.png">
            
                </button>
            </a>
			<%if (Usuario.getAcesso().equals("Administracao")) {%>
            <a href="cadastro.html">
                <button id="cadastrar" type="submit">
                    <p id="cadastrarButton">Cadastrar</p>
                    <img id="cadastrarImg" src="imagens/cadastro.png">
                </button>
            </a>
            <%} %>
            <a href="estoque.jsp">
                <button id="estoque" type="submit">
                    <p id="estoqueButton">Estoque</p>
                    <img id="estoqueImg" src="imagens/in-stock.png">
                </button>   
            </a>
			<%if (Usuario.getAcesso().equals("Administracao")) {%>
            <a href="usuario">
                <button id="informacao" type="submit">
                    <p id="informacaoButton">Usuário</p>
                    <img id="informacaoImg" src="imagens/boxes.png">
                </button>
            </a>
            <%} %>
        </div> <!--Termino da barra lateral esquerda-->

        <div class="body"> <!-- toda parte direita-->
            <div class="navbar"> <!-- a barra de navegação-->
                <input id="engrenagem" src="imagens/settings.png" type="image">
                <a href="sair">
                    <button>Sair do Sistema</button>
                    </a>
                <input id="perfil" src="imagens/user_icon.png" type="image">
                
                <div class="searchBar">
                    <input id="search" name="search" placeholder="Pesquisar" type="text">
                    <img id="searchIcon" src="imagens/search (1).png">
                </div>
            </div>

            <div class="bodyDiv"> <!--Aqui dentro é o corpo abaixo da navbar, e do lado da barra lateral-->
                <h2 class="bem-vindo">Bem-Vindo</h2>
                <div class="notes-info">
                    <h3>Produtos Perto de Vencer</h3>
                    <table>
                        <thead>
                            <tr>
                                <th>Código</th>
                                <th>Nome</th>
                                <th>Código do Lote</th>
                            </tr>
                        </thead>
                        <tbody>
                        	<%--for (int i = 0; i < lista.size(); i++) {--%>
	                            <tr>
	                                <td>00</td>
	                                <td>Produto</td>
	                                <td>00</td>
	                            </tr>
	                    	<%--} --%>
                        </tbody>
                    </table>
                </div>
                <%if (Usuario.getAcesso().equals("Administracao")) {%>
                <a href="Cadastrar-Fornecedor.jsp">
                    <button class="cad-func">Cadastrar Fornecedor</button>
                </a>
				<%} %>
            </div>
        </div>
    </div>


</body>
</html>