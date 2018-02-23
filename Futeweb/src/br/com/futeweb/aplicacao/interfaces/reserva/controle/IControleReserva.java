package br.com.futeweb.aplicacao.interfaces.reserva.controle;

import java.sql.SQLException;
import java.util.List;

import br.com.futeweb.aplicacao.dao.generico.IGenericoDAO;
import br.com.futeweb.aplicacao.interfaces.material.entidade.Material;
import br.com.futeweb.aplicacao.interfaces.quadra.entidade.Quadra;
import br.com.futeweb.aplicacao.interfaces.reserva.entidade.Reserva;
import br.com.futeweb.aplicacao.interfaces.usuario.entidade.PessoaFisica;

public interface IControleReserva extends IGenericoDAO<Reserva>  {
	
	public List<Reserva> obterReservaDisponibilidadeMaterial(Material material) throws SQLException;
	public List<Reserva> obterReservaDisponibilidadeQuadra(Quadra quadra) throws SQLException;
	public List<Reserva> obterReservaPessoaFisica(PessoaFisica pessoaFisica) throws SQLException;
	public int remover(Reserva object) throws SQLException;
	
}
