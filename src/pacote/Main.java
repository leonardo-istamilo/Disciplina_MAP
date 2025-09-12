package pacote;
import pacote.Usuario;
import pacote.Viagem;
import pacote.FormasPagamento;
import pacote.Veiculo;
import java.util.ArrayList;
import java.util.List;


public class Main {
	public static void main(String[] args) {
		List<Usuario> usuarios = new ArrayList<>();
		List<Viagem> viagens = new ArrayList<>();

		// 1. Criando os veículos
		Veiculo veiculoDoRui = new Veiculo("Toyota", "Etios", "ABC-1234");
		Veiculo veiculoDaDjeo = new Veiculo("Chevrolet", "Onix", "DEF-5678");

		// 2. Cadastrando os usuários e suas funções
		Usuario rui = new Usuario("Rui", "111.111.111-11");
		rui.tornarMotorista().adicionarVeiculo(veiculoDoRui);
		rui.tornarPassageiro().adicionarFormaPagamento(FormasPagamento.DEBITO);

		Usuario djeovanna = new Usuario("Djeovanna", "222.222.222-22");
		djeovanna.tornarMotorista().adicionarVeiculo(veiculoDaDjeo);
		djeovanna.tornarPassageiro().adicionarFormaPagamento(FormasPagamento.CREDITO);

		Usuario leonardo = new Usuario("Leonardo", "333.333.333-33");
		leonardo.tornarAdministrador();
		leonardo.tornarPassageiro().adicionarFormaPagamento(FormasPagamento.PIX);

		usuarios.add(rui);
		usuarios.add(djeovanna);
		usuarios.add(leonardo);

		System.out.println("--- Usuários Cadastrados ---");
		for (Usuario u : usuarios) {
			System.out.println("Nome: " + u.getNome());
			u.exibirFuncoes();
			System.out.println("-------------------------");
		}

		// 3. Criando uma viagem e associando os papéis e veículos
		// Rui (motorista) leva Djeovanna (passageiro)
		Viagem viagem1 = new Viagem(
				"Rua das Palmeiras, 100",
				"Shopping Partage, 500",
				"2025-09-11 10:00",
				rui,
				djeovanna,
				veiculoDoRui,
				35.50,
				FormasPagamento.DEBITO,
				5
		);

		// Djeovanna (motorista) leva Leonardo (passageiro)
		Viagem viagem2 = new Viagem(
				"Residencial Dona Lindu IV, 237",
				"UEPB",
				"2025-09-11 11:30",
				djeovanna,
				leonardo,
				veiculoDaDjeo,
				10.0,
				FormasPagamento.PIX,
				4
		);

		viagens.add(viagem1);
		viagens.add(viagem2);

		// 4. Consultando o histórico de viagens de cada usuário
		System.out.println("\n--- Histórico de Viagens de Rui ---");
		exibirHistoricoUsuario(rui, viagens);

		System.out.println("\n--- Histórico de Viagens de Djeovanna ---");
		exibirHistoricoUsuario(djeovanna, viagens);

		System.out.println("\n--- Histórico de Viagens de Leonardo ---");
		exibirHistoricoUsuario(leonardo, viagens);

		// 5. Exibindo as características de uma viagem específica
		System.out.println("\n--- Detalhes da Viagem entre Rui e Djeovanna ---");
		viagem1.exibirDetalhes();
	}

	// Método auxiliar para exibir o histórico de um usuário
	public static void exibirHistoricoUsuario(Usuario usuario, List<Viagem> viagens) {
		boolean participouDeAlgumaViagem = false;
		for (Viagem v : viagens) {
			String papel = "Não participou";
			boolean participouDaViagemAtual = false;

			if (v.getMotorista().equals(usuario)) {
				papel = "Motorista";
				participouDaViagemAtual = true;
			}

			if (v.getPassageiro().equals(usuario)) {
				if (papel.equals("Motorista")) {
					papel += " e Passageiro";
				} else {
					papel = "Passageiro";
				}
				participouDaViagemAtual = true;
			}

			if (participouDaViagemAtual) {
				System.out.printf("  - Papel: %s, Valor: R$%.2f, Avaliação: %d estrelas\n",
						papel, v.getValor(), v.getAvaliacao());
				participouDeAlgumaViagem = true;
			}
		}
		if (!participouDeAlgumaViagem) {
			System.out.println("  - Não participou de nenhuma viagem.");
		}
	}
}
