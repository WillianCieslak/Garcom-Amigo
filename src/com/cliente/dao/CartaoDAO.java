package com.cliente.dao;

import java.util.ArrayList;

import com.cliente.pojo.Cartao;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;

public class CartaoDAO {
	
	public ArrayList<Cartao> buscarEmUso() throws Exception{
		String uri = "cartao/emuso";
		String[] json = new WebService().get(uri);
		ArrayList<Cartao> cartoes = new ArrayList<Cartao>();
		if(json[0].equals("200")){
			Gson gson = new Gson();
			JsonParser parser = new JsonParser();
			JsonArray array = parser.parse(json[1]).getAsJsonArray();

			for (int i = 0; i < array.size(); i++) {
				cartoes.add(gson.fromJson(array.get(i), Cartao.class));
			}
			return cartoes;
		} else {
			throw new Exception("Erro: " + json[1]);
		}
	}
}
