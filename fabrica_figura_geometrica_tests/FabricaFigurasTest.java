package fabrica_figura_geometrica_tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import fabrica_figura_geometrica.FabricaFiguras;
import fabrica_figura_geometrica.Quadrado;
import fabrica_figura_geometrica.Triangulo;

public class FabricaFigurasTest {

	@BeforeEach
	void resetarFabrica() {
	    FabricaFiguras.getInstancia().resetarFiguras();
	}
	
	@Test
	void retornarMesmaInstancia() {
		FabricaFiguras f1 = FabricaFiguras.getInstancia();
		FabricaFiguras f2 = FabricaFiguras.getInstancia();
		
		assertSame(f1, f2);
	}
	
	@Test
	void deveCriarApenasUmTrianguloIsosceles() {
	    FabricaFiguras fabrica = FabricaFiguras.getInstancia();

	    Triangulo t1 = fabrica.criarTrianguloIsosceles();
	    Triangulo t2 = fabrica.criarTrianguloIsosceles();

	    assertSame(t1, t2);
	}

	@Test
	void deveCriarQuadradosIlimitados() {
	    FabricaFiguras fabrica = FabricaFiguras.getInstancia();

	    Quadrado q1 = fabrica.criarQuadrado();
	    Quadrado q2 = fabrica.criarQuadrado();

	    assertNotSame(q1, q2);
	}

}
