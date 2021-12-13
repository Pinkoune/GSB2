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

public class AccueilVisiteur extends JPanel implements ActionListener {

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
    private JMenuItem btnEmpruntMateriel;
    private JMenuItem btnSupprimerEmpruntMat;
    private JMenuItem btnAffichageEmpruntMat;

    //Les boutons vehicules
    private JMenuItem btnEmpruntVehicule;
    private JMenuItem btnSupprimerEmpruntVehicule;
    private JMenuItem btnAffichageEmpruntVehicule;

    //Label
    private JLabel lblMessage;
    
    //JText du login visiteur
    private JTextField jtfPseudo;

    //CONSTRUCTEURS
    public AccueilVisiteur(String unPseudo) {
    	
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
        this.menuMateriel = new JMenu("Emprunt matériel");
        this.menuVehicule = new JMenu("Emprunt véhicule");
        
        //Style des menus
        this.menuMateriel.setForeground(Color.white);
        this.menuVehicule.setForeground(Color.white);
        
        //Creation des elements du menu materiel
        this.btnAffichageEmpruntMat = new JMenuItem("Voir mes emprunts");
        this.btnEmpruntMateriel = new JMenuItem("Emprunter un matériel");
        this.btnSupprimerEmpruntMat = new JMenuItem("Retirer un emprunt");
        this.menuMateriel.add(this.btnAffichageEmpruntMat);
        this.menuMateriel.add(this.btnEmpruntMateriel);
        this.menuMateriel.add(this.btnSupprimerEmpruntMat);

        //Creation des elements du menu vehicule
        this.btnAffichageEmpruntVehicule = new JMenuItem("Voir mes emprunts");
        this.btnEmpruntVehicule = new JMenuItem("Emprunter un véhicule");
        this.btnSupprimerEmpruntVehicule = new JMenuItem("Retirer un emprunt");
        this.menuVehicule.add(this.btnAffichageEmpruntVehicule);
        this.menuVehicule.add(this.btnEmpruntVehicule);
        this.menuVehicule.add(this.btnSupprimerEmpruntVehicule);
        
        //Couleurs des items des matériels
        this.btnAffichageEmpruntMat.setBackground(new Color(47,53,66));
        this.btnEmpruntMateriel.setBackground(new Color(47,53,66));
        this.btnSupprimerEmpruntMat.setBackground(new Color(47,53,66));
        
        this.btnAffichageEmpruntMat.setForeground(Color.white);
        this.btnEmpruntMateriel.setForeground(Color.white);
        this.btnSupprimerEmpruntMat.setForeground(Color.white);
        
        //Couleurs des items des véhicules
        this.btnAffichageEmpruntVehicule.setBackground(new Color(47,53,66));
        this.btnEmpruntVehicule.setBackground(new Color(47,53,66));
        this.btnSupprimerEmpruntVehicule.setBackground(new Color(47,53,66));
        
        this.btnAffichageEmpruntVehicule.setForeground(Color.white);
        this.btnEmpruntVehicule.setForeground(Color.white);
        this.btnSupprimerEmpruntVehicule.setForeground(Color.white);

        //Ecoute des items du menu course
        this.btnEmpruntMateriel.addActionListener(this);
        this.btnSupprimerEmpruntMat.addActionListener(this);
        this.btnAffichageEmpruntMat.addActionListener(this);

        //Ecoute des items du menu ecurie
        this.btnEmpruntVehicule.addActionListener(this);
        this.btnSupprimerEmpruntVehicule.addActionListener(this);
        this.btnAffichageEmpruntVehicule.addActionListener(this);

        // Ajout de l'element au menu 
        jMenu.add(menuMateriel);
        jMenu.add(menuVehicule);

        // Permet de definir le menu utilise dans la JFrame
        this.framePrincipale.setJMenuBar(jMenu);

        //Label affichant le message
        this.lblMessage = new JLabel();
        this.lblMessage.setText("Visiteur du GSB");
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

        //Boutons des Materiels
        if (e.getSource().equals(btnEmpruntMateriel)) {
            this.framePrincipale.getContentPane().removeAll();
            this.framePrincipale.getContentPane().add(new EmpruntMateriel(pseudo).getMonPanelGlobal());
            this.framePrincipale.getContentPane().revalidate();
            this.framePrincipale.getContentPane().repaint();

        } else if (e.getSource().equals(btnSupprimerEmpruntMat)) {

            this.framePrincipale.getContentPane().removeAll();
            this.framePrincipale.getContentPane().add(new EmpruntSuppMateriel(pseudo).getMonPanelGlobal());
            this.framePrincipale.getContentPane().revalidate();
            this.framePrincipale.getContentPane().repaint();

        } else if (e.getSource().equals(btnAffichageEmpruntMat)) {
        	String nomVisiteur = this.jtfPseudo.getText();
            String idVisiteur = Modele.recupIdVisiteur(nomVisiteur);
            ArrayList < Materiel > listeMateriel;
            listeMateriel = new ArrayList < Materiel > ();
            listeMateriel = Modele.affichageEmpruntMateriel(idVisiteur);
            this.framePrincipale.getContentPane().removeAll();
            this.framePrincipale.getContentPane().add(new EmpruntAffichageMateriel(listeMateriel).getMonPanelGlobal());
            this.framePrincipale.getContentPane().revalidate();
            this.framePrincipale.getContentPane().repaint();

        //Boutons des Vehicules
        } else if (e.getSource().equals(btnEmpruntVehicule)) {

            this.framePrincipale.getContentPane().removeAll();
            this.framePrincipale.getContentPane().add(new EmpruntVehicule(pseudo).getMonPanelGlobal());
            this.framePrincipale.getContentPane().revalidate();
            this.framePrincipale.getContentPane().repaint();

        } else if (e.getSource().equals(btnSupprimerEmpruntVehicule)) {

            this.framePrincipale.getContentPane().removeAll();
            this.framePrincipale.getContentPane().add(new EmpruntSuppVehicule(pseudo).getMonPanelGlobal());
            this.framePrincipale.getContentPane().revalidate();
            this.framePrincipale.getContentPane().repaint();

        } else if (e.getSource().equals(btnAffichageEmpruntVehicule)) {
        	String nomVisiteur = this.jtfPseudo.getText();
            String idVisiteur = Modele.recupIdVisiteur(nomVisiteur);
            ArrayList < Vehicule > listeVehicule;
            listeVehicule = new ArrayList < Vehicule > ();
            listeVehicule = Modele.affichageEmpruntVehicule(idVisiteur);
            this.framePrincipale.getContentPane().removeAll();
            this.framePrincipale.getContentPane().add(new EmpruntAffichageVehicule(listeVehicule).getMonPanelGlobal());
            this.framePrincipale.getContentPane().revalidate();
            this.framePrincipale.getContentPane().repaint();

        }

    }

}