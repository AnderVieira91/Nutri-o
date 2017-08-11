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
@Table(name = "ANT_ANTROPOMETRICO")
public class Antropometrico {

	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	@Column(name = "ANT_ID")
	private Long id;

	@Column(name = "ANT_PESO_HABITUAL", unique = false, length = 5, nullable = false)
	private Double pesoHabitual;

	@Column(name = "ANT_PESO_ATUAL", unique = false, length = 5, nullable = false)
	private Double pesoAtual;

	@Column(name = "ANT_PESO_ESTIMADO", unique = false, length = 5, nullable = false)
	private Double pesoEstimado;

	@Column(name = "ANT_ESTATURA", unique = false, length = 3, nullable = false)
	private Double estatura;

	@Column(name = "ANT_PERIMETRO_CRANIANO", unique = false, length = 5, nullable = false)
	private Double perimetroCraniano;

	@Column(name = "ANT_PERIMETRO_TORACICO", unique = false, length = 5, nullable = false)
	private Double perimetroToracico;

	@Column(name = "ANT_ALTERACAO_PESO_RECENTE", unique = false, length = 5, nullable = false)
	private Double alteracaoPesoRecente;

	@Column(name = "ANT_CIRCUNFERENCIA_ABDOMINAL", unique = false, length = 5, nullable = false)
	private Double circunferenciaAbdominal;

	@Column(name = "ANT_CIRCUNFERENCIA_COXA", unique = false, length = 5, nullable = false)
	private Double circunferenciaCoxa;

	@Column(name = "ANT_CIRCUNFERENCIA_PANTURRILHA", unique = false, length = 5, nullable = false)
	private Double circunferenciaPanturrilha;

	@Column(name = "ANT_CIRCUNFERENCIA_PESCOCO", unique = false, length = 5, nullable = false)
	private Double circunferenciaPescoco;

	@Column(name = "ANT_DOBRA_CUTANEA_TRICIPITAL", unique = false, length = 5, nullable = false)
	private Double dobraCutaneaTricipital;

	@Column(name = "ANT_DOBRA_CUTANEA_SUBESCALAR", unique = false, length = 5, nullable = false)
	private Double dobraCutaneaSubescalar;

	@Column(name = "ANT_DOBRA_CUTANEA_BICIBITAL", unique = false, length = 5, nullable = false)
	private Double dobraCutaneaBicibital;

	@Column(name = "ANT_DOBRA_CUTANEA_SUPRA_ILIACA", unique = false, length = 5, nullable = false)
	private Double dobraCutaneaSupraIliaca;

