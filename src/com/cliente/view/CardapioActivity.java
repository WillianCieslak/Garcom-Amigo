package com.cliente.view;

import java.util.ArrayList;
import java.util.List;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.cliente.controller.CardapioController;
import com.cliente.pojo.Produto;
import com.view.garcom.R;

public class CardapioActivity extends ListActivity {

	Intent intent;

	public static List<Produto> produtos = new ArrayList<Produto>();
	private listAdapter adapter;
	private Progresso p;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		p = new Progresso(CardapioActivity.this, "Aguarde...");
		try {
			CardapioActivity.produtos = CardapioController.listar();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.cardapio, menu);
		return true;
	}

	@Override
	public boolean onMenuItemSelected(int featureId, MenuItem item) {

		switch (item.getItemId()) {
		case R.id.mesa2:
			intent = new Intent(CardapioActivity.this, SelecionarMesaActivity.class);
			CardapioActivity.this.startActivity(intent);
			finish();
			return true;
		case R.id.menu2:
			intent = new Intent(CardapioActivity.this, MenuActivity.class);
			CardapioActivity.this.startActivity(intent);
			finish();
			return true;
		default:
			return super.onMenuItemSelected(featureId, item);
		}
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);

		Intent intent = new Intent(this, DetalhesProdutoActivity.class);

		Bundle bundle = new Bundle();
		bundle.putInt("Position", position);
		intent.putExtras(bundle);

		startActivity(intent);

	}

	public void preencherLista() {
		adapter = new listAdapter();
		setListAdapter(adapter);
		p.setFim();
	}

	public void atualizar() {
		adapter.notifyDataSetChanged();
	}

	@Override
	protected void onStart() {
		super.onStart();
	}

	@Override
	protected void onResume() {
		super.onResume();

		preencherLista();
		atualizar();
	}

	@Override
	protected void onPause() {
		super.onPause();
	}

	@Override
	protected void onStop() {
		super.onStop();
	}

	protected void onRestart(View view) {
		super.onRestart();
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
	}

	class listAdapter extends BaseAdapter {

		LayoutInflater inflater;

		public listAdapter() {
			inflater = (LayoutInflater) CardapioActivity.this
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		}

		@Override
		public int getCount() {
			return produtos.size();
		}

		@Override
		public Object getItem(int arg0) {
			return arg0;
		}

		@Override
		public long getItemId(int arg0) {
			return arg0;
		}

		@Override
		public View getView(int arg0, View view, ViewGroup arg2) {
			view = inflater.inflate(R.layout.list_view, arg2, false);
			((TextView) view.findViewById(R.id.produto)).setText(produtos.get(
					arg0).getDsProduto());
			((TextView) view.findViewById(R.id.preco)).setText("R$ "
					+ produtos.get(arg0).getVlProduto());
			return view;
		}

	}

}
