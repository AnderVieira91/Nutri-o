package edu.fatec.sjc.tela;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.fatec.sjc.model.Familiar;
import edu.fatec.sjc.service.FamiliarService;
import edu.fatec.sjc.tela.Padrao.CriancaPadrao;

public class TelaFamiliar extends JFrame {
	/**
	 * 
	 */
	@Autowired
	private FamiliarService familiarService;
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textDoenca;
	private String todasDoencas;
	private JComboBox cBParentesco;
	private List<Familiar> familiares = CriancaPadrao.crianca.getFamiliares();
	private JTextArea textDoencas;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaFamiliar frame = new TelaFamiliar();
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
	public TelaFamiliar() {
		setTitle("Histórico Familiar");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 387);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblCriancaNome = new JLabel(CriancaPadrao.crianca.getNome());
		lblCriancaNome.setFont(new Font("Tahoma", Font.PLAIN, 16));

		JLabel lblDoena = new JLabel("Doença:");

		textDoenca = new JTextField();
		textDoenca.setColumns(10);

		JLabel lblParentesco = new JLabel("Parentesco:");

		cBParentesco = new JComboBox();
		cBParentesco.setModel(new DefaultComboBoxModel(new String[] { "P", "M" }));

		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				adicionarDoenca();
			}
		});

		textDoencas = new JTextArea();
		escrever();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup()
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
						.createSequentialGroup().addContainerGap()
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addComponent(lblParentesco)
								.addComponent(lblDoena))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(cBParentesco, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(textDoenca, GroupLayout.PREFERRED_SIZE, 305, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup().addGap(162).addComponent(lblCriancaNome))
						.addGroup(gl_contentPane.createSequentialGroup().addGap(168).addComponent(btnAdicionar))
						.addComponent(textDoencas, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 426,
								GroupLayout.PREFERRED_SIZE))
				.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup().addComponent(lblCriancaNome).addGap(18)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(textDoenca, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblDoena))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(lblParentesco)
								.addComponent(cBParentesco, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(btnAdicionar)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(textDoencas, GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)));
		contentPane.setLayout(gl_contentPane);
		
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		familiarService = (FamiliarService) context.getBean("familiarService");
	}

	private void adicionarDoenca() {
		if (CriancaPadrao.crianca.getId() != null) {

			String doenca = textDoenca.getText().toUpperCase();
			
			Familiar familiar = new Familiar();
			familiar.setDoenca(doenca);
			familiar.setParentesco(cBParentesco.getSelectedItem().toString());
			familiar.setCrianca(CriancaPadrao.crianca);
			familiar = familiarService.salvarFamiliar(familiar);

			if (familiar.getId() == null) {
				JOptionPane.showMessageDialog(null, "Dados bioquímicos não salvos.\nPreencha todos os campos.");
			} else {
				List<Familiar> familiares = CriancaPadrao.crianca.getFamiliares();
				familiares.add(familiar);

				CriancaPadrao.crianca.setFamiliares(familiares);
			}

			this.familiares = CriancaPadrao.crianca.getFamiliares();
			escrever();
		}
	}

	private void escrever() {
		StringBuffer a = new StringBuffer();
		for (Familiar f : familiares) {
			a.append("Doença: " + f.getDoenca() + " por parte de " + f.getParentesco()
					+ System.getProperty("line.separator"));
		}
		textDoencas.setText(a.toString());
	}
}
