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
@Table(name = "BIO_BIOQUIMICO")
public class Bioquimico {

	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	@Column(name = "BIO_ID")
	private Long id;

	@Column(name = "BIO_PROTEINAS_TOTAIS", unique = false, length = 10, nullable = false)
	private Double proteinasTotais;

	@Column(name = "BIO_ALBUMINA", unique = false, length = 10, nullable = false)
	private Double albumina;

	@Column(name = "BIO_PRE_ALBUMINA", unique = false, length = 10, nullable = false)
	private Double preAlbumina;

	@Column(name = "BIO_PCR", unique = false, length = 10, nullable = false)
	private Double pcr;

	@Column(name = "BIO_FERRETINA", unique = false, length = 10, nullable = false)
	private Double ferretina;

	@Column(name = "BIO_FERRO", unique = false, length = 10, nullable = false)
	private Double ferro;

	@Column(name = "BIO_ACIDO_FOLICO", unique = false, length = 10, nullable = false)
	private Double acidoFolico;

	@Column(name = "BIO_CREATININA", unique = false, length = 10, nullable = false)
	private Double creatinina;

	@Column(name = "BIO_CREATININA_URINA", unique = false, length = 10, nullable = false)
	private Double creatininaUrina;

	@Column(name = "BIO_ACIDO_URICO", unique = false, length = 10, nullable = false)
	private Double acidoUrico;

	@Column(name = "BIO_TGO", unique = false, length = 10, nullable = false)
	private Double tgo;

	@Column(name = "BIO_TGP", unique = false, length = 10, nullable = false)
	private Double tgp;

	@Column(name = "BIO_DHL", unique = false, length = 10, nullable = false)
	private Double dhl;

	@Column(name = "BIO_VCM", unique = false, length = 10, nullable = false)
	private Double vcm;

	@Column(name = "BIO_HCM", unique = false, length = 10, nullable = false)
	private Double hcm;

	@Column(name = "BIO_CHCM", unique = false, length = 10, nullable = false)
	private Double chcm;

	@Column(name = "BIO_RDW", unique = false, length = 10, nullable = false)
	private Double rdw;

	@Column(name = "BIO_HEMOGLOBINA", unique = false, length = 10, nullable = false)
	private Double hemoglobina;

	@Column(name = "BIO_HEMATOCRITO", unique = false, length = 10, nullable = false)
	private Double hematocrito;

	@Column(name = "BIO_PLAQUETA", unique = false, length = 10, nullable = false)
	private Double plaqueta;

	@Column(name = "BIO_LEUCOCITO", unique = false, length = 10, nullable = false)
	private Double leucocito;

	@Column(name = "BIO_LINFOCITO", unique = false, length = 10, nullable = false)
	private Double linfocito;

	@Column(name = "BIO_NEUTROFILO", unique = false, length = 10, nullable = false)
	private Double neutrofilo;

	@Column(name = "BIO_GLICEMIA", unique = false, length = 10, nullable = false)
	private Double glicemia;

	@Column(name = "BIO_INSULENIMIA", unique = false, length = 10, nullable = false)
	private Double insulenimia;

	@Column(name = "BIO_T4_LIVRE", unique = false, length = 10, nullable = false)
	private Double t4Livre;

	@Column(name = "BIO_CALCIO", unique = false, length = 10, nullable = false)
	private Double calcio;

	@Column(name = "BIO_SODIO", unique = false, length = 10, nullable = false)
	private Double sodio;

	@Column(name = "BIO_POTASSIO", unique = false, length = 10, nullable = false)
	private Double potassio;

	@Column(name = "BIO_DATA", unique = false, nullable = false)
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

	public Double getProteinasTotais() {
		return proteinasTotais;
	}

	public void setProteinasTotais(Double proteinasTotais) {
		this.proteinasTotais = proteinasTotais;
	}

	public Double getAlbumina() {
		return albumina;
	}

	public void setAlbumina(Double albumina) {
		this.albumina = albumina;
	}

	public Double getPreAlbumina() {
		return preAlbumina;
	}

