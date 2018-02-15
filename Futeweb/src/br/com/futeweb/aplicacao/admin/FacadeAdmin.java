package br.com.futeweb.aplicacao.admin;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.com.futeweb.aplicacao.interfaces.endereco.controle.IControleEndereco;
import br.com.futeweb.aplicacao.interfaces.estabelecimento.controle.IControleEstabelecimento;
import br.com.futeweb.aplicacao.interfaces.material.controle.IControleMaterial;
import br.com.futeweb.aplicacao.interfaces.quadra.controle.IControleQuadra;
import br.com.futeweb.aplicacao.interfaces.reserva.controle.IControleReserva;
import br.com.futeweb.aplicacao.interfaces.usuario.controle.IControleUsuario;

@Stateless
public class FacadeAdmin {
	
	@EJB(beanName="ControleEndereco")
	private IControleEndereco controleEndereco;
	
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

	public IControleEndereco getControleEndereco() {
		return controleEndereco;
	}

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
}
