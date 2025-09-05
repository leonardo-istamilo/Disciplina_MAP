package pacote;

public enum FigurasGeometricaKind {
	RETANGULO, 
	CIRCULO, 
	QUADRADO, 
	TODAS;
	
	public static FigurasGeometricaKind fromString(String nome) {
		try {
			return FigurasGeometricaKind.valueOf(nome.toUpperCase());
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException("Figura '" + nome.toUpperCase() + "' não reconhecida.");
		}
	}
}
