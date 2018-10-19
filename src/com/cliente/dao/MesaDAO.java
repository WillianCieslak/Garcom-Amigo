package com.cliente.dao;

import java.util.ArrayList;

import com.cliente.pojo.Mesa;
import com.cliente.pojo.Pedido;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;

public class MesaDAO {
	
	public ArrayList<Mesa> listar() throws Exception{
		String uri = "mesa/listar";
		String[] json = new WebService().get(uri);
		ArrayList<Mesa> mesas = new ArrayList<Mesa>();
		if(json[0].equals("200")){
			Gson gson = new Gson();
			JsonParser parser = new JsonParser();
			JsonArray array = parser.parse(json[1]).getAsJsonArray();

			for (int i = 0; i < array.size(); i++) {
				mesas.add(gson.fromJson(array.get(i), Mesa.class));
			}
			return mesas;
		} else {
			throw new Exception("Erro: " + json[1]);
		}
	}

	public Pedido incluir(Pedido pedido) throws Exception {
		Gson gson = new Gson();
		WebService ws = new WebService();
		String[] json = ws.post("pedido/inserir", gson.toJson(pedido));
		if (json[0].equals("200")) {
			return gson.fromJson(json[1], Pedido.class);
		} else {
			throw new Exception(json[1]);
		}
	}

}
