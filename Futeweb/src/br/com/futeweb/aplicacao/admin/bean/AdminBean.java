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

@Stateless
@SessionScoped
@ManagedBean(name="adminBean")
public class AdminBean extends AdminVO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@EJB(beanName="FacadeAdmin")
	private FacadeAdmin facadeAdmin;
	
//	public void inserirEndereco(){
//		try {
//			facadeAdmin.getControleEndereco().inserir(endereco);
//		} catch (SQLException e) {
//			new Logger(true, FacesMessage.SEVERITY_ERROR, Mensagens.ERRO_ENDERECO_INSERIR.replace(Mensagens.PARAMETRO_EXCEPTION, e.getMessage()) , Mensagens.ID_CAMPO_MENSAGEM_QUALQUER);
//		}
//	}
	
//	public void buscarCEP(){
//		try {
//			facadeAdmin.getControleEndereco().buscarCep(endereco);
//		} catch (ServiceException | RemoteException e) {
//			if (!"CEP NAO INFORMADO".equalsIgnoreCase(e.toString()) && !"BUSCA DEFINIDA COMO EXATA, 0 CEP DEVE TER 8 DIGITOS".equalsIgnoreCase(e.toString())){
//				new Logger(true, FacesMessage.SEVERITY_ERROR, Mensagens.ERRO_ENDERECO_BUSCA_CEP.replace(Mensagens.PARAMETRO_EXCEPTION, e.getMessage()) , Mensagens.ID_CAMPO_MENSAGEM_QUALQUER);
//			}
//		}
//	}
//	
	
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
			autenticadoPF = facadeAdmin.getControleUsuario().autenticarPF(usuario);
			if (autenticadoPF==null){
				autenticadoPJ = facadeAdmin.getControleUsuario().autenticarPJ(usuario);
			}
			if (autenticadoPF==null && autenticadoPJ==null){
				new Logger(true, FacesMessage.SEVERITY_ERROR, Mensagens.ERRO_ATENTICAR_0, Mensagens.ID_CAMPO_MENSAGEM_QUALQUER);
			}else{
				FacesContext.getCurrentInstance().getExternalContext().redirect(AplicacaoEnum.PAGE_INDEX.getValor());
			}
		} catch (SQLException | IOException e) {
			new Logger(true, FacesMessage.SEVERITY_ERROR, Mensagens.ERRO_ATENTICAR.replace(Mensagens.PARAMETRO_EXCEPTION, e.getMessage()) , Mensagens.ID_CAMPO_MENSAGEM_QUALQUER);
		}
	}
}
