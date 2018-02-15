package br.com.futeweb.aplicacao.interfaces.quadra.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import br.com.futeweb.aplicacao.dao.generico.GenericoDAO;
import br.com.futeweb.aplicacao.interfaces.estabelecimento.entidade.Estabelecimento;
import br.com.futeweb.aplicacao.interfaces.quadra.controle.IControleQuadra;
import br.com.futeweb.aplicacao.interfaces.quadra.entidade.Quadra;

@Stateless
public class QuadraDAO extends GenericoDAO implements IControleQuadra {

	private static final long serialVersionUID = 1L;

	@Override
	public int inserir(Quadra object) throws SQLException {
		String query = " insert into quadra (nome, id_estabelecimento) values (?, ?) ";
		montarQuery(query);
		setParametros().setString(1, object.getNome());
		setParametros().setInt(2, object.getEstabelecimento().getId());
		return executarUpdate();
	}

	@Override
	public List<Quadra> obterTodos() {
		List<Quadra> lista = new ArrayList<Quadra>();
		String query = " select q.id, q.nome, ";
		query += " es.id, es.nome, es.descricao ";
		query += " from quadra q, estabelecimento e ";
		query += " where q.id_estabelecimento = e.id ";
		montarQuery(query);
		String[][] retorno = executarQuery();
		if (retorno != null){
			for (String r[] : retorno){
				lista.add(new Quadra(Integer.parseInt(r[0]), r[1],
						new Estabelecimento(Integer.parseInt(r[2]), r[3], r[4], null)));
			}
		}
		return lista;
	}

	@Override
	public List<Quadra> obterPorCriterio(Quadra object) throws SQLException {
		List<Quadra> lista = new ArrayList<Quadra>();
		String query = " select q.id, q.nome, ";
		query += " es.id, es.nome, es.descricao ";
		query += " from quadra q, estabelecimento e ";
		query += " where q.id = ? or m.nome ";
		query += " and q.id_estabelecimento = e.id ";
		montarQuery(query);
		setParametros().setInt(1, object.getId());
		String[][] retorno = executarQuery();
		if (retorno != null){
			for (String r[] : retorno){
				lista.add(new Quadra(Integer.parseInt(r[0]), r[1],
						new Estabelecimento(Integer.parseInt(r[2]), r[3], r[4], null)));
			}
		}
		return lista;
	}
	
	@Override
	public int atualizar(Quadra object) throws SQLException {
		String query = " update quadra set nome = ? where id = ? ";
		montarQuery(query);
		setParametros().setString(1, object.getNome());
		setParametros().setInt(2, object.getId());
		return executarUpdate();
	}
}
