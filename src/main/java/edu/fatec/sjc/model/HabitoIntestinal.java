package edu.fatec.sjc.model;

import java.text.SimpleDateFormat;
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

import edu.fatec.sjc.tela.Padrao.CriancaPadrao;

@Entity
@Table(name = "HABITO_INTESTINAL")
public class HabitoIntestinal {

	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	@Column(name = "HAB_INT_ID")
	private Long id;

	@Column(name = "HAB_INT_FREQUENCIA_NUMERO", unique = false, length = 2, nullable = false)
	private Long numero;

	@Column(name = "HAB_INT_FREQUENCIA_MEDIDA", unique = false, length = 30, nullable = false)
	private String frequencia;

	@Column(name = "HAB_INT_BRISTOL", unique = false, length = 30, nullable = false)
	private String bristol;

	@Column(name = "HAB_INT_MELENA", unique = false, nullable = false)
	private boolean melena;

	@Temporal(TemporalType.DATE)
	@Column(name = "HAB_INT_DATA")
	private Date data = new Date();

	@ManyToOne
	@JoinColumn(name = "CRI_ID")
	private Crianca crianca;
	
	public String escrever(){
		StringBuffer a = new StringBuffer();
		a.append("Paciente: " + CriancaPadrao.crianca.getNome() + System.getProperty("line.separator"));
		a.append(numero +  "vez(es) por" + frequencia + CriancaPadrao.crianca.getNome() + System.getProperty("line.separator"));
		a.append("Bristol: " + bristol + System.getProperty("line.separator"));
		String s = "";
		if(melena){
			s = "positivo";
		} else {
			s = "negativo";
		}
		a.append("Melena: " + s + System.getProperty("line.separator"));
		
		Date dataPadrao = data;
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		String dataFormatada = formato.format(data);
		
		a.append("Data da consulta: " + dataFormatada +  System.getProperty("line.separator"));
		
		return a.toString();
	}

	public Long getId() {
		return id;
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

	public String getBristol() {
		return bristol;
	}

	public void setBristol(String bristol) {
		this.bristol = bristol;
	}

	public boolean getMelena() {
		return melena;
	}

	public void setMelena(boolean melena) {
		this.melena = melena;
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
