package br.com.deschateie.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.deschateie.beans.Conversa;
import br.com.deschateie.beans.Voluntario;
import br.com.deschateie.conexao.Conexao;

/**
 * Classe responsável por manipular dados da tabela T_SCP_CONVERSA
 * possui métodos para criar,alterar,consulta e excluir dados da tabela T_SCP_CONVERSA
 * @author Deschateie
 * @since 1.0
 * @version 1.0
 * @see Conversa
 * 
 *
 */
public class ConversaDAO {
	private Connection con;
	private PreparedStatement stmt;
	private ResultSet rs;
	
	/**
	 *
	 * Neste método construtor estabelecemos a comunicação com o banco de dados
	 * @author Deschateie
	 * @throws Exception Chamada da exceção checked SQLException
	 */
	public ConversaDAO()throws Exception{
		con = new Conexao().conectar();
	}
	
	/**
	 * Método responsável por consultar uma linha da tabela T_SCP_CONVERSA
	 * @param codConversa Recebe um número inteiro do codigo da conversa
	 * @return Retorna um Objeto do tipo Conversa
	 * @author Deschateie
	 * @throws Exception chamada da exceção checked SQLExcepiton
	 */
	public Conversa consultarConversa(int codConversa)throws Exception{
		stmt = con.prepareStatement("SELECT * FROM T_SCP_CONVERSA INNER JOIN T_SCP_VOLUNTARIO ON "
									+ "(T_SCP_CONVERSA.CD_VOLUNTARIO = T_SCP_VOLUNTARIO.CD_VOLUNTARIO)"
									+ " INNER JOIN T_SCP_USUARIO ON (T_SCP_VOLUNTARIO.CD_VOLUNTARIO = T_SCP_USUARIO.CD_USUARIO)"
									+ " WHERE T_SCP_CONVERSA.CD_CONVERSA = ?");
		stmt.setInt(1, codConversa);
		rs = stmt.executeQuery();
		if (rs.next()) {
			return new Conversa(
					rs.getInt("CD_CONVERSA"),
					rs.getString("HR_INICIO"),
					rs.getInt("QT_RESPOSTAS"),
					rs.getString("DS_HISTORICO"),
					rs.getString("HR_TERMINO"),
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
		
		return new Conversa();
	}

	
	/**
	 * Método responsável por excluir uma linha da tabela T_SCP_CONVERSA
	 * @param codConversa Recebe um número inteiro do codigo da conversa
	 * @return Retorna uma Stirng informando que a linha foi excluida
	 * @author Deschateie
	 * @throws Exception chamada da exceção checked SQLExcepiton
	 */
	public String excluirConversa(int codConversa)throws Exception {
		stmt = con.prepareStatement("DELETE FROM T_SCP_CONVERSA WHERE CD_CONVERSA = ?");
		stmt.setInt(1, codConversa);
		return stmt.executeUpdate() + "linha excluida";
	}
	
	
	/**
	 * Método responsável por inserir uma linha na tabela T_SCP_CONVERSA
	 * @param c Recebe um Objeto do tipo Conversa
	 * @return Retorna uma String informando que a inserção foi realizada
	 * @author Deschateie
	 * @throws Exception chamada da exceção checked SQLException
	 */
	public String gravarConversa(Conversa c)throws Exception {
		stmt = con.prepareStatement("INSERT INTO T_SCP_CONVERSA"
									+ "(CD_CONVERSA,HR_INICIO,QT_RESPOSTAS,"
									+ "DS_HISTORICO, HR_TERMINO,CD_VOLUNTARIO) "
									+ "VALUES(?,TO_DATE(?,'DD/MM/YYYY HH24:MI'),?,?,TO_DATE(?,'DD/MM/YYYY HH24:MI'),?)");
		stmt.setInt(1, c.getCodConversa());
		stmt.setString(2, c.getHoraInicio());
		stmt.setInt(3, c.getQtdeRespostas());
		stmt.setString(4, c.getHistorico());
		stmt.setString(5, c.getHoraTermino());
		stmt.setInt(6, c.getVoluntario().getCodVoluntario());
		stmt.executeUpdate();
		return "Conversa cadastrada com sucesso";
	}

	/**
	 * Método responsável por alterar os dados de uma linha da tabela T_SCP_CONVERSA
	 * @param c Recebe um Objeto do tipo Conversa
	 * @return Retorna uma String informando que a alteração foi realizada
	 * @throws Exception chamada da exceção checked SQLException
	 */
	public String alterarDadosConversa(Conversa c)throws Exception {
		stmt = con.prepareStatement("UPDATE T_SCP_CONVERSA SET "
									+ "HR_INICIO = TO_DATE(?,'DD/MM/YYYY HH24:MI'), QT_RESPOSTAS = ?,DS_HISTORICO = ?,HR_TERMINO = TO_DATE(?,'DD/MM/YYYY HH24:MI') WHERE CD_CONVERSA = ?");
		stmt.setString(1, c.getHoraInicio());
		stmt.setInt(2, c.getQtdeRespostas());
		stmt.setString(3, c.getHistorico());
		stmt.setString(4, c.getHoraTermino());
		stmt.setInt(5, c.getCodConversa());
		return stmt.executeUpdate() + "linha alterada";
	}
	
	/**
	 * Método responsável por finalizar a conexão com o banco de dados
	 * @author Deschateie
	 * @throws Exception Chamada da exceção checked SQLException
	 */
	public void fechar()throws Exception{
		con.close();
	}
	
}
