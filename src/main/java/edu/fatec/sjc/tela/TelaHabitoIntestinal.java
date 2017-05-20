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
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import org.springframework.beans.factory.annotation.Autowired;

import edu.fatec.sjc.model.HabitoIntestinal;
import edu.fatec.sjc.repository.HabitoIntestinalRepositorio;
import edu.fatec.sjc.tela.TelaPrincipal.CriancaPadrao;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TelaHabitoIntestinal extends JFrame {

	/**
	 * 
	 */
	@Autowired
	private HabitoIntestinalRepositorio intestinalRepo;
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFrequencia;
	private JTextField textBristol;
	private JComboBox cBFrequencia;
	private JCheckBox checkMelena;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaHabitoIntestinal frame = new TelaHabitoIntestinal();
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
	public TelaHabitoIntestinal() {
		setTitle("Hábito intestinal");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 407, 197);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblNomePadrao = new JLabel(CriancaPadrao.crianca.getNome());
		lblNomePadrao.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JLabel lblFrequncia = new JLabel("Frequência:");

		textFrequencia = new JTextField();
		textFrequencia.setColumns(10);

		cBFrequencia = new JComboBox();
		cBFrequencia.setModel(new DefaultComboBoxModel(new String[] { "Por dia", "Por semana" }));

		JLabel lblBristol = new JLabel("Bristol:");

		textBristol = new JTextField();
		textBristol.setColumns(10);

		checkMelena = new JCheckBox("Melena");
		checkMelena.setHorizontalAlignment(SwingConstants.CENTER);

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cadastrar();
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup()
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup().addGap(154).addComponent(lblNomePadrao))
						.addGroup(
								gl_contentPane
										.createSequentialGroup()
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addComponent(lblFrequncia).addComponent(lblBristol))
										.addPreferredGap(ComponentPlacement.RELATED)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addComponent(textBristol, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(checkMelena)
												.addGroup(gl_contentPane.createSequentialGroup()
														.addComponent(textFrequencia, GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(ComponentPlacement.RELATED)
														.addComponent(cBFrequencia, GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_contentPane.createSequentialGroup().addGap(162).addComponent(btnSalvar)))
				.addContainerGap(179, Short.MAX_VALUE)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup().addComponent(lblNomePadrao).addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(lblFrequncia)
						.addComponent(textFrequencia, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(cBFrequencia, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(lblBristol).addComponent(
						textBristol, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(18).addComponent(checkMelena).addPreferredGap(ComponentPlacement.UNRELATED)
				.addComponent(btnSalvar).addContainerGap(107, Short.MAX_VALUE)));
		contentPane.setLayout(gl_contentPane);
	}

	private void cadastrar() {
		if (CriancaPadrao.crianca.getId() != null) {
			HabitoIntestinal intestinal = new HabitoIntestinal();

			intestinal.setBristol(textBristol.getText());
			intestinal.setCrianca(CriancaPadrao.crianca);
			intestinal.setFrequencia(cBFrequencia.getSelectedItem().toString());
			intestinal.setMelena(checkMelena.isSelected());
			intestinal.setNumero(Long.valueOf(textFrequencia.getText()));

			intestinalRepo.save(intestinal);

			if (intestinal.getId() == null) {
				JOptionPane.showMessageDialog(null, "Dados Hábito intestinal não salvos.\nPreencha todos os campos.");
			}

		}
	}
	
	public HabitoIntestinalRepositorio getIntestinalRepo() {
		return intestinalRepo;
	}

	public void setIntestinalRepo(HabitoIntestinalRepositorio intestinalRepo) {
		this.intestinalRepo = intestinalRepo;
	}

}
