package edu.fatec.sjc.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import edu.fatec.sjc.model.Crianca;
import edu.fatec.sjc.model.HabitoUrinario;

public interface HabitoUrinarioRepositorio extends CrudRepository<HabitoUrinario, Long> {
	
	public List<HabitoUrinario> findByCriancaOderByDataAsc(Crianca crianca);

}
