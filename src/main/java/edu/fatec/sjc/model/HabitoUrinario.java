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
@Table(name = "HABITO_URINARIO")
public class HabitoUrinario {

	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	@Column(name = "HAB_URI_ID")
	private Long id;

	@Column(name = "HAB_URI_FREQUENCIA_NUMERO", unique = false, length = 2, nullable = false)
	private Long numero;

	@Column(name = "HAB_URI_FREQUENCIA_MEDIDA", unique = false, length = 30, nullable = false)
	private String frequencia;

	@Column(name = "HAB_URI_HEMATURIA", unique = false, length = 30, nullable = false)
	private String hematuria;

	@Column(name = "HAB_URI_DATA", unique = false, nullable = false)
	private Date data;

	@ManyToOne
	@JoinColumn(name = "CRI_ID")
	private Crianca crianca;

	public Long getId() {
		return id;
	}

	public String getHematuria() {
		return hematuria;
	}

	public void setHematuria(String hematuria) {
		this.hematuria = hematuria;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getNumero() {
		return numero;
	}

	public void setNumero(Long numero) {
		this.numero = numero;
	}

	public String getFrequencia() {
		return frequencia;
	}

	public void setFrequencia(String frequencia) {
		this.frequencia = frequencia;
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
