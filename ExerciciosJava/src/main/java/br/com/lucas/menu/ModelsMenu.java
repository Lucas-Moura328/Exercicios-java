package br.com.lucas.menu;

import br.com.lucas.Menu;

public abstract class ModelsMenu extends Menu {
    private int posicao;
    public int incrementarPos(int posicao) {
        System.out.print(posicao);
        posicao = posicao + 1;
        return posicao;
    }

    public int getPosicao() {
        return posicao;
    }

    public void setPosicao(int posicao) {
        this.posicao = posicao;
    }

    public int inicializar() {
        this.posicao = 0;
        return receberInteiro("Entre com o tamanho do vetor: ");
    };
    public abstract void incluir(int posicao);
    public abstract void listar();
    public abstract void alterar();
    public abstract boolean excluir();
    public abstract void pesquisar();
    public abstract int encontrar();


}
