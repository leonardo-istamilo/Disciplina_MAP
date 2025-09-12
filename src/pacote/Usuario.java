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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Usuario {
	
	private String nome, rg;
	private long id;
	
	private List<Veiculo> veiculos = new ArrayList<>();
	private List<PapelIF> papeis = new ArrayList<>();
	private Map<Viagem, String> historicoViagens = new HashMap<>();

	public Usuario(String nome, String rg, long id) {
		this.nome = nome;
		this.rg = rg;
		this.id = id;

	}
	
	public String getNome() {
		return nome;
	}
	
	public String getRg() {
		return rg;
	}
	
	public long getId() {
		return id;
	}
	
	
	public List<PapelIF> getPapeis() {
		return papeis;
	}
	
	public List<Veiculo> getVeiculos() {
		return veiculos;
	}

	public void addPapel(PapelIF papel) {
		papeis.add(papel);
	}
	
	public void addViagem(Viagem viagem, String papel) {
	    historicoViagens.put(viagem, papel);
	}
	
	public void exibirHistorico() {
	    System.out.println("\n Histórico de viagens de " + nome + ":");

	    for (Map.Entry<Viagem, String> entrada : historicoViagens.entrySet()) {
	        Viagem v = entrada.getKey();
	        String papel = entrada.getValue();

	        System.out.printf("[%s] %s → %s | Valor: R$%.2f | Avaliação: %s\n",
	            papel,
	            v.getOrigem(),
	            v.getDestino(),
	            v.getValor(),
	            v.getAvaliacao() >= 0 ? v.getAvaliacao() + "/5" : "Não avaliada"
	        );
	    }
	}
	public void executarPapeis() {
		for (PapelIF papel : papeis) {
			papel.executar(this);
		}
	}

	public Map<Viagem, String> getHistoricoViagens() {
		return historicoViagens;
	}
}
