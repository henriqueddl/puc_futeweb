package br.com.futeweb.aplicacao.interfaces.jogo.entidade;

import java.io.Serializable;


public class Jogo implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int id;
	private int id_quadra;
	private int id_timemandante;
	private int id_timevisitante;
	private int gols_timemandante;
	private int gols_timevisitante;
	private int id_campeonato;
        
	public Jogo(){}
	
	public Jogo(int id, int id_quadra, int id_timemandante,int id_timevisitante,int gols_timemandante, int gols_timevisitante, int id_campeonato) {
		super();
		this.id = id;
		this.id_quadra = id_quadra;
		this.id_timemandante = id_timemandante;
		this.id_timevisitante = id_timevisitante;
		this.gols_timemandante = gols_timemandante;
		this.gols_timevisitante = gols_timevisitante;
		this.id_campeonato = id_campeonato;
	}
	


	public boolean validarObjeto(Jogo obj){
		return (obj!=null
				&&  !"".equals(obj.getId())
				) ? true : false;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getid_quadra() {
		return id_quadra;
	}
	public void setid_quadra(int id) {
		this.id_quadra = id;
	}
	
	
	public int getid_timemandante() {
		return id_timemandante;
	}
	public void setid_timemandante(int id) {
		this.id_timevisitante = id;
	}

	
	
	public int getid_timevisitante() {
		return id_timevisitante;
	}
	public void setid_timevisitante(int Id) {
		this.id_timevisitante = id;
	}	
	

	public int getgols_timemandante() {
		return gols_timemandante;
	}
	public void setgols_timemandante(int id) {
		this.gols_timevisitante = id;
	}
	
	public int getgols_timevisitante() {
		return gols_timevisitante;
	}
	public void setgols_timevisitante(int Id) {
		this.gols_timevisitante = id;
	}		
	
	
	public int getid_campeonato() {
		return id_campeonato;
	}
	public void setid_campeonato(int Id) {
		this.id_campeonato = id;
	}	
}
