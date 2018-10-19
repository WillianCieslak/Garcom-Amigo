package com.cliente.dao;

import com.cliente.pojo.Cliente;
import com.cliente.pojo.Conta;
import com.cliente.pojo.Funcionario;
import com.cliente.pojo.Mesa;

public class LogadoSing {
	private Funcionario funcionario;
	private Cliente cliente;
	private Conta conta;
	private Mesa mesa;
	private static LogadoSing instancia;
	
	public final Funcionario getFuncionario() {
		return funcionario;
	}
	public final void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	public final Cliente getCliente() {
		return cliente;
	}
	public final void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public final void setMesa(Mesa mesa){
		this.mesa = mesa;
	}
	
	public final Mesa getMesa(){
		return this.mesa;
	}
	
	public final void setConta(Conta conta){
		this.conta = conta;
	}
	
	public final Conta getConta(){
		return this.conta;
	}
	
	public static LogadoSing getInst(){
		if(instancia == null){
			instancia = new LogadoSing();
		}
		return instancia;
	}
	
}
