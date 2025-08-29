package controleAcademico;

import controleAcademico.Aluno;
import controleAcademico.Disciplina;
import controleAcademico.Horario;

public class AlunoDisciplina {

	private Aluno aluno;
	private Disciplina disciplina;
	private Horario horario;

	public AlunoDisciplina(Aluno aluno, Disciplina disciplina, Horario horario) {
		this.aluno = aluno;
		this.disciplina = disciplina;
		this.horario = horario;
	}


	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
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
