package br.com.futeweb.aplicacao.admin.bean.entidade;

import java.io.Serializable;

import br.com.futeweb.aplicacao.interfaces.endereco.entidade.Endereco;
import br.com.futeweb.aplicacao.interfaces.estabelecimento.entidade.Estabelecimento;
import br.com.futeweb.aplicacao.interfaces.material.entidade.Material;
import br.com.futeweb.aplicacao.interfaces.quadra.entidade.Quadra;
import br.com.futeweb.aplicacao.interfaces.usuario.entidade.PessoaFisica;
import br.com.futeweb.aplicacao.interfaces.usuario.entidade.PessoaJuridica;
import br.com.futeweb.aplicacao.interfaces.usuario.entidade.Usuario;

public class AdminVO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	protected boolean logado = true;

	protected Endereco endereco = new Endereco();
	protected Usuario usuario = new Usuario();
	protected PessoaFisica pessoaFisica = new PessoaFisica();
	protected PessoaJuridica pessoaJuridica = new PessoaJuridica();
	protected Estabelecimento estabelecimento = new Estabelecimento();

	protected PessoaFisica autenticadoPF = new PessoaFisica();
	protected PessoaJuridica autenticadoPJ = new PessoaJuridica();

	protected Quadra quabdra = new Quadra();
	protected Material material = new Material();

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public PessoaFisica getPessoaFisica() {
		return pessoaFisica;
	}

	public void setPessoaFisica(PessoaFisica pessoaFisica) {
		this.pessoaFisica = pessoaFisica;
	}

	public PessoaJuridica getPessoaJuridica() {
		return pessoaJuridica;
	}

	public void setPessoaJuridica(PessoaJuridica pessoaJuridica) {
		this.pessoaJuridica = pessoaJuridica;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public PessoaFisica getAutenticadoPF() {
		return autenticadoPF;
	}

	public void setAutenticadoPF(PessoaFisica autenticadoPF) {
		this.autenticadoPF = autenticadoPF;
	}

	public PessoaJuridica getAutenticadoPJ() {
		return autenticadoPJ;
	}

	public void setAutenticadoPJ(PessoaJuridica autenticadoPJ) {
		this.autenticadoPJ = autenticadoPJ;
	}

	public Quadra getQuabdra() {
		return quabdra;
	}

	public void setQuabdra(Quadra quabdra) {
		this.quabdra = quabdra;
	}

	public Material getMaterial() {
		return material;
	}

	public void setMaterial(Material material) {
		this.material = material;
	}

	public Estabelecimento getEstabelecimento() {
		return estabelecimento;
	}

	public void setEstabelecimento(Estabelecimento estabelecimento) {
		this.estabelecimento = estabelecimento;
	}

	public boolean isLogado() {
		return logado;
	}

	public void setLogado(boolean logado) {
		this.logado = logado;
	}

}
