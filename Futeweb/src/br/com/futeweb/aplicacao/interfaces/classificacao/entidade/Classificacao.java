package br.com.futeweb.aplicacao.interfaces.classificacao.entidade;

import java.io.Serializable;

import br.com.futeweb.aplicacao.interfaces.classificacao.entidade.Classificacao;

public class Classificacao implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int id;
	private int Id_Campeonato;
	private int Id_Time;
	private int vitorias;
	private int golsPro;
	private int golsContra;	
        
	public Classificacao(int id, int Id_Campeonato,int Id_Time, int Vitorias,int golsPro, int golsContra) {
		super();
		this.id = id;
		this.Id_Campeonato = Id_Campeonato;
		this.Id_Time = Id_Time;
		this.vitorias = Vitorias;
		this.golsPro = golsPro;
		this.golsContra = golsContra;	
	}
	
	public boolean validarObjeto(Classificacao obj){
		return (obj!=null
				&& obj.getId()!=0 && !"".equals(obj.getId())
				&& obj.getId_Campeonato()!=0
				) ? true : false;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public int getId_Campeonato() {
		return Id_Campeonato;
	}
	public void setId_Campeonato(int id_Campeonato) {
		this.Id_Campeonato = id_Campeonato;
	}

	public int getId_Time() {
		return Id_Time;
	}
	public void setId_Time(int id_Time) {
		this.Id_Time = id_Time;
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
