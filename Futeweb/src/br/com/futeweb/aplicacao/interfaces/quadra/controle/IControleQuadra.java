package br.com.futeweb.aplicacao.interfaces.quadra.controle;

import java.sql.SQLException;
import java.util.List;

import br.com.futeweb.aplicacao.dao.generico.IGenericoDAO;
import br.com.futeweb.aplicacao.interfaces.estabelecimento.entidade.Estabelecimento;
import br.com.futeweb.aplicacao.interfaces.master.entidade.Disponibilidade;
import br.com.futeweb.aplicacao.interfaces.quadra.entidade.Quadra;

public interface IControleQuadra extends IGenericoDAO<Quadra>  {
	
	public int inserir(Quadra quadra, int idEstabelecimento) throws SQLException;
	public List<Quadra> obterQuadra(Estabelecimento estabelecimento) throws SQLException;
	
	public int inserirDisponibilidadeQuadra(Disponibilidade disponibilidade, Quadra quadra) throws SQLException;
	public List<Disponibilidade> obterDisponibilidadeQuadra(Quadra quadra) throws SQLException;
	public int removerDisponibilidadeQuadra(Disponibilidade disponibilidade) throws SQLException;

}
