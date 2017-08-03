package edu.fatec.sjc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.fatec.sjc.model.HabitoAlimentar;
import edu.fatec.sjc.repository.HabitoAlimentarRepositorio;

@Service("habitoAlimentarService")
public class HabitoAlimentarServiceImp implements HabitoAlimentarService {
	
	@Autowired
	private HabitoAlimentarRepositorio habAliRepo;
	
	public HabitoAlimentarRepositorio getHabAliRepo() {
		return habAliRepo;
	}

	public void setHabAliRepo(HabitoAlimentarRepositorio habAliRepo) {
		this.habAliRepo = habAliRepo;
	}

	@Override
	public HabitoAlimentar salvarHabAli(HabitoAlimentar habAli) {
		return habAliRepo.save(habAli);
	}

}
