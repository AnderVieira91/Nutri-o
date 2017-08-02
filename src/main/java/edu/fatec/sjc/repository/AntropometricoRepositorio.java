package edu.fatec.sjc.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import edu.fatec.sjc.model.Antropometrico;
import edu.fatec.sjc.model.Crianca;

public interface AntropometricoRepositorio extends CrudRepository<Antropometrico, Long> {
	
	public List<Antropometrico> findByCriancaOderByDataAsc(Crianca crianca);

}
