package com.cliente.dao;

import java.util.ArrayList;

import com.cliente.pojo.Pedido;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;

public class PedidoDAO {
	
	public ArrayList<Pedido> atuais() throws Exception{
		String uri = "pedido/atuais";
		String[] json = new WebService().get(uri);
		ArrayList<Pedido> pedidos = new ArrayList<Pedido>();
		if(json[0].equals("200")){
			Gson gson = new Gson();
			JsonParser parser = new JsonParser();
			JsonArray array = parser.parse(json[1]).getAsJsonArray();

			for (int i = 0; i < array.size(); i++) {
				pedidos.add(gson.fromJson(array.get(i), Pedido.class));
			}
			return pedidos;
		} else {
			throw new Exception("Erro: " + json[1]);
		}
	}

	public ArrayList<Pedido> todos() throws Exception{
		String uri = "pedido/todos";
		String[] json = new WebService().get(uri);
		ArrayList<Pedido> pedidos = new ArrayList<Pedido>();
		if(json[0].equals("200")){
			Gson gson = new Gson();
			JsonParser parser = new JsonParser();
			JsonArray array = parser.parse(json[1]).getAsJsonArray();

			for (int i = 0; i < array.size(); i++) {
				pedidos.add(gson.fromJson(array.get(i), Pedido.class));
			}
			return pedidos;
		} else {
			throw new Exception("Erro: " + json[1]);
		}
	}

	public String incluir(Pedido pedido) throws Exception {
		Gson gson = new Gson();
		WebService ws = new WebService();
		String[] json = ws.post("pedido/inserir", gson.toJson(pedido));
		if (json[0].equals("200")) {
			return json[1];
		} else {
			throw new Exception(json[1]);
		}
	}

}
