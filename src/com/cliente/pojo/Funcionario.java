package com.cliente.pojo;

import java.io.Serializable;
import java.util.List;

public class Funcionario extends Pessoa implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3699731123973417325L;
	private List<Permissao> permissoes;
	private String dsPermissao;

	public Funcionario() {

	}

	public Funcionario(String nrCpf, String nmPessoa, String dtNascimento,
			String nrTelefone, String nrCelular, String dsEmail,
			String dsSenha, boolean ieAtivo) {
		super(nrCpf, nmPessoa, dtNascimento, nrTelefone, nrCelular, dsEmail,
				dsSenha, "F", ieAtivo);
	}

	public List<Permissao> getPermissoes() {
		return permissoes;
	}

	public void setPermissoes(List<Permissao> permissoes) {
		this.permissoes = permissoes;
	}

	public String getDsPermissao() {
		return dsPermissao;
	}

	public void setDsPermissao(String dsPermissao) {
		this.dsPermissao = dsPermissao;
	}
	
}