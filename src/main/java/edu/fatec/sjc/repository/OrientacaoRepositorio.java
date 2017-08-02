package edu.fatec.sjc.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import edu.fatec.sjc.model.Crianca;
import edu.fatec.sjc.model.Orientacao;

public interface OrientacaoRepositorio extends CrudRepository<Orientacao, Long> {
	
	public List<Orientacao> findByCriancaOderByDataAsc(Crianca crianca);

}
