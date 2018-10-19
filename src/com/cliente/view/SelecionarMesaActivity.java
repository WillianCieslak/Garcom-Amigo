package com.cliente.view;

import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.cliente.controller.MesaController;
import com.cliente.dao.LogadoSing;
import com.cliente.pojo.Mesa;
import com.view.garcom.R;

public class SelecionarMesaActivity extends Activity {

	Mesa m;
	Button btnProsseguir;
	Intent intent;
	Mesa mesa;
	private Spinner spinner;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_selecionar_mesa);

		spinner = (Spinner) findViewById(R.id.spinner1);
		btnProsseguir = (Button) findViewById(R.id.buttonProsseguir);
		// Mesa mesa = new Mesa();
		// mesa = (Mesa)spinner.getSelectedItemPosition();
		// m = (Mesa) spinner.getItemIdAtPosition(mesa);
		addItemsOnSpinner();
	}

	public void onClickProsseguir(View view) {
		intent = new Intent(SelecionarMesaActivity.this, CardapioActivity.class);

		mesa = new Mesa();
		mesa = (Mesa) spinner.getSelectedItem();
		LogadoSing.getInst().setMesa(mesa);

		Toast.makeText(
				getApplicationContext(),
				"Mesa selecionada: "
						+ mesa.getDsMesa(),
				Toast.LENGTH_LONG).show();

		SelecionarMesaActivity.this.startActivity(intent);
		finish();

	}

	public void addItemsOnSpinner() {

		spinner = (Spinner) findViewById(R.id.spinner1);

		List<Mesa> mesas = null;
		try {
			mesas = MesaController.listar();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ArrayAdapter<Mesa> dataAdapter = new ArrayAdapter<Mesa>(this,
				android.R.layout.simple_spinner_item, mesas);
		dataAdapter
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner.setAdapter(dataAdapter);
		// Mesa m = (Mesa)spinner.getItemAtPosition(mesa);
		// m.getDsMesa();
	}

}
