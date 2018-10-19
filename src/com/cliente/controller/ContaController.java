package com.cliente.controller;

import com.cliente.dao.ContaDAO;
import com.cliente.pojo.Conta;

public class ContaController {

	public static Conta buscarConta(String nrCpf) throws Exception {
		ContaDAO dao = new ContaDAO();
		return dao.buscarCliente(nrCpf);
	}

}
