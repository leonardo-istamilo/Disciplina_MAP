package testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import controleAcademico.Aluno;
import controleAcademico.ControleAcademico;
import controleAcademico.DiaSemana;
import controleAcademico.Disciplina;
import controleAcademico.Horario;
import controleAcademico.Instituicao;
import controleAcademico.Professor;

import java.util.List;

public class ControleAcademicoTest {

    private ControleAcademico controle;
    private Instituicao instituicao;
    private Aluno aluno1;
    private Aluno aluno2;
    private Professor professor1;
    private Professor professor2;
    private Disciplina disciplina1;
    private Disciplina disciplina2;
    private Disciplina disciplina3;
    private Horario horario1;
    private Horario horario2;
    private Horario horarioConflitante;

    @BeforeEach
    public void setUp() {
        controle = new ControleAcademico();
        instituicao = new Instituicao();

        // Obtendo as listas já criadas pela Instituicao
        List<Aluno> alunos = instituicao.getAlunos();
        List<Professor> professores = instituicao.getProfessores();
        List<Disciplina> disciplinas = instituicao.getDisciplinas();

        // Acessando as instâncias e atribuindo a variáveis de instância
        this.aluno1 = alunos.get(0);
        this.aluno2 = alunos.get(1);
        this.professor1 = professores.get(0);
        this.professor2 = professores.get(1);
        this.disciplina1 = disciplinas.get(0);
        this.disciplina2 = disciplinas.get(1);
        this.disciplina3 = disciplinas.get(2);

        // Adicionando os horários às disciplinas
        this.horario1 = instituicao.criarHorario(8, 10, DiaSemana.Segunda);
        this.horario2 = instituicao.criarHorario(10, 12, DiaSemana.Terca);
        this.horarioConflitante = instituicao.criarHorario(8, 10, DiaSemana.Segunda);
        disciplina1.adicionarHorario(horario1);
        disciplina2.adicionarHorario(horario2);
        disciplina3.adicionarHorario(horarioConflitante);

        // Adicionando as entidades ao Controle Academico
        controle.adicionarAlunoSistema(this.aluno1);
        controle.adicionarAlunoSistema(this.aluno2);
        controle.adicionarProfessorSistema(this.professor1);
        controle.adicionarProfessorSistema(this.professor2);
    }

    // --- Testes de Adição de Aluno em Disciplina ---

    @Test
    public void testAdicionarAlunoDisciplinaComSucesso() {
        controle.adicionarAlunoDisciplina(aluno1, disciplina1);
        assertEquals(1, controle.getAlunosDisciplinas().size());
    }

    @Test
    public void testAdicionarAlunoDisciplinaDuplicada() {
        controle.adicionarAlunoDisciplina(aluno1, disciplina1);
        controle.adicionarAlunoDisciplina(aluno1, disciplina1);
        assertEquals(1, controle.getAlunosDisciplinas().size());
    }

    @Test
    public void testAdicionarAlunoDisciplinaComConflitoDeHorario() {
        controle.adicionarAlunoDisciplina(aluno1, disciplina1);
        controle.adicionarAlunoDisciplina(aluno1, disciplina3);
        assertEquals(1, controle.getAlunosDisciplinas().size());
    }

    // --- Testes de Adição de Professor em Disciplina ---

    @Test
    public void testAdicionarProfessorDisciplinaComSucesso() {
        controle.adicionarProfessorDisciplina(professor1, disciplina1);
        assertEquals(1, controle.getProfessoresDisciplinas().size());
    }

    @Test
    public void testAdicionarProfessorDisciplinaDuplicada() {
        controle.adicionarProfessorDisciplina(professor1, disciplina1);
        controle.adicionarProfessorDisciplina(professor1, disciplina1);
        assertEquals(1, controle.getProfessoresDisciplinas().size());
    }

    @Test
    public void testAdicionarProfessorDisciplinaComConflitoDeHorario() {
        controle.adicionarProfessorDisciplina(professor1, disciplina1);
        controle.adicionarProfessorDisciplina(professor1, disciplina3);
        assertEquals(1, controle.getProfessoresDisciplinas().size());
    }

    // --- Testes de Remoção de Aluno do Sistema ---

    @Test
    public void testRemoverAlunoDoSistemaComSucesso() {
        controle.adicionarAlunoDisciplina(aluno1, disciplina1);
        assertEquals(1, controle.getAlunosDisciplinas().size());

        controle.removerAlunoDoSistema(aluno1);
        assertEquals(1, controle.getAlunos().size());
        assertTrue(controle.getAlunosDisciplinas().isEmpty());
    }

    @Test
    public void testRemoverAlunoDoSistemaInexistente() {
        int totalAlunos = controle.getAlunos().size();
        controle.removerAlunoDoSistema(new Aluno("Novo Aluno", "999"));
        assertEquals(totalAlunos, controle.getAlunos().size());
    }

    // --- Testes de Remoção de Professor do Sistema ---

    @Test
    public void testRemoverProfessorDoSistemaComSucesso() {
        controle.adicionarProfessorDisciplina(professor1, disciplina1);
        assertEquals(1, controle.getProfessoresDisciplinas().size());

        controle.removerProfessorDoSistema(professor1);
        assertEquals(1, controle.getProfessores().size());
        assertTrue(controle.getProfessoresDisciplinas().isEmpty());
    }
    @Test
    public void testRemoverProfessorDoSistemaInexistente() {
        int totalProfessores = controle.getProfessores().size();
        controle.removerProfessorDoSistema(new Professor("Novo Professor", "999"));
        assertEquals(totalProfessores, controle.getProfessores().size());
    }

    // --- Testes de Listagem e Contagem ---

    @Test
    public void testListarDisciplinasAluno_SemDisciplinas() {
        List<Disciplina> disciplinas = controle.listarDisciplinasAluno(aluno1);
        assertTrue(disciplinas.isEmpty());
    }

    @Test
    public void testListarDisciplinasAluno_ComDisciplinas() {
        controle.adicionarAlunoDisciplina(aluno1, disciplina1);
        controle.adicionarAlunoDisciplina(aluno1, disciplina2);
        List<Disciplina> disciplinas = controle.listarDisciplinasAluno(aluno1);
        assertEquals(2, disciplinas.size());
        assertTrue(disciplinas.contains(disciplina1));
        assertTrue(disciplinas.contains(disciplina2));
    }

    @Test
    public void testQuantidadeAlunosDisciplina_Vazia() {
        assertEquals(0, controle.quantidadeAlunosdisciplina(disciplina1));
    }

    @Test
    public void testQuantidadeAlunosDisciplina_ComAlunos() {
        controle.adicionarAlunoDisciplina(aluno1, disciplina1);
        controle.adicionarAlunoDisciplina(aluno2, disciplina1);
        assertEquals(2, controle.quantidadeAlunosdisciplina(disciplina1));
    }

    // ---  Testes para a classe Horario ---

    @Test
    public void testHorarioConflitaCom_HorariosAdjacentes() {
        Horario h_final_1 = new Horario(12, 14, DiaSemana.Segunda);
        assertFalse(horario2.conflitaCom(h_final_1));
    }

    @Test
    public void testHorarioConflitaCom_HorariosNaoSobrepostos() {
        Horario h_sem_conflito = new Horario(14, 16, DiaSemana.Segunda);
        assertFalse(horario1.conflitaCom(h_sem_conflito));
    }
}