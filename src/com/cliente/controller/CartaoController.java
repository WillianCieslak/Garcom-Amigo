package com.cliente.controller;

import java.util.ArrayList;

import com.cliente.dao.CartaoDAO;
import com.cliente.pojo.Cartao;

public class CartaoController {

	public static ArrayList<Cartao> buscarUso() throws Exception {
		CartaoDAO dao = new CartaoDAO();
		return dao.buscarEmUso();
	}
}
