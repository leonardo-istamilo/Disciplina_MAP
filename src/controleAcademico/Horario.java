package controleAcademico;
import controleAcademico.DiaSemana;


public class Horario {

	private int horarioInicio;
	private int horarioFim;
	private DiaSemana diaSemana;

	public Horario(int horarioInicio, int horarioFim, DiaSemana diaSemana) {
		this.horarioInicio = horarioInicio;
		this.horarioFim = horarioFim;
		this.diaSemana = diaSemana;
	}

	public int getHorarioInicio() {
		return horarioInicio;
	}

	public void setHorarioInicio(int horarioInicio) {
		this.horarioInicio = horarioInicio;
	}

	public int getHorarioFim() {
		return horarioFim;
	}

	public void setHorarioFim(int horarioFim) {
		this.horarioFim = horarioFim;
	}

	public DiaSemana getDiaSemana() {
		return diaSemana;
	}

	public void setDiaSemana(DiaSemana diaSemana) {
		this.diaSemana = diaSemana;
	}
}
