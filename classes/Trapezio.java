package classes;

public class Trapezio implements ElementoConcretoIF {
	double altura;
	double base_maior;
	double base_menor;
	double lado1;
	double lado2;
	
	public Trapezio(double a, double B_maior, double B_menor, double l1, double l2) {
		this.altura = a;
		this.base_maior = B_maior;
		this.base_menor = B_menor;
		this.lado1 = l1;
		this.lado2 = l2;
		
	}

	@Override
	public void aceitaVisita(VisitorIF v) {
		v.visitaTrapezio(this);
		
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}

	public double getBase_maior() {
		return base_maior;
	}

	public void setBase_maior(double base_maior) {
		this.base_maior = base_maior;
	}

	public double getBase_menor() {
		return base_menor;
	}

	public void setBase_menor(double base_menor) {
		this.base_menor = base_menor;
	}

	public double getLado1() {
		return lado1;
	}

	public void setLado1(double lado1) {
		this.lado1 = lado1;
	}

	public double getLado2() {
		return lado2;
	}

	public void setLado2(double lado2) {
		this.lado2 = lado2;
	}

	

}
