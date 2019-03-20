package br.com.deschateie.beans;

public class Voluntario extends Usuario  implements Comparable<Usuario> {
	private int codVoluntario;
	private String rg;
	private long cpf;
	private String formacao;
	private String periodo;
	private String comentario;
	private long telefone;
	
	public Voluntario() {
		
	}
	
	public Voluntario(int codUsuario, String nomeUsuario, String email, String dataNascimento, String login,
			String senha, int nivelPermissao, String foto, String genero, String rg, long cpf, String formacao,
			String periodo, String comentario,  long telefone) {
		super(codUsuario, nomeUsuario, email, dataNascimento, login, senha, nivelPermissao, foto, genero);
		setCodVoluntario(codUsuario);
		setRg(rg);
		setCpf(cpf);
		setFormacao(formacao);
		setPeriodo(periodo);
		setComentario(comentario);
		setTelefone(telefone);
	}
	
	
	
	public void setAll(int codUsuario, String nomeUsuario, String email, String dataNascimento, String login,
			String senha, int nivelPermissao, String foto, String genero, String rg, long cpf, String formacao,
			String periodo, String comentario, long telefone) {
		super.setAll(codUsuario, nomeUsuario, email, dataNascimento, login, senha, nivelPermissao, foto, genero);
		setCodVoluntario(codUsuario);
		setRg(rg);
		setCpf(cpf);
		setFormacao(formacao);
		setPeriodo(periodo);
		setComentario(comentario);
		setTelefone((long)telefone);
	}
	
	
	
	
	
	public String getAll() {
		return 	super.getAll() + "\n" +
				"Codigo Voluntario :" + codVoluntario + "\n"+
				"Rg :" + rg + "\n"+
				"Cpf : " + cpf +  "\n"+
				"Formacao : " + formacao + "\n"+
				"Periodo :" + periodo+ "\n"+
				"Comentario : " + comentario + "\n"+
				"Telefone : " + telefone;
	}

	

	public int getCodVoluntario() {
		return codVoluntario;
	}

	public void setCodVoluntario(int codVoluntario) {
		this.codVoluntario = codVoluntario;
	}
	
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public long getCpf() {
		return cpf;
	}
	public void setCpf(long cpf) {
		this.cpf =(long) cpf;
	}
	public String getFormacao() {
		return formacao;
	}
	public void setFormacao(String formacao) {
		this.formacao = formacao;
	}
	public String getPeriodo() {
		return periodo;
	}
	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	public long getTelefone() {
		return telefone;
	}
	public void setTelefone(long telefone) {
		this.telefone = telefone;
	}

	@Override
	public int compareTo(Usuario o) {
		return getNomeUsuario().compareTo(o.getNomeUsuario());
	}
	
	
}
