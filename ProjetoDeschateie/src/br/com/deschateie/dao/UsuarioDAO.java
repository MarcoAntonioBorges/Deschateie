package br.com.deschateie.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.deschateie.beans.Usuario;
import br.com.deschateie.conexao.Conexao;

/** 
 * Classe responsável por manipula os dados da tabela T_SCP_USUARIO
 * possui método para : Cadastrar, consultar, alterar ,excluir e autenticar os dados da tabela T_SCP_USUARIO
 * @author Fernando Santos Ribeiro
 * @version 1.0
 * @since 1.0
 * @see Usuario
 *
 */


public class UsuarioDAO {
	
	private Connection con;
	private PreparedStatement stmt;
	private ResultSet rs;
	
	/**
	 *
	 * Neste método construtor estabelecemos a comunicação com o banco de dados
	 * @author Deschateie
	 * @throws Exception Chamada da exceção checked SQLException
	 */
	public UsuarioDAO()throws Exception{
		con = new  Conexao().conectar();
	}
	
	

	/**
	 * Método responsável por consultar uma linha na tabela T_SCP_USUARIO
	 * @param login Recebe uma String do nome de login do usuario
	 * @return  Retorna um Objeto do tipo Usuario
	 * @author Deschateie
	 * @throws Exception Chamada da exceção checked SQLException
	 */
	public Usuario consultarLoginUsuario(String login)throws Exception{
		stmt = con.prepareStatement("SELECT * FROM T_SCP_USUARIO WHERE DS_LOGIN = ?");
		stmt.setString(1, login);
		rs = stmt.executeQuery();
		
		if(rs.next()) {
			return new Usuario(	
								rs.getInt("CD_USUARIO"),
								rs.getString("NM_USUARIO"),
								rs.getString("DS_EMAIL"),
								rs.getString("DT_NASCIMENTO"),
								rs.getString("DS_LOGIN"),
								rs.getString("DS_SENHA"),
								rs.getInt("NR_NIVEL_PERMISSAO"),
								rs.getString("DS_FOTO"),
								rs.getString("DS_GENERO"));
		}
		
		return new Usuario();
		
	}
	
	/**
	 * Método responsável por consultar uma linha na tabela T_SCP_USUARIO
	 * @param codUsuario Recebe um número inteiro do codigo do usuario 
	 * @return	Retorna um Objeto do tipo Usuario
	 * @author Deschateie
	 * @throws Exception Chamada da exceção checked SQLException
	 */
	public Usuario consultarCodUsuario(int codUsuario)throws Exception{
		stmt = con.prepareStatement("SELECT * FROM T_SCP_USUARIO WHERE CD_USUARIO= ?");
		stmt.setInt(1, codUsuario);
		rs = stmt.executeQuery();
		
		if(rs.next()) {
			return new Usuario(	
								rs.getInt("CD_USUARIO"),
								rs.getString("NM_USUARIO"),
								rs.getString("DS_EMAIL"),
								rs.getString("DT_NASCIMENTO"),
								rs.getString("DS_LOGIN"),
								rs.getString("DS_SENHA"),
								rs.getInt("NR_NIVEL_PERMISSAO"),
								rs.getString("DS_FOTO"),
								rs.getString("DS_GENERO"));
		}
		
		return new Usuario();
		
	}
	
	/**
	 * Método responsável por consultar uma linha na tabela T_SCP_USUARIO
	 * @param email Recebe uma String do email do usuario
	 * @return Retorna um Objeto do tipo Usuario
	 * @author Deschateie
	 * @throws Exception Chamada da exceção checked SQLException
	 */
	public Usuario consultarEmailUsuario(String email)throws Exception{
		stmt = con.prepareStatement("SELECT * FROM T_SCP_USUARIO WHERE DS_EMAIL = ?");
		stmt.setString(1, email);
		rs = stmt.executeQuery();
		
		if(rs.next()) {
			return new Usuario(	
								rs.getInt("CD_USUARIO"),
								rs.getString("NM_USUARIO"),
								rs.getString("DS_EMAIL"),
								rs.getString("DT_NASCIMENTO"),
								rs.getString("DS_LOGIN"),
								rs.getString("DS_SENHA"),
								rs.getInt("NR_NIVEL_PERMISSAO"),
								rs.getString("DS_FOTO"),
								rs.getString("DS_GENERO"));
		}
		
		return new Usuario();
		
	}

	/**
	 * Método responsável por consultar várias linhas da tabela T_SCP_USUARIO
	 * @param nome Recebe uma String do nome do usuario
	 * @return Retorna um ArrayList do tipo Usuario
	 * @author Deschateie
	 * @throws Exception Chamada da exceção checked SQLException
	 */
	public List<Usuario> consultarNomesUsuario(String nome)throws Exception{
		List<Usuario> listaUsuario = new ArrayList<Usuario>();
		stmt = con.prepareStatement("SELECT * FROM T_SCP_USUARIO WHERE NM_USUARIO LIKE ? ");
		
		stmt.setString(1, nome + "%");
		rs = stmt.executeQuery();
		
		while(rs.next()) {
			listaUsuario.add(new Usuario(
					rs.getInt("CD_USUARIO"),
					rs.getString("NM_USUARIO"),
					rs.getString("DS_EMAIL"),
					rs.getString("DT_NASCIMENTO"),
					rs.getString("DS_LOGIN"),
					rs.getString("DS_SENHA"),
					rs.getInt("NR_NIVEL_PERMISSAO"),
					rs.getString("DS_FOTO"),
					rs.getString("DS_GENERO")
					));
		}
		return listaUsuario;
	}
	
