package edu.fatec.sjc.tela;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

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
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.fatec.sjc.model.HabitoUrinario;
import edu.fatec.sjc.service.HabitoUrinarioService;
import edu.fatec.sjc.tela.Padrao.CriancaPadrao;

public class TelaHabitoUrinario extends JFrame {

	/**
	 * 
	 */
	@Autowired
	private HabitoUrinarioService habitoUrinarioService;
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
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 451, 188);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel criancaNome = new JLabel(CriancaPadrao.crianca.getNome());
		criancaNome.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JLabel lblFrequncia = new JLabel("Frequência:");

		textFequencia = new JTextField();
		textFequencia.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				String caracteres="0987654321";
				if(!caracteres.contains(e.getKeyChar()+"")){
				e.consume();
				}
			}
		});
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
		
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		habitoUrinarioService = (HabitoUrinarioService) context.getBean("habitoUrinarioService");
	}

	private void salvar() {
		if (CriancaPadrao.crianca.getId() != null) {
			
			HabitoUrinario urinario = new HabitoUrinario();

			urinario.setCrianca(CriancaPadrao.crianca);
			urinario.setFrequencia(cBFrequencia.getSelectedItem().toString());
			urinario.setNumero(Long.valueOf(textFequencia.getText()));
			urinario.setHematuria(checkHematuria.isSelected());

			urinario = habitoUrinarioService.salvarHabUri(urinario);

			if (urinario.getId() == null) {
				JOptionPane.showMessageDialog(null, "Dados Hábito urinário não salvos.\nPreencha todos os campos.");
			} else {
				
				List<HabitoUrinario> urinarios = CriancaPadrao.crianca.getHabitoUrinario();
				urinarios.add(urinario);
				CriancaPadrao.crianca.setHabitoUrinario(urinarios);
			}
		}

	}

}
