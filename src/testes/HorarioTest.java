package testes;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import controleAcademico.DiaSemana;
import controleAcademico.Horario;

public class HorarioTest {

	@Test
	public void testConflitoDeHorarioNoMesmoDia() {
		Horario h1 = new Horario(DiaSemana.Segunda, 8, 10);

		// Conflito total
		Horario h2 = new Horario(DiaSemana.Segunda, 8, 10);
		assertTrue(h1.conflitaCom(h2));

		// Conflito parcial (inicio de h3 dentro de h1)
		Horario h3 = new Horario(DiaSemana.Segunda, 9, 11);
		assertTrue(h1.conflitaCom(h3));

		// Conflito parcial (fim de h4 dentro de h1)
		Horario h4 = new Horario(DiaSemana.Segunda, 7, 9);
		assertTrue(h1.conflitaCom(h4));

		// Conflito (um horário contido no outro)
		Horario h5 = new Horario(DiaSemana.Segunda, 8, 9);
		assertTrue(h1.conflitaCom(h5));
	}

	@Test
	public void testSemConflitoDeHorarioNoMesmoDia() {
		Horario h1 = new Horario(DiaSemana.Quarta, 14, 16);

		// Horários adjacentes (sem conflito)
		Horario h2 = new Horario(DiaSemana.Quarta, 16, 18);
		assertFalse(h1.conflitaCom(h2));

		// Horários separados
		Horario h3 = new Horario(DiaSemana.Quarta, 18, 20);
		assertFalse(h1.conflitaCom(h3));
	}

	@Test
	public void testSemConflitoDeHorarioEmDiasDiferentes() {
		Horario h1 = new Horario(DiaSemana.Sexta, 7, 9);
		Horario h2 = new Horario(DiaSemana.Quarta, 7, 9);
		assertFalse(h1.conflitaCom(h2));
	}
}