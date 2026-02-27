package visitor;

public class VisitorCalculaArea implements VisitorIF <Double>{

	@Override
	public Double visitaRetangulo(Retangulo r) {
		
		return r.getLado1() * r.getLado2();
	}
	
	@Override
	public Double visitaTriangulo(Triangulo tri) {
		//formula de herão
		// p = (a + b + c) /2 (semiperimetro)
		// A = raiz(p * (p-a) * (p-b) * (p-c))
		double lado1 = tri.getLado1();
		double lado2 = tri.getLado2();
		double lado3 = tri.getLado3();
		
		double p = (lado1 + lado2 + lado3)/2;
		double area = Math.sqrt(p * (p - lado1) * (p - lado2) * (p - lado3));
		
		return area;
	}
	
	@Override
	public Double visitaCirculo(Circulo c) {
		return Math.PI * c.getRaio() * c.getRaio();
	}
	
	@Override
	public Double visitaTrapezio(Trapezio tra) {
		return ((tra.getBaseMaior() + tra.getBaseMenor()) * tra.getAltura())/2;
	}
}
