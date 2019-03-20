package br.com.deschateie.beans;

public class PsiOnline extends Psicologo implements Comparable<Usuario> {
	private int codPsiOnline;
	private String periodo;
	private String formaAtendimento;
	private int notaAtendimento;
	private int qtdeAtendimentos;
	
	
	
	public PsiOnline(int codUsuario, String nomeUsuario, String email, String dataNascimento, String login,
			String senha, int nivelPermissao, String foto, String genero, int crp, String formacao, String biografia,
			long telefone, double valorConsulta, String periodo, String formaAtendimento,
			int notaAtendimento, int qtdeAtendimentos) {
		super(codUsuario, nomeUsuario, email, dataNascimento, login, senha, nivelPermissao, foto, genero, crp, formacao,
				biografia, telefone, valorConsulta);
		setCodPsiOnline(codUsuario);
		setPeriodo(periodo);
		setFormaAtendimento(formaAtendimento);
		setNotaAtendimento(notaAtendimento);
		setQtdeAtendimentos(qtdeAtendimentos);
	}
	
	
	public PsiOnline(int codPsiOnline,int crp, String formacao, String biografia,
			long telefone, double valorConsulta, String periodo, String formaAtendimento,
			int notaAtendimento, int qtdeAtendimentos) {
		super(codPsiOnline, crp, formacao, biografia, telefone, valorConsulta);
		
		setCodPsiOnline(codPsiOnline);
		setPeriodo(periodo);
		setFormaAtendimento(formaAtendimento);
		setNotaAtendimento(notaAtendimento);
		setQtdeAtendimentos(qtdeAtendimentos);
	}
	
	
	
	public PsiOnline() {
		
	}
	
	
	

	
	public String getAll() {
		return  "---- Psicologo Online ---- " +"\n"+
				super.getAll()+ "\n"+
				"Codigo Psicologo Online : " + codPsiOnline +"\n"+
				"Periodo :" + periodo + "\n"+
				"Forma Atendimento : "+ formaAtendimento + "\n"+
				"Nota Atendimento : " + notaAtendimento +"\n"+
				"Quantidade de Atendimentos : " + qtdeAtendimentos;
	}

	public void setAll(int codUsuario, String nomeUsuario, String email, String dataNascimento, String login,
			String senha, int nivelPermissao, String foto, String genero, int crp, String formacao, String biografia,
			long telefone, double valorConsulta, String periodo, String formaAtendimento,
			int notaAtendimento, int qtdeAtendimentos) {
		super.setAll(codUsuario, nomeUsuario, email, dataNascimento, login, senha, nivelPermissao, foto, genero, crp, formacao, biografia, telefone, valorConsulta);
		setCodPsiOnline(codUsuario);
		setPeriodo(periodo);
		setFormaAtendimento(formaAtendimento);
		setNotaAtendimento(notaAtendimento);
		setQtdeAtendimentos(qtdeAtendimentos);
	}



	public int getCodPsiOnline() {
		return codPsiOnline;
	}



	public void setCodPsiOnline(int codPsiOnline) {
		this.codPsiOnline = codPsiOnline;
	}



	public String getPeriodo() {
		return periodo;
	}



	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}



	public String getFormaAtendimento() {
		return formaAtendimento;
	}



	public void setFormaAtendimento(String formaAtendimento) {
		this.formaAtendimento = formaAtendimento;
	}



	public int getNotaAtendimento() {
		return notaAtendimento;
	}



	public void setNotaAtendimento(int notaAtendimento) {
		this.notaAtendimento = notaAtendimento;
	}



	public int getQtdeAtendimentos() {
		return qtdeAtendimentos;
	}



	public void setQtdeAtendimentos(int qtdeAtendimentos) {
		this.qtdeAtendimentos = qtdeAtendimentos;
	}



	@Override
	public int compareTo(Usuario outro) {
		return this.getNomeUsuario().compareTo(outro.getNomeUsuario());
	}
	
	
}
