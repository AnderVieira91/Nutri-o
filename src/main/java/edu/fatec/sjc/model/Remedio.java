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
@Table(name = "REM_REMEDIO")
public class Remedio {

	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	@Column(name = "REM_ID")
	private Long id;

	@Column(name = "REM_NOME", unique = false, length = 30, nullable = false)
	private String nome;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "REMEDIO_CRIANCA", joinColumns = { @JoinColumn(name = "REM_ID") }, inverseJoinColumns = {
			@JoinColumn(name = "CRI_ID") })
	private List<Crianca> criancas;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public List<Crianca> getCriancas() {
		return criancas;
	}

	public void setCriancas(List<Crianca> criancas) {
		this.criancas = criancas;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
