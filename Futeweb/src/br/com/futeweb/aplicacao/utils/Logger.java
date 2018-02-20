package br.com.futeweb.aplicacao.utils;

import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;


public class Logger {
	
	public Logger(boolean imprime, Severity severidade, String mensagem, String idCampoMensagem){
		if (imprime){
			String tempMensagem = AplicacaoEnum.APLICACAO_NOME.getValor()+" - "+AplicacaoUtils.sdf.format(new Date())+" - "+mensagem;
			if (AplicacaoEnum.SEVERIDADE_ERRO.getSeveridade().equals(severidade)){
				System.err.println(tempMensagem);
			}else{
				System.out.println(tempMensagem);
			}
		}
		if (severidade!=null){
			FacesContext.getCurrentInstance().addMessage(idCampoMensagem, new FacesMessage(severidade, mensagem, null));
			RequestContext.getCurrentInstance().update(idCampoMensagem);
		}
	}
}
