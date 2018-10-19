package com.cliente.controller;

import java.util.ArrayList;

import com.cliente.dao.PedidoDAO;
import com.cliente.pojo.Pedido;

public class PedidoController {

	public static ArrayList<Pedido> atuais() throws Exception {
		PedidoDAO dao = new PedidoDAO();
		return dao.atuais();
	}

	public static ArrayList<Pedido> todos() throws Exception {
		PedidoDAO dao = new PedidoDAO();
		return dao.todos();
	}

	public static String incluir(Pedido pedido) throws Exception{
		PedidoDAO dao  = new PedidoDAO();
		return dao.incluir(pedido);
	}

}
