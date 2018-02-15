package br.com.futeweb.aplicacao.interfaces.reserva.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import br.com.futeweb.aplicacao.dao.generico.GenericoDAO;
import br.com.futeweb.aplicacao.interfaces.master.entidade.Disponibilidade;
import br.com.futeweb.aplicacao.interfaces.reserva.controle.IControleReserva;
import br.com.futeweb.aplicacao.interfaces.reserva.entidade.Reserva;
import br.com.futeweb.aplicacao.interfaces.usuario.entidade.PessoaFisica;
import br.com.futeweb.aplicacao.utils.AplicacaoUtils;

@Stateless
public class ReservaDAO extends GenericoDAO implements IControleReserva {

	private static final long serialVersionUID = 1L;
	
	@Override
	public int inserir(Reserva object) throws SQLException {
		String query = " insert into reserva (id_disponibilidade_quadra, id_disponibilidade material, id_pessoa_fisica) values (?, ?, ?) ";
		montarQuery(query);
		setParametros().setInt(1, object.getDisponibilidadeQuadra().getId());
		setParametros().setInt(2, object.getDisponibilidadeMaterial().getId());
		setParametros().setInt(3, object.getPessoaFisica().getId());
		return executarUpdate();
	}

	@Override
	public List<Reserva> obterTodos() {
		List<Reserva> lista = new ArrayList<Reserva>();
		String query = " select r.id ";
		query += " dq.id, dq.data_inicio, dq.data_fim, ";
		query += " dm.id, dm.data_inicio, dm.data_fim, ";
		query += " pf.id, pf.nome, pf.email, pf.cpf, pf.data_nascimento ";
		query += " from reserva r, disponibilidade_quadra dq, disponibilidade_material dm, pessoa_fisica pf ";
		query += " where r.id_disponibilidade_quadra = dq.id ";
		query += " and r.id_disponibilidade_material = dm.id ";
		query += " and r.id_pessoa_fisica = pf.id ";
		montarQuery(query);
		String[][] retorno = executarQuery();
		if (retorno != null){
			for (String r[] : retorno){
				lista.add(new Reserva(Integer.parseInt(r[0]), 
						new Disponibilidade(Integer.parseInt(r[1]), AplicacaoUtils.parseDate(r[2]), AplicacaoUtils.parseDate(r[3])),
						new Disponibilidade(Integer.parseInt(r[4]), AplicacaoUtils.parseDate(r[5]), AplicacaoUtils.parseDate(r[6])),
						new PessoaFisica(Integer.parseInt(r[7]), r[8], r[9], r[10], AplicacaoUtils.parseDate(r[11]), null, null)));
			}
		}
		return lista;
	}

	@Override
	public List<Reserva> obterPorCriterio(Reserva object) throws SQLException {
		List<Reserva> lista = new ArrayList<Reserva>();
		String query = " select r.id ";
		query += " dq.id, dq.data_inicio, dq.data_fim, ";
		query += " dm.id, dm.data_inicio, dm.data_fim, ";
		query += " pf.id, pf.nome, pf.email, pf.cpf, pf.data_nascimento ";
		query += " from reserva r, disponibilidade_quadra dq, disponibilidade_material dm, pessoa_fisica pf ";
		query += " where q.id = ? ";
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
						new PessoaFisica(Integer.parseInt(r[7]), r[8], r[9], r[10], AplicacaoUtils.parseDate(r[11]), null, null)));
			}
		}
		return lista;
	}
	
	@Override
	public int atualizar(Reserva object) throws SQLException {
		String query = " delete reserva where id = ? ";
		montarQuery(query);
		setParametros().setInt(1, object.getId());
		return executarUpdate();
	}
}
