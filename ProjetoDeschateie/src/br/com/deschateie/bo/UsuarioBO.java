package br.com.deschateie.bo;

import java.util.ArrayList;
import java.util.List;
import br.com.deschateie.beans.Usuario;
import br.com.deschateie.dao.UsuarioDAO;

/**
 * Classe para validar os dados para tebela T_SCP_USUARIO
 * possui métodos para criar,pesquisar,alterar e excluir um usuario
 * @author Deschateie
 * @since 1.0
 * @version 1.0
 * @author Deschateie
 * @see Usuario
 * @see UsuarioDAO
 *
 */
public class UsuarioBO {
	
	/**
	  * Método responsável por manipular as regras de negócio relacionadas Usuario
	 * Regras avaliadas
	 * 1 Verifica se o codigo do usuario é valido
	 * 2 Verifica o tamanho do nome 
	 * 3 Verifica se a data é valida
	 * 4 Verifica o tamanho do login
	 * 5 Verifica o tamanha da senha
	 * 6 Verifica o nivel de permissao 
	 * 7 Verifica o tamanho da foto
	 * 8 Verifica o tamanho do genero
	 * 9 Verifica o tamanho do email do usuario
	 * 10 Verifica se o email já existe
	 * 11 Verifica se o login já existe
	 * 12 Verifica se códgio de usuario já existe
	 * @param u Recebe um Objeto do tipo Usuario
	 * @return Retorna uma String informando um erro ou sucesso caso nenhuma das regras acima seja quebrada
	 * @author Deschateie
	 * @throws Exception chamada da exceção checked SQLException
	 */
	public static String novoUsuario(Usuario u )throws Exception {
		
		if(u.getCodUsuario()>99999) {
			return "Quantidade de caracterdes de código é muito grande";
		}
		
		if(u.getCodUsuario() < 1) {
			return "código inválido";
		} 
		
		if(u.getNomeUsuario().length()>80) {
			return "nome muito grande";
		}
		
		if(u.getNomeUsuario().length()<1) {
			return "nome não pode estar vazio";
		}
		
		
		String status = DataBO.validarData(u.getDataNascimento());
		if(!status.equals(u.getDataNascimento())) {
			return status;
		}
		
		if(u.getDataNascimento().length()<6) {
			return "Data muito pequena";
		}
		
		if(u.getDataNascimento().length()>10) {
			return "data muito grande" ;
		}
		
		if (u.getLogin().length()>20) {
			return "nome de login muito grande" ;
		}
		
		if(u.getLogin().length()<1) {
			return "nome de login inválido";
		}
		
		if(u.getSenha().length()>15) {
			return "Senha muito grande";
		}
		
		if(u.getSenha().length()<4) {
			return "senha inválida";
		}
		
		if(u.getNivelPermissao() < 0 || u.getNivelPermissao() > 7) {
			return "nivel de permissao invalido";
		}
		
		
		if(u.getFoto().length()>120) {
			return "caminho da imagem muito grande";
		}
		
		if(u.getFoto().length()<1) {
			return "caminho inválido";
		}
		
		if(u.getGenero().length()>20) {
			return "genero muito grande";
		}
		
		if(u.getGenero().length()<1) {
			return "genero inválido";
		}
		
		UsuarioDAO dao = new UsuarioDAO();
		 
		
		
		if(u.getEmail().trim().isEmpty()) {
			return "O campo email nao pode estar vazio";
		}
		
		if(u.getEmail().equals(dao.consultarEmailUsuario(u.getEmail()).getEmail())) {
			return "email já existente";
		}
		
		if(u.getLogin().equals(dao.consultarLoginUsuario(u.getLogin()).getLogin())) {
			dao.fechar();
			return "Login já existente";
		}
		
		if(u.getCodUsuario()== dao.consultarCodUsuario(u.getCodUsuario()).getCodUsuario()) {
			dao.fechar();
			return "codigo existente";
		}
		
		
		dao.gravaUsuario(u);
		dao.fechar();
		return "Usuário cadastrado com Sucesso";
		
	}
	
	/**
	  * Método responsável por manipular as regras de negócio relacionadas Usuario
	 * Regras avaliadas
	 * Verifica o tamanho do email do usuario
	 * @param email Recebe uma String com o email do usuario
	 * @return Retorna um Objeto do tipo Usuario
	 * @author Deschateie
	 * @throws Exception chamada da exceção checked SQLException
	 */
	public static Usuario pesquisarEmailUsuario(String email)throws Exception{
		
		if(email.length()<0) {
			return new Usuario() ;
		}
		
		if (email.length()>60) {
			return new Usuario();
		}
		
		
		UsuarioDAO dao = new UsuarioDAO();
		
		Usuario us = dao.consultarEmailUsuario(email);
		dao.fechar();
		return us;
	}
	
