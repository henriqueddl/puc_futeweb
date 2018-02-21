package br.com.futeweb.aplicacao.interfaces.material.entidade;

import java.io.Serializable;
import java.util.List;

import br.com.futeweb.aplicacao.interfaces.master.entidade.Disponibilidade;

public class Material implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int id;
	private int id_estabelecimento;
	private String nome;
	private String descricao;
	private List<Disponibilidade> listDisponibilidade;
	
        public Material(){}
        
	public Material(int id, String nome, String descricao) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
	}
	
	public boolean validarObjeto(Material obj){
		return (obj!=null
				&& obj.getNome()!=null && !"".equals(obj.getNome())
				&& obj.getDescricao()!=null && !"".equals(obj.getDescricao())
				) ? true : false;
	}

	@Override
	public String toString() {
		return "Material [id=" + id + ", nome=" + nome + ", descricao=" + descricao + ", listDisponibilidade="
				+ listDisponibilidade + "]";
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
	public List<Disponibilidade> getListDisponibilidade() {
		return listDisponibilidade;
	}
	public void setListDisponibilidade(List<Disponibilidade> listDisponibilidade) {
		this.listDisponibilidade = listDisponibilidade;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getId_estabelecimento() {
		return id_estabelecimento;
	}

	public void setId_estabelecimento(int id_estabelecimento) {
		this.id_estabelecimento = id_estabelecimento;
	}
	
}
