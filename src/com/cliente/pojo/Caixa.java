package com.cliente.pojo;

import java.util.ArrayList;

/**
 * 
 * @author Cristhian, Everton, Felipe, Mariana e Willian
 *
 */
public class Caixa {
	/**
	 * Propriedade conta
	 */
	private Conta conta;
	/**
	 * Propriedade pedidos
	 */
	private ArrayList<Pedido> pedidos = new ArrayList<Pedido>();
	/**
	 * Propriedade pagamentos
	 */
	private ArrayList<Pagamento> pagamentos = new ArrayList<Pagamento>();
	
	/**
	 * Contrutor da classe caixa
	 */
	public Caixa(){
		
	}
	
	/**
	 * Contrutor da classe caixa
	 * @param conta
	 * @param pedidos
	 * @param pagamentos
	 */
	public Caixa(Conta conta, ArrayList<Pedido> pedidos,
			ArrayList<Pagamento> pagamentos) {
		setConta(conta);
		setPedidos(pedidos);
		setPagamentos(pagamentos);
	}

	/**
	 * Método para busca a conta 
	 * @return Propriedade conta
	 */
	public Conta getConta() {
		return conta;
	}

	/**
	 * Método para setar a propriedade conta
	 * @param conta
	 */
	public void setConta(Conta conta) {
		this.conta = conta;
	}

	/**
	 * Método para buscar os pedidos
	 * @return Propriedade pedido
	 */
	public ArrayList<Pedido> getPedidos() {
		return pedidos;
	}

	/**
	 * Método para setar a propriedade pedidos
	 * @param pedidos
	 */
	public void setPedidos(ArrayList<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	/**
	 * Método para buscar os pagamentos
	 * @return Propriedade pagamentos
	 */
	public ArrayList<Pagamento> getPagamentos() {
		return pagamentos;
	}

	/**
	 * Método para setar a propriedade pagamentos
	 * @param pagamentos
	 */
	public void setPagamentos(ArrayList<Pagamento> pagamentos) {
		this.pagamentos = pagamentos;
	}
}
