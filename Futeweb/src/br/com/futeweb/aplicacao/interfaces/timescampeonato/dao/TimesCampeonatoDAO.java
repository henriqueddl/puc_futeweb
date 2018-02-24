package br.com.futeweb.aplicacao.interfaces.timescampeonato.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

import javax.ejb.Stateless;

import br.com.futeweb.aplicacao.dao.generico.GenericoDAO;
import br.com.futeweb.aplicacao.interfaces.timescampeonato.controle.IControleTimesCampeonato;
import br.com.futeweb.aplicacao.interfaces.time.entidade.Time;
import br.com.futeweb.aplicacao.interfaces.timescampeonato.entidade.TimesCampeonato;
import br.com.futeweb.aplicacao.interfaces.campeonato.entidade.Campeonato;

//21:57:44	CREATE TABLE Time (   id INT NOT NULL AUTO_INCREMENT,   nome VARCHAR(50) NOT NULL,   descricao VARCHAR(200) NOT NULL,   PRIMARY KEY(id) )	0 row(s) affected	3.047 sec


@Stateless
public class TimesCampeonatoDAO extends GenericoDAO implements IControleTimesCampeonato {

	private static final long serialVersionUID = 1L;

	@Override
	public int inserir(TimesCampeonato object) throws SQLException {
		String query = " insert into times_campeonato (id_campeonato,id_time) values (?,?) ";
		montarQuery(query);
		setParametros().setInt(1, object.getIdcampeonato());
		setParametros().setInt(2, object.getIdtime());
		return executarUpdate();
	}

	public int inserirTimesCampeonato(Campeonato object,int id_jogador) throws SQLException {
		String query = " insert into jogadores_time (id_time,id_jogador) values (?,?) ";
		montarQuery(query);
		setParametros().setInt(1, object.getId());
		setParametros().setInt(2, id_jogador);
		return executarUpdate();
	}	
	
	@Override
	public List<TimesCampeonato> obterTodos() {
		List<TimesCampeonato> lista = new ArrayList<TimesCampeonato>();
		String query = " select q.id_campeonato, q.id_time ";
		query += " from times_campeonato q ";
		montarQuery(query);
		String[][] retorno = executarQuery();
		if (retorno != null){
			for (String r[] : retorno){
				lista.add(new TimesCampeonato(Integer.parseInt(r[0]), Integer.parseInt(r[1])));
			}
		}
		return lista;
	}

	
	public int IdUltimoCampeonatoeCadastrado() {
		int id=0;
		String query = " select q.id ";
		query += " from campeonato q where q.id = (select max(id) from campeonato)";
		montarQuery(query);
		String[][] retorno = executarQuery();
		if (retorno != null){
			for (String r[] : retorno){
				id = Integer.parseInt(r[0]);
			}
		}
		return id;
	}	
	
	public String NomeUltimoTimeCadastrado() {
		String Nome = "";
		String query = " select q.nome ";
		query += " from campeonato q where q.id = (select max(id) from campeonato)";
		montarQuery(query);
		String[][] retorno = executarQuery();
		if (retorno != null){
			for (String r[] : retorno){
				Nome = r[0];
			}
		}
		return Nome;
	}
	
	@Override
	public List<TimesCampeonato> obterPorCriterio(TimesCampeonato object) throws SQLException {
		List<TimesCampeonato> lista = new ArrayList<TimesCampeonato>();
		String query = " select q.id_campeonato, q.id_time";
		query += " from times_campeonato q ";
		query += " where q.id_campeonato = ?";
		montarQuery(query);
		setParametros().setInt(1, object.getIdcampeonato());
		String[][] retorno = executarQuery();
		if (retorno != null){
			for (String r[] : retorno){
				lista.add(new TimesCampeonato(Integer.parseInt(r[0]), Integer.parseInt(r[1]))
						);
			}
		}
		return lista;
	}
	
	@Override
	public int atualizar(TimesCampeonato object) throws SQLException {
		String query = " update times_campeonato set id_time = ? where id_campeonato = ? ";
		montarQuery(query);
		setParametros().setInt(1, object.getIdcampeonato());
		setParametros().setInt(2, object.getIdtime());		
		return executarUpdate();
	}
	
	public Map<Integer, String> obterListaCampeonatos() throws SQLException {
		Map<Integer, String> lista = new HashMap<Integer, String>();;
		String query = " select q.id, q.nome ";
		query += " from campeonato q ";
		montarQuery(query);
		String[][] retorno = executarQuery();
		if (retorno != null){
			for (String r[] : retorno){
				lista.put( Integer.parseInt(r[0]),r[1]);
			}
		}
		return lista;
	}
	
	
	public Map<Integer, String> obterListaTimes() throws SQLException {
		Map<Integer, String> lista = new HashMap<Integer, String>();;
		String query = " select q.id, q.nome ";
		query += " from time q ";
		montarQuery(query);
		String[][] retorno = executarQuery();
		if (retorno != null){
			for (String r[] : retorno){
				lista.put( Integer.parseInt(r[0]),r[1]);
			}
		}
		return lista;
	}
}
