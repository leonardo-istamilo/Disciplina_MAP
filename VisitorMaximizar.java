package visitor;

public class VisitorMaximizar implements VisitorIF <Void> {

	@Override
	public Void visitaRetangulo(Retangulo r) {
		r.setLado1(r.getLado1() * 2);
		r.setLado2(r.getLado2() * 2);
		
		return null;
	}
	
	@Override
	public Void visitaCirculo(Circulo c) {
		c.setRaio(c.getRaio() * 2);
		return null;
	}
	
	@Override
	public Void visitaTriangulo(Triangulo tri) {
		tri.setLado1(tri.getLado1() * 2);
		tri.setLado2(tri.getLado2() * 2);
		tri.setLado3(tri.getLado3() * 2);
		
		return null;
	}
	
	@Override
	public Void visitaTrapezio(Trapezio tra) {
		tra.setAltura(tra.getAltura() * 2);
		tra.setBaseMaior(tra.getBaseMaior() * 2);
		tra.setBaseMenor(tra.getBaseMenor() * 2);
		tra.setLado1(tra.getLado1() * 2);
		tra.setLado2(tra.getLado2() * 2);
		
		return null;
	}
}
