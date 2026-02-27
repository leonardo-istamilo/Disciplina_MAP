package visitor;

public class Retangulo implements ElementoConcretoIF {

	private double lado1, lado2;
	
	public Retangulo(double lado1, double lado2) {
		this.lado1 = lado1;
		this.lado2 = lado2;
	}
	
	public double getLado1() {return lado1;}
	public double getLado2() {return lado2;}
	
	public void setLado1(double lado1) {
		this.lado1 = lado1;
	}
	
	public void setLado2(double lado2) {
		this.lado2 = lado2;
	}
	
	@Override
	public void aceitaVisita(VisitorIF<?> v) {
		v.visitaRetangulo(this);
	}
}
