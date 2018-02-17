package br.com.futeweb.aplicacao.interfaces.usuario.entidade;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.com.futeweb.aplicacao.interfaces.estabelecimento.entidade.Estabelecimento;

public class PessoaJuridica implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;
	private String nome;
	private String email;
	private String cnpj;
	private Usuario usuario = new Usuario();
	private List<Estabelecimento> listEstabelecimento = new ArrayList<Estabelecimento>();
	
	public PessoaJuridica(){}
	
	public PessoaJuridica(int id, String nome, String email, String cnpj, Usuario usuario) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.cnpj = cnpj;
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return "PessoaJuridica [id=" + id + ", nome=" + nome + ", email=" + email + ", cnpj=" + cnpj + ", usuario="
				+ usuario + ", listEstabelecimento=" + listEstabelecimento + "]";
	}

	public boolean validarObjeto(PessoaJuridica obj){
		return (obj!=null
				&& obj.getNome()!=null && !"".equals(obj.getNome())
				&& obj.getEmail()!=null && !"".equals(obj.getEmail())
				&& obj.getCnpj()!=null && !"".equals(obj.getCnpj())
				&& obj.getUsuario()!=null
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public List<Estabelecimento> getListEstabelecimento() {
		return listEstabelecimento;
	}
	public void setListEstabelecimento(List<Estabelecimento> listEstabelecimento) {
		this.listEstabelecimento = listEstabelecimento;
	}
}
