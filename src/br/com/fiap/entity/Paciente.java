package br.com.fiap.entity;

import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="T_DES_PACIENTE")
@SequenceGenerator(name="paciente", sequenceName="SQ_T_PACIENTE", allocationSize=1)
public class Paciente {
	
	@Id
	@Column(name="cd_paciente")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="paciente")
	private int codigo;
	
	@OneToMany(mappedBy="paciente")
	private List<Consulta> consulta;
	
	@Column(name="nm_paciente", length=50, nullable=false)
	private String nome;
	
	@Column(name="dt_nascimento")
	@Temporal(value=TemporalType.DATE)
	private Calendar dataNasc;
	
	@Column(name="ds_sexo")
	@Enumerated(value=EnumType.STRING)
	private Genero genero;

	
	public Paciente(String nome, Calendar dataNasc, Genero genero) {
		super();
		this.nome = nome;
		this.dataNasc = dataNasc;
		this.genero = genero;
	}

	public Paciente() {
		super();
	}

	public Paciente(int codigo, List<Consulta> consulta, String nome, Calendar dataNasc, Genero genero) {
		super();
		this.codigo = codigo;
		this.consulta = consulta;
		this.nome = nome;
		this.dataNasc = dataNasc;
		this.genero = genero;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public List<Consulta> getConsulta() {
		return consulta;
	}

	public void setConsulta(List<Consulta> consulta) {
		this.consulta = consulta;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Calendar getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(Calendar dataNasc) {
		this.dataNasc = dataNasc;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}
	
	
}
