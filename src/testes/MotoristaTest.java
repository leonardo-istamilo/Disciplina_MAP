import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import pacote.Motorista;
import pacote.Veiculo;

public class MotoristaTest {

	@Test
	public void testAdicionarVeiculo_DeveAdicionarCorretamente() {
		Motorista motorista = new Motorista();
		Veiculo veiculo = new Veiculo("Ford", "Ka", "ABC-1234");

		assertTrue(motorista.getVeiculos().isEmpty());
		motorista.adicionarVeiculo(veiculo);

		assertFalse(motorista.getVeiculos().isEmpty());
		assertEquals(1, motorista.getVeiculos().size());
		assertEquals(veiculo, motorista.getVeiculos().get(0));
	}

	@Test
	public void testAceitarCorrida_DeveRetornarStatus() {
		Motorista motorista = new Motorista();
		String status = motorista.aceitarCorrida();
		assertEquals("Motorista aceitando corrida.", status);
	}
}