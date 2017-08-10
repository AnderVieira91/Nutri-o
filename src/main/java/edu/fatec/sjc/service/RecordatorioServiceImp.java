package edu.fatec.sjc.service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.fatec.sjc.model.Crianca;
import edu.fatec.sjc.model.Recordatorio;
import edu.fatec.sjc.repository.RecordatorioRepositorio;

@Service("recordatorioService")
public class RecordatorioServiceImp implements RecordatorioService {

	@Autowired
	private RecordatorioRepositorio recordatorioRepo;

	public RecordatorioRepositorio getRecordatorioRepo() {
		return recordatorioRepo;
	}

	public void setRecordatorioRepo(RecordatorioRepositorio recordatorioRepo) {
		this.recordatorioRepo = recordatorioRepo;
	}

	public Recordatorio salvarRecordatorio(Recordatorio recordatorio) {
		return recordatorioRepo.save(recordatorio);
	}

	public List<Recordatorio> buscarRecordatorios(Crianca crianca) {
		List<Recordatorio> recordatorios = recordatorioRepo.findByCriancaOrderByDataDesc(crianca);
		Date data;
		try {
			data = (Date) recordatorios.get(0).getData();
		} catch (Exception e) {

			return null;

		}
		return recordatorioRepo.retornarRecordatorios(data, crianca);
	}

}
