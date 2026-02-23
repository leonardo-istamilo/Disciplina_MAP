package fabrica_figuras_geometricas;

public class TrianguloEquilatero extends Triangulo {

    private static TrianguloEquilatero instancia;

    private TrianguloEquilatero() {
        super();
    }

    public static TrianguloEquilatero getInstancia() {
        if (instancia == null) {
            instancia = new TrianguloEquilatero();
        }
        return instancia;
    }
}

