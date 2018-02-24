package br.com.futeweb.aplicacao.interfaces.jogadorestime.controle;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import br.com.futeweb.aplicacao.dao.generico.IGenericoDAO;
import br.com.futeweb.aplicacao.interfaces.jogadorestime.entidade.JogadoresTime;

public interface IControleJogadoresTime extends IGenericoDAO<JogadoresTime>  {
	public int inserir(JogadoresTime object) throws SQLException;
	public List<JogadoresTime> obterTodos() ;
	public List<JogadoresTime> obterPorCriterio(JogadoresTime object) throws SQLException;
	public int atualizar(JogadoresTime object) throws SQLException;
	public int IdUltimoTimeCadastrado();
	public String NomeUltimoTimeCadastrado();
	public Map<Integer, String> obterListaJogadores() throws SQLException;
	public Map<Integer, String> obterListaTimes() throws SQLException;
	
}
