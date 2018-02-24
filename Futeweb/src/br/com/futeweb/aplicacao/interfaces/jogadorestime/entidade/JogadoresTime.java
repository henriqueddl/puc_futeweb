package br.com.futeweb.aplicacao.interfaces.jogadorestime.entidade;

import java.io.Serializable;
import br.com.futeweb.aplicacao.interfaces.usuario.entidade.Usuario;
import java.util.HashMap;
import java.util.Map;

public class JogadoresTime implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int idtime;
	private int idjogador;
	private Map<Integer, String> jogadores;
    private Map<Integer ,String> times;
	
	
	public JogadoresTime(){}
        
    public JogadoresTime(int idtime, int idcampeonato) {
		super();
		this.idtime = idtime;
		this.idjogador = idjogador;
	}
	
	public boolean validarObjeto(JogadoresTime obj){
		return (obj!=null
				&& obj.getIdtime()!=0)
				 ? true : false;
	}
	
	
	public int getIdtime() {
		return idtime;
	}
	public void setIdtime(int idtime) {
		this.idtime = idtime;
	}

	public int getIdjogador() {
		return idjogador;
	}
	public void setIdjogador(int idjogador) {
		this.idjogador = idjogador;
	}

    public Map<Integer, String> getJogadores() {
        return jogadores;
    }
 
    public Map<Integer, String> getTimes() {
        return times;
    }	
    
    public void setJogadores(Map<Integer, String> jogadores) {
        this.jogadores = jogadores;
    }
 
    public void setTimes(Map<Integer, String> times) {
        this.times = times;
    }	
       
    	
}
