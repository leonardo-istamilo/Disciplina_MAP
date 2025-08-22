package testes;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import controleAcademico.Aluno;
import controleAcademico.DiaSemana;
import controleAcademico.Disciplina;
import controleAcademico.Horario;
import controleAcademico.Professor;

public class AlunoTest {

	private Aluno aluno;
	private Disciplina disciplina1;
	private Disciplina disciplina2;
	private Disciplina disciplina3;
	private Professor professor;

	@BeforeEach
	public void setUp() {
		aluno = new Aluno("Joao", "12345", "Computacao", "Manha");
		professor = new Professor("Sabrina", "98765");

		disciplina1 = new Disciplina("MAP", "D1", "Manha");
		disciplina1.atribuirProf(professor);
		disciplina1.adicionarHorario(new Horario(DiaSemana.Segunda, 7, 9));

		disciplina2 = new Disciplina("ES2", "D2", "Manha");
		disciplina2.atribuirProf(professor);
		disciplina2.adicionarHorario(new Horario(DiaSemana.Terca, 9, 11));

		disciplina3 = new Disciplina("LF", "D3", "Manha");
		disciplina3.atribuirProf(professor);
		disciplina3.adicionarHorario(new Horario(DiaSemana.Segunda, 7, 9)); // Horario conflitante com disciplina1
	}

	@Test
	public void testMatricularEmDisciplinaComSucesso() {
		// Testa se a matrícula é feita com sucesso e as listas são atualizadas
		aluno.matricularEmDisciplina(disciplina1);
		assertEquals(1, aluno.getDisciplinas().size());
		assertTrue(aluno.getDisciplinas().contains(disciplina1));
		assertEquals(1, disciplina1.quantidadeAlunos());
		assertEquals(39, disciplina1.getVagas());
	}

	@Test
	public void testMatricularEmDisciplinaComConflitoDeHorario() {
		// Matricular o aluno na disciplina1 e depois tentar na disciplina3, que tem conflito de horário
		aluno.matricularEmDisciplina(disciplina1);
		aluno.matricularEmDisciplina(disciplina3);

		// O aluno deve permanecer matriculado apenas na primeira disciplina
		assertEquals(1, aluno.getDisciplinas().size());
		assertTrue(aluno.getDisciplinas().contains(disciplina1));
		assertFalse(aluno.getDisciplinas().contains(disciplina3));
	}

	@Test
	public void testMatricularEmDisciplinaSemVagas() {
		// Preencher as 40 vagas da disciplina1
		for (int i = 0; i < 40; i++) {
			Aluno tempAluno = new Aluno("Temp" + i, "Matricula" + i, "Curso", "Turno");
			tempAluno.matricularEmDisciplina(disciplina1);
		}

		// Tentar matricular o aluno de teste
		aluno.matricularEmDisciplina(disciplina1);

		// O aluno nao deve ser matriculado
		assertFalse(aluno.getDisciplinas().contains(disciplina1));
		assertEquals(0, disciplina1.getVagas());
		assertEquals(40, disciplina1.quantidadeAlunos());
	}

	@Test
	public void testCancelarMatricula() {
		// Matricular e depois cancelar a matricula
		aluno.matricularEmDisciplina(disciplina1);
		aluno.cancelarMatriculaEmDisciplina(disciplina1);

		assertTrue(aluno.getDisciplinas().isEmpty());
		assertEquals(0, disciplina1.quantidadeAlunos());
		assertEquals(40, disciplina1.getVagas());
	}
}