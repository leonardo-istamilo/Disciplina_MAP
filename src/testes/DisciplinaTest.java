package testes;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import controleAcademico.Aluno;
import controleAcademico.DiaSemana;
import controleAcademico.Disciplina;
import controleAcademico.Horario;
import controleAcademico.Professor;

public class DisciplinaTest {

	private Disciplina disciplina;
	private Professor professor;
	private Aluno aluno1;
	private Aluno aluno2;

	@BeforeEach
	public void setUp() {
		disciplina = new Disciplina("MAP", "D1", "Manha");
		professor = new Professor("Sabrina", "98765");
		aluno1 = new Aluno("Joao", "12345", "Computacao", "Manha");
		aluno2 = new Aluno("Maria", "54321", "Computacao", "Manha");
	}

	@Test
	public void testAtribuirProf() {
		// Testa se o professor é atribuído corretamente
		disciplina.atribuirProf(professor);
		assertEquals(professor, disciplina.getProfessor());
		// Testa se a disciplina é adicionada à lista do professor
		assertTrue(professor.getDisciplinas().contains(disciplina));
	}

	@Test
	public void testAdicionarAluno() {
		// Testa se o aluno é adicionado corretamente à disciplina
		disciplina.adicionarAluno(aluno1);
		assertEquals(1, disciplina.quantidadeAlunos());
		assertTrue(disciplina.getAlunos().contains(aluno1));
	}

	@Test
	public void testQuantidadeAlunos() {
		// Testa a contagem de alunos
		disciplina.adicionarAluno(aluno1);
		disciplina.adicionarAluno(aluno2);
		assertEquals(2, disciplina.quantidadeAlunos());
	}

	@Test
	public void testOcuparEDesocuparVaga() {
		// Testa a ocupação e desocupação de vagas
		int vagasIniciais = disciplina.getVagas();
		disciplina.ocuparVaga();
		assertEquals(vagasIniciais - 1, disciplina.getVagas());
		disciplina.desocuparVaga();
		assertEquals(vagasIniciais, disciplina.getVagas());
	}
}