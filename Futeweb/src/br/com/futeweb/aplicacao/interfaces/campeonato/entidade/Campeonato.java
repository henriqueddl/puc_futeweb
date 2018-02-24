package br.com.futeweb.aplicacao.interfaces.campeonato.entidade;

import java.io.Serializable;
import java.util.Date;


public class Campeonato implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int id;
	private String nome;
	private Date dataInicio;
	private Date dataFim;
	private int id_estabelecimento;
	
	public Campeonato(){}
	
	public Campeonato(int id, String nome, Date datainicio, Date datafim, int id_estabelecimento) {
		super();
		this.id = id;
		this.nome = nome;
		this.dataInicio = datainicio;
		this.dataFim = datafim;
		this.id_estabelecimento = id_estabelecimento;
	}
	

	public boolean validarObjeto(Campeonato obj){
		return (obj!=null
				&& obj.getNome()!=null && !"".equals(obj.getNome())
				&& obj.getid_estabelecimento()!=0
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
	public int getid_estabelecimento() {
		return id_estabelecimento;
	}
	public void setid_estabelecimento(int id_estabelecimento) {
		this.id_estabelecimento = id_estabelecimento;
	}

	public Date getDataInicio() {
		return dataInicio;
	}
	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}
	public Date getDataFim() {
		return dataFim;
	}
	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}	
	
	
}
