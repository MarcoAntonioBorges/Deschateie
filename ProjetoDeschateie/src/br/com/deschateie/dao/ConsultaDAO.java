package br.com.deschateie.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.deschateie.beans.Consulta;
import br.com.deschateie.beans.Paciente;
import br.com.deschateie.beans.PsiOnline;
import br.com.deschateie.conexao.Conexao;

/**
 * Classe responsável por manipular os dados da tabela T_SCP_CONSULTA
 * possui métodos para criar, consultar,excluir e alterar dados da tabela T_SCP_CONSULTA
 * @author Deshcateie
 * @since 1.0
 * @version 1.0
 * @see Consulta
 *
 */
public class ConsultaDAO {
	private Connection con;
	private PreparedStatement stmt;
	private ResultSet rs ;
	
	/**
	 *
	 * Neste método construtor estabelecemos a comunicação com o banco de dados
	 * @author Deschateie
	 * @throws Exception Chamada da exceção checked SQLException
	 */
	public ConsultaDAO()throws Exception{
		con = new Conexao().conectar();
	}
	
	/**
	 * Método responável por consultar uma linha da tabela T_SCP_CONSULTA
	 * @param codConsulta Recebe um número interido do codigo da consulta
	 * @return Retorna um Objeto do tipo Consulta
	 * @author Deschateie
	 * @throws Exception Chamada da exceção checked SQLException
	 */
	public Consulta pesquisarConsultaPorCod(int codConsulta)throws Exception{ 
		stmt = con.prepareStatement("SELECT * FROM T_SCP_CONSULTA WHERE CD_CONSULTA = ?");
		stmt.setInt(1, codConsulta);
		rs = stmt.executeQuery();
		if(rs.next()) {
			return new Consulta(
					rs.getInt("CD_CONSULTA"),
					rs.getInt("CD_PSICOLOGO_ON"),
					rs.getInt("CD_PACIENTE"),
					rs.getInt("CD_CONVERSA"),
					rs.getString("DT_CONSULTA"),
					rs.getInt("VL_NOTA_ATENDIMENTO"), 
					rs.getString("DS_COMENTARIO"));
		}
		
		return new Consulta();
	}

	/**
	 * Método responsável por consultas várias linha da tabela T_SCPC_CONSULTA
	 * @return Retorna um ArrayList do tipo Consulta
	 * @author Deschateie
	 * @throws Exception Chamada da exceção checked SQLException
	 */
	public List<Consulta> pesquisarListaConsulta()throws Exception{ 
		stmt = con.prepareStatement("SELECT * FROM T_SCP_CONSULTA ");
		rs = stmt.executeQuery();
		List<Consulta> listaConsulta = new ArrayList<Consulta>();
		while(rs.next()) {
			listaConsulta.add(new Consulta(
					rs.getInt("CD_CONSULTA"),
					rs.getInt("CD_PSICOLOGO_ON"),
					rs.getInt("CD_PACIENTE"),
					rs.getInt("CD_CONVERSA"),
					rs.getString("DT_CONSULTA"),
					rs.getInt("VL_NOTA_ATENDIMENTO"), 
					rs.getString("DS_COMENTARIO")));
		}
		return listaConsulta;
	}
	
	/**
	 * Método responsável por consultas várias linha da tabela T_SCPC_CONSULTA
	 * @param codPsiOnline Recebe um número inteiro do código do psicologo online
	 * @return Retorna um ArrayList do tipo Consulta
	 * @author Deschateie
	 * @throws Exception Chamada da exceção checked SQLException
	 */
	public List<Consulta> pesquisarConsultaPsiOnline(int codPsiOnline)throws Exception{ 
		List<Consulta> listaConsulta = new ArrayList<Consulta>();
		stmt = con.prepareStatement("SELECT * FROM T_SCP_CONSULTA WHERE CD_PSICOLOGO_ON = ?");
		stmt.setInt(1, codPsiOnline);
		rs = stmt.executeQuery();
		while(rs.next()) {
			listaConsulta.add(new Consulta(
					rs.getInt("CD_CONSULTA"),
					rs.getInt("CD_PSICOLOGO_ON"),
					rs.getInt("CD_PACIENTE"),
					rs.getInt("CD_CONVERSA"),
					rs.getString("DT_CONSULTA"),
					rs.getInt("VL_NOTA_ATENDIMENTO"), 
					rs.getString("DS_COMENTARIO")));
		}
		
		return listaConsulta;
	}
	
