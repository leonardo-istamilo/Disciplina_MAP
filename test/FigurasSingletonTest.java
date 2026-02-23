package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import fabrica_figuras_geometricas.Circulo;
import fabrica_figuras_geometricas.Quadrado;
import fabrica_figuras_geometricas.TrianguloEquilatero;
import fabrica_figuras_geometricas.TrianguloIsosceles;
import fabrica_figuras_geometricas.TrianguloRetangulo;

public class FigurasSingletonTest {

    @Test
    void circuloDeveSerSingleton() {
        Circulo c1 = Circulo.getInstancia();
        Circulo c2 = Circulo.getInstancia();

        assertSame(c1, c2);
    }

    @Test
    void trianguloIsoscelesDeveSerSingleton() {
        TrianguloIsosceles t1 = TrianguloIsosceles.getInstancia();
        TrianguloIsosceles t2 = TrianguloIsosceles.getInstancia();

        assertSame(t1, t2);
    }

    @Test
    void trianguloEquilateroDeveSerSingleton() {
        TrianguloEquilatero t1 = TrianguloEquilatero.getInstancia();
        TrianguloEquilatero t2 = TrianguloEquilatero.getInstancia();

        assertSame(t1, t2);
    }

    @Test
    void trianguloRetanguloDeveSerSingleton() {
        TrianguloRetangulo t1 = TrianguloRetangulo.getInstancia();
        TrianguloRetangulo t2 = TrianguloRetangulo.getInstancia();

        assertSame(t1, t2);
    }

    @Test
    void quadradosNaoDevemSerSingleton() {
        Quadrado q1 = new Quadrado();
        Quadrado q2 = new Quadrado();

        assertNotSame(q1, q2);
    }
}
