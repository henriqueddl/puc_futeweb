package br.com.futeweb.aplicacao.utils;


public class Mensagens {
	
	public static final String ID_CAMPO_MENSAGEM_INDEX = "form:id-mensagem-index";
	
	public static final String PARAMETRO_EXCEPTION = "<exception/>";
	
	public static final String ERRO_CONEXAO_ABRIR = "Ocorreu um erro ao abrir conexão: "+PARAMETRO_EXCEPTION;
	public static final String ERRO_CONEXAO_FECHAR = "Ocorreu um erro ao encerrar a conexão: "+PARAMETRO_EXCEPTION;
	public static final String ERRO_PREPAREDSTATEMENT_ABRIR = "Ocorreu um iniciar o preparedStatement: "+PARAMETRO_EXCEPTION;
	public static final String ERRO_PREPAREDSTATEMENT_FECHAR = "Ocorreu um erro ao encerrar o preparedStatement: "+PARAMETRO_EXCEPTION;
	public static final String ERRO_RESULTSET_FECHAR = "Ocorreu um erro ao encerrar o resultset: "+PARAMETRO_EXCEPTION;
	public static final String ERRO_EXECUTAR_QUERY = "Ocorreu um erro ao executar consulta: "+PARAMETRO_EXCEPTION;
	public static final String ERRO_EXECUTAR_UPDATE = "Ocorreu um erro ao gravar registro no banco: "+PARAMETRO_EXCEPTION;
	
	public static final String ERRO_PREENCHIMENTO = "Todos os campos com * devem ser preenchidos.";
	
	public static final String ERRO_ESTABELECIMENTO_INSERIR = "Ocorreu um erro ao inserir o estabelecimento: "+PARAMETRO_EXCEPTION;
	public static final String ERRO_ESTABELECIMENTO_INSERIR_0 = "Ocorreu um erro ao inserir o estabelecimento, nenhum estabelecimento foi registrado.";
	public static final String ERRO_ESTABELECIMENTO_ATUALIZAR = "Ocorreu um erro ao atualizar o estabelecimento: "+PARAMETRO_EXCEPTION;
	public static final String ERRO_ESTABELECIMENTO_ATUALIZAR_0 = "Ocorreu um erro ao atualizar o estabelecimento, nenhum estabelecimento foi atualizado.";
	public static final String ERRO_ESTABELECIMENTO_CONSULTAR = "A busca do estabelecimento foi realizada com sucesso, porem não retornou nenhum registro.";
	public static final String ERRO_ESTABELECIMENTO_CONSULTAR_EXCEPTION = "Ocorreu um erro ao buscar os estabelecimentos: "+PARAMETRO_EXCEPTION;
	public static final String OK_ESTABELECIMENTO_INSERIR = "O estabelecimento foi registrado com sucesso.";
	public static final String OK_ESTABELECIMENTO_ATUALIZAR = "O estabelecimento foi atualizado com sucesso.";
	
	public static final String ERRO_ESTABELECIMENTO_PESSOA_JURIDICA_INSERIR = "Ocorreu um erro ao vincular o estabelecimento ao usuário: "+PARAMETRO_EXCEPTION;
	public static final String ERRO_ESTABELECIMENTO_PESSOA_JURIDICA_INSERIR_0 = "Ocorreu um erro ao vincular o estabelecimento ao usuário, nenhum vinculo foi registrado.";
	public static final String ERRO_ESTABELECIMENTO_PESSOA_JURIDICA_REMOVER = "Ocorreu um erro ao desvincular o estabelecimento ao usuário: "+PARAMETRO_EXCEPTION;
	public static final String ERRO_ESTABELECIMENTO_PESSOA_JURIDICA_REMOVER_0 = "Ocorreu um erro ao desvincular o estabelecimento ao usuário, nenhum vinculo foi removido.";
	public static final String ERRO_ESTABELECIMENTO_PESSOA_JURIDICA_CONSULTAR = "A busca dos estabelecimentos vinculados ao usuário foi realizada com sucesso, porem não retornou nenhum registro.";
	public static final String ERRO_ESTABELECIMENTO_PESSOA_JURIDICA_CONSULTAR_EXCEPTION = "Ocorreu um erro ao buscar os usuários do estabelecimento: "+PARAMETRO_EXCEPTION;
	public static final String OK_ESTABELECIMENTO_PESSOA_JURIDICA_INSERIR = "O estabelecimento foi vinculado ao usuário com sucesso.";
	public static final String OK_ESTABELECIMENTO_PESSOA_JURIDICA_REMOVER = "O estabelecimento foi desvinculado ao usuário com sucesso.";
	
