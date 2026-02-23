package fabrica_figuras_geometricas;

public class Main {

    public static void main(String[] args) {

        // Singleton
        Circulo c1 = Circulo.getInstancia();
        Circulo c2 = Circulo.getInstancia();

        System.out.println("Círculo é único? " + (c1 == c2));

        // Triângulos (Singleton por tipo)
        TrianguloIsosceles ti1 = TrianguloIsosceles.getInstancia();
        TrianguloIsosceles ti2 = TrianguloIsosceles.getInstancia();
        
        TrianguloEquilatero teq = TrianguloEquilatero.getInstancia();
        TrianguloRetangulo ret = TrianguloRetangulo.getInstancia();
        
        System.out.println("Isósceles é único? " + (ti1 == ti2));
        
        
        // Quadrados (instâncias livres)
        Quadrado q1 = new Quadrado();
        Quadrado q2 = new Quadrado();
        
        System.out.println("Quadrados são diferentes? " + (q1 != q2));
    }
}