	@Column(name = "ANT_AREA_MUSCULAR_POLEGAR", unique = false, length = 5, nullable = false)
	private Double areaMuscularPolegar;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "ANT_DATA")
	private Date data = new Date();

	@ManyToOne
	@JoinColumn(name = "CRI_ID")
	private Crianca crianca;
	
	
	public String escrever(){
		StringBuffer a = new StringBuffer();
		a.append("Paciente: " + CriancaPadrao.crianca.getNome() + System.getProperty("line.separator"));
		a.append("Peso habitual: " + pesoHabitual +  System.getProperty("line.separator"));
		a.append("Peso atual: " + pesoAtual +  System.getProperty("line.separator"));
		a.append("Peso estimado: " + pesoEstimado +  System.getProperty("line.separator"));
		a.append("Alteração peso recente: " + alteracaoPesoRecente +  System.getProperty("line.separator"));
		a.append("Comprimento/Estatura: " + estatura +  System.getProperty("line.separator"));
		a.append("Perímetro craniano: " + perimetroCraniano +  System.getProperty("line.separator"));
		a.append("Perímetro torácico: " + perimetroToracico +  System.getProperty("line.separator"));
		a.append("Perímetro torácico: " + perimetroToracico +  System.getProperty("line.separator"));
		a.append("Circunferência abdominal: " + circunferenciaAbdominal +  System.getProperty("line.separator"));
		a.append("Circunferência da coxa: " + circunferenciaCoxa +  System.getProperty("line.separator"));
		a.append("Circunferência da panturrilha: " + circunferenciaPanturrilha +  System.getProperty("line.separator"));
		a.append("Circunferência do pescoço: " + circunferenciaPescoco +  System.getProperty("line.separator"));
		a.append("Dobra cutânea tricipital: " + dobraCutaneaTricipital +  System.getProperty("line.separator"));
		a.append("Dobra cutânea subescalar: " + dobraCutaneaSubescalar +  System.getProperty("line.separator"));
		a.append("Área muscular do polegar: " + areaMuscularPolegar +  System.getProperty("line.separator"));
		
		Date dataPadrao = data;
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		String dataFormatada = formato.format(data);
		
		a.append("Data da consulta: " + dataFormatada +  System.getProperty("line.separator"));
		
		return a.toString();
		
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getPesoHabitual() {
		return pesoHabitual;
	}

	public void setPesoHabitual(Double pesoHabitual) {
		this.pesoHabitual = pesoHabitual;
	}

	public Double getPesoAtual() {
		return pesoAtual;
	}

	public void setPesoAtual(Double pesoAtual) {
		this.pesoAtual = pesoAtual;
	}

	public Double getPesoEstimado() {
		return pesoEstimado;
	}

	public void setPesoEstimado(Double pesoEstimado) {
		this.pesoEstimado = pesoEstimado;
	}

	public Double getEstatura() {
		return estatura;
	}

	public void setEstatura(Double estatura) {
		this.estatura = estatura;
	}

	public Double getPerimetroCraniano() {
		return perimetroCraniano;
	}

	public void setPerimetroCraniano(Double perimetroCraniano) {
		this.perimetroCraniano = perimetroCraniano;
	}

	public Double getPerimetroToracico() {
		return perimetroToracico;
	}

	public void setPerimetroToracico(Double perimetroToracico) {
		this.perimetroToracico = perimetroToracico;
	}

	public Double getAlteracaoPesoRecente() {
		return alteracaoPesoRecente;
	}

	public void setAlteracaoPesoRecente(Double alteracaoPesoRecente) {
		this.alteracaoPesoRecente = alteracaoPesoRecente;
	}

	public Double getCircunferenciaAbdominal() {
		return circunferenciaAbdominal;
	}

	public void setCircunferenciaAbdominal(Double circunferenciaAbdominal) {
		this.circunferenciaAbdominal = circunferenciaAbdominal;
	}

	public Double getCircunferenciaCoxa() {
		return circunferenciaCoxa;
	}

	public void setCircunferenciaCoxa(Double circunferenciaCoxa) {
		this.circunferenciaCoxa = circunferenciaCoxa;
	}

	public Double getCircunferenciaPanturrilha() {
		return circunferenciaPanturrilha;
	}

	public void setCircunferenciaPanturrilha(Double circunferenciaPanturrilha) {
		this.circunferenciaPanturrilha = circunferenciaPanturrilha;
	}

	public Double getCircunferenciaPescoco() {
		return circunferenciaPescoco;
	}

	public void setCircunferenciaPescoco(Double circunferenciaPescoco) {
		this.circunferenciaPescoco = circunferenciaPescoco;
	}

	public Double getDobraCutaneaTricipital() {
		return dobraCutaneaTricipital;
	}

	public void setDobraCutaneaTricipital(Double dobraCutaneaTricipital) {
		this.dobraCutaneaTricipital = dobraCutaneaTricipital;
	}

	public Double getDobraCutaneaSubescalar() {
		return dobraCutaneaSubescalar;
	}

	public void setDobraCutaneaSubescalar(Double dobraCutaneaSubescalar) {
		this.dobraCutaneaSubescalar = dobraCutaneaSubescalar;
	}

	public Double getDobraCutaneaBicibital() {
		return dobraCutaneaBicibital;
	}

	public void setDobraCutaneaBicibital(Double dobraCutaneaBicibital) {
		this.dobraCutaneaBicibital = dobraCutaneaBicibital;
	}

	public Double getDobraCutaneaSupraIliaca() {
		return dobraCutaneaSupraIliaca;
	}

	public void setDobraCutaneaSupraIliaca(Double dobraCutaneaSupraIliaca) {
		this.dobraCutaneaSupraIliaca = dobraCutaneaSupraIliaca;
	}

	public Double getAreaMuscularPolegar() {
		return areaMuscularPolegar;
	}

	public void setAreaMuscularPolegar(Double areaMuscularPolegar) {
		this.areaMuscularPolegar = areaMuscularPolegar;
	}

	public Crianca getCrianca() {
		return crianca;
	}

	public void setCrianca(Crianca crianca) {
		this.crianca = crianca;
	}

}
