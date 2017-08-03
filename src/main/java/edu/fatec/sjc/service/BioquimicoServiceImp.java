package edu.fatec.sjc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.fatec.sjc.model.Bioquimico;
import edu.fatec.sjc.repository.BioquimicoRepositorio;

@Service("bioquimicoService")
public class BioquimicoServiceImp implements BioquimicoService {
	
	@Autowired
	private BioquimicoRepositorio bioRepo;
	
	public BioquimicoRepositorio getBioRepo() {
		return bioRepo;
	}

	public void setBioRepo(BioquimicoRepositorio bioRepo) {
		this.bioRepo = bioRepo;
	}

	public Bioquimico salvarBioquimico(Bioquimico bioquimico) {
		return bioRepo.save(bioquimico);
	}

}
