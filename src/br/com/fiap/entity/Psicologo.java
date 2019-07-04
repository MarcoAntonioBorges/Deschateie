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
@Table(name="T_DES_PSICOLOGO")
@SequenceGenerator(name="psicologo", sequenceName="SQ_T_PSICOLOGO", allocationSize=1)
public class Psicologo {
	
	@Id
	@Column(name="cd_psicologo")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="psicologo")
	private int codigo;
	
	@OneToMany(mappedBy="psicologo")
	private List<Consulta> consultas;
	
	@Column(name="nm_psicologo", length=50, nullable=false)
	private String nome;
	
	@Column(name="dt_nascimento")
	@Temporal(value=TemporalType.DATE)
	private Calendar dataNasc;
	
	@Column(name="ds_sexo")
	@Enumerated(value=EnumType.STRING)
	private Genero genero;

	
	public Psicologo(String nome, Calendar dataNasc, Genero genero) {
		super();
		this.nome = nome;
		this.dataNasc = dataNasc;
		this.genero = genero;
	}

	public Psicologo() {
		super();
	}

	public Psicologo(int codigo, List<Consulta> consultas, String nome, Calendar dataNasc, Genero genero) {
		super();
		this.codigo = codigo;
		this.consultas = consultas;
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

	public List<Consulta> getConsultas() {
		return consultas;
	}

	public void setConsultas(List<Consulta> consultas) {
		this.consultas = consultas;
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
