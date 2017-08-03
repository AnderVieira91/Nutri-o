package edu.fatec.sjc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.fatec.sjc.model.HabitoUrinario;
import edu.fatec.sjc.repository.HabitoUrinarioRepositorio;

@Service("habitoUrinarioService")
public class HabitoUrinarioServiceImp implements HabitoUrinarioService {
	
	@Autowired
	private HabitoUrinarioRepositorio habUriRepo;
	
	public HabitoUrinarioRepositorio getHabUriRepo() {
		return habUriRepo;
	}

	public void setHabUriRepo(HabitoUrinarioRepositorio habUriRepo) {
		this.habUriRepo = habUriRepo;
	}

	public HabitoUrinario salvarHabUri(HabitoUrinario habUri) {
		return habUriRepo.save(habUri);
	}

}
