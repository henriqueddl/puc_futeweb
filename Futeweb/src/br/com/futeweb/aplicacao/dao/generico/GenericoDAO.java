package br.com.futeweb.aplicacao.dao.generico;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.faces.application.FacesMessage;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import br.com.futeweb.aplicacao.utils.Logger;
import br.com.futeweb.aplicacao.utils.Mensagens;

public abstract class GenericoDAO {
	
	private static final String DATA_SOURCE_FUTEWEB_USER= "jdbc/futeweb_user";
	
	private Connection connection;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	protected void montarQuery(String query) {
		try {
			abrirConexao();
			if (connection!=null){
				pstmt = connection.prepareStatement(query);
			}
		} catch (Exception e) {
			new Logger(true, FacesMessage.SEVERITY_ERROR, Mensagens.ERRO_PREPAREDSTATEMENT_ABRIR.replace(Mensagens.PARAMETRO_EXCEPTION, e.getMessage()) , Mensagens.ID_CAMPO_MENSAGEM_QUALQUER);
		}
	}
	
	protected String[][] executarQuery() {
		String[][] retorno = null;
		if (pstmt!=null){
			try {
				rs = pstmt.executeQuery();
				if (rs != null){				
					int linhas = obterQuantidadeLinhas();
					int colunas = obterQuantidadeColunas();
					retorno = new String[linhas][colunas];
					int linha = 0;
					while (rs.next()){
						for (int i=0; i<colunas; i++){
							retorno[linha][i] = rs.getString(i+1);
						}
						linha++;
					}
				}
			} catch (SQLException e) {
				new Logger(true, FacesMessage.SEVERITY_ERROR, Mensagens.ERRO_EXECUTAR_QUERY.replace(Mensagens.PARAMETRO_EXCEPTION, e.getMessage()) , Mensagens.ID_CAMPO_MENSAGEM_QUALQUER);
			} finally {
				fecharConexao();
			}		
		}
		return retorno;
	}
	
	protected int executarUpdate() {
		int retorno = 0;
		if (pstmt!=null){
			try {
				retorno = pstmt.executeUpdate();
			} catch (SQLException e) {
				new Logger(true, FacesMessage.SEVERITY_ERROR, Mensagens.ERRO_EXECUTAR_UPDATE.replace(Mensagens.PARAMETRO_EXCEPTION, e.getMessage()) , Mensagens.ID_CAMPO_MENSAGEM_QUALQUER);
			} finally {
				fecharConexao();
			}		
		}
		return retorno;
	}

	public PreparedStatement setParametros() {
		return pstmt;
	}	
	
	private void abrirConexao() throws Exception {
		try {
			InitialContext contexto = new InitialContext();
			DataSource dataSource = (DataSource) contexto.lookup(DATA_SOURCE_FUTEWEB_USER);
			connection = dataSource.getConnection();
		} catch (NamingException | SQLException e) {
			new Logger(true, FacesMessage.SEVERITY_ERROR, Mensagens.ERRO_CONEXAO_ABRIR.replace(Mensagens.PARAMETRO_EXCEPTION, e.getMessage()) , Mensagens.ID_CAMPO_MENSAGEM_QUALQUER);
			throw e;
		}
	}
	
	private void fecharConexao(){
		try {
			if (connection != null && !connection.isClosed()) {
				connection.close();
			}
		} catch (SQLException e) {
			new Logger(true, FacesMessage.SEVERITY_ERROR, Mensagens.ERRO_CONEXAO_FECHAR.replace(Mensagens.PARAMETRO_EXCEPTION, e.getMessage()) , Mensagens.ID_CAMPO_MENSAGEM_QUALQUER);
		}
		try {
			if (pstmt != null && !pstmt.isClosed()) {
				pstmt.close();
			}
		} catch (SQLException e) {
			new Logger(true, FacesMessage.SEVERITY_ERROR, Mensagens.ERRO_PREPAREDSTATEMENT_FECHAR.replace(Mensagens.PARAMETRO_EXCEPTION, e.getMessage()) , Mensagens.ID_CAMPO_MENSAGEM_QUALQUER);
		}
		try {
			if (rs != null && !rs.isClosed()) {
				rs.close();
			}
		} catch (SQLException e) {
			new Logger(true, FacesMessage.SEVERITY_ERROR, Mensagens.ERRO_RESULTSET_FECHAR.replace(Mensagens.PARAMETRO_EXCEPTION, e.getMessage()) , Mensagens.ID_CAMPO_MENSAGEM_QUALQUER);
		}
	}
	
	private int obterQuantidadeLinhas() throws SQLException{
		int linhas = 0;
		while(rs.next()){
			linhas++;
		}
		rs.beforeFirst();
		return linhas;
	}
	
	private int obterQuantidadeColunas() throws SQLException{
		return rs.getMetaData().getColumnCount();
	}
}
