package br.com.deschateie.bo;


import br.com.deschateie.beans.Avaliacao;
import br.com.deschateie.beans.Psicologo;
import br.com.deschateie.beans.Usuario;
import br.com.deschateie.dao.AvaliacaoDAO;
/**
 * Classe para validar dados para tabela T_SCP_AVALIACAO
 * possui métodos para criar,excluir,alterar e pesquisar Avaliacao
 * @author Deschateie
 * @version 1.0
 * @since 1.0
 * @see DataBO
 * @see Psicologo
 * @see Usuario
 *
 */
public class AvaliacaoBO {
	
	/**
	 * Método responsavel por manipular as regras de negócio relacionadas a Avaliacao
	 * Regras a serem avaliada
	 * 1 O tamanho do código da avaliação
	 * @param codAvaliacao Recebe o código da avaliação que é um número inteiro 
	 * @return Retorna uma Avaliacao, que pode estar vazia se o código for inválido ou
	 * se a avaliacao não for encontrada e estar preenchida caso o código seja válido
	 * @throws Exception Exceção do tipo checkd SQLException
	 */
	public static Avaliacao pesquisarAvaliacao(int codAvaliacao) throws Exception{
		
		if (codAvaliacao<1) {
			return new Avaliacao();
		}
		
		if (codAvaliacao>99999) {
			return new Avaliacao();
		}
		
		
		AvaliacaoDAO  dao = new AvaliacaoDAO(); 	 
		Avaliacao avaliacao = dao.consultarAvaliacao(codAvaliacao);		
		dao.fechar();
		return avaliacao;
	}

	/**
	 * Método responsável por manipular as regras de negócio relacionadas a  Avaliacao
	 * Regras a serem avaliadas
	 * 1 Tamanho do código da avaliacao
	 * 2 Tamanho com campo resultado
	 * 3 Verifica se a data informada é válida
	 * 4 Verificar se o código da avaliacao que está sendo passar já existe
	 * 5 Verifica se o código do psicologo ou voluntario passado é valido 
	 * 6 verifica se o psicologo ou usuario existe
	 * 7 Define um nível de acesso temporário para o usuario até ele ser avaliado
	 * 8 Verifica se o usuário já fez alguma avaliação antes
	 * 9 Verificar se o usuario que está sendo cadastrado pretende se tornar um
	 * voluntario ou psicologo online, sendo o nivel de acesso no voluntario 7
	 * e o nivel de acesso do psicologo 6
	 * @param av Recebe uma um objeto do tipo Avaliacao
	 * @return Retorna uma String, podendo conter a mensagem de sucesso ou de erro se 
	 *  se a avaliacao passada não estiver de acordo com as regras acima
	 * @throws Exception Exceção do tipo checked SQLException
	 */
	public static String novaAvaliacao(Avaliacao av)throws Exception{
		
		if (av.getCodAvaliacao()<0) {
			return "codigo invalido";
		}
		
		if (av.getCodAvaliacao()>99999) {
			return "codigo muito grande"; 
		}
		if (av.getResultado().length()<0) {
			return "O campo resultado não pode esta vazio";
		}
		
		if(av.getResultado().length()>80) {
			return "resultado muito grande";
		}
		
		String status = DataBO.validarData(av.getDataAvaliacao());
		if(!status.equals(av.getDataAvaliacao())) {
			return status;
		}
		
		Avaliacao avu = pesquisarAvaliacao(av.getCodAvaliacao());
		if(avu.getCodAvaliacao()== av.getCodAvaliacao()) {
			return "codigo de avaliacao ja existente";
		}
		

		
		Usuario usuario = UsuarioBO.pesquisarUsuarioPorCod(av.getUsuario().getCodUsuario());
		Psicologo psicologo = PsicologoBO.pesquisarPsicologo(av.getPsicologo().getCodPsicologo());
		if(usuario.getCodUsuario()!= av.getUsuario().getCodUsuario()) {
			return "o codigo do usuairo nao foi encontrado";
		}
		
		if(psicologo.getCodPsicologo()!= av.getPsicologo().getCodPsicologo()) {
			return "o codigo do psicologo nao foi encontrado";
		}
		
		
		AvaliacaoDAO dao = new AvaliacaoDAO();
		
		if (dao.consultarAvaliacaoUsuario(av.getUsuario().getCodUsuario()).getUsuario().getCodUsuario()
				== av.getUsuario().getCodUsuario()) {
			return "Esse usuario já fez avalição";
		}
		
		if(avu.getUsuario().getNivelPermissao()== 6 ||avu.getUsuario().getNivelPermissao()==7) {
			return "os niveis de permissão precisam estar entre 6 e 7, pois ambos são temporarios";
		}
		avu.getUsuario().setNivelPermissao(avu.getUsuario().getNivelPermissao());
		UsuarioBO.alterarNivelAcesso(avu.getUsuario());
		
		dao.gravarDadosAvaliacao(av);
		dao.fechar();
		return "Avaliacao cadastrada com sucesso";
	}

	
	/**Método responsável por manipular as regras de negócio relacionadas a  Avaliacao
	 * Regras a serem avaliadas
	 * 1 Verifica o tamnho do código da avaliação
	 * 2 Verificar se a avaliação existe através do código 
	 * @param codAvaliacao Recebe o código da avaliação
	 * @return Retorna uma String, podendo conter uma mensagem de suceso ou de erro caso 
	 *  alguma regra de negócio não seja cumprida
	 * @throws Exception Exceção do tipo checked SQLException
	 */
	public static String excluirAvaliacaoVoluntario(int codAvaliacao)throws Exception{
		if(codAvaliacao<0) {
			return "codigo invalido";
		}
		
		if (codAvaliacao>99999) {
			return "codigo muito grande";
		}
		
		Avaliacao av = pesquisarAvaliacao(codAvaliacao);
		
		if(av.getCodAvaliacao()<1) {
			return "codigo nao existe";
		}
		
		AvaliacaoDAO dao = new AvaliacaoDAO();
		dao.excluirAvaliacao(codAvaliacao);
		dao.fechar();
		return "Excluido com sucesso";
	}