	public static final String ERRO_MATERIAL_INSERIR = "Ocorreu um erro ao inserir o material: "+PARAMETRO_EXCEPTION;
	public static final String ERRO_MATERIAL_INSERIR_0 = "Ocorreu um erro ao inserir o material, nenhum material foi registrado.";
	public static final String ERRO_MATERIAL_ATUALIZAR = "Ocorreu um erro ao atualizar o material: "+PARAMETRO_EXCEPTION;
	public static final String ERRO_MATERIAL_ATUALIZAR_0 = "Ocorreu um erro ao atualizar o material, nenhum material foi atualizado.";
	public static final String ERRO_MATERIAL_CONSULTAR = "A busca do material foi realizada com sucesso, porem não retornou nenhum registro.";
	public static final String ERRO_MATERIAL_CONSULTAR_EXCEPTION = "Ocorreu um erro ao buscar os materias: "+PARAMETRO_EXCEPTION;
	public static final String OK_MATERIAL_INSERIR = "O material foi registrado com sucesso.";
	public static final String OK_MATERIAL_ATUALIZAR = "O material foi atualizado com sucesso.";
	
	public static final String ERRO_MATERIAL_DISPONIBILIDADE_INSERIR = "Ocorreu um erro ao inserir a disponibilidade do material: "+PARAMETRO_EXCEPTION;
	public static final String ERRO_MATERIAL_DISPONIBILIDADE_INSERIR_0 = "Ocorreu um erro ao inserir a disponibilidade do material, nenhuma disponibilidade foi registrada.";
	public static final String ERRO_MATERIAL_DISPONIBILIDADE_REMOVER = "Ocorreu um erro ao remover a disponibilidade do material: "+PARAMETRO_EXCEPTION;
	public static final String ERRO_MATERIAL_DISPONIBILIDADE_REMOVER_0 = "Ocorreu um erro ao remover a disponibilidade do material, nenhuma disponibilidade foi removida.";
	public static final String ERRO_MATERIAL_DISPONIBILIDADE_CONSULTAR = "A busca da disponibilidade do material foi realizada com sucesso, porem não retornou nenhum registro.";
	public static final String ERRO_MATERIAL_DISPONIBILIDADE_CONSULTAR_EXCEPTION = "Ocorreu um erro a disponibilidade dos materias: "+PARAMETRO_EXCEPTION;
	public static final String OK_MATERIAL_DISPONIBILIDADE_INSERIR = "A disponibilidade do material foi registrada com sucesso.";
	public static final String OK_MATERIAL_DISPONIBILIDADE_REMOVER = "A disponibilidade do material foi removida com sucesso.";
	
	public static final String ERRO_QUADRA_INSERIR = "Ocorreu um erro ao inserir a quadra: "+PARAMETRO_EXCEPTION;
	public static final String ERRO_QUADRA_INSERIR_0 = "Ocorreu um erro ao inserir a quadra, nenhuma quadra foi registrada.";
	public static final String ERRO_QUADRA_ATUALIZAR = "Ocorreu um erro ao atualizar a quadra: "+PARAMETRO_EXCEPTION;
	public static final String ERRO_QUADRA_ATUALIZAR_0 = "Ocorreu um erro ao atualizar a quadra, nenhuma quadra foi atualizada.";
	public static final String ERRO_QUADRA_CONSULTAR = "A busca da quadra foi realizada com sucesso, porem não retornou nenhum registro.";
	public static final String ERRO_QUADRA_CONSULTAR_EXCEPTION = "Ocorreu um erro ao buscar as quadras: "+PARAMETRO_EXCEPTION;
	public static final String OK_QUADRA_INSERIR = "A quadra foi registrada com sucesso.";
	public static final String OK_QUADRA_ATUALIZAR = "A quadra foi atualizada com sucesso.";
	
