package br.com.eniac.gestaoativosti.model;

public class Ativo {
    private int id;
    private String nome;
    private String tipo;
    private String dataAquisicao;
    private double valor;
    private String status;

    public Ativo() {
    }

    public Ativo(int id, String nome, String tipo, String dataAquisicao, double valor, String status) {
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
        this.dataAquisicao = dataAquisicao;
        this.valor = valor;
        this.status = status;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public String getDataAquisicao() { return dataAquisicao; }
    public void setDataAquisicao(String dataAquisicao) { this.dataAquisicao = dataAquisicao; }

    public double getValor() { return valor; }
    public void setValor(double valor) { this.valor = valor; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}