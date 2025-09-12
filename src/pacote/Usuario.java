package pacote;

import pacote.Passageiro;
import pacote.Motorista;
import pacote.Administrador;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Usuario {
	private String nome;
	private String cpf;
	private Passageiro passageiro;
	private Motorista motorista;
	private Administrador administrador;

	public Usuario(String nome, String cpf) {
		this.nome = nome;
		this.cpf = cpf;
	}

	public Passageiro tornarPassageiro() {
		if (this.passageiro == null) {
			this.passageiro = new Passageiro();
		}
		return this.passageiro;
	}

	public Motorista tornarMotorista() {
		if (this.motorista == null) {
			this.motorista = new Motorista();
		}
		return this.motorista;
	}

	public Administrador tornarAdministrador() {
		if (this.administrador == null) {
			this.administrador = new Administrador();
		}
		return this.administrador;
	}

	public void exibirFuncoes() {
		System.out.println("Funções de " + this.nome + ":");
		if (this.passageiro != null) {
			System.out.println("- Passageiro");
		}
		if (this.motorista != null) {
			System.out.println("- Motorista");
		}
		if (this.administrador != null) {
			System.out.println("- Administrador");
		}
	}

	public Passageiro getPassageiro() {
		return passageiro;
	}

	public Motorista getMotorista() {
		return motorista;
	}

	public Administrador getAdministrador() {
		return administrador;
	}

	public String getNome() {
		return nome;
	}

	public String getCpf() {
		return cpf;
	}
}
