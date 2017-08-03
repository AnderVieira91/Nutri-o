package edu.fatec.sjc.service;

import java.util.List;

import edu.fatec.sjc.model.Crianca;

public interface CriancaService {
	
	public Crianca salvarCrianca(Crianca crianca);
	
	public List<Crianca> buscarLista(String nome);
	
	public Crianca buscarId(Long id);

}
