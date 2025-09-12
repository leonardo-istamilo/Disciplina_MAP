package pacote;
import pacote.FormasPagamento;
import pacote.IF_Passageiro;

import java.util.ArrayList;
import java.util.List;

public class Passageiro implements IF_Passageiro {
	private List<FormasPagamento> formasPagamento;

	public Passageiro() {
		this.formasPagamento = new ArrayList<>();
	}

	@Override
	public String solicitarCorrida() {
		return "Passageiro solicitando corrida.";
	}

	@Override
	public boolean pagarCorrida() {
		return true;
	}

	@Override
	public void adicionarFormaPagamento(FormasPagamento formaPagamento) {
		this.formasPagamento.add(formaPagamento);
	}

	public List<FormasPagamento> getFormasPagamento() {
		return formasPagamento;
	}
}
