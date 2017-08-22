package edu.fatec.sjc.service;

import edu.fatec.sjc.model.Familiar;

public interface FamiliarService {
	
	public Familiar salvarFamiliar(Familiar familiar);
	
	public Familiar buscarFamiliar(String doenca);
	
}
