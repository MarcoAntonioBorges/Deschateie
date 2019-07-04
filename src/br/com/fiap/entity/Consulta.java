package br.com.fiap.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@IdClass(ConsultaPK.class)
@Table(name="T_DES_CONSULTA")
public class Consulta {

	@SequenceGenerator(name="consulta", sequenceName="SQ_T_CONSULTA", allocationSize=1)
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="consulta")
	@Column(name="cd_consulta")
	private int codigo;
	
	@Id
	@JoinColumn(name="cd_psicologo")
	@ManyToOne
	private Psicologo psicologo;
	
	@Id
	@JoinColumn(name="cd_paciente")
	@ManyToOne
	private Paciente paciente;
	
    @Column(name="dt_hr_consulta", nullable=false)
    @Temporal(value=TemporalType.TIMESTAMP)
    private Calendar dataHoraConsulta;
    
    @Column(name="ds_consulta", length=400, nullable=false)
    private String descricao;

    
	public Consulta(Calendar dataHoraConsulta, String descricao) {
		super();
		this.dataHoraConsulta = dataHoraConsulta;
		this.descricao = descricao;
	}

	public Consulta() {
		super();
	}

	public Consulta(int codigo, Psicologo psicologo, Paciente paciente, Calendar dataHoraConsulta, String descricao) {
		super();
		this.codigo = codigo;
		this.psicologo = psicologo;
		this.paciente = paciente;
		this.dataHoraConsulta = dataHoraConsulta;
		this.descricao = descricao;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Psicologo getPsicologo() {
		return psicologo;
	}

	public void setPsicologo(Psicologo psicologo) {
		this.psicologo = psicologo;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Calendar getDataHoraConsulta() {
		return dataHoraConsulta;
	}

	public void setDataHoraConsulta(Calendar dataHoraConsulta) {
		this.dataHoraConsulta = dataHoraConsulta;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
    
    
}
