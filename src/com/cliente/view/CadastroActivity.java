package com.cliente.view;

import java.util.Calendar;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.cliente.controller.CadastroController;
import com.cliente.dao.LogadoSing;
import com.cliente.pojo.Cliente;
import com.view.garcom.R;

public class CadastroActivity extends Activity {

	OnDateSetListener datePickerListener;
	int year;
	int monthOfYear;
	int dayOfMonth;
	int hour;
	int minute;
	Intent intent;
	private EditText editTextNomeCompleto;
	private EditText editTextCpf;
	private Button editTextDataNascimento;
	private EditText editTextCelular;
	private EditText editTextEmail;
	// private EditText editTextConfirmarEmail;
	private EditText editTextSenha;
	private EditText editTextConfirmarSenha;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_cadastro);

		editTextNomeCompleto = (EditText) findViewById(R.id.editTextNomeCompleto);
		editTextCpf = (EditText) findViewById(R.id.editTextCpf);
		editTextDataNascimento = (Button) findViewById(R.id.editTextDataNascimento);
		editTextCelular = (EditText) findViewById(R.id.editTextCelular);
		editTextEmail = (EditText) findViewById(R.id.editTextEmail);
		// editTextConfirmarEmail = (EditText)
		// findViewById(R.id.editTextConfirmarEmail);
		editTextSenha = (EditText) findViewById(R.id.editTextSenha);
		editTextConfirmarSenha = (EditText) findViewById(R.id.editTextConfirmarSenha);

		datePickerListener = new DatePickerDialog.OnDateSetListener() {

			@Override
			public void onDateSet(DatePicker view, int selectedYear,
					int selectedMonthOfYear, int selectedDayOfMonth) {

				year = selectedYear;
				monthOfYear = selectedMonthOfYear;
				dayOfMonth = selectedDayOfMonth;
				editTextDataNascimento.setText(new StringBuilder()
						.append(String.format("%02d", dayOfMonth)).append("/")
						.append(String.format("%02d", monthOfYear + 1))
						.append("/").append(String.format("%04d", year)));
			}
		};

	}

	public void editTextData(View view) {
		final Calendar calendar = Calendar.getInstance();

		DatePickerDialog datePickerDialog = new DatePickerDialog(this,
				datePickerListener, calendar.get(Calendar.YEAR),
				calendar.get(Calendar.MONTH),
				calendar.get(Calendar.DAY_OF_MONTH));

		datePickerDialog.show();
	}

	public void onClickCancelar(View view) {
		finish();
	}

	public void onClickContinuar(View view) {
		String msg = null;
		String nomeCompleto = String.valueOf(editTextNomeCompleto.getText());
		String cpf = String.valueOf(editTextCpf.getText());
		String dataNascimento = String
				.valueOf(editTextDataNascimento.getText());
		String celular = String.valueOf(editTextCelular.getText());
		String email = String.valueOf(editTextEmail.getText());
		// String confirmarEmail =
		// String.valueOf(editTextConfirmarEmail.getText());
		String senha = String.valueOf(editTextSenha.getText());
		String confirmarSenha = String
				.valueOf(editTextConfirmarSenha.getText());

		Cliente cliente = new Cliente();
		cliente.setNmPessoa(nomeCompleto);
		cliente.setNrCpf(cpf);
		cliente.setDtNascimento(dataNascimento);
		cliente.setNrCelular(celular);
		cliente.setDsEmail(email);
		cliente.setDsSenha(senha);
		cliente.setIeAtivo(true);
		try {
			// if (email.equals(confirmarEmail)) {
			if (senha.equals(confirmarSenha)) {
				Cliente cliente2 = new Cliente();
				cliente2 = CadastroController.incluir(cliente);
				if (cliente2 != null) {
					if (cliente2.getNrCpf() != null) {
						LogadoSing.getInst().setCliente(cliente2);
						Intent intent = new Intent(this, MenuActivity.class);
						this.startActivity(intent);
						msg = "Cadastrado com sucesso!";
						Toast msgs = Toast.makeText(getApplicationContext(),
								msg, Toast.LENGTH_LONG);
						msgs.show();
						finish();
					}
				}
				// }
			} else {
				msg = "As senhas informadas não são iguais!";
				Toast msgs = Toast.makeText(getApplicationContext(), msg,
						Toast.LENGTH_LONG);
				msgs.show();
				editTextSenha.setFocusable(true);
			}
			// else {
			// msg = "Os e-mails informados não são iguais!";
			// Toast msgs = Toast.makeText(getApplicationContext(), msg,
			// Toast.LENGTH_LONG);
			// msgs.show();
			// editTextEmail.setFocusable(true);
			// }
		} catch (Exception e) {
			msg = e.getMessage();
			Toast msgs = Toast.makeText(getApplicationContext(), msg,
					Toast.LENGTH_LONG);
			msgs.show();
		}
	}
}
