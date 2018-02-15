package br.com.futeweb.aplicacao.interfaces.estabelecimento.controle;

import java.sql.SQLException;
import java.util.List;

import br.com.futeweb.aplicacao.dao.generico.IGenericoDAO;
import br.com.futeweb.aplicacao.interfaces.estabelecimento.entidade.Estabelecimento;
import br.com.futeweb.aplicacao.interfaces.usuario.entidade.PessoaJuridica;

public interface IControleEstabelecimento extends IGenericoDAO<Estabelecimento>  {
	
	public int inserirEstabelecimentoPessoaJuridica(Estabelecimento estabelecimento, PessoaJuridica pessoaJuridica) throws SQLException;
	public List<PessoaJuridica> obterPessoaJuridica(Estabelecimento estabelecimento) throws SQLException;
	public int removerEstabelecimentoPessoaJuridica(Estabelecimento estabelecimento, PessoaJuridica pessoaJuridica) throws SQLException;
}
