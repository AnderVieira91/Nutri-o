package edu.fatec.sjc.repository;

import org.springframework.data.repository.CrudRepository;

import edu.fatec.sjc.model.Familiar;

public interface FamiliarRepositorio extends CrudRepository<Familiar, Long> {
	
	public Familiar findByDoenca(String doenca);

}
