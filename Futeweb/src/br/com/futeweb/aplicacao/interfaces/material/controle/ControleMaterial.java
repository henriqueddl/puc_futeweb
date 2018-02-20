package br.com.futeweb.aplicacao.interfaces.material.controle;

import java.sql.SQLException;
import java.util.List;

import javax.ejb.Stateless;
import javax.faces.application.FacesMessage;

import br.com.futeweb.aplicacao.dao.generico.GenericoDAO;
import br.com.futeweb.aplicacao.interfaces.estabelecimento.entidade.Estabelecimento;
import br.com.futeweb.aplicacao.interfaces.master.entidade.Disponibilidade;
import br.com.futeweb.aplicacao.interfaces.material.dao.MaterialDAO;
import br.com.futeweb.aplicacao.interfaces.material.entidade.Material;
import br.com.futeweb.aplicacao.utils.Logger;
import br.com.futeweb.aplicacao.utils.Mensagens;

@Stateless
public class ControleMaterial extends GenericoDAO implements IControleMaterial {

	private static final long serialVersionUID = 1L;
	private MaterialDAO dao;
	
	private MaterialDAO getInstance(){
		if (dao==null){
			dao = new MaterialDAO();
		}
		return dao;
	}
	
	@Deprecated
	@Override
	public int inserir(Material object) throws SQLException {
		return dao.inserir(object);
	}
	
	@Override
	public int inserir(Material material, int idEstabelecimento) throws SQLException {
		int retorno = 0;
		if (material.validarObjeto(material) && idEstabelecimento != 0){
			retorno = getInstance().inserir(material, idEstabelecimento);
			if (retorno!=0){
				new Logger(true, FacesMessage.SEVERITY_INFO, Mensagens.OK_MATERIAL_INSERIR, Mensagens.ID_CAMPO_MENSAGEM_INDEX);
			}else{
				new Logger(true, FacesMessage.SEVERITY_ERROR, Mensagens.ERRO_MATERIAL_INSERIR_0, Mensagens.ID_CAMPO_MENSAGEM_INDEX);
			}
		}else{
			new Logger(true, FacesMessage.SEVERITY_ERROR, Mensagens.ERRO_PREENCHIMENTO, Mensagens.ID_CAMPO_MENSAGEM_INDEX);
		}
		return retorno;
	}

	@Deprecated
	@Override
	public List<Material> obterTodos() {
		return dao.obterTodos();
	}
	
	@Deprecated
	@Override
	public List<Material> obterPorCriterio(Material object) throws SQLException {
		return dao.obterPorCriterio(object);
	}

	@Override
	public List<Material> obterMaterial(Estabelecimento estabelecimento) throws SQLException {
		List<Material> lista = getInstance().obterMaterial(estabelecimento);
		if (lista==null || lista.size()==0){
			new Logger(true, FacesMessage.SEVERITY_ERROR, Mensagens.ERRO_MATERIAL_CONSULTAR, Mensagens.ID_CAMPO_MENSAGEM_INDEX);
		}
		return lista;
	}
	
	@Override
	public int atualizar(Material object) throws SQLException {
		int retorno = 0;
		if (object.validarObjeto(object)){
			retorno = getInstance().atualizar(object);
			if (retorno!=0){
				new Logger(true, FacesMessage.SEVERITY_INFO, Mensagens.OK_MATERIAL_ATUALIZAR, Mensagens.ID_CAMPO_MENSAGEM_INDEX);
			}else{
				new Logger(true, FacesMessage.SEVERITY_ERROR, Mensagens.ERRO_MATERIAL_ATUALIZAR_0, Mensagens.ID_CAMPO_MENSAGEM_INDEX);
			}
		}else{
			new Logger(true, FacesMessage.SEVERITY_ERROR, Mensagens.ERRO_PREENCHIMENTO, Mensagens.ID_CAMPO_MENSAGEM_INDEX);
		}
		return retorno;
	}
	
	@Override
	public int inserirDisponibilidadeMaterial(Disponibilidade disponibilidade, Material material) throws SQLException {
		int retorno = 0;
		if (disponibilidade.validarObjeto(disponibilidade) && material.validarObjeto(material)){
			retorno = getInstance().inserirDisponibilidadeMaterial(disponibilidade, material);
			if (retorno!=0){
				new Logger(true, FacesMessage.SEVERITY_INFO, Mensagens.OK_MATERIAL_DISPONIBILIDADE_INSERIR, Mensagens.ID_CAMPO_MENSAGEM_INDEX);
			}else{
				new Logger(true, FacesMessage.SEVERITY_ERROR, Mensagens.ERRO_MATERIAL_DISPONIBILIDADE_INSERIR_0, Mensagens.ID_CAMPO_MENSAGEM_INDEX);
			}
		}else{
			new Logger(true, FacesMessage.SEVERITY_ERROR, Mensagens.ERRO_PREENCHIMENTO, Mensagens.ID_CAMPO_MENSAGEM_INDEX);
		}
		return retorno;
	}

	@Override
	public List<Disponibilidade> obterDisponibilidadeMaterial(Material material) throws SQLException {
		List<Disponibilidade> lista = getInstance().obterDisponibilidadeMaterial(material);
		if (lista==null || lista.size()==0){
			new Logger(true, FacesMessage.SEVERITY_ERROR, Mensagens.ERRO_MATERIAL_DISPONIBILIDADE_CONSULTAR, Mensagens.ID_CAMPO_MENSAGEM_INDEX);
		}
		return lista;
	}

	@Override
	public int removerDisponibilidadeMaterial(Disponibilidade disponibilidade) throws SQLException {
		int retorno = 0;
		if (disponibilidade.validarObjeto(disponibilidade)){
			retorno = getInstance().removerDisponibilidadeMaterial(disponibilidade);
			if (retorno!=0){
				new Logger(true, FacesMessage.SEVERITY_INFO, Mensagens.OK_MATERIAL_DISPONIBILIDADE_REMOVER, Mensagens.ID_CAMPO_MENSAGEM_INDEX);
			}else{
				new Logger(true, FacesMessage.SEVERITY_ERROR, Mensagens.ERRO_MATERIAL_DISPONIBILIDADE_REMOVER_0, Mensagens.ID_CAMPO_MENSAGEM_INDEX);
			}
		}else{
			new Logger(true, FacesMessage.SEVERITY_ERROR, Mensagens.ERRO_PREENCHIMENTO, Mensagens.ID_CAMPO_MENSAGEM_INDEX);
		}
		return retorno;
	}
}
