package br.com.fiap.entity;

import java.io.Serializable;

public class ConsultaPK implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5706756171396895520L;

	private int codigo;
	
	private int psicologo;
	
	private int paciente;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codigo;
		result = prime * result + paciente;
		result = prime * result + psicologo;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ConsultaPK other = (ConsultaPK) obj;
		if (codigo != other.codigo)
			return false;
		if (paciente != other.paciente)
			return false;
		if (psicologo != other.psicologo)
			return false;
		return true;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getPsicologo() {
		return psicologo;
	}

	public void setPsicologo(int psicologo) {
		this.psicologo = psicologo;
	}

	public int getPaciente() {
		return paciente;
	}

	public void setPaciente(int paciente) {
		this.paciente = paciente;
	}
	
	
	
}
