package edu.fatec.sjc.tela;

import java.awt.EventQueue;
import java.awt.Font;
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

import edu.fatec.sjc.model.Antropometrico;
import edu.fatec.sjc.repository.AntropometricoRepositorio;
import edu.fatec.sjc.tela.Padrao.CriancaPadrao;

public class TelaAntropometria extends JFrame {

	/**
	 * 
	 */
	@Autowired
	private AntropometricoRepositorio antroRepo;
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtPesoHabitual;
	private JTextField txtPesoAtual;
	private JTextField txtPesoEstimado;
	private JTextField txtEstatura;
	private JTextField txtPerimetroCraniano;
	private JTextField txtPerimetroToracico;
	private JTextField txtAlteracaoPesoRecente;
	private JTextField txtCircunferenciaAbdominal;
	private JTextField txtCircunferenciaCoxa;
	private JTextField txtCircunferenciaPanturrilha;
	private JTextField txtCircunferenciaPescoco;
	private JTextField txtDobraCutaneaTricipital;
	private JTextField txtDobraCutaneaSubescalar;
	private JTextField txtDobraCutaneaBicibital;
	private JTextField txtDobraCutaneaSupraIliaca;
	private JTextField txtAreaMuscularPolegar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaAntropometria frame = new TelaAntropometria();
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
	public TelaAntropometria() {
		setTitle("Antropometria");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 400, 520);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblPesoHabitual = new JLabel("Peso habitual:");

		txtPesoHabitual = new JTextField();
		txtPesoHabitual.setColumns(10);

		JLabel lblPesoAtual = new JLabel("Peso atual:");

		txtPesoAtual = new JTextField();
		txtPesoAtual.setColumns(10);

		JLabel lblPesoEstimado = new JLabel("Peso estimado:");

		txtPesoEstimado = new JTextField();
		txtPesoEstimado.setColumns(10);

		JLabel lblEstatura = new JLabel("Estatura:");

		txtEstatura = new JTextField();
		txtEstatura.setColumns(10);

		JLabel lblPerimetroCraniano = new JLabel("Perímetro craniano:");

		txtPerimetroCraniano = new JTextField();
		txtPerimetroCraniano.setColumns(10);

		JLabel lblPermetroTorcico = new JLabel("Perímetro torácico:");

		txtPerimetroToracico = new JTextField();
		txtPerimetroToracico.setColumns(10);

		JLabel lblAlteraoDePeso = new JLabel("Alteração de peso recente:");

		txtAlteracaoPesoRecente = new JTextField();
		txtAlteracaoPesoRecente.setColumns(10);

		JLabel lblCircunfernciaAbdominal = new JLabel("Circunferência abdominal:");

		txtCircunferenciaAbdominal = new JTextField();
		txtCircunferenciaAbdominal.setColumns(10);

		JLabel lblCircunfernciaCoxa = new JLabel("Circunferência coxa:");

		txtCircunferenciaCoxa = new JTextField();
		txtCircunferenciaCoxa.setColumns(10);

		JLabel lblCircunfernciaPanturrilha = new JLabel("Circunferência panturrilha:");

		txtCircunferenciaPanturrilha = new JTextField();
		txtCircunferenciaPanturrilha.setColumns(10);

		JLabel lblCircunfernciaPescoo = new JLabel("Circunferência pescoço:");

		txtCircunferenciaPescoco = new JTextField();
		txtCircunferenciaPescoco.setColumns(10);

		JLabel lblDobraCutneaTricipital = new JLabel("Dobra cutânea tricipital:");

		txtDobraCutaneaTricipital = new JTextField();
		txtDobraCutaneaTricipital.setColumns(10);

		JLabel lblDobraCutneaSubescalar = new JLabel("Dobra cutânea subescalar:");

		txtDobraCutaneaSubescalar = new JTextField();
		txtDobraCutaneaSubescalar.setColumns(10);

		JLabel lblDobraCuttneaBicibital = new JLabel("Dobra cuttânea bicibital:");

		txtDobraCutaneaBicibital = new JTextField();
		txtDobraCutaneaBicibital.setColumns(10);

		JLabel lblDobraCutneaSupra = new JLabel("Dobra cutânea supra iliaca:");

		txtDobraCutaneaSupraIliaca = new JTextField();
		txtDobraCutaneaSupraIliaca.setColumns(10);

		JLabel lblreaMuscularDo = new JLabel("Área muscular do polegar:");

		txtAreaMuscularPolegar = new JTextField();
		txtAreaMuscularPolegar.setColumns(10);

