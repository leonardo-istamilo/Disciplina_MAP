package pacote;
import pacote.Veiculo;

import java.util.ArrayList;
import java.util.List;

import pacote.IF_Motorista;

public class Motorista implements IF_Motorista{

	private List<Veiculo> veiculos;

	public Motorista() {
		this.veiculos = new ArrayList<>();
	}

	@Override
	public String aceitarCorrida() {
		return "Motorista aceitando corrida.";
	}

	@Override
	public void transportarPassageiro() {
	}

	@Override
	public void adicionarVeiculo(Veiculo veiculo) {
		this.veiculos.add(veiculo);
	}

	public List<Veiculo> getVeiculos() {
		return veiculos;
	}
}
