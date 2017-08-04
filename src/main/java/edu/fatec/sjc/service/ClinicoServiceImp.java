package edu.fatec.sjc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.fatec.sjc.model.Clinico;
import edu.fatec.sjc.repository.ClinicoRepositorio;

@Service("clinicoService")
public class ClinicoServiceImp implements ClinicoService {

	@Autowired
	private ClinicoRepositorio clinicoRepo;

	public ClinicoRepositorio getClinicoRepo() {
		return clinicoRepo;
	}

	public void setClinicoRepo(ClinicoRepositorio clinicoRepo) {
		this.clinicoRepo = clinicoRepo;
	}

	public Clinico salvarClinico(Clinico clinico) {

		return clinicoRepo.save(clinico);
	}

	public Clinico buscarDoenca(String doenca) {
		Clinico c = clinicoRepo.findByDoenca(doenca);
		if(c != null){
			return c;
		}
		c = new Clinico();
		c.setId(0L);
		return c;
	}

}
