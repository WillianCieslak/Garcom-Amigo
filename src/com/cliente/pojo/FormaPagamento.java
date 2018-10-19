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
	 * Propriedade idFormaPagto - C�digo da forma de pagamento
	 */
	private int idFormaPagto;
	/**
	 * Propriedade dsFormaPagto - Descri��o da forma de pagamento
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
	 * M�todo que retorna o ID da forma de pagamento
	 * @return idFormaPagto
	 */
	public int getIdFormaPagto() {
		return idFormaPagto;
	}

	/**
	 * M�todo para definir o valor do ID da forma de pagamento
	 * @param idFormaPagto
	 */
	public void setIdFormaPagto(int idFormaPagto) {
		this.idFormaPagto = idFormaPagto;
	}

	/**
	 * M�todo que retorna a descri��o da forma de pagamento
	 * @return dsFormaPagto
	 */
	public String getDsFormaPagto() {
		return dsFormaPagto;
	}

	/**
	 * M�todo para definir o valor da descri��o da forma de pagamento
	 * @param dsFormaPagto
	 */
	public void setDsFormaPagto(String dsFormaPagto) {
		this.dsFormaPagto = dsFormaPagto;
	}
}