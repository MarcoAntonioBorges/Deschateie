package br.com.deschateie.main;

import br.com.deschateie.beans.Pagamento;
import br.com.deschateie.dao.PagamentoDAO;
import br.com.deschateie.excecao.Excecao;

public class TestePagamento {

	public static void main(String[] args) {
		try {
			
			//validar os dados da consulta,do psicologo online e do paciente precisam bater para que possa criar um novo pagamento
//			System.out.println(new PagamentoDAO().gravarPagamento
//					(new Pagamento(
//
//							97,
//							3,
//							15, 
//							9, 
//							3, 
//							340.32, 
//							"25/09/2018", 
//							5,
//							40
//							)));
//			
//			
//			System.out.println(new PagamentoDAO().alterarPagamento
//					(new Pagamento(
//
//							97,
//							3,
//							15, 
//							9, 
//							1, 
//							140.32, 
//							"25/09/2018", 
//							5,
//							15
//							)));
//			
					System.out.println(new PagamentoDAO().excluirPagamento(97));
		//	new Pagamento(codPagamento, codConsulta, codPsiOnline, codPaciente, codFormaPagamento, valorConsulta, dataPagamento, qtdeParcelas, valorDesconto)
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(Excecao.tratarExcecao(e));
		}

	}

}
