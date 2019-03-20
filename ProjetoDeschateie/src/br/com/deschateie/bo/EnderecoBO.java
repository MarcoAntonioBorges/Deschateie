package br.com.deschateie.bo;

import java.util.ArrayList;
import java.util.List;

import br.com.deschateie.beans.Endereco;
import br.com.deschateie.dao.EnderecoDAO;
/**
 *  Classe para validar os dados para tebela T_SCP_ENDERECO
 * possui métodos para criar,pesquisar,alterar e excluir um endereco
 * @author Deschateie
 * @since 1.0
 * @version 1.0
 * @see EnderecoDAO
 * @see Endereco
 *
 */
public class EnderecoBO {
	
	/**
	 * Método responsável por manipular as regras de negócio relacionadas Endereco
	 * Regras avaliadas
	 * 1 Verifica o tamanho do tipo e se não está vazio
	 * 2 Verifica o tamanho do logradouro e se não está vazio
	 * 3 Verifica o tamanho do número e se não está vazio
	 * 4 Verifica o tamanho do complemento
	 * 5 Verifica o tamanho do cep e se não está vazio
	 * 6 Verifica o tamanho do bairro e se não está vazio
	 * 7 Verifica o tamanho da cidade e se não está vazio
	 * 8 Verifica o tamnhao do uf e se não está vazio
	 * 9 Verifica se o codigo do atendente é valido
	 * 10 Verifica se o codigo do endereco é valido
	 * 11 Verifica se o o codigo e o endereco já existe
	 * @param endereco Recebe um Objeto do tipo Endereco do psicolgo
	 * @author Deschateie
	 * @return Retorna uma String informando o erro ou a mensagem de sucesso
	 * @throws Exception chamada de exceção checked SQLException
	 */
	public static String novoEnderecoPsicologo(Endereco endereco)throws Exception {
		
		if(endereco.getTipo().length()>20) {
			return "Quantidade de caracterdes de  Tipo muito grande";
		}
		
		if (endereco.getLogradouro().length()>60) {
			return "Quantidade de caracterdes de  Logradouro muito grande";
		}
		
		if(endereco.getNumero().length()>20) {
			return "Número muito grande";
		}
		
		if (endereco.getComplemento().length()>10) {
			return "Quantidade de caracterdes de  Complemento muito grande";
		}
		
		if (endereco.getCep().length()>99999999) {
			return "Número de CEP muito grande";
		}
		
		if (endereco.getBairro().length()>30) {
			return "Quantidade de caracterdes de Bairro muito grande";
		}
		
		if (endereco.getCidade().length()>30) {
			return "Quantidade de caracterdes de Cidade muito grande";
			
		}
		
		if (endereco.getUf().length()>2) {
			return "Quantidade de caracterdes de  UF muito grande";
			
		}
		
		if (endereco.getCdAtendente()>99999) {
			return "Código do Atendente inválido, excede a quantidade de caracteres permitida";
		}
		
		if (endereco.getCdAtendente()<1) {
			return "Atendente não existe";
		}
		
		if(endereco.getCdEndereco()<1) {
			return "código inválido";
		}
		
		if(endereco.getCdEndereco()>99999) {
			return "Código do endereco inválido, excede a quantidade de caracteres permitida";
		}
		
		
		if(endereco.getTipo().equals(null)) {
			return "O campo tipo não pode estar vazio";
		}
		
		if (endereco.getLogradouro().equals(null)) {
			return "O campo logradouro não pode estar vazio";
		}
		
		if(endereco.getNumero().equals(null)) {
			return "O campo numero não pode estar vazio";
		}
		
		
		
		if (endereco.getCep().length()== 0) {
			return "O campo Cep não pode estar vazio ";
		}
		
		if (endereco.getBairro().equals(null)) {
			return "O campo bairro não pode estar vazio";
		}
		
		if (endereco.getCidade().equals(null)) {
			return "O campo cidade não pode estar vazio";
			
		}
		
		if (endereco.getUf().equals(null)) {
			return "O campo uf não pode estar vazio";
		}	
		
		

		EnderecoDAO dao = new EnderecoDAO();
		Endereco ende = dao.consultarEnderecoPsicologo(endereco.getCdEndereco());
		String msg = null;
		if(ende.getCdEndereco()==0) {
			msg = dao.gravarEnderecoPsicologo(endereco);
			dao.fechar();
			return msg;
		}
		dao.fechar();
		return "Endereco Já existente";
	}

