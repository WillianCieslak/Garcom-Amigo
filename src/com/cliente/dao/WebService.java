package com.cliente.dao;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.concurrent.ExecutionException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;

import android.os.AsyncTask;

public class WebService {
/*	private ProgressDialog progDiag;
	private Activity atualActivity = new Activity();
	
	public final void setActivity(Activity atual){
		atualActivity = atual;
	}
	
	public final Activity getActivity(){
		return atualActivity;
	}*/
	
	public final String[] get(String url) throws InterruptedException, ExecutionException{
		String uri = HttpClientSing.getURI()+ url;
		UrlGet urlGet = new UrlGet();
		String[] tst = urlGet.execute(uri).get(); 
		return tst;
	}

	public final String[] post(String url, String json) throws InterruptedException, ExecutionException{
		String uri = HttpClientSing.getURI() + url;
		UrlPost urlPost = new UrlPost();
		return urlPost.execute(uri, json).get();
	}
	
	public String toString(InputStream is) throws IOException {
		byte[] bytes = new byte[1024];
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		int lidos;
		while ((lidos = is.read(bytes)) > 0){
			baos.write(bytes, 0, lidos);
		}
		return new String(baos.toByteArray());
	}

	private class UrlGet extends AsyncTask<String, Integer, String[]>{
	
/*		@Override
		protected void onPreExecute() {
			progDiag = new ProgressDialog(getActivity());
			progDiag.setMessage("Conectando...");
			progDiag.setProgressStyle(ProgressDialog.STYLE_SPINNER);
			progDiag.show();
		}*/

		@Override
		protected String[] doInBackground(String... params) {
			String[] result = new String[2];
			HttpGet httpGet = new HttpGet(params[0]);
			HttpResponse response;
			try {
				response = HttpClientSing.getInstancia().execute(httpGet);
				HttpEntity entidade = response.getEntity();
				if(entidade != null){
					result[0] = String.valueOf(response.getStatusLine().getStatusCode());
					InputStream instream = entidade.getContent();
					result[1] = WebService.this.toString(instream);
					instream.close();
				}
			} catch (Exception e) {
				result[0] = "0";
				result[1] = "Erro de acesso a rede!" + e.getMessage();
			}
			return result;
		}

/*		@Override
		protected void onPostExecute(String[] result) {
			super.onPostExecute(result);
			progDiag.dismiss();
		}*/
		
	}
	
	private class UrlPost extends AsyncTask<String, Integer, String[]>{

		@Override
		protected String[] doInBackground(String... params) {
			String[] result = new String[2];
			try {
				HttpPost httpPost = new HttpPost(new URI(params[0]));
				httpPost.setHeader("content-type", "application/json");
				StringEntity sEntity = new StringEntity(params[1]);
				httpPost.setEntity(sEntity);
				HttpResponse response = HttpClientSing.getInstancia().execute(httpPost);
				HttpEntity entidade = response.getEntity();
				if(entidade != null){
					result[0] = String.valueOf(response.getStatusLine().getStatusCode());
					InputStream instream = entidade.getContent();
					result[1] = WebService.this.toString(instream);
					instream.close();
				}
			} catch (URISyntaxException | IOException e) {
				result[0] = "0";
				result[1] = "Erro de acesso a rede!" + e.getMessage();
			}
			return result;
		}
		
	}
}
