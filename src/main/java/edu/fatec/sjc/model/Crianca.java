package edu.fatec.sjc.model;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "CRI_CRIANCA")
public class Crianca {

	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	@Column(name = "CRI_ID")
	private Long id;

	@Column(name = "CRI_NOME", unique = false, length = 80, nullable = false)
	private String nome;

	@Column(name = "CRI_PAI", unique = false, length = 80, nullable = false)
	private String pai;

	@Column(name = "CRI_MAE", unique = false, length = 80, nullable = false)
	private String mae;

	@Temporal(TemporalType.DATE)
	@Column(name = "CRI_NASCIMENTO")
	private Date nascimento;

	@Column(name = "CRI_MOTIVO", unique = false, length = 80, nullable = false)
	private String motivo;

	@Column(name = "CRI_TELEFONE", unique = false, length = 11, nullable = false)
	private Long telefone;

	@Column(name = "CRI_SEXO", unique = false, length = 1, nullable = false)
	private String sexo;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "REMEDIO_CRIANCA", joinColumns = { @JoinColumn(name = "CRI_ID") }, inverseJoinColumns = {
			@JoinColumn(name = "REM_ID") })
	private List<Remedio> remedios;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "CLINICO_CRIANCA", joinColumns = { @JoinColumn(name = "CRI_ID") }, inverseJoinColumns = {
			@JoinColumn(name = "CLI_ID") })
	private List<Clinico> clinicos;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "crianca")
	private List<Antropometrico> antropometricos = new LinkedList<Antropometrico>();

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "crianca")
	private List<Familiar> familiares = new LinkedList<Familiar>();

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "crianca")
	private List<HabitoUrinario> habitoUrinario = new LinkedList<HabitoUrinario>();

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "crianca")
	private List<HabitoIntestinal> habitoIntestinal = new LinkedList<HabitoIntestinal>();

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "crianca")
	private List<Bioquimico> bioquimico = new LinkedList<Bioquimico>();

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "crianca")
	private List<HabitoAlimentar> habitoAlimentar = new LinkedList<HabitoAlimentar>();

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "crianca")
	private List<Recordatorio> recordatorio = new LinkedList<Recordatorio>();
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "crianca")
	private List<Orientacao> orientecao = new LinkedList<Orientacao>();

	public List<Orientacao> getOrientecao() {
		return orientecao;
	}

	public void setOrientecao(List<Orientacao> orientecao) {
		this.orientecao = orientecao;
	}

	public List<Recordatorio> getRecordatorio() {
		return recordatorio;
	}

	public void setRecordatorio(List<Recordatorio> recordatorio) {
		this.recordatorio = recordatorio;
	}

	public List<HabitoAlimentar> getHabitoAlimentar() {
		return habitoAlimentar;
	}

	public void setHabitoAlimentar(List<HabitoAlimentar> habitoAlimentar) {
		this.habitoAlimentar = habitoAlimentar;
	}

	public List<Clinico> getClinicos() {
		return clinicos;
	}

	public void setClinicos(List<Clinico> clinicos) {
		this.clinicos = clinicos;
	}

	public List<Bioquimico> getBioquimico() {
		return bioquimico;
	}

	public void setBioquimico(List<Bioquimico> bioquimico) {
		this.bioquimico = bioquimico;
	}

	public List<HabitoIntestinal> getHabitoIntestinal() {
		return habitoIntestinal;
	}

	public void setHabitoIntestinal(List<HabitoIntestinal> habitoIntestinal) {
		this.habitoIntestinal = habitoIntestinal;
	}

	public List<HabitoUrinario> getHabitoUrinario() {
		return habitoUrinario;
	}

	public void setHabitoUrinario(List<HabitoUrinario> habitoUrinario) {
		this.habitoUrinario = habitoUrinario;
	}

	public List<Antropometrico> getAntropometricos() {
		return antropometricos;
	}

	public void setAntropometricos(List<Antropometrico> antropometricos) {
		this.antropometricos = antropometricos;
	}

	public List<Familiar> getFamiliares() {
		return familiares;
	}

	public void setFamiliares(List<Familiar> familiares) {
		this.familiares = familiares;
	}

	public List<Remedio> getRemedios() {
		return remedios;
	}

	public void setRemedios(List<Remedio> remedios) {
		this.remedios = remedios;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPai() {
		return pai;
	}

	public void setPai(String pai) {
		this.pai = pai;
	}

	public String getMae() {
		return mae;
	}

	public void setMae(String mae) {
		this.mae = mae;
	}

	public java.util.Date getNascimento() {
		return nascimento;
	}

	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	public Long getTelefone() {
		return telefone;
	}

	public void setTelefone(Long telefone) {
		this.telefone = telefone;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

}
