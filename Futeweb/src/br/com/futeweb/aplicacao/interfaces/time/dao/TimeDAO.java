package br.com.futeweb.aplicacao.interfaces.time.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import br.com.futeweb.aplicacao.dao.generico.GenericoDAO;
import br.com.futeweb.aplicacao.interfaces.time.controle.IControleTime;
import br.com.futeweb.aplicacao.interfaces.time.entidade.Time;

@Stateless
public class TimeDAO extends GenericoDAO implements IControleTime {

	private static final long serialVersionUID = 1L;

	@Override
	public int inserir(Time object) throws SQLException {
		String query = " insert into time (nome) values (?) ";
		montarQuery(query);
		setParametros().setString(1, object.getNome());
		return executarUpdate();
	}

	public int inserirJogadorTime(Time object,int id_jogador) throws SQLException {
		String query = " insert into jogadores_time (nome) values (?,?) ";
		montarQuery(query);
		setParametros().setInt(1, object.getId());
		setParametros().setInt(2, id_jogador);
		return executarUpdate();
	}	
	
	@Override
	public List<Time> obterTodos() {
		List<Time> lista = new ArrayList<Time>();
		String query = " select q.id, q.nome, ";
		query += " from quadra q ";
		montarQuery(query);
		String[][] retorno = executarQuery();
		if (retorno != null){
			for (String r[] : retorno){
				lista.add(new Time(Integer.parseInt(r[0]), r[1]));
			}
		}
		return lista;
	}

	@Override
	public List<Time> obterPorCriterio(Time object) throws SQLException {
		List<Time> lista = new ArrayList<Time>();
		String query = " select q.id, q.nome, ";
		query += " from time q ";
		query += " where q.id = ? ";
		montarQuery(query);
		setParametros().setInt(1, object.getId());
		String[][] retorno = executarQuery();
		if (retorno != null){
			for (String r[] : retorno){
				lista.add(new Time(Integer.parseInt(r[0]), r[1])
						);
			}
		}
		return lista;
	}
	
	@Override
	public int atualizar(Time object) throws SQLException {
		String query = " update time set nome = ? where id = ? ";
		montarQuery(query);
		setParametros().setString(1, object.getNome());
		setParametros().setInt(2, object.getId());
		return executarUpdate();
	}
}
