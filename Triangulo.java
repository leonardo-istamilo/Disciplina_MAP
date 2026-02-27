package visitor;

public class Triangulo implements ElementoConcretoIF {

	private double lado1, lado2, lado3;
	
	public Triangulo(double lado1, double lado2, double lado3) {
		
		if (!ehTriangulo(lado1, lado2, lado3)) {
			throw new IllegalArgumentException("Essas medidas não formam um triângulo");
		}
		
		this.lado1 = lado1;
		this.lado2 = lado2;
		this.lado3 = lado3;
	}
	
	public boolean ehTriangulo(double lado1, double lado2, double lado3) {
		// verifica se os valores dados formam um triangulo conforme a regra matemática
		if ((lado1 + lado2 > lado3)
				&&(lado1 + lado3 > lado2)&&(lado2 + lado3 > lado1)){
			return true;
		}
		return false;
	}
	
	public double getLado1() {return lado1;}
	public double getLado2() {return lado2;}
	public double getLado3() {return lado3;}
	
	public void setLado1(double lado1) {
		this.lado1 = lado1;
	}

	public void setLado2(double lado2) {
		this.lado2 = lado2;
	}

	public void setLado3(double lado3) {
		this.lado3 = lado3;
	}
	
	@Override
	public void aceitaVisita(VisitorIF<?> v) {
		v.visitaTriangulo(this);
	}
}
