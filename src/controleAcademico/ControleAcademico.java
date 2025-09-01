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

	public boolean adicionarAlunoSistema(Aluno aluno) {
		if (alunos.contains(aluno)) {
			System.out.println("Erro: Aluno já existe no sistema.");
			return false;
		}
		return this.alunos.add(aluno);
	}

	public boolean adicionarProfessorSistema(Professor professor) {
		if (professores.contains(professor)) {
			System.out.println("Erro: Professor já existe no sistema.");
			return false;
		}
		return this.professores.add(professor);
	}

	public boolean adicionarAlunoDisciplina(Aluno aluno, Disciplina disciplina) {
		// 1. Prevenir matrícula duplicada
		for (AlunoDisciplina ad : alunosDisciplinas) {
			if (ad.getAluno().equals(aluno) && ad.getDisciplina().equals(disciplina)) {
				System.out.println("Erro: O aluno já está matriculado nesta disciplina.");
				return false;
			}
		}

		// 2. Prevenir choque de horário
		List<Horario> horariosAluno = listarHorarioAluno(aluno);
		for (Horario horarioExistente : horariosAluno) {
			for (Horario horarioNovo : disciplina.getHorarios()) {
				if (horarioExistente.conflitaCom(horarioNovo)) {
					System.out.println("Erro: A disciplina tem um conflito de horário com outra disciplina do aluno.");
					return false;
				}
			}
		}

		// Se as validações passarem, adicione a matrícula
		System.out.println("Matrícula de " + aluno.getNome() + " na disciplina " + disciplina.getNome() + " realizada com sucesso.");
		return alunosDisciplinas.add(new AlunoDisciplina(aluno, disciplina));
	}

	public boolean removerAlunoDisciplina(Aluno aluno, Disciplina disciplina) {
		for(AlunoDisciplina ad : alunosDisciplinas) {
			if(ad.getAluno().equals(aluno) && ad.getDisciplina().equals(disciplina)) {
				System.out.println("Aluno " + aluno.getNome() + " removido da disciplina " + disciplina.getNome() + ".");
				return alunosDisciplinas.remove(ad);
			}
		}
		System.out.println("Erro: Aluno não está matriculado nesta disciplina.");
		return false;
	}

	public boolean removerAlunoDoSistema(Aluno aluno) {
		if (!alunos.contains(aluno)) {
			System.out.println("Erro: Aluno não encontrado no sistema.");
			return false;
		}

		alunosDisciplinas.removeIf(ad -> ad.getAluno().equals(aluno));
		System.out.println("Todos os vínculos de matrícula do aluno " + aluno.getNome() + " foram removidos.");

		boolean removed = alunos.remove(aluno);
		if (removed) {
			System.out.println("Aluno " + aluno.getNome() + " removido do sistema com sucesso.");
		}
		return removed;
	}

	public boolean adicionarProfessorDisciplina(Professor professor, Disciplina disciplina) {
		for (ProfessorDisciplina pd : professoresDisciplinas) {
			if (pd.getProfessor().equals(professor) && pd.getDisciplina().equals(disciplina)) {
				System.out.println("Erro: O professor já está vinculado a esta disciplina.");
				return false;
			}
		}

		List<Horario> horariosProfessor = listarHorarioProfessor(professor);
		for (Horario horarioExistente : horariosProfessor) {
			for (Horario horarioNovo : disciplina.getHorarios()) {
				if (horarioExistente.conflitaCom(horarioNovo)) {
					System.out.println("Erro: O professor tem um conflito de horário com outra disciplina.");
					return false;
				}
			}
		}

		System.out.println("Vínculo do professor " + professor.getNome() + " com a disciplina " + disciplina.getNome() + " criado com sucesso.");
		return professoresDisciplinas.add(new ProfessorDisciplina(professor, disciplina));
	}

	public boolean removerProfessorDisciplina(Professor professor, Disciplina disciplina){
		for(ProfessorDisciplina pd : professoresDisciplinas) {
			if(pd.getProfessor().equals(professor) && pd.getDisciplina().equals(disciplina)) {
				System.out.println("Vínculo do professor " + professor.getNome() + " com a disciplina " + disciplina.getNome() + " removido.");
				return professoresDisciplinas.remove(pd);
			}
		}
		System.out.println("Erro: Professor não está vinculado a esta disciplina.");
		return false;
	}

	public boolean removerProfessorDoSistema(Professor professor) {
		if (!professores.contains(professor)) {
			System.out.println("Erro: Professor não encontrado no sistema.");
			return false;
		}

		professoresDisciplinas.removeIf(pd -> pd.getProfessor().equals(professor));
		System.out.println("Todos os vínculos de disciplina do professor " + professor.getNome() + " foram removidos.");

		boolean removed = professores.remove(professor);
		if (removed) {
			System.out.println("Professor " + professor.getNome() + " removido do sistema com sucesso.");
		}
		return removed;
	}

	public List<Disciplina> listarDisciplinasAluno(Aluno aluno) {
		List<Disciplina> disciplinasAluno = new ArrayList<>();
		for (AlunoDisciplina ad : alunosDisciplinas) {
			if (ad.getAluno().equals(aluno)){
				disciplinasAluno.add(ad.getDisciplina());
			}
		}
		return disciplinasAluno;
	}

	public List<Disciplina> listarDisciplinasProfessores(Professor professor) {
		List<Disciplina> disciplinasProfessor = new ArrayList<>();
		for (ProfessorDisciplina ad : professoresDisciplinas) {
			if (ad.getProfessor().equals(professor)){
				disciplinasProfessor.add(ad.getDisciplina());
			}
		}
		return disciplinasProfessor;
	}

	public List<Horario> listarHorarioAluno(Aluno aluno) {
		List<Horario> horariosAluno = new ArrayList<>();
		List<Disciplina> disciplinas = listarDisciplinasAluno(aluno);
		for(Disciplina d : disciplinas) {
			horariosAluno.addAll(d.getHorarios());
		}
		return horariosAluno;
	}

	public List<Horario> listarHorarioProfessor(Professor professor) {
		List<Horario> horariosProfessor = new ArrayList<>();
		List<Disciplina> disciplinas = listarDisciplinasProfessores(professor);
		for(Disciplina d : disciplinas) {
			horariosProfessor.addAll(d.getHorarios());
		}
		return horariosProfessor;
	}


	public List<Aluno> listarAlunosDisciplina(Disciplina disciplina) {
		List<Aluno> aluno = new ArrayList<>();
		for (AlunoDisciplina ad : alunosDisciplinas){
			if (ad.getDisciplina().equals(disciplina)){
				aluno.add((ad.getAluno()));
			}
		}
		return aluno;
	}

	public int quantidadeAlunosdisciplina(Disciplina disciplina) {
		int contador = 0;
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

}