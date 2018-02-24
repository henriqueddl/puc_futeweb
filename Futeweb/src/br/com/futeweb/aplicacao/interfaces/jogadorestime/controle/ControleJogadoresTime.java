package br.com.futeweb.aplicacao.interfaces.jogadorestime.controle;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;
import javax.faces.application.FacesMessage;

import br.com.futeweb.aplicacao.dao.generico.GenericoDAO;
import br.com.futeweb.aplicacao.interfaces.jogadorestime.dao.JogadoresTimeDAO;
import br.com.futeweb.aplicacao.interfaces.jogadorestime.entidade.JogadoresTime;
import br.com.futeweb.aplicacao.utils.Logger;
import br.com.futeweb.aplicacao.utils.Mensagens;

@Stateless
public class ControleJogadoresTime extends GenericoDAO implements IControleJogadoresTime {

	private static final long serialVersionUID = 1L;
	private JogadoresTimeDAO dao;
	
	private JogadoresTimeDAO getInstance(){
		if (dao==null){
			dao = new JogadoresTimeDAO();
		}
		return dao;
	}
	
	@Override
	public int inserir(JogadoresTime object) throws SQLException {
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
	
	public int IdUltimoTimeCadastrado(){
		return getInstance().IdUltimoTimeCadastrado();
	}
	public String NomeUltimoTimeCadastrado(){
		return getInstance().NomeUltimoTimeCadastrado();		
	}


	/*public int inserirJogadorTime(Time object,int id_jogador) throws SQLException {
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
	}	*/
	
	
	@Override
	public List<JogadoresTime> obterTodos() {
		List<JogadoresTime> lista = getInstance().obterTodos();
		if (lista==null || lista.size()==0){
			new Logger(true, FacesMessage.SEVERITY_ERROR, Mensagens.ERRO_QUADRA_CONSULTAR, Mensagens.ID_CAMPO_MENSAGEM_INDEX);
		}
		return lista;
	}

	@Override
	public List<JogadoresTime> obterPorCriterio(JogadoresTime object) throws SQLException {
		List<JogadoresTime> lista = getInstance().obterPorCriterio(object);
		if (lista==null || lista.size()==0){
			new Logger(true, FacesMessage.SEVERITY_ERROR, Mensagens.ERRO_QUADRA_CONSULTAR, Mensagens.ID_CAMPO_MENSAGEM_INDEX);
		}
		return lista;
	}
	
	@Override
	public int atualizar(JogadoresTime object) throws SQLException {
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
	

	public Map<Integer, String> obterListaJogadores() throws SQLException {
		Map<Integer, String> lista = getInstance().obterListaJogadores();
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
