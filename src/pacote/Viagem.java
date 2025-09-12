package pacote;

import pacote.Usuario;
import pacote.FormasPagamento;
import pacote.Veiculo;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class Viagem {
	private String origem;
	private String destino;
	private String horario;
	private Usuario motorista;
	private Usuario passageiro;
	private Veiculo veiculoUtilizado;
	private double valor;
	private FormasPagamento formaPagamento;
	private int avaliacao;

	public Viagem(String origem, String destino, String horario, Usuario motorista, Usuario passageiro, Veiculo veiculo, double valor, FormasPagamento formaPagamento, int avaliacao) {
		this.origem = origem;
		this.destino = destino;
		this.horario = horario;
		this.motorista = motorista;
		this.passageiro = passageiro;
		this.veiculoUtilizado = veiculo;
		this.valor = valor;
		this.formaPagamento = formaPagamento;
		this.avaliacao = avaliacao;
	}

	public void exibirDetalhes() {
		System.out.println("--- Detalhes da Viagem ---");
		System.out.println("Origem: " + origem);
		System.out.println("Destino: " + destino);
		System.out.println("Horário: " + horario);
		System.out.println("Motorista: " + motorista.getNome());
		System.out.println("Passageiro: " + passageiro.getNome());
		System.out.println("Veículo: " + veiculoUtilizado.toString());
		System.out.println("Valor: R$" + String.format("%.2f", valor));
		System.out.println("Forma de Pagamento: " + formaPagamento);
		System.out.println("Avaliação: " + avaliacao + " estrelas");
	}

	public Usuario getMotorista() {
		return motorista;
	}

	public Usuario getPassageiro() {
		return passageiro;
	}

	public double getValor() {
		return valor;
	}

	public int getAvaliacao() {
		return avaliacao;
	}
}
