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
		
		// Background des panels
		this.monPanel.setBackground(new Color(22, 38, 119));
		this.monPanelGlobal.setBackground(new Color(22, 38, 119));
		this.panelErreur.setBackground(new Color(22, 38, 119));

		// Instanciation des JLabel
		this.lblIdentifiant = new JLabel("Identifiant :");
		this.lblMotDePasse = new JLabel("Mot de Passe :");
		this.lblErreur = new JLabel("");

		//Couleur de la police
        this.lblIdentifiant.setForeground(Color.white);
        this.lblMotDePasse.setForeground(Color.white);
        this.lblErreur.setForeground(Color.white);
		
		// Instanciation des JTextField
		this.jtextIdentifiant = new JTextField("");
		this.jpassMdp = new JPasswordField("");

		// Création des box pour entrer les infos
		this.jtextIdentifiant.setPreferredSize(new Dimension(150,30));
		this.jpassMdp.setPreferredSize(new Dimension(150, 30));

		// JButton
		this.btnConnexion = new JButton ("Connexion");
		this.btnConnexion.setBorder(null);
		this.btnConnexion.setBackground(new Color(67, 87, 186));
		this.btnConnexion.setForeground(Color.white);
		this.btnConnexion.setPreferredSize(new Dimension(170,30));
		this.btnConnexion.addActionListener(this);

		//Ajout des elements au panel central
		this.monPanel.add(lblIdentifiant);
		this.monPanel.add(jtextIdentifiant);
		this.monPanel.add(lblMotDePasse);
		this.monPanel.add(jpassMdp);
		this.monPanel.add(btnConnexion);

		this.panelErreur.add(lblErreur);

		//Ajout de l'élément titre au panel titre
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
			if (Modele.coResponsable(pseudo, mdp)) {
				this.dispose();
				new AccueilResponsable(pseudo).getMonPanelGlobal();

			}
			if (Modele.coDirecteur(pseudo, mdp)) {
				this.dispose();
				new AccueilDirecteur().getMonPanelGlobal();
			}
			if (Modele.coVisiteur(pseudo, mdp)) {
				this.dispose();
				new AccueilVisiteur(pseudo).getMonPanelGlobal();

			}
			this.lblErreur.setText("Identifiant incorrect.");
		}
	}
}