/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Model.BancoDAO;
import Model.Produto;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author bolin
 */
@WebServlet(name = "ControllerProduto", urlPatterns = {"/ControllerProduto"})
public class ControllerProduto extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        
        String mensagem;
        
        
        
        switch(request.getParameter("flag")){
            
            case "cadastroProduto" -> {
                Produto produto = new Produto();
                produto.setProdutonome(request.getParameter("nome"));
                produto.setProdutomarca(request.getParameter("marca"));
                produto.setProdutopreco(Double.valueOf(request.getParameter("preco")));
            
                switch (new BancoDAO().cadastrar(produto)) {
                    case 1 -> mensagem = "Produto " + produto.getProdutonome() + " cadastrado com sucesso!";
                    default -> {
                        mensagem = "Algo inesperado ocorreu :(";
                        throw new AssertionError();
                    }
                }
            }
            case "listagemProduto" -> {
                List<Produto> produtos = new BancoDAO().listar(
                        "Produto.findAll", Produto.class);
                if (produtos.isEmpty()){
                    request.setAttribute("mensagem", "Nenhum produto foi cadastrado");
                    request.getRequestDispatcher("mensagem.jsp").forward(request, response);
                }
                else{
                    request.setAttribute("produtos", produtos);
                    request.getRequestDispatcher("listagem/mostrarProduto.jsp").forward(request, response);
                }
            }
            case "escolherProdutoExclusao" -> {
                String idproduto = ""+ request.getParameter("idproduto");
                Produto produto_escolhido = new BancoDAO().listarUm(Integer.valueOf(idproduto));
                produto_escolhido.getProdutonome();
                produto_escolhido.getProdutomarca();
                produto_escolhido.getProdutopreco();
            
                request.setAttribute("produto", produto_escolhido);
                request.getRequestDispatcher("excluir/mostrarProdutoUnico.jsp").forward(request, response);
            }
            
            case "excluirProduto" -> {
                Produto produto = new Produto();
                produto.setIdproduto(Integer.valueOf(request.getParameter("idproduto")));
            
                switch (new BancoDAO().deletar(produto.getIdproduto())) {
                    case 1 -> mensagem = "Produto " + produto.getProdutonome() + " deletado com sucesso!";
                    default -> {
                        mensagem = "Algo inesperado ocorreu :(";
                        throw new AssertionError();
                    }
                }
            }
                
            case "escolherProdutoEdicao" -> {
                String idproduto = ""+ request.getParameter("idproduto");
                Produto produto_escolhido = new BancoDAO().listarUm(Integer.valueOf(idproduto));
                produto_escolhido.getProdutonome();
                produto_escolhido.getProdutomarca();
                produto_escolhido.getProdutopreco();
            
                request.setAttribute("produto", produto_escolhido);
                request.getRequestDispatcher("editar/mostrarProdutoUnico.jsp").forward(request, response);
            }
            
            case "editarProduto" -> {
                Produto produto = new Produto();
                produto.setIdproduto(Integer.valueOf(request.getParameter("idproduto")));
                produto.setProdutonome(request.getParameter("produtonome"));
                produto.setProdutomarca(request.getParameter("produtomarca"));
                produto.setProdutopreco(Double.valueOf(request.getParameter("produtopreco")));
            
                switch (new BancoDAO().editar(produto.getIdproduto(), produto)) {
                    case 1 -> mensagem = "Produto " + produto.getIdproduto() + " atualizado com sucesso!";
                    default -> {
                        mensagem = "Algo inesperado ocorreu :(";
                        throw new AssertionError();
                    }
                }
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
