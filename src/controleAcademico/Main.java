package controleAcademico;

import controleAcademico.DiaSemana;
import controleAcademico.Aluno;
import controleAcademico.Professor;
import controleAcademico.Disciplina;
import controleAcademico.Horario;
import controleAcademico.ControleAcademico;
import controleAcademico.Instituicao;

import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        ControleAcademico controle = new ControleAcademico();
        Instituicao instituicao = new Instituicao();

        // 1. Criando e adicionando professores ao sistema (Padrão Creator)
        List<Professor> professores = instituicao.getProfessores();
        for (Professor professor : professores) {
            controle.adicionarProfessorSistema(professor);
        }

        // 2. Criando e adicionando alunos ao sistema (Padrão Creator)
        List<Aluno> alunos = instituicao.getAlunos();
        for (Aluno aluno : alunos) {
            controle.adicionarAlunoSistema(aluno);
        }

        // 3. Criando horários e disciplinas
        Horario h1 = instituicao.criarHorario(7, 9, DiaSemana.Segunda);
        Horario h2 = instituicao.criarHorario(9, 11, DiaSemana.Segunda);
        Horario h3 = instituicao.criarHorario(11, 13, DiaSemana.Segunda);
        Horario h4 = instituicao.criarHorario(14, 16, DiaSemana.Segunda);
        Horario h5 = instituicao.criarHorario(16, 18, DiaSemana.Segunda);

        // Criando as disciplinas
        Disciplina map = instituicao.criarDisciplina("Metódos Avançados de Programação", "LAB INFO III");
        Disciplina aps = instituicao.criarDisciplina("Análise e Projeto de Sistemas", "Sala C-107");
        Disciplina engSoft = instituicao.criarDisciplina("Engenharia de Software", "Sala 102");

        // Adicionando os horários às disciplinas
        map.adicionarHorario(h1);
        map.adicionarHorario(h2);
        aps.adicionarHorario(h2);
        engSoft.adicionarHorario(h3);

        // Acessando as instâncias para as operações
        Aluno pedro = alunos.get(0);
        Aluno miguel = alunos.get(2);
        Aluno diogo = alunos.get(4);
        Professor sabrina = professores.get(0);
        Professor daniel = professores.get(2);

        // 4. Matriculando Alunos em Disciplinas
        System.out.println("--- Operações de Matrícula ---");
        controle.adicionarAlunoDisciplina(pedro, map);
        controle.adicionarAlunoDisciplina(miguel, map);
        controle.adicionarAlunoDisciplina(pedro, aps);
        controle.adicionarAlunoDisciplina(diogo, engSoft);

        // 5. Atribuindo Professores a Disciplinas
        System.out.println("\n--- Operações de Vínculo de Professor ---");
        controle.adicionarProfessorDisciplina(sabrina, map);
        controle.adicionarProfessorDisciplina(daniel, aps);

        // 6. Consultas do laboratório 01
        System.out.println("\n---------");
        System.out.println("A) QUAIS DISCIPLINAS UM PROFESSOR ESTA MINISTRANDO?");
        List<Disciplina> disciplinasProfessor = controle.listarDisciplinasProfessores(sabrina);
        for (Disciplina disciplina : disciplinasProfessor) {
            System.out.println("  -> " + disciplina.getNome());
        }

        System.out.println("\n---------");
        System.out.println("B) QUAL O HORARIO DE UM PROFESSOR?");
        List<Horario> horarioProfessor = controle.listarHorarioProfessor(sabrina);
        for (Horario hr : horarioProfessor) {
            System.out.println("  -> " + hr.getHorarioInicio() + "-" + hr.getHorarioFim());
        }

        System.out.println("\n---------");
        System.out.println("C) QUAIS OS ALUNOS DE UMA DISCIPLINA?");
        List<Aluno> alunosMatriculados = controle.listarAlunosDisciplina(map);
        for (Aluno a : alunosMatriculados) {
            System.out.println("  -> " + a.getNome());
        }

        System.out.println("\n---------");
        System.out.println("D) QUAIS AS DISCIPLINAS DE UM ALUNO?");
        List<Disciplina> disciplinasAluno = controle.listarDisciplinasAluno(pedro);
        for (Disciplina disciplina : disciplinasAluno) {
            System.out.println("  -> " + disciplina.getNome());
        }

        System.out.println("\n---------");
        System.out.println("E) QUAL O HORARIO DE UM ALUNO?");
        List<Horario> horariosAluno = controle.listarHorarioAluno(pedro);
        for (Horario hr : horariosAluno) {
            System.out.println("  -> " + hr.getHorarioInicio() + "-" + hr.getHorarioFim());
        }

        System.out.println("\n---------");
        System.out.println("F) QUAL O NUMERO DE ALUNOS DE UMA DISCIPLINA?");
        System.out.println("  -> " + controle.quantidadeAlunosdisciplina(map));
    }
}