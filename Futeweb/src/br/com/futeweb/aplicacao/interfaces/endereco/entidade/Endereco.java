package br.com.futeweb.aplicacao.interfaces.endereco.entidade;

import java.io.Serializable;

public class Endereco implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String logradouro;
	private int numero;
	private String cidade;
	private String estado;
	private String cep;
	
	public Endereco(){}
	
	public Endereco( String logradouro, int numero, String cidade, String estado, String cep) {
		super();
		this.logradouro = logradouro;
		this.numero = numero;
		this.cidade = cidade;
		this.estado = estado;
		this.cep = cep;
	}
	
	public boolean validarObjeto(Endereco obj){
		return (obj!=null
				&& obj.getLogradouro()!=null && !"".equals(obj.getLogradouro())
				&& obj.getNumero()!=0
				&& obj.getCidade()!=null && !"".equals(obj.getCidade())
				&& obj.getEstado()!=null && !"".equals(obj.getEstado())
				&& obj.getCep()!=null && !"".equals(obj.getCep())
				) ? true : false;
	}
	
	@Override
	public String toString() {
		return "Endereco [logradouro=" + logradouro + ", numero=" + numero + ", cidade=" + cidade
				+ ", estado=" + estado + ", cep=" + cep + "]";
	}

	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
}
