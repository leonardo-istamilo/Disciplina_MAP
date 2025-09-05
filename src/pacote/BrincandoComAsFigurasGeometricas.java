package pacote;

public class BrincandoComAsFigurasGeometricas {
	public static void main(String[] args) {

		FigurasGeometricas figura = new FigurasGeometricas(10, 5, 7, 25);

		figura.calcularArea(FigurasGeometricaKind.RETANGULO);
		figura.calcularArea(FigurasGeometricaKind.CIRCULO);
		figura.calcularArea(FigurasGeometricaKind.QUADRADO);
		figura.imprimirAreas(FigurasGeometricaKind.TODAS);
		
		try {
		    FigurasGeometricaKind tipo = FigurasGeometricaKind.fromString("triangulo");
		    figura.calcularArea(tipo);
		} catch (IllegalArgumentException e) {
		    System.out.println("Erro: " + e.getMessage());
		}

		System.out.println();
		
		System.out.println("Perímetro do retângulo: " + figura.calcularPerimetro(FigurasGeometricaKind.RETANGULO));
		System.out.println("Perímetro do círculo: " + figura.calcularPerimetro(FigurasGeometricaKind.CIRCULO));
		System.out.println("Perímetro do quadrado: " + figura.calcularPerimetro(FigurasGeometricaKind.QUADRADO));
		
		try {
		    FigurasGeometricaKind tipo = FigurasGeometricaKind.fromString("triangulo");
		    figura.calcularPerimetro(tipo);
		} catch (IllegalArgumentException e) {
		    System.out.println("Erro: " + e.getMessage());
		}

		System.out.println();
		
		System.out.println("Descrição do retângulo: " + figura.descricaoFigura(FigurasGeometricaKind.RETANGULO));
		System.out.println("Descrição do círculo: " + figura.descricaoFigura(FigurasGeometricaKind.CIRCULO));
		System.out.println("Descrição do quadrado: " + figura.descricaoFigura(FigurasGeometricaKind.QUADRADO));
		System.out.println("Descrição de todas: " + figura.descricaoFigura(FigurasGeometricaKind.TODAS));


	}
}
