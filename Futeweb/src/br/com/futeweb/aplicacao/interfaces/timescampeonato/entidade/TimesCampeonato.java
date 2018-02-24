package br.com.futeweb.aplicacao.interfaces.timescampeonato.entidade;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import br.com.futeweb.aplicacao.interfaces.usuario.entidade.Usuario;

public class TimesCampeonato implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int idcampeonato;
	private int idtime;
	private Map<Integer, String> times;
    private Map<Integer ,String> campeonatos;

	public TimesCampeonato(){}
        
    public TimesCampeonato(int idcampeonato,int idtime) {
		super();
		this.idcampeonato = idcampeonato;
		this.idtime = idtime;
	}
	
	public boolean validarObjeto(TimesCampeonato obj){
		return (obj!=null
				&& obj.getIdcampeonato()!=0)
				 ? true : false;
	}
	
	
	public int getIdcampeonato() {
		return idcampeonato;
	}
	public void setId(int idcampeonato) {
		this.idcampeonato = idcampeonato;
	}
	public int getIdtime() {
		return idtime;
	}
	public void setIdtime(int idtime) {
		this.idtime = idtime;
	}

    public Map<Integer, String> getCampeonatos() {
        return campeonatos;
    }
 
    public Map<Integer, String> getTimes() {
        return times;
    }	
    
    public void setCampeonatos(Map<Integer, String> campeonatos) {
        this.campeonatos = campeonatos;
    }
 
    public void setTimes(Map<Integer, String> times) {
        this.times = times;
    }	
       
	
}
