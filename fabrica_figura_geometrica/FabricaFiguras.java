package fabrica_figura_geometrica;

public class FabricaFiguras {
	
	private static FabricaFiguras instancia;
	
    private Circulo circulo;
    private TrianguloIsosceles isosceles;
    private TrianguloEquilatero equilatero;
    private TrianguloRetangulo retangulo;
    
    private FabricaFiguras() {}
    
    public static FabricaFiguras getInstancia() {
        if (instancia == null) {
            instancia = new FabricaFiguras();
        }
        return instancia;
    }

    
    public void resetarFiguras() {
    	circulo = null;
    	isosceles = null;
    	equilatero = null;
    	retangulo = null;
    }
    
    public Circulo criarCirculo() {
        if (circulo == null) {
            circulo = new Circulo();
        }
        return circulo;
    }


    public Triangulo criarTrianguloIsosceles() {
        if (isosceles == null) {
            isosceles = new TrianguloIsosceles();
        }
        return isosceles;
    }

    public Triangulo criarTrianguloEquilatero() {
        if (equilatero == null) {
            equilatero = new TrianguloEquilatero();
        }
        return equilatero;
    }

    public Triangulo criarTrianguloRetangulo() {
        if (retangulo == null) {
            retangulo = new TrianguloRetangulo();
        }
        return retangulo;
    }

    public Quadrado criarQuadrado() {
        return new Quadrado();
    }

}
