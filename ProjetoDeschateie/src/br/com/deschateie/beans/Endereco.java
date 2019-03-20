package br.com.deschateie.beans;


public class Endereco implements Comparable <Endereco> {
	
	private int cdEndereco;
	private int cdAtendente;
	private String tipo;
	private String logradouro;
	private String numero;
	private String complemento;
	private String cep;
	private String bairro;
	private String cidade;
	private String uf;
	private String pais;
	
	
	public Endereco() {
		
	}
	
	
	
	public Endereco(int cdEndereco, int cdAtendente ,String tipo, String logradouro, String numero,
			String complemento, String cep, String bairro, String cidade, String uf, String pais) {
		setCdEndereco(cdEndereco);
		setCdAtendente(cdAtendente);
		setTipo(tipo);
		setLogradouro(logradouro);
		setNumero(numero);
		setComplemento(complemento);
		setCep(cep);
		setBairro(bairro);
		setCidade(cidade);
		setUf(uf);
		setPais(pais);
	}
	

	public void setAll(int cdEndereco, int cdAtendente,String tipo, String logradouro, String numero,
			String complemento, String cep, String bairro, String cidade, String uf, String pais) {
		
		setCdEndereco(cdEndereco);
		setCdAtendente(cdAtendente);
		setTipo(tipo);
		setLogradouro(logradouro);
		setNumero(numero);
		setComplemento(complemento);
		setCep(cep);
		setBairro(bairro);
		setCidade(cidade);
		setUf(uf);
		setPais(pais);
	}

	@Override
	public int compareTo(Endereco outro) {
		// TODO Auto-generated method stub
		return this.logradouro.compareTo(outro.logradouro);
	}
	
	
	
		
	
	public String getAll() {
		return  "Código Endereco : " + cdEndereco + "\n"+ 
				"Cógido Atendente : " + cdAtendente+ "\n"+ 
				"Tipo : " + tipo + "\n" +
				"Logradouro : " + logradouro + "\n"+ 
				"Número : " + numero + "\n" +
				"Complemento : " + complemento + "\n" +
				"Cep : " + cep + "\n" +
				"Bairro : " + bairro + "\n" +
				"Cidade : " + cidade + "\n" +
				"Uf :" + uf + "\n" +
				"Pais : " + pais ;
	}

	

	


	public int getCdAtendente() {
		return cdAtendente;
	}


	public void setCdAtendente(int cdAtendente) {
		this.cdAtendente = cdAtendente;
	}

	public int getCdEndereco() {
		return cdEndereco;
	}
	public void setCdEndereco(int cdEndereco) {
		this.cdEndereco = cdEndereco;
	}
	
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}


	


	

	
}
