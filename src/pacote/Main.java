package pacote;

public class Main {
	public static void main(String[] args) {
		
		CentralCorridas central = new CentralCorridas();
		
		//Criando usuários
		Usuario rui = new Usuario("Rui", "14560", 300);
		Usuario ana = new Usuario("Ana", "12057", 456);
		
		//Atribuindo papeis aos usuarios
		Motorista papelMotorista = new Motorista();
		Passageiro papelPassageiro = new Passageiro();
		Administrador papelAdmin = new Administrador();
		
		rui.addPapel(papelMotorista);
		rui.addPapel(papelAdmin);
		ana.addPapel(papelPassageiro);
		
		//Cadastrar veiculo para um usuario
		
		Veiculo carro = new Veiculo("Ferrari", "QFC-9802", "Azul");
		rui.getVeiculos().add(carro);
		
		//Cadastrar formas de pagamento para um usuario
		
		papelPassageiro.addFormaPagamento(FormasPagamento.CRÉDITO);
		papelPassageiro.addFormaPagamento(FormasPagamento.PIX);
			
		
		//Solicitar corrida para o usuario que foi definido como passageiro

	    Viagem viagem = papelPassageiro.solicitarCorrida(
	    		"Centro", "Aeroporto", FormasPagamento.DÉBITO,
	    		ana, rui, carro
	    );

	   //Registrar viagem com papel desempenhado
	    rui.addViagem(viagem, "Motorista");
	    ana.addViagem(viagem, "Passageiro");

	    //Exibir informações completas da viagem
	    viagem.exibirInformacoes();

	    //Exibir histórico de cada usuário ===
	    System.out.println("\n--- Histórico de Rui ---");
	    rui.exibirHistorico();

	    System.out.println("\n--- Histórico de Ana ---");
	    ana.exibirHistorico();

	    //Administrador visualiza dados dos usuários ===
	    System.out.println("\n--- Ações do Administrador ---");
	    papelAdmin.detalharUsuario(rui);
	    papelAdmin.detalharUsuario(ana);
	    papelAdmin.detalharViagem(viagem);

	    //Executar papéis dinamicamente ===
	    System.out.println("\n--- Executando papéis ---");
	    rui.executarPapeis();
	    ana.executarPapeis();

	}
}
