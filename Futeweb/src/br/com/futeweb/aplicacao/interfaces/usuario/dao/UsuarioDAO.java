package br.com.futeweb.aplicacao.interfaces.usuario.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import br.com.futeweb.aplicacao.dao.generico.GenericoDAO;
import br.com.futeweb.aplicacao.interfaces.endereco.entidade.Endereco;
import br.com.futeweb.aplicacao.interfaces.usuario.controle.IControleUsuario;
import br.com.futeweb.aplicacao.interfaces.usuario.entidade.PessoaFisica;
import br.com.futeweb.aplicacao.interfaces.usuario.entidade.PessoaJuridica;
import br.com.futeweb.aplicacao.interfaces.usuario.entidade.Usuario;
import br.com.futeweb.aplicacao.utils.AplicacaoUtils;

@Stateless
public class UsuarioDAO extends GenericoDAO implements IControleUsuario {

	private static final long serialVersionUID = 1L;
	
	@Override
	public PessoaFisica autenticarPF(Usuario object) throws SQLException{
		PessoaFisica pessoa = null;
		String query = " select pf.id, pf.nome, pf.email, pf.cpf, pf.data_nascimento, ";
		query += " u.id, u.login, u.ativo  ";
		query += " from pessoa_fisica pf, usuario u ";
		query += " where pf.id_usuario = u.id ";
		query += " and u.ativo = 1 and login = ? and senha = ? ";
		montarQuery(query);
		setParametros().setString(1, object.getLogin());
		setParametros().setString(2, object.getSenha());
		String[][] retorno = executarQuery();
		if (retorno != null){
			for (String r[] : retorno){
				pessoa = new PessoaFisica(Integer.parseInt(r[0]), r[1], r[2], r[3], AplicacaoUtils.parseDate(r[4]),
						new Usuario(Integer.parseInt(r[5]), r[6], r[7], ("1".equals(r[8]))), null);
			}
		}
		return pessoa;
	}
	
	@Override
	public PessoaJuridica autenticarPJ(Usuario object) throws SQLException{
		PessoaJuridica pessoa = null;
		String query = " select pj.id, pj.nome, pj.email, pj.cnpj, pj.data_nascimento ";
		query += " u.id, u.login, u.ativo ";
		query += " from pessoa_juridica pj, usuario u ";
		query += " where pj.id_usuario = u.id ";
		query += " and u.ativo = 1 and login = ? and senha = ? ";
		montarQuery(query);
		setParametros().setString(1, object.getLogin());
		setParametros().setString(2, object.getSenha());
		String[][] retorno = executarQuery();
		if (retorno != null){
			for (String r[] : retorno){
				pessoa = new PessoaJuridica(Integer.parseInt(r[0]), r[1], r[2], r[3], AplicacaoUtils.parseDate(r[4]) ,
						new Usuario(Integer.parseInt(r[4]), r[5], r[6], ("1".equals(r[7]))));
			}
		}
		return pessoa;
	}
	
	@Override
	public int inserir(Usuario object) throws SQLException {
		String query = " insert into Usuario (login, senha) values (?, ?) ";
		montarQuery(query);
		setParametros().setString(1, object.getLogin());
		setParametros().setString(2, object.getSenha());
		return executarUpdate();
	}

	@Override
	public List<Usuario> obterTodos() {
		List<Usuario> lista = new ArrayList<Usuario>();
		String query = " select id, login, null, ativo from usuario ";
		montarQuery(query);
		String[][] retorno = executarQuery();
		if (retorno != null){
			for (String r[] : retorno){
				lista.add(new Usuario(Integer.parseInt(r[0]), r[1], r[2], ("1".equals(r[3])) ));
			}
		}
		return lista;
	}

	@Override
	public List<Usuario> obterPorCriterio(Usuario object) throws SQLException {
		List<Usuario> lista = new ArrayList<Usuario>();
		String query = " select id, login, senha, ativo from usuario where id = ? or login = ? ";
		montarQuery(query);
		setParametros().setInt(1, object.getId());
		setParametros().setString(2, object.getLogin());
		String[][] retorno = executarQuery();
		if (retorno != null){
			for (String r[] : retorno){
				lista.add(new Usuario(Integer.parseInt(r[0]), r[1], r[2], ("1".equals(r[3]))));
			}
		}
		return lista;
	}

	@Override
	public int atualizar(Usuario object) throws SQLException {
		String query = " update usuario set senha = ?, ativo = ? where id = ? ";
		montarQuery(query);
		setParametros().setString(1, object.getSenha());
		setParametros().setInt(2, (object.isAtivo() ? 1 : 0));
		setParametros().setInt(3, object.getId());
		return executarUpdate();
	}
	
	
	/** PESSOA FISICA **/
	
	@Override
	public int inserir(PessoaFisica object) throws SQLException {
		String query = " insert into pessoa_fisica (nome, email, cpf, data_nascimento, id_usuario, id_endereco) values (?, ?, ?, ?, ?, ?) ";
		montarQuery(query);
		setParametros().setString(1, object.getNome());
		setParametros().setString(2, object.getEmail());
		setParametros().setString(3, object.getCpf());
		setParametros().setDate(4, AplicacaoUtils.dateUtilToSql(object.getDataNascimento()));
		setParametros().setInt(5, object.getUsuario().getId());
		setParametros().setInt(6, object.getEndereco().getId());
		return executarUpdate();
	}

