package br.com.lucas.menu;

import br.com.lucas.ModelsMenu;
import br.com.lucas.model.Categoria;

public class CategoriaMenu extends ModelsMenu {
    private Categoria[] categorias;

    public CategoriaMenu() {
        categorias = new Categoria[10];
        continua = true;
    }

    public void executar() {
        try {
            do {
                opcao = receberInteiro("Menu Categoria\n"
                        + "\n1-Inicializar"
                        + "\n2-Incluir"
                        + "\n3-listar"
                        + "\n4-Pesquisar"
                        + "\n5-Editar"
                        + "\n6-Excluir"
                        + "\n7-Voltar");
                switch (opcao) {
                    case 1: categorias = new Categoria[inicializar()];
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
    @Override
    public void incluir(int posicao) {
        try {
            Categoria categoria = lerCategoria();
            categorias[posicao] = categoria;
            this.setPosicao(incrementarPos(posicao));
        } catch (Exception e) {
            System.err.print(e.getMessage());
        }
    }

    private Categoria lerCategoria() {
        try {
            int id = receberInteiro("Entre com id: ");
            String nome = receberTexto("Entre com o nome da Categoria: ");
            return new Categoria(id, nome);
        }catch (Exception e) {
            return lerCategoria();
        }
    }

    public void escreverCategoria(Categoria c) {
        graph.write("ID da Cateogria: " + c.getId()
                        +"\nNome da Categoria: " + c.getNome());
    }

    @Override
    public void listar(){
        try {
            for (Categoria c: categorias) {
                if(c != null) {
                    escreverCategoria(c);
                }
            }
        } catch(Exception e) {

        }
    }
    @Override
    public void alterar(){
        int pos = encontrar();
        categorias[pos] = lerCategoria();
    }
    @Override
    public boolean excluir(int posicao){
        int resultado = encontrar();
        System.out.println("pos " + posicao);
        if(resultado >= 0) {
            for (int i = resultado; i < posicao - 1; i++) {
                categorias[i] = categorias[i + 1];
                if (i == posicao - 2) {
                    categorias[posicao - 2] = null;
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
            escreverCategoria(categorias[pos]);
        }catch (Exception e) {

        }
    }

    @Override
    public int encontrar() {
        int pos = 0;
        String criterio = receberTexto("entre com a Categoria a pesquisar: ");
        for(Categoria c: categorias) {
            if(c != null && c.getNome().equals(criterio)) {
                return pos;
            }
            pos++;
        }
        return encontrar();
    }


}
