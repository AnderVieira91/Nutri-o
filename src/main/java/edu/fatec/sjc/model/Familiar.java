package edu.fatec.sjc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "FAM_FAMILIAR")
public class Familiar {
	
	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	@Column(name = "FAM_ID")
	private Long id;
	
	@Column(name = "FAM_DOENCA", unique = false, length = 30, nullable = false)
	private String doenca;
	
	@Column(name = "FAM_PARENTESCO", unique = false, length = 1, nullable = false)
	private String parentesco;
	
	@ManyToOne
	@JoinColumn(name = "CRI_ID")
	private Crianca crianca;

}
