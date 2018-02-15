package br.com.futeweb.aplicacao.interfaces.usuario.entidade;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.futeweb.aplicacao.interfaces.estabelecimento.entidade.Estabelecimento;

public class PessoaJuridica implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;
	private String nome;
	private String email;
	private String cnpj;
	private Date dataNascimento;
	private Usuario usuario = new Usuario();
	private List<Estabelecimento> listEstabelecimento = new ArrayList<Estabelecimento>();
	
	public PessoaJuridica(){}
	
	public PessoaJuridica(int id, String nome, String email, String cnpj, Date dataNascimento, Usuario usuario) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.cnpj = cnpj;
		this.dataNascimento = dataNascimento;
		this.usuario = usuario;
	}

	public boolean validarObjeto(PessoaJuridica obj){
		return (obj!=null
				&& obj.getNome()!=null && !"".equals(obj.getNome())
				&& obj.getEmail()!=null && !"".equals(obj.getEmail())
				&& obj.getCnpj()!=null && !"".equals(obj.getCnpj())
				&& obj.getDataNascimento()!=null && !"".equals(obj.getDataNascimento())
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

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
}
