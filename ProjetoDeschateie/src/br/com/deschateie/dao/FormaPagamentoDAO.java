package br.com.deschateie.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.deschateie.beans.FormaPagamento;
import br.com.deschateie.conexao.Conexao;

/**
 * Classe responsável por manipular os dados da tabela T_SCP_FORMA_PAGAMENTO
 * possui métodos para criar,alterar,consultar e excluir dados da tabela T_SCP_FORMA_PAGAMENTO
 * @author Deschateie
 * @version 1.0
 * @since 1.0
 * @see FormaPagamento
 */
public class FormaPagamentoDAO {
	
	private Connection con;
	private PreparedStatement stmt;
	private ResultSet rs;
	
	/**
	 * Método responsável por estabelecer conexão com o banco de dados
	 * @author Deschateie
	 * @throws Exception Chamada da exceção checked SQLException
	 */
	public FormaPagamentoDAO()throws Exception {
		this.con = new  Conexao().conectar();
	}
	
	
	/**
	 * Método responsável por consultar uma linha da tabela T_SCP_FORMA_PAGAMENTO
	 * @param codFormaPagamento Recebe um número inteiro do codigo da FormaPagamento
	 * @return Retorna um Objeto do tipo FormaPagamento
	 * @author Deschateie
	 * @throws Exception Chamada da exceção checked SQLException
	 */
	public FormaPagamento consultarFormaPagamento(int codFormaPagamento)throws Exception{
		stmt = con.prepareStatement("SELECT * FROM T_SCP_FORMA_PAGAMENTO WHERE CD_FORMA_PGTO = ?");
		stmt.setInt(1, codFormaPagamento);
		rs = stmt.executeQuery();
		if (rs.next()) {
			return new FormaPagamento(
					rs.getInt("CD_FORMA_PGTO"),
					rs.getString("DS_FORMA_PGTO"));
		}
		
		return new FormaPagamento();
	}

	
	
	/**
	 * Método responsável por inserir uma linha na tabela T_SCP_FORMA_PAGAMENTO
	 * @param fp Recebe um Objeto do tipo  FormaPagamento
	 * @return Retorna uma String com uma mensagem de sucesso
	 * @author Deschateie
	 * @throws Exception Chamada da exceção checked SQLException
	 */
	public String gravarFormaPagamento(FormaPagamento fp)throws Exception {
		stmt = con.prepareStatement("INSERT INTO T_SCP_FORMA_PAGAMENTO(CD_FORMA_PGTO,DS_FORMA_PGTO) VALUES(?,?)");
		stmt.setInt(1, fp.getCodFormaPagamento());
		stmt.setString(2, fp.getFormaPagamento());
		stmt.executeUpdate();
		return "Forma de pagamento cadastrada com suceso";
		
	}

	/**
	 * Método responsável por alterar os dados de uma linha da tabela T_SCP_FORMA_PAGAMENTO
	 * @param fp Recebe um Objeto do tipo FormaPagamento
	 * @return	Retorna uma String informando que foi alterado
	 * @author Deschateie
	 * @throws Exception Chamada da exceção checked SQLException
	 */
	public String alterarDadosFormaPagamento(FormaPagamento fp)throws Exception {
		stmt = con.prepareStatement("UPDATE T_SCP_FORMA_PAGAMENTO SET DS_FORMA_PGTO = ? WHERE CD_FORMA_PGTO = ?");
		stmt.setString(1, fp.getFormaPagamento());
		stmt.setInt(2, fp.getCodFormaPagamento());
		return stmt.executeUpdate()+"linha alterada";
	}
	
	
	/**
	 * Método responsável por excluir uma linha da tabela T_SCP_FORMA_PAGAMENTO
	 * @param codFormaPagamento Recebe um número interio do código da FormaPagamento
	 * @return Retorna uma String  informando que a linha foi excluida
	 * @author Deschateie
	 * @throws Exception Chamada da exceção checked SQLException
	 */
	public String exluirFormaPagamento(int codFormaPagamento)throws Exception{
		stmt = con.prepareStatement("DELETE FROM T_SCP_FORMA_PAGAMENTO WHERE CD_FORMA_PGTO = ?");
		stmt.setInt(1,codFormaPagamento);
		return stmt.executeUpdate() + "linha excluida";
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
