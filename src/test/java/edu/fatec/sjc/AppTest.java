package edu.fatec.sjc;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.fatec.sjc.model.Crianca;
import edu.fatec.sjc.model.Orientacao;
import edu.fatec.sjc.service.CriancaService;
import edu.fatec.sjc.service.OrientacaoService;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase {
	/**
	 * Create the test case
	 *
	 * @param testName
	 *            name of the test case
	 */
	public AppTest(String testName) {
		super(testName);
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
		return new TestSuite(AppTest.class);
	}

	/**
	 * Rigourous Test :-)
	 */
	public void testApp() {
		Crianca crianca = new Crianca();
		crianca.setMae("Maria");
		crianca.setPai("João");
		crianca.setNome("Joãoziinho");
		crianca.setMotivo("Teste");
		Date nascimento = new GregorianCalendar(2014, Calendar.FEBRUARY, 11).getTime();
		crianca.setNascimento(nascimento);
		crianca.setSexo("M");
		crianca.setTelefone(23445L);

		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		CriancaService criancaService = (CriancaService) context.getBean("criancaService");

		crianca = criancaService.salvarCrianca(crianca);

		List<Orientacao> orientacoes = new LinkedList<Orientacao>();
		Date date = new GregorianCalendar(2017, Calendar.JULY, 17).getTime();
		Orientacao ori = new Orientacao();
		ori.setAlimento("arroz");
		ori.setHora("12:30");
		ori.setCrianca(crianca);
		ori.setRefeicao("Almoço");
		ori.setData(date);
		orientacoes.add(ori);

		Orientacao ori2 = new Orientacao();
		ori2.setAlimento("feijão");
		ori2.setHora("12:30");
		ori2.setCrianca(crianca);
		ori2.setRefeicao("Almoço");
		ori2.setData(date);
		orientacoes.add(ori2);

		Date date2 = new GregorianCalendar(2017, Calendar.AUGUST, 18).getTime();
		Orientacao ori3 = new Orientacao();
		ori3.setAlimento("arroz");
		ori3.setHora("12:30");
		ori3.setCrianca(crianca);
		ori3.setRefeicao("Almoço");
		ori3.setData(date2);
		orientacoes.add(ori3);

		Orientacao ori4 = new Orientacao();
		ori4.setAlimento("feijão");
		ori4.setHora("12:30");
		ori4.setCrianca(crianca);
		ori4.setRefeicao("Almoço");
		ori4.setData(date2);
		orientacoes.add(ori4);

		OrientacaoService orientacaoService = (OrientacaoService) context.getBean("orientacaoService");

		for (Orientacao o : orientacoes) {
			orientacaoService.salvarOrientacao(o);
		}

		List<Orientacao> cardapio = orientacaoService.retornarOrientacoes(crianca);

		if (cardapio.size() == 2) {
			assertTrue(true);
		} else {
			assertTrue(false);
		}
	}
}
