package edu.fatec.sjc.service;

import java.util.List;

import edu.fatec.sjc.model.Crianca;
import edu.fatec.sjc.model.Orientacao;

public interface OrientacaoService {
	
	public Orientacao salvarOrientacao(Orientacao orientacao);
	
	public List<Orientacao> retornarOrientacoes(Crianca crianca);

}
