package br.com.lucas;

import java.util.Scanner;

public class Menu {
    private Produto[] vetor;
    private int pos;

    public Menu() {
        vetor= new Produto[10];
        pos = 0;
    }
    public void executar() {

        int opcao;
        boolean continua=true;
        do {
            try {
                opcao=receberInteiro2("\nMeu Cadastro de produto:\n"
                        + "1- Inicializar"
                        + "\n2- Incluir"
                        + "\n3 - Pesquisar"
                        + "\n4- editar"
                        + "\n5- excluir"
                        + "\n6- listar"
                        + "\n7- Sair\n" + "\nEntre com a opção");
            } catch (Exception ex) {
                escrever(ex.getMessage());
                opcao = 0;
            }

            switch(opcao){
                case 1:
                    pos = 0;
                    vetor = new Produto[receberInteiro("Entre com o tamanho: ")];
                    break;
                case 2:incluir(vetor, pos); break;
                case 3:
                    boolean modify;
                    modify = false;
                    pesquisar(vetor, modify);
                    break;
                case 4:
                    modify = true;
                    pesquisar(vetor, modify);
                    break;
                case 5:excluir(vetor, pos); break;
                case 6:listar(vetor); break;
                case 7:continua=confirmarSaida(); break;
                default:
                    escrever("Opção Invalida");break;
            }

        } while(continua);
    }

    public void incluir(Produto[] vetor, int pos){
        try {
            Produto p = new Produto();
            p.read();
            incrementarPos();
            vetor[pos] = p;
        } catch (Exception e) {
            System.err.println("Erro! tentar novamente "+ e.getMessage());
        }

    }
    public void incrementarPos() {
        this.pos++;
        //System.out.println("incrementou " + pos);
    }

    public void pesquisar(Produto[] vetor, boolean modify) {
        try {
            int res = encontrar(vetor);
            if(res >= 0) {
                if(modify == true) {
                    vetor[res].read();
                } else {
                    vetor[res].writeProduto();
                }
            }
        } catch(Exception e) {
            new InterfaceGraph().write(e.getMessage());
        }
    }
    public static int encontrar(Produto[] vetor){
        int pos = 0;
        String criterio = receberTexto("entre com o Produto a pesquisar: ");
        for(Produto p: vetor) {
            if(p != null && p.nome.equals(criterio)) {
                return pos;
            }
            pos++;
        }
        return -1;
    }

    public static boolean excluir(Produto[] vetor, int pos){
        int res = encontrar(vetor);
        if(res >= 0) {
            for(int i = res; i < pos-1; i++) {
                vetor[i] = vetor [i + 1];
                if(i == pos - 2) {
                    vetor[pos - 2] = null;
                }
            }
            escrever("Excluído com sucesso!");
            return true;
        } else {
            escrever("Não encontrado");
            return false;
        }

    }

    public static void listar(Produto[] vetor) {
        try {
            for(Produto p: vetor) {
                if(p != null) {
                    p.writeProduto();
                }
            }
        } catch (Exception e) {
            System.err.println(e);
        }


    }
    public static void escrever(String mensagem){
        InterfaceGraph g = new InterfaceGraph();
        g.write(mensagem);
    }
    public static String receberTexto (String mensagem){
        InterfaceGraph g = new InterfaceGraph();
        return  g.readText(mensagem);
    }
    public static int receberInteiro (String mensagem){
        int ret = 0;

        try {
            InterfaceGraph g = new InterfaceGraph();
            ret = Integer.parseInt(receberTexto(mensagem));
        } catch(Exception e) {
            escrever("Digito Inválido!");
            receberInteiro(mensagem);
        } finally {
            return ret;
        }

    }

    public static int receberInteiro2 (String mensagem) throws Exception {
        int ret = 0;
        try {
            Scanner sc = new Scanner(System.in);
            ret = Integer.parseInt(receberTexto(mensagem));
        } catch(Exception e) {
            throw e;
        }
        return ret;
    }

    public static boolean confirmarSaida(){
        InterfaceGraph g = new InterfaceGraph();

        return !(g.readBoolean("Deseja Realmente Sair?"));

    }
}
