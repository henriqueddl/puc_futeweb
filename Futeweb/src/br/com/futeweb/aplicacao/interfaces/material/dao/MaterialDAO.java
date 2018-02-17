package br.com.futeweb.aplicacao.interfaces.material.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import br.com.futeweb.aplicacao.dao.generico.GenericoDAO;
import br.com.futeweb.aplicacao.interfaces.estabelecimento.entidade.Estabelecimento;
import br.com.futeweb.aplicacao.interfaces.master.entidade.Disponibilidade;
import br.com.futeweb.aplicacao.interfaces.material.controle.IControleMaterial;
import br.com.futeweb.aplicacao.interfaces.material.entidade.Material;
import br.com.futeweb.aplicacao.utils.AplicacaoUtils;

@Stateless
public class MaterialDAO extends GenericoDAO implements IControleMaterial {

	private static final long serialVersionUID = 1L;
	
	@Deprecated
	@Override
	public int inserir(Material object) throws SQLException {
		throw new SQLException("Método não implementado");
	}
	
	@Override
	public int inserir(Material material, int idEstabelecimento) throws SQLException {
		String query = " insert into material (nome, descricao, id_estabelecimento) values (?, ?, ?) ";
		montarQuery(query);
		setParametros().setString(1, material.getNome());
		setParametros().setString(2, material.getDescricao());
		setParametros().setInt(3, idEstabelecimento);
		return executarUpdate();
	}
	
	@Deprecated
	@Override
	public List<Material> obterTodos() {
		return new ArrayList<Material>();
	}
	
	@Deprecated
	@Override
	public List<Material> obterPorCriterio(Material object) throws SQLException {
		throw new SQLException("Método não implementado");
	}

	@Override
	public List<Material> obterMaterial(Estabelecimento estabelecimento) throws SQLException {
		List<Material> lista = new ArrayList<Material>();
		String query = " select m.id, m.nome, m.descricao ";
		query += " from material m, estabelecimento e ";
		query += " where e.id = ? ";
		query += " and m.id_estabelecimento = e.id ";
		montarQuery(query);
		setParametros().setInt(1, estabelecimento.getId());
		String[][] retorno = executarQuery();
		if (retorno != null){
			for (String r[] : retorno){
				lista.add(new Material(Integer.parseInt(r[0]), r[1], r[2]));
			}
		}
		return lista;
	}
	
	@Override
	public int atualizar(Material object) throws SQLException {
		String query = " update material set nome = ? descricao = ? where id = ? ";
		montarQuery(query);
		setParametros().setString(1, object.getNome());
		setParametros().setString(2, object.getDescricao());
		setParametros().setInt(3, object.getId());
		return executarUpdate();
	}
	
	@Override
	public int inserirDisponibilidadeMaterial(Disponibilidade disponibilidade, Material material) throws SQLException {
		String query = " insert into disponibilidade_material (id_material, data_inicio, data_fim) values (?, ?, ?) ";
		montarQuery(query);
		setParametros().setInt(1, material.getId());
		setParametros().setTimestamp(2, AplicacaoUtils.dateUtilToSql(disponibilidade.getDataInicio()));
		setParametros().setTimestamp(3, AplicacaoUtils.dateUtilToSql(disponibilidade.getDataFim()));
		return executarUpdate();
	}

	@Override
	public List<Disponibilidade> obterDisponibilidadeMaterial(Material material) throws SQLException {
		List<Disponibilidade> lista = new ArrayList<Disponibilidade>();
		String query = " select d.id, d.data_inicio, d.data_fim ";
		query += " from disponibilidade_material d ";
		query += " where d.id_material = ? ";
		montarQuery(query);
		setParametros().setInt(1, material.getId());
		String[][] retorno = executarQuery();
		if (retorno != null){
			for (String r[] : retorno){
				lista.add(new Disponibilidade(Integer.parseInt(r[0]), AplicacaoUtils.parseDate(r[1]), AplicacaoUtils.parseDate(r[2])));
			}
		}
		return lista;
	}

	@Override
	public int removerDisponibilidadeMaterial(Disponibilidade disponibilidade) throws SQLException {
		String query = " delete disponibilidade_material where id = ? ";
		montarQuery(query);
		setParametros().setInt(1, disponibilidade.getId());
		return executarUpdate();
	}


}
