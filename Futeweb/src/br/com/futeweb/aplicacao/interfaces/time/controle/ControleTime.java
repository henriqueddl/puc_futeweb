package br.com.futeweb.aplicacao.interfaces.time.controle;

import java.sql.SQLException;
import java.util.List;

import javax.ejb.Stateless;
import javax.faces.application.FacesMessage;

import br.com.futeweb.aplicacao.dao.generico.GenericoDAO;
import br.com.futeweb.aplicacao.interfaces.time.dao.TimeDAO;
import br.com.futeweb.aplicacao.interfaces.time.entidade.Time;
import br.com.futeweb.aplicacao.utils.Logger;
import br.com.futeweb.aplicacao.utils.Mensagens;

@Stateless
public class ControleTime extends GenericoDAO implements IControleTime {

	private static final long serialVersionUID = 1L;
	private TimeDAO dao;
	
	private TimeDAO getInstance(){
		if (dao==null){
			dao = new TimeDAO();
		}
		return dao;
	}
	
	@Override
	public int inserir(Time object) throws SQLException {
		int retorno = 0;
		if (object.validarObjeto(object)){
			retorno = getInstance().inserir(object);
			if (retorno!=0){
				new Logger(true, FacesMessage.SEVERITY_INFO, Mensagens.OK_QUADRA_INSERIR, Mensagens.ID_CAMPO_MENSAGEM_INDEX);
			}else{
				new Logger(true, FacesMessage.SEVERITY_ERROR, Mensagens.ERRO_QUADRA_INSERIR_0, Mensagens.ID_CAMPO_MENSAGEM_INDEX);
			}
		}else{
			new Logger(true, FacesMessage.SEVERITY_ERROR, Mensagens.ERRO_PREENCHIMENTO, Mensagens.ID_CAMPO_MENSAGEM_INDEX);
		}
		return retorno;
	}


	public int inserirJogadorTime(Time object,int id_jogador) throws SQLException {
		int retorno = 0;
		if (object.validarObjeto(object)){
			retorno = getInstance().inserirJogadorTime(object, id_jogador);
			if (retorno!=0){
				new Logger(true, FacesMessage.SEVERITY_INFO, Mensagens.OK_QUADRA_INSERIR, Mensagens.ID_CAMPO_MENSAGEM_INDEX);
			}else{
				new Logger(true, FacesMessage.SEVERITY_ERROR, Mensagens.ERRO_QUADRA_INSERIR_0, Mensagens.ID_CAMPO_MENSAGEM_INDEX);
			}
		}else{
			new Logger(true, FacesMessage.SEVERITY_ERROR, Mensagens.ERRO_PREENCHIMENTO, Mensagens.ID_CAMPO_MENSAGEM_INDEX);
		}
		return retorno;
	}	
	
	
	@Override
	public List<Time> obterTodos() {
		List<Time> lista = getInstance().obterTodos();
		if (lista==null || lista.size()==0){
			new Logger(true, FacesMessage.SEVERITY_ERROR, Mensagens.ERRO_QUADRA_CONSULTAR, Mensagens.ID_CAMPO_MENSAGEM_INDEX);
		}
		return lista;
	}

	@Override
	public List<Time> obterPorCriterio(Time object) throws SQLException {
		List<Time> lista = getInstance().obterPorCriterio(object);
		if (lista==null || lista.size()==0){
			new Logger(true, FacesMessage.SEVERITY_ERROR, Mensagens.ERRO_QUADRA_CONSULTAR, Mensagens.ID_CAMPO_MENSAGEM_INDEX);
		}
		return lista;
	}
	
	@Override
	public int atualizar(Time object) throws SQLException {
		int retorno = 0;
		if (object.validarObjeto(object)){
			retorno = getInstance().atualizar(object);
			if (retorno!=0){
				new Logger(true, FacesMessage.SEVERITY_INFO, Mensagens.OK_QUADRA_ATUALIZAR, Mensagens.ID_CAMPO_MENSAGEM_INDEX);
			}else{
				new Logger(true, FacesMessage.SEVERITY_ERROR, Mensagens.ERRO_QUADRA_ATUALIZAR_0, Mensagens.ID_CAMPO_MENSAGEM_INDEX);
			}
		}else{
			new Logger(true, FacesMessage.SEVERITY_ERROR, Mensagens.ERRO_PREENCHIMENTO, Mensagens.ID_CAMPO_MENSAGEM_INDEX);
		}
		return retorno;
	}
}
