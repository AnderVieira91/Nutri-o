package edu.fatec.sjc.repository;

import org.springframework.data.repository.CrudRepository;

import edu.fatec.sjc.model.Clinico;

public interface ClinicoRepositorio extends CrudRepository<Clinico, Long> {
	
	public Clinico findByDoenca(String doenca);
	

}
