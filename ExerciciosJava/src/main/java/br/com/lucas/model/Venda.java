package br.com.lucas.model;

public class Venda {
    private int id;
    private int quantidade;
    private String descricao;

    public Venda(int id, int quantidade, String descricao) {
        setId(id);
        setQuantidade(quantidade);
        setDescricao(descricao);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
