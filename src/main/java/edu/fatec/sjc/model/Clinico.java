package edu.fatec.sjc.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "CLI_CLINICO")
public class Clinico {

	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	@Column(name = "CLI_ID")
	private Long id;

	@Column(name = "CLI_DOENCA", unique = false, length = 30, nullable = false)
	private String doenca;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "CLINICO_CRIANCA", joinColumns = { @JoinColumn(name = "CLI_ID") }, inverseJoinColumns = {
			@JoinColumn(name = "CRI_ID") })
	private List<Crianca> criancas;

	public List<Crianca> getCriancas() {
		return criancas;
	}

	public void setCriancas(List<Crianca> criancas) {
		this.criancas = criancas;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDoenca() {
		return doenca;
	}

	public void setDoenca(String doenca) {
		this.doenca = doenca;
	}

}
