package edu.fatec.sjc.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "HABITO_ALIMENTAR")
public class HabitoAlimentar {

	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	@Column(name = "HAB_ALI_ID")
	private Long id;

	@Column(name = "HAB_ALI_ALIMENTO", unique = false, length = 30, nullable = false)
	private String alimento;

	@Column(name = "HAB_ALI_REFEICAO", unique = false, length = 30, nullable = false)
	private String refeicao;

	@Column(name = "HAB_ALI_HORARIO", unique = false, length = 30, nullable = false)
	private String hora;

	@Column(name = "HAB_ALI_FREQUENCIA", unique = false, length = 30, nullable = false)
	private String frequencia;

	@Column(name = "HAB_ALI_FREQUENCIA_NUMERO", unique = false, length = 2, nullable = false)
	private Long numero;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "HAB_ALI_DATA")
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

	public String getFrequencia() {
		return frequencia;
	}

	public void setFrequencia(String frequencia) {
		this.frequencia = frequencia;
	}

	public Long getNumero() {
		return numero;
	}

	public void setNumero(Long numero) {
		this.numero = numero;
	}

	public Crianca getCrianca() {
		return crianca;
	}

	public void setCrianca(Crianca crianca) {
		this.crianca = crianca;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Date getData() {
		return data;
	}
}
