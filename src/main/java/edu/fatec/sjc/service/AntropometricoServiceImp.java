package edu.fatec.sjc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.fatec.sjc.model.Antropometrico;
import edu.fatec.sjc.model.Crianca;
import edu.fatec.sjc.repository.AntropometricoRepositorio;

@Service("antropometricoService")
public class AntropometricoServiceImp implements AntropometricoService {
	
	@Autowired
	private AntropometricoRepositorio antroRepo;
	
	public AntropometricoRepositorio getAntroRepo() {
		return antroRepo;
	}

	public void setAntroRepo(AntropometricoRepositorio antroRepo) {
		this.antroRepo = antroRepo;
	}

	public Antropometrico salvarAntropometrico(Antropometrico antropometrico) {
		return antroRepo.save(antropometrico);
	}

	public List<Antropometrico> buscarCrianca(Crianca crianca) {
		return antroRepo.findByCrianca(crianca);
	}

}
