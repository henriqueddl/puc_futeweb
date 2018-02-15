package br.com.futeweb.aplicacao.interfaces.usuario.entidade;

import java.io.Serializable;
import java.util.Date;

import br.com.futeweb.aplicacao.interfaces.endereco.entidade.Endereco;

public class PessoaFisica implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;
	private String nome;
	private String email;
	private String cpf;
	private Date dataNascimento;
	private Usuario usuario = new Usuario();
	private Endereco endereco = new Endereco();
	
	public PessoaFisica(){}
	
	public PessoaFisica(int id, String nome, String email, String cpf, Date dataNascimento, Usuario usuario,
			Endereco endereco) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.usuario = usuario;
		this.endereco = endereco;
	}
	
	public boolean validarObjeto(PessoaFisica obj){
		return (obj!=null
				&& obj.getNome()!=null && !"".equals(obj.getNome())
				&& obj.getEmail()!=null && !"".equals(obj.getEmail())
				&& obj.getCpf()!=null && !"".equals(obj.getCpf())
				&& obj.getDataNascimento()!=null && !"".equals(obj.getDataNascimento())
				&& obj.getUsuario()!=null
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
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	
	
	
}