	/**
	  * Método responsável por manipular as regras de negócio relacionadas Usuario
	 * Regras avaliadas
	 * Verifica o tamanho do nome do usuario
	 * @param nome Recebe uma String com o nome do usuario
	 * @return Retorna um ArrayList do tipo Usuario
	 * @author Deschateie
	 * @throws Exception chamada da exceção checked SQLException
	 */
	public static List<Usuario> pesquisarNomesUsuarios(String nome)throws Exception{
	
		List<Usuario> listaUsuario = new ArrayList<Usuario>();
		
		
		if(nome.length()<1) {
			return listaUsuario;
		}
		
		if(nome.length()>80) {
			return listaUsuario ;
		}
		
		UsuarioDAO dao = new UsuarioDAO();
		return dao.consultarNomesUsuario(nome);
		
	}
	
	/**
	  * Método responsável por manipular as regras de negócio relacionadas Usuario
	 * Regras avaliadas
	 * Verifica se o codigo do usuario é valido
	 * @param codUsuario Recebe um número inteiro do codigo do usuario
	 * @return Retorna uma String informando um erro ou sucesso caso nenhuma das regras acima seja quebrada
	 * @author Deschateie
	 * @throws Exception chamada da exceção checked SQLException
	 */
	public static String excluirUsuario(int codUsuario)throws Exception{
		
		if(codUsuario <0) {
			return "código inválido";
		}
		
		if (codUsuario> 99999) {
			return "código muito grande";
		}
		
		
		UsuarioDAO dao = new UsuarioDAO();
		Usuario usuario = dao.consultarCodUsuario(codUsuario);
		
		if(usuario.getCodUsuario()>1) {
			//vai dar uma excessao
			dao.excluirUsuario(codUsuario);
			dao.fechar();
			return "excluido com sucesso";
		}
		
		return "usuario não encontrado" ;
		
	}

	/**
	  * Método responsável por manipular as regras de negócio relacionadas Usuario
	 * Regras avaliadas
	 * 1 Verifica se o codigo do usuario é valido
	 * 2 Verifica o tamanho do nome 
	 * 3 Verifica se a data é valida
	 * 4 Verifica o tamanho do login
	 * 5 Verifica o tamanha da senha
	 * 6 Verifica o nivel de permissao 
	 * 7 Verifica o tamanho da foto
	 * 8 Verifica o tamanho do genero
	 * 9 Verifica o tamanho do email do usuario
	 * 10 Verifica se o email já existe
	 * 11 Verifica se o login já existe
	 * @param u Recebe um Objeto do tipo Usuario
	 * @return Retorna uma String informando um erro ou sucesso caso nenhuma das regras acima seja quebrada
	 * @author Deschateie
	 * @throws Exception chamada da exceção checked SQLException
	 */
	public static String AlterarDadosUsuario(Usuario u )throws Exception {
		
		if(u.getCodUsuario()>99999) {
			return "Quantidade de caracterdes de código é muito grande";
		}
		
		
		if(u.getCodUsuario() < 1) {
			return "código inválido";
		}
		
		
		if(u.getNomeUsuario().length()>80) {
			return "nome muito grande";
		}
		
		if(u.getNomeUsuario().length()<1) {
			return "nome não pode estar vazio";
		}
		
		

		
		String status = DataBO.validarData(u.getDataNascimento());
		if (!status.equals(u.getDataNascimento())) {
			return status;
		}
		if(u.getDataNascimento().length()<6) {
			return "Data muito pequena";
		}
		
		if(u.getDataNascimento().length()>10) {
			return "data muito grande" ;
		}
		
		if (u.getLogin().length()>20) {
			return "nome de login muito grande" ;
		}
		
		if(u.getLogin().length()<1) {
			return "nome de login inválido";
		}
		
		if(u.getSenha().length()>15) {
			return "Senha muito grande";
		}
		
		if(u.getSenha().length()<4) {
			return "senha inválida";
		}
		
		if(u.getNivelPermissao() < 1 || u.getNivelPermissao() > 7) {
			return "nivel de permissao invalido";
		}
		
		
		if(u.getFoto().length()>120) {
			return "caminho da imagem muito grande";
		}
		
		if(u.getFoto().length()<1) {
			return "caminho inválido";
		}
		
		if(u.getGenero().length()>20) {
			return "genero muito grande";
		}
		
		if(u.getGenero().length()<1) {
			return "genero inválido";
		}
		
		UsuarioDAO dao = new UsuarioDAO();
		
		if(u.getEmail().trim().isEmpty()) {
			return "O campo email nao pode estar vazio";
		}
		
		Usuario us = new Usuario();
		us = dao.consultarCodUsuario(u.getCodUsuario());
		
		if(us.getCodUsuario()<1) {
			return "codigo nao existe";
		}
		
		
		
		if(!u.getEmail().equals(us.getEmail())) {
			if(u.getEmail().equals(dao.consultarEmailUsuario(u.getEmail()).getEmail())) {
				dao.fechar();
				return "Email Já existente";
			}
		}
		
		
		if(!u.getLogin().equals(us.getLogin())) {
			if(u.getLogin().equals(dao.consultarLoginUsuario(u.getLogin()).getLogin())) {
				dao.fechar();
				return "Login já existente";
			}
		}
		
		
		
		u.setGenero(u.getGenero().toUpperCase());
		u.setNomeUsuario(u.getNomeUsuario().toUpperCase());
		
		
		dao.alterarDadosUsuario(u);
		dao.fechar();
		return "Usuário alterado com Sucesso";
		
	}
	
