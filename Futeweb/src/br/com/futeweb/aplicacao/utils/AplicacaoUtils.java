package br.com.futeweb.aplicacao.utils;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class AplicacaoUtils {

	public static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss", new Locale("pt", "BR"));
	
	public static java.sql.Timestamp dateUtilToSql(java.util.Date utilDate){
		return new Timestamp(utilDate.getTime());
	}
	
	public static java.util.Date dateSqlToUtil(java.sql.Date sqlDate){
		java.util.Date utilDate = new java.util.Date();
		utilDate.setTime(sqlDate.getTime());
		return utilDate;
	}
	
	public static java.util.Date parseDate(String stringDate){
		java.util.Date date = null;
		try {
			date = AplicacaoUtils.sdf.parse(stringDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
}
