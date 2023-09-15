package br.com.lucas;

import java.util.Scanner;

public class Produto {
    private InterfaceGraph graph;
    public int id;
    public String nome;
    public float preco;

    public Produto() throws Exception {
        try {
            graph = new InterfaceGraph();
            //System.out.println("lançou:");
        } catch (Throwable e) {
            throw e;
        }
    }

    public float getDollar() {
        return preco / 4;
    }

    public void writeProduto() throws Exception {
        try {
            graph.write("id:  " + id + "\n Produto: " + nome + "\nPreço: " + preco + "\nPreço em Dólar: " + getDollar());
        } catch (Exception e) {
            throw e;
        }

    }

    void read() throws Exception {
        try {
            id = graph.readInt("ID:");
            nome = graph.readText("Nome");
            preco = graph.readFloat("preco");

        } catch (Exception e) {
            throw e;
        }
    }
}
