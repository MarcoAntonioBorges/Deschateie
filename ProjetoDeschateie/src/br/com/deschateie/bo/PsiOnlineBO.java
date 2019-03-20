package br.com.deschateie.bo;

import java.util.ArrayList;
import java.util.List;

import br.com.deschateie.beans.Consulta;
import br.com.deschateie.beans.PsiOnline;
import br.com.deschateie.dao.PsiOnlineDAO;

/**
 *  Classe para validar os dados para tebela T_SCP_PSI_ONLINE
 * possui m�todos para criar,pesquisar,alterar e excluir um PsiOnline
 * @author Deschateie
 * @since 1.0
 * @version 1.0
 * @see PsiOnline
 * @see PsiOnlineDAO
 */
public class PsiOnlineBO {
	
	/**
	  * M�todo respons�vel por manipular as regras de neg�cio relacionadas PsiOnline
	 * Regras avaliadas
	 * Verifica se o codigo do psicologo online � valido
	 * @param codPsi Recebe um n�mero inteiro do codigo do PsiOnline
	 * @return Retorna um Objeto do tipo PsiOnline
	 * @author Deschateie
	 * @throws Exception chamada da exce��o checked SQLException
	 */
	public static PsiOnline pesquisarPsicologoOnline(int codPsi)throws Exception {
		
		if(codPsi <1) {
			return new PsiOnline();
		}
		
		if(codPsi>99999) {
			return new PsiOnline();
		}
		
		PsiOnlineDAO dao = new PsiOnlineDAO();
		PsiOnline ps = dao.consultarPsiOnline(codPsi);
		dao.fechar();
		return ps;
	}
	
	/**
	 * M�todo respons�vel por manipular as regras de neg�cio relacionadas PsiOnline
	 * @return Retorna um ArrayList do tipo PsiOnline apenas com os PsiOnline tempor�rio
	 * @author Deschateie
	 * @throws Exception chamada da exce��o checked SQLException
	 */
	public static List<PsiOnline> pesquisarPsicologosOnlineTemporario()throws Exception{
		List<PsiOnline> listaPsi = new ArrayList<PsiOnline>();
		PsiOnlineDAO dao = new PsiOnlineDAO();
		listaPsi = dao.consultarPsiOnline();
		dao.fechar();
		return listaPsi;
	}
	
	
	/**
	 * M�todo respons�vel por manipular as regras de neg�cio relacionadas PsiOnline
	 * Regras avaliadas
	 * 1 Verifica se o c�digo do PsiOnline � valido
	 * 2 Verifica o tamanho da formacao
	 * 3 Verifica o tamanha da forma de atendimento
	 * 4 Verifica o tamanha da nota de atendimento
	 * 5 Verifica a quantidade de atendimentos
	 * 6  Verifica se o usuario que est� se cadastrando como PsiOnline j� faz parte da plataforma ou n�o,
	 * se ele fizer ele vai apenas complementar os dados mas, se n�o fizer ser� necess�rio cadastrar todos os dados dele
	 * 7 Verifica se o usuario que foi passado existe
	 * @param psi Recebe um Objeto do tipo PsiOnline
	 * @param ehValido Recebe um boolean para validar uma regra de neg�cio
	 * @return Retorna uma Stirng informando uma mensagem de erro ou sucesso se nenhuma das regras 
	 * acima for quebrada
	 * @throws Exception chamada da exce��o checked SQLException
	 */
	public static String novoPsicologoOnline(PsiOnline psi, boolean ehValido)throws Exception {
		
		if (psi.getPeriodo().length()<0) {
			return "O periodo nao pode estar vazio";
		}
		
		if(psi.getPeriodo().length()>40) {
			return "periodo muito grande";
		}
		
		if (psi.getFormaAtendimento().length()<0) {
			return "A forma de atendimento nao pode estar vazia";
		}
		
		if (psi.getFormaAtendimento().length()>40) {
			return "forma de atendimento muito grande";
		}
		
		if (psi.getNotaAtendimento()<1) {
			return "nota invalida";
		}
		
		if (psi.getNotaAtendimento()>5) {
			return "nota atendimento deve estar entre 1 e 5";
		}
		
		if (psi.getQtdeAtendimentos()<0) {
			return "quantidade de atendimentos invalidos";
		}
		
		if (psi.getQtdeAtendimentos()>9999) {
			return "atendimento muito grande";
		}
		
		
		psi.setNivelPermissao(6);
		if (!ehValido) {
			String status = PsicologoBO.NovoPsicologo(psi,ehValido);
			 if (!status.equals("Psicologo cadastrado com Sucesso")) {
					return status;
				}
		}
		
		UsuarioBO.alterarNivelAcesso(psi);
		
		if(UsuarioBO.pesquisarUsuarioPorCod(psi.getCodUsuario()).getCodUsuario()==0) {
			return "Usuario nao encontrado";
		}
		
		 
		
		 
		 PsiOnlineDAO dao = new PsiOnlineDAO();
		 dao.gravarPsiOnline(psi);
		 dao.fechar();
		 return "Psicologo online cadastrado com  sucesso";
	}

