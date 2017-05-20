package edu.fatec.sjc.tela;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import org.springframework.beans.factory.annotation.Autowired;

import edu.fatec.sjc.model.HabitoAlimentar;
import edu.fatec.sjc.repository.HabitoAlimentarRepositorio;
import edu.fatec.sjc.tela.TelaPrincipal.CriancaPadrao;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TelaHabitoAlimentar extends JFrame {

	/**
	 * 
	 */
	@Autowired
	private HabitoAlimentarRepositorio alimentarRepo;
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textAlimento;
	private JTextField textHorario;
	private JTextField textFrequencia;
	private JComboBox cBFrequencia;
	JComboBox cBRefeicao;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaHabitoAlimentar frame = new TelaHabitoAlimentar();
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
	public TelaHabitoAlimentar() {
		setTitle("Hábito alimentar");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 226);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblNomePadrao = new JLabel(CriancaPadrao.crianca.getNome());
		lblNomePadrao.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JLabel lblAlimento = new JLabel("Alimento:");

		textAlimento = new JTextField();
		textAlimento.setColumns(10);

		JLabel lblRefeio = new JLabel("Refeição:");

		cBRefeicao = new JComboBox();
		cBRefeicao.setModel(new DefaultComboBoxModel(
				new String[] { "Café da manhã", "Almoço", "Café da tarde", "Lanche", "Janta" }));

		JLabel lblHorrio = new JLabel("Horário:");

		textHorario = new JTextField();
		textHorario.setColumns(10);

		JLabel lblFrequncia = new JLabel("Frequência:");

		textFrequencia = new JTextField();
		textFrequencia.setColumns(10);

		cBFrequencia = new JComboBox();
		cBFrequencia.setModel(new DefaultComboBoxModel(new String[] { "Por dia", "Por semana", "Por mês" }));

		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				adicionar();
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addComponent(lblFrequncia)
								.addComponent(lblRefeio).addComponent(lblHorrio).addComponent(lblAlimento))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(textAlimento, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(cBRefeicao, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(textHorario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(textFrequencia, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
												.addComponent(lblNomePadrao)
												.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
														.addComponent(btnAdicionar).addComponent(cBFrequencia,
																GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)))))
						.addContainerGap(171, Short.MAX_VALUE)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup().addComponent(lblNomePadrao).addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(lblAlimento).addComponent(
						textAlimento, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(lblRefeio).addComponent(
						cBRefeicao, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(lblHorrio).addComponent(
						textHorario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addComponent(lblFrequncia)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(textFrequencia, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(cBFrequencia, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)))
				.addGap(27).addComponent(btnAdicionar).addContainerGap(76, Short.MAX_VALUE)));
		contentPane.setLayout(gl_contentPane);
	}

	public HabitoAlimentarRepositorio getAlimentarRepo() {
		return alimentarRepo;
	}

	public void setAlimentarRepo(HabitoAlimentarRepositorio alimentarRepo) {
		this.alimentarRepo = alimentarRepo;
	}

	private void adicionar() {
		if (CriancaPadrao.crianca.getId() != null) {

			HabitoAlimentar alimentar = new HabitoAlimentar();
			alimentar.setCrianca(CriancaPadrao.crianca);
			alimentar.setAlimento(textAlimento.getText());
			alimentar.setFrequencia(cBFrequencia.getSelectedItem().toString());
			alimentar.setHora(textHorario.getText());
			alimentar.setNumero(Long.valueOf(textFrequencia.getText()));
			alimentar.setRefeicao(cBRefeicao.getSelectedItem().toString());

			alimentarRepo.save(alimentar);

			if (alimentar.getId() == null) {
				JOptionPane.showMessageDialog(null, "Dados do Hábito alimentar não salvos.\nPreencha todos os campos.");

			}
		}
	}

}
