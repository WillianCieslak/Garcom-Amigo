package com.cliente.pojo;

import java.io.Serializable;

public class Mesa implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3287671275285307825L;
	private int idMesa; //Codigo da Mesa (Autoincremental)
	private String dsMesa; //Descricao/Nome da Mesa
	private String ieStatus; //Status: U - Em uso, L - Livre
	
	public Mesa(){
		
	}
	
	public Mesa(int idMesa, String dsMesa, String ieStatus) {
		setIdMesa(idMesa);
		setDsMesa(dsMesa);
		setIeStatus(ieStatus);
	}

	public int getIdMesa() {
		return idMesa;
	}
	
	public void setIdMesa(int idMesa) {
		this.idMesa = idMesa;
	}
	
	public String getDsMesa() {
		return dsMesa;
	}
	
	public void setDsMesa(String dsMesa) {
		this.dsMesa = dsMesa;
	}
	
	public String getIeStatus() {
		return ieStatus;
	}
	
	public void setIeStatus(String ieStatus) {
		this.ieStatus = ieStatus;
	}

	@Override
	public String toString() {
		return dsMesa;
	}
	
	
}
