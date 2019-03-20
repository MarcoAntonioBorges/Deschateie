package br.com.deschateie.bo;


import br.com.deschateie.beans.Agendamento ;
import br.com.deschateie.beans.Psicologo;
import br.com.deschateie.beans.Usuario;
import br.com.deschateie.dao.AgendamentoDAO;

/**
 * Classe responsável por validar dados para a tabela T_SCP_AGENDAMENTO
 * possui métodos para  criar,exluir,alterar e pesquisar agendamentos
 * @author Deschateie
 * @version 1.0
 * @since 1.0
 * @see AgendamentoDAO 
 * @see Agendamento
 */

public class AgendamentoBO {
	/**
	 * Método responsável por manipular as regras de negócio relacionadas a Agendamento
	 * Regras de negócio avaliadas
	 * 1º O tamanho do código de agendamento
	 * @param codAgendamento recebe um codigo de agendamento que precisa ser um número inteiro
	 * @return Retorna um Objeto do tipo Agendamento, que pode estar nulo se o codigo não for existente
	 *  ou se o código passado não estiver dentro dos padrões
	 * @author Deschateie
	 * @throws Exception Exceção do tipo checkd
	 */
	public static Agendamento pesquisarAgendamento(int codAgendamento)throws Exception{
		if (codAgendamento<0) {
			return new Agendamento();
		}
		
		if(codAgendamento>99999) {
			return new Agendamento();
		}
		
		Agendamento agendamento = new Agendamento();
		AgendamentoDAO dao = new AgendamentoDAO();
		agendamento = dao.consultarAgendamento(codAgendamento);
		dao.fechar();
		return agendamento;
	}

	
	
	/** Método responsável por manipular as regras de negócio relacionadas a Agendamento
	 * Regras de negócio avaliadas
	 * 1 O tamanha do código de agendamento
	 * 2 Se o agendamento existe
	 * @param codAgendamento recebe um código de agendamento, que precisa ser um número inteiro
	 * @return retorna uma String  informando uma mensagem de erro se o código não for válido,
	 * o agendamento não for encontrado ou uma mensagem de sucesso se o agendamento for excluido
	 * @author Deschateie
	 * @throws Exception Exceção do tipo checkd
	 */
	public static String exluirAgendamento(int codAgendamento)throws Exception {
		if (codAgendamento<0) {
			return "Código inválido";
		}
		
		if (codAgendamento>99999) {
			return "codigo muito grande";
		}
		
		
		if(pesquisarAgendamento(codAgendamento).getCodAgendamento() == 0) {
			return "não foi pssivel excluir o agendamento, verifique o codigo de agendamento";
		}
		
		AgendamentoDAO dao = new AgendamentoDAO();
		dao.excluirAgendamento( codAgendamento);
		dao.fechar();
		return "Exluido com sucesso";
	}

	/**
	 * Método responsável por manipular as regras de negócio relacionadas a Agendamento
	 * Regras de negócio avaliadas
	 * 1 O tamanha do código de agendamento
	 * 2 Verifica se o agendamento existe através do código
	 * 3 Verificar se a data é válida
	 * @param ag Recebe um Objeto do tipo Agendamento
	 * @return Retorna uma Stirng, informando uma mensagem de erro ou de sucesso
	 * @author Deschateie
	 * @throws Exception Exceção do tipo checkd
	 */
	
	

	public static String AlterarDadosAgendamento(Agendamento ag) throws Exception{

		
		String status = DataBO.validarData(ag.getDataAgendamento());
		if(!status.equals(ag.getDataAgendamento())) {
			return status;
		}
		
		if (ag.getCodAgendamento()<1 ) {
			return "codigo agendamento invalido";
		}
		
		if (ag.getCodAgendamento()>99999) {
			return "codigo agendamento muito grande";
		}
		
		
		
		if (pesquisarAgendamento(ag.getCodAgendamento()).getCodAgendamento() <1) {
			return "codigo de agendamento nao encontrado";
		}
		AgendamentoDAO dao = new AgendamentoDAO();
		dao.alterarDadosAgendamento(ag);
		dao.fechar();
		return "Data Alterada com sucesso";
	}

	
	/**
	 * Método responsável por manipular as regras de negócio relacionadas a  Agendamento
	 * Regras de negócio avaliadas
	 * 1 O tamanha do código de agendamento
	 * 2 Verifica se o agendamento existe através do código
	 * 3 Verificar se a data é válida
	 * 4 Verificar se o Paciente Existe
	 * 5 Verificar se o Psicologo existe
	 * @param ag Recebe um Objeto do tipo Agendamento
	 * @return retorna uma String, informando uma mensagem de erro caso 
	 * alguma dessas regras não sejam cumpridas ou mensagem de sucesso caso o cadastro seja
	 * efetuado com sucesso
	 * @throws Exception Exceção do tipo checkd
	 * @author Deschateie
	 */ 
	
	
	public static String novoAgendamento(Agendamento ag)throws Exception  {
		
		if (ag.getCodAgendamento()<1 ) {
			return "codigo agendamento invalido";
		}
		
		if (ag.getCodAgendamento()>99999) {
			return "codigo agendamento muito grande";
		}
		
		if(ag.getPsicologo().getCodPsicologo()<1) {
			return "codigo psicologo invalido";
		}
		if (ag.getPsicologo().getCodPsicologo()>99999) {
			return "codigo psicologo muito grande";
		}
		
		String status = DataBO.validarData(ag.getDataAgendamento());
		if (!status.equals(ag.getDataAgendamento())) {
			return status;
		}
		
		Usuario usuario = new Usuario();
		usuario = UsuarioBO.pesquisarUsuarioPorCod(ag.getUsuario().getCodUsuario());
		if (usuario.getCodUsuario()<1) {
			return "codigo de usuario nao existe";
		}
		
		Psicologo psicologo = new Psicologo();
		psicologo = PsicologoBO.pesquisarPsicologo(ag.getPsicologo().getCodPsicologo());
		if (psicologo.getCodPsicologo()<1) {
			return "codigo do psicologo nao existe";
		}
		
		
		AgendamentoDAO dao = new AgendamentoDAO();
		
		if (dao.consultarAgendamento(ag.getCodAgendamento()).getCodAgendamento()>1) {
			return "Código de Agendamento já existente,  informe outro código";
		}
		
		dao.gravarAgendamento(ag);
		dao.fechar();
		
		return "Agendamento cadastrado com sucesso";
		
	}
}
