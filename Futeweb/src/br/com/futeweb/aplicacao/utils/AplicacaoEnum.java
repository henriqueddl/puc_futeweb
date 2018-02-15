package br.com.futeweb.aplicacao.utils;

import javax.faces.application.FacesMessage;

public enum AplicacaoEnum {

	APLICACAO_NOME("Futeweb"),
	SEVERIDADE_ERRO(FacesMessage.SEVERITY_ERROR),
	SEVERIDADE_SUCESSO(FacesMessage.SEVERITY_INFO),
	SEVERIDADE_ALERTA(FacesMessage.SEVERITY_WARN),
	
	PAGE_INDEX("index.web"),
	PAGE_CADASTRO_PF("cadastro_pf.web"),
	PAGE_CADASTRO_PJ("cadastro_pj.web")
	
	;
    
	private String valor;
	private FacesMessage.Severity severidade;
    
	private AplicacaoEnum(String valor){
        this.valor = valor;
    }
	
	private AplicacaoEnum(FacesMessage.Severity severidade){
        this.severidade = severidade;
    }

	public String getValor() {
		return valor;
	}
	public FacesMessage.Severity getSeveridade() {
		return severidade;
	}
}
