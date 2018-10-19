package com.cliente.view;

import android.app.ProgressDialog;
import android.content.Context;

public class Prog implements Runnable {
	private ProgressDialog pd;
	private boolean fim = false;
	
	public Prog(Context context, String titulo){
		pd = new ProgressDialog(context);
		pd.setCancelable(true);
		pd.setProgressStyle(ProgressDialog.STYLE_SPINNER);
		pd.setMessage(titulo);
		pd.show();
	}
	
	public void setFim(){
		this.fim = true;
	}
	
	public void run() {
		while(fim == false){
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
			}
		}
		pd.dismiss();
	}
}