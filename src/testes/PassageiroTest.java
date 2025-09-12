import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import pacote.Passageiro;
import pacote.Usuario;
import pacote.FormasPagamento;

public class PassageiroTest {

    @Test
    public void testAdicionarFormaPagamento_DeveAdicionarCorretamente() {
        Passageiro passageiro = new Passageiro();
        assertTrue(passageiro.getFormasPagamento().isEmpty());

        passageiro.adicionarFormaPagamento(FormasPagamento.CREDITO);

        assertFalse(passageiro.getFormasPagamento().isEmpty());
        assertEquals(1, passageiro.getFormasPagamento().size());
        assertTrue(passageiro.getFormasPagamento().contains(FormasPagamento.CREDITO));
    }

    @Test
    public void testSolicitarCorrida_DeveRetornarStatus() {
        Passageiro passageiro = new Passageiro();
        String status = passageiro.solicitarCorrida();
        assertEquals("Passageiro solicitando corrida.", status);
    }
}