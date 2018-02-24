package br.com.futeweb.aplicacao.interfaces.timescampeonato.controle;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import br.com.futeweb.aplicacao.dao.generico.IGenericoDAO;
import br.com.futeweb.aplicacao.interfaces.timescampeonato.entidade.TimesCampeonato;
import br.com.futeweb.aplicacao.interfaces.campeonato.entidade.Campeonato;

public interface IControleTimesCampeonato extends IGenericoDAO<TimesCampeonato>  {
	public int inserir(TimesCampeonato object) throws SQLException;
	public int inserirTimesCampeonato(Campeonato object,int id_time) throws SQLException ;
	public List<TimesCampeonato> obterTodos() ;
	public List<TimesCampeonato> obterPorCriterio(TimesCampeonato object) throws SQLException;
	public int atualizar(TimesCampeonato object) throws SQLException;

	public Map<Integer, String> obterListaCampeonatos() throws SQLException;
	public Map<Integer, String> obterListaTimes() throws SQLException;
	
}
