package edu.fatec.sjc.tela;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import org.springframework.beans.factory.annotation.Autowired;

import edu.fatec.sjc.model.Bioquimico;
import edu.fatec.sjc.repository.BioquimicoRepositorio;
import edu.fatec.sjc.tela.TelaPrincipal.CriancaPadrao;
import java.awt.Font;

public class TelaBioquimico extends JFrame {

	/**
	 * 
	 */

	@Autowired
	private BioquimicoRepositorio bioquimicoRepo;
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textProteinasTotais;
	private JTextField textAlbumina;
	private JTextField textPreAlbumina;
	private JTextField textPcr;
	private JTextField textFerretina;
	private JTextField textFerro;
	private JTextField textAcidoFolico;
	private JTextField textCreatinina;
	private JTextField textCreatininaUrina;
	private JTextField textAcidoUrico;
	private JTextField textTgo;
	private JTextField textTgp;
	private JTextField textDhl;
	private JTextField textVcm;
	private JTextField textHcm;
	private JTextField textChcm;
	private JTextField textRdw;
	private JLabel lblHemoglobina;
	private JTextField textHemoglobina;
	private JLabel lblHematcrito;
	private JTextField textHematocrito;
	private JLabel lblPlaqueta;
	private JTextField textPlaqueta;
	private JLabel lblLeuccito;
	private JTextField textLeucocito;
	private JLabel lblLinfcito;
	private JTextField textLinfocito;
	private JLabel lblNeutrfilo;
	private JTextField textNeutrofilo;
	private JLabel lblGlicemia;
	private JTextField textGlicemia;
	private JLabel lblInsulenimia;
	private JTextField textInsulenimia;
	private JLabel lblT4Livre;
	private JTextField textT4Livre;
	private JLabel lblClcio;
	private JTextField textCalcio;
	private JLabel lblSdio;
	private JTextField textSodio;
	private JLabel lblPotssio;
	private JTextField textPotassio;
	private JLabel lblCriancaNome;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaBioquimico frame = new TelaBioquimico();
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
	public TelaBioquimico() {
		setTitle("Bioquímico");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 487);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblProteinasTotais = new JLabel("Proteinas Totais:");

		textProteinasTotais = new JTextField();
		textProteinasTotais.setColumns(10);

		JLabel lblAlbumina = new JLabel("Albumina:");

		textAlbumina = new JTextField();
		textAlbumina.setColumns(10);

		JLabel lblPralbumina = new JLabel("Pré-Albumina:");

		textPreAlbumina = new JTextField();
		textPreAlbumina.setColumns(10);

		JLabel lblPcr = new JLabel("PCR:");

		textPcr = new JTextField();
		textPcr.setColumns(10);

		JLabel lblFerretina = new JLabel("Ferretina:");

		textFerretina = new JTextField();
		textFerretina.setColumns(10);

		JLabel lblFerro = new JLabel("Ferro:");

		textFerro = new JTextField();
		textFerro.setColumns(10);

		JLabel lblcidoFlico = new JLabel("Ácido Fólico:");

		textAcidoFolico = new JTextField();
		textAcidoFolico.setColumns(10);

		JLabel lblCreatinina = new JLabel("Creatinina:");

		textCreatinina = new JTextField();
		textCreatinina.setColumns(10);

		JLabel lblCreatininaNaUrina = new JLabel("Creatinina na Urina:");

		textCreatininaUrina = new JTextField();
		textCreatininaUrina.setColumns(10);

		JLabel lblcidoUrico = new JLabel("Ácido Urico:");

		textAcidoUrico = new JTextField();
		textAcidoUrico.setColumns(10);

		JLabel lblTgo = new JLabel("TGO:");

		textTgo = new JTextField();
		textTgo.setColumns(10);

		JLabel lblTgp = new JLabel("TGP:");

		textTgp = new JTextField();
		textTgp.setColumns(10);

		JLabel lblDhl = new JLabel("DHL:");

		textDhl = new JTextField();
		textDhl.setColumns(10);

		JLabel lblVcm = new JLabel("VCM:");

		textVcm = new JTextField();
		textVcm.setColumns(10);

		JLabel lblHcm = new JLabel("HCM:");

		textHcm = new JTextField();
		textHcm.setColumns(10);

		JLabel lblChcm = new JLabel("CHCM:");

		textChcm = new JTextField();
		textChcm.setColumns(10);

