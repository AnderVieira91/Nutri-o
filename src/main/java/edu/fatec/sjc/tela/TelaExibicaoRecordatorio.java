package edu.fatec.sjc.tela;

import java.awt.EventQueue;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.fatec.sjc.model.Recordatorio;
import edu.fatec.sjc.service.RecordatorioService;
import edu.fatec.sjc.tela.Padrao.CriancaPadrao;

public class TelaExibicaoRecordatorio extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	@Autowired
	private RecordatorioService recordatorioService;
	JTextArea textRecordatorios;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaExibicaoRecordatorio frame = new TelaExibicaoRecordatorio();
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
	public TelaExibicaoRecordatorio() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		textRecordatorios = new JTextArea();
		textRecordatorios.setText("");
		preencherTexto();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addComponent(textRecordatorios, GroupLayout.PREFERRED_SIZE, 432, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addComponent(textRecordatorios, GroupLayout.PREFERRED_SIZE, 261, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		contentPane.setLayout(gl_contentPane);

		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		recordatorioService = (RecordatorioService) context.getBean("recordatorioService");

	}

	private void preencherTexto() {

		if (!CriancaPadrao.crianca.getRecordatorio().isEmpty()) {

			StringBuffer a = new StringBuffer();
			a.append("");
			List<Recordatorio> recordatorios = recordatorioService.buscarRecordatorios(CriancaPadrao.crianca);

			for (Recordatorio r : recordatorios) {
				a.append("Alimento: " + r.getAlimento() + System.getProperty("line.separator"));
				a.append("Refeição: " + r.getRefeicao() + System.getProperty("line.separator"));
				a.append("Hora: " + r.getHorario() + System.getProperty("line.separator")
						+ System.getProperty("line.separator"));
			}

			textRecordatorios.setText(a.toString());
			textRecordatorios.setEditable(false);
		}
	}

}
