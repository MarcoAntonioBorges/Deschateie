package br.com.deschateie.bo;

import java.util.ArrayList;
import java.util.List;

import br.com.deschateie.beans.Consulta;
import br.com.deschateie.beans.Paciente;
import br.com.deschateie.dao.PacienteDAO;
/**
 *  Classe para validar os dados para tebela T_SCP_PACIENTE
 * possui métodos para criar,pesquisar,alterar e excluir um paciente
 * @author Deschateie
 * @since 1.0
 * @version 1.0
 * @see Consulta
 * @see ConsultaBO
 * @see Paciente
 * @see PacienteDAO
 *
 */
public class PacienteBO {
	
	/**
	  * Método responsável por manipular as regras de negócio relacionadas Paciente
	 * Regras avaliadas
	 * Verifica se o codigo do paciente é valido
	 * @param codPaciente Recebe um número inteiro do codigo do paciente
	 * @return Retorna um Objeto do tipo Paciente
	 * @author Deschateie
	 * @throws Exception chamada da exceção checked SQLException
	 */
	public static Paciente pesquisarPaciente(int codPaciente)throws Exception{
		
		if(codPaciente <0) {
			return new Paciente();
		}
		if(codPaciente> 99999) {
			return new Paciente();
		}
		
		PacienteDAO dao = new PacienteDAO();
		
		Paciente p = dao.consultarPaciente(codPaciente);
		dao.fechar();
		return p;
		
		
		
	}

	/**
	  * Método responsável por manipular as regras de negócio relacionadas Paciente
	 * Regras avaliadas
	 * 1 Verifica se o codigo do paciente é válido
	 * 2 Vericia se o tamanho do cep á válido
	 * 3 Verifica se o tamanho do histórico é válido
	 * 4 Verifica se as quantidades de consultas realizadas são válidas
	 * 5 Verifica se O paciente já é cadastrado no sistema atraves do segundo parâmetro que é passado
	 * 6 Verifica se o código passado do paciente passado já existe
	 * 7 Verifica se a usuario que está se cadastrando como voluntario já faz parte da plataforma ou não,
	 * se ele fizer ele vai apenas complementar os dados mas, se não fizer será necessário cadastrar todos os dados dele
	 * @param p Recebe um Objeto do tipo Paciente
	 * @param ehvalido Verifica se a pessoas que quer se tornar paciente já está cadastrada na plataforma
	 * @return Retorna uma String informando um erro ou sucesso caso nenhuma das regras acima seja quebrada
	 * @author Deschateie
	 * @throws Exception chamada da exceção checked SQLException
	 */
	public static String novoPaciente(Paciente p,boolean ehvalido)throws Exception{
		
		
		
		
		if(p.getCodPaciente()<1) {
			return "código inválido";
		}
		
		if (p.getCodPaciente()>99999) {
			return "código muito grande";
		}
		
		if(p.getCep().length()>99999999) {
			return "cep muito grande";
		}
		
		if(p.getCep().length()<1) {
			return "cep inválido";
		}
			
		if(p.getHistorico().length()>2000) {
			return "histórico muito grande";
		}
		
		if(p.getHistorico().length()<1) {
			p.setHistorico(" ");
		}
		
		if(p.getConsultasReazlizadas()>999) {
			return "consulta muito grande";
		}
		
		if(p.getConsultasReazlizadas()<1) {
			return "a quantidade de consultas não pode estar vazia";
		}
		
		p.setNivelPermissao(1);
		if(ehvalido==false) {
			String status = UsuarioBO.novoUsuario(p);
			
			if(!status.equals("Usuário cadastrado com Sucesso")) {
				
				return status;
			}
			
		
			
		}
		
		
		UsuarioBO.alterarNivelAcesso(p);	
		
		if(UsuarioBO.pesquisarUsuarioPorCod(p.getCodUsuario()).getCodUsuario()==0) {
			return "Usuario nao encontrado";
		}
		
		if(pesquisarPaciente(p.getCodPaciente()).getCodPaciente()>0) {
			return "O codigo do paciente ja existe";
		}
		
		PacienteDAO dao = new PacienteDAO();
		dao.gravarPaciente(p);
		dao.fechar();
		return "Cadastrado com suceso";
	}
	
