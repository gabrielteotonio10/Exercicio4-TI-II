package app;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson; // Você precisará da dependência Gson no seu pom.xml

import dao.InformacoesDAO;
import model.Informacoes;

@WebServlet("/listarEventos")
public class ListarEventosServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        InformacoesDAO dao = new InformacoesDAO();
        List<Informacoes> eventos = dao.getAll();

        Gson gson = new Gson();
        String json = gson.toJson(eventos);

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);
    }
}