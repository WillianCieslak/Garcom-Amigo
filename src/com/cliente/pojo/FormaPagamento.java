package com.cliente.pojo;

import java.io.Serializable;

/**
 * Classe modelo de formas de pagamentos
 * @author Cristhian, Everton, Felipe, Mariana e Willian
 *
 */
public class FormaPagamento implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2120271058978331601L;
	/**
	 * Propriedade idFormaPagto - Código da forma de pagamento
	 */
	private int idFormaPagto;
	/**
	 * Propriedade dsFormaPagto - Descrição da forma de pagamento
	 */
	private String dsFormaPagto;
	
	/**
	 * Construtor da forma de pagamento
	 */
	public FormaPagamento(){
		
	}
	
	/**
	 * Construtor da forma de pagamento
	 * @param idFormaPagto
	 * @param dsFormaPagto
	 */
	public FormaPagamento(int idFormaPagto, String dsFormaPagto) {
		setIdFormaPagto(idFormaPagto);
		setDsFormaPagto(dsFormaPagto);
	}

	/**
	 * Método que retorna o ID da forma de pagamento
	 * @return idFormaPagto
	 */
	public int getIdFormaPagto() {
		return idFormaPagto;
	}

	/**
	 * Método para definir o valor do ID da forma de pagamento
	 * @param idFormaPagto
	 */
	public void setIdFormaPagto(int idFormaPagto) {
		this.idFormaPagto = idFormaPagto;
	}

	/**
	 * Método que retorna a descrição da forma de pagamento
	 * @return dsFormaPagto
	 */
	public String getDsFormaPagto() {
		return dsFormaPagto;
	}

	/**
	 * Método para definir o valor da descrição da forma de pagamento
	 * @param dsFormaPagto
	 */
	public void setDsFormaPagto(String dsFormaPagto) {
		this.dsFormaPagto = dsFormaPagto;
	}
}