	public void setPreAlbumina(Double preAlbumina) {
		this.preAlbumina = preAlbumina;
	}

	public Double getPcr() {
		return pcr;
	}

	public void setPcr(Double pcr) {
		this.pcr = pcr;
	}

	public Double getFerretina() {
		return ferretina;
	}

	public void setFerretina(Double ferretina) {
		this.ferretina = ferretina;
	}

	public Double getFerro() {
		return ferro;
	}

	public void setFerro(Double ferro) {
		this.ferro = ferro;
	}

	public Double getAcidoFolico() {
		return acidoFolico;
	}

	public void setAcidoFolico(Double acidoFolico) {
		this.acidoFolico = acidoFolico;
	}

	public Double getCreatinina() {
		return creatinina;
	}

	public void setCreatinina(Double creatinina) {
		this.creatinina = creatinina;
	}

	public Double getCreatininaUrina() {
		return creatininaUrina;
	}

	public void setCreatininaUrina(Double creatininaUrina) {
		this.creatininaUrina = creatininaUrina;
	}

	public Double getAcidoUrico() {
		return acidoUrico;
	}

	public void setAcidoUrico(Double acidoUrico) {
		this.acidoUrico = acidoUrico;
	}

	public Double getTgo() {
		return tgo;
	}

	public void setTgo(Double tgo) {
		this.tgo = tgo;
	}

	public Double getTgp() {
		return tgp;
	}

	public void setTgp(Double tgp) {
		this.tgp = tgp;
	}

	public Double getDhl() {
		return dhl;
	}

	public void setDhl(Double dhl) {
		this.dhl = dhl;
	}

	public Double getVcm() {
		return vcm;
	}

	public void setVcm(Double vcm) {
		this.vcm = vcm;
	}

	public Double getHcm() {
		return hcm;
	}

	public void setHcm(Double hcm) {
		this.hcm = hcm;
	}

	public Double getChcm() {
		return chcm;
	}

	public void setChcm(Double chcm) {
		this.chcm = chcm;
	}

	public Double getRdw() {
		return rdw;
	}

	public void setRdw(Double rdw) {
		this.rdw = rdw;
	}

	public Double getHemoglobina() {
		return hemoglobina;
	}

	public void setHemoglobina(Double hemoglobina) {
		this.hemoglobina = hemoglobina;
	}

	public Double getHematocrito() {
		return hematocrito;
	}

	public void setHematocrito(Double hematocrito) {
		this.hematocrito = hematocrito;
	}

	public Double getPlaqueta() {
		return plaqueta;
	}

	public void setPlaqueta(Double plaqueta) {
		this.plaqueta = plaqueta;
	}

	public Double getLeucocito() {
		return leucocito;
	}

	public void setLeucocito(Double leucocito) {
		this.leucocito = leucocito;
	}

	public Double getLinfocito() {
		return linfocito;
	}

	public void setLinfocito(Double linfocito) {
		this.linfocito = linfocito;
	}

	public Double getNeutrofilo() {
		return neutrofilo;
	}

	public void setNeutrofilo(Double neutrofilo) {
		this.neutrofilo = neutrofilo;
	}

	public Double getGlicemia() {
		return glicemia;
	}

	public void setGlicemia(Double glicemia) {
		this.glicemia = glicemia;
	}

	public Double getInsulenimia() {
		return insulenimia;
	}

	public void setInsulenimia(Double insulenimia) {
		this.insulenimia = insulenimia;
	}

	public Double getT4Livre() {
		return t4Livre;
	}

	public void setT4Livre(Double t4Livre) {
		this.t4Livre = t4Livre;
	}

	public Double getCalcio() {
		return calcio;
	}

	public void setCalcio(Double calcio) {
		this.calcio = calcio;
	}

	public Double getSodio() {
		return sodio;
	}

	public void setSodio(Double sodio) {
		this.sodio = sodio;
	}

	public Double getPotassio() {
		return potassio;
	}

	public void setPotassio(Double potassio) {
		this.potassio = potassio;
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
