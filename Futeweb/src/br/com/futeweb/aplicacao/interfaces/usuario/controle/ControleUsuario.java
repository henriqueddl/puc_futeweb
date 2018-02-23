package br.com.futeweb.aplicacao.interfaces.usuario.controle;

import java.sql.SQLException;
import java.util.List;

import javax.ejb.Stateless;

import br.com.futeweb.aplicacao.dao.generico.GenericoDAO;
import br.com.futeweb.aplicacao.interfaces.usuario.dao.UsuarioDAO;
import br.com.futeweb.aplicacao.interfaces.usuario.entidade.PessoaFisica;
import br.com.futeweb.aplicacao.interfaces.usuario.entidade.PessoaJuridica;
import br.com.futeweb.aplicacao.interfaces.usuario.entidade.Usuario;

@Stateless
public class ControleUsuario extends GenericoDAO implements IControleUsuario {

	private static final long serialVersionUID = 1L;
	private UsuarioDAO dao;
	
	private UsuarioDAO getInstance(){
		if (dao==null){
			dao = new UsuarioDAO();
		}
		return dao;
	}
	
	@Override
	public int inserir(Usuario object) throws SQLException {
		return getInstance().inserir(object);
	}

	@Override
	public List<Usuario> obterTodos() {
		return getInstance().obterTodos();
	}

	@Override
	public List<Usuario> obterPorCriterio(Usuario object) throws SQLException {
		return getInstance().obterPorCriterio(object);
	}
	
	@Override
	public int atualizar(Usuario object) throws SQLException {
		return getInstance().atualizar(object);
	}
	
	@Override
	public int inserir(PessoaFisica object) throws SQLException {
		return	getInstance().inserir(object);
	}

	@Override
	public List<PessoaFisica> obterPessoaFisica() {
		return getInstance().obterPessoaFisica();
	}

	@Override
	public List<PessoaFisica> obterPorCriterio(PessoaFisica object) throws SQLException {
		return getInstance().obterPorCriterio(object);
	}
	
	@Override
	public int atualizar(PessoaFisica object) throws SQLException {
		return getInstance().atualizar(object);
	}
	
	@Override
	public int inserir(PessoaJuridica object) throws SQLException {
		return getInstance().inserir(object);
	}

	@Override
	public List<PessoaJuridica> obterPessoaJuridica() {
		return getInstance().obterPessoaJuridica();
	}

	@Override
	public List<PessoaJuridica> obterPorCriterio(PessoaJuridica object) throws SQLException {
		return getInstance().obterPorCriterio(object);
	}
	
	@Override
	public int atualizar(PessoaJuridica object) throws SQLException {
		return getInstance().atualizar(object);
	}

	@Override
	public PessoaFisica autenticarPF(Usuario object) throws SQLException {
		return getInstance().autenticarPF(object);
	}

	@Override
	public PessoaJuridica autenticarPJ(Usuario object) throws SQLException {
		return getInstance().autenticarPJ(object);
	}
	
}
