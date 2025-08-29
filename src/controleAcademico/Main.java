package controleAcademico;

import controleAcademico.DiaSemana;
import controleAcademico.Aluno;
import controleAcademico.Professor;
import controleAcademico.Disciplina;
import controleAcademico.Horario;

import controleAcademico.AlunoDisciplina;
import controleAcademico.ProfessorDisciplina;
import controleAcademico.ControleAcademico;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        //usado para geração aleatória de Id's e Matrículas -> String.valueOf(r.nextInt(100000000)
        Random r = new Random();

        ControleAcademico controle = new ControleAcademico();

        //Criando professores
        Professor sabrina = new Professor("Sabrina", String.valueOf(r.nextInt(100000000)));
        Professor antonio = new Professor("Antônio", String.valueOf(r.nextInt(10000000)));
        Professor daniel = new Professor("daniel", String.valueOf(r.nextInt(1000000000)));

        // Adicionando professores ao sistema
        controle.adicionarProfessorSistema(sabrina);
        controle.adicionarProfessorSistema(antonio);
        controle.adicionarProfessorSistema(daniel);


        //Criando alunos
        Aluno pedro = new Aluno("Pedro", String.valueOf(r.nextInt(100000000)));
        Aluno ana = new Aluno("Ana", String.valueOf(r.nextInt(100000000)));
        Aluno miguel = new Aluno("Miguel", String.valueOf(r.nextInt(100000000)));
        Aluno paulo = new Aluno("Paulo", String.valueOf(r.nextInt(100000000)));
        Aluno diogo = new Aluno("Diogo", String.valueOf(r.nextInt(100000000)));
        Aluno joao = new Aluno("João", String.valueOf(r.nextInt(100000000)));
        Aluno jose = new Aluno("José", String.valueOf(r.nextInt(100000000)));

        // Adicionando professores ao sistema
        controle.adicionarAlunoSistema(pedro);
        controle.adicionarAlunoSistema(ana);
        controle.adicionarAlunoSistema(miguel);
        controle.adicionarAlunoSistema(paulo);
        controle.adicionarAlunoSistema(diogo);
        controle.adicionarAlunoSistema(joao);
        controle.adicionarAlunoSistema(jose);

        //Criando horarios
        Horario h1 = new Horario(7,9, DiaSemana.Segunda);
        Horario h2 = new Horario(9,11, DiaSemana.Segunda);
        Horario h3 = new Horario(11,13, DiaSemana.Segunda);
        Horario h4 = new Horario(14,16, DiaSemana.Segunda);
        Horario h5 = new Horario(16,18, DiaSemana.Segunda);

        //Criando disciplinas
        Disciplina map = new Disciplina(String.valueOf(r.nextInt(10000)), "Metódos Avançados de Programação", "LAB INFO III - Central de Integração Acadêmica Paulo Freire");
        Disciplina aps = new Disciplina(String.valueOf(r.nextInt(10000)), "Análise e Projeto de Sistemas", "Sala C-107 - CCT");
        Disciplina engSoft = new Disciplina("ENGSOFT", "Engenharia de Software", "Sala 102");



        // Matriculando Alunos em Disciplinas
        controle.adicionarAlunoDisciplina(pedro, map, h1);
        controle.adicionarAlunoDisciplina(miguel, map, h2);
        controle.adicionarAlunoDisciplina(pedro, aps, h2);
        controle.adicionarAlunoDisciplina(diogo, engSoft, h3);

        // Atribuindo Professores a Disciplinas
        controle.adicionarProfessorDisciplina(sabrina, map, h1);
        controle.adicionarProfessorDisciplina(daniel, aps, h2);


        //Questão 1 lab01
        System.out.println("\n---------");
        System.out.println("A) QUAIS DISCIPLINAS UM PROFESSOR ESTA MINISTRANDO?");

        List<Disciplina> disciplinasProfessor = controle.listarDisciplinasProfessores(sabrina);
        for (Disciplina disciplina : disciplinasProfessor) {
            System.out.println("  -> "+disciplina.getNome());
        }

        System.out.println("\n---------");
        System.out.println("B) QUAL O HORARIO DE UM PROFESSOR?");

        List<Horario> horarioProfessor = controle.listarHorarioProfessor(sabrina);
        for (Horario hr : horarioProfessor) {
            System.out.println("  -> "+hr.getHorarioInicio()+"-"+hr.getHorarioFim());
        }

        System.out.println("\n---------");
        System.out.println("C) QUAIS OS ALUNOS DE UM DISCIPLINA?");

        List<Aluno> alunos = controle.listarAlunosDisciplina(map);
        for (Aluno a : alunos) {
            System.out.println("  -> "+a.getNome());
        }


        System.out.println("\n---------");
        System.out.println("D) QUAIS AS DISCIPLINAS DE UM ALUNO?");

        List<Disciplina> disciplinas = controle.listarDisciplinasAluno(pedro);
        for (Disciplina disciplina : disciplinas) {
            System.out.println("  -> "+disciplina.getNome());
        }

        System.out.println("\n---------");
        System.out.println("E) QUAL O HORARIO DE UM ALUNO?");

        List<Horario> horarios = controle.listarHorarioAluno(pedro);
        for (Horario hr : horarios) {
            System.out.println("  -> "+hr.getHorarioInicio()+"-"+hr.getHorarioFim());
        }


        System.out.println("\n---------");
        System.out.println("F) QUAL O NUMERO DE ALUNOS DE UMA DISCIPLINA?");
        System.out.println("  -> "+controle.quantidadeAlunosdisciplina(map));

    }
}
