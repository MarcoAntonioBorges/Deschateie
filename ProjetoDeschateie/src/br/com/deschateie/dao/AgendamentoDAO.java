package br.com.deschateie.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.deschateie.beans.Agendamento;
import br.com.deschateie.beans.Psicologo;
import br.com.deschateie.beans.Usuario;
import br.com.deschateie.conexao.Conexao;
/**
 * Classe responsável por manipular os dados da tabela T_SCP_AGENDAMENTO
 * possui métodos para cadastrar,consultar,alterar e excluir dados da tabela T_SCP_AGENDAMENTO
 * @author Deschateie
 * @version 1.0
 * @since 1.0
 * @see Agendamento
 * @see Psicologo
 *
 */
public class AgendamentoDAO {
	
	private Connection con;
	private PreparedStatement stmt;
	private ResultSet rs;
	/**
	 * Método responsável por estabelecer a conexão com o banco de dados
	 * @author Deschateie
	 * @throws Exception Chamada da exceção checked SQLException
	 */
	public AgendamentoDAO()throws Exception {
		con = new Conexao().conectar();
	}
	
	/**
	 * Método responsável por consultar uma linha da tabela T_SCP_AGENDAMENTO
	 * @param codAgendamento Recebe um número inteiro do código de agendamento
	 * @return Retorna um Objeto do tipo  Agendamento
	 * @author Deschateie
	 * @throws Exception Chamada da exceção checked SQLException
	 */
	public Agendamento consultarAgendamento(int codAgendamento)throws Exception{
		stmt = con.prepareStatement("SELECT * FROM T_SCP_AGENDAMENTO INNER JOIN T_SCP_USUARIO ON"
				+ "(T_SCP_AGENDAMENTO.CD_USUARIO = T_SCP_USUARIO.CD_USUARIO)"
				+ " INNER JOIN T_SCP_PSICOLOGO ON(T_SCP_AGENDAMENTO.CD_PSICOLOGO = T_SCP_PSICOLOGO.CD_PSICOLOGO)"
				+ " WHERE CD_AGENDAMENTO = ?");
		stmt.setInt(1, codAgendamento);
		rs = stmt.executeQuery();
		if(rs.next()) {
			return new Agendamento(
					rs.getInt("CD_AGENDAMENTO"),
					new Psicologo(
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
							rs.getDouble("VL_CONSULTA")),
					new Usuario(rs.getInt("CD_USUARIO"),
							rs.getString("NM_USUARIO"),
							rs.getString("DS_EMAIL"),
							rs.getString("DT_NASCIMENTO"),
							rs.getString("DS_LOGIN"),
							rs.getString("DS_SENHA"),
							rs.getInt("NR_NIVEL_PERMISSAO"),
							rs.getString("DS_FOTO"),
							rs.getString("DS_GENERO")),
					rs.getString("DT_AGENDAMENTO"));
		}
		
		return new Agendamento();
	}
	
	/**
	 * Método responsável por excluir uma linha da tabela T_SCP_AGENDAMENTO
	 * @param codAgendamento Recebe um número inteiro do código de agendamento
	 * @return  Retorna uma String com uma mensagem de sucesso
	 * @author Deschateie
	 * @throws Exception Chamada da exceção checked SQLException
	 */
	public String  excluirAgendamento(int codAgendamento)throws Exception {
		stmt = con.prepareStatement("DELETE FROM T_SCP_AGENDAMENTO WHERE CD_AGENDAMENTO = ?");
		stmt.setInt(1, codAgendamento);
		return stmt.executeUpdate() + "linha atualizada";
		
	}

	/**
	 * Método responsável por alterar os dados de uma linha da tabela T_SCP_AGENDAMENTO
	 * @param ag Recebe um Objeto do tipo Agendamento
	 * @return  Retorna uma String com a mensagem de sucesso
	 * @author Deschateie
	 * @throws Exception Chamada da exceção checked SQLException
	 */
	public String alterarDadosAgendamento(Agendamento ag)throws Exception {
		stmt = con.prepareStatement("UPDATE T_SCP_AGENDAMENTO SET DT_AGENDAMENTO = TO_DATE(?,'DD/MM/YYYY HH24:MI') WHERE CD_AGENDAMENTO = ?");
		stmt.setString(1, ag.getDataAgendamento());
		stmt.setInt(2, ag.getCodAgendamento());
		return stmt.executeUpdate() +  "linha alterada";
		
	}

	/**
	 * Método responsável por inserir uma linha na tabela T_SCP_AGENDAMENTO
	 * @param ag Recebe um Objeto do tipo Agendamento
	 * @return Retorna uma String com a mensagem de sucesso
	 * @author Deschateie
	 * @throws Exception Chamada da exceção checked SQLException
	 */
	public String gravarAgendamento(Agendamento ag)throws Exception {
		stmt = con.prepareStatement("INSERT INTO T_SCP_AGENDAMENTO"
									+ "(CD_AGENDAMENTO,CD_PSICOLOGO,CD_USUARIO,DT_AGENDAMENTO)"
									+ " VALUES(?,?,?,TO_DATE(?,'DD/MM/YYYY HH24:MI'))");
		stmt.setInt(1, ag.getCodAgendamento());
		stmt.setInt(2, ag.getPsicologo().getCodPsicologo());
		stmt.setInt(3, ag.getUsuario().getCodUsuario());
		stmt.setString(4, ag.getDataAgendamento());
		stmt.executeUpdate();
		return "Agendamento cadastrado com sucesso";
		
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
