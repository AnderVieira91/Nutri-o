package edu.fatec.sjc.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import edu.fatec.sjc.model.Bioquimico;
import edu.fatec.sjc.model.Crianca;

public interface BioquimicoRepositorio extends CrudRepository<Bioquimico, Long> {
	
	public List<Bioquimico> findByCriancaOderByDataAsc(Crianca crianca);

}
