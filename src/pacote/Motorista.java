package pacote;

public class Motorista implements PapelIF {
	
	@Override
	public void executar(Usuario usuario) {
		System.out.println(usuario.getNome() + " agora atua como motorista.");
	}
	
    public Viagem aceitarCorrida(SolicitacaoCorrida solicitacao, Usuario motorista, Veiculo veiculo) {
        
    	System.out.println(motorista.getNome() + " aceitando a corrida");
    	return solicitacao.aceitar(motorista, veiculo);
    }	
}
