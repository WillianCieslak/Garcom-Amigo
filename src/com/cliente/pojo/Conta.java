package com.cliente.pojo;

import java.io.Serializable;

public class Conta implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5604768325540110145L;
	private int idConta; //Codigo da Conta (Autoincremental)
	private String dtConta; //Data da criacao da Conta
	private String dtPagamento; //Data do Pagamento
	private double vlGasto; // Valor Total Gasto
	private double vlPago; //Valor Total Pago
	private double vlDesconto; //Valor do Desconto
	private Cliente cliente;//Cliente vinculado a conta
	
	public Conta(){
		
	}
	
	public Conta(int idConta, String dtConta, String dtPagamento,
			double vlGasto, double vlPago, double vlDesconto, Cliente cliente) {
		setIdConta(idConta);
		setDtConta(dtConta);
		setDtPagamento(dtPagamento);
		setVlGasto(vlGasto);
		setVlPago(vlPago);
		setVlDesconto(vlDesconto);
		setCliente(cliente);
	}

	public int getIdConta() {
		return idConta;
	}
	
	public void setIdConta(int idConta) {
		this.idConta = idConta;
	}
	
	public String getDtConta() {
		return dtConta;
	}
	
	public void setDtConta(String dtConta) {
		this.dtConta = dtConta;
	}
	
	public String getDtPagamento() {
		return dtPagamento;
	}
	
	public void setDtPagamento(String dtPagamento) {
		this.dtPagamento = dtPagamento;
	}
	
	public double getVlGasto() {
		return vlGasto;
	}
	
	public void setVlGasto(double vlGasto) {
		this.vlGasto = vlGasto;
	}
	
	public double getVlPago() {
		return vlPago;
	}
	
	public void setVlPago(double vlPago) {
		this.vlPago = vlPago;
	}
	
	public double getVlDesconto() {
		return vlDesconto;
	}
	
	public void setVlDesconto(double vlDesconto) {
		this.vlDesconto = vlDesconto;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}	
}
