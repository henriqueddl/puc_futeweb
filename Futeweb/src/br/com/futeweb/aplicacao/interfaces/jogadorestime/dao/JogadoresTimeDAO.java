package br.com.futeweb.aplicacao.interfaces.jogadorestime.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import javax.ejb.Stateless;

import br.com.futeweb.aplicacao.dao.generico.GenericoDAO;
import br.com.futeweb.aplicacao.interfaces.jogadorestime.controle.IControleJogadoresTime;
import br.com.futeweb.aplicacao.interfaces.jogadorestime.entidade.JogadoresTime;


//21:57:44	CREATE TABLE Time (   id INT NOT NULL AUTO_INCREMENT,   nome VARCHAR(50) NOT NULL,   descricao VARCHAR(200) NOT NULL,   PRIMARY KEY(id) )	0 row(s) affected	3.047 sec


@Stateless
public class JogadoresTimeDAO extends GenericoDAO implements IControleJogadoresTime {

	private static final long serialVersionUID = 1L;

	@Override
	public int inserir(JogadoresTime object) throws SQLException {
		String query = " insert into jogadorestime (id_time,id_campeonato) values (?,?) ";
		montarQuery(query);
		setParametros().setInt(1, object.getIdtime());
		setParametros().setInt(2, object.getIdjogador());
		return executarUpdate();
	}

	@Override
	public List<JogadoresTime> obterTodos() {
		List<JogadoresTime> lista = new ArrayList<JogadoresTime>();
		String query = " select q.id_time, q.id_jogador ";
		query += " from jogadorestime q ";
		montarQuery(query);
		String[][] retorno = executarQuery();
		if (retorno != null){
			for (String r[] : retorno){
				lista.add(new JogadoresTime(Integer.parseInt(r[0]), Integer.parseInt(r[1])));
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
	public List<JogadoresTime> obterPorCriterio(JogadoresTime object) throws SQLException {
		List<JogadoresTime> lista = new ArrayList<JogadoresTime>();
		String query = " select q.id, q.nome, q.descricao";
		query += " from jogadorestime q ";
		query += " where q.id_time = ?";
		montarQuery(query);
		setParametros().setInt(1, object.getIdtime());
		String[][] retorno = executarQuery();
		if (retorno != null){
			for (String r[] : retorno){
				lista.add(new JogadoresTime(Integer.parseInt(r[0]), Integer.parseInt(r[1])
						));
			}
		}
		return lista;
	}
	

	public Map<Integer, String> obterListaJogadores() throws SQLException {
		Map<Integer, String> lista = new HashMap<Integer, String>();;
		String query = " select q.id, q.nome ";
		query += " from pessoa_fisica q ";
		montarQuery(query);
		String[][] retorno = executarQuery();
		if (retorno != null){
			for (String r[] : retorno){
				lista.put(Integer.parseInt(r[0]),r[1]);
			}
		}
		return lista;
	}
	
	
	public Map<Integer, String> obterListaTimes() throws SQLException {
		Map<Integer, String> lista = new HashMap<Integer, String>();;
		String query = " select q.id, q.nome ";
		query += " from time q ";
		montarQuery(query);
		String[][] retorno = executarQuery();
		if (retorno != null){
			for (String r[] : retorno){
				lista.put(Integer.parseInt(r[0]),r[1]);
			}
		}
		return lista;
	}
	
	@Override
	public int atualizar(JogadoresTime object) throws SQLException {
		String query = " update jogadorestime set id_jogador = ? where id_time = ? ";
		montarQuery(query);
		setParametros().setInt(1, object.getIdjogador());
		setParametros().setInt(2, object.getIdtime());		
		return executarUpdate();
	}
}
