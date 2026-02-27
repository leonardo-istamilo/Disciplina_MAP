package classes;

public class Principal{
	public static void main(String[] args) {
	VisitorIF visitorCA = new VisitorCalculaArea();
    VisitorIF visitorP = new VisitorCalculaPerimetro();
    VisitorIF visitorD = new VisitorDesenhar();
    VisitorIF visitorMax = new VisitorMaximizarFigura();

	Circulo circulo = new Circulo(15);
	Retangulo retangulo = new Retangulo(10, 15);
	Trapezio trapezio = new Trapezio(20, 10, 5, 5, 8);
	Triangulo triangulo = null;
	try {
		//triangulo = new Triangulo(1, 1, 10);
	    triangulo = new Triangulo(5, 5, 5);
	} catch (IllegalArgumentException e) {
	    System.out.println("Erro na criação do triângulo: " + e.getMessage());
	}

    
    // Testes de area
    System.out.println("--- Áreas ---");
    System.out.println("Área circulo: " + visitorCA.visitaCirculo(circulo));
    System.out.println("Área retangulo: " + visitorCA.visitaRetangulo(retangulo));
    System.out.println("Área triangulo: " + visitorCA.visitaTriangulo(triangulo));
    System.out.println("Área trapezio: " + visitorCA.visitaTrapezio(trapezio));
	
    // Testes de Perimetro
    System.out.println("\n--- Perímetros ---");
    System.out.println("Perímetro circulo: " + visitorP.visitaCirculo(circulo));
    System.out.println("Perímetro retangulo: " + visitorP.visitaRetangulo(retangulo));
    System.out.println("Perímetro triangulo: " + visitorP.visitaTriangulo(triangulo));
    System.out.println("Perímetro trapezio: " + visitorP.visitaTrapezio(trapezio));
    
    // Testes de Desenho
    System.out.println("\n--- Desenhos ---");
    circulo.aceitaVisita(visitorD);
    retangulo.aceitaVisita(visitorD);
    triangulo.aceitaVisita(visitorD);
    trapezio.aceitaVisita(visitorD);
    
    // Testes de Maximização
    
    circulo.aceitaVisita(visitorMax);
    retangulo.aceitaVisita(visitorMax);
    triangulo.aceitaVisita(visitorMax);
    trapezio.aceitaVisita(visitorMax);
    
    System.out.println("\n--- Novas Áreas (Após Maximizar) ---");
    System.out.println("Nova Área círculo: " + visitorCA.visitaCirculo(circulo));
    System.out.println("Nova Área retângulo: " + visitorCA.visitaRetangulo(retangulo));
    System.out.println("Nova Área triângulo: " + visitorCA.visitaTriangulo(triangulo));
    System.out.println("Nova Área trapézio: " + visitorCA.visitaTrapezio(trapezio));
    
    // Verificando os novos desenhos
    System.out.println("\n--- Novas Medidas (Desenho) ---");
    circulo.aceitaVisita(visitorD);
    retangulo.aceitaVisita(visitorD);
    triangulo.aceitaVisita(visitorD);
    trapezio.aceitaVisita(visitorD);
    
    
    
    
}
}