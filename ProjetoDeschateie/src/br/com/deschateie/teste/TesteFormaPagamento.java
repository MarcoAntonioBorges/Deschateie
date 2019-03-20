package br.com.deschateie.teste;

import br.com.deschateie.beans.FormaPagamento;
import br.com.deschateie.bo.FormaPagamentoBO;
import br.com.deschateie.excecao.Excecao;

public class TesteFormaPagamento {

	public static void main(String[] args) {

		try {
//			
//			System.out.println("---------- PRIMEIRA CONSULTA -------------");
//			System.out.println(FormaPagamentoBO.pesquisarFormaPagamento(new FormaPagamento(1,"boleto")).getAll());
//			
//			System.out.println("--------------- S T A T U S ----------------------------");
//			
//			System.out.println(FormaPagamentoBO.novaFormaPagamento(new FormaPagamento(7,"cartao pre-pago")));
//			
//			System.out.println("-----------------------------------------------------------------------");
//			System.out.println("============ SEGUNDA CONSULTA===========");
//			System.out.println(FormaPagamentoBO.pesquisarFormaPagamento(new FormaPagamento(5,"cheque")).getAll());
//			
//			System.out.println("============ TERCEIRA CONSULTA===========");
//			System.out.println(FormaPagamentoBO.pesquisarFormaPagamento(new FormaPagamento(7,"cartao")).getAll());
//			
//			
//			System.out.println(FormaPagamentoBO.alterarDadosFormaPagamento(new FormaPagamento(7,"cartao de debito")));
//			
//			System.out.println("============ QUARTA CONSULTA===========");
//			System.out.println(FormaPagamentoBO.pesquisarFormaPagamento(new FormaPagamento(7,"cartao")).getAll());
//			
//			System.out.println("================================================");
//			
//			System.out.println(FormaPagamentoBO.exluirFormaPagamento(new FormaPagamento(7, "asd")));
//			
//			
//			System.out.println("====== ULTIMO TESTE ==============");
//			System.out.println(FormaPagamentoBO.pesquisarFormaPagamento(new FormaPagamento(7,"cartao")).getAll());
//			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(Excecao.tratarExcecao(e));
		}
	}

}
