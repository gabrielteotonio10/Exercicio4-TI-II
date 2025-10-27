package app;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Informacoes;
import service.EventoService;

@WebServlet("/inserirEvento")
public class InserirEventoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nome = request.getParameter("nome");
        String descricao = request.getParameter("descricao");
        String data = request.getParameter("data");
        String hora = request.getParameter("hora");

        Informacoes info = new Informacoes(nome, descricao, data, hora);

        EventoService service = new EventoService();

        try {
            boolean inserido = service.inserirEvento(info);
            response.setContentType("text/html; charset=UTF-8");

            if (inserido) {
                response.getWriter().println("<p>✅ Evento inserido com sucesso!</p>");
            } else {
                response.getWriter().println("<p>❌ Erro ao inserir evento.</p>");
            }
        } catch (IllegalArgumentException e) {
            response.setContentType("text/html; charset=UTF-8");
            response.getWriter().println("<p>⚠️ Erro: " + e.getMessage() + "</p>");
        } catch (Exception e) {
            response.setContentType("text/html; charset=UTF-8");
            response.getWriter().println("<p>❌ Ocorreu um erro inesperado: " + e.getMessage() + "</p>");
        }
    }
}
