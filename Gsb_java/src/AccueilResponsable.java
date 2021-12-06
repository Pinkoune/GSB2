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

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

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

    private JLabel lblMessage;

    //CONSTRUCTEURS
    public AccueilResponsable() {
    	
    	//Instanciation de la frame
    	this.framePrincipale = new JFrame();
    	
    	//Definition de la frame
        this.framePrincipale.setTitle("RaSio");
        this.framePrincipale.setLocationRelativeTo(null);
        this.framePrincipale.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.framePrincipale.setSize(700, 500);

        //Instanciation des panels
        this.monPanel.setLayout(new FlowLayout(1, 4, 2));
        this.monPanel.setBackground(Color.pink);

        this.monPanelGlobal = new JPanel();
        this.monPanelGlobal.setLayout(new BorderLayout());

        //Creation des menus
        this.menuMateriel = new JMenu("Menu du materiel");
        this.menuVehicule = new JMenu("Menu des vehicules");

        //Creation de la barre de menu
        JMenuBar jMenu = new JMenuBar();

        //Creation des elements du menu materiel
        this.btnAffichageMateriel = new JMenuItem("Afficher les materiels");
        this.btnAjouterMateriel = new JMenuItem("Ajouter un materiel");
        this.btnSupprimerMateriel = new JMenuItem("Supprimer un materiel");
        this.btnRechercherMateriel = new JMenuItem("Rechercher un materiel");
        this.menuMateriel.add(this.btnAffichageMateriel);
        this.menuMateriel.add(this.btnAjouterMateriel);
        this.menuMateriel.add(this.btnSupprimerMateriel);
        this.menuMateriel.add(this.btnRechercherMateriel);

        //Creation des elements du menu vehicule
        this.btnAffichageVehicule = new JMenuItem("Afficher les vehicules");
        this.btnAjouterVehicule = new JMenuItem("Ajouter un vehicule");
        this.btnSupprimerVehicule = new JMenuItem("Supprimer un vehicule");
        this.btnRechercherVehicule = new JMenuItem("Rechercher un vehicule");
        this.menuVehicule.add(this.btnAffichageVehicule);
        this.menuVehicule.add(this.btnAjouterVehicule);
        this.menuVehicule.add(this.btnSupprimerVehicule);
        this.menuVehicule.add(this.btnRechercherVehicule);

        //Ecoute des items du menu course
        this.btnAjouterMateriel.addActionListener(this);
        this.btnSupprimerMateriel.addActionListener(this);
        this.btnRechercherMateriel.addActionListener(this);
        this.btnAffichageMateriel.addActionListener(this);

        //Ecoute des items du menu ecurie
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
        this.lblMessage.setText("Resonsable du GSB");

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
        if (e.getSource().equals(btnAjouterMateriel)) {
            this.framePrincipale.getContentPane().removeAll();
            this.framePrincipale.getContentPane().add(new AjoutMateriel().getMonPanelGlobal());
            this.framePrincipale.getContentPane().revalidate();
            this.framePrincipale.getContentPane().repaint();

        } else if (e.getSource().equals(btnSupprimerMateriel)) {

            this.framePrincipale.getContentPane().removeAll();
            this.framePrincipale.getContentPane().add(new SuppMateriel().getMonPanelGlobal());
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

        //Boutons des Vehicules
        } else if (e.getSource().equals(btnAjouterVehicule)) {

            this.framePrincipale.getContentPane().removeAll();
            this.framePrincipale.getContentPane().add(new AjoutVehicule().getMonPanelGlobal());
            this.framePrincipale.getContentPane().revalidate();
            this.framePrincipale.getContentPane().repaint();

        } else if (e.getSource().equals(btnSupprimerVehicule)) {

            this.framePrincipale.getContentPane().removeAll();
            this.framePrincipale.getContentPane().add(new SuppVehicule().getMonPanelGlobal());
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