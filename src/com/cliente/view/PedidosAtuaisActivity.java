package com.cliente.view;

import java.util.ArrayList;
import java.util.List;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.cliente.controller.PedidoController;
import com.cliente.pojo.Pedido;
import com.view.garcom.R;

public class PedidosAtuaisActivity extends ListActivity {

	public static List<Pedido> pedidos = new ArrayList<Pedido>();
	//private ArrayAdapter<Produto> arrayAdapter;
	private listAdapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		try {
			PedidosAtuaisActivity.pedidos = PedidoController.atuais();
		} catch (Exception e) {
			Toast msgs = Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG);
			msgs.show();
		}
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);

		Intent intent = new Intent(this, DetalhesPedidoActivity.class);

		Bundle bundle = new Bundle();
		bundle.putInt("Position", position);
		intent.putExtras(bundle);

		startActivity(intent);

	}

	public void preencherLista() {
		adapter = new listAdapter();
		setListAdapter(adapter);
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

	class listAdapter extends BaseAdapter{
		
		LayoutInflater inflater;
		
		public listAdapter(){
			inflater = (LayoutInflater) PedidosAtuaisActivity.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		}
		
		@Override
		public int getCount() {
			return pedidos.size();
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
			((TextView) view.findViewById(R.id.produto)).setText(pedidos.get(arg0).getProduto().getDsProduto());
			((TextView) view.findViewById(R.id.preco)).setText("R$ "+ pedidos.get(arg0).getTotal());
			return view;
		}
		
	}
	
}
