package pacote;

import pacote.Usuario;
import pacote.Motorista;
import pacote.Passageiro;
import pacote.Administrador;
import pacote.Veiculo;
import pacote.Viagem;
import pacote.FormasPagamento;
import pacote.SolicitacaoCorrida;
import pacote.PapelIF;

public class Administrador implements PapelIF {

    @Override
    public void executar(Usuario usuario) {
        System.out.println(usuario.getNome() + " agora é administrador.");
    }

    public void detalharUsuario(Usuario u) {
        System.out.println("\n--- Detalhes do usuário: " + u.getNome() + " ---");

        
        System.out.println("Veículos cadastrados:");
        for (Veiculo v : u.getVeiculos()) {
            System.out.println(" - " + v.getDescricao());
        }

        // se for passageiro
        for (PapelIF papel : u.getPapeis()) {
            if (papel instanceof Passageiro passageiro) {
                System.out.println("Formas de pagamento:");
                for (FormasPagamento fp : passageiro.getFormasPagamento()) {
                    System.out.println(" - " + fp);
                }
            }
        }

        System.out.println("Histórico de viagens:");
        u.exibirHistorico();
    }


    public void detalharViagem(Viagem v) {
        System.out.println("\n--- Detalhes da viagem ---");
        v.exibirInformacoes();
    }
}