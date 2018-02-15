package br.com.futeweb.aplicacao.utils;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

import br.com.futeweb.aplicacao.interfaces.endereco.controle.IControleEndereco;
import br.com.futeweb.aplicacao.interfaces.endereco.dao.EnderecoDAO;
import br.com.futeweb.aplicacao.interfaces.endereco.entidade.Endereco;
import br.com.futeweb.aplicacao.interfaces.estabelecimento.controle.ControleEstabelecimento;
import br.com.futeweb.aplicacao.interfaces.estabelecimento.controle.IControleEstabelecimento;
import br.com.futeweb.aplicacao.interfaces.estabelecimento.entidade.Estabelecimento;
import br.com.futeweb.aplicacao.interfaces.material.controle.ControleMaterial;
import br.com.futeweb.aplicacao.interfaces.material.controle.IControleMaterial;
import br.com.futeweb.aplicacao.interfaces.material.entidade.Material;
import br.com.futeweb.aplicacao.interfaces.quadra.controle.ControleQuadra;
import br.com.futeweb.aplicacao.interfaces.quadra.controle.IControleQuadra;
import br.com.futeweb.aplicacao.interfaces.quadra.entidade.Quadra;
import br.com.futeweb.aplicacao.interfaces.reserva.controle.ControleReserva;
import br.com.futeweb.aplicacao.interfaces.reserva.controle.IControleReserva;
import br.com.futeweb.aplicacao.interfaces.reserva.entidade.Reserva;
import br.com.futeweb.aplicacao.interfaces.usuario.controle.ControleUsuario;
import br.com.futeweb.aplicacao.interfaces.usuario.controle.IControleUsuario;
import br.com.futeweb.aplicacao.interfaces.usuario.entidade.PessoaFisica;
import br.com.futeweb.aplicacao.interfaces.usuario.entidade.PessoaJuridica;
import br.com.futeweb.aplicacao.interfaces.usuario.entidade.Usuario;

public class Teste {
	
	private int acao;
	
