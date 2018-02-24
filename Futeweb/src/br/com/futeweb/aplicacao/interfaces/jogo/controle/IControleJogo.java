package br.com.futeweb.aplicacao.interfaces.jogo.controle;

import java.sql.SQLException;
import java.util.List;

import br.com.futeweb.aplicacao.dao.generico.IGenericoDAO;
import br.com.futeweb.aplicacao.interfaces.jogo.entidade.Jogo;

public interface IControleJogo extends IGenericoDAO<Jogo>  {
	public int inserir(Jogo object) throws SQLException;
    public List<Jogo> obterTodos();
	public List<Jogo> obterPorCriterio(Jogo object) throws SQLException;
	public int atualizar(Jogo object) throws SQLException;
}
