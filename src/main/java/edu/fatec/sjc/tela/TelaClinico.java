package edu.fatec.sjc.tela;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.LinkedList;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.fatec.sjc.model.Clinico;
import edu.fatec.sjc.model.Crianca;
import edu.fatec.sjc.service.ClinicoService;
import edu.fatec.sjc.tela.Padrao.CriancaPadrao;
import javax.swing.JTextPane;
import javax.swing.JTextArea;

public class TelaClinico extends JFrame {

	/**
	 * 
	 */
	private ClinicoService clinicoService;
	private static final long serialVersionUID = 1L;
	private List<Clinico> clinicos = CriancaPadrao.crianca.getClinicos();
	private JPanel contentPane;
	private JTextField textDoenca;
	private JTextArea textDoencas;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaClinico frame = new TelaClinico();
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
	public TelaClinico() {
		setTitle("Doença");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 405);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblCriancaPadrao = new JLabel(CriancaPadrao.crianca.getNome());
		lblCriancaPadrao.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JLabel lblDoena = new JLabel("Doença:");
		
		textDoenca = new JTextField();
		textDoenca.setColumns(10);
		
		JButton btnAdiconar = new JButton("ADICIONAR");
		btnAdiconar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				adicionar();
			}
		});
		
		textDoencas = new JTextArea();
		escreverDoencas();
				
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblDoena)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textDoenca, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(172)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(btnAdiconar)
								.addComponent(lblCriancaPadrao))))
					.addContainerGap(161, Short.MAX_VALUE))
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(textDoencas, GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblCriancaPadrao)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDoena)
						.addComponent(textDoenca, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(btnAdiconar)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textDoencas, GroupLayout.DEFAULT_SIZE, 272, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
	
	private void adicionar() {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		clinicoService = (ClinicoService) context.getBean("clinicoService");
		
		List<Crianca> crianca = new LinkedList<Crianca>();
		crianca.add(CriancaPadrao.crianca);
		String doenca = textDoenca.getText().toUpperCase();

		Clinico c = clinicoService.buscarDoenca(doenca);
		if (c.getId() == 0L) {
			c.setDoenca(doenca);
		}

		c.setCriancas(crianca);
		c = clinicoService.salvarClinico(c);

		clinicos.add(c);
		
		CriancaPadrao.crianca.setClinicos(clinicos);

		escreverDoencas();
	}
	
	private void escreverDoencas() {
		StringBuffer a = new StringBuffer();
		for (Clinico c : clinicos) {
			a.append(c.getDoenca());
			a.append("\n");
		};
		
		textDoencas.setText(String.valueOf(a));
	}
}
