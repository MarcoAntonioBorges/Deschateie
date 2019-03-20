package br.com.deschateie.beans;


public class Usuario implements Comparable<Usuario>{
	private int codUsuario;
	private String nomeUsuario;
	private String email;
	private String dataNascimento;
	private String login;
	private String senha;
	private int nivelPermissao;
	private String foto;
	private String genero;
	
	
	public Usuario() {
			
		}
	
	public Usuario(int codUsuario, String nomeUsuario, String email, String dataNascimento, String login, String senha,
			int nivelPermissao, String foto, String genero) {
		setCodUsuario(codUsuario);
		setNomeUsuario(nomeUsuario);
		setEmail(email);
		setDataNascimento(dataNascimento);
		setLogin(login);
		setSenha(senha);
		setNivelPermissao(nivelPermissao);
		setFoto(foto);
		setGenero(genero);
	}

	
	public void setAll(int codUsuario, String nomeUsuario, String email, String dataNascimento, String login, String senha,
			int nivelPermissao, String foto, String genero) {
		setCodUsuario(codUsuario);
		setNomeUsuario(nomeUsuario);
		setEmail(email);
		setDataNascimento(dataNascimento);
		setLogin(login);
		setSenha(senha);
		setNivelPermissao(nivelPermissao);
		setFoto(foto);
		setGenero(genero);
	}


	
	public String getAll() {
		return "Usuario : " + codUsuario + "\n"+ 
				"Nome de Usuario : " + nomeUsuario + "\n"+ 
				"E-mail :" + email + "\n"+ 
				"Data de Nascimento : " + dataNascimento + "\n"+ 
				"Login : " + login + "\n"+ 
				"Senha : " + senha + "\n"+ 
				"Nivel de Permissao : "	+ nivelPermissao + "\n"+ 
				"Foto :" + foto + "\n"+ 
				"Genero : " + genero;
	}


	
	
	
	public int getCodUsuario() {
		return codUsuario;
	}


	public void setCodUsuario(int codUsuario) {
		this.codUsuario = codUsuario;
	}


	public String getNomeUsuario() {
		return nomeUsuario;
	}


	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getDataNascimento() {
		return dataNascimento;
	}


	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}


	public String getLogin() {
		return login;
	}


	public void setLogin(String login) {
		this.login = login;
	}


	public String getSenha() {
		return senha;
	}


	public void setSenha(String senha) {
		this.senha = senha;
	}


	public int getNivelPermissao() {
		return nivelPermissao;
	}


	public void setNivelPermissao(int nivelPermissao) {
		this.nivelPermissao = nivelPermissao;
	}


	public String getFoto() {
		return foto;
	}


	public void setFoto(String foto) {
		this.foto = foto;
	}


	public String getGenero() {
		return genero;
	}


	public void setGenero(String genero) {
		this.genero = genero;
	}


	@Override
	public int compareTo(Usuario outro) {
		return this.nomeUsuario.compareTo(outro.getNomeUsuario());
	}
}
