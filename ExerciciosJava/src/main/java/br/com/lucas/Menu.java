package br.com.lucas;


import br.com.lucas.InterfaceGraph;

public abstract class Menu {
    protected InterfaceGraph graph = new InterfaceGraph();
    protected int opcao;
    protected boolean continua;
    public void escrever(String mensagem){
        graph.write(mensagem);
    }
    public String receberTexto (String mensagem){
        return  graph.readText(mensagem);
    }
    public int receberInteiro (String mensagem) throws Exception {
       try {
           return graph.readInt(mensagem);
       } catch (Exception e) {
           throw e;
       }
    }

    public float receberFloat (String mensagem) throws Exception {
        try {
            return graph.readFloat(mensagem);
        } catch (Exception e) {
            throw e;
        }
    }

    public boolean confirmarSaida(){
        return !(graph.readBoolean("Deseja Realmente Sair?"));

    }


}
