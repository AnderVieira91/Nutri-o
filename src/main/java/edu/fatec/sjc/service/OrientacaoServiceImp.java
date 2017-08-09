package edu.fatec.sjc.service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.fatec.sjc.model.Crianca;
import edu.fatec.sjc.model.Orientacao;
import edu.fatec.sjc.repository.OrientacaoRepositorio;

@Service("orientacaoService")
public class OrientacaoServiceImp implements OrientacaoService{
	
	@Autowired
	private OrientacaoRepositorio orientacaoRepo;
	
	public OrientacaoRepositorio getOrientacaoRepo() {
		return orientacaoRepo;
	}

	public void setOrientacaoRepo(OrientacaoRepositorio orientacaoRepo) {
		this.orientacaoRepo = orientacaoRepo;
	}

	public Orientacao salvarOrientacao(Orientacao orientacao) {
		return orientacaoRepo.save(orientacao);
	}

	public List<Orientacao> retornarOrientacoes(Crianca crianca) {
		List<Orientacao> orientacoes = orientacaoRepo.findByCriancaOrderByDataDesc(crianca);
		Date data;
		try{
		  data = (Date) orientacoes.get(0).getData();
		} catch(Exception e) {
			
			return null;
			
		}
		return orientacaoRepo.retornarOrientacoes(data, crianca);
	}

}
