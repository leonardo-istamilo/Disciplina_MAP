package classes;

public class Triangulo implements ElementoConcretoIF {
	private double ladoA, ladoB, ladoC;

	public Triangulo(double a, double b, double c) {
        // Validação do triangulo (Desigualdade Triangular)
        if ((a + b > c) && (a + c > b) && (b + c > a)) {
            this.ladoA = a;
            this.ladoB = b;
            this.ladoC = c;
        } else {
            throw new IllegalArgumentException("Os lados informados não formam um triângulo válido!");
        }
    }
 
    
    @Override
    public void aceitaVisita(VisitorIF v) {
    	v.visitaTriangulo(this);
    	}


	public double getLadoA() {
		return ladoA;
	}


	public void setLadoA(double ladoA) {
		this.ladoA = ladoA;
	}


	public double getLadoB() {
		return ladoB;
	}


	public void setLadoB(double ladoB) {
		this.ladoB = ladoB;
	}


	public double getLadoC() {
		return ladoC;
	}


	public void setLadoC(double ladoC) {
		this.ladoC = ladoC;
	}


    
    
}