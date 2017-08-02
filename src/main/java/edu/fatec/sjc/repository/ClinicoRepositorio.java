package edu.fatec.sjc.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import edu.fatec.sjc.model.Clinico;
import edu.fatec.sjc.model.Crianca;

public interface ClinicoRepositorio extends CrudRepository<Clinico, Long> {
	
	public Clinico findByDoenca(String doenca);
	
	public List<Clinico> findByCriancaOderByDataAsc(Crianca crianca);

}
