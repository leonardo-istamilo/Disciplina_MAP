package visitor;

public class Circulo implements ElementoConcretoIF {

	private double raio;
	
	public Circulo(double raio) {
		this.raio = raio;
	}
	
	public double getRaio() {
		return raio;
	}
	
	public void setRaio(double raio) {
		this.raio = raio;
	}
	
	@Override
	public void aceitaVisita(VisitorIF<?> v) {
		v.visitaCirculo(this);
	}
	
}
