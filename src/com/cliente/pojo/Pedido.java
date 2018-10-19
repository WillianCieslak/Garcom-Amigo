package com.cliente.pojo;

import java.io.Serializable;

public class Pedido implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6746827071529732669L;
	private int idPedido; //Codigo do pedido (Autoincremental)
	private String dtPedido; //Data do pedido
	private String iePedido; //Status: E - Entregue, P - Pendente, A - Andamento, N - Nao disponivel
	private double qtPedido;//Quantidade de itens
	private double vlPedido;//Valor Unitário do item
	private Funcionario funcionario;//Funcionario que fez o pedigo (Garcom)
	private Produto produto;//Produto solicitado no pedido
	private Conta conta;//Conta vinculada ao pedido
	private Mesa mesa;
	
	public Pedido(){
		
	}
	
	public Pedido(int idPedido, String dtPedido, String iePedido,
			double qtPedido, double vlPedido, Funcionario funcionario, Produto produto,
			Conta conta, Mesa mesa) {
		setIdPedido(idPedido);
		setDtPedido(dtPedido);
		setIePedido(iePedido);
		setQtPedido(qtPedido);
		setFuncionario(funcionario);
		setProduto(produto);
		setConta(conta);
		setMesa(mesa);
		setVlPedido(vlPedido);
	}


	public int getIdPedido() {
		return idPedido;
	}
	
	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}
	
	public String getDtPedido() {
		return dtPedido;
	}
	
	public void setDtPedido(String dtPedido) {
		this.dtPedido = dtPedido;
	}
	
	public String getIePedido() {
		return iePedido;
	}
	
	public void setIePedido(String iePedido) {
		this.iePedido = iePedido;
	}
	
	public double getQtPedido() {
		return qtPedido;
	}
	
	public void setQtPedido(double qtPedido) {
		this.qtPedido = qtPedido;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}	

	public Mesa getMesa() {
		return this.mesa;
	}

	public void setMesa(Mesa mesa) {
		this.mesa = mesa;
	}

	public double getVlPedido() {
		return vlPedido;
	}

	public void setVlPedido(double vlPedido) {
		this.vlPedido = vlPedido;
	}
	
	public double getTotal(){
		return getQtPedido() * getVlPedido();
	}
}
