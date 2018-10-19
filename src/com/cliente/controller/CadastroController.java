package com.cliente.controller;

import com.cliente.dao.CadastroDAO;
import com.cliente.pojo.Cliente;

public class CadastroController {
	private static CadastroDAO dao;
	
	/*public static String incluir(Cliente clie) throws Exception{
		dao = new CadastroDAO();
		return dao.incluir(clie);
	}*/

	public static Cliente incluir(Cliente clie) throws Exception{
		dao = new CadastroDAO();
		return dao.incluir(clie);
	}
	
	public static Cliente salvar(Cliente clie) throws Exception{
		dao = new CadastroDAO();
		return dao.salvar(clie);
	}
}
 