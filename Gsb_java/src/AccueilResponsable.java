/**
 * Page principale du programme
 * @return
 */

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AccueilResponsable extends JPanel implements ActionListener {

    //Frame
    private JFrame framePrincipale;

    //les panel classiques
    private JPanel monPanel = new JPanel();
    private JPanel monPanelGlobal = new JPanel();

    //La barre menu
    private JMenuBar jMenu;

    //Les menus
    private JMenu menuMateriel;
    private JMenu menuVehicule;

    //Les boutons materiels
    private JMenuItem btnAjouterMateriel;
    private JMenuItem btnSupprimerMateriel;
    private JMenuItem btnRechercherMateriel;
    private JMenuItem btnAffichageMateriel;

    //Les boutons vehicules
    private JMenuItem btnAjouterVehicule;
    private JMenuItem btnSupprimerVehicule;
    private JMenuItem btnRechercherVehicule;
    private JMenuItem btnAffichageVehicule;

    //Label
    private JLabel lblMessage;
    
    //JText du login visiteur
    private JTextField jtfPseudo;

    //CONSTRUCTEURS
    public AccueilResponsable(String unPseudo) {
    	
    	//Definition du pseudo
    	this.jtfPseudo = new JTextField();
    	this.jtfPseudo.setText(unPseudo);
    	
    	//Instanciation de la frame
    	this.framePrincipale = new JFrame();
    	
    	//Definition de la frame
        this.framePrincipale.setTitle("GSB");
        this.framePrincipale.setLocationRelativeTo(null);
        this.framePrincipale.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.framePrincipale.setSize(700, 500);
        
        //Instanciation des panels
        this.monPanel.setLayout(new FlowLayout(1, 4, 2));
        this.monPanel.setBackground(new Color(22, 38, 119));

        this.monPanelGlobal = new JPanel();
        this.monPanelGlobal.setLayout(new BorderLayout());
        
        //Creation de la barre de menu
        this.jMenu = new JMenuBar();
        
        //Style de la barre de menu
        this.jMenu.setBackground(new Color(47,53,66));
        this.jMenu.setPreferredSize(new Dimension(700,30));
        this.jMenu.setBorder(BorderFactory.createLineBorder(new Color(47,53,66)));
        
        //Creation des menus
        this.menuMateriel = new JMenu("Menu du mat??riel");
        this.menuVehicule = new JMenu("Menu des v??hicules");
        
        this.menuMateriel.setBackground(new Color(47,53,66));
        this.menuVehicule.setBackground(new Color(47,53,66));
        
        //Style des menus
        this.menuMateriel.setForeground(Color.white);
        this.menuVehicule.setForeground(Color.white);

        //Creation des elements du menu materiel
        this.btnAffichageMateriel = new JMenuItem("Afficher les mat??riels");
        this.btnAjouterMateriel = new JMenuItem("Ajouter un mat??riel");
        this.btnSupprimerMateriel = new JMenuItem("Supprimer un mat??riel");
        this.btnRechercherMateriel = new JMenuItem("Rechercher un mat??riel");
        this.menuMateriel.add(this.btnAffichageMateriel);
        this.menuMateriel.add(this.btnAjouterMateriel);
        this.menuMateriel.add(this.btnSupprimerMateriel);
        this.menuMateriel.add(this.btnRechercherMateriel);

        //Creation des elements du menu vehicule
        this.btnAffichageVehicule = new JMenuItem("Afficher les v??hicules");
        this.btnAjouterVehicule = new JMenuItem("Ajouter un v??hicule");
        this.btnSupprimerVehicule = new JMenuItem("Supprimer un v??hicule");
        this.btnRechercherVehicule = new JMenuItem("Rechercher un v??hicule");
        this.menuVehicule.add(this.btnAffichageVehicule);
        this.menuVehicule.add(this.btnAjouterVehicule);
        this.menuVehicule.add(this.btnSupprimerVehicule);
        this.menuVehicule.add(this.btnRechercherVehicule);
        
        //Couleurs des items des mat??riels
        this.btnAjouterMateriel.setBackground(new Color(47,53,66));
        this.btnSupprimerMateriel.setBackground(new Color(47,53,66));
        this.btnRechercherMateriel.setBackground(new Color(47,53,66));
        this.btnAffichageMateriel.setBackground(new Color(47,53,66));
        
        this.btnAjouterMateriel.setForeground(Color.white);
        this.btnSupprimerMateriel.setForeground(Color.white);
        this.btnRechercherMateriel.setForeground(Color.white);
        this.btnAffichageMateriel.setForeground(Color.white);
        
        //Couleurs des items des v??hicules
        this.btnAjouterVehicule.setBackground(new Color(47,53,66));
        this.btnSupprimerVehicule.setBackground(new Color(47,53,66));
        this.btnRechercherVehicule.setBackground(new Color(47,53,66));
        this.btnAffichageVehicule.setBackground(new Color(47,53,66));
        
        this.btnAjouterVehicule.setForeground(Color.white);
        this.btnSupprimerVehicule.setForeground(Color.white);
        this.btnRechercherVehicule.setForeground(Color.white);
        this.btnAffichageVehicule.setForeground(Color.white);

        //Ecoute des items du menu mat??riel
        this.btnAjouterMateriel.addActionListener(this);
        this.btnSupprimerMateriel.addActionListener(this);
        this.btnRechercherMateriel.addActionListener(this);
        this.btnAffichageMateriel.addActionListener(this);

        //Ecoute des items du menu v??hicule
        this.btnAjouterVehicule.addActionListener(this);
        this.btnSupprimerVehicule.addActionListener(this);
        this.btnRechercherVehicule.addActionListener(this);
        this.btnAffichageVehicule.addActionListener(this);

        // Ajout de l'element au menu 
        jMenu.add(menuMateriel);
        jMenu.add(menuVehicule);

        // Permet de definir le menu utilise dans la JFrame
        this.framePrincipale.setJMenuBar(jMenu);

        //Label affichant le message
        this.lblMessage = new JLabel();
        this.lblMessage.setText("Responsable du GSB");
        this.lblMessage.setFont(new Font("Serif", Font.BOLD, 30));
        
        //Couleur de la police
        this.lblMessage.setForeground(Color.white);

        //Ajout des panels
        this.monPanel.add(lblMessage);
        this.monPanelGlobal.add(monPanel, BorderLayout.CENTER);

        this.framePrincipale.getContentPane().add(this.monPanelGlobal);
        this.framePrincipale.setVisible(true);

    }

    //les getter et setter
    public JPanel getMonPanelGlobal() {
        return monPanelGlobal;
    }

    //Lance le changement de panel
    public void actionPerformed(ActionEvent e) {
    	
    	String pseudo = this.jtfPseudo.getText();

        //Boutons des Mat??riels
        if (e.getSource().equals(btnAjouterMateriel)) {
            this.framePrincipale.getContentPane().removeAll();
            this.framePrincipale.getContentPane().add(new AjoutMateriel().getMonPanelGlobal());
            this.framePrincipale.getContentPane().revalidate();
            this.framePrincipale.getContentPane().repaint();

        } else if (e.getSource().equals(btnSupprimerMateriel)) {

            this.framePrincipale.getContentPane().removeAll();
            this.framePrincipale.getContentPane().add(new SuppMateriel(pseudo).getMonPanelGlobal());
            this.framePrincipale.getContentPane().revalidate();
            this.framePrincipale.getContentPane().repaint();

        } else if (e.getSource().equals(btnRechercherMateriel)) {

            this.framePrincipale.getContentPane().removeAll();
            this.framePrincipale.getContentPane().add(new RechercheMateriel().getMonPanelGlobal());
            this.framePrincipale.getContentPane().revalidate();
            this.framePrincipale.getContentPane().repaint();

        } else if (e.getSource().equals(btnAffichageMateriel)) {
            ArrayList < Materiel > listeMateriel;
            listeMateriel = new ArrayList < Materiel > ();
            listeMateriel = Modele.affichageMateriel();
            this.framePrincipale.getContentPane().removeAll();
            this.framePrincipale.getContentPane().add(new AffMateriel(listeMateriel).getMonPanelGlobal());
            this.framePrincipale.getContentPane().revalidate();
            this.framePrincipale.getContentPane().repaint();

        //Boutons des V??hicules
        } else if (e.getSource().equals(btnAjouterVehicule)) {

            this.framePrincipale.getContentPane().removeAll();
            this.framePrincipale.getContentPane().add(new AjoutVehicule().getMonPanelGlobal());
            this.framePrincipale.getContentPane().revalidate();
            this.framePrincipale.getContentPane().repaint();

        } else if (e.getSource().equals(btnSupprimerVehicule)) {

            this.framePrincipale.getContentPane().removeAll();
            this.framePrincipale.getContentPane().add(new SuppVehicule(pseudo).getMonPanelGlobal());
            this.framePrincipale.getContentPane().revalidate();
            this.framePrincipale.getContentPane().repaint();

        } else if (e.getSource().equals(btnRechercherVehicule)) {

            this.framePrincipale.getContentPane().removeAll();
            this.framePrincipale.getContentPane().add(new RechercheVehicule().getMonPanelGlobal());
            this.framePrincipale.getContentPane().revalidate();
            this.framePrincipale.getContentPane().repaint();

        } else if (e.getSource().equals(btnAffichageVehicule)) {
            ArrayList < Vehicule > listeVehicule;
            listeVehicule = new ArrayList < Vehicule > ();
            listeVehicule = Modele.affichageVehicule();
            this.framePrincipale.getContentPane().removeAll();
            this.framePrincipale.getContentPane().add(new AffVehicule(listeVehicule).getMonPanelGlobal());
            this.framePrincipale.getContentPane().revalidate();
            this.framePrincipale.getContentPane().repaint();

        }

    }

}