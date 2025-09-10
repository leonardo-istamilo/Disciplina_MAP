package pacote;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class Viagem {
	
	private String origem, destino;
	private LocalDateTime inicio, fim; //horario da corrida (inicio e fim)
	private Usuario motorista;
	private Usuario passageiro;
	private Veiculo veiculo;
	private double valor;
	private FormasPagamento formaPagamento;
	private int avaliacao;
	
	private static final double TARIFA_FIXA = 5.56;
	private static final double TARIFA_MINUTO = 2.25;
	
	public Viagem(String origem, String destino, LocalDateTime inicio, LocalDateTime fim, Usuario motorista, 
			Usuario passageiro, Veiculo veiculo, FormasPagamento formaPagamento) {
	
		this.origem = origem;
		this.destino = destino;
		this.inicio = inicio;
		this.fim = fim;
		this.motorista = motorista;
		this.passageiro = passageiro;
		this.veiculo = veiculo;
		this.valor = calcularValor();
		this.formaPagamento = formaPagamento;
		this.avaliacao = gerarAvaliacao();
		
		motorista.addViagem(this, "Motorista");
		passageiro.addViagem(this, "Passageiro");
	}

	public String getOrigem() {
		return origem;
	}

	public String getDestino() {
		return destino;
	}

	public double getValor() {
		return valor;
	}


	public int getAvaliacao() {
		return avaliacao;
	}

	private int gerarAvaliacao() {
		Random r = new Random();
		
		return r.nextInt(1,5);
	}
	
	public double calcularValor() {
		long min = Duration.between(inicio, fim).toMinutes();
		return TARIFA_MINUTO * min + TARIFA_FIXA;
	}

	public void exibirInformacoes() {
		
		DateTimeFormatter br = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		
		System.out.println("\n Viagem de " + origem + " para " + destino +
				           "\n Horário de início: " + inicio.format(br) + 
				           "\n Horário do fim: " + (fim != null ? fim.format(br) : "Em andamento") + 
				           "\n Motorista: " + motorista.getNome() + 
				           "\n Passageiro: " + passageiro.getNome() + 
				           "\n Veiculo: " + veiculo.getDescricao() + 
				           "\n Valor: " + valor + ". Pago com " + formaPagamento + 
				           "\n Avaliação: " + avaliacao + "/5");
	}
	
	
}
