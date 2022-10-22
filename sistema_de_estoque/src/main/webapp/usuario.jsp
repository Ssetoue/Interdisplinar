<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="model.Usuario"%>
<%
  @ SuppressWarnings ("unchecked")
  ArrayList<Usuario> lista = (ArrayList<Usuario>) request.getAttribute("usuarios");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon"  type="image/x-icon" href="imagens/recanto_do_parque_logo.png">
    <link rel="stylesheet" href="./Style/usuario.css">
    <title>Usuário</title>
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
                <a href="cadastroUsuario.jsp">
                <button class="cadastrar_usuario">
                    <p id="cadastrar_usuario_title">Cadastrar Usuário</p>
                </button>
                </a>

                <a href="Atual-usuario.html"><button class="atualizar_informacao">
                    <p id="atualizar_informacao_title">Atualizar Informação</p>
                </button></a>

                <div class="usuario_cadastro_div">
                    <div id="usuario_cadastro_title">
                        <p id="usuario_cadastro_text">Usuários Cadastrados</p>
                    </div>

                    <table class="table_usuario">
                        <thead>
                            <tr id="usuario_title">
                                <th id="usuario_nome"><label>Nome</label></th>
                                <th id="usuario_cpf"><label>CPF</label></th>
                            </tr>
                        </thead>
                        <tbody>
                        	<%for (int i = 0; i < lista.size(); i++){ %>            
                            <tr class="field_usuario">
                                <td class="field_nome"><label></label><%=lista.get(i).getNome() %></td>
                                <td class="field_cpf"><label></label><%=lista.get(i).getCpf() %></td>
                            </tr>
                            <%} %>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>


</body>
</html>