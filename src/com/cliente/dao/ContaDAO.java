package com.cliente.dao;

import com.cliente.pojo.Conta;
import com.google.gson.Gson;

public class ContaDAO {
	
	public Conta buscarCliente(String nrCpf) throws Exception{
		String uri = "conta/cpf/" + nrCpf;
		String[] json = new WebService().get(uri);
		Conta conta = new Conta();
		if(json[0].equals("200")){
			Gson gson = new Gson();
			conta = gson.fromJson(json[1], Conta.class);
			return conta;
		} else {
			throw new Exception("Erro: " + json[1]);
		}
	}
}
