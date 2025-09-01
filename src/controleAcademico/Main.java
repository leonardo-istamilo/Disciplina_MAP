package controleAcademico;

import controleAcademico.DiaSemana;
import controleAcademico.Aluno;
import controleAcademico.Professor;
import controleAcademico.Disciplina;
import controleAcademico.Horario;

import controleAcademico.ControleAcademico;
import controleAcademico.Instituicao;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        ControleAcademico controle = new ControleAcademico();
        Instituicao instituicao = new Instituicao();

        // 1. Criando e adicionando professores ao sistema com a Instituicao
        List<Professor> professores = instituicao.getProfessores();
        for (Professor professor : professores) {
            controle.adicionarProfessorSistema(professor);
        }

        // 2. Criando e adicionando alunos ao sistema com a Instituicao
        List<Aluno> alunos = instituicao.getAlunos();
        for (Aluno aluno : alunos) {
            controle.adicionarAlunoSistema(aluno);
        }

        // 3. Obtendo as disciplinas já criadas e com horários definidos
        List<Disciplina> disciplinas = instituicao.getDisciplinas();

        // Acessando as instâncias para as operações
        Aluno pedro = alunos.get(0);
        Aluno ana = alunos.get(1);
        Aluno miguel = alunos.get(2);
        Aluno diogo = alunos.get(3);
        Professor sabrina = professores.get(0);
        Professor daniel = professores.get(2);

        Disciplina map = disciplinas.get(0);
        Disciplina aps = disciplinas.get(1);
        Disciplina engSoft = disciplinas.get(2);

        // 4. Matriculando Alunos em Disciplinas
        System.out.println("\n--- Operações de Matrícula ---");
        controle.adicionarAlunoDisciplina(pedro, map);
        controle.adicionarAlunoDisciplina(miguel, map);
        controle.adicionarAlunoDisciplina(pedro, aps);
        controle.adicionarAlunoDisciplina(diogo, engSoft);

        // 5. Atribuindo Professores a Disciplinas
        System.out.println("\n--- Operações de Vínculo de Professor ---");
        controle.adicionarProfessorDisciplina(sabrina, map);
        controle.adicionarProfessorDisciplina(sabrina, aps); // Matrícula duplicada
        controle.adicionarProfessorDisciplina(sabrina, engSoft);

        // 6. Consultas do laboratório 01
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

        List<Aluno> listAlunos = controle.listarAlunosDisciplina(map);
        for (Aluno alun : listAlunos) {
            System.out.println("  -> "+alun.getNome());
        }


        System.out.println("\n---------");
        System.out.println("D) QUAIS AS DISCIPLINAS DE UM ALUNO?");

        List<Disciplina> listDisciplinas = controle.listarDisciplinasAluno(ana);
        for (Disciplina disciplina : listDisciplinas) {
            System.out.println("  -> "+disciplina.getNome());
        }

        System.out.println("\n---------");
        System.out.println("E) QUAL O HORARIO DE UM ALUNO?");

        List<Horario> horarios = controle.listarHorarioAluno(ana);
        for (Horario hr : horarios) {
            System.out.println("  -> "+hr.getHorarioInicio()+"-"+hr.getHorarioFim());
        }


        System.out.println("\n---------");
        System.out.println("F) QUAL O NUMERO DE ALUNOS DE UMA DISCIPLINA?");
        System.out.println("  -> "+controle.quantidadeAlunosdisciplina(map));

    }
}