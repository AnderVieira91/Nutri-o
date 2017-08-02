package edu.fatec.sjc.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import edu.fatec.sjc.model.Crianca;
import edu.fatec.sjc.model.HabitoIntestinal;

public interface HabitoIntestinalRepositorio extends CrudRepository<HabitoIntestinal, Long> {
	
	public List<HabitoIntestinal> findByCriancaOderByDataAsc(Crianca crianca);

}
