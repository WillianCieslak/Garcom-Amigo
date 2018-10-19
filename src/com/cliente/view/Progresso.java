package com.cliente.view;

import android.content.Context;

public class Progresso {
	private Prog p;
	
	public Progresso(Context context, String titulo){
		p = new Prog(context, titulo);
		new Thread(p).start();
	}
	
	public void setFim(){
		this.p.setFim();
	}
}
