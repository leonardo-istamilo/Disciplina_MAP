package controleAcademico;

import controleAcademico.Professor;
import controleAcademico.Disciplina;
import controleAcademico.Horario;

public class ProfessorDisciplina {

	private Professor professor;
	private Disciplina disciplina;

	public ProfessorDisciplina(Professor professor, Disciplina disciplina) {
		this.professor = professor;
		this.disciplina = disciplina;
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


}
