package edu.fatec.sjc.tela;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import org.jfree.data.category.DefaultCategoryDataset;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.fatec.sjc.grafico.Desenho;
import edu.fatec.sjc.grafico.Grafico;
import edu.fatec.sjc.grafico.Menina;
import edu.fatec.sjc.grafico.Menino;
import edu.fatec.sjc.model.Antropometrico;
import edu.fatec.sjc.model.Crianca;
import edu.fatec.sjc.service.AntropometricoService;
import edu.fatec.sjc.service.CriancaService;
import edu.fatec.sjc.tela.Padrao.CriancaPadrao;

public class TelaPrincipal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private CriancaService criancaService;
	private AntropometricoService antropometricoService;
	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenuItem novoPaciente = new JMenuItem("Novo paciente");
	private JMenuItem dadosAntropometricos = new JMenuItem("Antropometria");
	private JMenuItem dadosBioquimicos = new JMenuItem("Bioquímico");
	private JMenuItem dadosClinicos = new JMenuItem("Clínico");
	private JMenuItem dadosFamiliares = new JMenuItem("Familiar");
	private JMenuItem dadosHabAli = new JMenuItem("Hábito alimentar");
	private JMenuItem dadosHabUri = new JMenuItem("Hábito urinário");
	private JMenuItem dadosHabInt = new JMenuItem("Hábito intestinal");
	private JMenuItem dadosOrientacao = new JMenuItem("Orientação");
	private JMenuItem dadosRecordatorio = new JMenuItem("Recordatório");
	private JMenuItem exibirOrientacao = new JMenuItem("Orientação");
	private JMenuItem exibirRecordatorio = new JMenuItem("Recordatório");
	private JMenuItem dadosRemedios = new JMenuItem("Remédio");
	private JMenu mnCadastrarDados = new JMenu("Cadastrar Dados");
	private JMenu mnExibirDados = new JMenu("Exibir Dados");
	private JTextField textBusca;
	private JComboBox listaBusca;
	private JLabel lblCrianca;
	private final JLabel lblIdade = new JLabel("IDADE:");
	private JLabel lblIdadeCalculada = new JLabel("");
	private Period p;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal frame = new TelaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaPrincipal() {
		lblIdadeCalculada.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblIdade.setFont(new Font("Tahoma", Font.PLAIN, 18));
		setTitle("Tela Principal");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);

		menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		menuBar.add(mnCadastrarDados);
		menuBar.add(mnExibirDados);
		novoPaciente.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				cadastrar();
			}
		});

		mnCadastrarDados.add(novoPaciente);
		dadosAntropometricos.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				antro();
			}
		});
		mnCadastrarDados.add(dadosAntropometricos);
		dadosBioquimicos.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				bio();
			}
		});
		dadosClinicos.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				cli();
			}
		});
		dadosFamiliares.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				fam();
			}
		});
		dadosHabAli.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				ali();
			}
		});
		dadosHabUri.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				uri();
			}
		});
		dadosHabInt.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				inte();
			}
		});
		dadosOrientacao.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				ori();
			}
		});
		dadosRecordatorio.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				rec();
			}
		});
		dadosRemedios.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				rem();
			}
		});
		mnCadastrarDados.add(dadosBioquimicos);
		mnCadastrarDados.add(dadosClinicos);
		mnCadastrarDados.add(dadosFamiliares);
		mnCadastrarDados.add(dadosHabAli);
		mnCadastrarDados.add(dadosHabUri);
		mnCadastrarDados.add(dadosHabInt);
		mnCadastrarDados.add(dadosOrientacao);
		mnCadastrarDados.add(dadosRecordatorio);
		mnCadastrarDados.add(dadosRemedios);
		
		exibirOrientacao.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				eOri();
			}
		});
		
		exibirRecordatorio.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				eRec();
			}
		});
		
		mnExibirDados.add(exibirOrientacao);
		mnExibirDados.add(exibirRecordatorio);

		contentPane = new JPanel();
		contentPane.setToolTipText("");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		textBusca = new JTextField();
		textBusca.setColumns(10);

		JButton btnBuscar = new JButton("BUSCAR");
		btnBuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				buscarCriancas();
			}
		});

		listaBusca = new JComboBox();

		listaBusca.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					setCrianca();
				}
			}
		});

		JLabel lblPaciente = new JLabel("PACIENTE:");
		lblPaciente.setFont(new Font("Tahoma", Font.PLAIN, 18));

		lblCrianca = new JLabel("NENHUM PACIENTE SELECIONADO");
		lblCrianca.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JButton btnPesoXIdade = new JButton("PESO X IDADE");

		JButton btnAlturaXIdade = new JButton("ALTURA X IDADE");

		JButton btnPermetroCeflico = new JButton("PERÍMETRO CEFÁLICO");
		btnPermetroCeflico.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				perimetroCefalico();
			}
		});

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup()
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(listaBusca, GroupLayout.PREFERRED_SIZE, 475, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(textBusca, GroupLayout.PREFERRED_SIZE, 475, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED).addComponent(btnBuscar))
						.addGroup(gl_contentPane.createSequentialGroup().addContainerGap()
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(lblPaciente).addComponent(lblIdade))
								.addGap(64)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(lblIdadeCalculada).addComponent(lblCrianca)))
						.addGroup(gl_contentPane.createSequentialGroup().addComponent(btnPesoXIdade)
								.addPreferredGap(ComponentPlacement.RELATED).addComponent(btnAlturaXIdade)
								.addPreferredGap(ComponentPlacement.RELATED).addComponent(btnPermetroCeflico)))
				.addContainerGap(700, Short.MAX_VALUE)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup().addGap(23)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(lblPaciente)
								.addComponent(lblCrianca))
						.addGap(22)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(lblIdade)
								.addComponent(lblIdadeCalculada))
						.addGap(18)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(textBusca, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(btnBuscar))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(listaBusca, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addGap(26)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(btnPesoXIdade)
								.addComponent(btnAlturaXIdade).addComponent(btnPermetroCeflico))
						.addContainerGap(446, Short.MAX_VALUE)));
		contentPane.setLayout(gl_contentPane);

	}

	private void cadastrar() {
		TelaCadastro frame = new TelaCadastro();
		frame.setVisible(true);
	}

	private void antro() {
		if (CriancaPadrao.crianca.getId() != null) {
			TelaAntropometria frame = new TelaAntropometria();
			frame.setVisible(true);
		}
	}

	private void bio() {
		if (CriancaPadrao.crianca.getId() != null) {
			TelaBioquimico frame = new TelaBioquimico();
			frame.setVisible(true);
		}
	}

	private void cli() {
		if (CriancaPadrao.crianca.getId() != null) {
			TelaClinico frame = new TelaClinico();
			frame.setVisible(true);
		}
	}

	private void fam() {
		if (CriancaPadrao.crianca.getId() != null) {
			TelaFamiliar frame = new TelaFamiliar();
			frame.setVisible(true);
		}
	}

	private void ali() {
		if (CriancaPadrao.crianca.getId() != null) {
			TelaHabitoAlimentar frame = new TelaHabitoAlimentar();
			frame.setVisible(true);
		}
	}

	private void inte() {
		if (CriancaPadrao.crianca.getId() != null) {
			TelaHabitoIntestinal frame = new TelaHabitoIntestinal();
			frame.setVisible(true);
		}
	}

	private void uri() {
		if (CriancaPadrao.crianca.getId() != null) {
			TelaHabitoUrinario frame = new TelaHabitoUrinario();
			frame.setVisible(true);
		}
	}

	private void ori() {
		if (CriancaPadrao.crianca.getId() != null) {
			TelaOrientacao frame = new TelaOrientacao();
			frame.setVisible(true);
		}
	}

	private void rec() {
		if (CriancaPadrao.crianca.getId() != null) {
			TelaRecordatorio frame = new TelaRecordatorio();
			frame.setVisible(true);
		}
	}

	private void rem() {
		if (CriancaPadrao.crianca.getId() != null) {
			TelaRemedio frame = new TelaRemedio();
			frame.setVisible(true);
		}
	}
	
	private void eRec() {
		if (CriancaPadrao.crianca.getId() != null) {
			TelaExibicaoRecordatorio frame = new TelaExibicaoRecordatorio();
			frame.setVisible(true);
		}
	}
	
	private void eOri() {
		if (CriancaPadrao.crianca.getId() != null) {
			TelaExibicaoOrientacao frame = new TelaExibicaoOrientacao();
			frame.setVisible(true);
		}
	}

	private void buscarCriancas() {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		criancaService = (CriancaService) context.getBean("criancaService");
		
		int a = 0;
		String nome = textBusca.getText().toUpperCase();
		if (!nome.equals("") && nome != null) {
			List<Crianca> criancas = criancaService.buscarLista(nome);
			String[] s = new String[criancas.size() + 1];
			s[a++] = "Selecione o paciente";
			for (Crianca c : criancas) {
				s[a] = "ID:" + c.getId() + " " + c.getNome();
				a++;
			}

			listaBusca.setModel(new DefaultComboBoxModel(s));
		}
	}

	private void setCrianca() {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		criancaService = (CriancaService) context.getBean("criancaService");
		
		String a = listaBusca.getSelectedItem().toString();
		String[] buscaId = a.split(" ");
		Long id = Long.valueOf(buscaId[0].replaceAll("ID:", ""));
		CriancaPadrao.crianca = criancaService.buscarId(id);
		if (CriancaPadrao.crianca.getId() != null) {
			lblCrianca.setText(CriancaPadrao.crianca.getNome());
			LocalDate hoje = LocalDate.now();
			java.util.Date d = new Date(CriancaPadrao.crianca.getNascimento().getTime());
			LocalDate nascimento = d.toInstant().atZone(ZoneId.systemDefault())
					.toLocalDate();
			p = Period.between(nascimento, hoje);
			String idade = p.getYears() + " ANOS " + p.getMonths() + " MESES E " + p.getDays() + " DIAS";
			lblIdadeCalculada.setText(idade);
		}
	}

	private void perimetroCefalico() {
		if (CriancaPadrao.crianca.getId() != null) {
			
			if (CriancaPadrao.crianca.getSexo().equals("M")) {
				if (p.getYears() < 2 || (p.getYears() == 2 && p.getMonths() == 0)) {
					Menino m = new Menino();
					double[] min = m.getPerimetroMinimo();
					double[] max = m.getPerimetroMaximo();

					Desenho desenho = new Desenho();
					DefaultCategoryDataset ds = desenho.getDs(0, 2, min, max);
					List<Antropometrico> antro = CriancaPadrao.crianca.getAntropometricos();
										
					java.util.Date d = new Date(CriancaPadrao.crianca.getNascimento().getTime());
					LocalDate nascimento = d.toInstant().atZone(ZoneId.systemDefault())
							.toLocalDate();
					
					for(Antropometrico a : antro ){
						
						java.util.Date e = new Date(a.getData().getTime());
						LocalDate intervalo = e.toInstant().atZone(ZoneId.systemDefault())
								.toLocalDate();
						Period periodo = Period.between(nascimento, intervalo);
						String data = p.getYears() + "/" + p.getMonths();
						ds.addValue(a.getPerimetroCraniano(), "paciente", data);	
					}
					
					Grafico grafico = new Grafico(  "Gráfico" ,
					         "Perímetro Cefálico X Idade \n0 a 2 anos", "IDADE", "PERÍMETRO CEFÁLICO (cm)", ds);
					grafico.setVisible(true);
					
				}
			}
			
			if (CriancaPadrao.crianca.getSexo().equals("F")) {
				if (p.getYears() < 2 || (p.getYears() == 2 && p.getMonths() == 0)) {
					Menina m = new Menina();
					double[] min = m.getPerimetroMinimo();
					double[] max = m.getPerimetroMaximo();

					Desenho desenho = new Desenho();
					DefaultCategoryDataset ds = desenho.getDs(0, 2, min, max);
					List<Antropometrico> antro = CriancaPadrao.crianca.getAntropometricos();
	
					java.util.Date d = new Date(CriancaPadrao.crianca.getNascimento().getTime());
					LocalDate nascimento = d.toInstant().atZone(ZoneId.systemDefault())
							.toLocalDate();
					
					for(Antropometrico a : antro ){
						java.util.Date e = new Date(a.getData().getTime());
						LocalDate intervalo = e.toInstant().atZone(ZoneId.systemDefault())
								.toLocalDate();
						Period periodo = Period.between(nascimento, intervalo);
						String data = p.getYears() + "/" + p.getMonths();
						ds.addValue(a.getPerimetroCraniano(), "paciente", data);	
					}
					
					Grafico grafico = new Grafico(  "Gráfico" ,
					         "Perímetro Cefálico X Idade \n0 a 2 anos", "IDADE", "PERÍMETRO CEFÁLICO (cm)", ds);
					grafico.setVisible(true);
					
				}
			}

		}
	}
}
