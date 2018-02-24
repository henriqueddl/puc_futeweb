package br.com.futeweb.aplicacao.interfaces.classificacao.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import br.com.futeweb.aplicacao.dao.generico.GenericoDAO;
import br.com.futeweb.aplicacao.interfaces.classificacao.entidade.Classificacao;
import br.com.futeweb.aplicacao.interfaces.classificacao.controle.IControleClassificacao;


@Stateless
public class ClassificacaoDAO extends GenericoDAO implements IControleClassificacao {

	private static final long serialVersionUID = 1L;

	@Override
	public int inserir(Classificacao object) throws SQLException {
		String query = " insert into classificacao (idcampeonato,idtime,jogos,vitorias,golspro,golscontra,saldo) values (?,?, ?,?,?,?) ";
		montarQuery(query);
		setParametros().setInt(1, object.getIdCampeonato());
		setParametros().setInt(2, object.getIdTime());
		setParametros().setInt(3, object.getjogos());
		setParametros().setInt(4, object.getvitorias());
		setParametros().setInt(5, object.getgolsPro());
		setParametros().setInt(6, object.getgolsContra());		
		return executarUpdate();
	}

	@Override
	public List<Classificacao> obterTodos() {
		List<Classificacao> lista = new ArrayList<Classificacao>();
		String query = " select q.id, q.idcampeonato,q.idtime, ";
		query += " q.jogos,q.vitorias, q.golsPro,q.golsContra ";
		query += " from classificacao q, campeonato e ";
		query += " where q.id_campeonato = e.id ";
		montarQuery(query);
		String[][] retorno = executarQuery();
		if (retorno != null){
			for (String r[] : retorno){
				lista.add(new Classificacao(Integer.parseInt(r[0]),Integer.parseInt(r[1]),Integer.parseInt(r[2]),Integer.parseInt(r[3]),Integer.parseInt(r[4]),Integer.parseInt(r[5]), Integer.parseInt(r[6])));
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
		query += " and q.idcampeonato = e.id ";
		montarQuery(query);
		setParametros().setInt(1, object.getId());
		String[][] retorno = executarQuery();
		if (retorno != null){
			for (String r[] : retorno){
				lista.add(new Classificacao(Integer.parseInt(r[0]),Integer.parseInt(r[1]),Integer.parseInt(r[2]),Integer.parseInt(r[3]),Integer.parseInt(r[4]),Integer.parseInt(r[5]),Integer.parseInt(r[6])));
			}
		}
		return lista;
	}
	
	@Override
	public int atualizar(Classificacao object) throws SQLException {
		String query = " update classificacao set Idcampeonato = ?,Idtime = ?, vitorias = ?,golsPro = ?, golsContra = ? where id = ? ";
		montarQuery(query);
		setParametros().setInt(1, object.getIdCampeonato());
		setParametros().setInt(2, object.getIdTime());
		setParametros().setInt(3, object.getvitorias());
		setParametros().setInt(4, object.getgolsPro());
		setParametros().setInt(5, object.getgolsContra());	
		setParametros().setInt(6, object.getId());			
		return executarUpdate();
	}
	
	
	@Override
	//public int exibirClassificacao(int idcampeonato) throws SQLException {
		//String query = " update classificacao set Idcampeonato = ?,Idtime = ?, vitorias = ?,golsPro = ?, golsContra = ? where id = ? ";
		//montarQuery(query);
		//setParametros().setInt(1, object.getIdCampeonato());
		//setParametros().setInt(2, object.getIdTime());
		//setParametros().setInt(3, object.getvitorias());
		//setParametros().setInt(4, object.getgolsPro());
		//setParametros().setInt(5, object.getgolsContra());	
		//setParametros().setInt(6, object.getId());			
		//return 1;
	//}
	
	
	
	public int AtualizarClassificacao(Classificacao object) throws SQLException {
		int pontosMandante = 0;
		int pontosVisitante = 0;
		int golsProMandante = 0;
		int golsContraMandante = 0;
		int golsProVisitante = 0;
		int golsContraVisitante = 0;
		int vitoriasMandante = 0;
		int vitoriasVisitante = 0;
		int jogosMandante = 0;
		int jogosVisitante = 0;	
		int id_timemandante = 0;
		int id_timevisitante = 0;
		
		String queryJogos = " select idjogo,idtimeMandante,id_Timevisitante, golsTimeMandante,golsTimevisitante from jogo where id_campeonato = ? and data_realizacao is not null";
		montarQuery(queryJogos);
		setParametros().setInt(1, object.getIdCampeonato());		
		
		String[][] retorno = executarQuery();
		if (retorno != null){
			for (String r[] : retorno){
				
			
		    	id_timemandante = Integer.parseInt(r[1]);
		    	id_timevisitante = Integer.parseInt(r[2]);
				jogosMandante = jogosMandante + 1;
				jogosVisitante = jogosVisitante + 1;	
			
				if (Integer.parseInt(r[3]) > Integer.parseInt(r[4])) {
					vitoriasMandante = vitoriasMandante + 1;
					pontosMandante = pontosMandante + 3;
					golsProMandante = golsProMandante + Integer.parseInt(r[3]);
					golsProVisitante = golsProVisitante + Integer.parseInt(r[4]);

					golsContraMandante = golsContraMandante + golsProVisitante;
					golsContraVisitante = golsContraVisitante + golsProMandante;
				}
				if (Integer.parseInt(r[3]) < Integer.parseInt(r[4])) {
					vitoriasVisitante = vitoriasVisitante + 1;
					pontosVisitante = pontosVisitante + 3;
					golsProMandante = golsProMandante + Integer.parseInt(r[3]);
					golsProVisitante = golsProVisitante + Integer.parseInt(r[4]);

					golsContraMandante = golsContraMandante + golsProVisitante;
					golsContraVisitante = golsContraVisitante + golsProMandante;	
				}      
				
				if (Integer.parseInt(r[3]) == Integer.parseInt(r[4])) {
					pontosMandante =  pontosMandante + 1;
					pontosVisitante = pontosVisitante + 1;
					golsProMandante = golsProMandante + Integer.parseInt(r[3]);
					golsProVisitante = golsProVisitante + Integer.parseInt(r[4]);

					golsContraMandante = golsContraMandante + golsProVisitante;
					golsContraVisitante = golsContraVisitante + golsProMandante;				}
				
			}
		    
			//Atualiza informa��o do mandante, e depois do visitante
			String query = " update classificacao set Idcampeonato = ?, jogos = ?,vitorias = ?,golsPro = ?, golsContra = ? where id = ? and Id_time = ?";
			montarQuery(query);
			setParametros().setInt(1, object.getIdCampeonato());
			setParametros().setInt(2, jogosMandante);			
			setParametros().setInt(3, vitoriasMandante);
			setParametros().setInt(4, golsProMandante);
			setParametros().setInt(5, golsContraMandante);
			setParametros().setInt(6, object.getId());	
			setParametros().setInt(7, id_timemandante);			
			executarUpdate();
			
			query = " update classificacao set Idcampeonato = ?, vitorias = ?,golsPro = ?, golsContra = ? where id = ? and Id_time = ?";
			montarQuery(query);
			setParametros().setInt(1, object.getIdCampeonato());
			setParametros().setInt(2, jogosVisitante);			
			setParametros().setInt(3, vitoriasVisitante);
			setParametros().setInt(4, golsProVisitante);
			setParametros().setInt(5, golsContraVisitante);
			setParametros().setInt(6, object.getId());	
			setParametros().setInt(7, id_timevisitante);			
			executarUpdate();
		}
		return 1;
	}	
}
