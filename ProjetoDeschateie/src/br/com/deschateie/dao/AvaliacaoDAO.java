package br.com.deschateie.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.deschateie.beans.Avaliacao;
import br.com.deschateie.beans.Psicologo;
import br.com.deschateie.beans.Usuario;
import br.com.deschateie.conexao.Conexao;


/**
 * Está classe manipula a tabela T_SCP_AVALIACAO
* possui método para : Cadastram consultar, alterar e excluir
 * @author Deschateie
 * @version 1.0
 * @since 1.0
 * @see Avaliacao
 *
 */

public class AvaliacaoDAO {
	private Connection con;
	private PreparedStatement stmt;
	private ResultSet rs;
	
	
	/**
	 * Neste método construtor estabelece a comunicação com o banco
	 * @throws Exception chamada da exceção checked SQLException
	 */
	public AvaliacaoDAO()throws Exception {
		con = new Conexao().conectar();
	}
	
	/**
	 * Método responsável por consultar a tabela T_SCP_AVALIACAO
	 * @param codAvaliacao recebe o código da avaliação 
	 * @return Retorna uma Avaliacao
	 * @throws Exception chamada da exceção checked SQLException
	 */
	public Avaliacao consultarAvaliacao(int codAvaliacao)throws Exception{
		
		
		
		stmt = con.prepareStatement("SELECT * FROM T_SCP_AVALIACAO INNER JOIN t_scp_usuario ON(T_SCP_AVALIACAO.CD_USUARIO = T_SCP_USUARIO.CD_USUARIO)" + 
				"				INNER JOIN T_SCP_PSICOLOGO ON(T_SCP_AVALIACAO.CD_PSICOLOGO = T_SCP_PSICOLOGO.CD_PSICOLOGO )" + 
				"				WHERE T_SCP_AVALIACAO.CD_AVALIACAO = ? ");
		
		stmt.setInt(1, codAvaliacao);
		rs = stmt.executeQuery();
		
		if (rs.next()) {
				return new Avaliacao
					(rs.getInt("CD_AVALIACAO"),
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
									rs.getString("DT_AVALIACAO"),
									rs.getString("DS_RESULTADO"));
		}
			return new Avaliacao();
		
	}

	/**
	 * Método responsável por alterar o resultado(coluna) de uma linha da tabela T_SCP_AVALIACAO
	 *  de  um psicologo ou voluntario, de acordo com o critério de avaliação do
	 *  psicólogo responsável
	 * @param av Recebe um Objeto do tipo Avaliacao
	 * @return Retorna uma String informando que a alteração foi feita
	 * @throws Exception chamada de exceção checked SQLException
	 */
	public String avaliar(Avaliacao av)throws Exception{
		stmt = con.prepareStatement("UPDATE T_SCP_AVALIACAO SET DS_RESULTADO = ? WHERE CD_AVALIACAO = ?");
		stmt.setString(1, av.getResultado());
		stmt.setInt(2, av.getCodAvaliacao());
		stmt.executeUpdate();
		return "Avaliado com sucesso";
	}
	 
	/**
	 * Método responsável por consultar a tabela T_SCP_AVALIACAO usando 
	 * o código do usuario como referência
	 * @param  codUsuario Recebe o código do usuario para fazer a pesquisa
	 * @return Retornar uma Avaliacao
	 * @throws Exception chamada da exceção checked SQLException
	 */
	public Avaliacao consultarAvaliacaoUsuario(int codUsuario)throws Exception{
		
		
		
		stmt = con.prepareStatement("SELECT * FROM T_SCP_AVALIACAO INNER JOIN t_scp_usuario ON(T_SCP_AVALIACAO.CD_USUARIO = T_SCP_USUARIO.CD_USUARIO)" + 
				"				INNER JOIN T_SCP_PSICOLOGO ON(T_SCP_AVALIACAO.CD_PSICOLOGO = T_SCP_PSICOLOGO.CD_PSICOLOGO )" + 
				"				WHERE T_SCP_AVALIACAO.CD_USUARIO = ? ");
		stmt.setInt(1, codUsuario);
		rs = stmt.executeQuery();
		
		if (rs.next()) {
				return new Avaliacao
					(rs.getInt("CD_AVALIACAO"),
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
									rs.getString("DT_AVALIACAO"),
									rs.getString("DS_RESULTADO"));
		}
			return new Avaliacao();
		
	}


	/**
	 * Método responsável por criar uma linha na tabela T_SCP_AVALIACAO
	 * @param av Recebe como parametro um Objeto do tipo Avaliacao
	 * @return Retorna uma Avaliacao
	 * @throws Exception chamada da exceção checked SQLException
	 */
	public String gravarDadosAvaliacao(Avaliacao av)throws Exception{
		stmt = con.prepareStatement("INSERT INTO T_SCP_AVALIACAO"
								+ "(CD_AVALIACAO,CD_PSICOLOGO,CD_USUARIO,DT_AVALIACAO,DS_RESULTADO)"
								+ "VALUES(?,?,?,TO_DATE(?,'dd/mm/yyyy'),?)");
		stmt.setInt(1, av.getCodAvaliacao());
		stmt.setInt(2, av.getPsicologo().getCodPsicologo());
		stmt.setInt(3, av.getUsuario().getCodUsuario());
		stmt.setString(4, av.getDataAvaliacao());
		stmt.setString(5, av.getResultado());
		stmt.executeUpdate();
		return "Avaliacao cadastrada com sucesso";
	}
	
	/**
	 * Método responsável por excluir uma linha da tabela T_SCP_AVALIACAO 
	 * @param codAvaliacao Recebe o código da avaliacao para excluir a linha
	 * @return Retorna uma String  informando que a exclusão foi efetuada
	 * @throws Exception chamada da exceção checked SQLException
	 */
	public String excluirAvaliacao(int codAvaliacao)throws Exception{
		stmt = con.prepareStatement("DELETE FROM T_SCP_AVALIACAO WHERE CD_AVALIACAO = ?");
		stmt.setInt(1, codAvaliacao);
		return stmt.executeUpdate() + "linha excluida";
	}
	
	/**
	 * Método responsável por alterar os dados da tabela T_SCP_AVALIACAO
	 * @param av Recebe um Objeto do tipo Avaliacao
	 * @return Retorna uma String informando que a alteração foi feita com sucesso
	 * @throws Exception chamada da exceção checked SQLException
	 */
	public String alterarDadosAvaliacao(Avaliacao av)throws Exception{
		stmt = con.prepareStatement("UPDATE  T_SCP_AVALIACAO SET DT_AVALIACAO = ?, DS_RESULTADO = ? WHERE CD_AVALIACAO = ?");
		stmt.setString(1, av.getDataAvaliacao());
		stmt.setString(2, av.getResultado());
		stmt.setInt(3, av.getCodAvaliacao());
		stmt.executeUpdate();
		return "Alterado com sucesso";
		
	}
	
	
	/**
	 * Método responsável por fechar a conexão com o banco
	 * @author Deschateie
	 * @throws Exception chamada da exceção checked SQLException
	 */
	public void fechar()throws Exception{
		con.close();
	}
}
