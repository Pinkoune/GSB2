/**
 * Suppression des Materiels
 * @author Jeremy
 */

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SuppMateriel extends JPanel implements ActionListener {

    //Attributs privés

    //Frame
    private JFrame framePrincipale;

    //Panel
    private JPanel panelSuppMateriel;
    private JPanel panelMessage;
    private JPanel panelChamps;
    private JPanel monPanelGlobal = new JPanel();

    //Label
    private JLabel lblMessage;
    private JLabel lblNomMateriel;
    private JLabel lblInsertion;

    //JBox
  	private JComboBox<String> listeMateriel;
  	
  	//Login de l'utilisateur
    private JTextField jtfPseudo;

    //Bouton
    private JButton btnValider;

    public SuppMateriel(String unPseudo) {
    	
    	//Definition du pseudo
    	this.jtfPseudo = new JTextField();
    	this.jtfPseudo.setText(unPseudo);
    	
    	//Liste des vehicules
        this.listeMateriel = new JComboBox<String>();

        //Instanciation de la frame
        this.framePrincipale = new JFrame();

        //Instanciation des panels
        this.panelSuppMateriel = new JPanel();
        this.panelMessage = new JPanel();
        this.panelChamps = new JPanel();
        this.monPanelGlobal.setLayout(new BorderLayout());

        //Background des panels
        this.panelSuppMateriel.setBackground(Color.white);
        this.panelMessage.setBackground(new Color(67, 87, 186));
        this.panelChamps.setBackground(new Color(22, 38, 119));

        //Disposition des panels
        this.panelSuppMateriel.setLayout(new BorderLayout());
        this.panelMessage.setLayout(new FlowLayout());
        this.panelChamps.setLayout(new FlowLayout());

        //Instanciation des messages
        this.lblMessage = new JLabel("Materiel - suppression");
        this.lblNomMateriel = new JLabel("Choisissez le matériel à supprimer :");
        this.lblInsertion = new JLabel("");

        //Liste des Matériels
        ArrayList<String> listeDeMateriel = Modele.recupListeNomMateriel();
 		String nomMateriel[] = new String[Modele.nbListeMateriel()];
 		int i = 0; 
 	    for (String unMateriel : listeDeMateriel) {
 	    	nomMateriel[i] = unMateriel;
 	        i++;
 	    }
 	   this.listeMateriel = new JComboBox<String>(nomMateriel);	   
 	   this.listeMateriel.addActionListener(this);

        //Couleur de la police
        this.lblMessage.setForeground(Color.white);
        this.lblNomMateriel.setForeground(Color.white);
        this.lblInsertion.setForeground(Color.white);

        //Instanciation des boutons
        this.btnValider = new JButton("Valider");
        this.btnValider.setBorder(null);
		this.btnValider.setBackground(new Color(67, 87, 186));
		this.btnValider.setForeground(Color.white);
		this.btnValider.setPreferredSize(new Dimension(170,30));
        this.btnValider.addActionListener(this);

        //Ajout des attributs aux panels
        this.panelSuppMateriel.add(panelMessage, BorderLayout.PAGE_START);
        this.panelSuppMateriel.add(panelChamps, BorderLayout.CENTER);

        this.panelMessage.add(lblMessage);

        this.panelChamps.add(lblNomMateriel);
        this.panelChamps.add(listeMateriel);
        this.panelChamps.add(btnValider);
        this.panelChamps.add(lblInsertion);

        //Toujours à la fin
        this.framePrincipale.getRootPane().setDefaultButton(btnValider);
        this.framePrincipale.setAlwaysOnTop(true);
        this.framePrincipale.getContentPane().add(panelSuppMateriel);
        this.monPanelGlobal.add(panelSuppMateriel, BorderLayout.CENTER);
        this.framePrincipale.getContentPane().add(this.monPanelGlobal);
    }

    //les getter et setter
    public JPanel getMonPanelGlobal() {
        return monPanelGlobal;
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnValider) {
        	
        	String nomMateriel = listeMateriel.getSelectedItem().toString();	
            int idMat = Modele.recupIdMateriel(nomMateriel);
            
            //Changement du nom Visiteur en idVisiteur
            String nomVisiteur = this.jtfPseudo.getText();
            String idVisiteur = Modele.recupIdVisiteur(nomVisiteur);
            
            if (Modele.suppressionMateriel(nomMateriel)) {
            	if(Modele.suppressionEmpruntMateriel(idMat, idVisiteur)) {
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