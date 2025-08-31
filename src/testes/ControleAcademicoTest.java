package testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import controleAcademico.Aluno;
import controleAcademico.ControleAcademico;
import controleAcademico.DiaSemana;
import controleAcademico.Disciplina;
import controleAcademico.Horario;
import controleAcademico.Professor;

import java.util.List;

public class ControleAcademicoTest {

    private ControleAcademico controle;
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
        aluno1 = new Aluno("Pedro", "123");
        aluno2 = new Aluno("Ana", "456");
        professor1 = new Professor("Sabrina", "P1");
        professor2 = new Professor("Antonio", "P2");
        disciplina1 = new Disciplina("MAP", "Métodos", "Lab");
        disciplina2 = new Disciplina("ES2", "Engenharia", "Sala");
        disciplina3 = new Disciplina("FPOO", "Fundamentos", "Lab");
        horario1 = new Horario(8, 10, DiaSemana.Segunda);
        horario2 = new Horario(10, 12, DiaSemana.Terca);
        horarioConflitante = new Horario(8, 10, DiaSemana.Segunda);

        // Adicionando horários às disciplinas
        disciplina1.adicionarHorario(horario1);
        disciplina2.adicionarHorario(horario2);
        disciplina3.adicionarHorario(horarioConflitante);

        // Adicionando entidades ao sistema
        controle.getAlunos().add(aluno1);
        controle.getAlunos().add(aluno2);
        controle.getProfessores().add(professor1);
        controle.getProfessores().add(professor2);
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
        controle.adicionarAlunoDisciplina(aluno1, disciplina1); // Tentativa de duplicar
        assertEquals(1, controle.getAlunosDisciplinas().size());
    }

    @Test
    public void testAdicionarAlunoDisciplinaComConflitoDeHorario() {
        controle.adicionarAlunoDisciplina(aluno1, disciplina1); // Matrícula com sucesso
        controle.adicionarAlunoDisciplina(aluno1, disciplina3); // Tentativa com conflito
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
        controle.adicionarProfessorDisciplina(professor1, disciplina1); // Tentativa de duplicar
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
        assertEquals(1, controle.getAlunos().size()); // aluno2 ainda existe
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
    public void testRemoverProfessorDoSistemaComSucesso()
    {
        controle.adicionarProfessorDisciplina(professor1, disciplina1);
        assertEquals(1, controle.getProfessoresDisciplinas().size());

        controle.removerProfessorDoSistema(professor1);
        assertEquals(1, controle.getProfessores().size()); // professor2 ainda existe
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