	/**
	 * Método responsável por manipular as regras de negócio relacionadas a  Avaliacao
	 * Regras a serem avaliadas
	 * 1 Verifica se a data é valida
	 * 2 Verifica se a qunantidade de caracteres do resultado é valido
	 * 3 Verifica se a avaliação existe
	 * 4 Verificar se o usuario que está sendo cadastrado pretende se tornar um
	 * voluntario ou psicologo online, sendo o nivel de acesso no voluntario 7
	 * e o nivel de acesso do psicologo 6
	 * 5 Verifica se o código da avaliação é valido
	 * @param av Recebe um Objeto do tipo Avaliacao
	 * @return Retorna uma String
	 * @throws Exception chamada exceção checked SQLException
	 */
	public static String alterarDadosAvaliacao(Avaliacao av)throws Exception {
		
		if (av.getCodAvaliacao()<1) {
			return "Código invalido";
		}
		
		if (av.getCodAvaliacao()>99999) {
			return "codigo muito grande";
		}
		
		String status = DataBO.validarData(av.getDataAvaliacao());
		if(!status.equals(av.getDataAvaliacao())) {
			return status;
		}
		
		if(av.getResultado().length()<0) {
			return "resultado nao pode estar vazio";
		}
		
		if (av.getResultado().length()>80) {
			return "resultado muito grande";
		}
		
		Avaliacao ava = pesquisarAvaliacao(av.getCodAvaliacao());
		if(ava.getCodAvaliacao()==0) {
			return "Avaliacao não encontradao";
		}
		
		
		if(av.getUsuario().getNivelPermissao()< 6 ||av.getUsuario().getNivelPermissao()>7) {
			return "  ambos já foram avaliados, não será possível mudar os dados";
		}
		
		
		
		AvaliacaoDAO dao = new AvaliacaoDAO();
		dao.alterarDadosAvaliacao(av);
		dao.fechar();
		return "Dados Alterados com suceso";
	}
	
	
	/**
	 * Método responsável por manipular as regras de negócio relacionadas a  Avaliacao
	 * Regras a serem avaliadas
	 * 1 Verifica se o código da avaliação é valido
	 * 2 Verifica se existe alguma avaliacao com o codigo passado
	 * 3 Verifica se a quantidade de caracteres do resultado é valida
	 * 4 Verifica se o usuario que está sendo avaliado quer se tornar um psicologo ou paciente
	 * e inseri o nivel de acesso caso usuario queria se tornar psicologo 
	 * o nivel é 3 e se quiser ser voluntario o nivel é 2
	 * @param av Recebe um Objeto do tipo Avaliacao
	 * @return Retorna uma String, podendo conter uma mesagem de erro caso
	 * algumas das regras acima não sejam seguidas ou  uma mensagem de sucesso 
	 * @throws Exception Exceção do tipo checked SQLException
	 */
	public static String avaliar(Avaliacao av)throws Exception{
		
		if (av.getCodAvaliacao()<1) {
			return "Código invalido";
		}
		
		if (av.getCodAvaliacao()>99999) {
			return "codigo muito grande";
		}
		
		if (av.getResultado().length()<1) {
			return "O campo resultado não pode estar vazio";
		}
		
		if (av.getResultado().length()>80) {
			return "O campo resultado está muito grande";
		}
		
		if (av.getUsuario().getNivelPermissao() == 6) {
			av.getUsuario().setNivelPermissao(3);
			UsuarioBO.alterarNivelAcesso(av.getUsuario());
		}else {
			av.getUsuario().setNivelPermissao(2);
			UsuarioBO.alterarNivelAcesso(av.getUsuario());
		}
		
		if (pesquisarAvaliacao(av.getCodAvaliacao()).getCodAvaliacao() == 0) {
			return "Avaliação não encontrada";
		}
			
		AvaliacaoDAO dao = new AvaliacaoDAO();
		String msg = dao.avaliar(av);
		dao.fechar();
		return msg;
	}
	
}
