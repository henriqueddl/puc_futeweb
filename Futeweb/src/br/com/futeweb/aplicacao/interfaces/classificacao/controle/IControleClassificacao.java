package br.com.futeweb.aplicacao.interfaces.classificacao.controle;

import java.sql.SQLException;
import java.util.List;

import br.com.futeweb.aplicacao.dao.generico.IGenericoDAO;
import br.com.futeweb.aplicacao.interfaces.classificacao.entidade.Classificacao;

public interface IControleClassificacao extends IGenericoDAO<Classificacao>  {
	public int inserir(Classificacao object) throws SQLException;
	public List<Classificacao> obterTodos();
	public List<Classificacao> obterPorCriterio(Classificacao object) throws SQLException;
	public int atualizar(Classificacao object) throws SQLException;
	public int AtualizarClassificacao(Classificacao object) throws SQLException;
}
