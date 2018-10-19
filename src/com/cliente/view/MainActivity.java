package com.cliente.view;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.Toast;

import com.cliente.controller.ContaController;
import com.cliente.controller.UsuarioController;
import com.cliente.dao.LogadoSing;
import com.cliente.pojo.Cliente;
import com.cliente.pojo.Funcionario;
import com.cliente.pojo.Pessoa;
import com.view.garcom.R;

@SuppressLint("ShowToast")
public class MainActivity extends Activity {

	Intent intent;
	private EditText editTextLogin;
	private EditText editTextSenha;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);

		editTextLogin = (EditText) findViewById(R.id.editTextUsuario);
		editTextSenha = (EditText) findViewById(R.id.editTextSenha);
	}

	public void onCLickCadastrar(View view) {
		intent = new Intent(MainActivity.this, CadastroActivity.class);
		MainActivity.this.startActivity(intent);
	}

	public void onCLickEntrar(View view) {
		Progresso p = new Progresso(MainActivity.this, "Logando...");
		String txtLogin = String.valueOf(editTextLogin.getText());
		String txtSenha = String.valueOf(editTextSenha.getText());
		Pessoa param = new Pessoa();
		param.setDsEmail(txtLogin);
		param.setDsSenha(txtSenha);
		try {
			Pessoa pessoa = new Pessoa();

			pessoa = UsuarioController.logar(param);

			if (pessoa.getNrCpf() != null) {
				Funcionario func = new Funcionario();
				Cliente cliente = new Cliente();
				cliente.setDsEmail(pessoa.getDsEmail());
				cliente.setDsSenha(pessoa.getDsSenha());
				cliente.setDtNascimento(pessoa.getDtNascimento());
				cliente.setIeTipoPessoa(pessoa.getIeTipoPessoa());
				cliente.setNmPessoa(pessoa.getNmPessoa());
				cliente.setNrCelular(pessoa.getNrCelular());
				cliente.setNrCpf(pessoa.getNrCpf());
				cliente.setNrTelefone(pessoa.getNrTelefone());

				func.setDsEmail(pessoa.getDsEmail());
				func.setDsSenha(pessoa.getDsSenha());
				func.setDtNascimento(pessoa.getDtNascimento());
				func.setIeTipoPessoa("F");
				func.setNmPessoa(pessoa.getNmPessoa());
				func.setNrCelular(pessoa.getNrCelular());
				func.setNrCpf(pessoa.getNrCpf());
				func.setNrTelefone(pessoa.getNrTelefone());

				LogadoSing.getInst().setCliente(cliente);
				LogadoSing.getInst().setFuncionario(func);
				LogadoSing.getInst().setConta(ContaController.buscarConta(cliente.getNrCpf()));
				Intent intent = new Intent(this, MenuActivity.class);
				this.startActivity(intent);
				p.setFim();
				finish();
			} else {
				p.setFim();
				Toast msg = Toast.makeText(getApplicationContext(),
						"Login e/ou senha inválido(s)!", Toast.LENGTH_LONG);
				msg.show();
			}
		} catch (Exception e) {
			p.setFim();
			e.printStackTrace();
		}
	}

}

/* ****************************************************************************************************************************
 ----------------------- PROGRESS DIALOG --------------------------------------------------------------------------------------
 ****************************************************************************************************************************  */
//@SuppressLint("ShowToast")
//public class MainActivity extends Activity {
//
//	Intent intent;
//	private EditText editTextLogin;
//	private EditText editTextSenha;
//	private ProgressBarTask progressBarTask;
//	private ProgressDialog progressDialog;
//
//	@Override
//	protected void onCreate(Bundle savedInstanceState) {
//		super.onCreate(savedInstanceState);
//		requestWindowFeature(Window.FEATURE_NO_TITLE);
//		setContentView(R.layout.activity_main);
//
//		editTextLogin = (EditText) findViewById(R.id.editTextUsuario);
//		editTextSenha = (EditText) findViewById(R.id.editTextSenha);
//	}
//
//	public void onCLickCadastrar(View view) {
//		intent = new Intent(MainActivity.this, CadastroActivity.class);
//		MainActivity.this.startActivity(intent);
//	}
//
//	public void onCLickEntrar(View view) {
//
//		String txtLogin = String.valueOf(editTextLogin.getText());
//		String txtSenha = String.valueOf(editTextSenha.getText());
//		
//		progressBarTask = new ProgressBarTask();
//		progressBarTask.execute(txtLogin, txtSenha);
//		
////		Pessoa param = new Pessoa();
////		param.setDsEmail(txtLogin);
////		param.setDsSenha(txtSenha);
////		try {
////			Pessoa pessoa = new Pessoa();
////			
////			pessoa = UsuarioController.logar(param);
////			
////			if (pessoa.getNrCpf() != null) {
////				if (pessoa.getIeTipoPessoa() == "F") {
////					LogadoSing.getInst().setFuncionario((Funcionario) pessoa);
////				} else {
////					LogadoSing.getInst().setCliente((Cliente) pessoa);
////				}
////				Intent intent = new Intent(this, MenuActivity.class);
////				this.startActivity(intent);
////				finish();
////			} else {
////				Toast msg = Toast.makeText(getApplicationContext(),
////						"Login e/ou senha inválido(s)!", Toast.LENGTH_LONG);
////				msg.show();
////			}
////		} catch (Exception e) {
////			e.printStackTrace();
////		}
//		
//	}
//
//	private class ProgressBarTask extends AsyncTask<String, Void, Boolean> {
//
//		@Override
//		protected void onPreExecute() {
//			progressDialog = new ProgressDialog(MainActivity.this);
//			progressDialog.setMessage("Autenticando...");
//			progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
//			progressDialog.setCancelable(true);
//
//			progressDialog.setButton(DialogInterface.BUTTON_NEGATIVE,
//					"Cancelar", new DialogInterface.OnClickListener() {
//
//						@Override
//						public void onClick(DialogInterface dialog, int which) {
//							progressDialog.dismiss();
//						}
//					});
//
//			progressDialog.show();
//
//		}
//
//		@Override
//		protected Boolean doInBackground(String... parameters) {
//
//			 try {
//			
//			 Thread.sleep(2000);
//			
//			 if (parameters[1].equalsIgnoreCase(parameters[0])) {
//			
//			 return true;
//			 } else {
//			
//			 return false;
//			 }
//			
//			 } catch (InterruptedException e) {
//			 e.printStackTrace();
//			 }
//			
//			 return false;
//
//		}
//
//		@Override
//		protected void onPostExecute(Boolean result) {
//
//			if (result) {
//				Toast.makeText(getApplicationContext(), "Login Realizado",
//						Toast.LENGTH_LONG).show();
//				Intent intent = new Intent(MainActivity.this,
//						MenuActivity.class);
//				MainActivity.this.startActivity(intent);
//				MainActivity.this.finish();
//
//			} else {
//				Toast.makeText(getApplicationContext(),
//						"Combinação de Login e Senha incorreta",
//						Toast.LENGTH_LONG).show();
//
//				editTextSenha.setText("");
//
//				progressDialog.dismiss();
//			}
//		}
//	}
//}
