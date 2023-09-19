package br.com.lucas.menu;

import br.com.lucas.ModelsMenu;
import br.com.lucas.model.Venda;

public class VendaMenu extends ModelsMenu {
    private Venda[] vendas;

    public VendaMenu() {
        vendas = new Venda[10];
        continua = true;
    }
    public void executar() {
        try {
            do {
                opcao = receberInteiro("Menu Venda\n"
                        + "\n1-Inicializar"
                        + "\n2-Incluir"
                        + "\n3-listar"
                        + "\n4-Pesquisar"
                        + "\n5-Editar"
                        + "\n6-Excluir"
                        + "\n7-Voltar");
                switch (opcao) {
                    case 1: vendas = new Venda[inicializar()];
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


    public void incluir(int posicao) {
        try {
            Venda venda = lerVenda();
            vendas[posicao] = venda;
            this.setPosicao(incrementarPos(posicao));
        } catch (Exception e) {
            System.err.print(e.getMessage());
        }
    }

    private Venda lerVenda() {
        try {
            int id = receberInteiro("Entre com o ID: ");
            int quantidade = receberInteiro("Entre com o Quantidade Vendidos: ");
            String descricao = receberTexto("Entre com a descrição da venda: ");
            return new Venda(id, quantidade, descricao);
        } catch (Exception e) {
            return lerVenda();
        }
    }

    public void escreverVenda(Venda v) {
        graph.write("ID da Venda: " + v.getId() + "\nDescrição da Venda: " + v.getDescricao() + "\nQuantidade da Venda: " + v.getQuantidade());
    }

    @Override
    public void listar() {
        try {
            for (Venda v : vendas) {
                if (v != null) {
                    escreverVenda(v);
                }
            }
        } catch (Exception e) {

        }
    }

    @Override
    public void alterar() {
        int pos = encontrar();
        vendas[pos] = lerVenda();
    }

    @Override
    public boolean excluir(int posicao) {
        int resultado = encontrar();
        System.out.println("pos " + posicao);
        if (resultado >= 0) {
            for (int i = resultado; i < posicao - 1; i++) {
                vendas[i] = vendas[i + 1];
                if (i == posicao - 2) {
                    vendas[posicao - 2] = null;
                }
            }
            escrever("O item foi excluído!");
            return true;
        } else {
            escrever("Nada encontrado!");
            return false;
        }
    }

    public void pesquisar() {
        try {
            int pos = encontrar();
            escreverVenda(vendas[pos]);
        } catch (Exception e) {

        }
    }

    @Override
    public int encontrar() {
        int pos = 0;
        try {
            int criterio = receberInteiro("Entre com o ID da Venda a pesquisar: ");
            for (Venda v : vendas) {
                if (v != null && v.getId() == criterio) {
                    return pos;
                }
                pos++;
            }

        } catch (Exception e) {

        }
        return encontrar();
    }

}
