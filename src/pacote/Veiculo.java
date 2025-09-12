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

public class Veiculo {
	private String modelo, placa, cor;
	
	public Veiculo(String modelo, String placa, String cor) {
		this.modelo = modelo;
		this.placa = placa;
		this.cor = cor;
	}
	
	public String getDescricao() {
		return modelo + " - " + placa + " - " + cor;
	}
}
