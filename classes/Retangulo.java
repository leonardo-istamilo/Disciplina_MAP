package classes;

public class Retangulo implements ElementoConcretoIF {
    private double largura, altura;
    
    public Retangulo(double l, double a) {
    	this.largura = l; 
    	this.altura = a; 
    	}
    
    @Override
    public void aceitaVisita(VisitorIF v) {
    	v.visitaRetangulo(this);
    	}

	public double getLargura() {
		return largura;
	}

	public void setLargura(double largura) {
		this.largura = largura;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}
    
    
}