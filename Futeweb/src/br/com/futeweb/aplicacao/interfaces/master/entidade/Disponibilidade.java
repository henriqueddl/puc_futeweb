package br.com.futeweb.aplicacao.interfaces.master.entidade;

import java.io.Serializable;
import java.util.Date;

public class Disponibilidade implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int id;
	private Date dataInicio;
	private Date dataFim;
	
	public Disponibilidade(int id, Date dataInicio, Date dataFim) {
		super();
		this.id = id;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
