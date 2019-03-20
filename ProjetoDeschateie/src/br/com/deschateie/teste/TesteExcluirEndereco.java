package br.com.deschateie.teste;

import br.com.deschateie.dao.EnderecoDAO;
import br.com.deschateie.excecao.Excecao;

public class TesteExcluirEndereco {

	public static void main(String[] args) {
		try {
			System.out.println(new EnderecoDAO().apagarEndereco(73741706));
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(Excecao.tratarExcecao(e));
		}

	}

}
