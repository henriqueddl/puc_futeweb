package br.com.futeweb.aplicacao.interfaces.campeonato.controle;

import java.sql.SQLException;
import java.util.List;

import br.com.futeweb.aplicacao.dao.generico.IGenericoDAO;
import br.com.futeweb.aplicacao.interfaces.campeonato.entidade.Campeonato;

public interface IControleCampeonato extends IGenericoDAO<Campeonato>  {
	public int inserir(Campeonato object) throws SQLException;
	public List<Campeonato> obterTodos();
	public List<Campeonato> obterPorCriterio(Campeonato object) throws SQLException;
	
	public int atualizar(Campeonato object) throws SQLException ;
	
}
