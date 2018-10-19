package com.cliente.dao;

import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

public class HttpClientSing {
	private static final int JSON_CONNECTION_TIMEOUT = 5000;
	private static final int JSON_SOCKET_TIMEOUT = 8000;
//	private static final String uri = "http://felipemontilla.no-ip.info/GarcomAmigo/ws/";
//	private static final String uri = "http://172.30.10.70:8090/GarcomAmigo/ws/";
	private static final String uri = "http://192.168.1.100/GarcomAmigo/ws/";
	private static HttpClientSing instancia;
	private HttpParams httpParams;
	private DefaultHttpClient httpCliente;
	
	private void setTimeOut(HttpParams params){
		HttpConnectionParams.setConnectionTimeout(params, JSON_CONNECTION_TIMEOUT);
		HttpConnectionParams.setSoTimeout(params, JSON_SOCKET_TIMEOUT);
	}
	
	private HttpClientSing(){
		httpParams = new BasicHttpParams();
		setTimeOut(httpParams);
		httpCliente = new DefaultHttpClient(httpParams);
	}
	
	public static DefaultHttpClient getInstancia(){
		if(instancia == null){
			instancia = new HttpClientSing();
		}
		return instancia.httpCliente;
	}
	
	public static String getURI(){
		return uri;
	}
}
