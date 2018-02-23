package br.com.futeweb.aplicacao.interfaces.estabelecimento.controle;

import java.sql.SQLException;
import java.util.List;

import javax.ejb.Stateless;
import javax.faces.application.FacesMessage;

import br.com.futeweb.aplicacao.dao.generico.GenericoDAO;
import br.com.futeweb.aplicacao.interfaces.estabelecimento.dao.EstabelecimentoDAO;
import br.com.futeweb.aplicacao.interfaces.estabelecimento.entidade.Estabelecimento;
import br.com.futeweb.aplicacao.interfaces.usuario.entidade.PessoaJuridica;
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
		return getInstance().inserir(object);
	}
	
	@Override
	public List<Estabelecimento> obterTodos() {
		return getInstance().obterTodos();
	}
	
	@Override
	public List<Estabelecimento> obterPorCriterio(Estabelecimento object) throws SQLException {
		return getInstance().obterPorCriterio(object);
	}
	
	@Override
	public int atualizar(Estabelecimento object) throws SQLException {
		return getInstance().atualizar(object);
	}

	@Override
	public int inserirEstabelecimentoPessoaJuridica(Estabelecimento estabelecimento, PessoaJuridica pessoaJuridica) throws SQLException {
		int retorno = 0; 
		if (estabelecimento!=null && pessoaJuridica!=null){
			retorno = getInstance().inserirEstabelecimentoPessoaJuridica(estabelecimento, pessoaJuridica);
			if (retorno!=0){
				new Logger(true, FacesMessage.SEVERITY_INFO, Mensagens.OK_ESTABELECIMENTO_PESSOA_JURIDICA_INSERIR, Mensagens.ID_CAMPO_MENSAGEM_INDEX);
			}else{
				new Logger(true, FacesMessage.SEVERITY_ERROR, Mensagens.ERRO_ESTABELECIMENTO_PESSOA_JURIDICA_INSERIR_0, Mensagens.ID_CAMPO_MENSAGEM_INDEX);
			}
		}else{
			new Logger(true, FacesMessage.SEVERITY_ERROR, Mensagens.ERRO_PREENCHIMENTO, Mensagens.ID_CAMPO_MENSAGEM_INDEX);
		}
		return retorno;
	}

	@Override
	public List<PessoaJuridica> obterPessoaJuridica(Estabelecimento estabelecimento) throws SQLException {
		List<PessoaJuridica> lista = getInstance().obterPessoaJuridica(estabelecimento);
		if (lista==null || lista.size()==0){
			new Logger(true, FacesMessage.SEVERITY_ERROR, Mensagens.ERRO_ESTABELECIMENTO_PESSOA_JURIDICA_CONSULTAR, Mensagens.ID_CAMPO_MENSAGEM_INDEX);
		}
		return lista;
	}

	@Override
	public int removerEstabelecimentoPessoaJuridica(Estabelecimento estabelecimento, PessoaJuridica pessoaJuridica) throws SQLException {
		int retorno = 0;
		if (estabelecimento!=null && pessoaJuridica!=null){
			retorno = getInstance().removerEstabelecimentoPessoaJuridica(estabelecimento, pessoaJuridica);
			if (retorno!=0){
				new Logger(true, FacesMessage.SEVERITY_INFO, Mensagens.OK_ESTABELECIMENTO_PESSOA_JURIDICA_REMOVER, Mensagens.ID_CAMPO_MENSAGEM_INDEX);
			}else{
				new Logger(true, FacesMessage.SEVERITY_ERROR, Mensagens.ERRO_ESTABELECIMENTO_PESSOA_JURIDICA_REMOVER_0, Mensagens.ID_CAMPO_MENSAGEM_INDEX);
			}
		}else{
			new Logger(true, FacesMessage.SEVERITY_ERROR, Mensagens.ERRO_PREENCHIMENTO, Mensagens.ID_CAMPO_MENSAGEM_INDEX);
		}
		return retorno;
	}
}
