package com.cliente.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.cliente.pojo.Pedido;
import com.cliente.pojo.Produto;
import com.cliente.pojo.Util;
import com.view.garcom.R;

public class DetalhesPedidoActivity extends Activity {

	int position;
	int mesa;
	int i;
	TextView nome;
	TextView preco;
	TextView descricao;
	TextView detalhes;
	EditText quantidade;
//	EditText nMesa;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_detalhes_produto);

		nome       = (TextView)findViewById(R.id.textViewNomeProduto);
		preco      = (TextView)findViewById(R.id.textViewPreco);
		detalhes   = (TextView)findViewById(R.id.textViewDetalhes);
		quantidade = (EditText)findViewById(R.id.editTextQuantidade);
		
//		nMesa      = (Button)findViewById(R.id.editTextMesaSelecionada);
//		i = Integer.valueOf(nMesa.getText().toString());
//		nMesa.setText(String.valueOf(i));
		
		Intent intent = getIntent();
		Bundle bundle = intent.getExtras();
		position = bundle.getInt("Position");
		mesa     = bundle.getInt("Mesa");
		Produto produtos = CardapioActivity.produtos.get(position);
		
//		nMesa.setText(String.valueOf(mesa));

		nome.setText(produtos.getDsProduto());
		preco.setText("R$ " + produtos.getVlProduto());
		detalhes.setText(produtos.getDsIngredientes());

	}

	public void onCLickMais(View view) {
		EditText et = (EditText) findViewById(R.id.editTextQuantidade);
		int tt = Integer.valueOf(et.getText().toString()) + 1;
		et.setText(String.valueOf(tt));
	}

	public void onClickMenos(View view) {
		EditText et = (EditText) findViewById(R.id.editTextQuantidade);
		int tt = Integer.valueOf(et.getText().toString()) - 1;
		if(tt <= 0){
			tt = 1;
		}
		et.setText(String.valueOf(tt));
	}
	
	public void clickConfirmaPedido(View view){
		EditText et = (EditText) findViewById(R.id.editTextQuantidade);
		int tt = Integer.valueOf(et.getText().toString());
		
		Pedido pedido = new Pedido();
		pedido.setDtPedido(Util.dateStr(new java.util.Date()));
		pedido.setQtPedido(tt);
		
	}

}
