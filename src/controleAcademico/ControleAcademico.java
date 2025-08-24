package controleAcademico;

import controleAcademico.Aluno;
import controleAcademico.Professor;
import controleAcademico.Disciplina;
import controleAcademico.Horario;

import controleAcademico.AlunoDisciplina;
import controleAcademico.ProfessorDisciplina;

import java.util.ArrayList;
import java.util.List;

public class ControleAcademico {

	private List<Aluno> alunos;
	private List<Professor> professores;
	private List<AlunoDisciplina> alunosDisciplinas;
	private List<ProfessorDisciplina> professoresDisciplinas;

	public ControleAcademico() {
		alunos = new ArrayList<>();
		professores = new ArrayList<>();
		alunosDisciplinas = new ArrayList<>();
		professoresDisciplinas = new ArrayList<>();
	}


	public void adicionarAlunoDisciplina(Aluno aluno, Disciplina disciplina) {

	}

	public void adicionarProfessorDisciplina(Professor professor, Disciplina disciplina) {

	}

	public ArrayList listarDisciplinasAluno(Aluno aluno) {
		return null;
	}

	public ArrayList listarDisciplinasProfessor(Professor professor) {
		return null;
	}

	public ArrayList listarHorarioAluno(Aluno aluno) {
		return null;
	}

	public ArrayList listarHorarioProfessor(Professor professor) {
		return null;
	}

	public ArrayList listarAlunosDisciplina(AlunoDisciplina alunoDisciplina) {
		return null;
	}

	public int quantidadeAlunosdisciplina(Disciplina disciplina) {
		return 0;
	}

}
