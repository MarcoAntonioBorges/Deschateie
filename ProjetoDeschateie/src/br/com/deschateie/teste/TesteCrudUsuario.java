package br.com.deschateie.teste;

import java.util.ArrayList;
import java.util.List;

import br.com.deschateie.beans.Usuario;
import br.com.deschateie.bo.UsuarioBO;
import br.com.deschateie.excecao.Excecao;

public class TesteCrudUsuario {

	public static void main(String[] args) {
		try {
			System.out.println(UsuarioBO.novoUsuario
					(new Usuario(92, "Fernando Dos Santos Ribeiro", "fernandodossantos001@gmail.com.br",
					"12/01/1997", "fernandodossantos001", "123123", 5, "c/", ",masculino")));
			
			System.out.println("----------- CONSULTANDO 1 USUARIO ------------");
		System.out.println(UsuarioBO.pesquisarEmailUsuario("fernandodossantos001@gmail.com.br").getAll());
		
		System.out.println("------------ CONSULTANDO VARIOS USUARIOS -------------");
		List<Usuario> usuarios = new ArrayList<Usuario>();
		usuarios = UsuarioBO.pesquisarNomesUsuarios("C");
		
		for(Usuario usuario:usuarios) {
			System.out.println(usuario.getAll());
		}
		
		System.out.println("--------------");
//		System.out.println(UsuarioBO.AlterarDadosUsuario((new Usuario(92, "Fernando Dos Santos Ribeiro", "fernandodossantos@gmail.com.br",
//				"12/01/1997", "fernandodossantos001", "123123", 5, "c/", ",masculino"))));
//		
		System.out.println(UsuarioBO.pesquisarUsuarioPorCod(92).getAll());
		System.out.println("--------------");
		System.out.println(UsuarioBO.excluirUsuario(92));
		System.out.println(UsuarioBO.pesquisarUsuarioPorCod(92).getAll());
		
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(Excecao.tratarExcecao(e));
		}

	}

}
