package controleAcademico;
import java.util.ArrayList;
import java.util.List;
import controleAcademico.Horario;

public class Disciplina {
	private String id;
	private String nome;
	private String sala;
	private List<Horario> horarios;

	public Disciplina(String id, String nome, String sala) {
		this.id = id;
		this.nome = nome;
		this.sala = sala;
		this.horarios = new ArrayList<>();
	}

	public void adicionarHorario(Horario horario) {
		this.horarios.add(horario);
	}

	public List<Horario> getHorarios() {
		return horarios;
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

	@Override
	public String toString() {
		return "Disciplina{" +
				"id='" + id + '\'' +
				", nome='" + nome + '\'' +
				", sala='" + sala + '\'' +
				'}';
	}
}
