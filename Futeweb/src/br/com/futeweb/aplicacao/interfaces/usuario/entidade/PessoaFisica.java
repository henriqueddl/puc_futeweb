package br.com.futeweb.aplicacao.interfaces.usuario.entidade;

import java.io.Serializable;
import java.util.Date;

public class PessoaFisica implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;
	private String nome;
	private String email;
	private String cpf;
	private Date dataNascimento;
	private Usuario usuario = new Usuario();
	
	public PessoaFisica(){}
	
	public PessoaFisica(int id, String nome, String email, String cpf, Date dataNascimento, Usuario usuario) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.usuario = usuario;
	}
	
	public boolean validarObjeto(PessoaFisica obj){
		return (obj!=null
				&& obj.getNome()!=null && !"".equals(obj.getNome())
				&& obj.getEmail()!=null && !"".equals(obj.getEmail())
				&& obj.getCpf()!=null && !"".equals(obj.getCpf())
				&& obj.getDataNascimento()!=null && !"".equals(obj.getDataNascimento())
				&& obj.getUsuario()!=null
				) ? true : false;
	}
	
	@Override
	public String toString() {
		return "PessoaFisica [id=" + id + ", nome=" + nome + ", email=" + email + ", cpf=" + cpf + ", dataNascimento="
				+ dataNascimento + ", usuario=" + usuario + "]";
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
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
