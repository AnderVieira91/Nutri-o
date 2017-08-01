package edu.fatec.sjc.tela;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import edu.fatec.sjc.tela.Padrao.CriancaPadrao;

public class TelaPrincipal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
	private JMenuItem dadosRemedios = new JMenuItem("Remédio");
	private JMenu mnCadastrarDados = new JMenu("Cadastrar Dados");;

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
		setTitle("Tela Principal");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		menuBar.add(mnCadastrarDados);
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
		mnCadastrarDados.add(dadosBioquimicos);
		mnCadastrarDados.add(dadosClinicos);
		mnCadastrarDados.add(dadosFamiliares);
		mnCadastrarDados.add(dadosHabAli);
		mnCadastrarDados.add(dadosHabUri);
		mnCadastrarDados.add(dadosHabInt);
		mnCadastrarDados.add(dadosOrientacao);
		mnCadastrarDados.add(dadosRecordatorio);
		mnCadastrarDados.add(dadosRemedios);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING).addGap(0, 424, Short.MAX_VALUE));
		gl_contentPane.setVerticalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING).addGap(0, 252, Short.MAX_VALUE));
		contentPane.setLayout(gl_contentPane);

	}

	private void cadastrar() {
		TelaCadastro frame = new TelaCadastro();
		frame.setVisible(true);
	}

	public void antro() {
		if (CriancaPadrao.crianca.getId() != null) {
			TelaAntropometria frame = new TelaAntropometria();
			frame.setVisible(true);
		}
	}

	public void bio() {
		if (CriancaPadrao.crianca.getId() != null) {
			TelaBioquimico frame = new TelaBioquimico();
			frame.setVisible(true);
		}
	}


}
