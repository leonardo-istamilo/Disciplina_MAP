package controleAcademico;

import java.util.ArrayList;

public class Professor {
	
	private String nome, matricula;
	private ArrayList<Disciplina> disciplinas;
	
	public Professor(String nome, String matricula) {
		this.nome = nome;
		this.matricula = matricula;
		this.disciplinas = new ArrayList<>();
	}

	public String getNome() {
		return nome;
	}

	public String getMatricula() {
		return matricula;
	}
	
	public ArrayList<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(ArrayList<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}
	
	public void ministrarDisciplina(Disciplina disciplina) {
		if (!disciplinas.contains(disciplina)) {
			disciplinas.add(disciplina);
		}
	}
	
	public void listarDisciplinas() {
		System.out.println("Disciplinas ministradas por Prof(a)." + nome + ":");
		for (Disciplina disciplina : disciplinas) {
			System.out.println("- " + disciplina.getNome());
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
        System.out.println("Horários do(a) professor(a) " + nome + ":");
        for (Disciplina d : disciplinas) {
            for (Horario h : d.getHorarios()) {
                System.out.println("- " + d.getNome() + ": " + h);
            }
        }
    }
}
