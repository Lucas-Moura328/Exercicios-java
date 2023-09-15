package br.com.lucas;



public abstract class Menu {
    protected int opcao;
    protected boolean continua;
    public void escrever(String mensagem){
        InterfaceGraph g = new InterfaceGraph();
        g.write(mensagem);
    }
    public String receberTexto (String mensagem){
        InterfaceGraph g = new InterfaceGraph();
        return  g.readText(mensagem);
    }
    public int receberInteiro (String mensagem){
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

    public float receberFloat (String mensagem) {
        float ret = 0;
        try {
            InterfaceGraph g = new InterfaceGraph();
            ret = Float.parseFloat(receberTexto(mensagem));

        } catch (Exception e) {
        escrever("Dado inválido!: " + e.getMessage());
        }finally {
            return ret;
        }
    }

    public boolean confirmarSaida(){
        InterfaceGraph g = new InterfaceGraph();

        return !(g.readBoolean("Deseja Realmente Sair?"));

    }


}
