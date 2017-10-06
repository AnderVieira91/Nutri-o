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

import edu.fatec.sjc.model.Recordatorio;
import edu.fatec.sjc.service.RecordatorioService;
import edu.fatec.sjc.tela.Padrao.CriancaPadrao;

public class TelaRecordatorio extends JFrame {

	/**
	 * 
	 */
	@Autowired
	private RecordatorioService recordatorioService;
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textAlimento;
	private JTextField textHora;
	private JComboBox cBRefeicao;
	private String sb = "";
	private JTextArea textRecordatorio;

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
	public TelaRecordatorio() {
		setTitle("Recordatório");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 489, 433);
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
		textHora.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				String caracteres="0987654321:";
				if(!caracteres.contains(e.getKeyChar()+"")){
				e.consume();
				}
			}
		});
		textHora.setColumns(10);

		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				adicionar();
			}
		});
		
		textRecordatorio = new JTextArea();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
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
							.addContainerGap(237, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED, 292, Short.MAX_VALUE)
							.addComponent(lblCriancaNome)
							.addGap(161))))
				.addComponent(textRecordatorio, GroupLayout.DEFAULT_SIZE, 463, Short.MAX_VALUE)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(191)
					.addComponent(btnAdicionar)
					.addContainerGap(195, Short.MAX_VALUE))
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
					.addGap(28)
					.addComponent(btnAdicionar)
					.addGap(18)
					.addComponent(textRecordatorio, GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
		
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		recordatorioService = (RecordatorioService) context.getBean("recordatorioService");
		
	}

	private void adicionar() {

		if (CriancaPadrao.crianca.getId() != null) {
			
			Recordatorio recordatorio = new Recordatorio();
			recordatorio.setCrianca(CriancaPadrao.crianca);
			recordatorio.setAlimento(textAlimento.getText());
			recordatorio.setHorario(textHora.getText());
			recordatorio.setRefeicao(cBRefeicao.getSelectedItem().toString());

			recordatorio = recordatorioService.salvarRecordatorio(recordatorio);

			if (recordatorio.getId() == null) {
				JOptionPane.showMessageDialog(null, "Dados da orientação não salvos.\nPreencha todos os campos.");
			} else {
				sb = sb + recordatorio.getAlimento() + " no(a) " + recordatorio.getRefeicao()
						+ " as " + recordatorio.getHorario() + "\n";
				textRecordatorio.setText(sb);
				
				List<Recordatorio> recordatorios = CriancaPadrao.crianca.getRecordatorio();
				recordatorios.add(recordatorio);
				
				CriancaPadrao.crianca.setRecordatorio(recordatorios);
			}
		}
	}
	
}