package br.com.futeweb.aplicacao.interfaces.estabelecimento.entidade;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.com.futeweb.aplicacao.interfaces.endereco.entidade.Endereco;
import br.com.futeweb.aplicacao.interfaces.material.entidade.Material;
import br.com.futeweb.aplicacao.interfaces.quadra.entidade.Quadra;
import br.com.futeweb.aplicacao.interfaces.usuario.entidade.PessoaJuridica;

public class Estabelecimento implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int id;
	private String nome;
	private String descricao;
	private Endereco endereco = new Endereco();
	private List<PessoaJuridica> listPessoaJuridica = new ArrayList<PessoaJuridica>();
	private List<Quadra> listQuadra = new ArrayList<Quadra>();
	private List<Material> listMaterial = new ArrayList<Material>();
	
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
	
	@Override
	public String toString() {
		return "Estabelecimento [id=" + id + ", nome=" + nome + ", descricao=" + descricao + ", endereco=" + endereco
				+ ", listPessoaJuridica=" + listPessoaJuridica + "]";
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

	public List<PessoaJuridica> getListPessoaJuridica() {
		return listPessoaJuridica;
	}

	public void setListPessoaJuridica(List<PessoaJuridica> listPessoaJuridica) {
		this.listPessoaJuridica = listPessoaJuridica;
	}

	public List<Quadra> getListQuadra() {
		return listQuadra;
	}

	public void setListQuadra(List<Quadra> listQuadra) {
		this.listQuadra = listQuadra;
	}

	public List<Material> getListMaterial() {
		return listMaterial;
	}

	public void setListMaterial(List<Material> listMaterial) {
		this.listMaterial = listMaterial;
	}
	
	

}
