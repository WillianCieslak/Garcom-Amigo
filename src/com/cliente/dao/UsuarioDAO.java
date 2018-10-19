package com.cliente.dao;

import com.cliente.pojo.Pessoa;
import com.google.gson.Gson;

public class UsuarioDAO {
	
	public Pessoa logar(Pessoa param) throws Exception{
		Gson gson = new Gson();
		String paramJason = gson.toJson(param);
		String[] json = new WebService().post("usuario/logar", paramJason);
		Pessoa pessoa = new Pessoa();
		if(json[0].equals("200")){
			pessoa = gson.fromJson(json[1], Pessoa.class);
		} else {
			throw new Exception("Erro: " + json[1]);
		}
		return pessoa;
	}

/*	public Pessoa logar(String dsEmail) throws Exception{
		String uri = "pessoa/buscaremail/" + dsEmail;
		String[] json = new WebService().get(uri);
		Pessoa pessoa = new Pessoa();
		if(json[0].equals("200")){
			Gson gson = new Gson();
			pessoa = gson.fromJson(json[1], Pessoa.class);
		} else {
			throw new Exception("Erro: " + json[1]);
		}
		return pessoa;
	}*/

}
