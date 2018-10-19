package com.cliente.pojo;

import java.io.Serializable;

/**
 * 
 * @author Cristhian, Everton, Felipe, Mariana e William
 *
 */

public class Permissao implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 9097125587506716229L;
	/**
	 * Propriedade id permissão
	 */
	private int idPermissao;
	/**
	 * Propriedade descrição da permissão
	 */
	private String dsPermissao;
	/**
	 * Propriedade cliente da permissão
	 */
	private Cliente cliente;
	
	/**
	 * Propriedade funcionario da permissao
	 */
	private Funcionario funcionario;
	
	/**
	 * Construtor vazio de Permissao
	 */
	public Permissao(){
		
	}

	/**
	 * Construtor de Permissao com Cliente 
	 * @param idPermissao (int)
	 * @param dsPermissao (String)
	 * @param cliente (Cliente)
	 */
	public Permissao(int idPermissao, String dsPermissao, Cliente cliente) {
		setIdPermissao(idPermissao);
		setDsPermissao(dsPermissao);
		setCliente(cliente);
	}
	
	public Permissao(int idPermissao, String dsPermissao, Funcionario funcionario) {
		setIdPermissao(idPermissao);
		setDsPermissao(dsPermissao);
		setFuncionario(funcionario);
	}

	public int getIdPermissao() {
		return idPermissao;
	}

	public void setIdPermissao(int idPermissao) {
		this.idPermissao = idPermissao;
	}

	public String getDsPermissao() {
		return dsPermissao;
	}

	public void setDsPermissao(String dsPermissao) {
		this.dsPermissao = dsPermissao;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
}
