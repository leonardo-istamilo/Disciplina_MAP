package classes;

public class VisitorDesenhar implements VisitorIF {

    @Override
    public double visitaRetangulo(Retangulo r) {
        System.out.println("Este Retângulo possui " + r.getAltura() + " de altura por " + r.getLargura() + " de largura.");
        return 0.0;
    }
    

    @Override
    public double visitaTriangulo(Triangulo t) {
        String tipo;
        // Lógica para identificar a particularidade do triângulo
        if (t.getLadoA() == t.getLadoB() && t.getLadoB() == t.getLadoC()) {
            tipo = "Equilátero";
        } else if (t.getLadoA() == t.getLadoB() || t.getLadoA() == t.getLadoC() || t.getLadoB() == t.getLadoC()) {
            tipo = "Isósceles";
        } else {
            tipo = "Escaleno";
        }
        
        System.out.println("Este Triângulo " + tipo + " possui lados de medida: " 
                            + t.getLadoA() + ", " + t.getLadoB() + " e " + t.getLadoC() + ".");
        return 0.0;
    }

    @Override
    public double visitaCirculo(Circulo c) {
        System.out.println("Este Círculo possui " + c.getRaio() + " de raio.");
        return 0.0;
    }

    @Override
    public double visitaTrapezio(Trapezio t) {
        String tipo = (t.getLado1() == t.getLado2()) ? "Isósceles" : "Escaleno";
        System.out.println("Este Trapézio " + tipo + " possui Base Maior: " + t.getBase_maior() 
                            + ", Base Menor: " + t.getBase_menor()+ " e altura: " + t.getAltura() + ".");
        return 0.0;
    }
}