	/**
	 * Método responsável por manipular as regras de negócio relacionadas Endereco
	 * Regras avaliadas
	 * 1 Verifica o tamanho do tipo e se não está vazio
	 * 2 Verifica o tamanho do logradouro e se não está vazio
	 * 3 Verifica o tamanho do número e se não está vazio
	 * 4 Verifica o tamanho do complemento
	 * 5 Verifica o tamanho do cep e se não está vazio
	 * 6 Verifica o tamanho do bairro e se não está vazio
	 * 7 Verifica o tamanho da cidade e se não está vazio
	 * 8 Verifica o tamnhao do uf e se não está vazio
	 * 9 Verifica se o codigo do atendente é valido
	 * 10 Verifica se o codigo do endereco é valido
	 * 11 Verifica se o o codigo e o endereco já existe
	 * @param endereco Recebe um Objeto do tipo Endereco do voluntario
	 * @return Retorna uma String informando o erro ou a mensagem de sucesso
	 * @throws Exception chamada de exceção checked SQLException
	 */
	public static String novoEnderecoVoluntario(Endereco endereco)throws Exception {

		
		if(endereco.getCdEndereco()<1) {
			return "código inválido";
		}
		
		if(endereco.getCdEndereco()>99999) {
			return "Código do endereco inválido, excede a quantidade de caracteres permitida";
		}
		
		if(endereco.getTipo().length()>20) {
			return "Quantidade de caracterdes de  Tipo muito grande";
		}
		
		if (endereco.getLogradouro().length()>60) {
			return "Quantidade de caracterdes de  Logradouro muito grande";
		}
		
		if(endereco.getNumero().length()>20) {
			return "Número muito grande";
		}
		
		if (endereco.getComplemento().length()>10) {
			return "Quantidade de caracterdes de  Complemento muito grande";
		}
		
		if (endereco.getCep().length()>99999999) {
			return "Número de CEP muito grande";
		}
		
		if (endereco.getBairro().length()>30) {
			return "Quantidade de caracterdes de Bairro muito grande";
		}
		
		if (endereco.getCidade().length()>30) {
			return "Quantidade de caracterdes de Cidade muito grande";
			
		}
		
		if (endereco.getUf().length()>2) {
			return "Quantidade de caracterdes de  UF muito grande";
			
		}
		
		if (endereco.getCdAtendente()>99999) {
			return "Código do Atendente inválido";
		}
		
		if (endereco.getCdAtendente()<1) {
			return "Atendente não existe";
		}
		
		
		if(endereco.getTipo().equals(null)) {
			return "O campo tipo não pode estar vazio";
		}
		
		if (endereco.getLogradouro().equals(null)) {
			return "O campo logradouro não pode estar vazio";
		}
		
		if(endereco.getNumero().equals(null)) {
			return "O campo numero não pode estar vazio";
		}
		
		
		
		if (endereco.getCep().length()== 0) {
			return "O campo Cep não pode estar vazio não pode estar vazio";
		}
		
		if (endereco.getBairro().equals(null)) {
			return "O campo bairro não pode estar vazio";
		}
		
		if (endereco.getCidade().equals(null)) {
			return "O campo cidade não pode estar vazio";
			
		}
		
		if (endereco.getUf().equals(null)) {
			return "O campo uf não pode estar vazio";
		}	
		
		

		EnderecoDAO dao = new EnderecoDAO();
		Endereco ende = dao.consultarEnderecoVoluntario(endereco.getCdEndereco());
		String msg = null;
		if(ende.getCdEndereco()==0) {
			msg = dao.gravarEnderecoVoluntario(endereco);
			dao.fechar();
			return msg;
		}
		dao.fechar();
		return "Endereco Já existente";
	}

