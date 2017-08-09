package edu.fatec.sjc.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import edu.fatec.sjc.model.Crianca;
import edu.fatec.sjc.model.Recordatorio;

public interface RecordatorioRepositorio extends CrudRepository<Recordatorio, Long> {
	
	public List<Recordatorio> findByCriancaOrderByDataDesc(Crianca crianca);
	
	@Query("select r from Recordatorio r where r.data = ?1 and r.crianca = ?2")
	public List<Recordatorio> retornarRecordatorios(Date data, Crianca crianca);
	
	
}
