package com.cliente.controller;

import java.util.ArrayList;

import com.cliente.dao.CardapioDAO;
import com.cliente.pojo.Produto;

public class CardapioController {

	public static ArrayList<Produto> listar() throws Exception {
		CardapioDAO dao = new CardapioDAO();
		return dao.listar();
	}
}
