package controleAcademico;

public class Disciplina {
	private int id;
	private String sala;

	public Disciplina(int id, String sala) {
		this.id = id;
		this.sala = sala;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSala() {
		return sala;
	}

	public void setSala(String sala) {
		this.sala = sala;
	}
}
