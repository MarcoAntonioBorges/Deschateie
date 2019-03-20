package br.com.deschateie.beans;

public class Avaliacao implements Comparable<Avaliacao> {
	private int codAvaliacao;
	private Psicologo psicologo;
	private Usuario usuario;
	private String dataAvaliacao;
	private String resultado;
	

	
	
	public Avaliacao() {
		super();
		this.usuario = new Usuario();
		this.psicologo= new Psicologo();
	}
	
	


	public Avaliacao(int codAvaliacao, Psicologo psicologo, Usuario usuario, String dataAvaliacao,String resultado) {
			setCodAvaliacao(codAvaliacao);
			setUsuario(usuario);
			setPsicologo(psicologo);
			setDataAvaliacao(dataAvaliacao);
			setResultado(resultado);
		}
	

	public void setAll(int codAvaliacao, Psicologo psicologo, Usuario usuario, String dataAvaliacao,
		String resultado) {
		setCodAvaliacao(codAvaliacao);
		setPsicologo(psicologo);
		setUsuario(usuario);
		setDataAvaliacao(dataAvaliacao);
		setResultado(resultado);
	}

	

	public String getAll() {
		return 
				"Codigo Avaliacao : " + codAvaliacao + "\n"+
				"Usuario : "+ usuario.getAll()+  "\n"+
				"Psicologo :" + psicologo.getAll() + "\n"+
				"Data Avaliacao : " + dataAvaliacao +  "\n"+
				"Resultado : " + resultado;
	}

	// verificar metodos
	public void setCodPsicologo(int codPsicologo) {
		psicologo.setCodPsicologo(codPsicologo);
		
	}
	
	public void setCodUsuario(int codUsuario) {
		usuario.setCodUsuario(codUsuario);;
		
	}
	
	
	public int getCodAvaliacao() {
		return codAvaliacao;
	}



	public void setCodAvaliacao(int codAvaliacao) {
		this.codAvaliacao = codAvaliacao;
	}



	public Psicologo getPsicologo() {
		return psicologo;
	}


	public void setPsicologo(Psicologo psicologo) {
		this.psicologo = psicologo;
	}


	public Usuario getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


	public String getDataAvaliacao() {
		return dataAvaliacao;
	}



	public void setDataAvaliacao(String dataAvaliacao) {
		this.dataAvaliacao = dataAvaliacao;
	}



	public String getResultado() {
		return resultado;
	}



	public void setResultado(String resultado) {
		this.resultado = resultado;
	}



	@Override
	public int compareTo(Avaliacao o) {
		if(this.codAvaliacao< o.codAvaliacao) {
			return -1;
		}else if(this.codAvaliacao > o.codAvaliacao) {
			return 1;
		}else {
			return 0;
		}
		
	}
	
	

}
