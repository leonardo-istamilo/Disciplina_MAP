package fabrica_figuras_geometricas;

public class Circulo {

    private static Circulo instancia;

    private Circulo() {}

    public static Circulo getInstancia() {
        if (instancia == null) {
            instancia = new Circulo();
        }
        return instancia;
    }
}
