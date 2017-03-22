package edu.fatec.sjc.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "REC_RECORDATORIO")
public class Recordatorio {

	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	@Column(name = "REC_ID")
	private Long id;

	@Column(name = "REC_ALIMENTO", unique = false, length = 30, nullable = false)
	private String alimento;

	@Column(name = "REC_HORARIO", unique = false, length = 5, nullable = false)
	private String horario;

	@Column(name = "REC_REFEICAO", unique = false, length = 30, nullable = false)
	private String refeicao;

	@Column(name = "REC_DATA", unique = false, nullable = false)
	private Date data;

	@ManyToOne
	@JoinColumn(name = "CRI_ID")
	private Crianca crianca;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAlimento() {
		return alimento;
	}

	public void setAlimento(String alimento) {
		this.alimento = alimento;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public String getRefeicao() {
		return refeicao;
	}

	public void setRefeicao(String refeicao) {
		this.refeicao = refeicao;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Crianca getCrianca() {
		return crianca;
	}

	public void setCrianca(Crianca crianca) {
		this.crianca = crianca;
	}

}
