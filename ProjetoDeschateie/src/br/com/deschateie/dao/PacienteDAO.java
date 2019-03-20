package br.com.deschateie.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.deschateie.beans.Paciente;

import br.com.deschateie.conexao.Conexao;
/**
 * Classe responsável por manipular os dados da tabela T_SCP_PACIENTE
 * possui métodos para criar,consultar,alterar e excluir dados da tabela T_SCP_PACIENTE
 * @author Deschateie
 * @version 1.0
 * @since 1.0
 * @see Paciente
 */
public class PacienteDAO {
	private Connection con;
	private PreparedStatement stmt;
	private ResultSet rs;
	

	/**
	 * Método responsável por estabelecer conexão com o banco de dados
	 * @author Deschateie
	 * @throws Exception Chamada da exceção checked SQLException
	 */
	public PacienteDAO()throws Exception {
		con= new Conexao().conectar();
	}
	
	/**
	 * Método responsável por inserir uma linha na tabela T_SCP_PACIENTE
	 * @param p Recebe um Objeto do tipo Paciente
	 * @return Retorna uma String informando que a linha foi inserida
	 * @author Deschateie
	 * @throws Exception chamada da exceção checked SQLException
	 */
	public String gravarPaciente(Paciente p)throws Exception{
		stmt = con.prepareStatement("INSERT INTO T_SCP_PACIENTE"
									+ "(CD_PACIENTE, DS_CEP,NR_CPF,"
									+ "DS_HISTORICO,NR_CONSULTAS_REALIZADAS)"
									+ "VALUES(?,?,?,?,?) ");
		
		stmt.setInt(1, p.getCodUsuario());
		stmt.setString(2, p.getCep());
		stmt.setLong(3, p.getCpf());
		stmt.setString(4, p.getHistorico());
		stmt.setInt(5, p.getConsultasReazlizadas());
		stmt.executeUpdate();
		return "cadastrado com sucesso";
	}
	
	/**
	 * Método responsável por alterar os dados de uma linha da tabela T_SCP_VOLUNTARIO
	 * @param p Recebe um Objeto do tipo Paciente
	 * @return Retorna uma String informando que a alteração foi feita
	 * @author Deschateie
	 * @throws Exception chamada da exceção checked SQLExcepiton
	 */
	public String AlteraDadosPaciente(Paciente p)throws Exception{
		
		stmt = con.prepareStatement(
									"UPDATE T_SCP_PACIENTE SET DS_CEP = ?, NR_CPF = ?, DS_HISTORICO = ? WHERE CD_PACIENTE = ?"
									);
		
		stmt.setString(1, p.getCep());
		stmt.setLong(2, p.getCpf());
		stmt.setString(3, p.getHistorico());
		stmt.setInt(4,p.getCodPaciente());
		
		
		return "atualizado com sucesso " + stmt.executeUpdate();
	}


	/**
	 * Método responsável por excluir uma linha da tabela T_SCP_PACIENTE
	 * @param codPaciente Recebe um número inteiro do codido de paciente
	 * @return Retorna uma String informando que a linha foi excluida
	 * @author Deschateie
	 * @throws Exception chamada da exceção checked SQLException
	 */
	public String excluirPaciente(int codPaciente) throws Exception{
		
		stmt = con.prepareStatement("DELETE FROM T_SCP_PACIENTE WHERE CD_PACIENTE=  ?");
		stmt.setInt(1, codPaciente);
		return "foi excluida " + stmt.executeUpdate() + " linha";
	}
	
	/**
	 * Método responsável por consultar uma linha da tabela T_SCP_PACIENTE
	 * @param codPaciente Recebe um número inteiro do codigo de paciente
	 * @return Retorna um Objeto do tipo Paciente
	 * @author Deschateie
	 * @throws Exception chamada da exceção checked SQLException
	 */
	public Paciente consultarPaciente(int codPaciente)throws Exception{
		stmt= con.prepareStatement("SELECT * FROM  T_SCP_USUARIO NATURAL JOIN T_SCP_PACIENTE WHERE CD_USUARIO = ? AND CD_PACIENTE = ? ");
		stmt.setInt(1, codPaciente);
		stmt.setInt(2, codPaciente);
		
		rs = stmt.executeQuery();
		if(rs.next()) {
			return new Paciente(
								rs.getInt("CD_USUARIO"),
								rs.getString("NM_USUARIO"),
								rs.getString("DS_EMAIL"),
								rs.getString("DT_NASCIMENTO"),
								rs.getString("DS_LOGIN"),
								rs.getString("DS_SENHA"),
								rs.getInt("NR_NIVEL_PERMISSAO"),
								rs.getString("DS_FOTO"),
								rs.getString("DS_GENERO"),
								rs.getString("DS_CEP"),
								rs.getLong("NR_CPF"),
								rs.getString("DS_HISTORICO"),
								rs.getInt("NR_CONSULTAS_REALIZADAS"));
			}else {
				return new Paciente();
			}
	}
	
	
	


	/**
	 * Método responsável por consultar uma linha da tabela T_SCP_PACIENTE
	 * @param cpf Recebe um número long do cpf de paciente
	 * @return Retorna um Objeto do tipo Paciente
	 * @author Deschateie
	 * @throws Exception chamada da exceção checked SQLException
	 */
	public Paciente consultarPacienteCpf(long cpf)throws Exception {
		stmt= con.prepareStatement("SELECT * FROM  T_SCP_USUARIO NATURAL JOIN T_SCP_PACIENTE WHERE NR_CPF = ? ");
		stmt.setLong(1, cpf);
		
		rs = stmt.executeQuery();
		if(rs.next()) {
			return new Paciente(
								rs.getInt("CD_USUARIO"),
								rs.getString("NM_USUARIO"),
								rs.getString("DS_EMAIL"),
								rs.getString("DT_NASCIMENTO"),
								rs.getString("DS_LOGIN"),
								rs.getString("DS_SENHA"),
								rs.getInt("NR_NIVEL_PERMISSAO"),
								rs.getString("DS_FOTO"),
								rs.getString("DS_GENERO"),
								rs.getString("DS_CEP"),
								rs.getLong("NR_CPF"),
								rs.getString("DS_HISTORICO"),
								rs.getInt("NR_CONSULTAS_REALIZADAS"));
			}else {
				return new Paciente();
			}
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

