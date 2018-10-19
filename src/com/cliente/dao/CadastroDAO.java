package com.cliente.dao;

import com.cliente.pojo.Cliente;
import com.google.gson.Gson;

public class CadastroDAO {
	/*
	 * public String incluir(Cliente clie) throws Exception{ Gson gson = new
	 * Gson(); WebService ws = new WebService(); String[] json =
	 * ws.post("cliente/inserir", gson.toJson(clie)); if(json[0].equals("200")){
	 * return json[1]; } else { throw new Exception(json[1]); } }
	 */

	public Cliente incluir(Cliente clie) throws Exception {
		Gson gson = new Gson();
		WebService ws = new WebService();
		String[] json = ws.post("cliente/inserir", gson.toJson(clie));
		if (json[0].equals("200")) {
			return gson.fromJson(json[1], Cliente.class);
		} else {
			throw new Exception(json[1]);
		}
	}

	public Cliente salvar(Cliente clie) throws Exception {
		Gson gson = new Gson();
		WebService ws = new WebService();
		String[] json = ws.post("cliente/salvar", gson.toJson(clie));
		if (json[0].equals("200")) {
			return gson.fromJson(json[1], Cliente.class);
		} else {
			throw new Exception(json[1]);
		}
	}
}
