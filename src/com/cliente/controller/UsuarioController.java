package com.cliente.controller;

import com.cliente.dao.UsuarioDAO;
import com.cliente.pojo.Pessoa;

public class UsuarioController {
	private static UsuarioDAO dao;
	
/*	public static Pessoa logar(String email) throws Exception{
		dao = new UsuarioDAO();
		return dao.logar(email);
	}*/
	
	public static Pessoa logar(Pessoa pessoa) throws Exception{
		dao = new UsuarioDAO();
		return dao.logar(pessoa);
	}
}
