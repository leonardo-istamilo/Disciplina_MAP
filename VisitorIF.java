package visitor;

public interface VisitorIF <T>{

	T visitaRetangulo(Retangulo r);
	T visitaTriangulo(Triangulo tri);
	T visitaCirculo(Circulo c);
	T visitaTrapezio(Trapezio tra);
}
