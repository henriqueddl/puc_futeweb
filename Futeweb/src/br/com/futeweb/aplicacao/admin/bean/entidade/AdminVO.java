package br.com.futeweb.aplicacao.admin.bean.entidade;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.com.futeweb.aplicacao.interfaces.campeonato.entidade.Campeonato;
import br.com.futeweb.aplicacao.interfaces.classificacao.entidade.Classificacao;
import br.com.futeweb.aplicacao.interfaces.endereco.entidade.Endereco;
import br.com.futeweb.aplicacao.interfaces.estabelecimento.entidade.Estabelecimento;
import br.com.futeweb.aplicacao.interfaces.jogadorestime.entidade.JogadoresTime;
import br.com.futeweb.aplicacao.interfaces.jogo.entidade.Jogo;
import br.com.futeweb.aplicacao.interfaces.material.entidade.Material;
import br.com.futeweb.aplicacao.interfaces.quadra.entidade.Quadra;
import br.com.futeweb.aplicacao.interfaces.reserva.entidade.Reserva;
import br.com.futeweb.aplicacao.interfaces.time.entidade.Time;
import br.com.futeweb.aplicacao.interfaces.timescampeonato.entidade.TimesCampeonato;
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

	protected Quadra quadra = new Quadra();
	protected Material material = new Material();
	protected Reserva reserva = new Reserva();

	protected Time time = new Time();
	protected Jogo jogo = new Jogo();

	protected Campeonato campeonato = new Campeonato();
	protected Classificacao classificacao = new Classificacao();
	
	protected List<Estabelecimento> listEstabelecimento = new ArrayList<Estabelecimento>();
	protected List<Material> listMaterial = new ArrayList<Material>();
	protected List<Quadra> listQuadra = new ArrayList<Quadra>();
	protected List<Reserva> listReserva = new ArrayList<Reserva>();
	protected List<Usuario> listUsuario = new ArrayList<Usuario>();
	protected List<PessoaFisica> listPessoaFisica = new ArrayList<PessoaFisica>();
	protected List<PessoaJuridica> listPessoaJuridica = new ArrayList<PessoaJuridica>();

	protected TimesCampeonato timescampeonato = new TimesCampeonato();
	protected JogadoresTime jogadorestime = new JogadoresTime();
	
	public List<Estabelecimento> getListEstabelecimento() {
		return listEstabelecimento;
	}

	public void setListEstabelecimento(List<Estabelecimento> listEstabelecimento) {
		this.listEstabelecimento = listEstabelecimento;
	}

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
	
	
	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}

	
	public TimesCampeonato getTimesCampeonato() {
		return timescampeonato;
	}

	public void setTimesCampeonato(TimesCampeonato timescampeonato) {
		this.timescampeonato = timescampeonato;
	}
	
	public JogadoresTime getJogadoresTime() {
		return jogadorestime;
	}

	public void setJogadoresTime(JogadoresTime jogadorestime) {
		this.jogadorestime = jogadorestime;
	}	

	
	public Jogo getJogo() {
		return jogo;
	}

	public void setJogo(Jogo jogo) {
		this.jogo = jogo;
	}	
	
	public Campeonato getCampeonato() {
		return campeonato;
	}

	public void setCampeonato(Campeonato campeonato) {
		this.campeonato = campeonato;
	}
	
	public Classificacao getClassificacao() {
		return classificacao;
	}

	public void setClassificacao(Classificacao classificacao) {
		this.classificacao = classificacao;
	}
	
	

	public boolean isLogado() {
		return logado;
	}

	public void setLogado(boolean logado) {
		this.logado = logado;
	}

	public Quadra getQuadra() {
		return quadra;
	}

	public void setQuadra(Quadra quadra) {
		this.quadra = quadra;
	}

	public Reserva getReserva() {
		return reserva;
	}

	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
	}

	public List<Material> getListMaterial() {
		return listMaterial;
	}

	public void setListMaterial(List<Material> listMaterial) {
		this.listMaterial = listMaterial;
	}

	public List<Quadra> getListQuadra() {
		return listQuadra;
	}

	public void setListQuadra(List<Quadra> listQuadra) {
		this.listQuadra = listQuadra;
	}

	public List<Reserva> getListReserva() {
		return listReserva;
	}

	public void setListReserva(List<Reserva> listReserva) {
		this.listReserva = listReserva;
	}

	public List<Usuario> getListUsuario() {
		return listUsuario;
	}

	public void setListUsuario(List<Usuario> listUsuario) {
		this.listUsuario = listUsuario;
	}

	public List<PessoaFisica> getListPessoaFisica() {
		return listPessoaFisica;
	}

	public void setListPessoaFisica(List<PessoaFisica> listPessoaFisica) {
		this.listPessoaFisica = listPessoaFisica;
	}

	public List<PessoaJuridica> getListPessoaJuridica() {
		return listPessoaJuridica;
	}

	public void setListPessoaJuridica(List<PessoaJuridica> listPessoaJuridica) {
		this.listPessoaJuridica = listPessoaJuridica;
	}	
}
