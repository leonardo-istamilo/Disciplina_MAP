package classes;

public class VisitorMaximizarFigura implements VisitorIF {

	@Override
	public double visitaRetangulo(Retangulo r) {
		r.setLargura(r.getLargura() * 2);
        r.setAltura(r.getAltura() * 2);
		return 0;
	}

	@Override
	public double visitaTriangulo(Triangulo t) {
		t.setLadoA(t.getLadoA() * 2);
        t.setLadoB(t.getLadoB() * 2);
        t.setLadoC(t.getLadoC() * 2);
		return 0;
	}

	@Override
	public double visitaCirculo(Circulo c) {
		c.setRaio(c.getRaio() * 2);
		return 0;
	}

	@Override
	public double visitaTrapezio(Trapezio t) {
		t.setBase_maior(t.getBase_maior() * 2);
        t.setBase_menor(t.getBase_menor() * 2);
        t.setLado1(t.getLado1() * 2);
        t.setLado2(t.getLado2() * 2);
        t.setAltura(t.getAltura() * 2);
		return 0;
	}

}
