package br.com.futeweb.aplicacao.interfaces.quadra.controle;

import java.sql.SQLException;
import java.util.List;

import javax.ejb.Stateless;
import javax.faces.application.FacesMessage;

import br.com.futeweb.aplicacao.dao.generico.GenericoDAO;
import br.com.futeweb.aplicacao.interfaces.master.entidade.Disponibilidade;
import br.com.futeweb.aplicacao.interfaces.quadra.dao.QuadraDAO;
import br.com.futeweb.aplicacao.interfaces.quadra.entidade.Quadra;
import br.com.futeweb.aplicacao.utils.Logger;
import br.com.futeweb.aplicacao.utils.Mensagens;

@Stateless
public class ControleQuadra extends GenericoDAO implements IControleQuadra {

	private static final long serialVersionUID = 1L;
	private QuadraDAO dao;
	
	private QuadraDAO getInstance(){
		if (dao==null){
			dao = new QuadraDAO();
		}
		return dao;
	}
	
	@Override
	public int inserir(Quadra object) throws SQLException {
		int retorno = 0;
		if (object.validarObjeto(object)){
			retorno = getInstance().inserir(object);
			if (retorno!=0){
				new Logger(true, FacesMessage.SEVERITY_INFO, Mensagens.OK_QUADRA_INSERIR, Mensagens.ID_CAMPO_MENSAGEM_QUALQUER);
			}else{
				new Logger(true, FacesMessage.SEVERITY_ERROR, Mensagens.ERRO_QUADRA_INSERIR_0, Mensagens.ID_CAMPO_MENSAGEM_QUALQUER);
			}
		}else{
			new Logger(true, FacesMessage.SEVERITY_ERROR, Mensagens.ERRO_PREENCHIMENTO, Mensagens.ID_CAMPO_MENSAGEM_QUALQUER);
		}
		return retorno;
	}

	@Override
	public List<Quadra> obterTodos() {
		List<Quadra> lista = getInstance().obterTodos();
		if (lista==null || lista.size()==0){
			new Logger(true, FacesMessage.SEVERITY_ERROR, Mensagens.ERRO_QUADRA_CONSULTAR, Mensagens.ID_CAMPO_MENSAGEM_QUALQUER);
		}
		return lista;
	}

	@Override
	public List<Quadra> obterPorCriterio(Quadra object) throws SQLException {
		List<Quadra> lista = getInstance().obterPorCriterio(object);
		if (lista==null || lista.size()==0){
			new Logger(true, FacesMessage.SEVERITY_ERROR, Mensagens.ERRO_QUADRA_CONSULTAR, Mensagens.ID_CAMPO_MENSAGEM_QUALQUER);
		}
		return lista;
	}
	
	@Override
	public int atualizar(Quadra object) throws SQLException {
		int retorno = 0;
		if (object.validarObjeto(object)){
			retorno = getInstance().atualizar(object);
			if (retorno!=0){
				new Logger(true, FacesMessage.SEVERITY_INFO, Mensagens.OK_QUADRA_ATUALIZAR, Mensagens.ID_CAMPO_MENSAGEM_QUALQUER);
			}else{
				new Logger(true, FacesMessage.SEVERITY_ERROR, Mensagens.ERRO_QUADRA_ATUALIZAR_0, Mensagens.ID_CAMPO_MENSAGEM_QUALQUER);
			}
		}else{
			new Logger(true, FacesMessage.SEVERITY_ERROR, Mensagens.ERRO_PREENCHIMENTO, Mensagens.ID_CAMPO_MENSAGEM_QUALQUER);
		}
		return retorno;
	}

	@Override
	public int inserirDisponibilidadeQuadra(Disponibilidade disponibilidade, Quadra quadra) throws SQLException {
		int retorno = 0;
		if (disponibilidade.validarObjeto(disponibilidade) && quadra.validarObjeto(quadra)){
			retorno = getInstance().inserirDisponibilidadeQuadra(disponibilidade, quadra);
			if (retorno!=0){
				new Logger(true, FacesMessage.SEVERITY_INFO, Mensagens.OK_QUADRA_DISPONIBILIDADE_INSERIR, Mensagens.ID_CAMPO_MENSAGEM_QUALQUER);
			}else{
				new Logger(true, FacesMessage.SEVERITY_ERROR, Mensagens.ERRO_QUADRA_DISPONIBILIDADE_INSERIR_0, Mensagens.ID_CAMPO_MENSAGEM_QUALQUER);
			}
		}else{
			new Logger(true, FacesMessage.SEVERITY_ERROR, Mensagens.ERRO_PREENCHIMENTO, Mensagens.ID_CAMPO_MENSAGEM_QUALQUER);
		}
		return retorno;
	}

	@Override
	public List<Disponibilidade> obterDisponibilidadeQuadra(Quadra quadra) throws SQLException {
		List<Disponibilidade> lista = getInstance().obterDisponibilidadeQuadra(quadra);
		if (lista==null || lista.size()==0){
			new Logger(true, FacesMessage.SEVERITY_ERROR, Mensagens.ERRO_QUADRA_DISPONIBILIDADE_CONSULTAR, Mensagens.ID_CAMPO_MENSAGEM_QUALQUER);
		}
		return lista;
	}

	@Override
	public int removerDisponibilidadeQuadra(Disponibilidade disponibilidade) throws SQLException {
		int retorno = 0;
		if (disponibilidade.validarObjeto(disponibilidade)){
			retorno = getInstance().removerDisponibilidadeQuadra(disponibilidade);
			if (retorno!=0){
				new Logger(true, FacesMessage.SEVERITY_INFO, Mensagens.OK_QUADRA_DISPONIBILIDADE_REMOVER, Mensagens.ID_CAMPO_MENSAGEM_QUALQUER);
			}else{
				new Logger(true, FacesMessage.SEVERITY_ERROR, Mensagens.ERRO_QUADRA_DISPONIBILIDADE_REMOVER_0, Mensagens.ID_CAMPO_MENSAGEM_QUALQUER);
			}
		}else{
			new Logger(true, FacesMessage.SEVERITY_ERROR, Mensagens.ERRO_PREENCHIMENTO, Mensagens.ID_CAMPO_MENSAGEM_QUALQUER);
		}
		return retorno;
	}
}
