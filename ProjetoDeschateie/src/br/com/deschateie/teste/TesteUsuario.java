package br.com.deschateie.teste;

import br.com.deschateie.beans.Usuario;
import br.com.deschateie.beans.Voluntario;
import br.com.deschateie.bo.UsuarioBO;
import br.com.deschateie.bo.VoluntarioBO;

public class TesteUsuario {

	public static void main(String[] args) {

		try {
			//System.out.println(UsuarioBO.AlterarDadosUsuario(new Usuario(1, "PAKI", "Cras.eu.tellus@Suspendi.net", "22/08/1974", "teste123321", "teste94238", 1, "c", "feminino")));
			
			
			System.out.println(UsuarioBO.alterarNivelAcesso(new Usuario(3, "asdads", "asdad@asdasd.com.br", "12/01/1997",
					"asdas", "asdasd", 4, "casda", "measculino")));
		} catch (Exception e) {
			e.printStackTrace();
		
		}
	}

}