	/**
	 * Método responsável por manipular as regras de negócio relacionadas Endereco
	 * @param logradouro Recebe uma String com o nome do logradouro
	 * @return Retorna um ArrayList do tipo Endereco do psicologo
	 * @author Deschateie
	 * @throws Exception chamda da exceção checked SQLException
	 */
	public static List<Endereco> pesquisarEnderecoPsicologo(String logradouro)throws Exception{
		
		List<Endereco> listaEndereco = new ArrayList<Endereco>();
		
		EnderecoDAO dao = new EnderecoDAO();
		listaEndereco = dao.consultarPorLogradouroEnderecoPsicologo(logradouro);
		dao.fechar();
		return listaEndereco;
		
	
	}

	/**
	 * Método responsável por manipular as regras de negócio relacionadas Endereco
	 * @param logradouro Recebe uma String com o nome do logradouro
	 * @return Retorna um ArrayList do tipo Endereco do voluntario
	 * @author Deschateie
	 * @throws Exception chamda da exceção checked SQLException
	 */
	public static List<Endereco> pesquisarEnderecoVoluntario(String logradouro)throws Exception{
		List<Endereco> listaEndereco = new ArrayList<Endereco>();
		
		EnderecoDAO dao = new EnderecoDAO();
		listaEndereco = dao.consultarPorLogradouroEnderecoVoluntario(logradouro);
		dao.fechar();
		return listaEndereco;
		
	
	}

	/**
	 * Método responsável por manipular as regras de negócio relacionadas Endereco
	 * Regras avaliada
	 * 1 Verifica se o codigo do endereco é valido
	 * 2 Verifica se o endereco existe
	 * @param cdEndereco Recebe um número inteiro com o codigo do psicologo
	 * @return Retorna uma String informando o erro ou o sucesso caso nenhuma regra seja
	 * quebrada 
	 * @author Deschateie
	 * @throws Exception chamda da exceção checked SQLException
	 */
	public static String excluirEnderecoPsicologo(int cdEndereco)throws Exception{
		if(cdEndereco < 0) {
			return "codigo endereco inválido";
		}
		
		if(cdEndereco > 99999999) {
			return "quantidade de caracteres ultrapassa o permitido ";
		}
		
		EnderecoDAO dao = new EnderecoDAO();
		Endereco endereco = dao.consultarEnderecoPsicologo(cdEndereco);
		
		if(endereco.getCdEndereco()==0) {
			dao.fechar();
			return "não foi possivel localizar um endereco com esse cep para ser apagado";
		}
		
		dao.apagarEndereco(cdEndereco);
		dao.fechar(); 
		return "O endereco foi apagado com sucesso" ;
	}
	
	/**
	 * Método responsável por manipular as regras de negócio relacionadas Endereco
	 * Regra avaliada
	 * 1 Verifica se o codigo do endereco é valido
	 * @param codPsicologo Recebe um número inteiro com o codigo do psicologo
	 * @return Retorna um Objeto do tipo Endereco 
	 * @author Deschateie
	 * @throws Exception chamda da exceção checked SQLException
	 */
	public static Endereco pesquisarEnderecoCodPsicologo(int codPsicologo)throws Exception{
		if (codPsicologo<1) {
			return new Endereco();
		}
		
		if (codPsicologo>99999) {
			return new Endereco();
		}
		
		EnderecoDAO dao = new EnderecoDAO();
		Endereco e = new Endereco();
		e = dao.consultarEnderecoCodPsicologo(codPsicologo);
		dao.fechar();
		return e;
	}
	
