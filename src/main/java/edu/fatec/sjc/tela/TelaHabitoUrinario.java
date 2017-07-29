package edu.fatec.sjc.tela;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import org.springframework.beans.factory.annotation.Autowired;

import edu.fatec.sjc.model.HabitoUrinario;
import edu.fatec.sjc.repository.HabitoUrinarioRepositorio;
import edu.fatec.sjc.tela.TelaPrincipal.CriancaPadrao;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TelaHabitoUrinario extends JFrame {

	/**
	 * 
	 */
	@Autowired
	private HabitoUrinarioRepositorio urinarioRepo;
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFequencia;
	private JComboBox cBFrequencia;
	private JCheckBox checkHematuria;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaHabitoUrinario frame = new TelaHabitoUrinario();
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
	public TelaHabitoUrinario() {
		setTitle("Hábito Urinário");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 451, 188);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel criancaNome = new JLabel(CriancaPadrao.crianca.getNome());
		criancaNome.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JLabel lblFrequncia = new JLabel("Frequência:");

		textFequencia = new JTextField();
		textFequencia.setColumns(10);

		cBFrequencia = new JComboBox();
		cBFrequencia.setModel(new DefaultComboBoxModel(new String[] { "Por dia", "Por semana" }));

		checkHematuria = new JCheckBox("Hematuria");

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				salvar();
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup().addComponent(lblFrequncia)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addComponent(checkHematuria)
								.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(textFequencia, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addGroup(gl_contentPane
												.createParallelGroup(Alignment.LEADING).addComponent(criancaNome)
												.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
														.addComponent(btnSalvar).addComponent(cBFrequencia,
																GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)))))
						.addContainerGap(182, Short.MAX_VALUE)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup().addComponent(criancaNome).addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(lblFrequncia)
						.addComponent(textFequencia, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(cBFrequencia, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
				.addGap(18).addComponent(checkHematuria).addPreferredGap(ComponentPlacement.UNRELATED)
				.addComponent(btnSalvar).addContainerGap(20, Short.MAX_VALUE)));
		contentPane.setLayout(gl_contentPane);
	}

	private void salvar() {
		if (CriancaPadrao.crianca.getId() != null) {
			HabitoUrinario urinario = new HabitoUrinario();

			urinario.setCrianca(CriancaPadrao.crianca);
			urinario.setFrequencia(cBFrequencia.getSelectedItem().toString());
			urinario.setNumero(Long.valueOf(textFequencia.getText()));
			urinario.setHematuria(checkHematuria.isSelected());

			urinarioRepo.save(urinario);

			if (urinario.getId() == null) {
				JOptionPane.showMessageDialog(null, "Dados Hábito urinário não salvos.\nPreencha todos os campos.");
			}
		}

	}

	public HabitoUrinarioRepositorio getUrinarioRepo() {
		return urinarioRepo;
	}

	public void setUrinarioRepo(HabitoUrinarioRepositorio urinarioRepo) {
		this.urinarioRepo = urinarioRepo;
	}

}
