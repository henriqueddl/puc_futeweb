package br.com.futeweb.aplicacao.interfaces.quadra.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import br.com.futeweb.aplicacao.dao.generico.GenericoDAO;
import br.com.futeweb.aplicacao.interfaces.estabelecimento.entidade.Estabelecimento;
import br.com.futeweb.aplicacao.interfaces.master.entidade.Disponibilidade;
import br.com.futeweb.aplicacao.interfaces.quadra.controle.IControleQuadra;
import br.com.futeweb.aplicacao.interfaces.quadra.entidade.Quadra;
import br.com.futeweb.aplicacao.utils.AplicacaoUtils;

@Stateless
public class QuadraDAO extends GenericoDAO implements IControleQuadra {

	private static final long serialVersionUID = 1L;

	@Override
	public int inserir(Quadra object) throws SQLException {
		String query = " insert into quadra (nome, descricao, id_estabelecimento) values (?, ?, ?) ";
		montarQuery(query);
		setParametros().setString(1, object.getNome());
		setParametros().setString(2, object.getDescricao());
		setParametros().setInt(3, object.getEstabelecimento().getId());
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
				lista.add(new Quadra(Integer.parseInt(r[0]), r[1], r[2],
						new Estabelecimento(Integer.parseInt(r[3]), r[4], r[5], null)));
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
				lista.add(new Quadra(Integer.parseInt(r[0]), r[1], r[2],
						new Estabelecimento(Integer.parseInt(r[3]), r[4], r[5], null)));
			}
		}
		return lista;
	}
	
	@Override
	public int atualizar(Quadra object) throws SQLException {
		String query = " update quadra set nome = ? descricao = ? where id = ? ";
		montarQuery(query);
		setParametros().setString(1, object.getNome());
		setParametros().setString(2, object.getDescricao());
		setParametros().setInt(3, object.getId());
		return executarUpdate();
	}

	@Override
	public int inserirDisponibilidadeQuadra(Disponibilidade disponibilidade, Quadra quadra) throws SQLException {
		String query = " insert into disponibilidade_quadra (id_quadra, data_inicio, data_fim) values (?, ?, ?) ";
		montarQuery(query);
		setParametros().setInt(1, quadra.getId());
		setParametros().setTimestamp(2, AplicacaoUtils.dateUtilToSql(disponibilidade.getDataInicio()));
		setParametros().setTimestamp(3, AplicacaoUtils.dateUtilToSql(disponibilidade.getDataFim()));
		return executarUpdate();
	}

	@Override
	public List<Disponibilidade> obterDisponibilidadeQuadra(Quadra quadra) throws SQLException {
		List<Disponibilidade> lista = new ArrayList<Disponibilidade>();
		String query = " select d.id, d.id_quadra, d.data_inicio, d.data_fim ";
		query += " from disponibilidade_quadra d ";
		query += " where d.id_quadra = ? ";
		montarQuery(query);
		setParametros().setInt(1, quadra.getId());
		String[][] retorno = executarQuery();
		if (retorno != null){
			for (String r[] : retorno){
				lista.add(new Disponibilidade(Integer.parseInt(r[0]), AplicacaoUtils.parseDate(r[1]), AplicacaoUtils.parseDate(r[2])));
			}
		}
		return lista;
	}

	@Override
	public int removerDisponibilidadeQuadra(Disponibilidade disponibilidade) throws SQLException {
		String query = " delete disponibilidade_quadra where id = ? ";
		montarQuery(query);
		setParametros().setInt(1, disponibilidade.getId());
		return executarUpdate();
	}
}
