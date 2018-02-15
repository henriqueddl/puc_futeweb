package br.com.futeweb.aplicacao.interfaces.endereco.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import br.com.futeweb.aplicacao.dao.generico.GenericoDAO;
import br.com.futeweb.aplicacao.interfaces.endereco.controle.IControleEndereco;
import br.com.futeweb.aplicacao.interfaces.endereco.entidade.Endereco;

@Stateless
public class EnderecoDAO extends GenericoDAO implements IControleEndereco {

	private static final long serialVersionUID = 1L;
	
	@Override
	public int inserir(Endereco object) throws SQLException {
		String query = " insert into endereco (logradouro, numero, cidade, estado, cep) values (?, ?, ?, ?, ?) ";
		montarQuery(query);
		setParametros().setString(1, object.getLogradouro());
		setParametros().setInt(2, object.getNumero());
		setParametros().setString(3, object.getCidade());
		setParametros().setString(4, object.getEstado());
		setParametros().setString(5, object.getCep());
		return executarUpdate();
	}

	@Override
	public List<Endereco> obterTodos() {
		List<Endereco> lista = new ArrayList<Endereco>();
		String query = " select id, logradouro, numero, cidade, estado, cep from endereco ";
		montarQuery(query);
		String[][] retorno = executarQuery();
		if (retorno != null){
			for (String r[] : retorno){
				lista.add(new Endereco(Integer.parseInt(r[0]), r[1], Integer.parseInt(r[2]), r[3], r[4], r[5]));
			}
		}
		return lista;
	}

	@Override
	public List<Endereco> obterPorCriterio(Endereco object) throws SQLException {
		List<Endereco> lista = new ArrayList<Endereco>();
		String query = " select id, logradouro, numero, cidade, estado, cep from endereco where id = ? or logradouro = ? or cidade = ? or estado = ? or cep = ? ";
		montarQuery(query);
		setParametros().setInt(1, object.getId());
		setParametros().setString(2, object.getLogradouro());
		setParametros().setString(3, object.getCidade());
		setParametros().setString(4, object.getEstado());
		setParametros().setString(5, object.getCep());
		String[][] retorno = executarQuery();
		if (retorno != null){
			for (String r[] : retorno){
				lista.add(new Endereco(Integer.parseInt(r[0]), r[1], Integer.parseInt(r[2]), r[3], r[4], r[5]));
			}
		}
		return lista;
	}
	
	@Override
	public int atualizar(Endereco object) throws SQLException {
		String query = " update endereco set logradouro = ?, numero = ?, cidade = ?, estado = ?, cep = ? where id = ? ";
		montarQuery(query);
		setParametros().setString(1, object.getLogradouro());
		setParametros().setInt(2, object.getNumero());
		setParametros().setString(3, object.getCidade());
		setParametros().setString(4, object.getEstado());
		setParametros().setString(5, object.getCep());
		setParametros().setInt(6, object.getId());
		return executarUpdate();
	}
}
