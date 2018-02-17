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

	@Deprecated
	@Override
	public int inserir(Quadra object) throws SQLException {
		throw new SQLException("Método não implementado");
	}
	
	@Override
	public int inserir(Quadra quadra, int idEstabelecimento) throws SQLException {
		String query = " insert into quadra (nome, descricao, id_estabelecimento) values (?, ?, ?) ";
		montarQuery(query);
		setParametros().setString(1, quadra.getNome());
		setParametros().setString(2, quadra.getDescricao());
		setParametros().setInt(3, idEstabelecimento);
		return executarUpdate();
	}

	@Deprecated
	@Override
	public List<Quadra> obterTodos() {
		return new ArrayList<Quadra>();
	}

	@Deprecated
	@Override
	public List<Quadra> obterPorCriterio(Quadra object) throws SQLException {
		throw new SQLException("Método não implementado");
	}
	
	@Override
	public List<Quadra> obterQuadra(Estabelecimento estabelecimento) throws SQLException {
		List<Quadra> lista = new ArrayList<Quadra>();
		String query = " select q.id, q.nome, q.descricao ";
		query += " from quadra q, estabelecimento e ";
		query += " where e.id = ? ";
		query += " and q.id_estabelecimento = e.id ";
		montarQuery(query);
		setParametros().setInt(1, estabelecimento.getId());
		String[][] retorno = executarQuery();
		if (retorno != null){
			for (String r[] : retorno){
				lista.add(new Quadra(Integer.parseInt(r[0]), r[1], r[2]));
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
		String query = " select id, data_inicio, data_fim ";
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
