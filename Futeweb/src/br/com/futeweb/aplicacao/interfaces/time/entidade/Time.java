package br.com.futeweb.aplicacao.interfaces.time.entidade;

import java.io.Serializable;
import br.com.futeweb.aplicacao.interfaces.usuario.entidade.Usuario;

public class Time implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int id;
	private String nome;
	private String descricao;
	
	public Time(){}
        
    public Time(int id, String nome,String descricao) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
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

	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	
	
}
