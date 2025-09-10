package pacote;

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
