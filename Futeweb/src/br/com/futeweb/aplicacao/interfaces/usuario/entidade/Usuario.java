package br.com.futeweb.aplicacao.interfaces.usuario.entidade;

import java.io.Serializable;

public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int id;
	private String login;
	private String senha;
	private String confirmaSenha;
	private boolean ativo;
	
	public Usuario(){}
	
	public Usuario(int id, String login, String senha, boolean ativo) {
		super();
		this.id = id;
		this.login = login;
		this.senha = senha;
		this.ativo = ativo;
	}
	
	public boolean validarObjeto(Usuario obj){
		return (obj!=null
				&& obj.getLogin()!=null && !"".equals(obj.getLogin())
				&& obj.getSenha()!=null && !"".equals(obj.getSenha())
				) ? true : false;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public String getConfirmaSenha() {
		return confirmaSenha;
	}

	public void setConfirmaSenha(String confirmaSenha) {
		this.confirmaSenha = confirmaSenha;
	}
}
