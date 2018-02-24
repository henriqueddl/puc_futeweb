package br.com.futeweb.aplicacao.admin;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.com.futeweb.aplicacao.interfaces.estabelecimento.controle.IControleEstabelecimento;
import br.com.futeweb.aplicacao.interfaces.material.controle.IControleMaterial;
import br.com.futeweb.aplicacao.interfaces.quadra.controle.IControleQuadra;
import br.com.futeweb.aplicacao.interfaces.reserva.controle.IControleReserva;
import br.com.futeweb.aplicacao.interfaces.usuario.controle.IControleUsuario;

import br.com.futeweb.aplicacao.interfaces.jogo.controle.IControleJogo;
import br.com.futeweb.aplicacao.interfaces.time.controle.IControleTime;
import br.com.futeweb.aplicacao.interfaces.campeonato.controle.IControleCampeonato;
import br.com.futeweb.aplicacao.interfaces.classificacao.controle.IControleClassificacao;
import br.com.futeweb.aplicacao.interfaces.jogadorestime.controle.IControleJogadoresTime;
import br.com.futeweb.aplicacao.interfaces.timescampeonato.controle.IControleTimesCampeonato;

@Stateless
public class FacadeAdmin {
	
	
	@EJB(beanName="ControleEstabelecimento")
	private IControleEstabelecimento controleEstabelecimento;
	
	@EJB(beanName="ControleMaterial")
	private IControleMaterial controleMaterial;
	
	@EJB(beanName="ControleQuadra")
	private IControleQuadra controleQuadra;
	
	@EJB(beanName="ControleReserva")
	private IControleReserva controleReserva;
	
	@EJB(beanName="ControleUsuario")
	
	private IControleUsuario controleUsuario;

	@EJB(beanName="ControleJogo")
	private IControleJogo controleJogo;
	
	@EJB(beanName="ControleTime")
	private IControleTime controleTime;
	
	@EJB(beanName="ControleJogadoresTime")
	private IControleJogadoresTime controleJogadoresTime;	
	
	@EJB(beanName="ControleCampeonato")
	private IControleCampeonato controleCampeonato;

	@EJB(beanName="ControleTimesCampeonato")
	private IControleTimesCampeonato controleTimesCampeonato;	
	
	@EJB(beanName="ControleClassificacao")
	private IControleClassificacao controleClassificacao;		


	public IControleEstabelecimento getControleEstabelecimento() {
		return controleEstabelecimento;
	}

	public IControleMaterial getControleMaterial() {
		return controleMaterial;
	}

	public IControleQuadra getControleQuadra() {
		return controleQuadra;
	}

	public IControleReserva getControleReserva() {
		return controleReserva;
	}

	public IControleUsuario getControleUsuario() {
		return controleUsuario;
	}
	
	
	public IControleTime getControleTime() {
		return controleTime;
	}
	
	public IControleJogadoresTime getControleJogadoresTime() {
		return controleJogadoresTime;
	}	

	public IControleJogo getControleJogo() {
		return controleJogo;
	}

	public IControleCampeonato getControleCampeonato() {
		return controleCampeonato;
	}

	
	public IControleTimesCampeonato getControleTimesCampeonato() {
		return controleTimesCampeonato;
	}
	
	public IControleClassificacao getControleClassificacao() {
		return controleClassificacao;
	}
}
