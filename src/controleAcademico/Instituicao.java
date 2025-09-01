package controleAcademico;

import controleAcademico.Aluno;
import controleAcademico.Professor;
import controleAcademico.Disciplina;
import controleAcademico.Horario;
import controleAcademico.DiaSemana;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Instituicao {

    private List<Aluno> alunos = new ArrayList<>();
    private List<Professor> professores = new ArrayList<>();
    private List<Disciplina> disciplinas = new ArrayList<>();
    private Random r = new Random();

    public Instituicao() {
        // Inicializa as listas e as preenche
        this.alunos.addAll(criarAlunosBase());
        this.professores.addAll(criarProfessoresBase());
        this.disciplinas.addAll(criarDisciplinasBase());
    }

    private List<Aluno> criarAlunosBase() {
        List<Aluno> listaAlunos = new ArrayList<>();
        listaAlunos.add(new Aluno("Pedro", String.valueOf(r.nextInt(100000000))));
        listaAlunos.add(new Aluno("Ana", String.valueOf(r.nextInt(100000000))));
        listaAlunos.add(new Aluno("Miguel", String.valueOf(r.nextInt(100000000))));
        listaAlunos.add(new Aluno("Paulo", String.valueOf(r.nextInt(100000000))));
        listaAlunos.add(new Aluno("Diogo", String.valueOf(r.nextInt(100000000))));
        listaAlunos.add(new Aluno("João", String.valueOf(r.nextInt(100000000))));
        listaAlunos.add(new Aluno("José", String.valueOf(r.nextInt(100000000))));
        return listaAlunos;
    }

    private List<Professor> criarProfessoresBase() {
        List<Professor> listaProfessores = new ArrayList<>();
        listaProfessores.add(new Professor("Sabrina", String.valueOf(r.nextInt(100000000))));
        listaProfessores.add(new Professor("Antônio", String.valueOf(r.nextInt(10000000))));
        listaProfessores.add(new Professor("Daniel", String.valueOf(r.nextInt(1000000000))));
        return listaProfessores;
    }

    private List<Disciplina> criarDisciplinasBase() {
        List<Disciplina> listaDisciplinas = new ArrayList<>();
        listaDisciplinas.add(new Disciplina(String.valueOf(r.nextInt(10000)), "Metódos Avançados de Programação", "LAB INFO III"));
        listaDisciplinas.add(new Disciplina(String.valueOf(r.nextInt(10000)), "Análise e Projeto de Sistemas", "Sala C-107"));
        listaDisciplinas.add(new Disciplina("ENGSOFT", "Engenharia de Software", "Sala 102"));
        return listaDisciplinas;
    }

    // Retorna um objeto aluno individual
    public Aluno criarAluno(String nome) {
        Aluno novoAluno = new Aluno(nome, String.valueOf(r.nextInt(100000000)));
        alunos.add(novoAluno);
        return novoAluno;
    }

    // Retorna um objeto professor individual
    public Professor criarProfessor(String nome) {
        Professor novoProfessor = new Professor(nome, String.valueOf(r.nextInt(100000000)));
        professores.add(novoProfessor);
        return novoProfessor;
    }

    // Retorna um objeto disciplina individual
    public Disciplina criarDisciplina(String nome, String sala) {
        Disciplina novaDisciplina = new Disciplina(String.valueOf(r.nextInt(10000)), nome, sala);
        disciplinas.add(novaDisciplina);
        return novaDisciplina;
    }
    // Método adicionado para criar um Horario
    public Horario criarHorario(int inicio, int fim, DiaSemana dia) {
        return new Horario(inicio, fim, dia);
    }

    // Método para associar um horário a uma disciplina
    public void definirHorarioParaDisciplina(Disciplina disciplina, Horario horario) {
        disciplina.adicionarHorario(horario);
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public List<Professor> getProfessores() {
        return professores;
    }

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }
}