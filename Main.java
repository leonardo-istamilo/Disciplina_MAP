package visitor;

public class Main {
	public static void main(String[] args) {
		
		VisitorIF<Double> visitor_area = new VisitorCalculaArea();
		
		Circulo circulo = new Circulo(10);
		circulo.aceitaVisita(visitor_area);
		System.out.println("Área do círculo: " + visitor_area.visitaCirculo(circulo)); // 314,15926....
		
		Triangulo triangulo = new Triangulo(3, 4, 5);
		triangulo.aceitaVisita(visitor_area);
		System.out.println("Área do triângulo: " + visitor_area.visitaTriangulo(triangulo));
		
		Trapezio trapezio = new Trapezio(10, 5, 3, 3, 2); //B, b, h, l1, l2
		trapezio.aceitaVisita(visitor_area);
		System.out.println("Área do trapézio: " + visitor_area.visitaTrapezio(trapezio));
		
		
		Retangulo retangulo = new Retangulo(40, 30);
		retangulo.aceitaVisita(visitor_area);
		System.out.println("Área do retângulo: " + visitor_area.visitaRetangulo(retangulo));
		
		System.out.println("-----------------------------");
		
		VisitorIF <Double> visitor_perimetro = new VisitorCalculaPerimetro();
		circulo.aceitaVisita(visitor_perimetro);
		System.out.println("O tamanho da circunferência é: " + visitor_perimetro.visitaCirculo(circulo));
		
		triangulo.aceitaVisita(visitor_perimetro);
		System.out.println("O perímetro do triângulo é: " + visitor_perimetro.visitaTriangulo(triangulo));
		
		trapezio.aceitaVisita(visitor_perimetro);
		System.out.println("O perímetro do trapézio é: " + visitor_perimetro.visitaTrapezio(trapezio));
		
		retangulo.aceitaVisita(visitor_perimetro);
		System.out.println("O perímetro do retângulo é: " + visitor_perimetro.visitaRetangulo(retangulo));
		
		System.out.println("-----------------------------");
		
		VisitorIF <Void> visitor_desenhar = new VisitorDesenhar();
		
		circulo.aceitaVisita(visitor_desenhar);
		triangulo.aceitaVisita(visitor_desenhar);
		trapezio.aceitaVisita(visitor_desenhar);
		retangulo.aceitaVisita(visitor_desenhar);
		
		System.out.println("-----------------------------");
		
		VisitorIF <Void> visitor_max = new VisitorMaximizar();
		circulo.aceitaVisita(visitor_max);
		System.out.println("O raio do círculo passa a ser: " + circulo.getRaio());
		
		triangulo.aceitaVisita(visitor_max);
		System.out.println("Os lados do triângulo passam a ser: " + triangulo.getLado1() +  
				", " + triangulo.getLado2() + ", " + triangulo.getLado3());
		
		trapezio.aceitaVisita(visitor_max);
		System.out.println("Os lados do trapézio passam a ser: " + trapezio.getBaseMaior() + ", " + 
				trapezio.getBaseMenor() + ", " + trapezio.getAltura() + ", " + 
				trapezio.getLado1() + ", " + trapezio.getLado2());
		
		retangulo.aceitaVisita(visitor_max);
		System.out.println("Os lados do retângulo passam a ser: " + retangulo.getLado1() + ", " + retangulo.getLado2());
	}
}