	private Endereco endereco;
	private Estabelecimento estabelecimento;
	private Material material;
	private Quadra quadra;
	private Reserva reserva;
	private Usuario usuario;
	private PessoaFisica pessoaFisica;
	private PessoaJuridica pessoaJuridica;
	
	
	private void init(){
		
		acao = 0;
		
		endereco = new Endereco(1, "Rua Fredolin Wolf", 641, "Curitiba", "PR", "82115000");
		estabelecimento = new Estabelecimento(1, "Stark", "Aqui voce joga bola", endereco);
		material = new Material(1, "bola nike", estabelecimento);
		quadra = new Quadra(1, "Coberta 1", estabelecimento);
		usuario = new Usuario(1, "G0036216", "Sr4d2018!3", true);
		Date dataNascimento = null;
		try {
			dataNascimento = AplicacaoUtils.sdf.parse("21/09/1989 00:00:00");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		pessoaFisica = new PessoaFisica(1, "Jose Henrique Dias de Lima", "henriqueddl89@gmail.com", "04654782982", dataNascimento, usuario, endereco);
		pessoaJuridica = new PessoaJuridica(1, "Desiree Angelica Rieiro de Lima", "desiree.ribeiro@hotmail.com", "1234/0001-10", dataNascimento,  usuario);
		
	}
	
	public static void main(String[] args) throws SQLException {
		
		Teste teste = new Teste();
		teste.init();
		teste.testarEndereco();
		teste.testarEstabelecimento();
		teste.testarMaterial();
		teste.testarQuadra();
		teste.testarReserva();
		teste.testarUsuario();
		teste.testarPessoaFisica();
		teste.testarPessoaJuridica();
	}
	
	private void testarEndereco() throws SQLException{
		IControleEndereco impl = new EnderecoDAO();
		if (acao==1){
			impl.inserir(endereco);
		}else if (acao==2){
			List<Endereco> lista = impl.obterTodos();
			for (Endereco obj : lista){
				System.out.println(obj.toString());
			}
		}else if (acao==3){
			List<Endereco> lista = impl.obterPorCriterio(endereco);
			for (Endereco obj : lista){
				System.out.println(obj.toString());
			}
		}else if (acao==4){
			impl.atualizar(endereco);
		}
	}
	
	private void testarEstabelecimento() throws SQLException{
		IControleEstabelecimento impl = new ControleEstabelecimento();
		if (acao==1){
			impl.inserir(estabelecimento);
		}else if (acao==2){
			List<Estabelecimento> lista = impl.obterTodos();
			for (Estabelecimento obj : lista){
				System.out.println(obj.toString());
			}
		}else if (acao==3){
			List<Estabelecimento> lista = impl.obterPorCriterio(estabelecimento);
			for (Estabelecimento obj : lista){
				System.out.println(obj.toString());
			}
		}else if (acao==4){
			impl.atualizar(estabelecimento);
		}
	}
	
	private void testarMaterial() throws SQLException{
		IControleMaterial impl = new ControleMaterial();
		if (acao==1){
			impl.inserir(material);
		}else if (acao==2){
			List<Material> lista = impl.obterTodos();
			for (Material obj : lista){
				System.out.println(obj.toString());
			}
		}else if (acao==3){
			List<Material> lista = impl.obterPorCriterio(material);
			for (Material obj : lista){
				System.out.println(obj.toString());
			}
		}else if (acao==4){
			impl.atualizar(material);
		}
	}
	
	private void testarQuadra() throws SQLException{
		IControleQuadra impl = new ControleQuadra();
		if (acao==1){
			impl.inserir(quadra);
		}else if (acao==2){
			List<Quadra> lista = impl.obterTodos();
			for (Quadra obj : lista){
				System.out.println(obj.toString());
			}
		}else if (acao==3){
			List<Quadra> lista = impl.obterPorCriterio(quadra);
			for (Quadra obj : lista){
				System.out.println(obj.toString());
			}
		}else if (acao==4){
			impl.atualizar(quadra);
		}
	}

	private void testarReserva() throws SQLException{
		IControleReserva impl = new ControleReserva();
		if (acao==1){
			impl.inserir(reserva);
		}else if (acao==2){
			List<Reserva> lista = impl.obterTodos();
			for (Reserva obj : lista){
				System.out.println(obj.toString());
			}
		}else if (acao==3){
			List<Reserva> lista = impl.obterPorCriterio(reserva);
			for (Reserva obj : lista){
				System.out.println(obj.toString());
			}
		}else if (acao==4){
			impl.atualizar(reserva);
		}
	}
	
	private void testarUsuario() throws SQLException{
		IControleUsuario impl = new ControleUsuario();
		if (acao==1){
			impl.inserir(usuario);
		}else if (acao==2){
			List<Usuario> lista = impl.obterTodos();
			for (Usuario obj : lista){
				System.out.println(obj.toString());
			}
		}else if (acao==3){
			List<Usuario> lista = impl.obterPorCriterio(usuario);
			for (Usuario obj : lista){
				System.out.println(obj.toString());
			}
		}else if (acao==4){
			impl.atualizar(usuario);
		}
	}

	private void testarPessoaFisica() throws SQLException{
		IControleUsuario impl = new ControleUsuario();
		if (acao==1){
			impl.inserir(pessoaFisica);
		}else if (acao==2){
			List<PessoaFisica> lista = impl.obterPessoaFisica();
			for (PessoaFisica obj : lista){
				System.out.println(obj.toString());
			}
		}else if (acao==3){
			List<PessoaFisica> lista = impl.obterPorCriterio(pessoaFisica);
			for (PessoaFisica obj : lista){
				System.out.println(obj.toString());
			}
		}else if (acao==4){
			impl.atualizar(pessoaFisica);
		}
	}
	
	private void testarPessoaJuridica() throws SQLException{
		IControleUsuario impl = new ControleUsuario();
		if (acao==1){
			impl.inserir(pessoaJuridica);
		}else if (acao==2){
			List<PessoaJuridica> lista = impl.obterPessoaJuridica();
			for (PessoaJuridica obj : lista){
				System.out.println(obj.toString());
			}
		}else if (acao==3){
			List<PessoaJuridica> lista = impl.obterPorCriterio(pessoaJuridica);
			for (PessoaJuridica obj : lista){
				System.out.println(obj.toString());
			}
		}else if (acao==4){
			impl.atualizar(pessoaJuridica);
		}
	}

}
