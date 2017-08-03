package edu.fatec.sjc.service;

import edu.fatec.sjc.model.Clinico;

public interface ClinicoService {
	
	public Clinico salvarClinico(Clinico clinico);
	
	public Clinico buscarDoenca(String doenca);

}
