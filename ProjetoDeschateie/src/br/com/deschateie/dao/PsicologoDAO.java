package br.com.deschateie.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.deschateie.beans.Psicologo;
import br.com.deschateie.conexao.Conexao;
/**
 * Classe responsável por manipular dados da tabela T_SCP_PSICOLOGO
 * possui métodos para criar, consultar,exluir e alterar dados da tabela T_SCP_PSICOLOGO
 * @author Deschateie
 * @since 1.0
 * @version 1.0
 * @see Psicologo
 *
 */

public class PsicologoDAO {
	private Connection con;
	private PreparedStatement stmt;
	private ResultSet rs;
	
	/**
	 * Método responsável por estabelecer conexão com banco de dados
	 * @author Deschateie
	 * @throws Exception Chamada da exceção checked SQLException
	 */
	public PsicologoDAO() throws Exception{
		con = new Conexao().conectar();
	}
	
	
	/**
	 * Método responsável por consultar uma linha da tabela T_SCP_PSICOLOGO
	 * @param codPsicologo Recebe um número inteiro de codigo do Psiologo
	 * @return Retorna um Objeto do tipo Psicologo
	 * @author Deschateie
	 * @throws Exception Chamada da exceção checked SQLException
	 */
	public Psicologo consultarPsicologo(int codPsicologo)throws Exception{
		stmt = con.prepareStatement("SELECT * FROM T_SCP_USUARIO NATURAL JOIN T_SCP_PSICOLOGO  WHERE CD_USUARIO = ? AND CD_PSICOLOGO = ?");
		stmt.setInt(1, codPsicologo);
		stmt.setInt(2, codPsicologo);
		rs = stmt.executeQuery();
		
		if(rs.next()) {
			return new Psicologo(
					rs.getInt("CD_USUARIO"),
					rs.getString("NM_USUARIO"),
					rs.getString("DS_EMAIL"),
					rs.getString("DT_NASCIMENTO"),
					rs.getString("DS_LOGIN"),
					rs.getString("DS_SENHA"),
					rs.getInt("NR_NIVEL_PERMISSAO"),
					rs.getString("DS_FOTO"),
					rs.getString("DS_GENERO"),
					rs.getInt("NR_CRP"),
					rs.getString("DS_FORMACAO"),
					rs.getString("DS_BIOGRAFIA"),
					rs.getLong("DS_TELEFONE"),
					rs.getDouble("VL_CONSULTA"));
					}else {
						return new Psicologo();
					}
	}

	/**
	 * Método responsável por consultar uma linha da tabela T_SCP_PSICOLOGO
	 * @param  crp Recebe um número inteiro do codigo de CRP do Psiologo
	 * @return Retorna um Objeto do tipo Psicologo
	 * @author Deschateie
	 * @throws Exception Chamada da exceção checked SQLException
	 */
	public Psicologo consultarPsicologoCrp(int crp)throws Exception{
		stmt = con.prepareStatement("SELECT * FROM T_SCP_USUARIO NATURAL JOIN T_SCP_PSICOLOGO  WHERE NR_CRP = ?");
		stmt.setInt(1, crp);
		rs = stmt.executeQuery();
		
		if(rs.next()) {
			return new Psicologo(
					rs.getInt("CD_USUARIO"),
					rs.getString("NM_USUARIO"),
					rs.getString("DS_EMAIL"),
					rs.getString("DT_NASCIMENTO"),
					rs.getString("DS_LOGIN"),
					rs.getString("DS_SENHA"),
					rs.getInt("NR_NIVEL_PERMISSAO"),
					rs.getString("DS_FOTO"),
					rs.getString("DS_GENERO"),
					rs.getInt("NR_CRP"),
					rs.getString("DS_FORMACAO"),
					rs.getString("DS_BIOGRAFIA"),
					rs.getLong("DS_TELEFONE"),
					rs.getDouble("VL_CONSULTA"));
					}else {
						return new Psicologo();
					}
	}

	/**
	 * métodos responsável por excluir uma linha da tabela T_SCP_PSICOLOGO
	 * @param codPsicologo Recebe um  número inteiro de codigo do Psicologo
	 * @return Retorna uma String informando que a linha foi exluida
	 * @author Deschateie
	 * @throws Exception Chamada da exceção checked SQLException
	 */
	public  String excluirPsicologo(int codPsicologo) throws Exception{
		stmt = con.prepareStatement("DELETE FROM T_SCP_PSICOLOGO WHERE CD_PSICOLOGO = ?");
		stmt.setInt(1, codPsicologo);
		return stmt.executeUpdate() + "linha excluida";
		
	}

	/**
	 * Método responsável por alterar os dados da tabela T_SCP_PSICOLOGO
	 * @param p Recebe um Objeto do tipo Psicologo
	 * @return Retorna uma String informando que foi atualizado com sucesso
	 * @throws Exception Chamada da exceção checked SQLException
	 */
	public String alterarDadosPsicologo(Psicologo p)throws Exception{
		stmt = con.prepareStatement("UPDATE T_SCP_PSICOLOGO"
									+ " SET NR_CRP = ?,"
									+ " DS_FORMACAO = ?,"
									+ " DS_BIOGRAFIA = ?,"
									+ " DS_TELEFONE = ?,"
									+ " VL_CONSULTA = ? "
									+ "WHERE CD_PSICOLOGO = ?");
		stmt.setInt(1, p.getCrp());
		stmt.setString(2, p.getFormacao());
		stmt.setString(3, p.getBiografia());
		stmt.setLong(4, p.getTelefone());
		stmt.setDouble(5, p.getValorConsulta());
		stmt.setInt(6, p.getCodPsicologo());
		return stmt.executeUpdate() + "linha atualizada";
	}
	
	/**
	 * Método responsável por inserir uma linha na tabela T_SCP_PSICOLOGO
	 * @param p Recebe um Objeto do tipo Psicologo
	 * @return Retorna uma String informando que foi criada com sucesso
	 * @throws Exception Chamada da exceção checked SQLException
	 */
	public String GravarPsicologo(Psicologo p)throws Exception {
		stmt = con.prepareStatement("INSERT INTO T_SCP_PSICOLOGO "
									+ "(CD_PSICOLOGO,NR_CRP,DS_FORMACAO,DS_BIOGRAFIA,DS_TELEFONE,VL_CONSULTA)"
									+ " VALUES(?,?,?,?,?,?)");
		stmt.setInt(1, p.getCodUsuario());
		stmt.setInt(2, p.getCrp());
		stmt.setString(3, p.getFormacao());
		stmt.setString(4, p.getBiografia());
		stmt.setLong(5, p.getTelefone());
		stmt.setDouble(6, p.getValorConsulta());
		stmt.executeUpdate();
		return "Psicologo cadastrado com Sucesso";
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
