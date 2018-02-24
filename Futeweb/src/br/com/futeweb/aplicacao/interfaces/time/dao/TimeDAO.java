package br.com.futeweb.aplicacao.interfaces.time.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import br.com.futeweb.aplicacao.dao.generico.GenericoDAO;
import br.com.futeweb.aplicacao.interfaces.time.controle.IControleTime;
import br.com.futeweb.aplicacao.interfaces.time.entidade.Time;


//21:57:44	CREATE TABLE Time (   id INT NOT NULL AUTO_INCREMENT,   nome VARCHAR(50) NOT NULL,   descricao VARCHAR(200) NOT NULL,   PRIMARY KEY(id) )	0 row(s) affected	3.047 sec


@Stateless
public class TimeDAO extends GenericoDAO implements IControleTime {

	private static final long serialVersionUID = 1L;

	@Override
	public int inserir(Time object) throws SQLException {
		String query = " insert into time (nome,descricao) values (?,?) ";
		montarQuery(query);
		setParametros().setString(1, object.getNome());
		setParametros().setString(2, object.getDescricao());
		return executarUpdate();
	}

	public int inserirJogadorTime(Time object,int id_jogador) throws SQLException {
		String query = " insert into jogadores_time (id_time,id_jogador) values (?,?) ";
		montarQuery(query);
		setParametros().setInt(1, object.getId());
		setParametros().setInt(2, id_jogador);
		return executarUpdate();
	}	
	
	@Override
	public List<Time> obterTodos() {
		List<Time> lista = new ArrayList<Time>();
		String query = " select q.id, q.nome,q.descricao ";
		query += " from time q ";
		montarQuery(query);
		String[][] retorno = executarQuery();
		if (retorno != null){
			for (String r[] : retorno){
				lista.add(new Time(Integer.parseInt(r[0]), r[1],r[2]));
			}
		}
		return lista;
	}

	
	public int IdUltimoTimeCadastrado() {
		int id=0;
		String query = " select q.id, q.nome,q.descricao ";
		query += " from time q where q.id = (select max(id) from time)";
		montarQuery(query);
		String[][] retorno = executarQuery();
		if (retorno != null){
			for (String r[] : retorno){
				id = Integer.parseInt(r[0]);
			}
		}
		return id;
	}	
	
	public String NomeUltimoTimeCadastrado() {
		String Nome = "";
		String query = " select q.nome ";
		query += " from time q where q.id = (select max(id) from time)";
		montarQuery(query);
		String[][] retorno = executarQuery();
		if (retorno != null){
			for (String r[] : retorno){
				Nome = r[0];
			}
		}
		return Nome;
	}
	
	@Override
	public List<Time> obterPorCriterio(Time object) throws SQLException {
		List<Time> lista = new ArrayList<Time>();
		String query = " select q.id, q.nome, q.descricao";
		query += " from time q ";
		query += " where q.id = ?";
		montarQuery(query);
		setParametros().setInt(1, object.getId());
		String[][] retorno = executarQuery();
		if (retorno != null){
			for (String r[] : retorno){
				lista.add(new Time(Integer.parseInt(r[0]), r[1],r[2])
						);
			}
		}
		return lista;
	}
	
	@Override
	public int atualizar(Time object) throws SQLException {
		String query = " update time set nome = ?,descricao = ? where id = ? ";
		montarQuery(query);
		setParametros().setString(1, object.getNome());
		setParametros().setString(2, object.getDescricao());		
		setParametros().setInt(3, object.getId());
		return executarUpdate();
	}
}
