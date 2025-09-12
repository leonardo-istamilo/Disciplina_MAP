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

import java.util.ArrayList;
import java.util.List;

public class CentralCorridas {
	
	private List<SolicitacaoCorrida> pendentes =  new ArrayList<>();
	
	public void addSolicitacao(SolicitacaoCorrida soli) {
		pendentes.add(soli);
	}
	
	public List<SolicitacaoCorrida> listarPendentes() {
		return pendentes.stream().filter(soli -> !soli.isAceita()).toList();
	}
}
