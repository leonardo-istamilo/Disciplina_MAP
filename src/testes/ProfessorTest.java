package testes;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import controleAcademico.DiaSemana;
import controleAcademico.Disciplina;
import controleAcademico.Horario;
import controleAcademico.Professor;

import java.util.ArrayList;

public class ProfessorTest {

	private Professor professor;
	private Disciplina disciplina1;
	private Disciplina disciplina2;

	@BeforeEach
	public void setUp() {
		professor = new Professor("Sabrina", "98765");
		disciplina1 = new Disciplina("MAP", "D1", "Manha");
		disciplina2 = new Disciplina("ES2", "D2", "Manha");

		disciplina1.adicionarHorario(new Horario(DiaSemana.Segunda, 7, 9));
		disciplina2.adicionarHorario(new Horario(DiaSemana.Terca, 9, 11));

		professor.ministrarDisciplina(disciplina1);
		professor.ministrarDisciplina(disciplina2);
	}

	@Test
	public void testListarDisciplinas() {
		// Testa se o professor lista as disciplinas corretamente
		ArrayList<Disciplina> disciplinas = professor.getDisciplinas();
		assertEquals(2, disciplinas.size());
		assertTrue(disciplinas.contains(disciplina1));
		assertTrue(disciplinas.contains(disciplina2));
	}

	@Test
	public void testGetHorarios() {
		// Testa se o método retorna a lista de horários de todas as disciplinas
		ArrayList<Horario> horarios = professor.getHorarios();
		assertEquals(2, horarios.size());
		assertTrue(horarios.stream().anyMatch(h -> h.getDia() == DiaSemana.Segunda && h.getInicio() == 7));
		assertTrue(horarios.stream().anyMatch(h -> h.getDia() == DiaSemana.Terca && h.getInicio() == 9));
	}
}