package br.com.futeweb.aplicacao.interfaces.jogo.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import br.com.futeweb.aplicacao.dao.generico.GenericoDAO;
import br.com.futeweb.aplicacao.interfaces.jogo.controle.IControleJogo;
import br.com.futeweb.aplicacao.interfaces.jogo.entidade.Jogo;

@Stateless
public class JogoDAO extends GenericoDAO implements IControleJogo {

	private static final long serialVersionUID = 1L;

	@Override
	public int inserir(Jogo object) throws SQLException {
		String query = " insert into jogo (id_quadra,id_timemandante,id_timevisitante,gols_timemandante,gols_timevisitante,id_campeonato) values (?, ?,?,?,?,?,?) ";
		montarQuery(query);
		setParametros().setInt(1, object.getid_quadra());
		setParametros().setInt(2, object.getid_timemandante());
		setParametros().setInt(3, object.getid_timevisitante());
		setParametros().setInt(4, object.getgols_timemandante());
		setParametros().setInt(5, object.getgols_timevisitante());
		setParametros().setInt(6, object.getid_campeonato());
		return executarUpdate();
	}


	public List<Jogo> obterTodos() {
		List<Jogo> lista = new ArrayList<Jogo>();
		String query = " select id, id_quadra,id_timemandante,id_timevisitante,gols_timemandante,gols_timevisitante,id_campeonato ";
		query += " from jogo q ";
		montarQuery(query);
		String[][] retorno = executarQuery();
		if (retorno != null){
			for (String r[] : retorno){
				lista.add(new Jogo(Integer.parseInt(r[0]),Integer.parseInt(r[1]),Integer.parseInt(r[2]),Integer.parseInt(r[3]),Integer.parseInt(r[4]),Integer.parseInt(r[5]),Integer.parseInt(r[6])));
			}
		}
		return lista;
	}

	@Override
	public List<Jogo> obterPorCriterio(Jogo object) throws SQLException {
		List<Jogo> lista = new ArrayList<Jogo>();
		String query = " select q.id, q.nome, ";
		query += " from time q ";
		query += " where q.id = ? ";
		montarQuery(query);
		setParametros().setInt(1, object.getId());
		String[][] retorno = executarQuery();
		if (retorno != null){
			for (String r[] : retorno){
				lista.add(new Jogo(Integer.parseInt(r[0]),Integer.parseInt(r[1]),Integer.parseInt(r[2]),Integer.parseInt(r[3]),Integer.parseInt(r[4]),Integer.parseInt(r[5]),Integer.parseInt(r[6])));
			}
		}
		return lista;
	}

	public int atualizar(Jogo object) throws SQLException {
		String query = " update jogo set id_quadra = ?, id_timemandante = ?, id_timevisitante = ?, gols_timemandante = ?, gols_timevisitante = ?, id_campeonato = ? where id = ? ";
		montarQuery(query);
		setParametros().setInt(1, object.getid_quadra());
		setParametros().setInt(2, object.getid_timemandante());
		setParametros().setInt(3, object.getid_timevisitante());
		setParametros().setInt(4, object.getgols_timemandante());
		setParametros().setInt(5, object.getgols_timevisitante());
		setParametros().setInt(6, object.getid_campeonato());
		setParametros().setInt(7, object.getId());
		return executarUpdate();
  }

}