		JLabel lblRdw = new JLabel("RDW:");

		textRdw = new JTextField();
		textRdw.setColumns(10);

		lblHemoglobina = new JLabel("Hemoglobina:");

		textHemoglobina = new JTextField();
		textHemoglobina.setColumns(10);

		lblHematcrito = new JLabel("Hematócrito:");

		textHematocrito = new JTextField();
		textHematocrito.setColumns(10);

		lblPlaqueta = new JLabel("Plaqueta:");

		textPlaqueta = new JTextField();
		textPlaqueta.setColumns(10);

		lblLeuccito = new JLabel("Leucócito:");

		textLeucocito = new JTextField();
		textLeucocito.setColumns(10);

		lblLinfcito = new JLabel("Linfócito:");

		textLinfocito = new JTextField();
		textLinfocito.setColumns(10);

		lblNeutrfilo = new JLabel("Neutrófilo:");

		textNeutrofilo = new JTextField();
		textNeutrofilo.setColumns(10);

		lblGlicemia = new JLabel("Glicemia:");

		textGlicemia = new JTextField();
		textGlicemia.setColumns(10);

		lblInsulenimia = new JLabel("Insulenimia:");

		textInsulenimia = new JTextField();
		textInsulenimia.setColumns(10);

		lblT4Livre = new JLabel("T4 Livre:");

		textT4Livre = new JTextField();
		textT4Livre.setColumns(10);

		lblClcio = new JLabel("Cálcio:");

		textCalcio = new JTextField();
		textCalcio.setColumns(10);

		lblSdio = new JLabel("Sódio:");

		textSodio = new JTextField();
		textSodio.setColumns(10);

		lblPotssio = new JLabel("Potássio:");

