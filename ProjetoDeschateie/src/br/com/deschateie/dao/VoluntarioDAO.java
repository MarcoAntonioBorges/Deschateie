package br.com.deschateie.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.deschateie.beans.Voluntario;
import br.com.deschateie.conexao.Conexao;


/**
 * Classe responsável por manipular os dados da tabela T_SCP_VOLUNTARIO
 * possui métodos para criar,consultar,excluir e alterar os dados da tabela T_SCP_VOLUNTARIO
 * @author Deschateie
 * @version 1.0
 * @since 1.0
 * @see Voluntario
 *
 */
public class VoluntarioDAO {
	private Connection con;
	private PreparedStatement stmt;
	private ResultSet rs;
	
	/**
	 *
	 * Neste método construtor estabelecemos a comunicação com o banco de dados
	 * @author Deschateie
	 * @throws Exception Chamada da exceção checked SQLException
	 */
	public VoluntarioDAO()throws Exception {
		con = new Conexao().conectar();
	}
	
	/**
	 * Método responsável por consultar uma linha da tabela T_SCP_VOLUNTARIO
	 * @param codVoluntario Recebe um número interio do código de voluntario
	 * @return	Retorna um  Objeto do tipo Voluntario
	 * @author Deschateie
	 * @throws Exception Chamada da exceção checked SQLException
	 */
	public Voluntario consultarVoluntario(int codVoluntario)throws Exception{
		stmt = con.prepareStatement("SELECT * FROM  T_SCP_USUARIO INNER JOIN T_SCP_VOLUNTARIO "
				+ "ON (T_SCP_USUARIO.CD_USUARIO = T_SCP_VOLUNTARIO.CD_VOLUNTARIO) WHERE CD_USUARIO = ? ");
		stmt.setInt(1, codVoluntario);
		rs = stmt.executeQuery();
		
		if(rs.next()) { 
			return new  Voluntario(
									rs.getInt("CD_USUARIO"),
									rs.getString("NM_USUARIO"),
									rs.getString("DS_EMAIL"),
									rs.getString("DT_NASCIMENTO"),
									rs.getString("DS_LOGIN"),
									rs.getString("DS_SENHA"),
									rs.getInt("NR_NIVEL_PERMISSAO"),
									rs.getString("DS_FOTO"),
									rs.getString("DS_GENERO"),
									rs.getString("NR_RG"),
									rs.getLong("NR_CPF"),
									rs.getString("DS_FORMACAO"),
									rs.getString("DS_PERIODO"),
									rs.getString("DS_COMENTARIO"),
									rs.getLong("DS_TELEFONE"));
		}else {
			return new Voluntario();
		}
	}
	
	/**
	 * Método responsável por consultar várias linhas da tabela T_SCP_VOLUNTARIO
	 * @return	Retorna um ArrayList do tipo Voluntario
	 * @author Deschateie
	 * @throws Exception Chamada da exceção checked SQLException
	 */
	public List<Voluntario> consultarVoluntario()throws Exception{
		List<Voluntario> voluntario = new ArrayList<Voluntario>();
		stmt = con.prepareStatement("SELECT * FROM T_SCP_USUARIO INNER JOIN " + 
				"T_SCP_VOLUNTARIO ON(T_SCP_USUARIO.CD_USUARIO = T_SCP_VOLUNTARIO.CD_VOLUNTARIO) " + 
				"WHERE T_SCP_USUARIO.NR_NIVEL_PERMISSAO = 7");
		rs = stmt.executeQuery();
		while(rs.next()) { 
			voluntario.add(
					new  Voluntario(
					rs.getInt("CD_USUARIO"),
					rs.getString("NM_USUARIO"),
					rs.getString("DS_EMAIL"),
					rs.getString("DT_NASCIMENTO"),
					rs.getString("DS_LOGIN"),
					rs.getString("DS_SENHA"),
					rs.getInt("NR_NIVEL_PERMISSAO"),
					rs.getString("DS_FOTO"),
					rs.getString("DS_GENERO"),
					rs.getString("NR_RG"),
					rs.getLong("NR_CPF"),
					rs.getString("DS_FORMACAO"),
					rs.getString("DS_PERIODO"),
					rs.getString("DS_COMENTARIO"),
					rs.getLong("DS_TELEFONE")));	
		}
			return voluntario;
		
	}