	/**
	  * Método responsável por manipular as regras de negócio relacionadas Usuario
	 * Regras avaliadas
	 * 1 Verifica se o login do usuario é válido
	 * 2 Verifica se a senha do usuario é válida
	 * @param login Recebe uma String com o login do usuario
	 * @param senha  Recebe uma String com  senha do usuario
	 * @return Retorna um Objeto do tipo Usuario
	 * @author Deschateie
	 * @throws Exception chamada da exceção checked SQLException
	 */
	public static Usuario autenticarUsuario(String login, String senha)throws Exception{
		if(login.length()<1) {
			return new Usuario();	
		}
		
		if(login.length()>20) {
			return new Usuario();
		}
		
		if(senha.length()<1) {
			return new Usuario();	
		}
		
		if(senha.length()>15) {
			return new Usuario();
			
		}
		
		
		UsuarioDAO dao = new UsuarioDAO();
		Usuario usuario = dao.autenticarUsuario(login, senha);
		dao.fechar();
		return usuario;

	}
	/**
	  * Método responsável por manipular as regras de negócio relacionadas Usuario
	 * Regras avaliadas
	 * 1 Verifica se o codigo de usuario é valido
	 * @param codUsuario Recebe um número interio com o codigo do usuario
	 * @return Retorna um Objeto do tipo Usuario
	 * @author Deschateie
	 * @throws Exception chamada da exceção checked SQLException
	 */
	public static Usuario pesquisarUsuarioPorCod(int codUsuario)throws Exception{
		
		if(codUsuario<0) {
			return new Usuario() ;
		}
		
		if (codUsuario>99999) {
			return new Usuario();
		}
		
		
		UsuarioDAO dao = new UsuarioDAO();
		
		 Usuario us =dao.consultarCodUsuario(codUsuario);
		dao.fechar();
		return us;
	}
	
	/**
	  * Método responsável por manipular as regras de negócio relacionadas Usuario
	 * Regras avaliadas
	 * 1 Verifica se o codigo de usuario é valido
	 * 2 Verifica se o nivel de permissao é valido
	 * 3 Verifica se o usuario existe
	 * @param u Recebe um Objeto do tipo Usuario
	 * @return Retorna uma String informando um erro ou sucesso caso nenhuma das regras acima seja quebrada
	 * @author Deschateie
	 * @throws Exception chamada da exceção checked SQLException
	 */
	public static String alterarNivelAcesso(Usuario u)throws Exception{
		if (u.getCodUsuario()<1) {
			return "codigo invalido";
		}
		
		if (u.getCodUsuario()>99999) {
			return "codigo de usuario muito grande";
		}
		
		
		if (u.getNivelPermissao()<0 || u.getNivelPermissao()> 7) {
			return "nivel de permissao invalido";
		}
		
		
		if (pesquisarUsuarioPorCod(u.getCodUsuario()).getCodUsuario()==0) {
			return "usuario nao encontrado";
		}
		
		UsuarioDAO dao = new UsuarioDAO();
		dao.alterarNivelAcesso(u);
		dao.fechar();
		return "nivel de acesso alterado com sucesso";
		
	}

	
}
