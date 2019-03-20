package br.com.deschateie.teste;

import br.com.deschateie.beans.Endereco;
import br.com.deschateie.dao.EnderecoDAO;
import br.com.deschateie.excecao.Excecao;

public class TesteAtualizarEndereco {

	public static void main(String[] args) {

		try {
			System.out.println(new EnderecoDAO().gravarEnderecoPsicologo(new Endereco(123, 321, "RUA", "JOAOZINHO", "33A", " ", "999999", "PEREIRA", "SÃO PAULO", "SP", "BRASIL")));
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(Excecao.tratarExcecao(e));
		}
	}

}