	/**
	  * Método responsável por manipular as regras de negócio relacionadas Paciente
	 * Regras avaliadas
	 * 1 Verifica se o codigo do paciente é válido
	 * 2 Verifica se o paciente existe
	 * @param codPaciente Recebe um número inteiro do codigo do paciente
	 * @return Retorna uma String informando um erro ou sucesso caso nenhuma das regras acima seja quebrada
	 * @author Deschateie
	 * @throws Exception chamada da exceção checked SQLException
	 */
	public static String excluirPaciente(int codPaciente)throws Exception{
		
		if(codPaciente<1) {
			return "código inválido";
		}
		
		if(codPaciente> 99999) {
			return "código muito grande";
		}
		
		PacienteDAO dao = new PacienteDAO();
		Paciente p = dao.consultarPaciente(codPaciente);
		
		if(p.getCodPaciente()<1) {
			return "nao foi possivel encontrar o paciente";
		}
		
		
		dao.excluirPaciente(codPaciente);
		dao.fechar();
		return "excluido com sucesso";
	}
	/**
	 * Método responsável por manipular as regras de negócio relacionadas Paciente
	 * Regras avaliadas
	 * 1 Verifica se o codigo do paciente é válido
	 * 2 Vericia se o tamanho do cep á válido
	 * 3 Verifica se o tamanho do histórico é válido
	 * 4 Verifica se as quantidades de consultas realizadas são válidas
	 * 5 Verifica se O paciente já é cadastrado no sistema atraves do segundo parâmetro que é passado
	 * 6 Caso o a pessoa que está prestes a se tornar um paciente já esteja cadastrada no sistema será verificado
	 * se o código de usuario dele existe no sistema
	 * 7 Verifica se o código passado do paciente passado já existe
	 * @param p Recebe um Objeto do tipo Paciente
	 * @return Retorna uma String informando um erro ou sucesso caso nenhuma das regras acima seja quebrada
	 * @author Deschateie
	 * @throws Exception chamada da exceção checked SQLException
	 */
	public static String alterarDadosPaciente(Paciente p)throws Exception{
		
		
		
		
		
		if(p.getCep().length()>99999999) {
			return "cep muito grande";
		}
		
		if(p.getCep().length()<1) {
			return "cep inválido";
		}
			
		if(p.getHistorico().length()>2000) {
			return "histórico muito grande";
		}
		
		PacienteDAO dao = new PacienteDAO();
		Paciente pa = new Paciente();
		
		if(dao.consultarPaciente(p.getCodPaciente()).getCodPaciente()<1) {
			return "nao foi possivel achar esse codigo no banco";
		}
		
		String status = UsuarioBO.AlterarDadosUsuario(p);
		
		if(!status.equals("Usuário alterado com Sucesso")) {
			System.out.println(dao.consultarPaciente(p.getCodPaciente()).getAll());
			return status;
		}
		
	
		
		if(p.getCpf() != pa.getCpf()) {
			if(p.getCpf() == dao.consultarPacienteCpf(pa.getCpf()).getCpf()) {
				dao.fechar();
				return "cpf já existe";			}
		}
		
		
		dao.AlteraDadosPaciente(p);
		dao.fechar();
		return "alterado com sucesso";
		
	}
	
	/**
	 * Método responsável por manipular as regras de negócio relacionadas Paciente
	 * Regras avaliadas
	 * 1 Verificar se o paciente já está na lista, caso esteja
	 * o mesmo não será adicionado
	 * @return Retorna um ArrayList do tipo Paciente
	 * @author Deschateie
	 * @throws Exception chamada da exceção checked SQLException
	 */
	public static List<Paciente> pesquisarPacienteConsulta()throws Exception{
		
		boolean isTrueP = false;
		List<Consulta> listaConsultas = new ArrayList<Consulta>();
		List<Paciente> listaPacientes = new ArrayList<Paciente>();
		List<Consulta> listaConsultPaciente = new ArrayList<Consulta>();

		
		listaConsultas = ConsultaBO.pesquisarConsulta();
		
		Paciente paciente;
		for (Consulta consultas: listaConsultas) {
			paciente = PacienteBO.pesquisarPaciente(consultas.getCodPaciente());
			for(Consulta x : listaConsultPaciente) {
				if(x.getCodPaciente() == paciente.getCodPaciente()) {
					isTrueP = true;
					break;
				}
			}
			if(!isTrueP) {
				listaConsultPaciente.add(consultas);
			}
			isTrueP = false;
		}
		
		for (Consulta consulta : listaConsultPaciente) {
			listaPacientes.add(PacienteBO.pesquisarPaciente(consulta.getCodPaciente()));
		}
		
	return listaPacientes;
	}

}
