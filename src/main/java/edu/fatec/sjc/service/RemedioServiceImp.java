package edu.fatec.sjc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.fatec.sjc.model.Remedio;
import edu.fatec.sjc.repository.RemedioRepositorio;

@Service("remedioService")
public class RemedioServiceImp implements RemedioService {

	@Autowired
	private RemedioRepositorio remedioRepo;
	
	public RemedioRepositorio getRemedioRepo() {
		return remedioRepo;
	}


	public void setRemedioRepo(RemedioRepositorio remedioRepo) {
		this.remedioRepo = remedioRepo;
	}


	public Remedio salvarRemedio(Remedio remedio) {
	
		return remedioRepo.save(remedio);
	}

	
	public Remedio buscarNome(String nome) {
		Remedio r = remedioRepo.findByNome(nome);
		if(r != null){
			return r;
		}
		r = new Remedio();
		r.setId(0L);
		return r;
	}

}