	@Override
	public List<PessoaFisica> obterPessoaFisica() {
		List<PessoaFisica> lista = new ArrayList<PessoaFisica>();
		String query = " select pf.id, pf.nome, pf.email, pf.cpf, pf.data_nascimento, ";
		query += " u.id, u.login, u.ativo,  ";
		query += " e.id, e.logradouro, e.numero, e.cidade, e.estado, e.cep ";
		query += " from pessoa_fisica pf, usuario u, endereco e ";
		query += " where pf.id_usuario = u.id ";
		query += " and pf.endereco = e.id ";
		montarQuery(query);
		String[][] retorno = executarQuery();
		if (retorno != null){
			for (String r[] : retorno){
				lista.add(new PessoaFisica(Integer.parseInt(r[0]), r[1], r[2], r[3], AplicacaoUtils.parseDate(r[4]),
						new Usuario(Integer.parseInt(r[5]), r[6], r[7], ("1".equals(r[8]))),
						new Endereco(Integer.parseInt(r[9]), r[10], Integer.parseInt(r[11]), r[12], r[13], r[14])));
			}
		}
		return lista;
	}

	@Override
	public List<PessoaFisica> obterPorCriterio(PessoaFisica object) throws SQLException {
		List<PessoaFisica> lista = new ArrayList<PessoaFisica>();
		String query = " select pf.id, pf.nome, pf.email, pf.cpf, pf.data_nascimento, ";
		query += " u.id, u.login, u.ativo, ";
		query += " e.id, e.logradouro, e.numero, e.cidade, e.estado, e.cep ";
		query += " from pessoa_fisica pf, usuario u, endereco e ";
		query += " where pf.id = ? or pf.nome = ? or pf.email = ? or pf.cpf = ? ";
		query += " and pf.id_usuario = u.id ";
		query += " and pf.endereco = e.id ";
		montarQuery(query);
		setParametros().setInt(1, object.getId());
		setParametros().setString(2, object.getNome());
		setParametros().setString(3, object.getEmail());
		setParametros().setString(4, object.getCpf());
		String[][] retorno = executarQuery();
		if (retorno != null){
			for (String r[] : retorno){
				lista.add(new PessoaFisica(Integer.parseInt(r[0]), r[1], r[2], r[3], AplicacaoUtils.parseDate(r[4]),
						new Usuario(Integer.parseInt(r[5]), r[6], r[7], ("1".equals(r[8]))),
						new Endereco(Integer.parseInt(r[9]), r[10], Integer.parseInt(r[11]), r[12], r[13], r[14])));
			}
		}
		return lista;
	}

	@Override
	public int atualizar(PessoaFisica object) throws SQLException {
		String query = " update pessoa_fisica set nome = ? where id = ? ";
		montarQuery(query);
		setParametros().setString(1, object.getNome());
		setParametros().setInt(2, object.getId());
		return executarUpdate();
	}
	
	
	/** PESSOA JURIDICA **/

	@Override
	public int inserir(PessoaJuridica object) throws SQLException {
		String query = " insert into pessoa_juridica (nome, email, cnpj, id_usuario) values (?, ?, ?, ?) ";
		montarQuery(query);
		setParametros().setString(1, object.getNome());
		setParametros().setString(2, object.getEmail());
		setParametros().setString(3, object.getCnpj());
		setParametros().setInt(4, object.getUsuario().getId());
		return executarUpdate();
	}

	@Override
	public List<PessoaJuridica> obterPessoaJuridica() {
		List<PessoaJuridica> lista = new ArrayList<PessoaJuridica>();
		String query = " select pj.id, pj.nome, pj.email, pj.cnpj, pj.data_nascimento ";
		query += " u.id, u.login, u.ativo ";
		query += " from pessoa_juridica pj, usuario u ";
		query += " where pj.id_usuario = u.id ";
		montarQuery(query);
		String[][] retorno = executarQuery();
		if (retorno != null){
			for (String r[] : retorno){
				lista.add(new PessoaJuridica(Integer.parseInt(r[0]), r[1], r[2], r[3], AplicacaoUtils.parseDate(r[4]) ,
						new Usuario(Integer.parseInt(r[4]), r[5], r[6], ("1".equals(r[7])))));
			}
		}
		return lista;
	}

	@Override
	public List<PessoaJuridica> obterPorCriterio(PessoaJuridica object) throws SQLException {
		List<PessoaJuridica> lista = new ArrayList<PessoaJuridica>();
		String query = " select pj.id, pj.nome, pj.email, pj.cnpj, pj.data_nascimento ";
		query += " u.id, u.login, u.ativo ";
		query += " from pessoa_juridica pj, usuario u ";
		query += " where pj.id = ? or pj.nome = ? or pj.email = ? or pj.cnpj = ? ";
		query += " and pj.id_usuario = u.id ";
		montarQuery(query);
		String[][] retorno = executarQuery();
		if (retorno != null){
			for (String r[] : retorno){
				lista.add(new PessoaJuridica(Integer.parseInt(r[0]), r[1], r[2], r[3], AplicacaoUtils.parseDate(r[4]) ,
						new Usuario(Integer.parseInt(r[4]), r[5], r[6], ("1".equals(r[7])))));
			}
		}
		return lista;
	}

	@Override
	public int atualizar(PessoaJuridica object) throws SQLException {
		String query = " update pessoa_juridica set nome = ? where id = ? ";
		montarQuery(query);
		setParametros().setString(1, object.getNome());
		setParametros().setInt(2, object.getId());
		return executarUpdate();
	}
}
