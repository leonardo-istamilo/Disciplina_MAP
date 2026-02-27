package testes;

import classes.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TesteAcuracia {

    private final VisitorIF vArea = new VisitorCalculaArea();
    private final VisitorIF vPerim = new VisitorCalculaPerimetro();

    @Test
    void testAreaRetangulo() {
        Retangulo r = new Retangulo(10, 5);
        assertEquals(50.0, vArea.visitaRetangulo(r), 0.01);
    }

    @Test
    void testAreaCirculo() {
        Circulo c = new Circulo(10);
        assertEquals(314.0, vArea.visitaCirculo(c), 0.01);
    }

    @Test
    void testAreaTriangulo() {
        Triangulo t = new Triangulo(3, 4, 5);
        assertEquals(6.0, vArea.visitaTriangulo(t), 0.01);
    }

    @Test
    void testAreaTrapezio() {
        Trapezio t = new Trapezio(4, 10, 5, 5, 5);
        assertEquals(30.0, vArea.visitaTrapezio(t), 0.01);
    }

    @Test
    void testPerimetroRetangulo() {
        Retangulo r = new Retangulo(10, 5);
        assertEquals(30.0, vPerim.visitaRetangulo(r), 0.01);
    }

    @Test
    void testPerimetroTriangulo() {
        Triangulo t = new Triangulo(3, 4, 5);
        assertEquals(12.0, vPerim.visitaTriangulo(t), 0.01);
    }
    
    @Test
    void testPerimetroTrapezio() {
        Trapezio t = new Trapezio(4, 10, 5, 5, 5);
        assertEquals(25.0, vPerim.visitaTrapezio(t), 0.01);
    }
}