package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Departamento;
import model.SenacDao;

/**
 *
 * @author marcos.vcrosa
 */
@WebServlet(name = "ControllerDepartamento", urlPatterns = {"/ControllerDepartamento"})
public class ControllerDepartamento extends HttpServlet {

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
        // aqui fica a programação da servlet
        String flag, nome, telefone, mensagem;
        RequestDispatcher dispatcher;
        flag = request.getParameter("flag");
        if (flag.equals("Cdep")){
            nome = request.getParameter("nome");
            telefone = request.getParameter("telefone");
            
            Departamento departamento = new Departamento();
            departamento.setNomedepartamento(nome);
            departamento.setTelefonedepartamento(telefone);
            
            SenacDao dao = new SenacDao();
            int resultado =  dao.salvarDepartamento(departamento);
            
            if(resultado==1){
                mensagem = "Departamento salvo com sucesso :)";
            }
            else{
                mensagem = "Erro ao tentar salvar o departamento :(";
            }
            request.setAttribute("mensagem", mensagem);
            dispatcher = request.getRequestDispatcher("mensagem.jsp");
            dispatcher.forward(request, response);
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
