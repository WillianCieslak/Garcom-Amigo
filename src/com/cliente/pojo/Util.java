package com.cliente.pojo;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Util {
	private static SimpleDateFormat dfm = new SimpleDateFormat("dd/MM/yyyy");
	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	public static Date strDate(String date){
		Date dt = null;
		try {
			dt = new Date(dfm.parse(date).getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return dt;
	}
	
	public static String dateStr(Date data){
		java.util.Date dt = new java.util.Date(data.getTime());;
		return dfm.format(dt);
	}

	public static String dateStr(java.util.Date data){
		return dfm.format(data);
	}

	public static String sqlToUtil(Date date){
		java.util.Date dt = new java.util.Date(date.getTime());
		return dfm.format(dt);
	}
	
	public static Date htmlToSql(String date){
		try {
			java.util.Date dt = sdf.parse(date);
			Date d1 = new Date(dt.getTime());
			return d1;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static String jsonHtml(String texto){
    	String cont = texto.replace("{", "§");
    	cont = cont.replace("\"", "£");
    	cont = cont.replace(",", "¢");
    	cont = cont.replace("/", "§§");
    	cont = cont.replace(":", "¢¢");
    	return cont;
    }

    public static String htmlJson(String texto){
    	String cont = texto.replace("¢¢", ":");
    	cont = cont.replace("¢", ",");
    	cont = cont.replace("£", "\"");
    	cont = cont.replace("§§", "/");
    	cont = cont.replace("§", "{");
    	return cont;
    }
}
