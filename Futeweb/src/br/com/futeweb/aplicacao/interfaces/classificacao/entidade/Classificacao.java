package br.com.futeweb.aplicacao.interfaces.classificacao.entidade;

import java.io.Serializable;

import br.com.futeweb.aplicacao.interfaces.classificacao.entidade.Classificacao;

public class Classificacao implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int id;
	private int IdCampeonato;
	private int IdTime;
	private int jogos;
	private int vitorias;
	private int golsPro;
	private int golsContra;	
	
	public Classificacao(){}
        
	public Classificacao(int id, int IdCampeonato,int IdTime,int jogos, int Vitorias,int golsPro, int golsContra) {
		super();
		this.id = id;
		this.IdCampeonato = IdCampeonato;
		this.jogos = jogos;
		this.IdTime = IdTime;
		this.vitorias = Vitorias;
		this.golsPro = golsPro;
		this.golsContra = golsContra;	
	}
	
	public boolean validarObjeto(Classificacao obj){
		return (obj!=null
				&& obj.getId()!=0 && !"".equals(obj.getId())
				&& obj.getIdCampeonato()!=0
				) ? true : false;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public int getIdCampeonato() {
		return IdCampeonato;
	}
	
	public void setIdCampeonato(int idCampeonato) {
		this.IdCampeonato = idCampeonato;
	}

	public int getIdTime() {
		return IdTime;
	}
	public void setIdTime(int idTime) {
		this.IdTime = idTime;
	}	
	
	public int getjogos() {
		return jogos;
	}
	public void setjogos(int jogos) {
		this.jogos = jogos;
	}
	
	public int getvitorias() {
		return vitorias;
	}
	public void setvitorias(int vitorias) {
		this.vitorias = vitorias;
	}
	
	public int getgolsPro() {
		return golsPro;
	}
	public void setgolsPro(int golsPro) {
		this.golsPro = golsPro;
	}		

	public int getgolsContra() {
		return golsContra;
	}
	public void setgolsContra(int golsContra) {
		this.golsContra = golsContra;
	}	
}
