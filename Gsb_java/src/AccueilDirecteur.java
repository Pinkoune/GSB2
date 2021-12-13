/**
 * Page principale du programme
 * @return
 */

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
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

public class AccueilDirecteur extends JPanel implements ActionListener {

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
    private JMenuItem btnAffichageMateriel;
    private JMenuItem btnAffichageEmpruntMat;

    //Les boutons vehicules
    private JMenuItem btnAffichageVehicule;
    private JMenuItem btnAffichageEmpruntVehicule;

    //Label
    private JLabel lblMessage;

    //CONSTRUCTEURS
    public AccueilDirecteur() {
    	
    	//Instanciation de la frame
    	this.framePrincipale = new JFrame();
    	
    	//Definition de la frame
        this.framePrincipale.setTitle("GSB");
        this.framePrincipale.setLocationRelativeTo(null);
        this.framePrincipale.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.framePrincipale.setSize(700, 500);

        //Instanciation des panels
        this.monPanel.setLayout(new FlowLayout(1, 4, 2));
        this.monPanel.setBackground(Color.pink);

        this.monPanelGlobal = new JPanel();
        this.monPanelGlobal.setLayout(new BorderLayout());

        //Creation des menus
        this.menuMateriel = new JMenu("Gestion des matériels");
        this.menuVehicule = new JMenu("Gestion des véhicules");
        
        //Creation de la barre de menu
        this.jMenu = new JMenuBar();
        
        //Style du menu
        this.jMenu.setBackground(new Color(47,53,66));
        this.jMenu.setPreferredSize(new Dimension(700,35));
        this.jMenu.setBorder(BorderFactory.createLineBorder(new Color(47,53,66)));

        //Creation des elements du menu materiel
        this.btnAffichageEmpruntMat = new JMenuItem("Voir les emprunts de matériel");
        this.btnAffichageMateriel = new JMenuItem("Voir les matériels disponibles");
        this.menuMateriel.add(this.btnAffichageEmpruntMat);
        this.menuMateriel.add(this.btnAffichageMateriel);

        //Creation des elements du menu vehicule
        this.btnAffichageEmpruntVehicule = new JMenuItem("Voir les emprunts de véhicule");
        this.btnAffichageVehicule = new JMenuItem("Voir les véhicules disponibles");
        this.menuVehicule.add(this.btnAffichageEmpruntVehicule);
        this.menuVehicule.add(this.btnAffichageVehicule);

        //Ecoute des items du menu course
        this.btnAffichageMateriel.addActionListener(this);
        this.btnAffichageEmpruntMat.addActionListener(this);

        //Ecoute des items du menu ecurie
        this.btnAffichageVehicule.addActionListener(this);
        this.btnAffichageEmpruntVehicule.addActionListener(this);

        // Ajout de l'element au menu 
        jMenu.add(menuMateriel);
        jMenu.add(menuVehicule);
        
        

        // Permet de definir le menu utilise dans la JFrame
        this.framePrincipale.setJMenuBar(jMenu);

        //Label affichant le message
        this.lblMessage = new JLabel();
        this.lblMessage.setText("Directeur du GSB");

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
    	
        //Boutons des Materiels
        if (e.getSource().equals(btnAffichageMateriel)) {
        	ArrayList < Materiel > listeMateriel;
            listeMateriel = new ArrayList < Materiel > ();
            listeMateriel = Modele.affichageMateriel();
            this.framePrincipale.getContentPane().removeAll();
            this.framePrincipale.getContentPane().add(new AffMateriel(listeMateriel).getMonPanelGlobal());
            this.framePrincipale.getContentPane().revalidate();
            this.framePrincipale.getContentPane().repaint();

        } else if (e.getSource().equals(btnAffichageEmpruntMat)) {
            ArrayList < Materiel > listeMateriel;
            listeMateriel = new ArrayList < Materiel > ();
            listeMateriel = Modele.affichageEmpruntMaterielDirec();
            this.framePrincipale.getContentPane().removeAll();
            this.framePrincipale.getContentPane().add(new AffEmpruntMaterielDirecteur(listeMateriel).getMonPanelGlobal());
            this.framePrincipale.getContentPane().revalidate();
            this.framePrincipale.getContentPane().repaint();

        //Boutons des Vehicules
        } else if (e.getSource().equals(btnAffichageVehicule)) {
        	ArrayList < Vehicule > listeVehicule;
            listeVehicule = new ArrayList < Vehicule > ();
            listeVehicule = Modele.affichageVehicule();
            this.framePrincipale.getContentPane().removeAll();
            this.framePrincipale.getContentPane().add(new AffVehicule(listeVehicule).getMonPanelGlobal());
            this.framePrincipale.getContentPane().revalidate();
            this.framePrincipale.getContentPane().repaint();

        } else if (e.getSource().equals(btnAffichageEmpruntVehicule)) {
            ArrayList < Vehicule > listeVehicule;
            listeVehicule = new ArrayList < Vehicule > ();
            listeVehicule = Modele.affichageEmpruntVehiculeDirec();
            this.framePrincipale.getContentPane().removeAll();
            this.framePrincipale.getContentPane().add(new AffEmpruntVehiculeDirecteur(listeVehicule).getMonPanelGlobal());
            this.framePrincipale.getContentPane().revalidate();
            this.framePrincipale.getContentPane().repaint();

        }

    }

}