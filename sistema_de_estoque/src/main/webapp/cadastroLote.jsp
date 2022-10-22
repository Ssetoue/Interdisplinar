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
    <link rel="stylesheet" href="Style/cadastroLote.css">
    <title>Cadastrar Lote</title>
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
                <form name="novoLote" action="novoLote">

                    <div class="divCadastro">
                        <div id="cadastroUsuario">
                            <p id="cadastro_placeholder_user">Cadastrar Lote</p>
                            <p id="cadastro_placeholder_dataCreation">Data de Cadastro:</p>
                            <p id="cadastro_placeholder_data"><%=dtf.format(now)%></p>
                        </div>
                    </div>
    
                    <div class="code_lote">
                        <input id="code_lote_text" name="CodLote" type="number">
                        <p id="code_lote_title">Código de lote</p>
                    </div>
    
                    <div class="fornecedor">
                        <input id="fornecedor_text" name="NomeProd" type="text">
                        <p id="fornecedor_title">Nome do produto</p>
                    </div>
    
                    <div class="data_chegada">
                        <input id="data_chegada_text" name="DataChegada" type="date">
                        <p id="data_chegada_title">Data de chegada</p>
                    </div>
                    
                    <div class="data_fabricacao">
                        <input id="data_fabricacao_text" name="DataFabricacao" type="date">
                        <p id="data_fabricacao_title">Data de fabricação</p>
                    </div>

                    <div class="valor_lote">
                        <input id="valor_lote_text" name="Valor" type="number">
                        <p id="valor_lote_title">Valor (lote)</p>
                    </div>

                    <div class="code_produto">
                        <input id="code_produto_text" name="NomeForn">
                        <p id="code_produto_title">Nome do Fornecedor</p>
                    </div>

                    <div class="quantidade">
                        <input id="quantidade_text" name="Quantidade" type="number">
                        <p id="quantidade_title">Quantidade</p>
                    </div>

                    <div class="data_vencimento">
                        <input id="data_vencimento_text" name="DataVencimento" type="date">
                        <p id="data_vencimento_title">Data de Vencimento</p>
                    </div>
    
                    <div class="informaçoes_produto">
                        <input id="informaçoes_produto1_text" name="inf_1" type="text">
                        <input id="informaçoes_produto2_text" name="inf_2" type="text">
                        <input id="informaçoes_produto3_text" name="inf_3" type="text">
                        <p id="informaçoes_produto_title">Informações do Produto</p>
                        <p id="informaçoes_produto_title2">Produtos Constado no Lote:</p>
                    </div>
    
                    <div class="cancelar_cadastro">
                        <a href="cadastro.html"><input id="cancelar_cadastro_button" name="cancelar_cadastro" type="button" value="Cancelar"></a>
                    </div>
    
                    <div class="confirmar_cadastro">
                        <input id="confirmar_cadastro_button" name="confirmar_cadastrar" type="button" onclick="validar()" value="Cadastrar">
                    </div>

                </form>
            </div>
        </div>
    </div>
<script>
function validar() {
	let nomeProd = novoLote.NomeProd.value;
	let dataFabricacao = novoLote.DataFabricacao.value;
	let valor = novoLote.Valor.value;
	let nomeForn = novoLote.NomeForn.value;
	let quantidade = novoLote.Quantidade.value;
	let dataVencimento = novoLote.DataVencimento.value;
	if (nomeProd === "") {
		alert("Preencha o campo Nome do Produto");
		novoLote.NomeProd.focus();
		return false
	} else if (dataFabricacao === "") {
		alert("Preencha o campo Data de Fabricação");
		novoLote.DataFabricacao.focus();
		return false
	} else if (valor === "") {
		alert("Preencha o campo Valor");
		novoLote.Valor.focus();
		return false
	} else if (nomeForn === "") {
		alert("Preencha o campo Nome do Fornecedor");
		novoLote.NomeForn.focus();
		return false
	} else if (quantidade === "") {
		alert("Preencha o campo Quantidade");
		novoLote.Quantidade.focus();
		return false
	} else if (dataVencimento === "") {
		alert("Preencha o campo Data de Vencimento");
		novoLote.DataVencimento.focus();
		return false
	} else {
		novoLote.submit();
	}
}
</script>

</body>
</html>