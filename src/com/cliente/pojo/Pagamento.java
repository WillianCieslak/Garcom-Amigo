package com.cliente.pojo;

import java.io.Serializable;

public class Pagamento implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8121438946953845663L;
	private int idPagamento; //Codigo do pagamento (Autoincremental)
	private String dtPagamento; //Data do pagamento
	private int nrFormaPagamento;//Forma de pagamento: 1 - Dinheiro, 2 - Cartão Debito, 3 - Cartao Credito
	private double vlPagamento; //Valor pago
	private Conta conta;//Conta vinculada ao pagamento
	
	public Pagamento(){
		
	}
	
	public Pagamento(int idPagamento, String dtPagamento, int nrFormaPagamento,
			double vlPagamento, Conta conta) {
		setIdPagamento(idPagamento);
		setDtPagamento(dtPagamento);
		setNrFormaPagamento(nrFormaPagamento);
		setVlPagamento(vlPagamento);
		setConta(conta);
	}

	public int getIdPagamento() {
		return idPagamento;
	}
	
	public void setIdPagamento(int idPagamento) {
		this.idPagamento = idPagamento;
	}
	
	public String getDtPagamento() {
		return dtPagamento;
	}
	
	public void setDtPagamento(String dtPagamento) {
		this.dtPagamento = dtPagamento;
	}
	
	public int getNrFormaPagamento() {
		return nrFormaPagamento;
	}
	
	public void setNrFormaPagamento(int nrFormaPagamento) {
		this.nrFormaPagamento = nrFormaPagamento;
	}
	
	public double getVlPagamento() {
		return vlPagamento;
	}
	
	public void setVlPagamento(double vlPagamento) {
		this.vlPagamento = vlPagamento;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}	
}
