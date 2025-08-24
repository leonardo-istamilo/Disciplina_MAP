package controleAcademico;
import controleAcademico.DiaSemana;


public class Horario {

	private int horario;
	private DiaSemana diaSemana;

	public Horario(int horario, DiaSemana diaSemana) {
		this.horario = horario;
		this.diaSemana = diaSemana;
	}

	public int getHorario() {
		return horario;
	}

	public void setHorario(int horario) {
		this.horario = horario;
	}

	public DiaSemana getDiaSemana() {
		return diaSemana;
	}

	public void setDiaSemana(DiaSemana diaSemana) {
		this.diaSemana = diaSemana;
	}
}
