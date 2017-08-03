package edu.fatec.sjc.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import edu.fatec.sjc.model.Crianca;


public interface CriancaRepositorio extends CrudRepository<Crianca, Long> {
	
	public List<Crianca> findByNomeIgnoreCaseContaining(String nome);
	
	public Crianca findById(Long id);

}
