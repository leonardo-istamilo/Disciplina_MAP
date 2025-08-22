package controleAcademico;

import java.util.ArrayList;

public class Aluno {
	
	private String nome, matricula, curso, turno;
	private Disciplina disciplina;
	private ArrayList<Disciplina> disciplinas;
	
	public Aluno(String nome, String matricula, String curso, String turno) {
		this.nome = nome;
		this.matricula = matricula;
		this.curso = curso;
		this.turno = turno;
		this.disciplinas = new ArrayList<>();
	}
	
	public Disciplina getDisciplina() {
		return disciplina;
	}
	
	public String getNome() {return nome;}
	
	public String getMatricula() {return matricula;}
	
	public String getCurso() {return curso;}
	
	public String getTurno() {return turno;}
	
	public void setTurno(String turno) {this.turno = turno;}
	
	public ArrayList<Disciplina> getDisciplinas() {return disciplinas;}
	
	public void setDisciplinas(ArrayList<Disciplina> disciplinas) {this.disciplinas = disciplinas;}
	
	
	public void matricularEmDisciplina(Disciplina disciplina) {
		
		if (disciplinas.contains(disciplina)) {
			System.out.println(nome + " já está matriculado na disciplina " + disciplina.getNome());
			return;
		}
		
	    for (Disciplina d : disciplinas) {
	        for (Horario h1 : d.getHorarios()) {
	            for (Horario h2 : disciplina.getHorarios()) {
	                if (h1.conflitaCom(h2)) {
	                    System.out.println("Conflito de horário: " + disciplina.getNome() +
	                                       " colide com " + d.getNome());
	                    return;
	                }
	            }
	        }
	    }
		if (disciplina.getVagas() > 0) {
			disciplinas.add(disciplina);
			disciplina.ocuparVaga();
			disciplina.adicionarAluno(this);
			System.out.println("Matrícula de " + nome + " na disciplina " + disciplina.getNome() + " feita com sucesso. " + 
			"Quantidade de vagas na disciplina: " + disciplina.getVagas());
		} else {
			System.out.println("No momento, não há vagas disponíveis nesta disciplina.");
		}
	}
	
	public void cancelarMatriculaEmDisciplina(Disciplina disciplina) {
		if (!disciplinas.isEmpty()) {
			disciplinas.remove(disciplina);
			disciplina.desocuparVaga();
			disciplina.removerAluno(this);
			System.out.println("Aluno removido da disciplina " + disciplina.getNome() + 
					           ". Quantidade de vagas na disciplina: " + disciplina.getVagas());
		} else {
			System.out.println("O aluno não está matriculado em nenhuma disciplina");
		}

	}
	
	public void listarDisciplinas() {
		System.out.println("Lista de disciplinas do aluno " + nome);
		for (Disciplina disciplina : disciplinas) {
			System.out.println("/Nome da disciplina: " + disciplina.getNome() + 
							  " /Id: " + disciplina.getId() +
							  " /Professor: " + disciplina.getProfessor().getNome());
		}
	}
	public ArrayList<Horario> getHorarios(){
		ArrayList<Horario> horarios = new ArrayList<>();
		for (Disciplina d : disciplinas) {
			horarios.addAll(d.getHorarios());
		}
		return horarios;
	}
	
    public void exibirHorarios() {
        System.out.println("Horários do aluno " + nome + ":");
        for (Disciplina d : disciplinas) {
            for (Horario h : d.getHorarios()) {
                System.out.println("- " + d.getNome() + ": " + h);
            }
        }
    }
}