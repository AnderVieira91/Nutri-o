package edu.fatec.sjc.internet;

import org.springframework.beans.factory.annotation.Autowired;

import edu.fatec.sjc.model.Crianca;
import edu.fatec.sjc.model.Remedio;
import edu.fatec.sjc.repository.CriancaRepositorio;
import edu.fatec.sjc.repository.RemedioRepositorio;

public class Teste {
	
	@Autowired
	private RemedioRepositorio remedioRepo;
	@Autowired
	private CriancaRepositorio criancaRepo;

	public CriancaRepositorio getCriancaRepo() {
		return criancaRepo;
	}

	public void setCriancaRepo(CriancaRepositorio criancaRepo) {
		this.criancaRepo = criancaRepo;
	}

	public RemedioRepositorio getRemedioRepo() {
		return remedioRepo;
	}

	public void setRemedioRepo(RemedioRepositorio remedioRepo) {
		this.remedioRepo = remedioRepo;
	}
	
	public Crianca c(){
		Crianca crianca = new Crianca();
		crianca = criancaRepo.findById(1L);
		return crianca;
	}
	
	public Remedio t(){
		Remedio r = new Remedio();
		r.setId(2L);
		r.setNome("diclofenaco");
		r = remedioRepo.save(r);
		return r;
	}
	
	public static void main(String[] args){
		Teste t = new Teste();
		Crianca r = t.c();
		System.out.println(r.getId());
	}

}
