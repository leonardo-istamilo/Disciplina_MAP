package controleAcademico;

import controleAcademico.Professor;
import controleAcademico.Disciplina;
import controleAcademico.Horario;

public class ProfessorDisciplina {

	private Professor professor;
	private Disciplina disciplina;
	private Horario horario;

	public ProfessorDisciplina(Professor professor, Disciplina disciplina, Horario horario) {
		this.professor = professor;
		this.disciplina = disciplina;
		this.horario = horario;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public Horario getHorario() {
		return horario;
	}

	public void setHorario(Horario horario) {
		this.horario = horario;
	}
}
