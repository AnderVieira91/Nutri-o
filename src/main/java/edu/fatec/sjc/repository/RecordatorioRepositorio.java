package edu.fatec.sjc.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import edu.fatec.sjc.model.Crianca;
import edu.fatec.sjc.model.Recordatorio;

public interface RecordatorioRepositorio extends CrudRepository<Recordatorio, Long> {
	
	public List<Recordatorio> findByCriancaOderByDataAsc(Crianca crianca);

}