	/**
	 * Método responsável por manipular as regras de negócio relacionadas Endereco
	 * Regra avaliada
	 * 1 Verifica se o codigo do endereco é valido
	 * @param codVoluntario Recebe um número inteiro com o codigo do voluntario
	 * @return Retorna um Objeto do tipo Endereco
	 * @author Deschateie
	 * @throws Exception chamda da exceção checked SQLException
	 */
	public static Endereco pesquisarEnderecoCodVoluntario(int codVoluntario)throws Exception{
		if (codVoluntario<1) {
			return new Endereco();
		}
		
		if (codVoluntario>99999) {
			return new Endereco();
		}
		
		EnderecoDAO dao = new EnderecoDAO();
		Endereco e = new Endereco();
		e = dao.consultarEnderecoCodVoluntario(codVoluntario);
		dao.fechar();
		return e;
	}
	


	/**
	 * Método responsável por manipular as regras de negócio relacionadas Endereco
	 * Regras avaliadas
	 * 1 Verifica o tamanho do tipo e se não está vazio
	 * 2 Verifica o tamanho do logradouro e se não está vazio
	 * 3 Verifica o tamanho do número e se não está vazio
	 * 4 Verifica o tamanho do complemento
	 * 5 Verifica o tamanho do cep e se não está vazio
	 * 6 Verifica o tamanho do bairro e se não está vazio
	 * 7 Verifica o tamanho da cidade e se não está vazio
	 * 8 Verifica o tamnhao do uf e se não está vazio
	 * 9 Verifica se o codigo do atendente é valido
	 * 10 Verifica se o codigo do endereco é valido
	 * 11 Verifica se o o codigo e o endereco já existe
	 * @param endereco Recebe um Objeto do tipo Endereco do psicologo
	 * @return Retorna uma String informando o erro ou a mensagem de sucesso
	 * @author Deschateie
	 * @throws Exception chamada de exceção checked SQLException
	 */
	public static String alterarDadosEnderecoPsicologo(Endereco endereco)throws Exception{
		
		if(endereco.getCdEndereco()<1) {
			return "código inválido";
		}
		
		if(endereco.getCdEndereco()>99999) {
			return "Código do endereco inválido, excede a quantidade de caracteres permitida";
		}
		if(endereco.getTipo().length()>20) {
			return "Quantidade de caracterdes de  Tipo muito grande";
		}
		
		if (endereco.getLogradouro().length()>60) {
			return "Quantidade de caracterdes de  Logradouro muito grande";
		}
		
		if(endereco.getNumero().length()>20) {
			return "Número muito grande";
		}
		
		if (endereco.getComplemento().length()>10) {
			return "Quantidade de caracterdes de  Complemento muito grande";
		}
		
		if (endereco.getCep().length()>99999999) {
			return "Número de CEP muito grande";
		}
		
		if (endereco.getBairro().length()>30) {
			return "Quantidade de caracterdes de Bairro muito grande";
		}
		
		if (endereco.getCidade().length()>30) {
			return "Quantidade de caracterdes de Cidade muito grande";
			
		}
		
		if (endereco.getUf().length()>2) {
			return "Quantidade de caracterdes de  UF muito grande";
			
		}
		
		if (endereco.getCdAtendente()>99999) {
			return "Código do Atendente inválido";
		}
		
		if (endereco.getCdAtendente()<1) {
			return "Atendente não existe";
		}
		
		
		if(endereco.getTipo().equals(null)) {
			return "O campo tipo não pode estar vazio";
		}
		
		if (endereco.getLogradouro().equals(null)) {
			return "O campo logradouro não pode estar vazio";
		}
		
		if(endereco.getNumero().equals(null)) {
			return "O campo numero não pode estar vazio";
		}
		
		
		
		if (endereco.getCep().length()== 0) {
			return "O campo Cep não pode estar vazio não pode estar vazio";
		}
		
		if (endereco.getBairro().equals(null)) {
			return "O campo bairro não pode estar vazio";
		}
		
		if (endereco.getCidade().equals(null)) {
			return "O campo cidade não pode estar vazio";
			
		}
		
		if (endereco.getUf().equals(null)) {
			return "O campo uf não pode estar vazio";
		}
		
		EnderecoDAO dao = new EnderecoDAO();
		Endereco ende = new Endereco();
		
		ende = dao.consultarEnderecoPsicologo(endereco.getCdEndereco());
		
		if(ende.getCdEndereco() != 0) {
			String resp = dao.alterarEnderecoPsicologo(endereco);
			dao.fechar();
			return resp;
		}
		
		dao.fechar();
		return "código de endereco não encontrado";
		
		
		
		
		
	}
	
