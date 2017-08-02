package edu.fatec.sjc.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import edu.fatec.sjc.model.Crianca;
import edu.fatec.sjc.model.Remedio;

public interface RemedioRepositorio extends CrudRepository<Remedio, Long> {
	
	public Remedio findByNome(String nome);
	
	public List<Remedio> findByCrianca(Crianca crianca);

}
