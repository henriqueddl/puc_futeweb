package br.com.futeweb.aplicacao.interfaces.material.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import br.com.futeweb.aplicacao.dao.generico.GenericoDAO;
import br.com.futeweb.aplicacao.interfaces.estabelecimento.entidade.Estabelecimento;
import br.com.futeweb.aplicacao.interfaces.material.controle.IControleMaterial;
import br.com.futeweb.aplicacao.interfaces.material.entidade.Material;

@Stateless
public class MaterialDAO extends GenericoDAO implements IControleMaterial {

	private static final long serialVersionUID = 1L;
	
	@Override
	public int inserir(Material object) throws SQLException {
		String query = " insert into material (nome, id_estabelecimento) values (?, ?) ";
		montarQuery(query);
		setParametros().setString(1, object.getNome());
		setParametros().setInt(2, object.getEstabelecimento().getId());
		return executarUpdate();
	}

	@Override
	public List<Material> obterTodos() {
		List<Material> lista = new ArrayList<Material>();
		String query = " select m.id, m.nome, ";
		query += " es.id, es.nome, es.descricao ";
		query += " from material m, estabelecimento e ";
		query += " where m.id_estabelecimento = e.id ";
		montarQuery(query);
		String[][] retorno = executarQuery();
		if (retorno != null){
			for (String r[] : retorno){
				lista.add(new Material(Integer.parseInt(r[0]), r[1],
						new Estabelecimento(Integer.parseInt(r[2]), r[3], r[4], null)));
			}
		}
		return lista;
	}

	@Override
	public List<Material> obterPorCriterio(Material object) throws SQLException {
		List<Material> lista = new ArrayList<Material>();
		String query = " select m.id, m.nome, ";
		query += " es.id, es.nome, es.descricao ";
		query += " from material m, estabelecimento e ";
		query += " where m.id = ? or m.nome ";
		query += " and m.id_estabelecimento = e.id ";
		montarQuery(query);
		setParametros().setInt(1, object.getId());
		String[][] retorno = executarQuery();
		if (retorno != null){
			for (String r[] : retorno){
				lista.add(new Material(Integer.parseInt(r[0]), r[1],
						new Estabelecimento(Integer.parseInt(r[2]), r[3], r[4], null)));
			}
		}
		return lista;
	}
	
	@Override
	public int atualizar(Material object) throws SQLException {
		String query = " update material set nome = ? where id = ? ";
		montarQuery(query);
		setParametros().setString(1, object.getNome());
		setParametros().setInt(2, object.getId());
		return executarUpdate();
	}
}
