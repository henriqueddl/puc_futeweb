package br.com.futeweb.aplicacao.interfaces.campeonato.dao;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;

import br.com.futeweb.aplicacao.dao.generico.GenericoDAO;
import br.com.futeweb.aplicacao.interfaces.campeonato.controle.IControleCampeonato;
import br.com.futeweb.aplicacao.interfaces.campeonato.entidade.Campeonato;
import br.com.futeweb.aplicacao.interfaces.jogo.entidade.Jogo;
import br.com.futeweb.aplicacao.interfaces.time.entidade.Time;

@Stateless
public class CampeonatoDAO extends GenericoDAO implements IControleCampeonato {

	private static final long serialVersionUID = 1L;

	@Override
	public int inserir(Campeonato object) throws SQLException {
		String query = " insert into campeonato (nome, datainicio,datafim,id_estabelecimento) values (?, ?,?,?) ";
		montarQuery(query);
		setParametros().setString(1, object.getNome());
		setParametros().setDate(2, (Date) object.getDataInicio());
		setParametros().setDate(3, (Date) object.getDataFim());
		setParametros().setInt(4, object.getid_estabelecimento());
		return executarUpdate();
	}

    
	public List<Jogo> ListarJogos(Campeonato obj) throws SQLException {
		List<Jogo> lista = new ArrayList<Jogo>();
		String query = " select a.id, a.id_quadra, ";
		query += " a.id_timemandante,a.id_timevisitante,a.gols_timemandante,a.gols_timevisitante,a.id_campeonato ";
		query += " from jogo a";
		query += " where a.id_campeonato = ? ";
		montarQuery(query);
		setParametros().setInt(1, obj.getId());
		String[][] retorno = executarQuery();
		if (retorno != null){
			for (String r[] : retorno){
				lista.add(new Jogo(Integer.parseInt(r[0]),Integer.parseInt(r[1]),Integer.parseInt(r[2]),Integer.parseInt(r[3]),Integer.parseInt(r[4]),Integer.parseInt(r[5]),Integer.parseInt(r[6]))
						);
			}
		}
		return lista;

         }
	
	@Deprecated
	@Override
	public List<Campeonato> obterTodos() {
		return new ArrayList<Campeonato>();
	}

	@Deprecated
	@Override
	public List<Campeonato> obterPorCriterio(Campeonato object) throws SQLException {
		List<Campeonato> lista = new ArrayList<Campeonato>();
		String query = " select q.id, q.nome, q.id_estabelecimnento e";
		query += " from campeonato q, estabelecimento e ";
		query += " where q.id = ? or e.nome ";
		query += " and q.id_estabelecimento = e.id ";
		montarQuery(query);
		setParametros().setInt(1, object.getId());
		String[][] retorno = executarQuery();
		if (retorno != null){
			for (String r[] : retorno){
				lista.add(new Campeonato(Integer.parseInt(r[0]), r[1], Date.valueOf(r[2]),Date.valueOf(r[3]), Integer.parseInt(r[4])));
			}
		}
		return lista;
	}
	
	@Override
	public int atualizar(Campeonato object) throws SQLException {
		String query = " update campeonato set nome = ?,datainicio = ?,datafim = ?, where id = ? ";
		montarQuery(query);
		setParametros().setString(1, object.getNome());
		setParametros().setInt(4, object.getId());
		return executarUpdate();
	}
	
	public int inserirTimesCampeonato(Time time, Campeonato campeonato) throws SQLException {
		String query = " insert into times_campeonato (id_campeonato, id_time) values (?, ?) ";
		montarQuery(query);
		setParametros().setInt(1, campeonato.getId());
		setParametros().setInt(2,time.getId());


		
		String queryClassificacao = " insert into classificacao (id_campeonato, id_time,jogos,vitorias,golspro,golscontra) values (?, ?,0,0,0,0) ";
		montarQuery(queryClassificacao);
		setParametros().setInt(1, campeonato.getId());
		setParametros().setDate(2, (Date) campeonato.getDataInicio());
		setParametros().setDate(3, (Date) campeonato.getDataFim());
		setParametros().setInt(2, time.getId());
		return executarUpdate();
	}
}
