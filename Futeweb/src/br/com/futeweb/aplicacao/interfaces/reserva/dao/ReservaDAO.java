package br.com.futeweb.aplicacao.interfaces.reserva.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import br.com.futeweb.aplicacao.dao.generico.GenericoDAO;
import br.com.futeweb.aplicacao.interfaces.master.entidade.Disponibilidade;
import br.com.futeweb.aplicacao.interfaces.material.entidade.Material;
import br.com.futeweb.aplicacao.interfaces.quadra.entidade.Quadra;
import br.com.futeweb.aplicacao.interfaces.reserva.controle.IControleReserva;
import br.com.futeweb.aplicacao.interfaces.reserva.entidade.Reserva;
import br.com.futeweb.aplicacao.interfaces.usuario.entidade.PessoaFisica;
import br.com.futeweb.aplicacao.utils.AplicacaoUtils;

@Stateless
public class ReservaDAO extends GenericoDAO implements IControleReserva {

	private static final long serialVersionUID = 1L;
	
	@Override
	public int inserir(Reserva object) throws SQLException {
		String query = " insert into reserva (id_disponibilidade_quadra, id_disponibilidade_material, id_pessoa_fisica) values (?, ?, ?) ";
		montarQuery(query);
		setParametros().setInt(1, object.getDisponibilidadeQuadra().getId());
		setParametros().setInt(2, object.getDisponibilidadeMaterial().getId());
		setParametros().setInt(3, object.getPessoaFisica().getId());
		return executarUpdate();
	}
	
	@Deprecated
	@Override
	public List<Reserva> obterTodos() {
		return new ArrayList<Reserva>();
	}
	
	@Override
	public List<Reserva> obterReservaPessoaFisica(PessoaFisica pessoaFisica) throws SQLException{
		List<Reserva> lista = new ArrayList<Reserva>();
		String query = " select r.id, ";
		query += " dq.id, dq.data_inicio, dq.data_fim, ";
		query += " dm.id, dm.data_inicio, dm.data_fim, ";
		query += " pf.id, pf.nome, pf.email, pf.cpf, pf.data_nascimento ";
		query += " from reserva r, disponibilidade_quadra dq, disponibilidade_material dm, pessoa_fisica pf ";
		query += " where r.id_pessoa_fisica = ? ";
		query += " and r.id_disponibilidade_quadra = dq.id ";
		query += " and r.id_disponibilidade_material = dm.id ";
		query += " and r.id_pessoa_fisica = pf.id ";
		montarQuery(query);
		setParametros().setInt(1, pessoaFisica.getId());
		String[][] retorno = executarQuery();
		if (retorno != null){
			for (String r[] : retorno){
				lista.add(new Reserva(Integer.parseInt(r[0]), 
						new Disponibilidade(Integer.parseInt(r[1]), AplicacaoUtils.parseDate(r[2]), AplicacaoUtils.parseDate(r[3])),
						new Disponibilidade(Integer.parseInt(r[4]), AplicacaoUtils.parseDate(r[5]), AplicacaoUtils.parseDate(r[6])),
						new PessoaFisica(Integer.parseInt(r[7]), r[8], r[9], r[10], AplicacaoUtils.parseDate(r[11]), null)));
			}
		}
		return lista;
	}
	
	@Override
	public List<Reserva> obterReservaDisponibilidadeQuadra(Quadra quadra) throws SQLException{
		List<Reserva> lista = new ArrayList<Reserva>();
		String query = " select r.id, ";
		query += " dq.id, dq.data_inicio, dq.data_fim, ";
		query += " dm.id, dm.data_inicio, dm.data_fim, ";
		query += " pf.id, pf.nome, pf.email, pf.cpf, pf.data_nascimento ";
		query += " from reserva r, disponibilidade_quadra dq, disponibilidade_material dm, pessoa_fisica pf ";
		query += " where r.id_disponibilidade_quadra = ? ";
		query += " and r.id_disponibilidade_quadra = dq.id ";
		query += " and r.id_disponibilidade_material = dm.id ";
		query += " and r.id_disponibilidade_quadra = dq.id ";
		montarQuery(query);
		setParametros().setInt(1, quadra.getId());
		String[][] retorno = executarQuery();
		if (retorno != null){
			for (String r[] : retorno){
				lista.add(new Reserva(Integer.parseInt(r[0]), 
						new Disponibilidade(Integer.parseInt(r[1]), AplicacaoUtils.parseDate(r[2]), AplicacaoUtils.parseDate(r[3])),
						new Disponibilidade(Integer.parseInt(r[4]), AplicacaoUtils.parseDate(r[5]), AplicacaoUtils.parseDate(r[6])),
						new PessoaFisica(Integer.parseInt(r[7]), r[8], r[9], r[10], AplicacaoUtils.parseDate(r[11]), null)));
			}
		}
		return lista;
	}
	
