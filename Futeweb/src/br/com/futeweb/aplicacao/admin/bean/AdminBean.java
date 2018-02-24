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
	
	public void abrirConta(){

	}
	
	public void teste(){
		System.out.println("chamou teste");
		
	}
	
	public void acessarQuadra() {
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect(AplicacaoEnum.PAGE_QUADRA.getValor());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			new Logger(true, FacesMessage.SEVERITY_ERROR, Mensagens.ERRO_ATENTICAR.replace(Mensagens.PARAMETRO_EXCEPTION, e.getMessage()) , Mensagens.ID_CAMPO_MENSAGEM_INDEX);
		}		
	}
	
	
	public void cadastrarJogo() {
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect(AplicacaoEnum.PAGE_JOGO.getValor());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			new Logger(true, FacesMessage.SEVERITY_ERROR, Mensagens.ERRO_ATENTICAR.replace(Mensagens.PARAMETRO_EXCEPTION, e.getMessage()) , Mensagens.ID_CAMPO_MENSAGEM_INDEX);
		}		
	}
	
	public void cadastrarTime() {
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect(AplicacaoEnum.PAGE_TIME.getValor());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			new Logger(true, FacesMessage.SEVERITY_ERROR, Mensagens.ERRO_ATENTICAR.replace(Mensagens.PARAMETRO_EXCEPTION, e.getMessage()) , Mensagens.ID_CAMPO_MENSAGEM_INDEX);
		}		
	}
	
	public void cadastrarCampeonato() {
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect(AplicacaoEnum.PAGE_CAMPEONATO.getValor());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			new Logger(true, FacesMessage.SEVERITY_ERROR, Mensagens.ERRO_ATENTICAR.replace(Mensagens.PARAMETRO_EXCEPTION, e.getMessage()) , Mensagens.ID_CAMPO_MENSAGEM_INDEX);
		}		
	}
	
	public void cadastrarClassificacao() {
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect(AplicacaoEnum.PAGE_CLASSIFICACAO.getValor());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			new Logger(true, FacesMessage.SEVERITY_ERROR, Mensagens.ERRO_ATENTICAR.replace(Mensagens.PARAMETRO_EXCEPTION, e.getMessage()) , Mensagens.ID_CAMPO_MENSAGEM_INDEX);
		}		
	}
	
	
	public int idUltimoTimeCadastrado(){
		return facadeAdmin.getControleJogadoresTime().IdUltimoTimeCadastrado();
	}

	public String NomeUltimoTimeCadastrado(){
		return facadeAdmin.getControleJogadoresTime().NomeUltimoTimeCadastrado();
	}	
	
	
	public int idUltimoCampeonatoCadastrado(){
		return 1;// facadeAdmin.getControleTimesCampeonato().IdUltimoCampeonatoCadastrado();
	}

	public String NomeUltimoCampeonatoCadastrado(){
		return "1";//facadeAdmin.getControleTimesCampeonato().NomeUltimoCampeonatoCadastrado();
	}	
	
	public void inserirTime(){
		try {
			if(time !=null && time.getNome()!=null && time.getDescricao()!=null) {
			if (facadeAdmin.getControleTime().inserir(time) != 0){
				try {
					FacesContext.getCurrentInstance().getExternalContext().redirect(AplicacaoEnum.PAGE_INSERIRJOGADORESTIME.getValor());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}				
			};
			//return 1;
			}	
		} catch (SQLException e) {
	//		// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void inserirCampeonato(){
		try {
			int retorno = 0;
			if(campeonato !=null && campeonato.getNome()!=null && campeonato.getDataInicio()!=null && campeonato.getDataFim() != null){
			if (facadeAdmin.getControleCampeonato().inserir(campeonato) != 0){
				try {
					FacesContext.getCurrentInstance().getExternalContext().redirect(AplicacaoEnum.PAGE_INSERIRTIMESCAMPEONATO.getValor());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}				
			};
			//return 1;
			}	
		} catch (SQLException e) {
	//		// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void inserirJogadoresTime(){
		try {
			int retorno = 0;
			if((jogadorestime !=null) && (jogadorestime.getIdtime()!=0) && (jogadorestime.getIdjogador()!=0)){
			if (facadeAdmin.getControleJogadoresTime().inserir(jogadorestime) != 0){
				try {
					FacesContext.getCurrentInstance().getExternalContext().redirect(AplicacaoEnum.PAGE_INSERIRJOGADORESTIME.getValor());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}				
			};
			//return 1;
			}	
		} catch (SQLException e) {
	//		// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	public void inserirTimesCampeonato(){
		try {
			int retorno = 0;
			if(timescampeonato !=null && timescampeonato.getIdtime()!=0 && timescampeonato.getIdcampeonato()!=0 && campeonato.getDataFim() != null){
			if (facadeAdmin.getControleTimesCampeonato().inserir(timescampeonato) != 0){
				try {
					FacesContext.getCurrentInstance().getExternalContext().redirect(AplicacaoEnum.PAGE_INSERIRTIMESCAMPEONATO.getValor());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}				
			};
			//return 1;
			}	
		} catch (SQLException e) {
	//		// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
	// ---------- ESTABELECIMENTO ----------
	
	public void cadastrarEstabelecimento() {
		if (estabelecimento.validarObjeto(estabelecimento)){
			try {
				if (0 != facadeAdmin.getControleEstabelecimento().inserir(estabelecimento)){
					new Logger(true, FacesMessage.SEVERITY_INFO, Mensagens.OK_ESTABELECIMENTO_INSERIR, Mensagens.ID_CAMPO_MENSAGEM_INDEX);
				}else{
					new Logger(true, FacesMessage.SEVERITY_ERROR, Mensagens.ERRO_ESTABELECIMENTO_INSERIR_0, Mensagens.ID_CAMPO_MENSAGEM_INDEX);
				}
			} catch (SQLException e) {
				new Logger(true, FacesMessage.SEVERITY_ERROR, Mensagens.ERRO_ESTABELECIMENTO_INSERIR.replace(Mensagens.PARAMETRO_EXCEPTION, e.getMessage()) , Mensagens.ID_CAMPO_MENSAGEM_INDEX);
			}
		}else{
			new Logger(true, FacesMessage.SEVERITY_ERROR, Mensagens.ERRO_PREENCHIMENTO, Mensagens.ID_CAMPO_MENSAGEM_INDEX);
		}
	}
	
	public void obterEstabelecimento() {
		listEstabelecimento = facadeAdmin.getControleEstabelecimento().obterTodos();
		if (listEstabelecimento==null || listEstabelecimento.size()==0){
			new Logger(true, FacesMessage.SEVERITY_ERROR, Mensagens.ERRO_ESTABELECIMENTO_CONSULTAR, Mensagens.ID_CAMPO_MENSAGEM_INDEX);
		}
	}
	
	public void obterEstabelecimentoPorCriterio() {
		try {
			listEstabelecimento = facadeAdmin.getControleEstabelecimento().obterPorCriterio(estabelecimento);
			if (listEstabelecimento==null || listEstabelecimento.size()==0){
				new Logger(true, FacesMessage.SEVERITY_ERROR, Mensagens.ERRO_ESTABELECIMENTO_CONSULTAR, Mensagens.ID_CAMPO_MENSAGEM_INDEX);
			}
		} catch (SQLException e) {
			new Logger(true, FacesMessage.SEVERITY_ERROR, Mensagens.ERRO_ESTABELECIMENTO_CONSULTAR_EXCEPTION.replace(Mensagens.PARAMETRO_EXCEPTION, e.getMessage()), Mensagens.ID_CAMPO_MENSAGEM_INDEX);
		}
	}
	
	public void atualizarEstabelecimento(){
		if (estabelecimento.validarObjeto(estabelecimento)){
			try {
				if (0 != facadeAdmin.getControleEstabelecimento().atualizar(estabelecimento)){
					new Logger(true, FacesMessage.SEVERITY_INFO, Mensagens.OK_ESTABELECIMENTO_ATUALIZAR, Mensagens.ID_CAMPO_MENSAGEM_INDEX);
				}else{
					new Logger(true, FacesMessage.SEVERITY_ERROR, Mensagens.ERRO_ESTABELECIMENTO_ATUALIZAR_0, Mensagens.ID_CAMPO_MENSAGEM_INDEX);
				}
			} catch (SQLException e) {
				new Logger(true, FacesMessage.SEVERITY_ERROR, Mensagens.ERRO_ESTABELECIMENTO_ATUALIZAR.replace(Mensagens.PARAMETRO_EXCEPTION, e.getMessage()) , Mensagens.ID_CAMPO_MENSAGEM_INDEX);
			}
		}else{
			new Logger(true, FacesMessage.SEVERITY_ERROR, Mensagens.ERRO_PREENCHIMENTO, Mensagens.ID_CAMPO_MENSAGEM_INDEX);
		}
	}
	
	// ---------- MATERIAL ----------
	
	public void cadastrarMaterial() {
		if (material.validarObjeto(material) && estabelecimento.getId()!=0){
			try {
				if (0 != facadeAdmin.getControleMaterial().inserir(material, estabelecimento.getId())){
					new Logger(true, FacesMessage.SEVERITY_INFO, Mensagens.OK_MATERIAL_INSERIR, Mensagens.ID_CAMPO_MENSAGEM_INDEX);
				}else{
					new Logger(true, FacesMessage.SEVERITY_ERROR, Mensagens.ERRO_MATERIAL_INSERIR_0, Mensagens.ID_CAMPO_MENSAGEM_INDEX);
				}
			} catch (SQLException e) {
				new Logger(true, FacesMessage.SEVERITY_ERROR, Mensagens.ERRO_MATERIAL_INSERIR.replace(Mensagens.PARAMETRO_EXCEPTION, e.getMessage()) , Mensagens.ID_CAMPO_MENSAGEM_INDEX);
			}
		}else{
			new Logger(true, FacesMessage.SEVERITY_ERROR, Mensagens.ERRO_PREENCHIMENTO, Mensagens.ID_CAMPO_MENSAGEM_INDEX);
		}
	}
	
	public void obterMaterial() {
		listMaterial = facadeAdmin.getControleMaterial().obterTodos();
		if (listMaterial==null || listMaterial.size()==0){
			new Logger(true, FacesMessage.SEVERITY_ERROR, Mensagens.ERRO_MATERIAL_CONSULTAR, Mensagens.ID_CAMPO_MENSAGEM_INDEX);
		}
	}
	
	public void obterMaterialPorCriterio() {
		try {
			listMaterial = facadeAdmin.getControleMaterial().obterPorCriterio(material);
			if (listMaterial==null || listMaterial.size()==0){
				new Logger(true, FacesMessage.SEVERITY_ERROR, Mensagens.ERRO_MATERIAL_CONSULTAR, Mensagens.ID_CAMPO_MENSAGEM_INDEX);
			}
		} catch (SQLException e) {
			new Logger(true, FacesMessage.SEVERITY_ERROR, Mensagens.ERRO_ESTABELECIMENTO_CONSULTAR_EXCEPTION.replace(Mensagens.PARAMETRO_EXCEPTION, e.getMessage()), Mensagens.ID_CAMPO_MENSAGEM_INDEX);
		}
	}
	
	public void atualizarMaterial() {
		if (material.validarObjeto(material)){
			try {
				if (0 != facadeAdmin.getControleMaterial().atualizar(material)){
					new Logger(true, FacesMessage.SEVERITY_INFO, Mensagens.OK_MATERIAL_ATUALIZAR, Mensagens.ID_CAMPO_MENSAGEM_INDEX);
				}else{
					new Logger(true, FacesMessage.SEVERITY_ERROR, Mensagens.ERRO_MATERIAL_ATUALIZAR_0, Mensagens.ID_CAMPO_MENSAGEM_INDEX);
				}
			} catch (SQLException e) {
				new Logger(true, FacesMessage.SEVERITY_ERROR, Mensagens.ERRO_MATERIAL_ATUALIZAR.replace(Mensagens.PARAMETRO_EXCEPTION, e.getMessage()) , Mensagens.ID_CAMPO_MENSAGEM_INDEX);
			}
		}else{
			new Logger(true, FacesMessage.SEVERITY_ERROR, Mensagens.ERRO_PREENCHIMENTO, Mensagens.ID_CAMPO_MENSAGEM_INDEX);
		}
	}
	
	
	// ---------- QUADRA ----------
	
	public void cadastrarQuadra() {
		if (quadra.validarObjeto(quadra) && estabelecimento.getId()!=0){
			try {
				if (0 != facadeAdmin.getControleQuadra().inserir(quadra, estabelecimento.getId())){
					new Logger(true, FacesMessage.SEVERITY_INFO, Mensagens.OK_QUADRA_INSERIR, Mensagens.ID_CAMPO_MENSAGEM_INDEX);
				}else{
					new Logger(true, FacesMessage.SEVERITY_ERROR, Mensagens.ERRO_QUADRA_INSERIR_0, Mensagens.ID_CAMPO_MENSAGEM_INDEX);
				}
			} catch (SQLException e) {
				new Logger(true, FacesMessage.SEVERITY_ERROR, Mensagens.ERRO_QUADRA_INSERIR.replace(Mensagens.PARAMETRO_EXCEPTION, e.getMessage()) , Mensagens.ID_CAMPO_MENSAGEM_INDEX);
			}
		}else{
			new Logger(true, FacesMessage.SEVERITY_ERROR, Mensagens.ERRO_PREENCHIMENTO, Mensagens.ID_CAMPO_MENSAGEM_INDEX);
		}
	}
	
	public void obterQuadra() {
		listQuadra = facadeAdmin.getControleQuadra().obterTodos();
		if (listQuadra==null || listQuadra.size()==0){
			new Logger(true, FacesMessage.SEVERITY_ERROR, Mensagens.ERRO_QUADRA_CONSULTAR, Mensagens.ID_CAMPO_MENSAGEM_INDEX);
		}
	}
	
	public void obterQuadraPorCriterio() {
		try {
			listQuadra = facadeAdmin.getControleQuadra().obterPorCriterio(quadra);
			if (listQuadra==null || listQuadra.size()==0){
				new Logger(true, FacesMessage.SEVERITY_ERROR, Mensagens.ERRO_QUADRA_CONSULTAR, Mensagens.ID_CAMPO_MENSAGEM_INDEX);
			}
		} catch (SQLException e) {
			new Logger(true, FacesMessage.SEVERITY_ERROR, Mensagens.ERRO_ESTABELECIMENTO_CONSULTAR_EXCEPTION.replace(Mensagens.PARAMETRO_EXCEPTION, e.getMessage()), Mensagens.ID_CAMPO_MENSAGEM_INDEX);
		}
	}
	
	public void atualizarQuadra() {
		if (quadra.validarObjeto(quadra)){
			try {
				if (0 != facadeAdmin.getControleQuadra().atualizar(quadra)){
					new Logger(true, FacesMessage.SEVERITY_INFO, Mensagens.OK_QUADRA_ATUALIZAR, Mensagens.ID_CAMPO_MENSAGEM_INDEX);
				}else{
					new Logger(true, FacesMessage.SEVERITY_ERROR, Mensagens.ERRO_QUADRA_ATUALIZAR_0, Mensagens.ID_CAMPO_MENSAGEM_INDEX);
				}
			} catch (SQLException e) {
				new Logger(true, FacesMessage.SEVERITY_ERROR, Mensagens.ERRO_QUADRA_ATUALIZAR.replace(Mensagens.PARAMETRO_EXCEPTION, e.getMessage()) , Mensagens.ID_CAMPO_MENSAGEM_INDEX);
			}
		}else{
			new Logger(true, FacesMessage.SEVERITY_ERROR, Mensagens.ERRO_PREENCHIMENTO, Mensagens.ID_CAMPO_MENSAGEM_INDEX);
		}
	}
	
	// ---------- RESERVA ----------
	
	public void cadastrarReserva() {
		if (reserva.validarObjeto(reserva)){
			try {
				if (0 != facadeAdmin.getControleReserva().inserir(reserva)){
					new Logger(true, FacesMessage.SEVERITY_INFO, Mensagens.OK_RESERVA_INSERIR, Mensagens.ID_CAMPO_MENSAGEM_INDEX);
				}else{
					new Logger(true, FacesMessage.SEVERITY_ERROR, Mensagens.ERRO_RESERVA_INSERIR_0, Mensagens.ID_CAMPO_MENSAGEM_INDEX);
				}
			} catch (SQLException e) {
				new Logger(true, FacesMessage.SEVERITY_ERROR, Mensagens.ERRO_RESERVA_INSERIR.replace(Mensagens.PARAMETRO_EXCEPTION, e.getMessage()) , Mensagens.ID_CAMPO_MENSAGEM_INDEX);
			}
		}else{
			new Logger(true, FacesMessage.SEVERITY_ERROR, Mensagens.ERRO_PREENCHIMENTO, Mensagens.ID_CAMPO_MENSAGEM_INDEX);
		}
	}
	
	public void obterReserva() {
		listReserva = facadeAdmin.getControleReserva().obterTodos();
		if (listReserva==null || listReserva.size()==0){
			new Logger(true, FacesMessage.SEVERITY_ERROR, Mensagens.ERRO_RESERVA_CONSULTAR, Mensagens.ID_CAMPO_MENSAGEM_INDEX);
		}
	}
	
	public void obterReservaPorCriterio() {
		try {
			listReserva = facadeAdmin.getControleReserva().obterPorCriterio(reserva);
			if (listReserva==null || listReserva.size()==0){
				new Logger(true, FacesMessage.SEVERITY_ERROR, Mensagens.ERRO_RESERVA_CONSULTAR, Mensagens.ID_CAMPO_MENSAGEM_INDEX);
			}
		} catch (SQLException e) {
			new Logger(true, FacesMessage.SEVERITY_ERROR, Mensagens.ERRO_ESTABELECIMENTO_CONSULTAR_EXCEPTION.replace(Mensagens.PARAMETRO_EXCEPTION, e.getMessage()), Mensagens.ID_CAMPO_MENSAGEM_INDEX);
		}
	}
	
	public void removerReserva() {
		if (reserva.validarObjeto(reserva)){
			try {
				if (0 != facadeAdmin.getControleReserva().atualizar(reserva)){
					new Logger(true, FacesMessage.SEVERITY_INFO, Mensagens.OK_RESERVA_REMOVER, Mensagens.ID_CAMPO_MENSAGEM_INDEX);
				}else{
					new Logger(true, FacesMessage.SEVERITY_ERROR, Mensagens.ERRO_RESERVA_REMOVER_0, Mensagens.ID_CAMPO_MENSAGEM_INDEX);
				}
			} catch (SQLException e) {
				new Logger(true, FacesMessage.SEVERITY_ERROR, Mensagens.ERRO_RESERVA_REMOVER.replace(Mensagens.PARAMETRO_EXCEPTION, e.getMessage()) , Mensagens.ID_CAMPO_MENSAGEM_INDEX);
			}
		}else{
			new Logger(true, FacesMessage.SEVERITY_ERROR, Mensagens.ERRO_PREENCHIMENTO, Mensagens.ID_CAMPO_MENSAGEM_INDEX);
		}
	}
	
	// ---------- USUARIO ----------
	
	public void cadastrarUsuario() {
		if (usuario.validarObjeto(usuario)){
			try {
				if (0 != facadeAdmin.getControleUsuario().inserir(usuario)){
					new Logger(true, FacesMessage.SEVERITY_INFO, Mensagens.OK_USUARIO_INSERIR, Mensagens.ID_CAMPO_MENSAGEM_INDEX);
				}else{
					new Logger(true, FacesMessage.SEVERITY_ERROR, Mensagens.ERRO_USUARIO_INSERIR_0, Mensagens.ID_CAMPO_MENSAGEM_INDEX);
				}
			} catch (SQLException e) {
				new Logger(true, FacesMessage.SEVERITY_ERROR, Mensagens.ERRO_USUARIO_INSERIR.replace(Mensagens.PARAMETRO_EXCEPTION, e.getMessage()) , Mensagens.ID_CAMPO_MENSAGEM_INDEX);
			}
		}else{
			new Logger(true, FacesMessage.SEVERITY_ERROR, Mensagens.ERRO_PREENCHIMENTO, Mensagens.ID_CAMPO_MENSAGEM_INDEX);
		}
	}
	
	public void obterUsuario() {
		listUsuario = facadeAdmin.getControleUsuario().obterTodos();
		if (listUsuario==null || listUsuario.size()==0){
			new Logger(true, FacesMessage.SEVERITY_ERROR, Mensagens.ERRO_USUARIO_CONSULTAR, Mensagens.ID_CAMPO_MENSAGEM_INDEX);
		}
	}
	
	public void obterUsuarioPorCriterio() {
		try {
			listUsuario = facadeAdmin.getControleUsuario().obterPorCriterio(usuario);
			if (listUsuario==null || listUsuario.size()==0){
				new Logger(true, FacesMessage.SEVERITY_ERROR, Mensagens.ERRO_USUARIO_CONSULTAR, Mensagens.ID_CAMPO_MENSAGEM_INDEX);
			}
		} catch (SQLException e) {
			new Logger(true, FacesMessage.SEVERITY_ERROR, Mensagens.ERRO_ESTABELECIMENTO_CONSULTAR_EXCEPTION.replace(Mensagens.PARAMETRO_EXCEPTION, e.getMessage()), Mensagens.ID_CAMPO_MENSAGEM_INDEX);
		}
	}
	
	public void atualizarUsuario() {
		if (usuario.validarObjeto(usuario)){
			try {
				if (0 != facadeAdmin.getControleUsuario().atualizar(usuario)){
					new Logger(true, FacesMessage.SEVERITY_INFO, Mensagens.OK_USUARIO_ATUALIZAR, Mensagens.ID_CAMPO_MENSAGEM_INDEX);
				}else{
					new Logger(true, FacesMessage.SEVERITY_ERROR, Mensagens.ERRO_USUARIO_ATUALIZAR_0, Mensagens.ID_CAMPO_MENSAGEM_INDEX);
				}
			} catch (SQLException e) {
				new Logger(true, FacesMessage.SEVERITY_ERROR, Mensagens.ERRO_USUARIO_ATUALIZAR.replace(Mensagens.PARAMETRO_EXCEPTION, e.getMessage()) , Mensagens.ID_CAMPO_MENSAGEM_INDEX);
			}
		}else{
			new Logger(true, FacesMessage.SEVERITY_ERROR, Mensagens.ERRO_PREENCHIMENTO, Mensagens.ID_CAMPO_MENSAGEM_INDEX);
		}
	}
	
	// ---------- PESSOA FISICA ----------
	
	public void cadastrarPessoaFisica() {
		if (pessoaFisica.validarObjeto(pessoaFisica)){
			try {
				if (0 != facadeAdmin.getControleUsuario().inserir(pessoaFisica)){
					new Logger(true, FacesMessage.SEVERITY_INFO, Mensagens.OK_USUARIO_INSERIR, Mensagens.ID_CAMPO_MENSAGEM_INDEX);
				}else{
					new Logger(true, FacesMessage.SEVERITY_ERROR, Mensagens.ERRO_USUARIO_INSERIR_0, Mensagens.ID_CAMPO_MENSAGEM_INDEX);
				}
			} catch (SQLException e) {
				new Logger(true, FacesMessage.SEVERITY_ERROR, Mensagens.ERRO_USUARIO_INSERIR.replace(Mensagens.PARAMETRO_EXCEPTION, e.getMessage()) , Mensagens.ID_CAMPO_MENSAGEM_INDEX);
			}
		}else{
			new Logger(true, FacesMessage.SEVERITY_ERROR, Mensagens.ERRO_PREENCHIMENTO, Mensagens.ID_CAMPO_MENSAGEM_INDEX);
		}
	}
	
	public void obterPessoaFisica() {
		listPessoaFisica = facadeAdmin.getControleUsuario().obterPessoaFisica();
		if (listPessoaFisica==null || listPessoaFisica.size()==0){
			new Logger(true, FacesMessage.SEVERITY_ERROR, Mensagens.ERRO_USUARIO_CONSULTAR, Mensagens.ID_CAMPO_MENSAGEM_INDEX);
		}
	}
	
	public void obterPessoaFisicaCriterio() {
		try {
			listPessoaFisica = facadeAdmin.getControleUsuario().obterPorCriterio(pessoaFisica);
			if (listPessoaFisica==null || listPessoaFisica.size()==0){
				new Logger(true, FacesMessage.SEVERITY_ERROR, Mensagens.ERRO_USUARIO_CONSULTAR, Mensagens.ID_CAMPO_MENSAGEM_INDEX);
			}
		} catch (SQLException e) {
			new Logger(true, FacesMessage.SEVERITY_ERROR, Mensagens.ERRO_ESTABELECIMENTO_CONSULTAR_EXCEPTION.replace(Mensagens.PARAMETRO_EXCEPTION, e.getMessage()), Mensagens.ID_CAMPO_MENSAGEM_INDEX);
		}
	}
		
	public void atualizarPessoaFisica() {
		if (pessoaFisica.validarObjeto(pessoaFisica)){
			try {
				if (0 != facadeAdmin.getControleUsuario().atualizar(pessoaFisica)){
					new Logger(true, FacesMessage.SEVERITY_INFO, Mensagens.OK_USUARIO_ATUALIZAR, Mensagens.ID_CAMPO_MENSAGEM_INDEX);
				}else{
					new Logger(true, FacesMessage.SEVERITY_ERROR, Mensagens.ERRO_USUARIO_ATUALIZAR_0, Mensagens.ID_CAMPO_MENSAGEM_INDEX);
				}
			} catch (SQLException e) {
				new Logger(true, FacesMessage.SEVERITY_ERROR, Mensagens.ERRO_USUARIO_ATUALIZAR.replace(Mensagens.PARAMETRO_EXCEPTION, e.getMessage()) , Mensagens.ID_CAMPO_MENSAGEM_INDEX);
			}
		}else{
			new Logger(true, FacesMessage.SEVERITY_ERROR, Mensagens.ERRO_PREENCHIMENTO, Mensagens.ID_CAMPO_MENSAGEM_INDEX);
		}
	}
	
	// ---------- PESSOA JURIDICA ----------
	
	public void cadastrarPessoaJuridica() {
		if (pessoaJuridica.validarObjeto(pessoaJuridica)){
			try {
				if (0 != facadeAdmin.getControleUsuario().inserir(pessoaJuridica)){
					new Logger(true, FacesMessage.SEVERITY_INFO, Mensagens.OK_USUARIO_INSERIR, Mensagens.ID_CAMPO_MENSAGEM_INDEX);
				}else{
					new Logger(true, FacesMessage.SEVERITY_ERROR, Mensagens.ERRO_USUARIO_INSERIR_0, Mensagens.ID_CAMPO_MENSAGEM_INDEX);
				}
			} catch (SQLException e) {
				new Logger(true, FacesMessage.SEVERITY_ERROR, Mensagens.ERRO_USUARIO_INSERIR.replace(Mensagens.PARAMETRO_EXCEPTION, e.getMessage()) , Mensagens.ID_CAMPO_MENSAGEM_INDEX);
			}
		}else{
			new Logger(true, FacesMessage.SEVERITY_ERROR, Mensagens.ERRO_PREENCHIMENTO, Mensagens.ID_CAMPO_MENSAGEM_INDEX);
		}
	}
	
	public void obterPessoaJuridica() {
		listPessoaJuridica = facadeAdmin.getControleUsuario().obterPessoaJuridica();
		if (listPessoaJuridica==null || listPessoaJuridica.size()==0){
			new Logger(true, FacesMessage.SEVERITY_ERROR, Mensagens.ERRO_USUARIO_CONSULTAR, Mensagens.ID_CAMPO_MENSAGEM_INDEX);
		}
	}
	
	public void obterPessoaJuridicaCriterio() {
		try {
			listPessoaJuridica = facadeAdmin.getControleUsuario().obterPorCriterio(pessoaJuridica);
			if (listPessoaJuridica==null || listPessoaJuridica.size()==0){
				new Logger(true, FacesMessage.SEVERITY_ERROR, Mensagens.ERRO_USUARIO_CONSULTAR, Mensagens.ID_CAMPO_MENSAGEM_INDEX);
			}
		} catch (SQLException e) {
			new Logger(true, FacesMessage.SEVERITY_ERROR, Mensagens.ERRO_ESTABELECIMENTO_CONSULTAR_EXCEPTION.replace(Mensagens.PARAMETRO_EXCEPTION, e.getMessage()), Mensagens.ID_CAMPO_MENSAGEM_INDEX);
		}
	}
	
	public void atualizarPessoaJuridica() {
		if (pessoaJuridica.validarObjeto(pessoaJuridica)){
			try {
				if (0 != facadeAdmin.getControleUsuario().atualizar(pessoaJuridica)){
					new Logger(true, FacesMessage.SEVERITY_INFO, Mensagens.OK_USUARIO_ATUALIZAR, Mensagens.ID_CAMPO_MENSAGEM_INDEX);
				}else{
					new Logger(true, FacesMessage.SEVERITY_ERROR, Mensagens.ERRO_USUARIO_ATUALIZAR_0, Mensagens.ID_CAMPO_MENSAGEM_INDEX);
				}
			} catch (SQLException e) {
				new Logger(true, FacesMessage.SEVERITY_ERROR, Mensagens.ERRO_USUARIO_ATUALIZAR.replace(Mensagens.PARAMETRO_EXCEPTION, e.getMessage()) , Mensagens.ID_CAMPO_MENSAGEM_INDEX);
			}
		}else{
			new Logger(true, FacesMessage.SEVERITY_ERROR, Mensagens.ERRO_PREENCHIMENTO, Mensagens.ID_CAMPO_MENSAGEM_INDEX);
		}
	}
	
	// ---------- AUTENTICAÇÃO ----------
	
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
						FacesContext.getCurrentInstance().getExternalContext().redirect(AplicacaoEnum.PAGE_INDEX.getValor());
					} 
				}else {
					new Logger(true, FacesMessage.SEVERITY_ERROR, Mensagens.ERRO_AUTENTICAR_PREENCHIMENTO, Mensagens.ID_CAMPO_MENSAGEM_INDEX);
				}
			}
		} catch (IOException | SQLException e) {
			new Logger(true, FacesMessage.SEVERITY_ERROR, Mensagens.ERRO_ATENTICAR.replace(Mensagens.PARAMETRO_EXCEPTION, e.getMessage()) , Mensagens.ID_CAMPO_MENSAGEM_INDEX);
		}
	}
}
