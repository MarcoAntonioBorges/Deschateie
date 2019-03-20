package br.com.deschateie.bo;

import br.com.deschateie.beans.FormaPagamento;
import br.com.deschateie.dao.FormaPagamentoDAO;
/**
 * Classe para validar os dados para tebela T_SCP_FORMA_PAGAMENTO
 * possui métodos para criar,pesquisar,alterar e excluir forma de pagamentos
 * @author Deschateie
 * @version 1.0
 * @since 1.0
 * @see FormaPagamento
 * @see FormaPagamentoDAO
 *
 */
public class FormaPagamentoBO {
	
	 /**
	  * Método responsável por manipular as regras de negócio relacionadas FormaPagamento
	  * Regras avaliadas
	  * 1 Verificar se o código da forma de pagamento é valido
	  * @param codFormaPagamento Recebe um número inteiro do codigo da forma de pagamento
	  * @return Retorna um Objeto do tipo FormaPagamento
	  * @author Deschateie
	  * @throws Exception chamada da exceção checked SQLException
	  */
	public static FormaPagamento pesquisarFormaPagamento(int codFormaPagamento)throws Exception{
		
		if(codFormaPagamento<0) {
			return new FormaPagamento();
		}
		
		if (codFormaPagamento>99) {
			return new FormaPagamento();
		}
		
		FormaPagamentoDAO dao = new FormaPagamentoDAO();
		FormaPagamento forma = dao.consultarFormaPagamento(codFormaPagamento);
		dao.fechar();
		return forma;
	}

	
	/**
	 * Método responsável por manipular as regras de negócio relacionadas FormaPagamento
	 * Regras avaliadas
	 * 1 verificar se o codigo é valido
	 * 2 Verifica se o campo da forma de pagamento é valido
	 * @param fp Recebe um Objeto do tipo FormaPagamento
	 * @return Retornar uma String informando um erro caso algumas das regras acima
	 * não sejam seguidas ou mensagem de sucesso 
	 * @author Deschateie
	 * @throws Exception chamada da exceção checked SQLException
	 */
	public static String novaFormaPagamento(FormaPagamento fp)throws Exception {
		if(fp.getCodFormaPagamento()<0) {
			return "codigo invalido";
		}
		
		if (fp.getCodFormaPagamento()>99) {
			return  "codigo muito grande";
		}
		
		if(fp.getFormaPagamento().length()<1) {
			return "A forma de pagamento nao pode estar vazia";
					
		}
		
		if(fp.getFormaPagamento().length()>40) {
			return "Forma de pagamento muito grande";
		}
		
		if(pesquisarFormaPagamento(fp.getCodFormaPagamento()).getCodFormaPagamento()!=0) {
			return "codigo de forma de pagamento ja existente";
		}
		
		FormaPagamentoDAO dao = new FormaPagamentoDAO();
		String status = dao.gravarFormaPagamento(fp);
		dao.fechar();
		return status;
	}

	
	/**
	 * Método responsável por manipular as regras de negócio relacionadas FormaPagamento
	 * Regras avaliadas
	 * 1 verificar se o codigo é valido
	 * 2 Verifica se o campo da forma de pagamento é valido
	 * @param fp Recebe um Objeto do tipo FormaPagamento
	 * @return Retornar uma String informando um erro caso alguma das regras acima
	 * não sejam seguidas ou mensagem de sucesso 
	 * @author Deschateie
	 * @throws Exception chamada da exceção checked SQLException
	 */
	public static String alterarDadosFormaPagamento(FormaPagamento fp) throws Exception {

		if(fp.getCodFormaPagamento()<0) {
			return "codigo invalido";
		}
		
		if (fp.getCodFormaPagamento()>99) {
			return  "codigo muito grande";
		}
		
		if(fp.getFormaPagamento().length()<1) {
			return "A forma de pagamento nao pode estar vazia";
					
		}
		
		if(fp.getFormaPagamento().length()>40) {
			return "Forma de pagamento muito grande";
		}
		
		if(pesquisarFormaPagamento(fp.getCodFormaPagamento()).getCodFormaPagamento()==0) {
			return "codigo de forma de pagamento nao existente";
		}
		
		
		FormaPagamentoDAO dao = new FormaPagamentoDAO();
		String status = dao.alterarDadosFormaPagamento(fp);
		dao.fechar();
		return status;
	}
	
	/**
	 * Método responsável por manipular as regras de negócio relacionadas FormaPagamento
	 * Regras avaliadas
	 * 1 Verifica se o código é valido
	 * 2 Verifica se a forma de pagamento existe
	 * @param codFormaPagamento Recebe um número interio do codigo da forma de pagamento
	 * @return Retorna uma Stirng informando um erro caso alguma das regras acima não sejam seguidas
	 * ou mensagem de sucesso
	 * @author Deschateie
	 * @throws Exception chamada da exceção checked SQLException
	 */
	public static String exluirFormaPagamento(int codFormaPagamento)throws Exception{
		if(codFormaPagamento <1) {
			return "codigo invalido";
		}
		
		if (codFormaPagamento>99) {
			return  "codigo muito grande";
		}
		
		if(pesquisarFormaPagamento(codFormaPagamento).getCodFormaPagamento()==0) {
			return "codigo de forma de pagamento nao existente";
		}
		
		FormaPagamentoDAO dao = new FormaPagamentoDAO();
		String status = dao.exluirFormaPagamento(codFormaPagamento);
		dao.fechar();
		return status;
	}
}
