package fabrica_figuras_geometricas;

public class TrianguloRetangulo extends Triangulo {

    private static TrianguloRetangulo instancia;

    private TrianguloRetangulo() {
        super();
    }

    public static TrianguloRetangulo getInstancia() {
        if (instancia == null) {
            instancia = new TrianguloRetangulo();
        }
        return instancia;
    }
}