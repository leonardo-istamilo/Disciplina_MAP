package testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import pacote.FigurasGeometricaKind;
import pacote.FigurasGeometricas;

public class FigurasGeometricasTest {

	private FigurasGeometricas figura;
	private FigurasGeometricaKind retangulo;
	private FigurasGeometricaKind quadrado;
	private FigurasGeometricaKind circulo;
	private FigurasGeometricaKind todas;
	
	@BeforeEach
	public void setUp() {
		figura = new FigurasGeometricas(10, 3, 5, 8);
		retangulo = FigurasGeometricaKind.RETANGULO;
		quadrado = FigurasGeometricaKind.QUADRADO;
		circulo = FigurasGeometricaKind.CIRCULO;
		todas = FigurasGeometricaKind.TODAS;
	}
    @Test
    public void testAreaRetangulo() {
        
        int area = figura.calcularArea(retangulo);
        assertEquals(30, area);
    }

    @Test
    public void testAreaQuadrado() {
        
        int area = figura.calcularArea(quadrado);
        assertEquals(25, area);
    }

    @Test
    public void testAreaCirculo() {
 
        int area = figura.calcularArea(circulo);
        assertEquals(3 * 8 * 8, area);
    }
    
    @Test
    public void testPerimetroRetangulo() {
    	int per = figura.calcularPerimetro(retangulo);
    	
    	assertEquals(26, per);
    }
    
    @Test
    public void testPerimetroQuadrado() {
    	int per = figura.calcularPerimetro(quadrado);
    	
    	assertEquals(20, per);
    }
    
    @Test
    public void testPerimetroCirculo() {
    	int per = figura.calcularPerimetro(circulo);
    	
    	assertEquals(50, per);
    }

    @Test
    public void testDescricaoQuadrado() {
        
        String descricao = figura.descricaoFigura(quadrado);
        assertTrue(descricao.contains("Quadrado"));
        assertTrue(descricao.contains("5"));
    }

    @Test
    public void testConstrutorComValoresNegativos() {
        assertThrows(IllegalArgumentException.class, () -> {
            new FigurasGeometricas(-1, 5, 7, 25);
        });
    }

	
}
