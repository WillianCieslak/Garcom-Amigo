package com.cliente.pojo;

import java.io.Serializable;

public class Pessoa implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6550112457412285611L;
	private String nrCpf; //id da pessoa (CPF)
	private String nmPessoa; //Nome da pessoa
	private String dtNascimento; //Data de nascimento
	private String nrTelefone; //Numero de telefone
	private String nrCelular; //Numero do celular
	private String dsEmail; //Endereco de Email
	private String dsSenha; //Senha da pessoa
	private String ieTipoPessoa; //Tipo de Pessoa: C - Cliente; F - Funcionário
	private boolean ieAtivo; //Flag se ativo
	
	public Pessoa(){
		
	}
	
	public Pessoa(String nrCpf){
		setNrCpf(nrCpf);
	}
	
	public Pessoa(String nrCpf, String nmPessoa, String dtNascimento,
			String nrTelefone, String nrCelular, String dsEmail, String dsSenha, String ieTipoPessoa, boolean ieAtivo) {
		setNrCpf(nrCpf);
		setNmPessoa(nmPessoa);
		setDtNascimento(dtNascimento);
		setNrTelefone(nrTelefone);
		setNrCelular(nrCelular);
		setDsEmail(dsEmail);
		setDsSenha(dsSenha);
		setIeTipoPessoa(ieTipoPessoa);
		setIeAtivo(ieAtivo);
	}

	public String getNrCpf() {
		return nrCpf;
	}
	
	public void setNrCpf(String nrCpf) {
		this.nrCpf = nrCpf;
	}
	
	public String getNmPessoa() {
		return nmPessoa;
	}
	
	public void setNmPessoa(String nmPessoa) {
		this.nmPessoa = nmPessoa;
	}
	
	public String getDtNascimento() {
		return dtNascimento;
	}
	
	public void setDtNascimento(String dtNascimento) {
		this.dtNascimento = dtNascimento;
	}
	
	public void setDtNascimento(java.sql.Date dtNascimento){
		this.dtNascimento = Util.dateStr(dtNascimento);
	}
	
	public void setDtNascimento(java.util.Date dtNascimento){
		this.dtNascimento = Util.dateStr(dtNascimento);
	}

	public String getNrTelefone() {
		return nrTelefone;
	}
	
	public void setNrTelefone(String nrTelefone) {
		this.nrTelefone = nrTelefone;
	}
	
	public String getNrCelular() {
		return nrCelular;
	}
	
	public void setNrCelular(String nrCelular) {
		this.nrCelular = nrCelular;
	}
	
	public String getDsEmail() {
		return dsEmail;
	}
	
	public void setDsEmail(String dsEmail) {
		this.dsEmail = dsEmail;
	}

	public String getDsSenha() {
		return dsSenha;
	}

	public void setDsSenha(String dsSenha) {
		this.dsSenha = dsSenha;
	}

	public boolean isIeAtivo() {
		return ieAtivo;
	}

	public void setIeAtivo(boolean ieAtivo) {
		this.ieAtivo = ieAtivo;
	}

	public void setIeTipoPessoa(String tipo){
		this.ieTipoPessoa = tipo;
	}
	
	public String getIeTipoPessoa(){
		return this.ieTipoPessoa;
	}
}
