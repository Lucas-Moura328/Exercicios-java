package br.com.lucas.model;

public class Usuario {
    private int id;
    private String nome;
    private int cpf;
    private String email;

    public Usuario(int id, String nome, int cpf, String email) {
        setId(id);
        setCpf(cpf);
        setNome(nome);
        setEmail(email);
    }
    public Usuario(String nome, int cpf, String email) {
        setCpf(cpf);
        setNome(nome);
        setEmail(email);
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

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
