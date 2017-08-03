package edu.fatec.sjc.service;

import java.util.List;

import edu.fatec.sjc.model.Antropometrico;
import edu.fatec.sjc.model.Crianca;

public interface AntropometricoService {
	
	public Antropometrico salvarAntropometrico(Antropometrico antropometrico);
	
	public List<Antropometrico> buscarCrianca(Crianca crianca);

}
