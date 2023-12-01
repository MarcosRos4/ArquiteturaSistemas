<%-- 
    Document   : mostrarProduto
    Created on : 19 de out. de 2023, 22:12:14
    Author     : bolin
--%>

<%@page import="java.util.List"%>
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
            List<Produto> produtos = (List<Produto>) request.getAttribute("produtos");
        %>
        <table>
            <tr>
                <th> ID </th>
                <th> Nome </th>   
                <th> Marca </th>
                <th> Preco </th>
            </tr>
            <%
                for (Produto pro : produtos) {
            %>   
            <tr>
                <td> <%= pro.getIdproduto() %> </td>
                <td> <%= pro.getProdutonome() %> </td>
                <td> <%= pro.getProdutomarca() %> </td>
                <td> <%= pro.getProdutopreco() %> </td> 
            </tr>    
            <%
                }
            %> 
    </body>
</html>
