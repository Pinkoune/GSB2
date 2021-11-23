import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class FenetreConnexion extends JFrame implements ActionListener {
	
	//JPanel
    private JPanel monPanel;
    private JPanel monPanelGlobal;

	// JLabel
	private JLabel lblIdentifiant;
	private JLabel lblMotDePasse;
	
	// JTextField
	private JTextField jtextIdentifiant;
	private JPasswordField jpassMdp;
    private char getpass[];
    
	// Jbutton
	private JButton btnConnexion;
	
	public FenetreConnexion() {
		
		this.setTitle("GSB_2");
    	this.setLocationRelativeTo(null);
    	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	this.setSize(600, 400);
    	this.setResizable(false);
	     
		// Instanciation des panels
        this.monPanel = new JPanel();
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
        
        // Création des box pour entrée les info
        this.jtextIdentifiant.setPreferredSize(new Dimension(150,20));
        this.jpassMdp.setPreferredSize(new Dimension(150, 20));

        // JButton
        this.btnConnexion = new JButton ("Connexion");
        this.btnConnexion.addActionListener(this);

        //Ajout des éléments au panel central
        this.monPanel.add(lblIdentifiant);
        this.monPanel.add(jtextIdentifiant);
        this.monPanel.add(lblMotDePasse);
        this.monPanel.add(jpassMdp);
        this.monPanel.add(btnConnexion);
        
        //Ajout de l'élément titre au panel titre 

        this.setAlwaysOnTop(true);
        this.getContentPane().add(monPanel);
        this.setVisible(true);
        
        // Layout des panels
        this.monPanelGlobal.add(monPanel, BorderLayout.NORTH);
        this.getContentPane().add(this.monPanelGlobal);
    }

	@Override

	
	public void actionPerformed (ActionEvent evenement) {
    	if(evenement.getSource() == btnConnexion) { //Si JButton connexion est cliqué
    		String login = jtextIdentifiant.getText();
    		getpass = jpassMdp.getPassword();
    		String mdp = String.valueOf(getpass);
    		if(Modele.connecter(login, mdp)) {
    			this.dispose();
    			AccueilResponsable uneAutreFenetre = new AccueilResponsable();
    		}
    		else {
    			JLabel reponse = new JLabel("Erreur");	
    			this.monPanel.add(reponse);
    			monPanel.revalidate();
    			monPanel.repaint();
    		}
    	}
    }
	
	

}