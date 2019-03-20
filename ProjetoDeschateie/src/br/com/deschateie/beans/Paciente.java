package br.com.deschateie.beans;

public class Paciente extends Usuario implements Comparable<Usuario> {
	
	private int codPaciente;
	private String cep;
	private long cpf;
	private String historico;
	private int consultasReazlizadas; 
	
	

	public Paciente() {
		
	}
	
	public Paciente(int codUsuario, String nomeUsuario, String email, String dataNascimento, String login, String senha,
			int nivelPermissao, String foto, String genero, String cep, long cpf, String historico,
			int consultasReazlizadas) {
		super(codUsuario, nomeUsuario, email, dataNascimento, login, senha, nivelPermissao, foto, genero);
		setCodPaciente(codUsuario);
		setCep(cep);
		setCpf(cpf);
		setHistorico(historico);
		setConsultasReazlizadas(consultasReazlizadas); 
	}


	public void setAll(int codUsuario, String nomeUsuario, String email, String dataNascimento, String login, String senha,
			int nivelPermissao, String foto, String genero, String cep, int cpf, String historico,
			int consultasReazlizadas) {
		
		super.setAll(codUsuario, nomeUsuario, email, dataNascimento, login, senha, nivelPermissao, foto, genero);
		setCodPaciente(codUsuario);
		setCep(cep);
		setCpf(cpf);
		setHistorico(historico);
		setConsultasReazlizadas(consultasReazlizadas);
	}

	


	
	public String getAll() {
		return  " ---- Paciente ------ "+ "\n"+
				super.getAll()+"\n"+ 
				"Código Paciente :" + codPaciente  + "\n"+ 
				"Cep : " + cep  + "\n"+ 
				"Cpf : " + cpf  + "\n"+ 
				"Histórico : " + historico  + "\n"+ 
				"Consultas Reazlizadas : " + consultasReazlizadas;
	}

	public int getCodPaciente() {
		return codPaciente;
	}





	public void setCodPaciente(int codPaciente) {
		this.codPaciente = codPaciente;
	}





	public String getCep() {
		return cep;
	}





	public void setCep(String cep) {
		this.cep = cep;
	}





	public long getCpf() {
		return cpf;
	}





	public void setCpf(long cpf) {
		this.cpf = cpf;
	}





	public String getHistorico() {
		return historico;
	}





	public void setHistorico(String historico) {
		this.historico = historico;
	}





	public int getConsultasReazlizadas() {
		return consultasReazlizadas;
	}





	public void setConsultasReazlizadas(int consultasReazlizadas) {
		this.consultasReazlizadas = consultasReazlizadas;
	}





	@Override
	public int compareTo(Usuario o) {
		return getNomeUsuario().compareTo(o.getNomeUsuario());
	}

	@Override
	public boolean equals(Object obj) {
	if(((Paciente)obj).getNomeUsuario().equals(this.getNomeUsuario())){
	return true;
	}else{
	return false;
	}
	}

}
