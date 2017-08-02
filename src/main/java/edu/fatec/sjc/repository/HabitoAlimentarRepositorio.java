package edu.fatec.sjc.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import edu.fatec.sjc.model.Crianca;
import edu.fatec.sjc.model.HabitoAlimentar;

public interface HabitoAlimentarRepositorio extends CrudRepository<HabitoAlimentar, Long> {
	
	public List<HabitoAlimentar> findByCriancaOderByDataAsc(Crianca crianca);

}
