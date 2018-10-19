package com.cliente.pojo;

import java.io.Serializable;

public class Cartao implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6987402012627614321L;
	private int idCartao; //Codigo do Cartao (Autoincremental)
	private String dsCartao;//Descricao/Nome do Cartao
	private String ieStatus;//Status: U - Em uso, L - Livre, E - Extraviado
	
	public Cartao(){
		
	}
	
	public Cartao(int idCartao, String dsCartao, String ieStatus) {
		setIdCartao(idCartao);
		setDsCartao(dsCartao);
		setIeStatus(ieStatus);
	}

	public int getIdCartao() {
		return idCartao;
	}
	
	public void setIdCartao(int idCartao) {
		this.idCartao = idCartao;
	}
	
	public String getDsCartao() {
		return dsCartao;
	}
	
	public void setDsCartao(String dsCartao) {
		this.dsCartao = dsCartao;
	}
	
	public String getIeStatus() {
		return ieStatus;
	}
	
	public void setIeStatus(String ieStatus) {
		this.ieStatus = ieStatus;
	}
	
	public String getDsStatus(){
		if(getIeStatus() == null){
			return "Não informado";
		}
		switch(getIeStatus()){
		case "U": return "Em Uso";
		case "L": return "Livre";
		case "E": return "Extraviado";
		default: return "Nao Informado";
		}
	}
}
