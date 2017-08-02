package edu.fatec.sjc.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import edu.fatec.sjc.model.Crianca;
import edu.fatec.sjc.model.Familiar;

public interface FamiliarRepositorio extends CrudRepository<Familiar, Long> {
	
	public List<Familiar> findByCriancaOderByDataAsc(Crianca crianca);

}
