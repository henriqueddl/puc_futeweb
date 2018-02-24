package br.com.futeweb.aplicacao.interfaces.timescampeonato.controle;

import java.sql.SQLException;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

import javax.ejb.Stateless;
import javax.faces.application.FacesMessage;

import br.com.futeweb.aplicacao.dao.generico.GenericoDAO;
import br.com.futeweb.aplicacao.interfaces.timescampeonato.dao.TimesCampeonatoDAO;
import br.com.futeweb.aplicacao.interfaces.time.entidade.Time;
import br.com.futeweb.aplicacao.interfaces.timescampeonato.entidade.TimesCampeonato;
import br.com.futeweb.aplicacao.interfaces.campeonato.entidade.Campeonato;
import br.com.futeweb.aplicacao.utils.Logger;
import br.com.futeweb.aplicacao.utils.Mensagens;

@Stateless
public class ControleTimesCampeonato extends GenericoDAO implements IControleTimesCampeonato {

	private static final long serialVersionUID = 1L;
	private TimesCampeonatoDAO dao;
	
	private TimesCampeonatoDAO getInstance(){
		if (dao==null){
			dao = new TimesCampeonatoDAO();
		}
		return dao;
	}
	
	@Override
	public int inserir(TimesCampeonato object) throws SQLException {
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



	public int inserirTimesCampeonato(Campeonato object,int id_time) throws SQLException {
		int retorno = 0;
		if (object.validarObjeto(object)){
			retorno = getInstance().inserirTimesCampeonato(object, id_time);
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
	public List<TimesCampeonato> obterTodos() {
		List<TimesCampeonato> lista = getInstance().obterTodos();
		if (lista==null || lista.size()==0){
			new Logger(true, FacesMessage.SEVERITY_ERROR, Mensagens.ERRO_QUADRA_CONSULTAR, Mensagens.ID_CAMPO_MENSAGEM_INDEX);
		}
		return lista;
	}

	@Override
	public List<TimesCampeonato> obterPorCriterio(TimesCampeonato object) throws SQLException {
		List<TimesCampeonato> lista = getInstance().obterPorCriterio(object);
		if (lista==null || lista.size()==0){
			new Logger(true, FacesMessage.SEVERITY_ERROR, Mensagens.ERRO_QUADRA_CONSULTAR, Mensagens.ID_CAMPO_MENSAGEM_INDEX);
		}
		return lista;
	}
	
	@Override
	public int atualizar(TimesCampeonato object) throws SQLException {
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
	
	public Map<Integer, String> obterListaCampeonatos() throws SQLException {
		Map<Integer, String> lista = getInstance().obterListaCampeonatos();
		if (lista==null || lista.size()==0){
			new Logger(true, FacesMessage.SEVERITY_ERROR, Mensagens.ERRO_QUADRA_DISPONIBILIDADE_CONSULTAR, Mensagens.ID_CAMPO_MENSAGEM_INDEX);
		}
		return lista;
	}
	
	
	public Map<Integer, String> obterListaTimes() throws SQLException {
		Map<Integer, String> lista = getInstance().obterListaTimes();
		if (lista==null || lista.size()==0){
			new Logger(true, FacesMessage.SEVERITY_ERROR, Mensagens.ERRO_QUADRA_DISPONIBILIDADE_CONSULTAR, Mensagens.ID_CAMPO_MENSAGEM_INDEX);
		}
		return lista;
	}
}
