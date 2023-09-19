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
                    case 4: pesquisar(); break;
                    case 5: alterar(); break;
                    case 6: excluir(getPosicao()); break;
                    case 7: continua = false; break;
                    default: executar(); break;

                }
            }while (continua);
        } catch(Exception e2) {

        }
    }
    public Produto lerProduto() {
        try {
            int id = receberInteiro("Entre com id: ");
            String nome = receberTexto("Entre com o nome do produto");
            String descricao = receberTexto("Entre com a descrição do produto");
            float preco = receberFloat("Entre com o preco");
            boolean ativo = true;
            return new Produto(id, nome, descricao, preco, ativo);
        } catch (Exception e) {

        }
        return null;
    }

   @Override
    public void incluir(int posicao) {
        try {
            Produto produto = lerProduto();
            produtos[posicao] = produto;
             this.setPosicao(incrementarPos(posicao));
        } catch (Exception e) {
            System.err.print(e.getMessage());
        }
    }

    public void writeProduto(Produto p) {
        graph.write("ID: " + p.getId()
                + "\nNome do produto: " + p.getNome()
                + "\nDescrição: " + p.getDescricao()
                + "\nPreço: " + p.getPreco());
    }
    @Override
    public void listar(){
        try {
            for (Produto p: produtos) {
                if(p != null) {
                    writeProduto(p);
                }
            }
        } catch(Exception e) {

        }
    }
    @Override
    public void alterar(){
        int pos = encontrar();
        produtos[pos] = lerProduto();
    }
    @Override
    public boolean excluir(int posicao) {
        int resultado = encontrar();
        System.out.println("pos " + posicao);
        if(resultado >= 0) {
            for (int i = resultado; i < posicao - 1; i++) {
                produtos[i] = produtos[i + 1];
                if (i == posicao - 2) {
                    produtos[posicao - 2] = null;

                }

            }

            escrever("O item foi excluído!");
            return true;
        } else {
            escrever("Nada encontrado!");
            return false;
        }

    }



    public void pesquisar(){
        try {
            int pos = encontrar();
            writeProduto(produtos[pos]);
        }catch (Exception e) {

        }
    }

    @Override
    public int encontrar() {
        int pos = 0;
        String criterio = receberTexto("entre com o Produto a pesquisar: ");
        for(Produto p: produtos) {
            if(p != null && p.getNome().equals(criterio)) {
                return pos;
            }
            pos++;
        }
        return -1;
    }


}
