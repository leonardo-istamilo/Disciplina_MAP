package controleAcademico;

public class Professor {

	private String nome;
	private String matricula;


	public Professor( String nome, String matricula) {
		this.nome = nome;
		this.matricula = matricula;

	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
