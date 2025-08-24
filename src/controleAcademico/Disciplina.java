package controleAcademico;

public class Disciplina {
	private String id;
	private String nome;
	private String sala;

	public Disciplina(String id, String nome, String sala) {
		this.id = id;
		this.nome = nome;
		this.sala = sala;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSala() {
		return sala;
	}

	public void setSala(String sala) {
		this.sala = sala;
	}
}
