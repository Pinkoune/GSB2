/**
 * Suppression des Vehicules
 * @author Jeremy
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
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SuppVehicule extends JPanel implements ActionListener {

    //Attributs privés

    //Frame
    private JFrame framePrincipale;

    //Panel
    private JPanel panelSuppVehicule;
    private JPanel panelMessage;
    private JPanel panelChamps;
    private JPanel monPanelGlobal = new JPanel();

    //Label
    private JLabel lblMessage;
    private JLabel lblNomVehicule;
    private JLabel lblInsertion;
    
    //Login de l'utilisateur
    private JTextField jtfPseudo;

    //JBox
  	private JComboBox<String> listeVehicule;
  	
    //Bouton
    private JButton btnValider;

    public SuppVehicule(String unPseudo) {
    	
    	//Definition du pseudo
    	this.jtfPseudo = new JTextField();
    	this.jtfPseudo.setText(unPseudo);
    	
    	//Liste des vehicules
        this.listeVehicule = new JComboBox<String>();

        //Instanciation de la frame
        this.framePrincipale = new JFrame();

        //Instanciation des panels
        this.panelSuppVehicule = new JPanel();
        this.panelMessage = new JPanel();
        this.panelChamps = new JPanel();
        this.monPanelGlobal.setLayout(new BorderLayout());

        //Background des panels
        this.panelSuppVehicule.setBackground(Color.white);
        this.panelMessage.setBackground(new Color(144, 12, 63));
        this.panelChamps.setBackground(new Color(88, 24, 69));

        //Disposition des panels
        this.panelSuppVehicule.setLayout(new BorderLayout());
        this.panelMessage.setLayout(new FlowLayout());
        this.panelChamps.setLayout(new FlowLayout());

        //Instanciation des messages
        this.lblMessage = new JLabel("Vehicule - suppression");
        this.lblNomVehicule = new JLabel("Choisissez le modèle à supprimer :");
        this.lblInsertion = new JLabel("");

        //Liste des Véhicules
        ArrayList<String> listeDesVehicules = Modele.recupListeNomVehicule();
 		String nomVehicule[] = new String[Modele.nbListeVehicule()];
 		int i = 0; 
 	    for (String unVehicule : listeDesVehicules) {
 	    	nomVehicule[i] = unVehicule;
 	        i++;
 	    }
 	   this.listeVehicule = new JComboBox<String>(nomVehicule);	   
 	   this.listeVehicule.setBackground(new Color(47,53,66));
	   this.listeVehicule.setBorder(BorderFactory.createLineBorder(new Color(144, 12, 63)));
	   this.listeVehicule.setForeground(Color.white);
	   this.listeVehicule.setSelectedIndex(-1);
 	   this.listeVehicule.addActionListener(this);

        //Couleur de la police
        this.lblMessage.setForeground(Color.white);
        this.lblNomVehicule.setForeground(Color.white);
        this.lblInsertion.setForeground(Color.white);

        //Instanciation des boutons
        this.btnValider = new JButton("Valider");
        this.btnValider.setBorder(null);
		this.btnValider.setBackground(new Color(144, 12, 63));
		this.btnValider.setForeground(Color.white);
		this.btnValider.setPreferredSize(new Dimension(170,30));
        this.btnValider.addActionListener(this);

        //Ajout des attributs aux panels
        this.panelSuppVehicule.add(panelMessage, BorderLayout.PAGE_START);
        this.panelSuppVehicule.add(panelChamps, BorderLayout.CENTER);

        this.panelMessage.add(lblMessage);

        this.panelChamps.add(lblNomVehicule);
        this.panelChamps.add(listeVehicule);
        this.panelChamps.add(btnValider);
        this.panelChamps.add(lblInsertion);

        //Toujours à la fin
        this.framePrincipale.getRootPane().setDefaultButton(btnValider);
        this.framePrincipale.setAlwaysOnTop(true);
        this.framePrincipale.getContentPane().add(panelSuppVehicule);
        this.monPanelGlobal.add(panelSuppVehicule, BorderLayout.CENTER);
        this.framePrincipale.getContentPane().add(this.monPanelGlobal);
    }

    //les getter et setter
    public JPanel getMonPanelGlobal() {
        return monPanelGlobal;
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnValider) {
        	
    		String modeleVehicule = listeVehicule.getSelectedItem().toString();	
    		int idVehicule = Modele.recupIdVehicule(modeleVehicule);
    		
    		//Changement du nom Visiteur en idVisiteur
            String nomVisiteur = this.jtfPseudo.getText();
            String idVisiteur = Modele.recupIdVisiteur(nomVisiteur);
            
            if (Modele.suppressionVehicule(modeleVehicule)) {
            	if(Modele.suppressionEmpruntVehicule(idVehicule, idVisiteur)) {
            		lblInsertion.setText("Suppression effectuée.");
            	}
            	else {
            		lblInsertion.setText("Problème dans la suppression de l'emprunt.");
            	}
            } else {
                lblInsertion.setText("Suppression non effectuée.");
            }
        }
    }

}