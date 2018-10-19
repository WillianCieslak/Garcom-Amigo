package com.cliente.view;
    
import com.view.garcom.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

public class MenuActivity extends Activity {

	Intent intent;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_menu);
	}

	
	public void onClickFacaSeuPedido(View view){
		intent = new Intent(MenuActivity.this, SelecionarMesaActivity.class);
		MenuActivity.this.startActivity(intent);
	}
	
	public void onCLickAlterar(View view){
		intent = new Intent(MenuActivity.this, AlterarDadosActivity.class);
		MenuActivity.this.startActivity(intent);
	}
	
	public void onClickQuemSomos(View view){
		intent = new Intent(MenuActivity.this, QuemSomosActivity.class);
		MenuActivity.this.startActivity(intent);
	}
	
	public void onClickMeusPedidos(View view){
		intent = new Intent(MenuActivity.this, PedidosAtuaisActivity.class);
		MenuActivity.this.startActivity(intent);
	}

	public void onCLickSair(View view){
		finish();
	}

}
