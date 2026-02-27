package visitor;

public class VisitorCalculaPerimetro implements VisitorIF <Double>{

	@Override
	public Double visitaRetangulo(Retangulo r) {
		return 2 * (r.getLado1() + r.getLado2());
	}
	
	@Override
	public Double visitaCirculo(Circulo c) {
		return 2 * Math.PI * c.getRaio();
	}
	
	@Override
	public Double visitaTriangulo(Triangulo tri) {
		return tri.getLado1() + tri.getLado2() + tri.getLado3();
	}
	
	@Override
	public Double visitaTrapezio(Trapezio tra) {
		return tra.getBaseMaior() + tra.getBaseMenor() + 
				tra.getAltura() + tra.getLado1() + tra.getLado2();
	}
}