	public static final String ERRO_QUADRA_DISPONIBILIDADE_INSERIR = "Ocorreu um erro ao inserir a disponibilidade da quadra: "+PARAMETRO_EXCEPTION;
	public static final String ERRO_QUADRA_DISPONIBILIDADE_INSERIR_0 = "Ocorreu um erro ao inserir a disponibilidade da quadra, nenhuma disponibilidade foi registrada.";
	public static final String ERRO_QUADRA_DISPONIBILIDADE_REMOVER = "Ocorreu um erro ao remover a disponibilidade da quadra: "+PARAMETRO_EXCEPTION;
	public static final String ERRO_QUADRA_DISPONIBILIDADE_REMOVER_0 = "Ocorreu um erro ao remover a disponibilidade da quadra, nenhuma disponibilidade foi removida.";
	public static final String ERRO_QUADRA_DISPONIBILIDADE_CONSULTAR = "A busca da disponibilidade da quadra foi realizada com sucesso, porem não retornou nenhum registro.";
	public static final String ERRO_QUADRA_DISPONIBILIDADE_CONSULTAR_EXCEPTION = "Ocorreu um erro a disponibilidade das quadras: "+PARAMETRO_EXCEPTION;
	public static final String OK_QUADRA_DISPONIBILIDADE_INSERIR = "A disponibilidade da quadra foi registrada com sucesso.";
	public static final String OK_QUADRA_DISPONIBILIDADE_REMOVER = "A disponibilidade da quadra foi removida com sucesso.";
	
	public static final String ERRO_RESERVA_INSERIR = "Ocorreu um erro ao inserir a reserva: "+PARAMETRO_EXCEPTION;
	public static final String ERRO_RESERVA_INSERIR_0 = "Ocorreu um erro ao inserir a reserva, nenhuma reserva foi registrada.";
	public static final String ERRO_RESERVA_REMOVER = "Ocorreu um erro ao remover a reserva: "+PARAMETRO_EXCEPTION;
	public static final String ERRO_RESERVA_REMOVER_0 = "Ocorreu um erro ao remover a reserva, nenhuma reserva foi removida.";
	public static final String ERRO_RESERVA_CONSULTAR = "A busca da reserva foi realizada com sucesso, porem não retornou nenhum registro.";
	public static final String ERRO_RESERVA_CONSULTAR_EXCEPTION = "Ocorreu um erro ao buscar as reservas: "+PARAMETRO_EXCEPTION;
	public static final String OK_RESERVA_INSERIR = "A reserva foi registrada com sucesso.";
	public static final String OK_RESERVA_REMOVER = "A reserva foi removida com sucesso.";
	
	public static final String ERRO_USUARIO_INSERIR = "Ocorreu um erro ao inserir o usuário: "+PARAMETRO_EXCEPTION;
	public static final String ERRO_USUARIO_INSERIR_0 = "Ocorreu um erro ao inserir o usuário, nenhum usuário foi registrado.";
	public static final String ERRO_USUARIO_ATUALIZAR = "Ocorreu um erro ao atualizar o usuário: "+PARAMETRO_EXCEPTION;
	public static final String ERRO_USUARIO_ATUALIZAR_0 = "Ocorreu um erro ao atualizar o usuário, nenhum usuário foi atualizado.";
	public static final String ERRO_USUARIO_CONSULTAR = "A busca do usuário foi realizada com sucesso, porem não retornou nenhum registro.";
	public static final String ERRO_USUARIO_CONSULTAR_EXCEPTION = "Ocorreu um erro ao buscar os usuários: "+PARAMETRO_EXCEPTION;
	public static final String OK_USUARIO_INSERIR = "O usuário foi registrado com sucesso.";
	public static final String OK_USUARIO_ATUALIZAR = "O usuário foi atualizado com sucesso.";
	
	
	public static final String ERRO_JOGO_INSERIR = "Ocorreu um erro ao inserir o jogo: "+PARAMETRO_EXCEPTION;
	public static final String ERRO_JOGO_INSERIR_0 = "Ocorreu um erro ao inserir o jogo, nenhum jogo foi registrado.";
	public static final String ERRO_JOGO_ATUALIZAR = "Ocorreu um erro ao atualizar o jogo: "+PARAMETRO_EXCEPTION;
	public static final String ERRO_JOGO_ATUALIZAR_0 = "Ocorreu um erro ao atualizar o jogo, nenhum jogo foi atualizado.";
	public static final String ERRO_JOGO_CONSULTAR = "A busca do jogo foi realizada com sucesso, porem não retornou nenhum registro.";
	public static final String OK_JOGO_INSERIR = "O jogo foi registrado com sucesso.";
	public static final String OK_JOGO_ATUALIZAR = "O jogo foi atualizado com sucesso.";
		
