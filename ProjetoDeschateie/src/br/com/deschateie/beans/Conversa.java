package br.com.deschateie.beans;

public class Conversa implements Comparable<Conversa> {
	
	private int codConversa;
	private String HoraInicio;
	private int qtdeRespostas;
	private String historico;
	private String horaTermino;
	private Voluntario voluntario;
	
	
	public Conversa() {
		super();
		this.voluntario = new Voluntario();
	}
	
	public Conversa(int codConversa, String horaInicio, int qtdeRespostas, String historico, String horaTermino,
			Voluntario voluntario) {
		super();
		setCodConversa(codConversa);
		setHoraInicio(horaInicio);
		setQtdeRespostas(qtdeRespostas);
		setHistorico(historico);
		setHoraTermino(horaTermino);
		setVoluntario(voluntario);
	}
	
	
	
	public void setAll(int codConversa, String horaInicio, int qtdeRespostas, String historico, String horaTermino,
			Voluntario voluntario) {
		setCodConversa(codConversa);
		setHoraInicio(horaInicio);
		setQtdeRespostas(qtdeRespostas);
		setHistorico(historico);
		setHoraTermino(horaTermino);
		setVoluntario(voluntario);
	}
	public String getAll() {
		return "Codigo conversa : " + codConversa + "\n"+
				"Horario Inicio : " + HoraInicio + "\n"+
				"Quantidade Respostas : " + qtdeRespostas + "\n"+
				"Historico : " + historico + "\n"+
				"Horario Termino : " + horaTermino + "\n"+
				voluntario.getAll();
	}
	public int getCodConversa() {
		return codConversa;
	}
	public void setCodConversa(int codConversa) {
		this.codConversa = codConversa;
	}
	public String getHoraInicio() {
		return HoraInicio;
	}
	public void setHoraInicio(String horaInicio) {
		HoraInicio = horaInicio;
	}
	public int getQtdeRespostas() {
		return qtdeRespostas;
	}
	public void setQtdeRespostas(int qtdeRespostas) {
		this.qtdeRespostas = qtdeRespostas;
	}
	public String getHistorico() {
		return historico;
	}
	public void setHistorico(String historico) {
		this.historico = historico;
	}
	public String getHoraTermino() {
		return horaTermino;
	}
	public void setHoraTermino(String horaTermino) {
		this.horaTermino = horaTermino;
	}
	public Voluntario getVoluntario() {
		return voluntario;
	}
	public void setVoluntario(Voluntario voluntario) {
		this.voluntario = voluntario;
	}

	@Override
	public int compareTo(Conversa o) {
		return this.voluntario.getNomeUsuario().compareTo(o.voluntario.getNomeUsuario());
	}
	
	

}
