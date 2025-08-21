package controleAcademico;

public class Horario {
    
	private DiaSemana dia;
    private int inicio;
    private int fim;

    public Horario(DiaSemana dia, int inicio, int fim) {
        this.dia = dia;
        this.inicio = inicio;
        this.fim = fim;
    }

    
    public DiaSemana getDia() {
        return dia;
    }


    // Método para verificar se dois horários se sobrepõem (útil para conflitos)
    public boolean conflitaCom(Horario outro) {
        if (this.dia != outro.dia) return false;
        return (this.inicio < outro.fim && outro.inicio < this.fim);
    }

    @Override
    public String toString() {
        return dia + " " + inicio + ":00- " + fim + ":00";
    }
}
