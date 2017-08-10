package edu.fatec.sjc.service;

import java.util.List;

import edu.fatec.sjc.model.Crianca;
import edu.fatec.sjc.model.Recordatorio;

public interface RecordatorioService {
	
	public Recordatorio salvarRecordatorio(Recordatorio recordatorio);
	
	public List<Recordatorio> buscarRecordatorios(Crianca crianca);

}
