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

	private List<Aluno> alunos = new ArrayList<>();
	private List<Professor> professores = new ArrayList<>();
	private List<AlunoDisciplina> alunosDisciplinas = new ArrayList<>();
	private List<ProfessorDisciplina> professoresDisciplinas = new ArrayList<>();


	public void adicionarAlunoDisciplina(Aluno aluno, Disciplina disciplina, Horario horario) {
			alunosDisciplinas.add(new AlunoDisciplina(aluno, disciplina, horario));
	}
	public void removerAlunoDisciplina(Aluno aluno, Disciplina disciplina){

	}

	public void adicionarProfessorDisciplina(Professor professor, Disciplina disciplina, Horario horario) {
		professoresDisciplinas.add(new ProfessorDisciplina(professor, disciplina,horario));
	}
	public void removerProfessorDisciplina(Professor professor, Disciplina disciplina, Horario horario){

	}
s
	public List listarDisciplinasAluno(Aluno aluno) {
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
