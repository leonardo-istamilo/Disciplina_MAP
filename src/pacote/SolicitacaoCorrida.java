package pacote;

import java.time.LocalDateTime;

public class SolicitacaoCorrida {
    private String origem;
    private String destino;
    private LocalDateTime inicio, fim;
    private Usuario passageiro;
    private FormasPagamento formaPagamento;
    private double valor;
    private boolean aceita;

    public SolicitacaoCorrida(String origem, String destino, LocalDateTime inicio, LocalDateTime fim,
                              Usuario passageiro, FormasPagamento formaPagamento, double valor) {
        this.origem = origem;
        this.destino = destino;
        this.inicio = inicio;
        this.fim = null;
        this.passageiro = passageiro;
        this.formaPagamento = formaPagamento;
        this.valor = valor;
        this.aceita = false;
    }

    public Viagem aceitar(Usuario motorista, Veiculo veiculo) {
        aceita = true;
        System.out.println(motorista.getNome() + " aceitou a corrida");
        return new Viagem(origem, destino, inicio, fim, 
        		motorista, passageiro, veiculo, formaPagamento);
    }

    public boolean isAceita() {
        return aceita;
    }

    public String getResumo() {
        return String.format("Corrida pendente: %s → %s | Valor: R$%.2f | Passageiro: %s",
                origem, destino, valor, passageiro.getNome());
    }
}