	/**
	 * Método responsável por consultar uma linha da tabela T_SCP_VOLUNTARIO
	 * @param cpf Recebe um número long do cpf do voluntario
	 * @return	Retorna um  Objeto do tipo Voluntario
	 * @author Deschateie
	 * @throws Exception Chamada da exceção checked SQLException
	 */
	public Voluntario consultarVoluntarioCpf(long cpf)throws Exception{
		stmt = con.prepareStatement("SELECT * FROM  T_SCP_USUARIO "
				+ "INNER JOIN T_SCP_VOLUNTARIO ON(T_SCP_USUARIO.CD_USUARIO = T_SCP_VOLUNTARIO.CD_VOLUNTARIO)"
				+ "WHERE NR_CPF = ? ");
		stmt.setLong(1, cpf);
		rs = stmt.executeQuery();
		
		if(rs.next()) { 
			return new  Voluntario(
									rs.getInt("CD_USUARIO"),
									rs.getString("NM_USUARIO"),
									rs.getString("DS_EMAIL"),
									rs.getString("DT_NASCIMENTO"),
									rs.getString("DS_LOGIN"),
									rs.getString("DS_SENHA"),
									rs.getInt("NR_NIVEL_PERMISSAO"),
									rs.getString("DS_FOTO"),
									rs.getString("DS_GENERO"),
									rs.getString("NR_RG"),
									rs.getLong("NR_CPF"),
									rs.getString("DS_FORMACAO"),
									rs.getString("DS_PERIODO"),
									rs.getString("DS_COMENTARIO"),
									rs.getLong("DS_TELEFONE"));
		}else {
			return new Voluntario();
		}
	}
	
	
	/**
	 * Método responsável por consultar uma linha da tabela T_SCP_VOLUNTARIO
	 * @param rg Recebe um número long do cpf do voluntario
	 * @return	Retorna um  Objeto do tipo Voluntario
	 * @author Deschateie
	 * @throws Exception Chamada da exceção checked SQLException
	 */
	public Voluntario consultarVoluntarioRg(String rg)throws Exception{
		stmt = con.prepareStatement("SELECT * FROM  T_SCP_USUARIO "
				+ "INNER JOIN T_SCP_VOLUNTARIO ON(T_SCP_USUARIO.CD_USUARIO = T_SCP_VOLUNTARIO.CD_VOLUNTARIO)"
				+ " WHERE NR_RG = ? ");
		stmt.setString(1, rg);
		rs = stmt.executeQuery();
		
		if(rs.next()) { 
			return new  Voluntario(
									rs.getInt("CD_USUARIO"),
									rs.getString("NM_USUARIO"),
									rs.getString("DS_EMAIL"),
									rs.getString("DT_NASCIMENTO"),
									rs.getString("DS_LOGIN"),
									rs.getString("DS_SENHA"),
									rs.getInt("NR_NIVEL_PERMISSAO"),
									rs.getString("DS_FOTO"),
									rs.getString("DS_GENERO"),
									rs.getString("NR_RG"),
									rs.getLong("NR_CPF"),
									rs.getString("DS_FORMACAO"),
									rs.getString("DS_PERIODO"),
									rs.getString("DS_COMENTARIO"),
									rs.getLong("DS_TELEFONE"));
		}else {
			return new Voluntario();
		}
	}
	
	/**
	 * Método responsável por inserir uma linha na tabela T_SCP_VOLUNTARIO
	 * @param v Recebe um Objeto do tipo Voluntario
	 * @return	Retorna uma String com a mensagem de sucesso
	 * @throws Exception Chamada da exceção checked SQLException
	 */
	public String gravarVoluntario(Voluntario v)throws Exception{
		stmt = con.prepareStatement("INSERT INTO T_SCP_VOLUNTARIO"
									+ "	(CD_VOLUNTARIO,"
									+ " NR_RG,"
									+ " NR_CPF,"
									+ " DS_FORMACAO,"
									+ " DS_PERIODO,"
									+ " DS_COMENTARIO,"
									+ " DS_TELEFONE)"
									+ " VALUES (?,?,?,?,?,?,?)");
		stmt.setInt(1, v.getCodVoluntario());
		stmt.setString(2, v.getRg());
		stmt.setLong(3, v.getCpf());
		stmt.setString(4, v.getFormacao());
		stmt.setString(5, v.getPeriodo());
		stmt.setString(6, v.getComentario());
		stmt.setLong(7, v.getTelefone());
		stmt.executeUpdate();
		return "Cadastrado com sucesso";
	}

	/**
	 * Método responsável por excluir uma linha da tabela T_SCP_VOLUNTARIO
	 * @param codVoluntario Recebe um número inteiro do código do voluntario
	 * @return  Retorna uma String com a mensagem de sucesso
	 * @throws Exception Chamada da exceção checked SQLException
	 */
	public String excluirVoluntario(int codVoluntario)throws Exception{
		stmt = con.prepareStatement("DELETE FROM T_SCP_VOLUNTARIO WHERE CD_VOLUNTARIO  = ?");
		stmt.setInt(1, codVoluntario );
		return stmt.executeUpdate() + "linha exlcuida"; 
	}
	
	/**
	 * Método responsável por alterar os dados de uma linha da tabela T_SCP_VOLUNTARIO
	 * @param v Recebe um Objeto do tipo Voluntario
	 * @return Retorna uma String com a mensagem de sucesso
	 * @throws Exception Chamada da exceção checked SQLException
	 */
	public String alterarDadosVoluntario(Voluntario v)throws Exception {

		stmt= con.prepareStatement("UPDATE T_SCP_VOLUNTARIO"
									+ " SET NR_RG = ?,"
									+ "NR_CPF = ?,"
									+ "DS_FORMACAO =?,"
									+ "DS_PERIODO = ?,"
									+ "DS_COMENTARIO = ?,"
									+ "DS_TELEFONE = ?"
									+ "WHERE CD_VOLUNTARIO = ?");
		
		stmt.setString(1, v.getRg());
		stmt.setLong(2, v.getCpf());
		stmt.setString(3, v.getFormacao());
		stmt.setString(4, v.getPeriodo());
		stmt.setString(5, v.getComentario());
		stmt.setLong(6, v.getTelefone());
		stmt.setInt(7, v.getCodVoluntario());
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
