package classes;

public class VisitorCalculaArea implements VisitorIF{

	@Override
	public double visitaRetangulo(Retangulo r) {
		return r.getAltura() * r.getLargura();
	}

	
	public double visitaTriangulo(Triangulo t) {
	    // Calcula o semiperímetro
	    double s = (t.getLadoA() + t.getLadoB() + t.getLadoC()) / 2.0;
	    
	    // Aplica a Fórmula de Heron: sqrt(s * (s-a) * (s-b) * (s-c))
	    return Math.sqrt(s * (s - t.getLadoA()) * (s - t.getLadoB()) * (s - t.getLadoC()));
	}
	
	//@Override
	//public double visitaTriangulo(Triangulo t) {
	//	return (t.getBase() * t.getAltura())/2;
	//}

	@Override
	public double visitaCirculo(Circulo c) {
		return 3.14 * (c.getRaio() * c.getRaio());
	}

	@Override
	public double visitaTrapezio(Trapezio t) {
		return ((t.getBase_maior() + t.getBase_menor())*t.getAltura())/2;
	}
}