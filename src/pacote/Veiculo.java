package pacote;

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
