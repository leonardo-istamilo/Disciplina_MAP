package visitor;

public class Trapezio implements ElementoConcretoIF{
	
	private double baseMaior, baseMenor, altura;
	private double lado1, lado2;
	
	public Trapezio(double baseMaior, double baseMenor, 
			double altura, double lado1, double lado2) {
		this.baseMaior = baseMaior;
		this.baseMenor = baseMenor;
		this.altura = altura;
		this.lado1 = lado1;
		this.lado2 = lado2;
	}
	
	public double getBaseMaior() {return baseMaior;}
	
	public double getBaseMenor() {return baseMenor;}
	
	public double getAltura() {return altura;}
	
	public double getLado1() {return lado1;}
	public double getLado2() {return lado2;}
	
	public void setBaseMaior(double baseMaior) {
		this.baseMaior = baseMaior;
	}

	public void setBaseMenor(double baseMenor) {
		this.baseMenor = baseMenor;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}

	public void setLado1(double lado1) {
		this.lado1 = lado1;
	}

	public void setLado2(double lado2) {
		this.lado2 = lado2;
	}
	
	@Override
	public void aceitaVisita(VisitorIF<?> v) {
		v.visitaTrapezio(this);
	}	
}
