package br.com.futeweb.aplicacao.interfaces.time.entidade;

import java.io.Serializable;

public class Time implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int id;
	private String nome;
	
	public Time(){}
        
    public Time(int id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}
	
	public boolean validarObjeto(Time obj){
		return (obj!=null
				&& obj.getNome()!=null && !"".equals(obj.getNome())
				) ? true : false;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	
	
}
