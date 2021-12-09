/**
 * Ajout des Materiels
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

public class EmpruntMateriel extends JPanel implements ActionListener {

    //Attributs priv�s

    //Frame
    private JFrame framePrincipale;

    //Panel
    private JPanel panelAjoutMateriel;
    private JPanel panelMessage;
    private JPanel panelChamps;
    private JPanel monPanelGlobal = new JPanel();

    //Label
    private JLabel lblMessage;
    private JLabel lblNomMateriel;
    private JLabel lblDateDebut;
    private JLabel lblDateFin;
    private JLabel lblDuree;
    private JLabel lblInsertion;

    //JTextField
    private JTextField jtfDateDebut;
    private JTextField jtfDateFin;
    private JTextField jtfDuree;
    private JTextField jtfPseudo;
    
    //JComboBox
    private JComboBox jcbNomMateriel;

    //Bouton
    private JButton btnValider;

    //Constructeur
    public EmpruntMateriel(String unPseudo) {
    	
    	//Definition du pseudo
    	this.jtfPseudo = new JTextField();
    	this.jtfPseudo.setText(unPseudo);

        //Instanciation de la frame
        this.framePrincipale = new JFrame();

        //Instanciation des panels
        this.panelAjoutMateriel = new JPanel();
        this.panelMessage = new JPanel();
        this.panelChamps = new JPanel();
        this.monPanelGlobal.setLayout(new BorderLayout());

        //Background des panels
        this.panelAjoutMateriel.setBackground(Color.white);
        this.panelMessage.setBackground(Color.blue);
        this.panelChamps.setBackground(Color.white);

        //Disposition des panels
        this.panelAjoutMateriel.setLayout(new BorderLayout());
        this.panelMessage.setLayout(new FlowLayout());
        this.panelChamps.setLayout(new FlowLayout());

        //Instanciation des messages
        this.lblMessage = new JLabel("Materiel - Emprunt");
        this.lblNomMateriel = new JLabel("Nom du materiel :");
        this.lblDateDebut = new JLabel("Date du début de l'emprunt :");
        this.lblDateFin = new JLabel("Date de fin de l'emprunt :");
        this.lblDuree = new JLabel("Duree de l'emprunt :");
        this.lblInsertion = new JLabel();
        this.lblInsertion.setText("");
        
        //Instanciation des entr�es
        this.jtfDateDebut = new JTextField();
        this.jtfDateDebut.setPreferredSize(new Dimension(150, 30));
        this.jtfDateFin = new JTextField();
        this.jtfDateFin.setPreferredSize(new Dimension(150, 30));
        this.jtfDuree = new JTextField();
        this.jtfDuree.setPreferredSize(new Dimension(150, 30));

        //Couleur de la police
        this.lblMessage.setForeground(Color.white);
        this.lblNomMateriel.setForeground(Color.black);
        this.lblDateDebut.setForeground(Color.black);
        this.lblDateFin.setForeground(Color.black);
        this.lblDuree.setForeground(Color.black);

        //Instanciation des boutons
        this.btnValider = new JButton("Valider");
        this.btnValider.addActionListener(this);
        
        //Ajout de la liste dans le jcbNomMateriel
        ArrayList<String> listeMateriel = Modele.recupListeNomMateriel();
		String nomMateriel[] = new String[Modele.nbListeMateriel()];
		int i = 0; 
        for (String unMateriel : listeMateriel) {
            nomMateriel[i] = unMateriel;
            i++;
        }
        
        //Instanciation de la liste de noms
        this.jcbNomMateriel = new JComboBox<String>();
        this.jcbNomMateriel = new JComboBox<String>(nomMateriel);
        this.jcbNomMateriel.addActionListener(this);
        

        //Ajout des attributs aux panels
        this.panelAjoutMateriel.add(panelMessage, BorderLayout.PAGE_START);
        this.panelAjoutMateriel.add(panelChamps, BorderLayout.CENTER);

        this.panelMessage.add(lblMessage);

        this.panelChamps.add(lblNomMateriel);
        this.panelChamps.add(jcbNomMateriel);
        
        this.panelChamps.add(lblDateDebut);
        this.panelChamps.add(jtfDateDebut);
        
        this.panelChamps.add(lblDateFin);
        this.panelChamps.add(jtfDateFin);
        
        this.panelChamps.add(lblDuree);
        this.panelChamps.add(jtfDuree);
        
        this.panelChamps.add(btnValider);
        this.panelChamps.add(lblInsertion);

        //Toujours a la fin
        this.framePrincipale.getRootPane().setDefaultButton(btnValider);
        this.framePrincipale.setAlwaysOnTop(true);
        this.framePrincipale.getContentPane().add(panelAjoutMateriel);
        this.monPanelGlobal.add(panelAjoutMateriel, BorderLayout.CENTER);
        this.framePrincipale.getContentPane().add(monPanelGlobal);
    }

    //les getter et setter
    public JPanel getMonPanelGlobal() {
        return monPanelGlobal;
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnValider) {
            String nomMateriel = (String)jcbNomMateriel.getSelectedItem();
            int idMat = Modele.recupIdMateriel(nomMateriel);
            
            String nomVisiteur = this.jtfPseudo.getText();
            String idVisiteur = Modele.recupIdVisiteur(nomVisiteur);
            
            String dateDebut = jtfDateDebut.getText();
            String dateFin = jtfDateFin.getText();
            float duree = Integer.parseInt(jtfDuree.getText());
            
            boolean rep = Modele.ajoutEmpruntMateriel(idMat, dateDebut, dateFin, duree, idVisiteur);
            if (rep) {
            	boolean statut = Modele.majStatutMateriel(idMat);
            	if(statut) {
            		lblInsertion.setText("Emprunt reussi");
            	}
            	else {
            		lblInsertion.setText("ERREUR, emprunt avec statut echoue");
            	}
            } else {
                lblInsertion.setText("ERREUR, emprunt echoue");
            }
        }
    }
}