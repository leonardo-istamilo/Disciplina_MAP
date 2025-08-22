package controleAcademico;

import java.util.Random;

public class Main {
		
	public static void main(String[] args) {
		
		//usado para geração aleatória de Id's e Matrículas -> String.valueOf(r.nextInt(100000000)
		Random r = new Random(); 
		
		//Criando professores
		Professor sabrina = new Professor("Sabrina", String.valueOf(r.nextInt(100000000)));
		Professor antonio = new Professor("Antônio", String.valueOf(r.nextInt(10000000)));
		Professor hugo = new Professor("Hugo", String.valueOf(r.nextInt(1000000000)));
		Professor hygor = new Professor("Hygor", String.valueOf(r.nextInt(100000000)));
		
		//Criando disciplinas e adicionando seus respectivos horários
		Disciplina map = new Disciplina("MAP", String.valueOf(r.nextInt(1000000)), "Manhã");
		map.adicionarHorario(new Horario(DiaSemana.Segunda, 7, 9));
		map.adicionarHorario(new Horario(DiaSemana.Sexta, 7, 9));
		
		Disciplina engSoft2 = new Disciplina("Engenharia de Software 2", String.valueOf(r.nextInt(100000000)), "Manhã");
		engSoft2.adicionarHorario(new Horario(DiaSemana.Sexta, 9, 11));
		
		Disciplina lingformais = new Disciplina("Linguagens Formais e Teoria da Computação", String.valueOf(r.nextInt(1000000)), "Manhã");
		lingformais.adicionarHorario(new Horario(DiaSemana.Quarta, 11, 13));
		lingformais.adicionarHorario(new Horario(DiaSemana.Sexta, 7, 9));
		
		Disciplina alglinear = new Disciplina("Álgebra Linear", String.valueOf(r.nextInt(1000000)), "Noite");
		alglinear.adicionarHorario(new Horario(DiaSemana.Terca, 18, 20));
		alglinear.adicionarHorario(new Horario(DiaSemana.Quarta, 18, 22));
	
		
		Disciplina c3 =  new Disciplina("Cálculo 3", String.valueOf(r.nextInt(1000000)), "Tarde");
		c3.adicionarHorario(new Horario(DiaSemana.Sexta, 14, 16));
		
		Disciplina vet = new Disciplina("Vetores", String.valueOf(r.nextInt(1000000)), "Tarde");
		vet.adicionarHorario(new Horario(DiaSemana.Quinta, 14, 16));
		vet.adicionarHorario(new Horario(DiaSemana.Sexta, 14,16));
		
		//Criando alunos e matriculando-os em disciplinas 
		Aluno pedro = new Aluno("Pedro", String.valueOf(r.nextInt(100000000)), "Computação", "Manhã");
		Aluno ana = new Aluno("Ana", String.valueOf(r.nextInt(100000000)), "Computação", "Manhã");
		Aluno miguel = new Aluno("Miguel", String.valueOf(r.nextInt(100000000)), "Computação", "Manhã");
		Aluno paulo = new Aluno("Paulo", String.valueOf(r.nextInt(100000000)), "Computação", "Manhã");
		Aluno diogo = new Aluno("Diogo", String.valueOf(r.nextInt(100000000)), "Computação", "Manhã");
		Aluno joao = new Aluno("João", String.valueOf(r.nextInt(100000000)), "Computação", "Manhã");
		Aluno jose = new Aluno("José", String.valueOf(r.nextInt(100000000)), "Computação", "Manhã");
		
		pedro.matricularEmDisciplina(map);
		ana.matricularEmDisciplina(map);
		ana.matricularEmDisciplina(alglinear);
		ana.matricularEmDisciplina(c3);
		miguel.matricularEmDisciplina(vet);
		paulo.matricularEmDisciplina(c3);
		diogo.matricularEmDisciplina(alglinear);
		joao.matricularEmDisciplina(engSoft2);
		jose.matricularEmDisciplina(map);
		
		System.out.println();
		
		ana.cancelarMatriculaEmDisciplina(map);
		
		System.out.println();
		
		// atribuindo professores às suas disciplinas
		
		map.atribuirProf(sabrina);
		engSoft2.atribuirProf(sabrina);
		vet.atribuirProf(hygor);
		alglinear.atribuirProf(hygor);
		lingformais.atribuirProf(antonio);
		c3.atribuirProf(hugo);

		//Questão 1 lab01
		System.out.println("\n---------");
		System.out.println("A) QUAIS DISCIPLINAS UM PROFESSOR ESTA MINISTRANDO?");

		hygor.listarDisciplinas();
		System.out.println();
		sabrina.listarDisciplinas();

		System.out.println("\n---------");
		System.out.println("B) QUAL O HORARIO DE UM PROFESSOR?");

		sabrina.exibirHorarios();
		System.out.println();
		antonio.exibirHorarios();
		System.out.println();
		hygor.exibirHorarios();

		System.out.println("\n---------");
		System.out.println("C) QUAIS OS ALUNOS DE UM DISCIPLINA?");
		
		map.listarAlunos();
		c3.listarAlunos();

		System.out.println("\n---------");
		System.out.println("D) QUAIS AS DISCIPLINAS DE UM ALUNO?");
		
		miguel.listarDisciplinas();

		System.out.println("\n---------");
		System.out.println("E) QUAL O HORARIO DE UM ALUNO?");

		joao.exibirHorarios();

		System.out.println("\n---------");
		System.out.println("F) QUAL O NUMERO DE ALUNOS DE UMA DISCIPLINA?\n");

		map.quantidade_alunos();
	}
}
