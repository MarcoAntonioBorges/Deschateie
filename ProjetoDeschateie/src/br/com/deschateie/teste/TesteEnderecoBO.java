package br.com.deschateie.teste;

import br.com.deschateie.beans.Endereco;
import br.com.deschateie.bo.EnderecoBO;
import br.com.deschateie.dao.EnderecoDAO;
import br.com.deschateie.excecao.Excecao;

public class TesteEnderecoBO {

	public static void main(String[] args) {

		try {
//			System.out.println(EnderecoBO.novoEnderecoPsicologo
//					(new Endereco(9339, 17, "Rua", "São José", "66A", "", 78954949, "Zezinho", "Longe", "Lg", "123")));
		
			
		//	System.out.println(EnderecoBO.novoEnderecoVoluntario
		//			(new Endereco(9349, 17, "Rua", "São José", "66A", "", 78954949, "Zezinho", "Longe", "Lg", "123")));
//			
//			System.out.println(EnderecoBO.novoEnderecoVoluntario((new Endereco(9847, 9999, "Avenida", "machado", "21", " ", 3022298, "a", "a", "a", "a"))));
			
	//		System.out.println(EnderecoBO.pesquisarPorCepPsicologo(39030080));
			
		//	System.out.println(EnderecoBO.excluirEnderecoVoluntario(0));
			
//			System.out.println(EnderecoBO.alterarDadosEnderecoVoluntario(new Endereco(1221, 27, "Rua", "Muriçoca", "22A", " ", 41582556, "Jardim joao", "Joaozinho", "JA", "brasil")));
		//System.out.println(new EnderecoDAO().consultarEnderecoVoluntario(105).getAll());
			//System.out.println(EnderecoBO.alterarDadosEnderecoVoluntario(new Endereco(105, 23, "rua", "muriçoca", "66x", " ", 948333, "JP", "spa", "sp", "brasil")));
			System.out.println(EnderecoBO.alterarDadosEnderecoPsicologo(new Endereco(105, 17, "avenida", "mendonça", "785", " casa 2 ", "3398261", "jardim jj", "sp", "sp", "brasil")));
		} catch (Exception e) {
			e.printStackTrace();
			
		System.out.println(Excecao.tratarExcecao(e));
		}
	}

}
