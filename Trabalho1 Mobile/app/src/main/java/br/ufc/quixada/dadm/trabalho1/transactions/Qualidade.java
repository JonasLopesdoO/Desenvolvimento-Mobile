package br.ufc.quixada.dadm.trabalho1.transactions;

public class Qualidade {

    private static int contadorId = 0;

    private int id;
    private String nome;
    private String descricao;

    public Qualidade(String nome, String qualidade) {
        this.id = contadorId++;
        this.nome = nome;
        this.descricao = qualidade;
    }

    public Qualidade(){ }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return nome;
    }
}
