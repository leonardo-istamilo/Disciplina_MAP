package controleAcademico;

import java.util.ArrayList;

public class Disciplina {
	
	private ArrayList<Aluno> alunos;
	private ArrayList<Horario> horarios = new ArrayList<>();
	private String nome, Id;
	private int vagas;
	private Professor professor;
	private String turno;

	public Disciplina(String nome, String Id, String turno) {
		this.nome = nome;
		this.Id = Id;
		this.vagas = 40; // quantidade de vagas iniciais na disciplina
		this.alunos = new ArrayList<>();
		this.professor = null;
		this.turno = turno;
	}
	
	public ArrayList<Horario> getHorarios(){return horarios;}

	public String getTurno() {return turno;}
	
	public void setTurno(String turno) {this.turno = turno;}
	
	public Professor getProfessor() {return professor;}
	
	public void setProfessor(Professor professor) {this.professor = professor;}

	public ArrayList<Aluno> getAlunos() {return alunos;}

	public void setAlunos(ArrayList<Aluno> alunos) {this.alunos = alunos;}



	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getId() {return Id;}
	
	public int getVagas() {return vagas;}
	
	public int quantidadeAlunos() {return alunos.size();}
	
	public void quantidade_alunos() {
		System.out.println("A disciplina " + nome + " têm " + alunos.size() + " alunos matriculados.");
	}
	public void ocuparVaga() {vagas--;}
	
	public void desocuparVaga() {vagas++;}
	
	public void listarAlunos() {
		if (!alunos.isEmpty()) {
			System.out.println(" *** Alunos da disciplina: " + nome);
			for (Aluno aluno : alunos) {
				System.out.println("----------------------" +
								   "\n Nome: " + aluno.getNome() +
								   "\n Matrícula: " + aluno.getMatricula() +
								   "\n Curso: " + aluno.getCurso() +
								   "\n Turno:" + aluno.getTurno() +
								   "\n----------------------");
			}
		} else {
			System.out.println("Não há alunos matriculados nesta disciplina.");
		}

	}
	
	public void atribuirProf(Professor prof) {
		
		if (this.professor == null) {
			this.professor = prof;
			prof.ministrarDisciplina(this);
			System.out.println("O(A) professor(a) " + prof.getNome() + " agora ministra " + nome);
		} else {
			System.out.println("A disciplina " + nome + " já possui o professor " + prof.getNome());
		}
	}

	public void adicionarAluno(Aluno aluno) {alunos.add(aluno);}

	public void removerAluno(Aluno aluno) {
		if (alunos.contains(aluno)) {
			alunos.remove(aluno);
		}
	}
	
	public void adicionarHorario(Horario horario) {horarios.add(horario);}
}