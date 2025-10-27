package app;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.InformacoesDAO;

@WebServlet("/excluirEvento")
public class ExcluirEventoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String dataExclusao = request.getParameter("data");
        String nomeExclusao = request.getParameter("nome");

        InformacoesDAO dao = new InformacoesDAO();
        boolean deletado = dao.delete(dataExclusao, nomeExclusao);

        if (deletado) {
            response.sendRedirect("index.html?status=sucesso&acao=deletar");
        } else {
            response.sendRedirect("index.html?status=erro&acao=deletar");
        }
    }
}