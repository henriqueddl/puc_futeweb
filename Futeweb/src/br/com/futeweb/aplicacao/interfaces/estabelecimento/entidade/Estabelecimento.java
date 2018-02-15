package br.com.futeweb.aplicacao.interfaces.estabelecimento.entidade;

import java.io.Serializable;

import br.com.futeweb.aplicacao.interfaces.endereco.entidade.Endereco;

public class Estabelecimento implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int id;
	private String nome;
	private String descricao;
	private Endereco endereco;
//	private List<PessoaJuridica> listPessoaJuridica;
//	private List<Quadra> listQuadra;
//	private List<Material> listMaterial;
	
	public Estabelecimento(){}
        
	public Estabelecimento(int id, String nome, String descricao, Endereco endereco) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.endereco = endereco;
	}
	
	public boolean validarObjeto(Estabelecimento obj){
		return (obj!=null
				&& obj.getNome()!=null && !"".equals(obj.getNome())
				&& obj.getDescricao()!=null && !"".equals(obj.getDescricao())
				&& obj.getEndereco()!=null
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


	public Endereco getEndereco() {
		return endereco;
	}


	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	

}
