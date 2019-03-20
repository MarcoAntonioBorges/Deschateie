package br.com.deschateie.beans;

public class Agendamento implements Comparable<Agendamento>{
	
	
	
	private int codAgendamento;
	private Usuario usuario;
	private Psicologo psicologo;
	private String dataAgendamento;
	
	
	
	
	public Agendamento(int codAgendamento, Psicologo psicologo,Usuario usuario, String dataAgendamento) {
		super();
		setCodAgendamento(codAgendamento);
		setUsuario(usuario);
		setPsicologo(psicologo);
		setDataAgendamento(dataAgendamento);
	}



	public Agendamento() {
		super();
		this.usuario = new Usuario();
		this.psicologo = new Psicologo();
	}
	
	

	public void setAll(int codAgendamento, Psicologo psicologo, Usuario usuario,String dataAgendamento) {
		setCodAgendamento(codAgendamento);
		setUsuario(usuario);
		setPsicologo(psicologo);
		setDataAgendamento(dataAgendamento);
	}
	
	
	
	
	public String getAll() {
		return "Codigo Agendamento : " + codAgendamento +"\n"+
				"Usuario : " + usuario.getAll() +"\n"+
				"Psicologo : " + psicologo.getAll()+"\n"+
				"Data Agendamento : " + dataAgendamento;
	}



	public int getCodAgendamento() {
		return codAgendamento;
	}





	public void setCodAgendamento(int codAgendamento) {
		this.codAgendamento = codAgendamento;
	}





	public Usuario getUsuario() {
		return usuario;
	}





	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}





	public Psicologo getPsicologo() {
		return psicologo;
	}





	public void setPsicologo(Psicologo psicologo) {
		this.psicologo = psicologo;
	}





	public String getDataAgendamento() {
		return dataAgendamento;
	}





	public void setDataAgendamento(String dataAgendamento) {
		this.dataAgendamento = dataAgendamento;
	}





	@Override
	public int compareTo(Agendamento o) {
		return usuario.getNomeUsuario().compareTo(o.getUsuario().getNomeUsuario());
	}
	
	
}
