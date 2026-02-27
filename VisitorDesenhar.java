package visitor;

public class VisitorDesenhar implements VisitorIF <Void>{

	@Override
	public Void visitaRetangulo(Retangulo r) {
		System.out.println("Desenhando retângulo");
		System.out.println("Base: " + r.getLado1());
		System.out.println("Altura: " + r.getLado2());
		
		return null;
	}
	
	@Override
	public Void visitaCirculo(Circulo c) {
		System.out.println("Desenhando círculo");
		System.out.println("Raio: " + c.getRaio());
		
		return null;
	}
	
	@Override
	public Void visitaTrapezio(Trapezio tra) {
		System.out.println("Desenhando trapézio");
		System.out.println("Base maior: " + tra.getBaseMaior());
		System.out.println("Base menor: " + tra.getBaseMenor());
		System.out.println("Altura: " + tra.getAltura());
		System.out.println("Lado não-paralelo 1: " + tra.getLado1());
		System.out.println("Lado não-paralelo 2: " + tra.getLado2());
		
		return null;
	}
	
	@Override
	public Void visitaTriangulo(Triangulo tri) {
		System.out.println("Desenhando triângulo");
		System.out.println("Lado 1: " + tri.getLado1());
		System.out.println("Lado 2: " + tri.getLado2());
		System.out.println("Lado 3: " + tri.getLado3());
		
		return null;
	}
	
}
