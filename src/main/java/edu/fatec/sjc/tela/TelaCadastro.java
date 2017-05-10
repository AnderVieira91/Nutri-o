package edu.fatec.sjc.tela;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

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

import edu.fatec.sjc.model.Crianca;
import edu.fatec.sjc.repository.CriancaRepositorio;
import edu.fatec.sjc.tela.TelaPrincipal.CriancaPadrao;

public class TelaCadastro extends JFrame {

	/**
	 * 
	 */
	@Autowired
	private CriancaRepositorio criancaRepo;
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textNome;
	private JTextField textPai;
	private JTextField textMae;
	private JTextField textMotivo;
	private JTextField textNascimento;
	private JTextField textTelefone;
	private JLabel lblTelefone;
	private JComboBox cBSexo;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastro frame = new TelaCadastro();
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
	public TelaCadastro() {
		setTitle("Cadastro de criança");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 455, 280);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		textNome = new JTextField();
		textNome.setColumns(10);

		JLabel lblNome = new JLabel("Nome:");

		textPai = new JTextField();
		textPai.setColumns(10);

		JLabel lblPai = new JLabel("Pai:");

		textMae = new JTextField();
		textMae.setColumns(10);

		JLabel lblMe = new JLabel("Mãe:");

		textMotivo = new JTextField();
		textMotivo.setColumns(10);

		JLabel lblMotivo = new JLabel("Motivo:");

		textNascimento = new JTextField();
		textNascimento.setColumns(10);

		JLabel lblNascimento = new JLabel("Nascimento:");

		JLabel lblSexo = new JLabel("Sexo:");
		cBSexo = new JComboBox();
		cBSexo.setModel(new DefaultComboBoxModel(new String[] { "M", "F" }));

		textTelefone = new JTextField();
		textTelefone.setColumns(10);

		lblTelefone = new JLabel("Telefone:");

		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cadastrar();
			}
		});

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup().addContainerGap()
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING).addComponent(lblNome)
								.addComponent(lblPai)
								.addComponent(lblMe).addComponent(lblMotivo).addComponent(lblNascimento)
								.addComponent(lblSexo).addComponent(lblTelefone))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
										.addComponent(textMotivo, GroupLayout.DEFAULT_SIZE, 318, Short.MAX_VALUE)
										.addComponent(textMae).addComponent(textPai).addComponent(textNome)
										.addComponent(textNascimento, GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
										.addComponent(textTelefone, GroupLayout.PREFERRED_SIZE, 220,
												GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(cBSexo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addGap(25)))
						.addContainerGap(38, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup().addContainerGap(187, Short.MAX_VALUE)
						.addComponent(btnCadastrar).addGap(168)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup()
				.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(lblNome).addComponent(
						textNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textPai, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPai))
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textMae, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(lblMe))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textMotivo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(lblMotivo))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textNascimento, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNascimento))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(lblSexo)
										.addComponent(cBSexo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE))
								.addGap(2)))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textTelefone, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(lblTelefone))
				.addPreferredGap(ComponentPlacement.RELATED, 17, Short.MAX_VALUE).addComponent(btnCadastrar)
				.addContainerGap()));
		contentPane.setLayout(gl_contentPane);
	}

	public CriancaRepositorio getCriancaRepo() {
		return criancaRepo;
	}

	public void setCriancaRepo(CriancaRepositorio criancaRepo) {
		this.criancaRepo = criancaRepo;
	}

	private void cadastrar() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		String nome = textNome.getText().toUpperCase();
		String pai = textPai.getText().toUpperCase();
		String mae = textMae.getText().toUpperCase();
		String motivo = textMotivo.getText().toUpperCase();
		Long telefone = Long.valueOf(textTelefone.getText());
		String sexo = cBSexo.getSelectedItem().toString();
		Date nascimento = new Date(0L);
		try {
			Date nascimentoB = (Date) sdf.parse(textNascimento.getText());
			nascimento = nascimentoB;
		} catch (ParseException e1) {
			e1.printStackTrace();
		}

		Crianca crianca = new Crianca();
		crianca.setNome(nome);
		crianca.setMae(mae);
		crianca.setPai(pai);
		crianca.setMotivo(motivo);
		crianca.setNascimento(nascimento);
		crianca.setSexo(sexo);
		crianca.setTelefone(telefone);

		criancaRepo.save(crianca);
		if (crianca.getId() == null) {
			JOptionPane.showMessageDialog(null, "Usuário não salvo.\nPreencha todos os campos.");
		} else {
			CriancaPadrao.crianca = crianca;
		}
	}
}
