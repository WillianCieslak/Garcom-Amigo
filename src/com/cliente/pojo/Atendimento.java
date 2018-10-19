package com.cliente.pojo;

import java.io.Serializable;

public class Atendimento implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8213442581718157564L;
	private int idAtendimento; //Codigo do Atendimento (Autoincremental)
	private String dtAtendimento; //Data do atendimento
	private String dtDevolucao; //Data da devolução do Cartao
	private String ieDevolucao; //Tipo de Devolucao: P - Pago, R - Roubo, E - Extravio
	private Cartao cartao;//Cartão a ser atribuido
	private Conta conta;//Conta a ser vinculada
	
	public Atendimento(){
		
	}
	
	public Atendimento(int idAtendimento, String dtAtendimento,
			String dtDevolucao, String ieDevolucao, Cartao cartao, Conta conta) {
		setIdAtendimento(idAtendimento);
		setDtAtendimento(dtAtendimento);
		setDtDevolucao(dtDevolucao);
		setIeDevolucao(ieDevolucao);
		setCartao(cartao);
		setConta(conta);
	}

	public int getIdAtendimento() {
		return idAtendimento;
	}
	
	public void setIdAtendimento(int idAtendimento) {
		this.idAtendimento = idAtendimento;
	}
	
	public String getDtAtendimento() {
		return dtAtendimento;
	}
	
	public void setDtAtendimento(String dtAtendimento) {
		this.dtAtendimento = dtAtendimento;
	}
	
	public String getDtDevolucao() {
		return dtDevolucao;
	}
	
	public void setDtDevolucao(String dtDevolucao) {
		this.dtDevolucao = dtDevolucao;
	}
	
	public String getIeDevolucao() {
		return ieDevolucao;
	}
	
	public void setIeDevolucao(String ieDevolucao) {
		this.ieDevolucao = ieDevolucao;
	}

	public Cartao getCartao() {
		return cartao;
	}

	public void setCartao(Cartao cartao) {
		this.cartao = cartao;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}
}
