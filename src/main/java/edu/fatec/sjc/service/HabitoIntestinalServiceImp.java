package edu.fatec.sjc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.fatec.sjc.model.HabitoIntestinal;
import edu.fatec.sjc.repository.HabitoIntestinalRepositorio;

@Service("habitoIntestinalService")
public class HabitoIntestinalServiceImp implements HabitoIntestinalService {
	
	@Autowired
	private HabitoIntestinalRepositorio habIntRepo;
	
	public HabitoIntestinalRepositorio getHabIntRepo() {
		return habIntRepo;
	}

	public void setHabIntRepo(HabitoIntestinalRepositorio habIntRepo) {
		this.habIntRepo = habIntRepo;
	}

	public HabitoIntestinal salvarHabInt(HabitoIntestinal habInt) {
	
		return habIntRepo.save(habInt);
	}

}
