package edu.fatec.sjc.tela;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.fatec.sjc.model.Orientacao;
import edu.fatec.sjc.service.OrientacaoService;
import edu.fatec.sjc.tela.Padrao.CriancaPadrao;

public class TelaOrientacao extends JFrame {

	/**
	 * 
	 */
	private OrientacaoService orientacaoService;
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textAlimento;
	private JTextField textHora;
	private JComboBox cBRefeicao;
	private JLabel lblOrientacao;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaOrientacao frame = new TelaOrientacao();
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
	public TelaOrientacao() {
		setTitle("Orientação");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 489, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblCriancaNome = new JLabel(CriancaPadrao.crianca.getNome());
		lblCriancaNome.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JLabel lblAlimento = new JLabel("Alimento:");

		textAlimento = new JTextField();
		textAlimento.setColumns(10);

		cBRefeicao = new JComboBox();
		cBRefeicao.setModel(
				new DefaultComboBoxModel(new String[] { "Café da manhã", "Almoço", "Café da tarde", "Janta" }));

		JLabel lblRefeio = new JLabel("Refeição");

		JLabel lblHora = new JLabel("Hora:");

		textHora = new JTextField();
		textHora.setColumns(10);

		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				adicionar();
			}
		});

		lblOrientacao = new JLabel("");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblAlimento)
								.addComponent(lblRefeio)
								.addComponent(lblHora))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(textHora, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textAlimento, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE)
								.addComponent(cBRefeicao, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addContainerGap(172, Short.MAX_VALUE))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblCriancaNome)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblOrientacao)
									.addPreferredGap(ComponentPlacement.RELATED, 194, Short.MAX_VALUE)
									.addComponent(btnAdicionar)))
							.addGap(161))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblCriancaNome)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAlimento)
						.addComponent(textAlimento, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(cBRefeicao, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblRefeio))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblHora)
						.addComponent(textHora, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnAdicionar))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(27)
							.addComponent(lblOrientacao)))
					.addContainerGap(100, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}

	private void adicionar() {

		if (CriancaPadrao.crianca.getId() != null) {
			
			ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
			orientacaoService = (OrientacaoService) context.getBean("orientacaoService");
			
			Orientacao orientacao = new Orientacao();
			orientacao.setCrianca(CriancaPadrao.crianca);
			orientacao.setAlimento(textAlimento.getText());
			orientacao.setHora(textHora.getText());
			orientacao.setRefeicao(cBRefeicao.getSelectedItem().toString());

			orientacao = orientacaoService.salvarOrientacao(orientacao);

			if (orientacao.getId() == null) {
				JOptionPane.showMessageDialog(null, "Dados da orientação não salvos.\nPreencha todos os campos.");
			} else {
				String s = lblOrientacao.getText() + orientacao.getAlimento() + " no(a) " + orientacao.getRefeicao()
						+ " as " + orientacao.getHora() + "\n";
				lblOrientacao.setText(s);
			}
		}
	}
}
