package com.cliente.pojo;

import java.io.Serializable;

public class Cliente extends Pessoa implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 726645139450104332L;

	public Cliente(){
		
	}
	
	public Cliente(String nrCpf){
		super(nrCpf);
	}
	
	public Cliente(String nrCpf, String nmPessoa, String dtNascimento,
			String nrTelefone, String nrCelular, String dsEmail, String dsSenha, boolean ieAtivo) {
		super(nrCpf, nmPessoa, dtNascimento, nrTelefone, nrCelular, dsEmail, dsSenha, "C", ieAtivo);
	}

		@Override
	public String toString() {
		return getNmPessoa() + " - CPF: " + getNrCpf();
	}
}
