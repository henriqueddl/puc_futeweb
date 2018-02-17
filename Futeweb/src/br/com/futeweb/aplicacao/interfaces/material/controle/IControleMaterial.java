package br.com.futeweb.aplicacao.interfaces.material.controle;

import java.sql.SQLException;
import java.util.List;

import br.com.futeweb.aplicacao.dao.generico.IGenericoDAO;
import br.com.futeweb.aplicacao.interfaces.estabelecimento.entidade.Estabelecimento;
import br.com.futeweb.aplicacao.interfaces.master.entidade.Disponibilidade;
import br.com.futeweb.aplicacao.interfaces.material.entidade.Material;

public interface IControleMaterial extends IGenericoDAO<Material>  {

	public int inserir(Material material, int idEstabelecimento) throws SQLException;
	public List<Material> obterMaterial(Estabelecimento estabelecimento) throws SQLException;
	
	public int inserirDisponibilidadeMaterial(Disponibilidade disponibilidade, Material material) throws SQLException;
	public List<Disponibilidade> obterDisponibilidadeMaterial(Material material) throws SQLException;
	public int removerDisponibilidadeMaterial(Disponibilidade disponibilidade) throws SQLException;
	
	
}
