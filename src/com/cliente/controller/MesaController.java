package com.cliente.controller;

import java.util.ArrayList;

import com.cliente.dao.MesaDAO;
import com.cliente.pojo.Mesa;

public class MesaController {

	public static ArrayList<Mesa> listar() throws Exception {
		MesaDAO dao = new MesaDAO();
		return dao.listar();
	}
}