	/**
	 * M�todo respons�vel por manipular as regras de neg�cio relacionadas PsiOnline
	 * Regras Avaliada
	 * 1 Verifica se o codigo do Psionline � valido
	 * 2 Verifica se o PsiOnline existe
	 * @param codPsi Recebe um n�mero inteiro do codigo do PsiOnlines
	 * @return Retorna uma String informando um erro ou sucesso caso nenhuma das regras acima 
	 * sejam quebradas
	 * @author Deschateie
	 * @throws Exception chamada da exce��o checked SQLException
	 */
	public static String excluirPsicologoOnline(int codPsi)throws Exception{
		if(codPsi<1) {
			return "codigo invalido";
		}
		
		if (codPsi>99999) {
			return "codigo muito grande";
		}
		
		if(pesquisarPsicologoOnline(codPsi).getCodPsicologo()<1) {
			return "PsiOnline n�o encontrado";
		}
		
		PsiOnlineDAO dao = new PsiOnlineDAO();
		String msg = dao.excluirPsiOnline(codPsi);
		PsicologoBO.excluirPsicologo(codPsi);
		return msg;
		
	}
	
	/**
	 * M�todo respons�vel por manipular as regras de neg�cio relacionadas PsiOnline
	 * Regras avaliadas
	 * 1 Verifica se o c�digo do PsiOnline � valido
	 * 2 Verifica o tamanho da formacao
	 * 3 Verifica o tamanha da forma de atendimento
	 * 4 Verifica o tamanha da nota de atendimento
	 * 5 Verifica a quantidade de atendimentos
	 * 7 Verifica se o usuario que foi passado existe
	 * @param psi Recebe um Objeto do tipo PsiOnline
	 * @return Retorna uma Stirng informando uma mensagem de erro ou sucesso se nenhuma das regras 
	 * acima for quebrada
	 * @throws Exception chamada da exce��o checked SQLException
	 */
	public static String AlterarDadosPsicologo(PsiOnline psi)throws Exception{
		if (psi.getPeriodo().length()<0) {
			return "O periodo nao pode estar vazio";
		}
		
		if(psi.getPeriodo().length()>40) {
			return "periodo muito grande";
		}
		
		if (psi.getFormaAtendimento().length()<0) {
			return "A forma de atendimento nao pode estar vazia";
		}
		
		if (psi.getFormaAtendimento().length()>40) {
			return "forma de atendimento muito grande";
		}
		
		if (psi.getNotaAtendimento()<1) {
			return "nota invalida";
		}
		
		if (psi.getNotaAtendimento()>5) {
			return "nota atendimento deve estar entre 1 e 5";
		}
		
		if (psi.getQtdeAtendimentos()<0) {
			return "quantidade de atendimentos invalidos";
		}
		
		if (psi.getQtdeAtendimentos()>9999) {
			return "atendimento muito grande";
		}

		String status = PsicologoBO.AlterarDadosPsicologo(psi);
		if(!status.equals("Psicologo atualizado com Sucesso")) {
			return status;
		}
		
		PsiOnlineDAO dao = new PsiOnlineDAO();
		dao.alterarDadosPsiOnline(psi);
		dao.fechar();
		return "Psicologo Online atualizado com Sucesso";
	}
	
	/**
	 * M�todo respons�vel por manipular as regras de neg�cio relacionadas PsiOnline
	 * @return Retorna um ArrayList do tipo PsiOnline que est�o j� fizeram alguma consulta
	 * @author Deschateie
	 * @throws Exception chamada da exce��o checked SQLException
	 */
	public static List<PsiOnline> pesquisarPsiOnlineConsulta()throws Exception{
		boolean isTruePsi = false;
		List<Consulta> listaConsultas = new ArrayList<Consulta>();
		List<PsiOnline> listaPsiOnlines = new ArrayList<PsiOnline>();
		List<Consulta> listaConsultPsiOn = new ArrayList<Consulta>();
		listaConsultas = ConsultaBO.pesquisarConsulta();
		PsiOnline psiOnline;
		
		for (Consulta consultas: listaConsultas) {
			psiOnline = PsiOnlineBO.pesquisarPsicologoOnline(consultas.getCodPsiOnline());
			
			for(Consulta x : listaConsultPsiOn) {
				if(x.getCodPsiOnline() == psiOnline.getCodPsicologo()) {
					isTruePsi = true;
					break;
				}
			}
			
			if(!isTruePsi) {
				listaConsultPsiOn.add(consultas);
			}
			isTruePsi = false;
			
		}
		
		
		
		for (Consulta consulta : listaConsultPsiOn) {
			listaPsiOnlines.add(PsiOnlineBO.pesquisarPsicologoOnline(consulta.getCodPsiOnline()));
		}
		
		
		return listaPsiOnlines;
				
		
	}	

}