package edu.fatec.sjc.service;

import edu.fatec.sjc.model.Remedio;

public interface RemedioService {
	
	public Remedio salvarRemedio(Remedio remedio);
	
	public Remedio buscarNome(String nome);

}
