package edu.fatec.sjc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.fatec.sjc.model.Familiar;
import edu.fatec.sjc.repository.FamiliarRepositorio;

@Service("familiarService")
public class FamiliarServiceImp implements FamiliarService {
	
	@Autowired
	private FamiliarRepositorio familiarRepo; 
	
	public FamiliarRepositorio getFamiliarRepo() {
		return familiarRepo;
	}

	public void setFamiliarRepo(FamiliarRepositorio familiarRepo) {
		this.familiarRepo = familiarRepo;
	}

	public Familiar salvarFamiliar(Familiar familiar) {
		return familiarRepo.save(familiar);
	}

}
