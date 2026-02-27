package classes;


public class Circulo implements ElementoConcretoIF{
	private double raio;
	
	public Circulo(double r) {
		this.raio = r;
	}
	

	@Override
	public void aceitaVisita(VisitorIF v) {
		v.visitaCirculo(this);
		
	}


	public double getRaio() {
		return raio;
	}


	public void setRaio(double raio) {
		this.raio = raio;
	}
	
}