package br.com.lucas.menu;

import br.com.lucas.ModelsMenu;
import br.com.lucas.model.Produto;

public class ProdutoMenu extends ModelsMenu {
    private Produto[] produtos;

    public ProdutoMenu() {
        produtos = new Produto[10];
        continua = true;
    }

    public void executar() {
        try {
            do {
                opcao = receberInteiro("Menu Produto\n"
                        + "\n1-Inicializar"
                        + "\n2-Incluir"
                        + "\n3-listar"
                        + "\n4-Pesquisar"
                        + "\n5-Editar"
                        + "\n6-Excluir"
                        + "\n7-Voltar");
                switch (opcao) {
                    case 1: produtos = new Produto[inicializar()];
                    System.out.println("Inicializou"); break;
                    case 2: incluir(getPosicao()); break;
                    case 3: listar(); break;
                    case 7: continua = false; break;

                }
            }while (continua);
        } catch(Exception e2) {

        }
    }


   @Override
    public void incluir(int posicao) {
        try {
            int id = receberInteiro("Entre com id: ");
            String nome = receberTexto("Entre com o nome do produto");
            String descricao = receberTexto("Entre com a descrição do produto");
            float preco = receberFloat("Entre com o preco");
            boolean ativo = true;

            Produto produto = new Produto(id, nome, descricao, preco, ativo);
            produtos[posicao] = produto;
             this.setPosicao(incrementarPos(posicao));
        } catch (Exception e) {
            System.err.print(e.getMessage());
        }
    }
    @Override
    public void listar(){
        try {
            for (Produto p: produtos) {
                if(p != null) {
                    graph.write("ID: " + p.getId()
                            + "\nNome do produto: " + p.getNome()
                            + "\nDescrição: " + p.getDescricao()
                            + "\nPreço: " + p.getPreco());
                }
            }
        } catch(Exception e) {

        }
    }
    @Override
    public void alterar(){

    }
    @Override
    public boolean excluir(){
        return false;
    }
    public void pesquisar(){

    }

    @Override
    public int encontrar() {
        return 0;
    }


}
