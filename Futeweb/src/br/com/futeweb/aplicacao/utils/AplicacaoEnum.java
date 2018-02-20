package br.com.futeweb.aplicacao.utils;

import javax.faces.application.FacesMessage;

public enum AplicacaoEnum {

	APLICACAO_NOME("Futeweb"),
	SEVERIDADE_ERRO(FacesMessage.SEVERITY_ERROR),
	SEVERIDADE_SUCESSO(FacesMessage.SEVERITY_INFO),
	SEVERIDADE_ALERTA(FacesMessage.SEVERITY_WARN),
	
	PAGE_INDEX("/Futeweb/index.web"),
	PAGE_HOME("/Futeweb/home.web"),
	
	PAGE_ESTABELECIMENTO_CADASTRO("/Futeweb/estabelecimento/cadastro.web"),
	PAGE_ESTABELECIMENTO_ALTERACAO("/Futeweb/estabelecimento/alteracao.web"),
	PAGE_ESTABELECIMENTO_CONSULTA("/Futeweb/estabelecimento/consulta.web"),
	PAGE_ESTABELECIMENTO_REMOCAO("/Futeweb/estabelecimento/remocao.web"),
	
	PAGE_CADASTRO_PF("cadastro_pf.web"),
	PAGE_CADASTRO_PJ("cadastro_pj.web")
	
	;
    
	private AplicacaoEnum tipo;
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
	public AplicacaoEnum getTipo(){
		return tipo;
	}
}
