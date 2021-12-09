/**
 * Ajout des Vehicules
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

public class EmpruntVehicule extends JPanel implements ActionListener {

    //Attributs priv�s

    //Frame
    private JFrame framePrincipale;

    //Panel
    private JPanel panelAjoutVehicule;
    private JPanel panelMessage;
    private JPanel panelChamps;
    private JPanel monPanelGlobal = new JPanel();

    //Label
    private JLabel lblMessage;
    private JLabel lblNomVehicule;
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
    private JComboBox jcbNomVehicule;

    //Bouton
    private JButton btnValider;

    //Constructeur
    public EmpruntVehicule(String unPseudo) {
    	
    	//Definition du pseudo
    	this.jtfPseudo = new JTextField();
    	this.jtfPseudo.setText(unPseudo);

        //Instanciation de la frame
        this.framePrincipale = new JFrame();

        //Instanciation des panels
        this.panelAjoutVehicule = new JPanel();
        this.panelMessage = new JPanel();
        this.panelChamps = new JPanel();
        this.monPanelGlobal.setLayout(new BorderLayout());

        //Background des panels
        this.panelAjoutVehicule.setBackground(Color.white);
        this.panelMessage.setBackground(Color.blue);
        this.panelChamps.setBackground(Color.white);

        //Disposition des panels
        this.panelAjoutVehicule.setLayout(new BorderLayout());
        this.panelMessage.setLayout(new FlowLayout());
        this.panelChamps.setLayout(new FlowLayout());

        //Instanciation des messages
        this.lblMessage = new JLabel("Vehicule - Emprunt");
        this.lblNomVehicule = new JLabel("Nom du Vehicule :");
        this.lblDateDebut = new JLabel("Date du debut de l'emprunt :");
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
        this.lblNomVehicule.setForeground(Color.black);
        this.lblDateDebut.setForeground(Color.black);
        this.lblDateFin.setForeground(Color.black);
        this.lblDuree.setForeground(Color.black);

        //Instanciation des boutons
        this.btnValider = new JButton("Valider");
        this.btnValider.addActionListener(this);
        
        //Ajout de la liste dans le jcbNomVehicule
        ArrayList<String> listeVehicule = Modele.recupListeNomVehicule();
		String nomVehicule[] = new String[Modele.nbListeVehicule()];
		int i = 0; 
        for (String unVehicule : listeVehicule) {
            nomVehicule[i] = unVehicule;
            i++;
        }
        
        //Instanciation de la liste de noms
        this.jcbNomVehicule = new JComboBox<String>();
        this.jcbNomVehicule = new JComboBox<String>(nomVehicule);
        this.jcbNomVehicule.addActionListener(this);
        

        //Ajout des attributs aux panels
        this.panelAjoutVehicule.add(panelMessage, BorderLayout.PAGE_START);
        this.panelAjoutVehicule.add(panelChamps, BorderLayout.CENTER);

        this.panelMessage.add(lblMessage);

        this.panelChamps.add(lblNomVehicule);
        this.panelChamps.add(jcbNomVehicule);
        
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
        this.framePrincipale.getContentPane().add(panelAjoutVehicule);
        this.monPanelGlobal.add(panelAjoutVehicule, BorderLayout.CENTER);
        this.framePrincipale.getContentPane().add(monPanelGlobal);
    }

    //les getter et setter
    public JPanel getMonPanelGlobal() {
        return monPanelGlobal;
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnValider) {
            String nomVehicule = (String)jcbNomVehicule.getSelectedItem();
            int idVehicule = Modele.recupIdVehicule(nomVehicule);
            
            String nomVisiteur = this.jtfPseudo.getText();
            String idVisiteur = Modele.recupIdVisiteur(nomVisiteur);
            
            String dateDebut = jtfDateDebut.getText();
            String dateFin = jtfDateFin.getText();
            float duree = Integer.parseInt(jtfDuree.getText());
            
            boolean rep = Modele.ajoutEmpruntVehicule(idVehicule, dateDebut, dateFin, duree, idVisiteur);
            if (rep) {
            	boolean statut = Modele.majStatutVehicule(idVehicule);
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