package br.com.lucas;

public abstract class Menu {
    protected int opcao;
    protected boolean continua;
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
