package br.com.futeweb.aplicacao.admin.bean;

import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.com.futeweb.aplicacao.admin.FacadeAdmin;
import br.com.futeweb.aplicacao.admin.bean.entidade.AdminVO;
import br.com.futeweb.aplicacao.utils.AplicacaoEnum;
import br.com.futeweb.aplicacao.utils.Logger;
import br.com.futeweb.aplicacao.utils.Mensagens;
import br.com.futeweb.aplicacao.utils.Teste;

@Stateless
@SessionScoped
@ManagedBean(name="adminBean")
public class AdminBean extends AdminVO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@EJB(beanName="FacadeAdmin")
	private FacadeAdmin facadeAdmin;
	
	public void abrirConta(){
		Teste teste = new Teste();
		teste.teste();
	}
	
	public void teste(){
		System.out.println("chamou teste");
		
	}
	
	public boolean isLogged(){
		boolean retorno = false;
		try {
			if ( (autenticadoPF!=null && autenticadoPF.getId()!=0) || (autenticadoPJ!=null && autenticadoPJ.getId()!=0)){
				if (!logado){
					logado = true;
					retorno = true;
					new Logger(true, null, Mensagens.OK_ATENTICAR, null);
					FacesContext.getCurrentInstance().getExternalContext().redirect(AplicacaoEnum.PAGE_HOME.getValor());
				}
			}else if (logado){ 
				logado = false;
				FacesContext.getCurrentInstance().getExternalContext().redirect(AplicacaoEnum.PAGE_INDEX.getValor());
			}
		} catch (IOException e) {
			new Logger(true, FacesMessage.SEVERITY_ERROR, Mensagens.ERRO_ATENTICAR.replace(Mensagens.PARAMETRO_EXCEPTION, e.getMessage()) , Mensagens.ID_CAMPO_MENSAGEM_INDEX);
		}
		return  retorno;
	}
	
	public void logout(){
		autenticadoPF = null;
		autenticadoPJ = null;
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect(AplicacaoEnum.PAGE_INDEX.getValor());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void autenticar(){
		try {
			if (!isLogged() ){
				if (usuario!=null && !"".equals(usuario.getLogin()) && !"".equals(usuario.getSenha())){
					autenticadoPF = facadeAdmin.getControleUsuario().autenticarPF(usuario);
					if (autenticadoPF==null){
						autenticadoPJ = facadeAdmin.getControleUsuario().autenticarPJ(usuario); 
					} 
					if ( !isLogged() ){
						new Logger(true, FacesMessage.SEVERITY_ERROR, Mensagens.ERRO_ATENTICAR_0, Mensagens.ID_CAMPO_MENSAGEM_INDEX);
					} 
				}else {
					new Logger(true, FacesMessage.SEVERITY_ERROR, Mensagens.ERRO_AUTENTICAR_PREENCHIMENTO, Mensagens.ID_CAMPO_MENSAGEM_INDEX);
				}
			}
		} catch (SQLException e) {
			new Logger(true, FacesMessage.SEVERITY_ERROR, Mensagens.ERRO_ATENTICAR.replace(Mensagens.PARAMETRO_EXCEPTION, e.getMessage()) , Mensagens.ID_CAMPO_MENSAGEM_INDEX);
		}
	}
}
