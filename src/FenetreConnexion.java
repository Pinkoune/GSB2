import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class FenetreConnexion extends JFrame implements ActionListener {

	//JPanel
	private JPanel monPanel;
	private JPanel panelErreur;
	private JPanel monPanelGlobal;

	// JLabel
	private JLabel lblIdentifiant;
	private JLabel lblMotDePasse;
	private JLabel lblErreur;

	// JTextField
	private JTextField jtextIdentifiant;
	private JPasswordField jpassMdp;

	// Jbutton
	private JButton btnConnexion;

	public FenetreConnexion() {

		// Informations de la fenetre
		this.setTitle("GSB_2");
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(700, 300);
		this.setBackground(Color.gray);
		this.setResizable(false);

		// Instanciation des panels
		this.monPanel = new JPanel();
		this.panelErreur = new JPanel();
		this.monPanelGlobal = new JPanel();

		// Set Layout des panels
		this.monPanel.setLayout(new FlowLayout());
		this.monPanelGlobal.setLayout(new FlowLayout());

		// Instanciation des JLabel
		this.lblIdentifiant = new JLabel("Identifiant :") ;
		this.lblMotDePasse = new JLabel("Mot de Passe :") ;

		// Instanciation des JTextField
		this.jtextIdentifiant = new JTextField("");
		this.jpassMdp = new JPasswordField("");
		this.lblErreur = new JLabel("");

		// Cr�ation des box pour entr�e les info
		this.jtextIdentifiant.setPreferredSize(new Dimension(150,30));
		this.jpassMdp.setPreferredSize(new Dimension(150, 30));

		// JButton
		this.btnConnexion = new JButton ("Connexion");
		this.btnConnexion.addActionListener(this);

		//Ajout des elements au panel central
		this.monPanel.add(lblIdentifiant);
		this.monPanel.add(jtextIdentifiant);
		this.monPanel.add(lblMotDePasse);
		this.monPanel.add(jpassMdp);
		this.monPanel.add(btnConnexion);

		this.panelErreur.add(lblErreur);

		//Ajout de l'�l�ment titre au panel titre
		this.getRootPane().setDefaultButton(btnConnexion);
		this.setAlwaysOnTop(true);
		this.monPanelGlobal.add(monPanel, BorderLayout.NORTH);
		this.monPanelGlobal.add(panelErreur, BorderLayout.CENTER);
		this.getContentPane().add(this.monPanelGlobal);
		this.setVisible(true);
	}

	//Get du panel global
	public JPanel getMonPanelGlobal() {
		return monPanelGlobal;
	}

	@Override
	public void actionPerformed (ActionEvent e) {
		if (e.getSource() == btnConnexion) {
			String pseudo = jtextIdentifiant.getText();
			String mdp = jpassMdp.getText();
			if (Modele.connecter(pseudo, mdp)) {
				this.dispose();
				new FenetreAccueil().getMonPanelGlobal();

			}
			this.lblErreur.setText("Identifiant incorrect.");
		}
	}
}