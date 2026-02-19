package fabrica_figura_geometrica;

public class Main {
    public static void main(String[] args) {

        FabricaFiguras fabrica = FabricaFiguras.getInstancia();

        Circulo c1 = fabrica.criarCirculo();
        Circulo c2 = fabrica.criarCirculo();
        

        System.out.println(c1 == c2); // true

        Quadrado q1 = fabrica.criarQuadrado();
        Quadrado q2 = fabrica.criarQuadrado();

        System.out.println(q1 == q2); // false

        Triangulo t1 = fabrica.criarTrianguloEquilatero();
        Triangulo t2 = fabrica.criarTrianguloEquilatero();

        System.out.println(t1 == t2); // true
    }
}
