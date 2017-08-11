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

	@Column(name = "HAB_URI_HEMATURIA", unique = false, nullable = false)
	private boolean hematuria;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "HAB_URI_DATA")
	private Date data = new Date();

	@ManyToOne
	@JoinColumn(name = "CRI_ID")
	private Crianca crianca;
	
	public String escrever(){
		StringBuffer a = new StringBuffer();
		a.append("Paciente: " + CriancaPadrao.crianca.getNome() + System.getProperty("line.separator"));
		a.append(numero +  "vez(es) por" + frequencia + CriancaPadrao.crianca.getNome() + System.getProperty("line.separator"));
		
		String s = "";
		if(hematuria){
			s = "positivo";
		} else {
			s = "negativo";
		}
		a.append("Hematuria: " + s + System.getProperty("line.separator"));
		
		Date dataPadrao = data;
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		String dataFormatada = formato.format(data);
		
		a.append("Data da consulta: " + dataFormatada +  System.getProperty("line.separator"));
		
		return a.toString();
	}

	public Long getId() {
		return id;
	}

	public boolean getHematuria() {
		return hematuria;
	}

	public void setHematuria(boolean hematuria) {
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
