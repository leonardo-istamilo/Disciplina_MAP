package testes;

import classes.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TesteMaximizacao {

    private final VisitorIF vMax = new VisitorMaximizarFigura();

    @Test
    void testMaximizarCirculo() {
        Circulo c = new Circulo(10.0);
        c.aceitaVisita(vMax);
        assertEquals(20.0, c.getRaio(), 0.01);
    }

    @Test
    void testMaximizarRetangulo() {
        Retangulo r = new Retangulo(10.0, 5.0);
        r.aceitaVisita(vMax);
        assertEquals(20.0, r.getLargura(), 0.01);
        assertEquals(10.0, r.getAltura(), 0.01);
    }

    @Test
    void testMaximizarTriangulo() {
        Triangulo t = new Triangulo(3.0, 4.0, 5.0);
        t.aceitaVisita(vMax);
        assertEquals(6.0, t.getLadoA(), 0.01);
        assertEquals(8.0, t.getLadoB(), 0.01);
        assertEquals(10.0, t.getLadoC(), 0.01);
    }

    @Test
    void testMaximizarTrapezio() {
        // Trapezio(altura, baseMaior, baseMenor, lado1, lado2)
        Trapezio t = new Trapezio(4.0, 10.0, 5.0, 5.0, 5.0);
        t.aceitaVisita(vMax);
        assertEquals(8.0, t.getAltura(), 0.01);
        assertEquals(20.0, t.getBase_maior(), 0.01);
        assertEquals(10.0, t.getBase_menor(), 0.01);
        assertEquals(10.0, t.getLado1(), 0.01);
        assertEquals(10.0, t.getLado2(), 0.01);
    }
}