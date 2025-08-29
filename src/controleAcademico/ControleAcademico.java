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

	public boolean removerAlunoDisciplina(Aluno aluno, Disciplina disciplina) {
		return alunosDisciplinas.removeIf(ad -> ad.getAluno().equals(aluno) && ad.getDisciplina().equals(disciplina));
	}

	public void adicionarProfessorDisciplina(Professor professor, Disciplina disciplina, Horario horario) {
		professoresDisciplinas.add(new ProfessorDisciplina(professor, disciplina,horario));
	}

	public boolean removerProfessorDisciplina(Professor professor, Disciplina disciplina, Horario horario){
		return professoresDisciplinas.removeIf(pd -> pd.getProfessor().equals(professor) && pd.getDisciplina().equals(disciplina));
	}

	List<Disciplina> disciplinasAluno = new ArrayList<>();
	public List<Disciplina> listarDisciplinasAluno(Aluno aluno) {
		for (AlunoDisciplina ad : alunosDisciplinas) {
			if (ad.getAluno().equals(aluno)){
				disciplinasAluno.add(ad.getDisciplina());
			}
		}
		return disciplinasAluno;
	}

	List<Disciplina> disciplinasProfessor = new ArrayList<>();
	public List<Disciplina> listarDisciplinasProfessores(Professor professor) {
		for (ProfessorDisciplina ad : professoresDisciplinas) {
			if (ad.getProfessor().equals(professor)){
				disciplinasProfessor.add(ad.getDisciplina());
			}
		}
		return disciplinasProfessor;
	}

	List<Horario> horariosAluno = new ArrayList<>();
	public List<Horario> listarHorarioAluno(Aluno aluno) {
		for (AlunoDisciplina ad : alunosDisciplinas) {
			if (ad.getAluno().equals(aluno)){
				horariosAluno.add(ad.getHorario());
			}
		}
		return horariosAluno;
	}

	List<Horario> horariosProfessor = new ArrayList<>();
	public List<Horario> listarHorarioProfessor(Professor professor) {
		for (ProfessorDisciplina pd : professoresDisciplinas) {
			if (pd.getProfessor().equals(professor)){
				horariosProfessor.add(pd.getHorario());
			}
		}
		return horariosProfessor;
	}

	List<Aluno> aluno = new ArrayList<>();
	public List<Aluno> listarAlunosDisciplina(Disciplina disciplina) {
		for (AlunoDisciplina ad : alunosDisciplinas){
			if (ad.getDisciplina().equals(disciplina)){
				aluno.add((ad.getAluno()));
			}
		}
		return aluno;
	}

	int contador = 0;
	public int quantidadeAlunosdisciplina(Disciplina disciplina) {
		for (AlunoDisciplina ad : alunosDisciplinas) {
			if (ad.getDisciplina().equals(disciplina)){
				contador++;
			}
		}
		return contador;
	}

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}

	public List<Professor> getProfessores() {
		return professores;
	}

	public void setProfessores(List<Professor> professores) {
		this.professores = professores;
	}

	public List<AlunoDisciplina> getAlunosDisciplinas() {
		return alunosDisciplinas;
	}

	public void setAlunosDisciplinas(List<AlunoDisciplina> alunosDisciplinas) {
		this.alunosDisciplinas = alunosDisciplinas;
	}

	public List<ProfessorDisciplina> getProfessoresDisciplinas() {
		return professoresDisciplinas;
	}

	public void setProfessoresDisciplinas(List<ProfessorDisciplina> professoresDisciplinas) {
		this.professoresDisciplinas = professoresDisciplinas;
	}

	@Override
	public String toString() {
		return "ControleAcademico{" +
				"alunos=" + alunos +
				", professores=" + professores +
				", alunosDisciplinas=" + alunosDisciplinas +
				", professoresDisciplinas=" + professoresDisciplinas +
				'}';
	}
}
