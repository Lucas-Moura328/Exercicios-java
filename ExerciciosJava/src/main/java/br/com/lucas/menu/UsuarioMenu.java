package br.com.lucas.menu;

import br.com.lucas.ModelsMenu;
import br.com.lucas.model.Usuario;

public class UsuarioMenu extends ModelsMenu {

    private Usuario[] usuarios;

    public UsuarioMenu() {
        usuarios = new Usuario[10];
        continua = true;
    }

    public void executar() {
        try {
            do {
                opcao = receberInteiro("Menu Usuario\n"
                        + "\n1-Inicializar"
                        + "\n2-Incluir"
                        + "\n3-listar"
                        + "\n4-Pesquisar"
                        + "\n5-Editar"
                        + "\n6-Excluir"
                        + "\n7-Voltar");
                switch (opcao) {
                    case 1: usuarios = new Usuario[inicializar()];
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

    public Usuario lerUsuario() {
        try {
            int id = receberInteiro("Entre com o id do usuario: ");
            int cpf = receberInteiro("Entre com o CPF do Usuario: ");
            String nome = receberTexto("Entre com o nome do usuario: ");
            String email = receberTexto("Entre com E-mail: ");
            return new Usuario(id, nome, cpf, email);
        }catch (Exception e) {
            return lerUsuario();
        }

    }
    public void escreverUsuario(Usuario u) {
        graph.write("Id: " + u.getId()
        + "\nNome do Usuário: " + u.getNome()
        + "\nCPF: " + u.getCpf()
        + "\nE-mail: " + u.getEmail());
    }

    @Override
    public void incluir(int posicao) {
        try {
            Usuario usuario = lerUsuario();
            usuarios[posicao] = usuario;
            this.setPosicao(incrementarPos(posicao));
        } catch (Exception e) {
            System.err.print(e.getMessage());
        }
    }
    @Override
    public void listar(){
        try {
            for(Usuario u: usuarios) {
                if(u != null) {
                    escreverUsuario(u);
                }
            }
        } catch (Exception e) {

        }

    }
    @Override
    public void alterar(){
        int pos = encontrar();
        usuarios[pos] = lerUsuario();
    }
    @Override
    public boolean excluir(int posicao){
        int resultado = encontrar();
        System.out.println("pos " + posicao);
        if(resultado >= 0) {
            for (int i = resultado; i < posicao - 1; i++) {
                usuarios[i] = usuarios[i + 1];
                if (i == posicao - 2) {
                    usuarios[posicao - 2] = null;

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
            escreverUsuario(usuarios[pos]);
        }catch (Exception e) {

        }
    }

    @Override
    public int encontrar() {
        int pos = 0;
        String criterio = receberTexto("entre com o Usuario a pesquisar: ");
        for(Usuario u: usuarios) {
            if(u != null && u.getNome().equals(criterio)) {
                return pos;
            }
            pos++;
        }
        return encontrar();
    }

}
