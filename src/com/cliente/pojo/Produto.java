package com.cliente.pojo;

import java.io.Serializable;

public class Produto implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8802635648477178680L;
	private int idProduto; //Codigo do produto
	private String dsProduto; //Descricao/Nome do produto
	private String ieDestino; //Destino: C - Cozinha, B - Bar
	private double vlProduto;//Valor unitario
	private String dsIngredientes;//Descricao dos ingredientes
	private String imProduto; //Endereco da imagem
	
	public Produto(){
		
	}
	
	public Produto(int idProduto, String dsProduto, String ieDestino,
			double vlProduto, String dsIngredientes, String imProduto) {
		setIdProduto(idProduto);
		setDsProduto(dsProduto);
		setIeDestino(ieDestino);
		setVlProduto(vlProduto);
		setDsIngredientes(dsIngredientes);
		setImProduto(imProduto);
	}

	public int getIdProduto() {
		return this.idProduto;
	}
	
	public void setIdProduto(int idProduto) {
		this.idProduto = idProduto;
	}
	
	public String getDsProduto() {
		return this.dsProduto;
	}
	
	public void setDsProduto(String dsProduto) {
		this.dsProduto = dsProduto;
	}
	
	public String getIeDestino() {
		return this.ieDestino;
	}
	
	public void setIeDestino(String ieDestino) {
		this.ieDestino = ieDestino;
	}
	
	public double getVlProduto() {
		return this.vlProduto;
	}
	
	public void setVlProduto(double vlProduto) {
		this.vlProduto = vlProduto;
	}
	
	public String getDsIngredientes() {
		return this.dsIngredientes;
	}
	
	public void setDsIngredientes(String dsIngredientes) {
		this.dsIngredientes = dsIngredientes;
	}

	public String getImProduto() {
		return this.imProduto;
	}
	
	public void setImProduto(String imProduto) {
		this.imProduto = imProduto;
	}
	
	public String getDsDestino(){
		if(getIeDestino() == null){
			return "Não informado";
		}
		switch(getIeDestino()){
		case "C": return "Cozinha";
		case "B": return "Bar";
		default: return "Não informado";
		}
	}

	@Override
	public String toString() {
		return dsProduto + " - " + "R$ "+ vlProduto;
	}
	
	
}
