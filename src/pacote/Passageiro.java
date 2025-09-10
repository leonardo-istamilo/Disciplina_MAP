package pacote;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Passageiro implements PapelIF{
	
	private List<FormasPagamento> formasPagamento = new ArrayList<>();
	
	@Override
	public void executar(Usuario usuario) {
		System.out.println(usuario.getNome() + " agora atua como passageiro.");
	}
	
	public void addFormaPagamento(FormasPagamento forma) {
		
		if (forma == FormasPagamento.CRÉDITO) {
			formasPagamento.add(forma);
		
		} else if (forma == FormasPagamento.PIX) {
			formasPagamento.add(forma);
		
		} else if (forma == FormasPagamento.DÉBITO) {
			formasPagamento.add(forma);
			
		} else if (forma == FormasPagamento.DINHEIRO) {
			formasPagamento.add(forma);
		}
	}
	
	public List<FormasPagamento> getFormasPagamento() {
		return formasPagamento;
	}

	public Viagem solicitarCorrida(String origem, String destino, FormasPagamento pagamento,
            Usuario passageiro, Usuario motorista, Veiculo veiculo) {
		
		if (!possuiFormaPagamento(pagamento)) {
			System.out.println("Forma de pagamento não cadastrada para o passageiro " + passageiro.getNome());
		}
		
		LocalDateTime inicio = LocalDateTime.now();
		LocalDateTime fim = inicio.plusMinutes(15);
		
		Viagem viagem = new Viagem(origem, destino, inicio, fim,
				motorista, passageiro, veiculo, pagamento);
		
		return viagem;
	}
	
	public boolean possuiFormaPagamento(FormasPagamento forma) {
		return formasPagamento.contains(forma);
	}
}
