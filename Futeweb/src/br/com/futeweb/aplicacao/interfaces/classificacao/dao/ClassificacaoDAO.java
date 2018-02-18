package br.com.futeweb.aplicacao.interfaces.classificacao.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;

import javax.ejb.Stateless;

import br.com.futeweb.aplicacao.dao.generico.GenericoDAO;
import br.com.futeweb.aplicacao.interfaces.classificacao.entidade.Classificacao;
import br.com.futeweb.aplicacao.interfaces.master.entidade.Disponibilidade;
import br.com.futeweb.aplicacao.utils.AplicacaoUtils;
import br.com.futeweb.aplicacao.interfaces.classificacao.controle.IControleClassificacao;


@Stateless
public class ClassificacaoDAO extends GenericoDAO implements IControleClassificacao {

	private static final long serialVersionUID = 1L;

	@Override
	public int inserir(Classificacao object) throws SQLException {
		String query = " insert into classificacao (id_campeonato,id_time,vitorias,golspro,golscontra,saldo) values (?, ?,?,?,?) ";
		montarQuery(query);
		setParametros().setInt(1, object.getId_Campeonato());
		setParametros().setInt(2, object.getId_Time());
		setParametros().setInt(3, object.getvitorias());
		setParametros().setInt(4, object.getgolsPro());
		setParametros().setInt(5, object.getgolsContra());		
		return executarUpdate();
	}

	@Override
	public List<Classificacao> obterTodos() {
		List<Classificacao> lista = new ArrayList<Classificacao>();
		String query = " select q.id, q.id_campeonato,q.id_time, ";
		query += " q.vitorias, q.golsPro,q.golsContra ";
		query += " from classificacao q, campeonato e ";
		query += " where q.id_campeonato = e.id ";
		montarQuery(query);
		String[][] retorno = executarQuery();
		if (retorno != null){
			for (String r[] : retorno){
				lista.add(new Classificacao(Integer.parseInt(r[0]),Integer.parseInt(r[1]),Integer.parseInt(r[2]),Integer.parseInt(r[3]),Integer.parseInt(r[4]),Integer.parseInt(r[5])));
			}
		}
		return lista;
	}

	@Override
	public List<Classificacao> obterPorCriterio(Classificacao object) throws SQLException {
		List<Classificacao> lista = new ArrayList<Classificacao>();
		String query = " select q.id, q.nome, ";
		query += " es.id, es.nome, es.descricao ";
		query += " from classificacao q, campeonato e ";
		query += " where q.id = ? or m.nome ";
		query += " and q.id_campeonato = e.id ";
		montarQuery(query);
		setParametros().setInt(1, object.getId());
		String[][] retorno = executarQuery();
		if (retorno != null){
			for (String r[] : retorno){
				lista.add(new Classificacao(Integer.parseInt(r[0]),Integer.parseInt(r[1]),Integer.parseInt(r[2]),Integer.parseInt(r[3]),Integer.parseInt(r[4]),Integer.parseInt(r[5])));
			}
		}
		return lista;
	}
	
	@Override
	public int atualizar(Classificacao object) throws SQLException {
		String query = " update classificacao set Id_campeonato = ?,Id_time = ?, vitorias = ?,golsPro = ?, golsContra = ? where id = ? ";
		montarQuery(query);
		setParametros().setInt(1, object.getId_Campeonato());
		setParametros().setInt(2, object.getId_Time());
		setParametros().setInt(3, object.getvitorias());
		setParametros().setInt(4, object.getgolsPro());
		setParametros().setInt(5, object.getgolsContra());	
		setParametros().setInt(6, object.getId());			
		return executarUpdate();
	}
	
	public int AtualizarClassificacao(Classificacao object) throws SQLException {
		String queryJogos = " select id_jogo,id_timeMandante,id_Timevisitante, golsTimeMandante,golsTime visitante from jogo where id_campeonato = ?";
		montarQuery(queryJogos);
		setParametros().setInt(1, object.getId_Campeonato());		
		
		String[][] retorno = executarQuery();
		if (retorno != null){
			for (String r[] : retorno){
				//lista.add(new Disponibilidade(Integer.parseInt(r[0]), AplicacaoUtils.parseDate(r[1]), AplicacaoUtils.parseDate(r[2])));
			}
		}
		
		String query = " update classificacao set Id_campeonato = ?,Id_time = ?, vitorias = ?,golsPro = ?, golsContra = ? where id = ? ";
		montarQuery(query);
		setParametros().setInt(1, object.getId_Campeonato());
		setParametros().setInt(2, object.getId_Time());
		setParametros().setInt(3, object.getvitorias());
		setParametros().setInt(4, object.getgolsPro());
		setParametros().setInt(5, object.getgolsContra());	
		setParametros().setInt(6, object.getId());			
		return executarUpdate();
	}	
}
