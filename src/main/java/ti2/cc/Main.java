package ti2.cc;

import static spark.Spark.*;

public class Main {
    public static void main(String[] args) {
        // Configura a porta (opcional)
        port(4567);

        // Exemplo de rota
        get("/", (req, res) -> "Servidor rodando!");
    }
}

