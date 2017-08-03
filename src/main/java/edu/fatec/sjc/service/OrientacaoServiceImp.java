package edu.fatec.sjc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.fatec.sjc.model.Orientacao;
import edu.fatec.sjc.repository.OrientacaoRepositorio;

@Service("orientacaoService")
public class OrientacaoServiceImp implements OrientacaoService{
	
	@Autowired
	private OrientacaoRepositorio orientacaoRepo;
	
	public OrientacaoRepositorio getOrientacaoRepo() {
		return orientacaoRepo;
	}

	public void setOrientacaoRepo(OrientacaoRepositorio orientacaoRepo) {
		this.orientacaoRepo = orientacaoRepo;
	}

	public Orientacao salvarOrientacao(Orientacao orientacao) {
		return orientacaoRepo.save(orientacao);
	}

}