	/**
	 * Método responsável por consultas várias linha da tabela T_SCPC_CONSULTA
	 * @param codPaciente Recebe um número inteiro do código do pacientes
	 * @return Retorna um ArrayList do tipo Consulta
	 * @author Deschateie
	 * @throws Exception Chamada da exceção checked SQLException
	 */
	public List<Consulta> pesquisarConsultaPaciente(int codPaciente)throws Exception{ 
		List<Consulta> listaConsulta = new ArrayList<Consulta>();
		stmt = con.prepareStatement("SELECT * FROM T_SCP_CONSULTA WHERE CD_PACIENTE = ?");
		stmt.setInt(1, codPaciente);
		rs = stmt.executeQuery();
		while(rs.next()) {
			listaConsulta.add(new Consulta(
					rs.getInt("CD_CONSULTA"),
					rs.getInt("CD_PSICOLOGO_ON"),
					rs.getInt("CD_PACIENTE"),
					rs.getInt("CD_CONVERSA"),
					rs.getString("DT_CONSULTA"),
					rs.getInt("VL_NOTA_ATENDIMENTO"), 
					rs.getString("DS_COMENTARIO")));
		}
		
		return listaConsulta;
	}

	/**
	 * Método responsável por excluir uma linha da tabela T_SCP_CONSULTA
	 * @param codConsulta Recebe um número inteiro do código da consulta
	 * @return Retorna uma String com a mensagem de sucesso
	 * @throws Exception Chamada da exceção checked SQLExcpetion
	 */
	public String excluirConsulta(int codConsulta)throws Exception{
		stmt = con.prepareStatement("DELETE FROM T_SCP_CONSULTA WHERE CD_CONSULTA = ?");
		stmt.setInt(1, codConsulta);
		return stmt.executeUpdate() + "excluida";
	}
	
	/**
	 * Método responsável por alterar os dados de uma linha da tabela T_SCP_CONSULTA
	 * @param c Recebe um Objeto do tipo Consulta
	 * @return Retorna uma String com a mensagem de sucesso
	 * @throws Exception Chamada da exceção checked SQLException
	 */
	public String alterarDadosConsulta(Consulta c)throws Exception{
		stmt = con.prepareStatement("UPDATE T_SCP_CONSULTA SET"
									+ "CD_PSICOLOGO_ON = ?, CD_PACIENTE = ?,CD_CONVERSA = ?,"
									+ "DT_CONSULTA = TO_DATE(?,'DD/MM/YYYY'),VL_NOTA_ATENDIMENTO= ?,"
									+ "DS_COMENTARIO = ? WHERE CD_CONSULTA = ?");
		stmt.setInt(1, c.getCodPsiOnline());
		stmt.setInt(2, c.getCodPaciente());
		stmt.setInt(3, c.getCodConversa());
		stmt.setString(4, c.getComentario());
		stmt.setInt(5, c.getCodConsulta());
		return stmt.executeUpdate() + "linha atualizada";
	}
	

	/**
	 * Método responsável por inserir uma linha na tabela T_SCP_CONSULTA
	 * @param c Recebe um Objeto do tipo Consulta
	 * @return	Retorna uma String com a mensagem de sucesso
	 * @throws Exception Chama da exceção checked SQLException
	 */
	public String gravarConsulta(Consulta c)throws Exception{
		stmt = con.prepareStatement("INSERT INTO T_SCP_CONSULTA(CD_CONSULTA,CD_PSICOLOGO_ON,"
				+ "CD_PACIENTE,CD_CONVERSA,DT_CONSULTA,VL_NOTA_ATENDIMENTO,DS_COMENTARIO)"
				+ "VALUES(?,?,?,?,TO_DATE(?,'DD/MM/YYYY'),?,?)");
		stmt.setInt(1, c.getCodConsulta());
		stmt.setInt(2, c.getCodPsiOnline());
		stmt.setInt(3, c.getCodPaciente());
		stmt.setInt(4, c.getCodConversa());
		stmt.setString(5, c.getDataConsulta());
		stmt.setInt(6, c.getNotaAtendimento());
		stmt.setString(7, c.getComentario());
		stmt.executeUpdate();
		return "Conversa Cadastrada com sucesso";
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