	@Override
	public List<Reserva> obterReservaDisponibilidadeMaterial(Material material) throws SQLException{
		List<Reserva> lista = new ArrayList<Reserva>();
		String query = " select r.id, ";
		query += " dq.id, dq.data_inicio, dq.data_fim, ";
		query += " dm.id, dm.data_inicio, dm.data_fim, ";
		query += " pf.id, pf.nome, pf.email, pf.cpf, pf.data_nascimento ";
		query += " from reserva r, disponibilidade_quadra dq, disponibilidade_material dm, pessoa_fisica pf ";
		query += " where r.id_disponibilidade_material = ? ";
		query += " and r.id_disponibilidade_quadra = dq.id ";
		query += " and r.id_disponibilidade_material = dm.id ";
		query += " and r.id_disponibilidade_material = dm.id ";
		montarQuery(query);
		setParametros().setInt(1, material.getId());
		String[][] retorno = executarQuery();
		if (retorno != null){
			for (String r[] : retorno){
				lista.add(new Reserva(Integer.parseInt(r[0]), 
						new Disponibilidade(Integer.parseInt(r[1]), AplicacaoUtils.parseDate(r[2]), AplicacaoUtils.parseDate(r[3])),
						new Disponibilidade(Integer.parseInt(r[4]), AplicacaoUtils.parseDate(r[5]), AplicacaoUtils.parseDate(r[6])),
						new PessoaFisica(Integer.parseInt(r[7]), r[8], r[9], r[10], AplicacaoUtils.parseDate(r[11]), null)));
			}
		}
		return lista;
	}

	@Override
	public List<Reserva> obterPorCriterio(Reserva object) throws SQLException {
		List<Reserva> lista = new ArrayList<Reserva>();
		String query = " select r.id, ";
		query += " dq.id, dq.data_inicio, dq.data_fim, ";
		query += " dm.id, dm.data_inicio, dm.data_fim, ";
		query += " pf.id, pf.nome, pf.email, pf.cpf, pf.data_nascimento ";
		query += " from reserva r, disponibilidade_quadra dq, disponibilidade_material dm, pessoa_fisica pf ";
		query += " where r.id = ? ";
		query += " and r.id_disponibilidade_quadra = dq.id ";
		query += " and r.id_disponibilidade_material = dm.id ";
		query += " and r.id_pessoa_fisica = pf.id ";
		montarQuery(query);
		setParametros().setInt(1, object.getId());
		String[][] retorno = executarQuery();
		if (retorno != null){
			for (String r[] : retorno){
				lista.add(new Reserva(Integer.parseInt(r[0]), 
						new Disponibilidade(Integer.parseInt(r[1]), AplicacaoUtils.parseDate(r[2]), AplicacaoUtils.parseDate(r[3])),
						new Disponibilidade(Integer.parseInt(r[4]), AplicacaoUtils.parseDate(r[5]), AplicacaoUtils.parseDate(r[6])),
						new PessoaFisica(Integer.parseInt(r[7]), r[8], r[9], r[10], AplicacaoUtils.parseDate(r[11]), null)));
			}
		}
		return lista;
	}
	
	@Deprecated
	@Override
	public int atualizar(Reserva object) throws SQLException {
		return 0;
	}

	@Override
	public int remover(Reserva object) throws SQLException {
		String query = " delete from reserva where id = ? ";
		montarQuery(query);
		setParametros().setInt(1, object.getId());
		return executarUpdate();
	}
}
