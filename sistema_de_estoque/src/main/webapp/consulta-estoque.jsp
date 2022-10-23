<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="model.Usuario" %>
<%@ page import="model.LoteEstoque" %>
<% 	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); %>
<%
  @ SuppressWarnings ("unchecked")
  ArrayList<LoteEstoque> lista = (ArrayList<LoteEstoque>) request.getAttribute("loteEstoque");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" type="image/x-icon" href="imagens/recanto_do_parque_logo.png">
    <link rel="stylesheet" href="./Style/style-estoque.css">
    <title>Consultar Estoque</title>
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
                <input id="perfil" src="imagens/user_icon.png" type="image">
                <div class="searchBar">
                    <input id="search" name="search" placeholder="Pesquisar" type="text">
                    <img id="searchIcon" src="imagens/search (1).png">
                </div>
            </div>
            <div class="bodyDiv"> <!--Aqui dentro é o corpo abaixo da navbar, e do lado da barra lateral-->
                
                <div id="cabeca">
                    <h3 class="style-title"><img src="./imagens/box.png">Estoque</h3>
                        <p class="filtro">Filtro <img src="./imagens/right-arrow.png"></p>
                </div>
                <div class="consulta"> 
                </div><!--consulta-->
                <div class="tl-info-prod">
                    <div id="tab-th">
                    <label style="border-right: black solid 1px; padding:0 36.5px 10px 36.5px;">Produto</label>
                    <label style="border-right: black solid 1px; padding:0 36.5px 10px 36.5px;">Código</label>
                    <label style="border-right: black solid 1px; padding:0 36.5px 10px 36.5px;">Qtd.</label>
                    <label style="border-right: black solid 1px; padding:0 30px 10px 45px;">Lote.</label>
                    <label style="padding:0 0 10px 0;">Data de Venc.</label>
                    </div>
                   <table class="style-tab">
                      <thead>
                      <tr>
                         <th></th>
                         <th></th>
                         <th></th>
                         <th></th>
                      </tr> 
                      </thead>
                      <tbody>
                      <%for (int i = 0; i < lista.size(); i++) {%>
	                      <tr>
	                         <td><%=lista.get(i).getProdutoNome() %></td>
	                         <td><%=lista.get(i).getProdutoCodigo() %></td>
	                         <td><%=lista.get(i).getQuantidade() %></td>
	                         <td><%=lista.get(i).getLoteCodigo() %></td>
	                         <td><%=sdf.format(lista.get(i).getDataVencimento()) %></td>
	                      </tr>
                      <%} %> 
                   </tbody> 
                   </table><!--style-tab-->
                </div><!--info-prod-->
            </div>
        </div>
    </div>


</body>
</html>