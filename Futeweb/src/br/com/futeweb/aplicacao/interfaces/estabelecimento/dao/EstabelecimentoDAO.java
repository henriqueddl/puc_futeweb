package br.com.futeweb.aplicacao.interfaces.estabelecimento.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import br.com.futeweb.aplicacao.dao.generico.GenericoDAO;
import br.com.futeweb.aplicacao.interfaces.endereco.entidade.Endereco;
import br.com.futeweb.aplicacao.interfaces.estabelecimento.controle.IControleEstabelecimento;
import br.com.futeweb.aplicacao.interfaces.estabelecimento.entidade.Estabelecimento;
import br.com.futeweb.aplicacao.interfaces.usuario.entidade.PessoaJuridica;
import br.com.futeweb.aplicacao.interfaces.usuario.entidade.Usuario;

@Stateless
public class EstabelecimentoDAO extends GenericoDAO implements IControleEstabelecimento {

	private static final long serialVersionUID = 1L;

	@Override
	public int inserir(Estabelecimento object) throws SQLException {
		String query = " insert into estabelecimento (nome, descricao, id_endereco) values (?, ?, ?) ";
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
		query += " where es.id_endereco = en.id ";
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
		query += " and es.id_endereco = en.id ";		
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

	@Override
	public int inserirEstabelecimentoPessoaJuridica(Estabelecimento estabelecimento, PessoaJuridica pessoaJuridica) throws SQLException {
		String query = " insert into estabelecimento_pessoa_juridica (id_estabelecimento, id_pessoa_juridica) values (?, ?) ";
		montarQuery(query);
		setParametros().setInt(1, estabelecimento.getId());
		setParametros().setInt(2, pessoaJuridica.getId());
		return executarUpdate();
	}

	@Override
	public List<PessoaJuridica> obterPessoaJuridica(Estabelecimento estabelecimento) throws SQLException {
		List<PessoaJuridica> lista = new ArrayList<PessoaJuridica>();
		String query = " select pj.id, pj.nome, pj.email, pj.cnpj, ";
		query += " u.id, u.login, u.ativo ";
		query += " from pessoa_juridica pj, usuario u, estabelecimento_pessoa_juridica espj ";
		query += " where espj.id_estabelecimento = ? ";
		query += " and espj.id_pessoa_juridica = pj.id ";
		query += " and pj.id_usuario = u.id ";
		montarQuery(query);
		setParametros().setInt(1, estabelecimento.getId());
		String[][] retorno = executarQuery();
		if (retorno != null){
			for (String r[] : retorno){
				lista.add(new PessoaJuridica(Integer.parseInt(r[0]), r[1], r[2], r[3], 
						new Usuario(Integer.parseInt(r[4]), r[5], null, ("1".equals(r[6])))));
			}
		}
		return lista;
	}

	@Override
	public int removerEstabelecimentoPessoaJuridica(Estabelecimento estabelecimento, PessoaJuridica pessoaJuridica) throws SQLException {
		String query = " delete from estabelecimento_pessoa_juridica where id_estabelecimento = ? and id_pessoa_juridica = ? ";
		montarQuery(query);
		setParametros().setInt(1, estabelecimento.getId());
		setParametros().setInt(2, pessoaJuridica.getId());
		return executarUpdate();
	}
}
