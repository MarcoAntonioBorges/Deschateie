package br.com.deschateie.teste;



import br.com.deschateie.beans.Endereco;
import br.com.deschateie.dao.EnderecoDAO;
import br.com.deschateie.excecao.Excecao;

public class TesteGravaEndereco {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			System.out.println(new EnderecoDAO().gravarEnderecoVoluntario
					(new Endereco(9846,13, "CASA", "AVENIDA PAULIS",
							"1000","" , "000000000", "BELA VISTA", "SÂO PAULOS", "SP", "BRASIL")));
			
	
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(Excecao.tratarExcecao(e));
		}

	}

}
