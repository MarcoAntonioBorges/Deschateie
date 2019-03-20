package br.com.deschateie.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.deschateie.beans.PsiOnline;
import br.com.deschateie.beans.Voluntario;
import br.com.deschateie.conexao.Conexao;

/**
 * Classe responsável por manipular os dados da tabela T_SCP_PSI_ONLINE
 * possui métodos para criar,consultar,excluir e alterar os dados da tabela T_SCP_PSI_ONLINE
 * @author Deschateie
 * @since 1.0
 * @version 1.0
 * @see PsiOnline
 *
 */
public class PsiOnlineDAO {
	private Connection con;
	private PreparedStatement stmt;
	private ResultSet rs;
		
	/**
	 * Método responsável por estabelecer conexão com banco de dados
	 * @author Deschateie
	 * @throws Exception Chamada da exceção checked SQLException
	 */
	public PsiOnlineDAO()throws Exception{
		con = new Conexao().conectar();
	}
	
	/**
	 * Método responsável por consultar uma linha da tabela T_SCP_PSI_ONLINE
	 * @param codPsi Recebe um número inteiro de codigo do psicologo online
	 * @return	Retorna um Objeto do tipo PsiOnline
	 * @author Deschateie
	 * @throws Exception Chamada da exceção checked SQLException
	 */
	public PsiOnline consultarPsiOnline(int codPsi)throws Exception{
		stmt = con.prepareStatement("SELECT * FROM T_SCP_USUARIO INNER JOIN T_SCP_PSICOLOGO"
				+ " ON CD_USUARIO = CD_PSICOLOGO INNER JOIN T_SCP_PSI_ONLINE"
				+ " ON CD_PSICOLOGO = CD_PSICOLOGO_ON WHERE CD_PSICOLOGO_ON = ?");
		stmt.setInt(1, codPsi);
		rs = stmt.executeQuery();
		if(rs.next()) {
			return new PsiOnline(
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
					rs.getDouble("VL_CONSULTA"),
					rs.getString("DS_PERIODO"),
					rs.getString("DS_FORMA_ATENDIMENTO"),
					rs.getInt("VL_NOTA_ATENDIMENTO"),
					rs.getInt("QT_ATENDIMENTO"));
		}else {
			return new PsiOnline();
		}
	}

	/**
	 * Método responsável por consultar uma linha da tabela T_SCP_PSI_ONLINE
	 * @return	Retorna um ArrayList do Objeto  PsiOnline
	 * @author Deschateie
	 * @throws Exception Chamada da exceção checked SQLException
	 */
	public List<PsiOnline> consultarPsiOnline()throws Exception{
		List<PsiOnline> listaPsiOnline = new ArrayList<PsiOnline>();
		stmt = con.prepareStatement("SELECT * FROM T_SCP_USUARIO INNER JOIN T_SCP_PSICOLOGO"
				+ " ON CD_USUARIO = CD_PSICOLOGO INNER JOIN T_SCP_PSI_ONLINE"
				+ " ON CD_PSICOLOGO = CD_PSICOLOGO_ON WHERE T_SCP_USUARIO.NR_NIVEL_PERMISSAO = 6");
		rs = stmt.executeQuery();
		while(rs.next()) {
			
			listaPsiOnline.add(
					new PsiOnline(
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
					rs.getDouble("VL_CONSULTA"),
					rs.getString("DS_PERIODO"),
					rs.getString("DS_FORMA_ATENDIMENTO"),
					rs.getInt("VL_NOTA_ATENDIMENTO"),
					rs.getInt("QT_ATENDIMENTO")));
		}
		
		return listaPsiOnline;
	}
	
	
	/**
	 * Método responsável por inserir uma linha na tabela T_SCP_PSI_ONLINE
	 * @param psi Recebe um Objeto do tipo PsiOnline
	 * @return	Retorna uma String informando uma mensagem de sucesso
	 * @author Deschateie
	 * @throws Exception Chamada da exceção checked SQLException
	 */
	public String gravarPsiOnline(PsiOnline psi)throws Exception{
		stmt = con.prepareStatement("INSERT INTO T_SCP_PSI_ONLINE"
									+ "(CD_PSICOLOGO_ON,DS_PERIODO,"
									+ "DS_FORMA_ATENDIMENTO,VL_NOTA_ATENDIMENTO,QT_ATENDIMENTO)"
									+ "VALUES(?,?,?,?,?)");
		stmt.setInt(1, psi.getCodPsiOnline());
		stmt.setString(2, psi.getPeriodo());
		stmt.setString(3, psi.getFormaAtendimento());
		stmt.setInt(4, psi.getNotaAtendimento());
		stmt.setInt(5, psi.getQtdeAtendimentos());
		stmt.executeUpdate();
		return "Cadastrado com sucesso";
	}

	/**
	 * Método responsável por excluir uma linha da tabela T_SCP_PSI_ONLINE
	 * @param codPsi Recebe um numero inteiro do codigo do psicologo online
	 * @return	Retorna uma String informando uma mensagem de sucesso
	 * @throws Exception Chamada da exceção checked SQLException
	 */
	public String excluirPsiOnline(int codPsi)throws Exception{
		stmt = con.prepareStatement("DELETE FROM T_SCP_PSI_ONLINE WHERE CD_PSICOLOGO_ON = ?");
		stmt.setInt(1, codPsi);
		return "foi excluida " + stmt.executeUpdate() + "linha";
		
	}
	
	/**
	 * Método responsável por alterar uma linha na tabela T_SCP_PSI_ONLINE
	 * @param psi Recebe um Objeto do tipo PsiOnline
	 * @return	Retorna uma String informando uma mensagem de sucesso
	 * @author Deschateie
	 * @throws Exception Chamada da exceção checked SQLException
	 */

	public String alterarDadosPsiOnline(PsiOnline psi)throws Exception{
		stmt = con.prepareStatement("UPDATE T_SCP_PSI_ONLINE "
									+ "SET DS_PERIODO = ?,"
									+ "DS_FORMA_ATENDIMENTO = ?,"
									+ "VL_NOTA_ATENDIMENTO = ?,"
									+ "QT_ATENDIMENTO = ?");
		stmt.setString(1, psi.getPeriodo());
		stmt.setString(2, psi.getFormaAtendimento());
		stmt.setInt(3, psi.getNotaAtendimento());
		stmt.setInt(4, psi.getQtdeAtendimentos());
		return stmt.executeUpdate()+"atualiada";
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
