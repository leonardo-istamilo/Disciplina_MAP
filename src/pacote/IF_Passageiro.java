package pacote;

import pacote.FormasPagamento;

public interface IF_Passageiro {
    String solicitarCorrida();
    boolean pagarCorrida();
    void adicionarFormaPagamento(FormasPagamento formaPagamento);
}
