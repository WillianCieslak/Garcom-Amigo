package com.cliente.dao;

import java.util.ArrayList;

import com.cliente.pojo.Produto;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;

public class CardapioDAO {
	
	public ArrayList<Produto> listar() throws Exception{
		String uri = "cardapio/listar";
		String[] json = new WebService().get(uri);
		ArrayList<Produto> produtos = new ArrayList<Produto>();
		if(json[0].equals("200")){
			Gson gson = new Gson();
			JsonParser parser = new JsonParser();
			JsonArray array = parser.parse(json[1]).getAsJsonArray();

			for (int i = 0; i < array.size(); i++) {
				produtos.add(gson.fromJson(array.get(i), Produto.class));
			}
			return produtos;
		} else {
			throw new Exception("Erro: " + json[1]);
		}
	}
}
