<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" type="imagens/x-icon" href="imagens/recanto_do_parque_logo.png">
    <link rel="stylesheet" href="Style/atual-estoque.css">
    <title>Cadastro Produto</title>
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

            <div class="bodyDiv"> <!--Aqui dentro é o corpo abaixo da navbar, e do lado da barra lateral-->
                <main class="main">
                    <div class="cima">
                        <h2>Atualizar Estoque</h2>
                        <div class="dt-atual">
                        <p>Data de Atualização:</p>
                    <input id="data-de-atualizar" name="data" type="date">
                    </div><!--dt-atual-->
                    </div><!--cima--> 
                    <form action="atualizarEstoque" name="atualizarEstoque">
                        <div class="divCadastro">
                        </div>
                        <div class="nome-produto">
                            <input id="n-prod" name="NomeProd" type="text">
                            <p id="nome-prod">Nome de produto</p>
                        </div>
                        <div class="code_produto">
                            <input id="code_produto_text" name="CodigoProduto" type="number">
                            <p id="code_produto_title">Código de produto</p>
                        </div>
                        <div class="code_lote">
                            <input id="code_lote_text" name="CodigoLote" type="number">
                            <p id="code_lote_title">Código de lote</p>
                        </div>
                        <div class="valor_unid">
                            <input id="valor_unid_text" name="Valor" type="number">
                            <p id="valor_unid_title">Valor (unid)</p>
                        </div>
                        <div class="quantidade">
                            <input id="quantidade_text" name="Quantidade" type="number">
                            <p id="quantidade_title">Quantidade Saida</p>
                        </div>
                        <div class="info-estoque">
                            <p id="informaçoes_produto1_text"> Produto Codigo Quantidade Valor Total Lote Data</p>
                            <input id="informaçoes_produto2_text" name="inf_2" type="text">
                            <input id="informaçoes_produto3_text" name="inf_3" type="text">
                            <input id="informaçoes_produto4_text" name="inf_" type="text">
                            <p id="atual-info-mes">Atualizações do Mês<br> (01/01 - 31/01)</p>
                            <p id="informaçoes_produto_title">Informações do Estoque</p>
                            <p id="informaçoes_produto_title2">Saídas do Estoque:</p>
                        </div>
                        <div class="cancelar_atualizar">
                            <a href="estoque.jsp"><input id="cancelar_atual_button" name="cancelar_atualiar" type="button" value="Cancelar"></a>
                        </div>
                        <div class="atualizar-estoque">
                            <input id="atual-estoque" name="atualizar-estoque" value="Atualizar" type="button" onclick="validar()">
                        </div>
                     
                     </form>
                </main>

            </div>
        </div>
    </div>
<script>
function validar() {
	let nomeProd = atualizarEstoque.NomeProd.value;
	let valor = atualizarEstoque.Valor.value;
	let codigoLote = atualizarEstoque.CodigoLote.value;
	let quantidade = atualizarEstoque.Quantidade.value;
	if (nomeProd === "") {
		alert("Preencha o campo Nome do Produto");
		atualizarEstoque.NomeProd.focus();
		return false
	} else if (valor === "") {
		alert("Preencha o campo Valor");
		atualizarEstoque.Valor.focus();
		return false
	} else if (codigoLote === "") {
		alert("Preencha o campo Código do Lote");
		atualizarEstoque.CodigoLote.focus();
		return false
	} else if (quantidade === "") {
		alert("Preencha o campo Quantidade");
		atualizarEstoque.Quantidade.focus();
		return false
	} else {
		atualizarEstoque.submit();
	}
}
</script>

</body>
</html>