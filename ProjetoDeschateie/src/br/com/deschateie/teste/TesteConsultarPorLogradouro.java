package br.com.deschateie.teste;


import java.util.List;

import br.com.deschateie.beans.Endereco;
import br.com.deschateie.dao.EnderecoDAO;
import br.com.deschateie.excecao.Excecao;

public class TesteConsultarPorLogradouro {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			List<Endereco> enderecos = new EnderecoDAO().consultarPorLogradouroEnderecoPsicologo("A");
			
			if(!enderecos.isEmpty()) {
				for(Endereco endereco : enderecos) {
					System.out.println(endereco.getAll());
					System.out.println();
					
				}
			}else {
				System.out.println("nenhum resultado foi encontrado");
			}
			
			
		
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(Excecao.tratarExcecao(e));
		}

	}

}
