package classes;

public class VisitorCalculaPerimetro implements VisitorIF {

	@Override
	public double visitaRetangulo(Retangulo r) {
		return (r.getAltura() + r.getLargura()) * 2;
	}

	@Override
	public double visitaTriangulo(Triangulo t) {
		return t.getLadoA() + t.getLadoB() + t.getLadoC();
	}

	@Override
	public double visitaCirculo(Circulo c) {
		return 2 * 3.14 * c.getRaio();
	}

	@Override
	public double visitaTrapezio(Trapezio t) {
		return t.getBase_maior() + t.getBase_menor() + t.getLado1() + t.getLado2();
	}

}
