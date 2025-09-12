package pacote;
import pacote.IF_Administrador;

public class Administrador implements IF_Administrador {
    @Override
    public void gerenciarUsuarios() {
        System.out.println("Administrador gerenciando usuários...");
    }

    @Override
    public void gerenciarPagamentos() {
        System.out.println("Administrador gerenciando pagamentos...");
    }

    @Override
    public void fornecerSuporte() {
        System.out.println("Administrador fornecendo suporte...");
    }
}