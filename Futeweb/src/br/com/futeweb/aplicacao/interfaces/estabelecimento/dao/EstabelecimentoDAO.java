package br.com.futeweb.aplicacao.interfaces.estabelecimento.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import br.com.futeweb.aplicacao.dao.generico.GenericoDAO;
import br.com.futeweb.aplicacao.interfaces.endereco.entidade.Endereco;
import br.com.futeweb.aplicacao.interfaces.estabelecimento.controle.IControleEstabelecimento;
import br.com.futeweb.aplicacao.interfaces.estabelecimento.entidade.Estabelecimento;

@Stateless
public class EstabelecimentoDAO extends GenericoDAO implements IControleEstabelecimento {

	private static final long serialVersionUID = 1L;

	@Override
	public int inserir(Estabelecimento object) throws SQLException {
		String query = " insert into estabelecimento (nome, descricao, idEndereco) values (?, ?, ?) ";
		montarQuery(query);
		setParametros().setString(1, object.getNome());
		setParametros().setString(2, object.getDescricao());
		setParametros().setInt(3, object.getEndereco().getId());
		return executarUpdate();
	}
	
	@Override
	public List<Estabelecimento> obterTodos() {
		List<Estabelecimento> lista = new ArrayList<Estabelecimento>();
		String query = " select es.id, es.nome, es.descricao, ";
		query += " en.id, en.logradouro, en.numero, en.cidade, en.estado, en.cep from estabelecimento es, endereco en ";
		query += " where es.idEndereco = en.id ";
		montarQuery(query);
		String[][] retorno = executarQuery();
		if (retorno != null){
			for (String r[] : retorno){
				lista.add(new Estabelecimento(Integer.parseInt(r[0]), r[1], r[2], new Endereco(Integer.parseInt(r[3]), r[4], Integer.parseInt(r[5]), r[6], r[7], r[8])));
			}
		}
		return lista;
	}
	
	@Override
	public List<Estabelecimento> obterPorCriterio(Estabelecimento object) throws SQLException {
		List<Estabelecimento> lista = new ArrayList<Estabelecimento>();
		String query = " select es.id, es.nome, es.descricao, ";
		query += " en.id, en.logradouro, en.numero, en.cidade, en.estado, en.cep from estabelecimento es, endereco en ";
		query += " where es.id = ? or es.nome = ? ";
		query += " and es.idEndereco = en.id ";		
		montarQuery(query);
		setParametros().setInt(1, object.getId());
		setParametros().setString(2, object.getNome());
		String[][] retorno = executarQuery();
		if (retorno != null){
			for (String r[] : retorno){
				lista.add(new Estabelecimento(Integer.parseInt(r[0]), r[1], r[2], new Endereco(Integer.parseInt(r[3]), r[4], Integer.parseInt(r[5]), r[6], r[7], r[8])));
			}
		}
		return lista;
	}
	
	@Override
	public int atualizar(Estabelecimento object) throws SQLException {
		String query = " update estabelecimento set nome = ?, descricao = ? where id = ? ";
		montarQuery(query);
		setParametros().setString(1, object.getNome());
		setParametros().setString(2, object.getDescricao());
		setParametros().setInt(3, object.getId());
		return executarUpdate();
	}
}
