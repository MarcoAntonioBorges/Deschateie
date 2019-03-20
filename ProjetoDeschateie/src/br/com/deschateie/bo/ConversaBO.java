package br.com.deschateie.bo;

import br.com.deschateie.beans.Conversa;
import br.com.deschateie.dao.ConversaDAO;


/**
 * Classe para validar os dados da tabela T_SCP_CONVERSA
 * possui métodos para consultar,excluir,criar e alterar uma consulta
 * 
 * @author Deschateie
 * @version 1.0
 * @since 1.0
 * @see ConversaDAO
 * @see Conversa
 *
 */
public class ConversaBO {
	
	
	/**
	 * Método responsável por manipular as regras de negócio relacionadas a Conversa
	 * Regras de negócio avaliadas
	 * 1 Verifica se o código é valido
	 * @param codConversa Recebe um código da conversa que precisa ser um número inteiro
	 * @return Retorna um Objeto do tipo Conversa
	 * @throws Exception chamada de exceção do tipo checked
	 * @author Deschateie
	 */
	public static Conversa pesquisarConversa(int codConversa)throws Exception {
		if (codConversa<1) {
			return new Conversa();
		}
		
		if (codConversa>99999) {
			return new Conversa();
		}
		
		ConversaDAO dao = new ConversaDAO();
		Conversa conversa = dao.consultarConversa(codConversa);
		dao.fechar();
		return conversa;
	}
	
	/**
	 * Método responsável por manipular as regras de negócio relacionada a Conversa
	 * Regras avaliadas
	 * 1 Verifica se o código é valido
	 * 2 Verifica através do código se a conversa existe
	 * @param codConversa Recebe um número inteiro do codigo da conversa
	 * @return Retorna uma String informando um erro se alguma das regras acima
	 * não estiverem sendo cumpridas ou uma mensagem de sucesso
	 * @throws Exception chamada da exceção checked SQLException
	 */
	public static String  exluirConversa(int codConversa)throws Exception {
		if (codConversa<1) {
			return "codigo invalido";
		}
		
		if (codConversa>99999) {
			return "codigo conversa muito grande";
		}
		
		if(pesquisarConversa(codConversa).getCodConversa()<1) {
			return "Codigo nao encontrado";
		}
		
		ConversaDAO dao = new ConversaDAO();
		dao.excluirConversa(codConversa);
		return "Conversa excluida com sucesso";
	}

	
	/**
	 * Método responsável por manipular as regras de negócio relacionada a Conversa
	 * Regras avaliadas 
	 * 1 Verifica se o códgio é valido
	 * 2 Verifica se a data da convers é válida
	 * 3 Verifica se o códgio da conversa passado já existe
	 * 4 Verifica se o voluntario existe 
	 * @param c Recebe um Objeto do tipo Conversa
	 * @return Retorna uma String informando um erro se alguma das regras acima 
	 * não estivem sendo cumpridas ou uma mensagem de sucesso
	 * @throws Exception chamada da exceção checked SQLException
	 */
	public static String novaConversa(Conversa c)throws Exception {
		
		if (c.getCodConversa()<1) {
			return "codigo invalido";
		}
		
		if (c.getCodConversa()>99999) {
			return "codigo muito grande";
		}
		
		String status = DataBO.validaDataHora(c.getHoraInicio());
		if(!status.equals(c.getHoraInicio())) {
			return status;
		}
		
		
		status = DataBO.validaDataHora(c.getHoraTermino());
		if(!status.equals(c.getHoraTermino())) {
			return status;
		}
		
		status = DataBO.comparaDatas(c.getHoraInicio(), c.getHoraTermino());
		if(!status.equals("ok")) {
			return status;
		}
		
		
		
		if(pesquisarConversa(c.getCodConversa())!=null) {
			return "codigo de conversa já existente";
		}
		
		if (VoluntarioBO.pesquisarVoluntario(c.getVoluntario().getCodVoluntario()).getCodVoluntario()==0) {
			return "codigo voluntario nao existente";
		}
		
		ConversaDAO dao = new ConversaDAO();
		status = dao.gravarConversa(c);
		dao.fechar();
		
		return status;
	}

	/**
	 * Método responsável por manipular as regras de negócio relacionada a Conversa
	 * Regras avaliadas 
	 * 1 Verifica se o códgio é valido
	 * 2 Verifica se a data da convers é válida
	 * 3 Verifica se o códgio da conversa passado já existe
	 * 4 Verifica se o voluntario existe 
	 * @param c Recebe um Objeto do tipo Conversa
	 * @return  Retorna uma String informando um erro se alguma das regras acima 
	 * não estivem sendo cumpridas ou uma mensagem de sucesso
	 * @throws Exception chamada da exceção checked SQLException
	 */
	public static String alterarDadosConversa(Conversa c) throws Exception{
		if (c.getCodConversa()<1) {
			return "codigo invalido";
		}
		
		if (c.getCodConversa()>99999) {
			return "codigo muito grande";
		}
		
		String status = DataBO.validaDataHora(c.getHoraInicio());
		if(!status.equals(c.getHoraInicio())) {
			return status;
		}
		
		
		status = DataBO.validaDataHora(c.getHoraTermino());
		if(!status.equals(c.getHoraTermino())) {
			return status;
		}
		
		status = DataBO.comparaDatas(c.getHoraInicio(), c.getHoraTermino());
		if(!status.equals("ok")) {
			return status;
		}
		
		Conversa conversa = pesquisarConversa(c.getCodConversa());
		
		if(conversa.getCodConversa()==0) {
			return "a conversa nao foi encontrada para ser alterada";
		}
		
		if (VoluntarioBO.pesquisarVoluntario(c.getVoluntario().getCodVoluntario()).getCodVoluntario()==0) {
			return "codigo voluntario nao existente";
		}
		
		
		
		
		
		ConversaDAO dao = new ConversaDAO();
		status = dao.alterarDadosConversa(c);
		dao.fechar();
		
		return "alterado com sucesso";
	}

}
