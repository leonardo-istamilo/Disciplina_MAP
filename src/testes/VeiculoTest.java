import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import pacote.Veiculo;

class VeiculoTest {
	@Test
	public void testVeiculo_DeveTerAtributosCorretos() {
		Veiculo veiculo = new Veiculo("Honda", "Civic", "XYZ-5678");
		assertEquals("Honda", veiculo.getMarca());
		assertEquals("Civic", veiculo.getModelo());
		assertEquals("XYZ-5678", veiculo.getPlaca());
	}

	@Test
	public void testToString_DeveRetornarStringFormatada() {
		Veiculo veiculo = new Veiculo("Chevrolet", "Onix", "DEF-9012");
		assertEquals("Chevrolet Onix (DEF-9012)", veiculo.toString());
	}
}