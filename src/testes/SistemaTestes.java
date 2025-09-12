package pacote;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import pacote.Usuario;
import pacote.Motorista;
import pacote.Passageiro;
import pacote.Administrador;
import pacote.Veiculo;
import pacote.Viagem;
import pacote.FormasPagamento;
import pacote.SolicitacaoCorrida;
import pacote.PapelIF;

import java.util.List;

public class SistemaTestes {

	private Usuario rui;
	private Usuario ana;
	private Motorista papelMotorista;
	private Passageiro papelPassageiro;
	private Administrador papelAdmin;
	private Veiculo carro;

	@BeforeEach
	void setUp() {
		// Criando usuários
		rui = new Usuario("Rui", "14560", 300);
		ana = new Usuario("Ana", "12057", 456);

		// Criando papéis
		papelMotorista = new Motorista();
		papelPassageiro = new Passageiro();
		papelAdmin = new Administrador();

		// Atribuindo papéis
		rui.addPapel(papelMotorista);
		rui.addPapel(papelAdmin);
		ana.addPapel(papelPassageiro);

		// Cadastrando veículo para Rui
		carro = new Veiculo("Ferrari", "QFC-9802", "Azul");
		rui.getVeiculos().add(carro);

		// Cadastrando formas de pagamento para Ana
		papelPassageiro.addFormaPagamento(FormasPagamento.CRÉDITO);
		papelPassageiro.addFormaPagamento(FormasPagamento.PIX);
	}

	@Test
	@DisplayName("Teste de atribuição de papéis múltiplos a um usuário")
	void testAtribuicaoDePapeis() {
		// Verifica se Rui tem 2 papéis
		assertEquals(2, rui.getPapeis().size(), "Rui deveria ter 2 papéis.");
		// Verifica se Ana tem 1 papel
		assertEquals(1, ana.getPapeis().size(), "Ana deveria ter 1 papel.");
		// Verifica se Rui tem o papel de Motorista
		List<PapelIF> papeisRui = rui.getPapeis();
		boolean ruiEhMotorista = papeisRui.stream().anyMatch(p -> p instanceof Motorista);
		assertTrue(ruiEhMotorista, "Rui deveria ter o papel de motorista.");
	}

	@Test
	@DisplayName("Teste de cadastro de dados específicos de cada papel")
	void testCadastroDeDados() {
		// Verifica se o veículo foi adicionado ao usuário Rui
		assertEquals(1, rui.getVeiculos().size(), "Rui deveria ter 1 veículo.");
		// Verifica se Ana tem 2 formas de pagamento cadastradas
		assertEquals(2, papelPassageiro.getFormasPagamento().size(), "Ana deveria ter 2 formas de pagamento.");
		// Verifica se Ana tem a forma de pagamento PIX
		assertTrue(papelPassageiro.possuiFormaPagamento(FormasPagamento.PIX), "Ana deveria ter PIX como forma de pagamento.");
	}

	@Test
	@DisplayName("Teste do fluxo completo de uma viagem")
	void testFluxoCompletoDaViagem() {
		// Simula a solicitação da corrida
		Viagem viagem = papelPassageiro.solicitarCorrida(
				"Centro", "Aeroporto", FormasPagamento.CRÉDITO,
				ana, rui, carro
		);

		// Verifica se a viagem foi criada corretamente
		assertNotNull(viagem, "A viagem não deveria ser nula.");
		assertEquals("Centro", viagem.getOrigem(), "A origem da viagem está incorreta.");
		assertEquals("Aeroporto", viagem.getDestino(), "O destino da viagem está incorreto.");

		// Verifica se o histórico dos usuários foi atualizado
		rui.addViagem(viagem, "Motorista");
		ana.addViagem(viagem, "Passageiro");

		assertEquals(1, rui.getHistoricoViagens().size(), "O histórico de Rui deveria ter 1 viagem.");
		assertEquals(1, ana.getHistoricoViagens().size(), "O histórico de Ana deveria ter 1 viagem.");

		// Verifica se a forma de pagamento foi registrada
		assertEquals(FormasPagamento.CRÉDITO, viagem.getFormaPagamento(), "A forma de pagamento da viagem está incorreta.");
	}

	@Test
	@DisplayName("Teste das funcionalidades do Administrador")
	void testFuncionalidadesAdministrador() {
		// Simula a viagem para testar os detalhes
		Viagem viagem = papelPassageiro.solicitarCorrida(
				"Rodoviaria", "Praia", FormasPagamento.DÉBITO,
				ana, rui, carro
		);

		// Verifica se os métodos de detalhamento do Administrador funcionam
		// Apenas chamadas para garantir que não lancem erros
		papelAdmin.detalharUsuario(rui);
		papelAdmin.detalharUsuario(ana);
		papelAdmin.detalharViagem(viagem);
		// O teste passa se nenhuma exceção for lançada durante a execução dos métodos.
	}
}