	public static final String ERRO_TIME_INSERIR = "Ocorreu um erro ao inserir o time: "+PARAMETRO_EXCEPTION;
	public static final String ERRO_TIME_INSERIR_0 = "Ocorreu um erro ao inserir o time, nenhum time foi registrado.";
	public static final String ERRO_TIME_ATUALIZAR = "Ocorreu um erro ao atualizar o time: "+PARAMETRO_EXCEPTION;
	public static final String ERRO_TIME_ATUALIZAR_0 = "Ocorreu um erro ao atualizar o time, nenhum time foi atualizado.";
	public static final String ERRO_TIME_CONSULTAR = "A busca do time foi realizada com sucesso, porem não retornou nenhum registro.";
	public static final String OK_TIME_INSERIR = "O time foi registrado com sucesso.";
	public static final String OK_TIME_ATUALIZAR = "O time foi atualizado com sucesso.";
		
	public static final String ERRO_CAMPEONATO_INSERIR = "Ocorreu um erro ao inserir o campeonato: "+PARAMETRO_EXCEPTION;
	public static final String ERRO_CAMPEONATO_INSERIR_0 = "Ocorreu um erro ao inserir o campeonato.";
	public static final String ERRO_CAMPEONATO_ATUALIZAR = "Ocorreu um erro ao atualizar o campeonato: "+PARAMETRO_EXCEPTION;
	public static final String ERRO_CAMPEONATO_ATUALIZAR_0 = "Ocorreu um erro ao atualizar o campeonato, nenhum campeonato foi atualizado.";
	public static final String ERRO_CAMPEONATO_CONSULTAR = "A busca do campeonato foi realizada com sucesso, porem não retornou nenhum registro.";
	public static final String OK_CAMPEONATO_INSERIR = "O campeonato foi registrado com sucesso.";
	public static final String OK_CAMPEONATO_ATUALIZAR = "O campeonato foi atualizado com sucesso.";

	public static final String ERRO_CLASSIFICACAO_INSERIR = "Ocorreu um erro ao inserir a classificação: "+PARAMETRO_EXCEPTION;
	public static final String ERRO_CLASSIFICACAO_INSERIR_0 = "Ocorreu um erro ao inserir a classificação.";
	public static final String ERRO_CLASSIFICACAO_ATUALIZAR = "Ocorreu um erro ao atualizar a classificação: "+PARAMETRO_EXCEPTION;
	public static final String ERRO_CLASSIFICACAO_ATUALIZAR_0 = "Ocorreu um erro ao atualizar a classificação, nenhum campeonato foi atualizado.";
	public static final String ERRO_CLASSIFICACAO_CONSULTAR = "A busca da classificação foi realizada com sucesso, porem não retornou nenhum registro.";
	public static final String OK_CLASSIFICACAO_INSERIR = "A classificação foi registrada com sucesso.";
	public static final String OK_CLASSIFICACAO_ATUALIZAR = "A classificação foi atualizada com sucesso.";
	
	public static final String ERRO_AUTENTICAR_PREENCHIMENTO = "Para logar no sistema o campo Login e Senha devem ser preenchidos.";
	public static final String ERRO_ATENTICAR = "Ocorreu um erro ao tentar autenticar o usuário: "+PARAMETRO_EXCEPTION;
	public static final String ERRO_ATENTICAR_0 = "Não foi encontrado nenhum usuário ativo a partir dos dados informados.";
	public static final String OK_ATENTICAR = "O usuário foi autenticado com sucesso.";

}