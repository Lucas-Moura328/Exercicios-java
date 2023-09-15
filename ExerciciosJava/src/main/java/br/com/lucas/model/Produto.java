package br.com.lucas.model;

public class Produto {
    private int id;
    private String nome;
    private String descricao;
    private float preco;
    private boolean ativo;

    public Produto(int id, String nome, String descricao, float preco, boolean ativo) {
        setId(id);
        setNome(nome);
        setDescricao(descricao);
        setPreco(preco);
        setAtivo(ativo);
    }
    public Produto(String nome, String descricao, float preco, boolean ativo) {
        setNome(nome);
        setDescricao(descricao);
        setPreco(preco);
        setAtivo(ativo);
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }
}