	/**
	 * Método responsável por inserir uma linha na tabela T_SCP_USUARIO
	 * @param u Recebe um Obejto do tipo Usuario
	 * @return	Retorna uma String com a mensagem de sucesso
	 * @author Deschateie
	 * @throws Exception Chamada da exceção checked SQLException
	 */
	public String gravaUsuario(Usuario u)throws Exception {
		stmt = con.prepareStatement("INSERT INTO T_SCP_USUARIO "
				+ "(CD_USUARIO,NM_USUARIO,DS_EMAIL,DT_NASCIMENTO,DS_LOGIN,DS_SENHA,NR_NIVEL_PERMISSAO,DS_GENERO,DS_FOTO)"
				+ "VALUES(?,?,?,TO_DATE(?,'dd/mm/yyyy'),?,?,?,?,?)");
		stmt.setInt(1, u.getCodUsuario());
		stmt.setString(2, u.getNomeUsuario());
		stmt.setString(3, u.getEmail());
		stmt.setString(4, u.getDataNascimento());
		stmt.setString(5, u.getLogin());
		stmt.setString(6, u.getSenha());
		stmt.setInt(7, u.getNivelPermissao());
		stmt.setString(8, u.getGenero());
		stmt.setString(9, u.getFoto());
		
		stmt.executeUpdate();
		
		return "Usuário cadastrado com sucesso" ; 
		
	}

	/**
	 * Método responsável por excluir uma linha da tabela t_SCP_USUARIO
	 * @param codUsuario Recebe um número inteiro do código do usuario
	 * @return Retorna uma String com a mensagem de sucesso
	 * @author Deschateie
	 * @throws Exception Chamada da exceção checked SQLException
	 */
	public String excluirUsuario(int codUsuario)throws Exception{
		stmt = con.prepareStatement("DELETE FROM T_SCP_USUARIO WHERE CD_USUARIO =  ?");
		stmt.setInt(1, codUsuario);
		return "Foram excluidas " + stmt.executeUpdate() + " linhas";
	}

	/**
	 * Método responsável por alterar uma linha da tabea T_SCP_USUARIO
	 * @param u Recebe um Objeto do tipo Usuario
	 * @return	Retorna uma String com a mensagem de sucesso
	 * @throws Exception Chamada da exceção checked SQLException
	 */
	public String alterarDadosUsuario(Usuario u)throws Exception{
		stmt = con.prepareStatement("UPDATE T_SCP_USUARIO"
									+ "	SET NM_USUARIO = ?,"
									+ " DS_EMAIL = ?,"
									+ " DT_NASCIMENTO = TO_DATE(?,'DD/MM/YYYY'),"
									+ " DS_LOGIN = ?,"
									+ " DS_SENHA = ?,"
									+ " DS_FOTO = ?,"
									+ " DS_GENERO = ?"
									+ "WHERE CD_USUARIO = ?");
		stmt.setString(1, u.getNomeUsuario());
		stmt.setString(2, u.getEmail());
		stmt.setString(3, u.getDataNascimento());
		stmt.setString(4, u.getLogin());
		stmt.setString(5, u.getSenha());
		stmt.setString(6, u.getFoto());
		stmt.setString(7, u.getGenero());
		stmt.setInt(8, u.getCodUsuario());
		return "Foi atualizada " + stmt.executeUpdate() + "linha";
		
	}

	
	/**
	 * Método responspável por autenticar(Verificar/Consultar) um login e senha na tabela T_SCP_USUARIO
	 * @param login Recebe uma String do login do usuario
	 * @param senha Recebe uma String da senha do usuario
	 * @return	Retorna um Objeto do tipo Usuario
	 * @author Deshcateie
	 * @throws Exception Chamada da exceção checked SQLException
	 */
	public Usuario autenticarUsuario(String login, String senha)throws Exception {
		stmt = con.prepareStatement("SELECT * FROM T_SCP_USUARIO WHERE DS_LOGIN = ? AND DS_SENHA = ?");
		stmt.setString(1, login);
		stmt.setString(2, senha);
		rs = stmt.executeQuery();
		
		if(rs.next()) {
			 return new Usuario(	
					rs.getInt("CD_USUARIO"),
					rs.getString("NM_USUARIO"),
					rs.getString("DS_EMAIL"),
					rs.getString("DT_NASCIMENTO"),
					rs.getString("DS_LOGIN"),
					rs.getString("DS_SENHA"),
					rs.getInt("NR_NIVEL_PERMISSAO"),
					rs.getString("DS_FOTO"),
					rs.getString("DS_GENERO"));
		}
		
		return new Usuario();
	}

	/**
	 * Método responsável por alterar o nivel de permissao de uma linha da tabela T_SCP_USUARIO
	 * @param u Recebe um Objeto do tipo Usuario
	 * @return Retorna uma String com a mensagem de sucesso
	 * @throws Exception Chamada da exceção checked SQLException
	 */
	public String alterarNivelAcesso(Usuario u)throws Exception{
		stmt = con.prepareStatement("UPDATE T_SCP_USUARIO SET NR_NIVEL_PERMISSAO = ? WHERE CD_USUARIO = ?");
		stmt.setInt(1, u.getNivelPermissao());
		stmt.setInt(2, u.getCodUsuario());
		return stmt.executeUpdate() + "linha atualizada";
	}
	
	/**
	 * Método responsável por finalizar a conexão com o banco de dados
	 * @author Deschateie
	 * @throws Exception Chamada da exceção checked SQLException
	 */
	public void fechar()throws Exception {
		con.close();
	}
}