	/**
	 * Método responsável por manipular as regras de negócio relacionadas Endereco
	 * Regras avaliadas
	 * 1 Verifica o tamanho do tipo e se não está vazio
	 * 2 Verifica o tamanho do logradouro e se não está vazio
	 * 3 Verifica o tamanho do número e se não está vazio
	 * 4 Verifica o tamanho do complemento
	 * 5 Verifica o tamanho do cep e se não está vazio
	 * 6 Verifica o tamanho do bairro e se não está vazio
	 * 7 Verifica o tamanho da cidade e se não está vazio
	 * 8 Verifica o tamnhao do uf e se não está vazio
	 * 9 Verifica se o codigo do atendente é valido
	 * 10 Verifica se o codigo do endereco é valido
	 * 11 Verifica se o o codigo e o endereco já existe
	 * @param endereco Recebe um Objeto do tipo Endereco do voluntario
	 * @return Retorna uma String informando o erro ou a mensagem de sucesso
	 * @author Deschateie 
	 * @throws Exception chamada de exceção checked SQLException
	 */	
	public static String alterarDadosEnderecoVoluntario(Endereco endereco)throws Exception{

		
		
		if(endereco.getCdEndereco()<1) {
			return "código inválido";
		}
		
		if(endereco.getCdEndereco()>99999) {
			return "Código do endereco inválido, excede a quantidade de caracteres permitida";
		}
		
		if(endereco.getTipo().length()>20) {
			return "Quantidade de caracterdes de  Tipo muito grande";
		}
		
		if (endereco.getLogradouro().length()>60) {
			return "Quantidade de caracterdes de  Logradouro muito grande";
		}
		
		if(endereco.getNumero().length()>20) {
			return "Número muito grande";
		}
		
		if (endereco.getComplemento().length()>10) {
			return "Quantidade de caracterdes de  Complemento muito grande";
		}
		
		if (endereco.getCep().length()>99999999) {
			return "Número de CEP muito grande";
		}
		
		if (endereco.getBairro().length()>30) {
			return "Quantidade de caracterdes de Bairro muito grande";
		}
		
		if (endereco.getCidade().length()>30) {
			return "Quantidade de caracterdes de Cidade muito grande";
			
		}
		
		if (endereco.getUf().length()>2) {
			return "Quantidade de caracterdes de  UF muito grande";
			
		}
		
		if (endereco.getCdAtendente()>99999) {
			return "Código do Atendente inválido";
		}
		
		if (endereco.getCdAtendente()<1) {
			return "Atendente não existe";
		}
		
		
		if(endereco.getTipo().equals(null)) {
			return "O campo tipo não pode estar vazio";
		}
		
		if (endereco.getLogradouro().equals(null)) {
			return "O campo logradouro não pode estar vazio";
		}
		
		if(endereco.getNumero().equals(null)) {
			return "O campo numero não pode estar vazio";
		}
		
		
		
		if (endereco.getCep().length()== 0) {
			return "O campo Cep não pode estar vazio não pode estar vazio";
		}
		
		if (endereco.getBairro().equals(null)) {
			return "O campo bairro não pode estar vazio";
		}
		
		if (endereco.getCidade().equals(null)) {
			return "O campo cidade não pode estar vazio";
			
		}
		
		if (endereco.getUf().equals(null)) {
			return "O campo uf não pode estar vazio";
		}

		EnderecoDAO dao = new EnderecoDAO();
		Endereco ende = new Endereco();
		
		ende = dao.consultarEnderecoVoluntario(endereco.getCdEndereco());
		
		if(ende.getCdEndereco() != 0) {
			String resp = dao.alterarEnderecoVoluntario(endereco);
			dao.fechar();
			return resp;
		}
		
		
		
		dao.fechar();
		return "código de endereco não encontrado";
		
	}
		
	}
	
	

