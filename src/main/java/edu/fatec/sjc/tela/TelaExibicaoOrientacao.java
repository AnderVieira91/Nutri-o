package edu.fatec.sjc.tela;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.fatec.sjc.envio.Envio;
import edu.fatec.sjc.model.Orientacao;
import edu.fatec.sjc.service.OrientacaoService;
import edu.fatec.sjc.tela.Padrao.CriancaPadrao;

public class TelaExibicaoOrientacao extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextArea textOrientacao;
	@Autowired
	private OrientacaoService orientacaoService;
	private Envio envio;
	private JTextField textEmail;
	private JTextField textSenha;
	private JTextField textDestinatario;
	private StringBuffer a = new StringBuffer();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaExibicaoOrientacao frame = new TelaExibicaoOrientacao();
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
	public TelaExibicaoOrientacao() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 564);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		textOrientacao = new JTextArea();
		textEmail = new JTextField();
		textEmail.setColumns(10);
		textSenha = new JPasswordField();
		textSenha.setColumns(10);
		textDestinatario = new JTextField();
		textDestinatario.setColumns(10);

		preencherTexto();

		JButton btnImprimir = new JButton("IMPRIMIR");
		btnImprimir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				imprimir();
			}
		});

		JButton btnEmail = new JButton("EMAIL");
		btnEmail.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				System.out.println(a.toString());
				enviarEmail();
			}
		});

		JLabel lblEmail = new JLabel("Email:");

		JLabel lblSenha = new JLabel("Senha:");

		JLabel lblDestinatrio = new JLabel("Destinatário:");

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup().addContainerGap().addComponent(textOrientacao,
						GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup().addGap(37).addGroup(gl_contentPane
						.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup().addComponent(btnImprimir)
								.addPreferredGap(ComponentPlacement.RELATED, 211, Short.MAX_VALUE)
								.addComponent(btnEmail).addGap(32))
						.addGroup(gl_contentPane.createSequentialGroup()
								.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
										.addComponent(lblDestinatrio).addComponent(lblEmail))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
										.addComponent(textDestinatario, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE,
												135, Short.MAX_VALUE)
										.addComponent(textEmail, Alignment.TRAILING))
								.addGap(19).addComponent(lblSenha).addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(textSenha, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
								.addContainerGap()))));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addComponent(textOrientacao, GroupLayout.PREFERRED_SIZE, 395, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(btnImprimir)
								.addComponent(btnEmail))
						.addGap(24)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(lblEmail)
								.addComponent(textEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblSenha).addComponent(textSenha, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING).addComponent(lblDestinatrio)
								.addComponent(textDestinatario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		contentPane.setLayout(gl_contentPane);

		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		orientacaoService = (OrientacaoService) context.getBean("orientacaoService");

	}

	private void preencherTexto() {

		if (!CriancaPadrao.crianca.getOrientecao().isEmpty()) {
			
			a.append("");
			List<Orientacao> orientacoes = orientacaoService.retornarOrientacoes(CriancaPadrao.crianca);

			for (Orientacao o : orientacoes) {
				a.append("Alimento: " + o.getAlimento() + System.getProperty("line.separator"));
				a.append("Refeição: " + o.getRefeicao() + System.getProperty("line.separator"));
				a.append("Hora: " + o.getHora() + System.getProperty("line.separator")
						+ System.getProperty("line.separator"));
			}

			textOrientacao.setText(a.toString());
			textOrientacao.setEditable(false);
		}
	}

	private void enviarEmail() {

		Envio.enviarEmail(textEmail.getText(), textSenha.getText(), textDestinatario.getText(),
				"Orientacão Nutricionla de " + CriancaPadrao.crianca.getNome(), a.toString());
	}

	private void imprimir() {
		envio.impressao(textOrientacao.getText());
	}
}
