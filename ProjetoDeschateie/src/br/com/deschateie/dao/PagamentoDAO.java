package br.com.deschateie.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.deschateie.beans.Pagamento;
import br.com.deschateie.conexao.Conexao;

/**
 * Classe responsável por manipular os dados da tabela T_SCP_PAGAMENTO
 * possui métodos para criar,alterar,consultar e excluir dados da tabela T_SCP_PAGAMENTO
 * @author Deschateie
 * @version 1.0
 * @since 1.0
 * @see Pagamento
 * 
 *
 */
public class PagamentoDAO {
	private Connection con;
	private PreparedStatement stmt;
	private ResultSet rs;
	

	/**
	 * Método responsável por estabelecer conexão com o banco de dados
	 * @author Deschateie
	 * @throws Exception Chamada da exceção checked SQLException
	 */
	public PagamentoDAO()throws Exception{
		con = new Conexao().conectar();
	}

	/**
	 * Método responsável por consultar uma linha da tabela T_SCP_PAGAMENTO
	 * @param codPagamento Recebe um número inteiro do codigo de pagamento
	 * @return Retorna um Objeto do tipo Pagamento
	 * @author Deschateie
	 * @throws Exception chamada da exceção checked SQLException
	 */
	public Pagamento consultarPagamento(int codPagamento)throws Exception{
		stmt = con.prepareStatement("SELECT * FROM T_SCP_PAGAMENTO  WHERE CD_PAGAMENTO = ?");
		stmt.setInt(1, codPagamento);
		rs = stmt.executeQuery();
		if (rs.next()) {
			return new Pagamento(
					rs.getInt("CD_PAGAMENTO"),
					rs.getInt("CD_PSICOLOGO_ON"),
					rs.getInt("CD_PACIENTE"), 
					rs.getInt("CD_CONSULTA"), 
					rs.getInt("CD_FORMA_PGTO"), 
					rs.getDouble("VL_CONSULTA"), 
					rs.getString("DT_PAGAMENTO"), 
					rs.getInt("QT_PARCELAS"), 
					rs.getDouble("VL_DESCONTO")
					);
		}
		return new Pagamento();
		
	}
	
	/**
	 * Método responsável por consultar uma linha da tabela T_SCP_PAGAMENTO
	 * @param codConsulta Recebe um número inteiro do codigo de consulta
	 * @return Retorna um Objeto do tipo Pagamento
	 * @author Deschateie
	 * @throws Exception chamada da exceção checked SQLException
	 */
	public Pagamento consultarPagamentoCodConsulta(int codConsulta)throws Exception{
		stmt = con.prepareStatement("SELECT * FROM T_SCP_PAGAMENTO  WHERE CD_CONSULTA = ?");
		stmt.setInt(1, codConsulta);
		rs = stmt.executeQuery();
		if (rs.next()) {
			return new Pagamento(
					rs.getInt("CD_PAGAMENTO"),
					rs.getInt("CD_PSICOLOGO_ON"),
					rs.getInt("CD_PACIENTE"), 
					rs.getInt("CD_CONSULTA"), 
					rs.getInt("CD_FORMA_PGTO"), 
					rs.getDouble("VL_CONSULTA"), 
					rs.getString("DT_PAGAMENTO"), 
					rs.getInt("QT_PARCELAS"), 
					rs.getDouble("VL_DESCONTO")
					);
		}
		return new Pagamento();
		
	}

	/**
	 * Método responsável por inserir uma linha na tabela T_SCP_PAGAMENTO
	 * @param p Recebe um Objeto do tipo Pagamento
	 * @return Retorna uma String informando que a linha foi inserida
	 * @author Deschateie
	 * @throws Exception chamada da exceção checked SQLException
	 */
	public String gravarPagamento(Pagamento p)throws Exception{
		stmt = con.prepareStatement("INSERT INTO T_SCP_PAGAMENTO "
				+ "(CD_PAGAMENTO,CD_PSICOLOGO_ON,CD_PACIENTE,CD_CONSULTA,CD_FORMA_PGTO,"
				+ "VL_CONSULTA,DT_PAGAMENTO,QT_PARCELAS,VL_DESCONTO) "
				+"VALUES (?,?,?,?,?,?,TO_DATE(?,'DD/MM/YYYY'),?,?)");
		stmt.setInt(1,p.getCodPagamento());
		stmt.setInt(2, p.getCodPsiOnline());
		stmt.setInt(3, p.getCodPaciente());
		stmt.setInt(4, p.getCodConsulta());
		stmt.setInt(5, p.getCodFormaPagamento());
		stmt.setDouble(6, p.getValorConsulta());
		stmt.setString(7, p.getDataPagamento());
		stmt.setInt(8, p.getQtdeParcelas());
		stmt.setDouble(9, p.getValorDesconto());
		
		stmt.executeUpdate();
		return "Cadastrado com sucesso";
	}

	/**
	 * Método responsável por alterar uma linha da tabela T_SCP_PAGAMENTO
	 * @author Deschateie
	 * @param p Recebe um Objeto do tipo Pagamento
	 * @return Retorna uma String informando que a linha foi alterada
	 * @throws Exception chamada da exceção checked SQLException
	 */
	public String alterarPagamento(Pagamento p)throws Exception{
		stmt = con.prepareStatement("UPDATE T_SCP_PAGAMENTO SET CD_FORMA_PGTO = ?,VL_CONSULTA = ?,QT_PARCELAS = ?, VL_DESCONTO = ? WHERE CD_PAGAMENTO = ?");
		stmt.setInt(1, p.getCodFormaPagamento());
		stmt.setDouble(2, p.getValorConsulta());
		stmt.setInt(3, p.getQtdeParcelas());
		stmt.setDouble(4, p.getValorDesconto());
		stmt.setInt(5, p.getCodPagamento());
		return stmt.executeUpdate() + "linha alterada";
	}
	
	/**
	 * Método responsável por excluir uma linha da tabela T_SCP_PAGAMENTO
	 * @author Deschateie
	 * @param codPagamento Recebe um número inteiro do codigo de pagamento
	 * @return Retorna uma String informando que a linha foi excluida
	 * @throws Exception chamada da exceção checked SQLException
	 */
	public String excluirPagamento(int codPagamento)throws Exception{
		stmt = con.prepareStatement("DELETE FROM T_SCP_PAGAMENTO WHERE CD_PAGAMENTO = ?");
		stmt.setInt(1, codPagamento);
		return stmt.executeUpdate() + " linha excluida";
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
