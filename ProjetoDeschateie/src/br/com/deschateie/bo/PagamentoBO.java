package br.com.deschateie.bo;


import br.com.deschateie.beans.Pagamento;
import br.com.deschateie.dao.PagamentoDAO;

/**
 * Classe responsável por validar dados da tabela T_SCP_PAGAMENTO
 * possui método para pesquisar um pagamento
 * @author Deschateie
 * @version 1.0
 * @since 1.0
 * @see Pagamento
 * @see PagamentoDAO
 */
public class PagamentoBO {

	/**
	 * Métod responsável por manipular a regra de negócio relacionado ao pagamento
	 * Regra avaliada
	 * 1 Verificar se o código do pagamento é valido
	 * @param codPagamento Recebe um número inteiro do código de pagamento
	 * @return Retornar um Objeto do tipo Pagamento
	 * @throws Exception chamada da exceção checked SQLException
	 */
	public static Pagamento pesquisarPagamento(int codPagamento)throws Exception{
		if (codPagamento<1) {
			return new Pagamento();
		}
		if (codPagamento>99999) {
			return new Pagamento();
		}
		
		PagamentoDAO dao = new PagamentoDAO();
		Pagamento pa = dao.consultarPagamento(codPagamento);
		dao.fechar();
		return pa;
	}
	
	
	/**
	 * Métod responsável por manipular a regra de negócio relacionado ao pagamento
	 * Regra avaliada
	 * 1 Verificar se o código do pagamento é valido
	 * @param codConsulta Recebe um número inteiro do código de consulta
	 * @return Retornar um Objeto do tipo Pagamento
	 * @throws Exception chamada da exceção checked SQLException
	 */
	public static Pagamento pesquisarPagamentoCodConsulta(int codConsulta)throws Exception{
		if (codConsulta<1) {
			return new Pagamento();
		}
		if (codConsulta>99999) {
			return new Pagamento();
		}
		
		PagamentoDAO dao = new PagamentoDAO();
		Pagamento pa = dao.consultarPagamentoCodConsulta(codConsulta);
		dao.fechar();
		return pa;
	}
}
