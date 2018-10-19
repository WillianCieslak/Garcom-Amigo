package com.cliente.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.cliente.controller.PedidoController;
import com.cliente.dao.LogadoSing;
import com.cliente.pojo.Pedido;
import com.cliente.pojo.Produto;
import com.cliente.pojo.Util;
import com.view.garcom.R;

public class DetalhesProdutoActivity extends Activity {

	int position;
	String mesa;
	TextView nome;
	TextView preco;
	TextView descricao;
	TextView detalhes;
	EditText quantidade;
	EditText nMesa;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_detalhes_produto);

		Intent intent = getIntent();
		Bundle bundle = intent.getExtras();
		position = bundle.getInt("Position");

		nome = (TextView) findViewById(R.id.textViewNomeProduto);
		preco = (TextView) findViewById(R.id.textViewPreco);
		quantidade = (EditText) findViewById(R.id.editTextQuantidade);
		detalhes = (TextView) findViewById(R.id.textViewDetalhes);

		try {
			nMesa = (EditText) findViewById(R.id.editTextMesaSelecionada);
			mesa = LogadoSing.getInst().getMesa().getDsMesa();

			nMesa.setText(mesa);
		} catch (Exception e) {
			e.printStackTrace();
		}

		Produto produtos = CardapioActivity.produtos.get(position);
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
		if (tt <= 0) {
			tt = 1;
		}
		et.setText(String.valueOf(tt));
	}

	public void onClickSelecionarMesa(View view){
		Toast.makeText(getApplicationContext(), "teste", Toast.LENGTH_LONG).show();
	}
	
	public void clickConfirmaPedido(View view) {
		Progresso p = new Progresso(DetalhesProdutoActivity.this, "Aguarde..");
		EditText et = (EditText) findViewById(R.id.editTextQuantidade);
		int tt = Integer.valueOf(et.getText().toString());

		Pedido pedido = new Pedido();
		pedido.setDtPedido(Util.dateStr(new java.util.Date()));
		pedido.setQtPedido(tt);
		pedido.setMesa(LogadoSing.getInst().getMesa());
		pedido.setFuncionario(LogadoSing.getInst().getFuncionario());
		pedido.setProduto(CardapioActivity.produtos.get(position));
		pedido.setVlPedido(pedido.getProduto().getVlProduto());
		pedido.setConta(LogadoSing.getInst().getConta());
		pedido.setIePedido("P");
		
		String ped = null;
		
		try {
			ped = PedidoController.incluir(pedido);
			if(ped != null){
				p.setFim();
				Toast msgs = Toast.makeText(getApplicationContext(), "Pedido incluso com sucesso!", Toast.LENGTH_LONG);
				msgs.show();
				finish();
			} else {
				p.setFim();
				Toast msgs = Toast.makeText(getApplicationContext(), "Ocorreu um erro na inclusão do pedido!", Toast.LENGTH_LONG);
				msgs.show();				
			}
		} catch (Exception e) {
			p.setFim();
			Toast msgs = Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG);
			msgs.show();
		}
	}

}
