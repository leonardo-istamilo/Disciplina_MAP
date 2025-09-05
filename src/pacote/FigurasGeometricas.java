package pacote;

public class FigurasGeometricas implements I_FigurasGeometricas {
	
	private int alturaRetangulo;
	private int larguraRetangulo;
	private int ladoQuadrado;
	private int raioCirculo; 
	
	public FigurasGeometricas(int alturaRetangulo, int larguraRetangulo, int ladoQuadrado, int raioCirculo){
		
		if (alturaRetangulo < 0 || larguraRetangulo < 0 || ladoQuadrado < 0 || raioCirculo < 0) {
			throw new IllegalArgumentException("Dimensões de uma figura nunca são negativas");
		}
		
		this.alturaRetangulo = alturaRetangulo;
		this.larguraRetangulo = larguraRetangulo;
		this.ladoQuadrado = ladoQuadrado;
		this.raioCirculo = raioCirculo;
	}
	
	
	public int getAlturaRetangulo() {
		return alturaRetangulo;
	}

	public void setAlturaRetangulo(int alturaRetangulo) {
		
		if (alturaRetangulo < 0) {throw new IllegalArgumentException("alturaRetangulo não pode ser negativo");}
		this.alturaRetangulo = alturaRetangulo;
	}

	public int getLarguraRetangulo() {
		return larguraRetangulo;
	}

	public void setLarguraRetangulo(int larguraRetangulo) {
		if (larguraRetangulo < 0) {throw new IllegalArgumentException("larguraRetangulo não pode ser negativo");}
		this.larguraRetangulo = larguraRetangulo;
	}

	public int getLadoQuadrado() {
		return ladoQuadrado;
	}

	public void setLadoQuadrado(int ladoQuadrado) {
		if (ladoQuadrado < 0) {throw new IllegalArgumentException("ladoQuadrado não pode ser negativo");}
		this.ladoQuadrado = ladoQuadrado;
	}

	public int getRaioCirculo() {
		return raioCirculo;
	}

	public void setRaioCirculo(int raioCirculo) {
		if (raioCirculo < 0) {throw new IllegalArgumentException("raioCirculo não pode ser negativo");}
		this.raioCirculo = raioCirculo;
	}
	
	
	@Override
	public int calcularArea(FigurasGeometricaKind tipo) {
		if (tipo == FigurasGeometricaKind.RETANGULO) {
			
			return alturaRetangulo * larguraRetangulo;
			
		} else if (tipo == FigurasGeometricaKind.QUADRADO) {
		
			return ladoQuadrado * ladoQuadrado;
			
		} else if (tipo == FigurasGeometricaKind.CIRCULO) {
			
			return (int) Math.PI * raioCirculo * raioCirculo;
			
		} else {
			throw new IllegalArgumentException("Tipo de figura inválido.");
		}

	}
	
	public void imprimirAreas(FigurasGeometricaKind tipo){
		
		if (tipo == FigurasGeometricaKind.TODAS) {
			
			int areaRetangulo = alturaRetangulo * larguraRetangulo;
			int areaQuadrado = ladoQuadrado*ladoQuadrado;
			int areaCirculo = (int) Math.PI * raioCirculo * raioCirculo;
			
			System.out.println("Área do retangulo, quadrado e círculo, respectivamente: " + areaRetangulo + ", " + areaQuadrado + " e " + areaCirculo);
		}
	}
	

	@Override
	public int calcularPerimetro(FigurasGeometricaKind tipo){
		
		if (tipo == FigurasGeometricaKind.RETANGULO){
			
			return 2 * alturaRetangulo + 2 * larguraRetangulo;

		} else if (tipo == FigurasGeometricaKind.QUADRADO){

			return  4 * ladoQuadrado;
		
		} else if (tipo == FigurasGeometricaKind.CIRCULO){
		
			return (int) (2 * 3.14 * raioCirculo);
		
		} else {
			throw new IllegalArgumentException("Tipo de figura inválido.");
		}
	}
	
	@Override
	public String descricaoFigura(FigurasGeometricaKind tipo){
		
		if (tipo == FigurasGeometricaKind.RETANGULO) {
			return "O Retângulo criado tem altura de tamanho: " + alturaRetangulo + 
			" e largura de tamanho: " + larguraRetangulo;
		
		} else if (tipo == FigurasGeometricaKind.QUADRADO) {
			return "O Quadrado criado tem lados de tamanho: " + ladoQuadrado;
		
		} else if (tipo == FigurasGeometricaKind.CIRCULO) {
			return "O Círculo criado tem raio de tamanho: " + raioCirculo;
		
		} else if (tipo == FigurasGeometricaKind.TODAS) {
			return "O Retângulo criado tem altura: " + alturaRetangulo + " e largura de: " + larguraRetangulo +
			           "\n|O Quadrado criado tem lados de: " + ladoQuadrado +
			           "\n|O Círculo criado tem raio de: " + raioCirculo;
		
		} else {
			throw new IllegalArgumentException("Tipo de figura inválido.");
		}
	}
}
