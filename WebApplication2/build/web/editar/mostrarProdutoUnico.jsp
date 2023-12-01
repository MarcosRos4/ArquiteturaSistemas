<%-- 
    Document   : mostrarProdutoUnico
    Created on : 1 de dez. de 2023, 00:40:53
    Author     : bolin
--%>

<%@page import="Model.Produto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <%
        Produto produto = (Produto) request.getAttribute("produto");
    %>
    <div>
        <h1>EDIÇÃO DE PRODUTO</h1>
        <form method="post" action="ControllerProduto">
            <input type="hidden" name="flag" value="editarProduto" >
            <p>
                <label>Id do Produto</label>
                <input readonly type="number" name="idproduto" value="<%= produto.getIdproduto() %>">
            </p>
            <p>
                <label>Nome: </label>
                <input type="text" name="produtonome" value="<%= produto.getProdutonome() %>">
            </p>
            <p>
                <label>Marca: </label>
                <input type="text" name="produtomarca" value="<%= produto.getProdutomarca() %>">
            </p>
            <p>
                <label>Preço: </label>
                <input type="number" name="produtopreco" value="<%= produto.getProdutopreco() %>">
            </p>
            <input type="submit" name="excluir" value="Salvar Alterações" onclick="return confirmacaoAlteracoes();">
        </form>
        <script>
            function confirmacaoAlteracoes() {
                return confirm('Tem certeza que deseja salvar as alterações?');
            }
        </script>
    </div>
</body>
</html>
