package edu.fatec.sjc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.fatec.sjc.model.Crianca;
import edu.fatec.sjc.repository.CriancaRepositorio;

@Service("criancaService")
public class CriancaServiceImp implements CriancaService{
	
	@Autowired
	CriancaRepositorio criancaRepositorio;
	
	
	public CriancaRepositorio getCriancaRepositorio() {
		return criancaRepositorio;
	}


	public void setCriancaRepositorio(CriancaRepositorio criancaRepositorio) {
		this.criancaRepositorio = criancaRepositorio;
	}


	public Crianca salvarCrianca(Crianca crianca) {
		crianca = criancaRepositorio.save(crianca);
		return crianca;
	}
	
	public List<Crianca> buscarLista(String nome) {
		
		return criancaRepositorio.findByNomeIgnoreCaseContaining(nome);
	}

	public Crianca buscarId(Long id) {
		
		return criancaRepositorio.findById(id);
	}

}