		JButton btnSalvar = new JButton("Cadastrar");
		btnSalvar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				cadastrar();

			}
		});

		JLabel lblNomeCrianca = new JLabel(CriancaPadrao.crianca.getNome());
		lblNomeCrianca.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane
				.setHorizontalGroup(
						gl_contentPane
								.createParallelGroup(
										Alignment.TRAILING)
								.addGroup(gl_contentPane.createSequentialGroup().addContainerGap()
										.addGroup(gl_contentPane
												.createParallelGroup(Alignment.TRAILING).addComponent(
														btnSalvar)
												.addGroup(gl_contentPane.createSequentialGroup().addGroup(gl_contentPane
														.createParallelGroup(Alignment.LEADING)
														.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
																.addComponent(lblDobraCutneaSupra)
																.addComponent(lblDobraCutneaSubescalar)
																.addComponent(lblCircunfernciaPanturrilha)
																.addComponent(lblAlteraoDePeso))
														.addComponent(lblPesoHabitual).addComponent(lblPesoAtual)
														.addComponent(lblPesoEstimado).addComponent(lblEstatura)
														.addComponent(lblPerimetroCraniano)
														.addComponent(lblPermetroTorcico)
														.addComponent(lblCircunfernciaAbdominal)
														.addComponent(lblCircunfernciaCoxa)
														.addComponent(lblCircunfernciaPescoo)
														.addComponent(lblDobraCutneaTricipital)
														.addComponent(lblDobraCuttneaBicibital)
														.addComponent(lblreaMuscularDo))
														.addPreferredGap(ComponentPlacement.UNRELATED)
														.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
																.addComponent(txtPesoHabitual,
																		GroupLayout.PREFERRED_SIZE,
																		GroupLayout.DEFAULT_SIZE,
																		GroupLayout.PREFERRED_SIZE)
																.addComponent(txtPesoAtual, GroupLayout.PREFERRED_SIZE,
																		GroupLayout.DEFAULT_SIZE,
																		GroupLayout.PREFERRED_SIZE)
																.addComponent(txtPesoEstimado,
																		GroupLayout.PREFERRED_SIZE,
																		GroupLayout.DEFAULT_SIZE,
																		GroupLayout.PREFERRED_SIZE)
																.addComponent(txtEstatura, GroupLayout.PREFERRED_SIZE,
																		GroupLayout.DEFAULT_SIZE,
																		GroupLayout.PREFERRED_SIZE)
																.addComponent(txtPerimetroCraniano,
																		GroupLayout.PREFERRED_SIZE,
																		GroupLayout.DEFAULT_SIZE,
																		GroupLayout.PREFERRED_SIZE)
																.addComponent(txtPerimetroToracico,
																		GroupLayout.PREFERRED_SIZE,
																		GroupLayout.DEFAULT_SIZE,
																		GroupLayout.PREFERRED_SIZE)
																.addComponent(txtAlteracaoPesoRecente,
																		GroupLayout.PREFERRED_SIZE,
																		GroupLayout.DEFAULT_SIZE,
																		GroupLayout.PREFERRED_SIZE)
																.addComponent(txtCircunferenciaAbdominal,
																		GroupLayout.PREFERRED_SIZE,
																		GroupLayout.DEFAULT_SIZE,
																		GroupLayout.PREFERRED_SIZE)
																.addComponent(txtCircunferenciaCoxa,
																		GroupLayout.PREFERRED_SIZE,
																		GroupLayout.DEFAULT_SIZE,
																		GroupLayout.PREFERRED_SIZE)
																.addComponent(txtCircunferenciaPanturrilha,
																		GroupLayout.PREFERRED_SIZE,
																		GroupLayout.DEFAULT_SIZE,
																		GroupLayout.PREFERRED_SIZE)
																.addComponent(txtCircunferenciaPescoco,
																		GroupLayout.PREFERRED_SIZE,
																		GroupLayout.DEFAULT_SIZE,
																		GroupLayout.PREFERRED_SIZE)
																.addComponent(txtDobraCutaneaTricipital,
																		GroupLayout.PREFERRED_SIZE,
																		GroupLayout.DEFAULT_SIZE,
																		GroupLayout.PREFERRED_SIZE)
																.addComponent(txtDobraCutaneaSubescalar,
																		GroupLayout.PREFERRED_SIZE,
																		GroupLayout.DEFAULT_SIZE,
																		GroupLayout.PREFERRED_SIZE)
																.addComponent(txtDobraCutaneaBicibital,
																		GroupLayout.PREFERRED_SIZE,
																		GroupLayout.DEFAULT_SIZE,
																		GroupLayout.PREFERRED_SIZE)
																.addComponent(txtDobraCutaneaSupraIliaca,
																		GroupLayout.PREFERRED_SIZE,
																		GroupLayout.DEFAULT_SIZE,
																		GroupLayout.PREFERRED_SIZE)
																.addComponent(txtAreaMuscularPolegar,
																		GroupLayout.PREFERRED_SIZE,
																		GroupLayout.DEFAULT_SIZE,
																		GroupLayout.PREFERRED_SIZE))))
										.addContainerGap(137, Short.MAX_VALUE))
								.addGroup(gl_contentPane.createSequentialGroup().addContainerGap(136, Short.MAX_VALUE)
										.addComponent(lblNomeCrianca).addGap(155)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup().addComponent(lblNomeCrianca)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtPesoHabitual, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblPesoHabitual))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtPesoAtual, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblPesoAtual))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtPesoEstimado, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblPesoEstimado))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtEstatura, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblEstatura))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtPerimetroCraniano, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblPerimetroCraniano))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtPerimetroToracico, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblPermetroTorcico))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(lblAlteraoDePeso)
								.addComponent(txtAlteracaoPesoRecente, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtCircunferenciaAbdominal, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblCircunfernciaAbdominal))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtCircunferenciaCoxa, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblCircunfernciaCoxa))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblCircunfernciaPanturrilha).addComponent(txtCircunferenciaPanturrilha,
										GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtCircunferenciaPescoco, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblCircunfernciaPescoo))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtDobraCutaneaTricipital, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblDobraCutneaTricipital))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblDobraCutneaSubescalar).addComponent(txtDobraCutaneaSubescalar,
										GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtDobraCutaneaBicibital, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblDobraCuttneaBicibital))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(
								gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(lblDobraCutneaSupra)
										.addComponent(txtDobraCutaneaSupraIliaca, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtAreaMuscularPolegar, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblreaMuscularDo))
						.addPreferredGap(ComponentPlacement.RELATED, 13, Short.MAX_VALUE).addComponent(btnSalvar)));
		contentPane.setLayout(gl_contentPane);
	}

	public void setAntroRepo(AntropometricoRepositorio antroRepo) {
		this.antroRepo = antroRepo;
	}

	public AntropometricoRepositorio getAntroRepo() {
		return antroRepo;
	}

	private void cadastrar() {
		if (CriancaPadrao.crianca.getId() != null) {

			Antropometrico antro = new Antropometrico();
			antro.setAlteracaoPesoRecente(Double.valueOf(txtAlteracaoPesoRecente.getText().replaceAll(",", ".")));
			antro.setAreaMuscularPolegar(Double.valueOf(txtAreaMuscularPolegar.getText().replaceAll(",", ".")));
			antro.setCircunferenciaAbdominal(Double.valueOf(txtCircunferenciaAbdominal.getText().replaceAll(",", ".")));
			antro.setCircunferenciaCoxa(Double.valueOf(txtCircunferenciaCoxa.getText().replaceAll(",", ".")));
			antro.setCircunferenciaPanturrilha(
					Double.valueOf(txtCircunferenciaPanturrilha.getText().replaceAll(",", ".")));
			antro.setCircunferenciaPescoco(Double.valueOf(txtCircunferenciaPescoco.getText().replaceAll(",", ".")));
			antro.setDobraCutaneaBicibital(Double.valueOf(txtDobraCutaneaBicibital.getText().replaceAll(",", ".")));
			antro.setDobraCutaneaSubescalar(Double.valueOf(txtDobraCutaneaSubescalar.getText().replaceAll(",", ".")));
			antro.setDobraCutaneaSupraIliaca(Double.valueOf(txtDobraCutaneaSupraIliaca.getText().replaceAll(",", ".")));
			antro.setDobraCutaneaTricipital(Double.valueOf(txtDobraCutaneaTricipital.getText().replaceAll(",", ".")));
			antro.setEstatura(Double.valueOf(txtEstatura.getText().replaceAll(",", ".")));
			antro.setPerimetroCraniano(Double.valueOf(txtPerimetroCraniano.getText().replaceAll(",", ".")));
			antro.setPerimetroToracico(Double.valueOf(txtPerimetroToracico.getText().replaceAll(",", ".")));
			antro.setPesoAtual(Double.valueOf(txtPesoAtual.getText().replaceAll(",", ".")));
			antro.setPesoEstimado(Double.valueOf(txtPesoEstimado.getText().replaceAll(",", ".")));
			antro.setPesoHabitual(Double.valueOf(txtPesoHabitual.getText().replaceAll(",", ".")));
			antro.setCrianca(CriancaPadrao.crianca);

			antroRepo.save(antro);

			if (antro.getId() == null) {
				JOptionPane.showMessageDialog(null, "Dados antropométricos não salvos.\nPreencha todos os campos.");
			}
		}
	}
}
