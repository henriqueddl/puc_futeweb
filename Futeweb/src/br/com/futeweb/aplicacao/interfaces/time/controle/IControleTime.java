package br.com.futeweb.aplicacao.interfaces.time.controle;

import java.sql.SQLException;
import java.util.List;

import br.com.futeweb.aplicacao.dao.generico.IGenericoDAO;
import br.com.futeweb.aplicacao.interfaces.time.entidade.Time;

public interface IControleTime extends IGenericoDAO<Time>  {
	public int inserir(Time object) throws SQLException;
	public int inserirJogadorTime(Time object,int id_jogador) throws SQLException ;
	public List<Time> obterTodos() ;
	public List<Time> obterPorCriterio(Time object) throws SQLException;
	public int atualizar(Time object) throws SQLException;
	public int IdUltimoTimeCadastrado();
	public String NomeUltimoTimeCadastrado();
	
}
