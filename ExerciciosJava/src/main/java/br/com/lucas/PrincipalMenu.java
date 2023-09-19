package br.com.lucas;

import br.com.lucas.Menu;
import br.com.lucas.menu.CategoriaMenu;
import br.com.lucas.menu.ProdutoMenu;
import br.com.lucas.menu.UsuarioMenu;
import br.com.lucas.menu.VendaMenu;

public class PrincipalMenu extends Menu {
    private ProdutoMenu produtoMenu;
    private CategoriaMenu categoriaMenu;
    private UsuarioMenu usuarioMenu;
    private VendaMenu vendaMenu;



    public PrincipalMenu() {
        produtoMenu = new ProdutoMenu();
        categoriaMenu = new CategoriaMenu();
        usuarioMenu = new UsuarioMenu();
        vendaMenu = new VendaMenu();

        opcao = 0;
        continua =true;
    }

    public void executarMenuPrincipal() {
        do {
            try {
                opcao = receberInteiro("Exercicio 05: implementação CRUD das classes 05.\n"
                            + "\nMenu Principal"
                            + "\n1-Produto"
                            + "\n2-Categoria"
                            + "\n3-Usuario"
                            + "\n4-Venda"
                            + "\n5-Sair");
                switch(opcao) {
                    case 1: produtoMenu.executar();   break;
                    case 2: categoriaMenu.executar(); break;
                    case 3: usuarioMenu.executar();   break;
                    case 4: break;
                    case 5: continua = confirmarSaida(); break;
                    default: escrever("Opção inválida jovem");break;
                }


            }catch(Exception e1) {

            }
        } while(continua);
    }
}