		textPotassio = new JTextField();
		textPotassio.setColumns(10);

		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				cadastrar();

			}
		});

		lblCriancaNome = new JLabel(CriancaPadrao.crianca.getNome());
		lblCriancaNome.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane
				.setHorizontalGroup(
						gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(
										gl_contentPane
												.createSequentialGroup().addGroup(gl_contentPane
														.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
																.createSequentialGroup().addContainerGap()
																.addGroup(gl_contentPane
																		.createParallelGroup(Alignment.LEADING)
																		.addGroup(gl_contentPane
																				.createParallelGroup(Alignment.TRAILING)
																				.addGroup(gl_contentPane
																						.createSequentialGroup()
																						.addGroup(gl_contentPane
																								.createParallelGroup(
																										Alignment.LEADING)
																								.addComponent(
																										lblPralbumina)
																								.addComponent(lblPcr)
																								.addComponent(
																										lblFerretina)
																								.addComponent(
																										lblFerro)
																								.addComponent(
																										lblcidoFlico)
																								.addComponent(
																										lblProteinasTotais)
																								.addComponent(
																										lblAlbumina)
																								.addComponent(
																										lblcidoUrico)
																								.addComponent(
																										lblCreatinina))
																						.addGap(19))
																				.addGroup(gl_contentPane
																						.createSequentialGroup()
																						.addComponent(
																								lblCreatininaNaUrina)
																						.addPreferredGap(
																								ComponentPlacement.RELATED)))
																		.addComponent(lblTgo).addComponent(lblTgp)
																		.addComponent(lblDhl)
																		.addComponent(lblVcm)
																		.addComponent(lblPotssio))
																.addGap(4)
																.addGroup(gl_contentPane
																		.createParallelGroup(Alignment.LEADING)
																		.addComponent(textCreatininaUrina,
																				GroupLayout.PREFERRED_SIZE,
																				GroupLayout.DEFAULT_SIZE,
																				GroupLayout.PREFERRED_SIZE)
																		.addGroup(gl_contentPane.createSequentialGroup()
																				.addGroup(gl_contentPane
																						.createParallelGroup(
																								Alignment.LEADING)
																						.addComponent(
																								textProteinasTotais,
																								GroupLayout.PREFERRED_SIZE,
																								GroupLayout.DEFAULT_SIZE,
																								GroupLayout.PREFERRED_SIZE)
																						.addComponent(textAlbumina,
																								GroupLayout.PREFERRED_SIZE,
																								GroupLayout.DEFAULT_SIZE,
																								GroupLayout.PREFERRED_SIZE)
																						.addComponent(textPreAlbumina,
																								GroupLayout.PREFERRED_SIZE,
																								GroupLayout.DEFAULT_SIZE,
																								GroupLayout.PREFERRED_SIZE)
																						.addComponent(textPcr,
																								GroupLayout.PREFERRED_SIZE,
																								GroupLayout.DEFAULT_SIZE,
																								GroupLayout.PREFERRED_SIZE)
																						.addComponent(textFerretina,
																								GroupLayout.PREFERRED_SIZE,
																								GroupLayout.DEFAULT_SIZE,
																								GroupLayout.PREFERRED_SIZE)
																						.addComponent(textFerro,
																								GroupLayout.PREFERRED_SIZE,
																								GroupLayout.DEFAULT_SIZE,
																								GroupLayout.PREFERRED_SIZE)
																						.addComponent(textAcidoFolico,
																								GroupLayout.PREFERRED_SIZE,
																								GroupLayout.DEFAULT_SIZE,
																								GroupLayout.PREFERRED_SIZE)
																						.addComponent(textCreatinina,
																								GroupLayout.PREFERRED_SIZE,
																								GroupLayout.DEFAULT_SIZE,
																								GroupLayout.PREFERRED_SIZE)
																						.addComponent(textAcidoUrico,
																								GroupLayout.PREFERRED_SIZE,
																								GroupLayout.DEFAULT_SIZE,
																								GroupLayout.PREFERRED_SIZE)
																						.addComponent(textTgo,
																								GroupLayout.PREFERRED_SIZE,
																								GroupLayout.DEFAULT_SIZE,
																								GroupLayout.PREFERRED_SIZE)
																						.addComponent(textTgp,
																								GroupLayout.PREFERRED_SIZE,
																								GroupLayout.DEFAULT_SIZE,
																								GroupLayout.PREFERRED_SIZE)
																						.addComponent(textDhl,
																								GroupLayout.PREFERRED_SIZE,
																								GroupLayout.DEFAULT_SIZE,
																								GroupLayout.PREFERRED_SIZE)
																						.addComponent(textVcm,
																								GroupLayout.PREFERRED_SIZE,
																								GroupLayout.DEFAULT_SIZE,
																								GroupLayout.PREFERRED_SIZE))
																				.addGap(28)
																				.addGroup(gl_contentPane
																						.createParallelGroup(
																								Alignment.LEADING)
																						.addGroup(gl_contentPane
																								.createSequentialGroup()
																								.addGroup(gl_contentPane
																										.createParallelGroup(
																												Alignment.LEADING)
																										.addComponent(
																												lblRdw)
																										.addComponent(
																												lblHemoglobina)
																										.addComponent(
																												lblChcm)
																										.addComponent(
																												lblHcm))
																								.addPreferredGap(
																										ComponentPlacement.RELATED)
																								.addGroup(gl_contentPane
																										.createParallelGroup(
																												Alignment.LEADING)
																										.addComponent(
																												textHcm,
																												GroupLayout.PREFERRED_SIZE,
																												GroupLayout.DEFAULT_SIZE,
																												GroupLayout.PREFERRED_SIZE)
																										.addComponent(
																												textChcm,
																												GroupLayout.PREFERRED_SIZE,
																												GroupLayout.DEFAULT_SIZE,
																												GroupLayout.PREFERRED_SIZE)
																										.addComponent(
																												textRdw,
																												GroupLayout.PREFERRED_SIZE,
																												GroupLayout.DEFAULT_SIZE,
																												GroupLayout.PREFERRED_SIZE)
																										.addComponent(
																												textHemoglobina,
																												GroupLayout.PREFERRED_SIZE,
																												86,
																												GroupLayout.PREFERRED_SIZE)))
																						.addGroup(gl_contentPane
																								.createSequentialGroup()
																								.addGroup(gl_contentPane
																										.createParallelGroup(
																												Alignment.LEADING)
																										.addComponent(
																												lblHematcrito)
																										.addComponent(
																												lblPlaqueta)
																										.addComponent(
																												lblLeuccito)
																										.addComponent(
																												lblNeutrfilo)
																										.addComponent(
																												lblLinfcito)
																										.addComponent(
																												lblGlicemia))
																								.addPreferredGap(
																										ComponentPlacement.UNRELATED)
																								.addGroup(gl_contentPane
																										.createParallelGroup(
																												Alignment.LEADING)
																										.addComponent(
																												textGlicemia,
																												GroupLayout.PREFERRED_SIZE,
																												GroupLayout.DEFAULT_SIZE,
																												GroupLayout.PREFERRED_SIZE)
																										.addComponent(
																												textNeutrofilo,
																												GroupLayout.PREFERRED_SIZE,
																												GroupLayout.DEFAULT_SIZE,
																												GroupLayout.PREFERRED_SIZE)
																										.addComponent(
																												textLinfocito,
																												GroupLayout.PREFERRED_SIZE,
																												GroupLayout.DEFAULT_SIZE,
																												GroupLayout.PREFERRED_SIZE)
																										.addComponent(
																												textLeucocito,
																												GroupLayout.PREFERRED_SIZE,
																												GroupLayout.DEFAULT_SIZE,
																												GroupLayout.PREFERRED_SIZE)
																										.addComponent(
																												textPlaqueta,
																												GroupLayout.PREFERRED_SIZE,
																												GroupLayout.DEFAULT_SIZE,
																												GroupLayout.PREFERRED_SIZE)
																										.addComponent(
																												textHematocrito,
																												GroupLayout.PREFERRED_SIZE,
																												GroupLayout.DEFAULT_SIZE,
																												GroupLayout.PREFERRED_SIZE)))
																						.addGroup(gl_contentPane
																								.createSequentialGroup()
																								.addGroup(gl_contentPane
																										.createParallelGroup(
																												Alignment.LEADING)
																										.addComponent(
																												lblInsulenimia)
																										.addComponent(
																												lblT4Livre)
																										.addGroup(
																												gl_contentPane
																														.createParallelGroup(
																																Alignment.TRAILING)
																														.addComponent(
																																lblSdio)
																														.addComponent(
																																lblClcio)))
																								.addGap(18)
																								.addGroup(gl_contentPane
																										.createParallelGroup(
																												Alignment.LEADING)
																										.addComponent(
																												textSodio,
																												GroupLayout.PREFERRED_SIZE,
																												GroupLayout.DEFAULT_SIZE,
																												GroupLayout.PREFERRED_SIZE)
																										.addComponent(
																												textCalcio,
																												GroupLayout.PREFERRED_SIZE,
																												GroupLayout.DEFAULT_SIZE,
																												GroupLayout.PREFERRED_SIZE)
																										.addComponent(
																												textT4Livre,
																												GroupLayout.PREFERRED_SIZE,
																												GroupLayout.DEFAULT_SIZE,
																												GroupLayout.PREFERRED_SIZE)
																										.addComponent(
																												textInsulenimia,
																												GroupLayout.PREFERRED_SIZE,
																												GroupLayout.DEFAULT_SIZE,
																												GroupLayout.PREFERRED_SIZE)))))
																		.addComponent(textPotassio,
																				GroupLayout.PREFERRED_SIZE,
																				GroupLayout.DEFAULT_SIZE,
																				GroupLayout.PREFERRED_SIZE)))
														.addGroup(gl_contentPane.createSequentialGroup().addGap(171)
																.addComponent(btnCadastrar))
														.addGroup(gl_contentPane.createSequentialGroup().addGap(185)
																.addComponent(lblCriancaNome)))
												.addContainerGap(35, Short.MAX_VALUE)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup().addComponent(lblCriancaNome)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblHcm).addComponent(textHcm, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addComponent(textProteinasTotais, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblProteinasTotais))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING).addComponent(lblAlbumina)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(textAlbumina, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblChcm).addComponent(textChcm, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING).addComponent(lblPralbumina)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(textPreAlbumina, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblRdw).addComponent(textRdw, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(lblPcr)
								.addComponent(textPcr, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblHemoglobina).addComponent(textHemoglobina, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(lblFerretina)
								.addComponent(textFerretina, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblHematcrito).addComponent(textHematocrito, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(lblFerro)
								.addComponent(textFerro, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblPlaqueta).addComponent(textPlaqueta, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addComponent(lblcidoFlico)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(textAcidoFolico, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblLeuccito).addComponent(textLeucocito,
												GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(textCreatinina, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(textLinfocito, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblLinfcito))
								.addComponent(lblCreatinina))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(textCreatininaUrina, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNeutrfilo).addComponent(textNeutrofilo,
												GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE))
								.addComponent(lblCreatininaNaUrina))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(lblcidoUrico)
								.addComponent(textAcidoUrico, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblGlicemia).addComponent(textGlicemia, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addComponent(lblTgo)
										.addComponent(textTgo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblInsulenimia).addComponent(textInsulenimia,
												GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addComponent(lblTgp)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(textTgp, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(textT4Livre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(lblT4Livre)))
						.addPreferredGap(ComponentPlacement.RELATED).addGroup(gl_contentPane.createParallelGroup(
								Alignment.LEADING)
								.addGroup(gl_contentPane
										.createSequentialGroup().addGroup(gl_contentPane
												.createParallelGroup(Alignment.LEADING).addComponent(lblDhl)
												.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
														.addComponent(textDhl, GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
														.addComponent(lblClcio)))
										.addPreferredGap(ComponentPlacement.RELATED)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addComponent(lblVcm).addGroup(gl_contentPane
														.createParallelGroup(Alignment.BASELINE).addComponent(textVcm,
																GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(lblSdio)))
										.addPreferredGap(ComponentPlacement.RELATED)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addComponent(textPotassio, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(lblPotssio)))
								.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(textCalcio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(textSodio,
												GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)))
						.addPreferredGap(ComponentPlacement.RELATED, 21, Short.MAX_VALUE).addComponent(btnCadastrar)));
		contentPane.setLayout(gl_contentPane);
	}

	public BioquimicoRepositorio getBioquimicoRepo() {
		return bioquimicoRepo;
	}

	public void setBioquimicoRepo(BioquimicoRepositorio bioquimicoRepo) {
		this.bioquimicoRepo = bioquimicoRepo;
	}

	private void cadastrar() {
		if (CriancaPadrao.crianca.getId() != null) {

			Bioquimico bioquimico = new Bioquimico();

			bioquimico.setAcidoFolico(Double.valueOf(textAcidoFolico.getText()));
			bioquimico.setAcidoUrico(Double.valueOf(textAcidoUrico.getText()));
			bioquimico.setAlbumina(Double.valueOf(textAlbumina.getText()));
			bioquimico.setCalcio(Double.valueOf(textCalcio.getText()));
			bioquimico.setChcm(Double.valueOf(textChcm.getText()));
			bioquimico.setCreatinina(Double.valueOf(textCreatinina.getText()));
			bioquimico.setCreatininaUrina(Double.valueOf(textCreatininaUrina.getText()));
			bioquimico.setDhl(Double.valueOf(textDhl.getText()));
			bioquimico.setFerretina(Double.valueOf(textFerretina.getText()));
			bioquimico.setFerro(Double.valueOf(textFerro.getText()));
			bioquimico.setGlicemia(Double.valueOf(textGlicemia.getText()));
			bioquimico.setHcm(Double.valueOf(textHcm.getText()));
			bioquimico.setHematocrito(Double.valueOf(textHematocrito.getText()));
			bioquimico.setHemoglobina(Double.valueOf(textHemoglobina.getText()));
			bioquimico.setInsulenimia(Double.valueOf(textInsulenimia.getText()));
			bioquimico.setLeucocito(Double.valueOf(textLeucocito.getText()));
			bioquimico.setLinfocito(Double.valueOf(textLinfocito.getText()));
			bioquimico.setNeutrofilo(Double.valueOf(textNeutrofilo.getText()));
			bioquimico.setPcr(Double.valueOf(textPcr.getText()));
			bioquimico.setPlaqueta(Double.valueOf(textPlaqueta.getText()));
			bioquimico.setPotassio(Double.valueOf(textPotassio.getText()));
			bioquimico.setPreAlbumina(Double.valueOf(textPreAlbumina.getText()));
			bioquimico.setProteinasTotais(Double.valueOf(textProteinasTotais.getText()));
			bioquimico.setRdw(Double.valueOf(textRdw.getText()));
			bioquimico.setSodio(Double.valueOf(textSodio.getText()));
			bioquimico.setT4Livre(Double.valueOf(textT4Livre.getText()));
			bioquimico.setTgo(Double.valueOf(textTgo.getText()));
			bioquimico.setTgp(Double.valueOf(textTgp.getText()));
			bioquimico.setVcm(Double.valueOf(textVcm.getText()));
			bioquimico.setCrianca(CriancaPadrao.crianca);

			bioquimicoRepo.save(bioquimico);

			if (bioquimico.getId() == null) {
				JOptionPane.showMessageDialog(null, "Dados bioquímicos não salvos.\nPreencha todos os campos.");
			}
		}
	}
}
