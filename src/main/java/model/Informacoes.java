package model;

public class Informacoes {

    private String nome; 
    private String descricao;
    private String data;
    private String hora; 
    
    public Informacoes() {
        this.nome = "";
        this.descricao = "";
        this.data = "";
        this.hora = "";
    }
    
    public Informacoes(String nome, String descricao, String data, String hora) {
        this.nome = nome;
        this.descricao = descricao;
        this.data = data;
        this.hora = hora;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Evento [nome=" + nome + ", descrição=" + descricao + ", data=" + data + ", hora=" + hora + "]";
    }   
}