package br.com.futeweb.aplicacao.interfaces.reserva.controle;

import java.sql.SQLException;
import java.util.List;

import javax.ejb.Stateless;
import javax.faces.application.FacesMessage;

import br.com.futeweb.aplicacao.dao.generico.GenericoDAO;
import br.com.futeweb.aplicacao.interfaces.material.entidade.Material;
import br.com.futeweb.aplicacao.interfaces.quadra.entidade.Quadra;
import br.com.futeweb.aplicacao.interfaces.reserva.dao.ReservaDAO;
import br.com.futeweb.aplicacao.interfaces.reserva.entidade.Reserva;
import br.com.futeweb.aplicacao.interfaces.usuario.entidade.PessoaFisica;
import br.com.futeweb.aplicacao.utils.Logger;
import br.com.futeweb.aplicacao.utils.Mensagens;

@Stateless
public class ControleReserva extends GenericoDAO implements IControleReserva {

	private static final long serialVersionUID = 1L;
	private ReservaDAO dao;
	
	private ReservaDAO getInstance(){
		if (dao==null){
			dao = new ReservaDAO();
		}
		return dao;
	}
	
	@Override
	public int inserir(Reserva object) throws SQLException {
		 return getInstance().inserir(object);
	}
	
	@Deprecated
	@Override
	public List<Reserva> obterTodos() {
		return getInstance().obterTodos();
	}
	
	@Override
	public List<Reserva> obterReservaDisponibilidadeMaterial(Material material) throws SQLException {
		List<Reserva> lista = getInstance().obterReservaDisponibilidadeMaterial(material);
		if (lista==null || lista.size()==0){
			new Logger(true, FacesMessage.SEVERITY_ERROR, Mensagens.ERRO_RESERVA_CONSULTAR, Mensagens.ID_CAMPO_MENSAGEM_INDEX);
		}
		return lista;
	}

	@Override
	public List<Reserva> obterReservaDisponibilidadeQuadra(Quadra quadra) throws SQLException {
		List<Reserva> lista = getInstance().obterReservaDisponibilidadeQuadra(quadra);
		if (lista==null || lista.size()==0){
			new Logger(true, FacesMessage.SEVERITY_ERROR, Mensagens.ERRO_RESERVA_CONSULTAR, Mensagens.ID_CAMPO_MENSAGEM_INDEX);
		}
		return lista;
	}

	@Override
	public List<Reserva> obterReservaPessoaFisica(PessoaFisica pessoaFisica) throws SQLException {
		List<Reserva> lista = getInstance().obterReservaPessoaFisica(pessoaFisica);
		if (lista==null || lista.size()==0){
			new Logger(true, FacesMessage.SEVERITY_ERROR, Mensagens.ERRO_RESERVA_CONSULTAR, Mensagens.ID_CAMPO_MENSAGEM_INDEX);
		}
		return lista;
	}

	@Override
	public List<Reserva> obterPorCriterio(Reserva object) throws SQLException {
		return getInstance().obterPorCriterio(object);
	}
	
	@Override
	public int remover(Reserva object) throws SQLException {
		return getInstance().remover(object);
	}

	@Deprecated
	@Override
	public int atualizar(Reserva object) throws SQLException {
		return getInstance().atualizar(object);
	}
}
