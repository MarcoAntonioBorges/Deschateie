package br.com.deschateie.teste;

import java.util.List;

import br.com.deschateie.beans.Usuario;
import br.com.deschateie.bo.UsuarioBO;
import br.com.deschateie.dao.UsuarioDAO;
import br.com.deschateie.excecao.Excecao;

public class TesteGravarUsuario { 

	public static void main(String[] args) {
		try {
			
			//System.out.println(new UsuarioDAO().consultarEmailUsuario("Fernandodossantos002@gmail.com").getAll());
		//	System.out.println(new UsuarioDAO().excluirUsuario(1234));
		//	System.out.println(new UsuarioDAO().alterarDadosUsuario(new Usuario(123, "fernando2","Fernandodossantos002@gmail.com", "12/01/1997", "fernandodossantos002", "asdf", 001, " ", "Masculino")));
	//	System.out.println(new UsuarioDAO().autenticarUsuario("fernandodossantos002","asdf").getAll());
			//	System.out.println(new UsuarioDAO().gravaUsuario(new Usuario(1234, "fernando2","Fernandodossantos001@gmail.com", "12/01/1997", "fernandodossantos002", "asdf", 001, " ", "Masculino")));
		//System.out.println(UsuarioBO.novoUsuario(new Usuario(12394, "fernadndoSantos","fernandoribeiri2018@hotmail.com", "12/01/1997", "mandela1234226", "csadfas", 1, " ", "Masculino")));
		//	System.out.println(UsuarioBO.excluirUsuario(12394));
	//	System.out.println(UsuarioBO.pesquisarUsuarioPorCod(12394).getAll());
		//	System.out.println(UsuarioBO.pesquisarEmailUsuario("libero@euismodest.net").getEmail());
		
		
		//System.out.println(UsuarioBO.pesquisarUsuario("FERNANDODOSASDSANTOS005@GMAIL.COM"));
		
			
//		List<Usuario> usuarios = new UsuarioDAO().consultarNomesUsuario("F");
//		if(usuarios != null) {
//			for (Usuario usuario : usuarios) {
//				System.out.println(usuario.getAll());
//			}
//		}
			
			
//			List<Usuario> usuarios = UsuarioBO.pesquisarNomesUsuarios("");
//			if(usuarios != null) {
//				for (Usuario usuario : usuarios) {
//					System.out.println(usuario.getAll());
//				}
//			}
			
			// não é possicel exlcuir System.out.println(UsuarioBO.excluirUsuario(12));
			
			//System.out.println(new UsuarioDAO().excluirUsuario(12));
			
			
			
		//	System.out.println(UsuarioBO.AlterarDadosUsuario(new Usuario(27, "NovoUsuario", "NovoUser@gmail.com.br", "12/01/1997", "NewUsuario", "new123", 2, " ", "masculino")));
	//	System.out.println(UsuarioBO.autenticarUsuario("fernandodossantos002", "asdf"));
		
		
		
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(Excecao.tratarExcecao(e));
		}

	}

}
