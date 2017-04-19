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
@Table(name = "ORI_ORIENTACAO")
public class Orientacao {
	
	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	@Column(name = "ORI_ID")
	private Long id;
	
	@Column(name = "ORI_ALIMENTO", unique = false, length = 30, nullable = false)
	private String alimento;
	
	@Column(name = "ORI_REFEICAO", unique = false, length = 30, nullable = false)
	private String refeicao;
	
	@Column(name = "ORI_HORARIO", unique = false, length = 5, nullable = false)
	private String hora;
	
	@Column(name = "ORI_DATA", unique = false, nullable = false)
	private Date data = new Date();
	
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

	public String getRefeicao() {
		return refeicao;
	}

	public void setRefeicao(String refeicao) {
		this.refeicao = refeicao;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
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
