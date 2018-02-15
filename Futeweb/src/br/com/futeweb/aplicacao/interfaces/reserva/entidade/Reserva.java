package br.com.futeweb.aplicacao.interfaces.reserva.entidade;

import java.io.Serializable;

import br.com.futeweb.aplicacao.interfaces.master.entidade.Disponibilidade;
import br.com.futeweb.aplicacao.interfaces.usuario.entidade.PessoaFisica;

public class Reserva implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int id;
	private Disponibilidade disponibilidadeQuadra;
	private Disponibilidade disponibilidadeMaterial;
	private PessoaFisica pessoaFisica;
	
	public Reserva(int id, Disponibilidade disponibilidadeQuadra, Disponibilidade disponibilidadeMaterial,
			PessoaFisica pessoaFisica) {
		super();
		this.id = id;
		this.disponibilidadeQuadra = disponibilidadeQuadra;
		this.disponibilidadeMaterial = disponibilidadeMaterial;
		this.pessoaFisica = pessoaFisica;
	}
	
	public boolean validarObjeto(Reserva obj){
		return (obj!=null
				&& obj.getDisponibilidadeQuadra()!=null
				&& obj.getDisponibilidadeMaterial()!=null
				&& obj.getPessoaFisica()!=null
				) ? true : false;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Disponibilidade getDisponibilidadeQuadra() {
		return disponibilidadeQuadra;
	}
	public void setDisponibilidadeQuadra(Disponibilidade disponibilidadeQuadra) {
		this.disponibilidadeQuadra = disponibilidadeQuadra;
	}
	public Disponibilidade getDisponibilidadeMaterial() {
		return disponibilidadeMaterial;
	}
	public void setDisponibilidadeMaterial(Disponibilidade disponibilidadeMaterial) {
		this.disponibilidadeMaterial = disponibilidadeMaterial;
	}
	public PessoaFisica getPessoaFisica() {
		return pessoaFisica;
	}
	public void setPessoaFisica(PessoaFisica pessoaFisica) {
		this.pessoaFisica = pessoaFisica;
	}
	
	
}
