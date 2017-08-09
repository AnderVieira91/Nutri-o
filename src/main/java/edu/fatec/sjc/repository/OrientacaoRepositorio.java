package edu.fatec.sjc.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import edu.fatec.sjc.model.Crianca;
import edu.fatec.sjc.model.Orientacao;

public interface OrientacaoRepositorio extends CrudRepository<Orientacao, Long> {
	
	
	public List<Orientacao> findByCriancaOrderByDataDesc(Crianca crianca);
	
	@Query("select o from Orientacao o where o.data = ?1 and o.crianca = ?2")
	public List<Orientacao> retornarOrientacoes(Date data, Crianca crianca);
	

}
