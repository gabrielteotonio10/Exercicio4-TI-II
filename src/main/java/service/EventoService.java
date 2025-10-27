package service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import dao.InformacoesDAO;
import model.Informacoes;

public class EventoService {

    private InformacoesDAO dao;

    public EventoService() {
        dao = new InformacoesDAO();
    }

    public boolean inserirEvento(Informacoes info) {
        if (info.getNome() == null || info.getNome().trim().isEmpty()) {
            throw new IllegalArgumentException("O nome do evento não pode ser vazio.");
        }

        if (info.getData() == null || info.getData().trim().isEmpty()) {
            throw new IllegalArgumentException("A data do evento é obrigatória.");
        }

        LocalDate dataEvento;
        try {
            dataEvento = LocalDate.parse(info.getData(), DateTimeFormatter.ISO_LOCAL_DATE);
        } catch (Exception e) {
            throw new IllegalArgumentException("Formato de data inválido. Use yyyy-MM-dd.");
        }

        if (dataEvento.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("A data do evento não pode ser anterior à data atual.");
        }

        return dao.insert(info);
    }
}
