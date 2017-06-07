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

import org.springframework.beans.factory.annotation.Autowired;

import edu.fatec.sjc.model.Crianca;
import edu.fatec.sjc.model.Remedio;
import edu.fatec.sjc.repository.CriancaRepositorio;
import edu.fatec.sjc.repository.RemedioRepositorio;
import edu.fatec.sjc.tela.TelaPrincipal.CriancaPadrao;

public class TelaRemedio extends JFrame {

	/**
	 * 
	 */
	@Autowired
	private CriancaRepositorio criancaRepo;
	@Autowired
	private RemedioRepositorio remedioRepo;
	private List<Remedio> remedios;
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textRemedio;
	private JLabel lblRemedios;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaRemedio frame = new TelaRemedio();
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
	public TelaRemedio() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel criancaPadrao = new JLabel(CriancaPadrao.crianca.getNome());
		criancaPadrao.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JLabel lblRemdio = new JLabel("Remédio:");

		textRemedio = new JTextField();
		textRemedio.setColumns(10);

		lblRemedios = new JLabel("");

		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(CriancaPadrao.crianca != null){
					
					adicionar();
					
				}
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup()
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING).addComponent(lblRemedios)
								.addGroup(gl_contentPane.createSequentialGroup().addComponent(lblRemdio)
										.addPreferredGap(ComponentPlacement.RELATED).addComponent(textRemedio,
												GroupLayout.PREFERRED_SIZE, 193, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup().addGap(175)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
										.addComponent(btnAdicionar).addComponent(criancaPadrao))))
				.addContainerGap(158, Short.MAX_VALUE)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup().addComponent(criancaPadrao).addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(lblRemdio).addComponent(
						textRemedio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(18).addComponent(btnAdicionar).addPreferredGap(ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
				.addComponent(lblRemedios).addGap(84)));
		contentPane.setLayout(gl_contentPane);
	}

	public CriancaRepositorio getCriancaRepo() {
		return criancaRepo;
	}

	public void setCriancaRepo(CriancaRepositorio criancaRepo) {
		this.criancaRepo = criancaRepo;
	}

	public RemedioRepositorio getRemedioRepo() {
		return remedioRepo;
	}

	public void setRemedioRepo(RemedioRepositorio remedioRepo) {
		this.remedioRepo = remedioRepo;
	}

	private void adicionar() {

		List<Crianca> crianca = new LinkedList<Crianca>();
		crianca.add(CriancaPadrao.crianca);
		String remedio = textRemedio.getText().toUpperCase();

		Remedio r = remedioRepo.findByNome(remedio);
		if (r.getId() == null) {
			r.setNome(remedio);
		}

		r.setCriancas(crianca);
		remedioRepo.save(r);

		remedios.add(r);

		escreverRemedios();
	}

	private void escreverRemedios() {
		StringBuffer a = new StringBuffer();
		for (Remedio r : remedios) {
			a.append(r.getNome());
			a.append("; ");
		}

		lblRemedios.setText(String.valueOf(a));
	}
}
