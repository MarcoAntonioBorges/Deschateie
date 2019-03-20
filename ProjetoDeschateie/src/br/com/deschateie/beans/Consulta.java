package br.com.deschateie.beans;

public class Consulta implements Comparable<Consulta>{
	
	private int codConsulta;
	private int codPsiOnline;
	private int codPaciente;
	private int codConversa;
	private String dataConsulta;
	private int notaAtendimento;
	private String comentario;
	
	
	public Consulta() {
		
	}
	
	public Consulta(int codConsulta, int codPsiOnline, int codPaciente, int codConversa, String dataConsulta,
			int notaAtendimento, String comentario) {
		setCodConsulta(codConsulta);
		setCodPsiOnline(codPsiOnline);
		setCodPaciente(codPaciente);
		setCodConversa(codConversa);
		setDataConsulta(dataConsulta);
		setNotaAtendimento(notaAtendimento);
		setComentario(comentario);
	}
	
	public void setAll(int codConsulta, int codPsiOnline, int codPaciente, int codConversa, String dataConsulta,
			int notaAtendimento, String comentario) {
		setCodConsulta(codConsulta);
		setCodPsiOnline(codPsiOnline);
		setCodPaciente(codPaciente);
		setCodConversa(codConversa);
		setDataConsulta(dataConsulta);
		setNotaAtendimento(notaAtendimento);
		setComentario(comentario);
	}
	
	
	
	
	public String getAll() {
		return "Codigo consulta :" + codConsulta + "\n"
				+ "Codigo Psicologo Online" + codPsiOnline +  "\n"
				+ "Codigo Paciente"+codPaciente+ "\n"
				+ "Codigo conversa : " +codConversa+ "\n"
				+"Data Consulta :" + dataConsulta + "\n"
				+ "Nota Atendimento :" + notaAtendimento+ "\n"
				+ "Comentario :" + comentario + "\n"+
				"-------------------------------------";
	}

	public int getCodConsulta() {
		return codConsulta;
	}
	public void setCodConsulta(int codConsulta) {
		this.codConsulta = codConsulta;
	}
	public int getCodPsiOnline() {
		return codPsiOnline;
	}
	public void setCodPsiOnline(int codPsiOnline) {
		this.codPsiOnline = codPsiOnline;
	}
	public int getCodPaciente() {
		return codPaciente;
	}
	public void setCodPaciente(int codPaciente) {
		this.codPaciente = codPaciente;
	}
	public int getCodConversa() {
		return this.codConversa;
	}
	public void setCodConversa(int codConversa) {
		this.codConversa = codConversa;
	}
	public String getDataConsulta() {
		return dataConsulta;
	}
	public void setDataConsulta(String dataConsulta) {
		this.dataConsulta = dataConsulta;
	}
	public int getNotaAtendimento() {
		return notaAtendimento;
	}
	public void setNotaAtendimento(int notaAtendimento) {
		this.notaAtendimento = notaAtendimento;
	}
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	@Override
	public int compareTo(Consulta o) {
		if(this.codConsulta>o.codConsulta) {
			return 1;
		}else if (this.codConsulta<o.codConsulta) {
			return -1;
		}else {
			return 0;
		}
		
	}
	
	
}
