package br.com.futeweb.aplicacao.dao.generico;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

@SuppressWarnings("hiding")
public interface IGenericoDAO<Object> extends Serializable {
	
	public int inserir(Object object) throws SQLException;
	public List<Object> obterTodos();
	public List<Object> obterPorCriterio(Object object) throws SQLException;
	public int atualizar(Object object) throws SQLException;
	
}
