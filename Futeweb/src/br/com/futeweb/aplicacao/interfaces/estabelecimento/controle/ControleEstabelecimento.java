package br.com.futeweb.aplicacao.interfaces.estabelecimento.controle;

import java.sql.SQLException;
import java.util.List;

import javax.ejb.Stateless;
import javax.faces.application.FacesMessage;

import br.com.futeweb.aplicacao.dao.generico.GenericoDAO;
import br.com.futeweb.aplicacao.interfaces.estabelecimento.dao.EstabelecimentoDAO;
import br.com.futeweb.aplicacao.interfaces.estabelecimento.entidade.Estabelecimento;
import br.com.futeweb.aplicacao.utils.Logger;
import br.com.futeweb.aplicacao.utils.Mensagens;

@Stateless
public class ControleEstabelecimento extends GenericoDAO implements IControleEstabelecimento {

	private static final long serialVersionUID = 1L;
	
	private EstabelecimentoDAO dao;
	
	private EstabelecimentoDAO getInstance(){
		if (dao==null){
			dao = new EstabelecimentoDAO();
		}
		return dao;
	}

	@Override
	public int inserir(Estabelecimento object) throws SQLException {
		int retorno = 0;
		if (object.validarObjeto(object)){
			retorno = getInstance().inserir(object);
			if (retorno!=0){
				new Logger(true, FacesMessage.SEVERITY_INFO, Mensagens.OK_ESTABELECIMENTO_INSERIR, Mensagens.ID_CAMPO_MENSAGEM_QUALQUER);
			}else{
				new Logger(true, FacesMessage.SEVERITY_ERROR, Mensagens.ERRO_ESTABELECIMENTO_INSERIR_0, Mensagens.ID_CAMPO_MENSAGEM_QUALQUER);
			}
		}else{
			new Logger(true, FacesMessage.SEVERITY_ERROR, Mensagens.ERRO_PREENCHIMENTO, Mensagens.ID_CAMPO_MENSAGEM_QUALQUER);
		}
		return retorno;
	}
	
	@Override
	public List<Estabelecimento> obterTodos() {
		List<Estabelecimento> lista = getInstance().obterTodos();
		if (lista==null || lista.size()==0){
			new Logger(true, FacesMessage.SEVERITY_ERROR, Mensagens.ERRO_ESTABELECIMENTO_CONSULTAR, Mensagens.ID_CAMPO_MENSAGEM_QUALQUER);
		}
		return lista;
	}
	
	@Override
	public List<Estabelecimento> obterPorCriterio(Estabelecimento object) throws SQLException {
		List<Estabelecimento> lista = getInstance().obterPorCriterio(object);
		if (lista==null || lista.size()==0){
			new Logger(true, FacesMessage.SEVERITY_ERROR, Mensagens.ERRO_ESTABELECIMENTO_CONSULTAR, Mensagens.ID_CAMPO_MENSAGEM_QUALQUER);
		}
		return lista;
	}
	
	@Override
	public int atualizar(Estabelecimento object) throws SQLException {
		int retorno = 0;
		if (object.validarObjeto(object)){
			retorno = getInstance().atualizar(object);
			if (retorno!=0){
				new Logger(true, FacesMessage.SEVERITY_INFO, Mensagens.OK_ESTABELECIMENTO_ATUALIZAR, Mensagens.ID_CAMPO_MENSAGEM_QUALQUER);
			}else{
				new Logger(true, FacesMessage.SEVERITY_ERROR, Mensagens.ERRO_ESTABELECIMENTO_ATUALIZAR_0, Mensagens.ID_CAMPO_MENSAGEM_QUALQUER);
			}
		}else{
			new Logger(true, FacesMessage.SEVERITY_ERROR, Mensagens.ERRO_PREENCHIMENTO, Mensagens.ID_CAMPO_MENSAGEM_QUALQUER);
		}
		return retorno;
	}
}
