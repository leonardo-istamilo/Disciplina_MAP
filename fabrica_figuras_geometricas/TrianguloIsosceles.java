package fabrica_figuras_geometricas;

public class TrianguloIsosceles extends Triangulo {
    private static TrianguloIsosceles instancia;

    private TrianguloIsosceles() {
        super();
    }

    public static TrianguloIsosceles getInstancia() {
        if (instancia == null) {
            instancia = new TrianguloIsosceles();
        }
        return instancia;
    }
}
